package com.shiant.user.core.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.shiant.common.enums.TimeToLiveEnums;
import com.shiant.common.exception.ServiceException;
import com.shiant.common.util.HttpUtil;
import com.shiant.common.util.StringUtil;
import com.shiant.rmi.user.vo.OrganizationRmiVo;
import com.shiant.rmi.user.vo.RoleRmiVo;
import com.shiant.rmi.user.vo.UserRmiVo;
import com.shiant.user.core.dao.UserRepository;
import com.shiant.user.core.model.Organization;
import com.shiant.user.core.model.Role;
import com.shiant.user.core.model.User;
import com.shiant.user.core.service.OrganizationService;
import com.shiant.user.core.service.RoleService;
import com.shiant.user.core.service.UserService;
import com.shiant.user.core.transfer.RoleTransfer;
import com.shiant.user.core.transfer.UserTransfer;

import net.sf.json.JSONArray;
import net.rubyeye.xmemcached.MemcachedClient;
import net.sf.json.JSONObject;

@Service(value = "/userService")
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private OrganizationService organizationService;
	
	@Autowired
	private RoleService roleService;
	
	@Autowired
	private MemcachedClient memcachedClient;
	
	public static String userKey = "memcache_user_";
	
	private String sso_url = "http://sso.shanhaiyh.com";
	
	private static UserTransfer transfer = new UserTransfer();
	
	private static RoleTransfer rtransfer = new RoleTransfer();
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void addBean(UserRmiVo bean, UserRmiVo user) throws ServiceException {
		try {
			JSONObject body = new JSONObject();
			body.put("userName", bean.getUserName());
			body.put("phone", bean.getPhone());
			String result = HttpUtil.HttpPostMethod(sso_url+"/webservice/users/val", null, null, body.toString());
			
			JSONObject json = JSONObject.fromObject(result);
			if(json.getBoolean("status")) {
				body = new JSONObject();
				body.put("status", 1);
				body.put("userName", bean.getUserName());
				body.put("phone", bean.getPhone());
				body.put("email", bean.getEmail());
				body.put("password", bean.getUserPwd());
				body.put("realUserName", bean.getUserRealName());
				body.put("company", bean.getOrgName());
				
				result = HttpUtil.HttpPostMethod(sso_url+"/webservice/users/insertUser", null, null, body.toString());
				json = JSONObject.fromObject(result);
				if(!json.getBoolean("status")) {
					throw new ServiceException("SSO创建用户失败");
				}
				bean.setUserid(json.getLong("userId"));
			}else {
				result = HttpUtil.HttpPostMethod(sso_url+"/webservice/users/getAllUser", null, null, body.toString());
				json = JSONObject.fromObject(result);
				bean.setUserid(json.getJSONArray("users")
						.getJSONObject(0).getLong("userId"));
				
			}
			User u = userRepository.findById(bean.getUserid()).orElse(null);
			if(u != null) {
				throw new ServiceException("当前用户已经创建");
			}
			u = userRepository.findByUserName(bean.getUserName());
			if(u != null) {
				throw new ServiceException("当前用户已经存在");
			}
			
			User entity = transfer.transferVoToEntity(bean);
			entity.setCreateDate(new Date());
			entity.setCreater(user.getUserRealName());
			entity.setUpdateDate(new Date());
			entity.setUpdater(user.getUserRealName());
			entity.setDelete(false);
			
			if(bean.getListOfRole() != null) {
				for(RoleRmiVo role : bean.getListOfRole()) {
					Role r = roleService.findByid(role.getRoleid(), user);
					entity.getListOfRole().add(r);
				}
			}
			
			//创建企业用户
			if(StringUtil.isBlank(bean.getOrgid())&&StringUtil.isNotBlank(bean.getOrgName())) {
				Organization org = organizationService.findByName(bean.getOrgName(), user);
				if(org != null) {
					throw new ServiceException("组织机构重复");
				}
				OrganizationRmiVo o = new OrganizationRmiVo();
				o.setOrgName(bean.getOrgName());
				org = organizationService.addBean(o, user);
				entity.setOrg(org);
				userRepository.save(entity);
				o.setOrgid(org.getOrgid());
				o.setLegalPerson(bean.getUserRealName());
				o.setLegalPersonPhone(bean.getPhone());
				organizationService.updateBean(o, user);
			}else {
				if(StringUtil.isNotBlank(bean.getOrgid())) {
					Organization org = organizationService.findByid(bean.getOrgid(),user);
					if(org == null) {
						throw new ServiceException("未找到相关组织机构信息");
					}
					entity.setOrg(org);
					userRepository.save(entity);
					bean.setUserid(entity.getUserid());
				}
			}
			
			memcachedClient.delete(userKey+bean.getUserid());
		} catch (ServiceException e) {
			if (e.getErrorMsg() ==  null) {
				e.setErrorMsg("添加用户失败");
			}
			throw e;
		} catch (Exception e) {
			throw new ServiceException("添加用户失败", e);
		}
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
	public void updateBean(UserRmiVo vo, UserRmiVo user) throws ServiceException {
		try {
			User bean = userRepository.findById(vo.getUserid()).orElse(null);
			if(bean != null) {
				
				JSONObject body = new JSONObject();
				body.put("userId", bean.getUserid());
				body.put("realUserName", vo.getUserRealName());
				if(vo.isDelete()) {
					
				}
//				body.put("status", !vo.isDelete());
				body.put("phone", vo.getPhone());
				String result = HttpUtil.HttpPostMethod(sso_url+"/webservice/users/updateUser", null, null, body.toString());
				
				JSONObject json = JSONObject.fromObject(result);
				if(!json.getBoolean("status")) {
					throw new ServiceException("更新用户失败");
				}
				
				bean.setUpdateDate(new Date());
				bean.setUpdater(user.getUserRealName());
				bean.setDelete(user.isDelete());
				
				Organization org = organizationService.findByid(vo.getOrgid(),user);
				if(org == null) {
					throw new ServiceException("未找到相关组织机构信息!");
				}
				bean.setOrg(org);
				if(vo.getListOfRole() != null) {
					bean.getListOfRole().clear();
					for(RoleRmiVo role : vo.getListOfRole()) {
						Role r = roleService.findByid(role.getRoleid(), user);
						bean.getListOfRole().add(r);
					}
					userRepository.save(bean);
				}
			}else {
				throw new ServiceException("未找到相关用户信息!");
			}
			memcachedClient.delete(userKey+bean.getUserid());
		}catch(ServiceException e){
			if(e.getErrorMsg() == null){
				e.setErrorMsg("更新用户");
			}
			throw new ServiceException(e.getErrorMsg(),e);
		}catch(Exception e){
			throw new ServiceException("更新用户失败",e);
		}
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
	public void deleteBean(Long id,UserRmiVo user) throws ServiceException {
		try {
//			JSONObject body = new JSONObject();
//			String result = HttpUtil.HttpPostMethod(sso_url+"/webservice/users/deletUser/"+id, null, null, null);
//			
//			JSONObject json = JSONObject.fromObject(result);
//			if(!json.getBoolean("status")) {
//				throw new ServiceException("删除用户失败");
//			}
//			User bean = userRepository.findById(id).orElse(null);
//			bean.setDelete(true);
//			bean.setUpdater(user.getUserRealName());
//			bean.setUpdateDate(new Date());
			userRepository.deleteById(id);
			memcachedClient.delete(userKey+id);
//		} catch (ServiceException e) {
//			if (e.getErrorMsg() == null) {
//				e.setErrorMsg("删除用户数据操作失败!");
//			}
//			throw new ServiceException(e.getErrorMsg(),e);
		} catch (Exception e) {
			throw new ServiceException("删除用户失败",e);
		}
	}

	@Override
	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public Map<String, Object> getBeans(int from,int size,String userName,String phone, Long roleid, UserRmiVo user) throws ServiceException {
		try {
			Map<String, Object> maps = new HashMap<String, Object>();
			Sort sort = Sort.by(Direction.DESC, "createDate");
			Pageable pageable = PageRequest.of(from-1, size, sort);
			Page<User> beans = null;
			if(user.getUserid().intValue() == 1) {
//				String result = HttpUtil.HttpPostMethod(URL, null, null, body);
				if(StringUtil.isBlank(userName)&&StringUtil.isBlank(phone)&&StringUtil.isBlank(roleid)) {
					beans = userRepository.findAll(pageable);
				}else {
//					if(StringUtil.isNotBlank(roleid)) {
//						beans = userRepository.findByUseridIn(userid,pageable);
//					}
					
					JSONObject body = new JSONObject();
					if(StringUtil.isNotBlank(userName)) {
						body.put("userName", userName);
					}
					if(StringUtil.isNotBlank(phone)) {
						body.put("phone", phone);
					}
					body.put("page", from);
					body.put("pageSize", size);
					
					String result = HttpUtil.HttpPostMethod(sso_url+"/webservice/users/getAllUser", null, null, body.toString());
					JSONObject json = JSONObject.fromObject(result);
					JSONArray userJsons = json.getJSONArray("users");
					List<Long> userids = new ArrayList<>();
					for(int i=0;i<userJsons.size();i++) {
						userids.add(userJsons.getJSONObject(i).getLong("userId"));
					}
					
					List<User> users = userRepository.findByUseridIn(userids);
					List<UserRmiVo> vos = (List<UserRmiVo>) transfer
							.transferCollectionEntityToVosWithOrg(users);
					for(UserRmiVo vo : vos) {
						for(int i=0;i<userJsons.size();i++) {
							JSONObject j = userJsons.getJSONObject(i);
							if(j.getLong("userId") == vo.getUserid().longValue()) {
								vo.setPhone(j.getString("phone"));
								vo.setUserRealName(j.getString("realUserName"));
							}
						}
					}
					maps.put("beans",vos);
//					maps.put("total", beans.getTotalElements());
//					maps.put("totalPages", beans.getTotalPages());
					return maps;
				}
			}else {
				
			}
			if(beans.getSize()>0) {
				List<UserRmiVo> vos = (List<UserRmiVo>) transfer
						.transferCollectionEntityToVosWithOrg(beans.getContent());
				
				String useridStr = "";
				Map<Long,UserRmiVo> map2user = new HashMap<>();
				for(UserRmiVo vo : vos) {
					useridStr = useridStr+vo.getUserid()+",";
					map2user.put(vo.getUserid(), vo);
				}
				
				JSONObject body = new JSONObject();
				body.put("ids", useridStr.substring(0, useridStr.length()-1));
				String result = HttpUtil.HttpPostMethod(sso_url+"/webservice/users/getAllUser", null, null, body.toString());
				JSONObject json = JSONObject.fromObject(result);
				JSONArray userJsons = json.getJSONArray("users");
				for(int i=0;i<userJsons.size();i++) {
					JSONObject j = userJsons.getJSONObject(i);
					UserRmiVo vo =  map2user.get(j.getLong("userId"));
					if(j.containsKey("phone")) {
						vo.setPhone(j.getString("phone"));
					}
					if(j.containsKey("realUserName")) {
						vo.setUserRealName(j.getString("realUserName"));
					}
				}
				maps.put("beans", vos);
			}else {
				maps.put("beans",new ArrayList<>());
			}
			maps.put("total", beans.getTotalElements());
			maps.put("totalPages", beans.getTotalPages());
			return maps;
		}catch(Exception e){
			throw new ServiceException("根据条件分页获取用户集合服务失败!",e);
		}
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
	public UserRmiVo getBean(Long id, UserRmiVo user) throws ServiceException {
		try {
			UserRmiVo u = memcachedClient.get(userKey+id);
			if(u == null) {
				User bean = userRepository.findById(id).orElse(null);
				if(bean == null) {
					bean = new User();
					bean.setUserid(id);
				}
				UserRmiVo vo = transfer.transferEntityToBaseVo(bean);
				vo.setListOfRole((List<RoleRmiVo>)rtransfer.transferCollectionEntityToBaseVos(bean.getListOfRole()));
				
				JSONObject body = new JSONObject();
				body.put("userId", bean.getUserid());
				String result = HttpUtil.HttpPostMethod(sso_url+"/webservice/users/getAllUser", null, null, body.toString());
				JSONObject json = JSONObject.fromObject(result);
				JSONObject userJson = json.getJSONArray("users").getJSONObject(0);
				vo.setUserName(userJson.getString("userName"));
				vo.setUserRealName(userJson.getString("realUserName"));
				if(vo.getUserRealName().equals("null")) {
					vo.setUserRealName(vo.getUserName());
				}
				vo.setPhone(userJson.getString("phone"));
				if(vo.getPhone().equals("null")) {
					vo.setPhone("");
				}
				vo.setEmail(userJson.getString("email"));
				if(vo.getEmail().equals("null")) {
					vo.setEmail("");
				}
				
				memcachedClient.add(userKey+id, TimeToLiveEnums.SEVEN_DAYS.getDuration(), vo);
				u = vo;
			}
			return u;
		}catch(Exception e){
			throw new ServiceException("根据用户编号获取实体失败!",e);
		}
	}

	@Override
	@Transactional(propagation = Propagation.NOT_SUPPORTED,rollbackFor = Exception.class)
	public User findByid(Long id, UserRmiVo user) throws ServiceException {
		return userRepository.findById(id).orElse(null);
	}

	@Override
	public List<User> getBeanByOrgidAndRoleid(Long orgid, List<Long> roleids, UserRmiVo user) throws ServiceException {
		return userRepository.findByOrgOrgidAndListOfRoleRoleidIn(orgid,roleids);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
	public void resetPassword(UserRmiVo bean) throws ServiceException {
		try {
			JSONObject body = new JSONObject();
			body.put("phone", bean.getPhone());
			String result = HttpUtil.HttpPostMethod(sso_url+"/webservice/users/getAllUser", null, null, body.toString());
			JSONObject json = JSONObject.fromObject(result);
			JSONObject userJson = json.getJSONArray("users").getJSONObject(0);
			
			body = new JSONObject();
			body.put("userId", userJson.getLong("userId"));
			body.put("password", bean.getUserPwd());
			result = HttpUtil.HttpPostMethod(sso_url+"/webservice/users/updateUser", null, null, body.toString());
			
			json = JSONObject.fromObject(result);
			if(!json.getBoolean("status")) {
				throw new ServiceException("重置密码失败");
			}
		}catch(ServiceException e){
			if(e.getErrorMsg() == null){
				e.setErrorMsg("重置密码失败");
			}
			throw new ServiceException(e.getErrorMsg(),e);
		}catch(Exception e){
			throw new ServiceException("重置密码失败",e);
		}
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
	public UserRmiVo getBeanWithAdd(UserRmiVo bean, UserRmiVo user) throws ServiceException {
		try {
			Long userid = memcachedClient.get(userKey+bean.getUserName());
			if(userid == null) {
				JSONObject body = new JSONObject();
				body.put("userName", bean.getUserName());
				String result = HttpUtil.HttpPostMethod(sso_url+"/webservice/users/getAllUser", null, null, body.toString());
				JSONObject json = JSONObject.fromObject(result);
				int totalCount = json.getInt("totalCount");
				
				if(totalCount == 0) {
					if(StringUtil.isNotBlank(bean.getPhone())) {
						body = new JSONObject();
						body.put("phone", bean.getPhone());
						result = HttpUtil.HttpPostMethod(sso_url+"/webservice/users/val", null, null, body.toString());
						json = JSONObject.fromObject(result);
						if(!json.getBoolean("status")) {
							throw new ServiceException("用户手机号码已存在");
						}
					}
					
					body = new JSONObject();
					body.put("status", 1);
					body.put("userName", bean.getUserName());
					body.put("phone", bean.getPhone());
					body.put("email", bean.getEmail());
					body.put("password", "shiant!2020");
					body.put("realUserName", bean.getUserRealName());
					
					result = HttpUtil.HttpPostMethod(sso_url+"/webservice/users/insertUser", null, null, body.toString());
					json = JSONObject.fromObject(result);
					if(!json.getBoolean("status")) {
						throw new ServiceException("SSO创建用户失败");
					}
					bean.setUserid(json.getLong("userId"));
					
					User entity = transfer.transferVoToEntity(bean);
					entity.setCreateDate(new Date());
					entity.setCreater(user.getUserRealName());
					entity.setUpdateDate(new Date());
					entity.setUpdater(user.getUserRealName());
					entity.setDelete(false);
					Organization org = organizationService.findByid(bean.getOrgid(),user);
					if(org == null) {
						throw new ServiceException("未找到相关组织机构信息");
					}
					entity.setOrg(org);
					
					userRepository.save(entity);
					userid = entity.getUserid();
				}else {
					JSONObject userJson = json.getJSONArray("users").getJSONObject(0);
					userid = userJson.getLong("userId");
					User qs_user = userRepository.findById(userid).orElse(null);
					if(qs_user == null) {
						User entity = transfer.transferVoToEntity(bean);
						entity.setCreateDate(new Date());
						entity.setCreater(user.getUserRealName());
						entity.setUpdateDate(new Date());
						entity.setUpdater(user.getUserRealName());
						entity.setDelete(false);
						entity.setUserid(userid);
						Organization org = organizationService.findByid(bean.getOrgid(),user);
						if(org == null) {
							throw new ServiceException("未找到相关组织机构信息");
						}
						entity.setOrg(org);
						userRepository.save(entity);
					}
				}
				memcachedClient.add(userKey+bean.getUserName(), TimeToLiveEnums.SEVEN_DAYS.getDuration(), userid);
			}
			return this.getBean(userid, user);
		}catch(ServiceException e){
			if(e.getErrorMsg() == null){
				e.setErrorMsg("查询并注册账号失败");
			}
			throw new ServiceException(e.getErrorMsg(),e);
		}catch(Exception e){
			throw new ServiceException("查询并注册账号失败",e);
		}
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
	public UserRmiVo getHasBeanByUserName(String userName, UserRmiVo user) throws ServiceException {
		try {
			Long userid = memcachedClient.get(userKey+userName);
			UserRmiVo uservo = null;
			if(userid == null) {
				JSONObject body = new JSONObject();
				body.put("userName", userName);
				String result = HttpUtil.HttpPostMethod(sso_url+"/webservice/users/getAllUser", null, null, body.toString());
				JSONObject json = JSONObject.fromObject(result);
				int totalCount = json.getInt("totalCount");
				if(totalCount == 0) {
					return uservo;
				}
				JSONObject userJson = json.getJSONArray("users").getJSONObject(0);
				userid = userJson.getLong("userId");
				
				memcachedClient.add(userKey+userName, TimeToLiveEnums.SEVEN_DAYS.getDuration(), userid);
				uservo = this.getBean(userid, user);
			}else {
				uservo = this.getBean(userid, user);
			}
			return uservo;
		}catch(ServiceException e){
			if(e.getErrorMsg() == null){
				e.setErrorMsg("根据用户账号获取已注册的用户失败");
			}
			throw new ServiceException(e.getErrorMsg(),e);
		}catch(Exception e){
			throw new ServiceException("根据用户账号获取已注册的用户失败",e);
		}
	}
}
