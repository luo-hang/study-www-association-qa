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
import com.shiant.common.util.StringUtil;
import com.shiant.rmi.user.vo.ExpertToEnterpriseRmiVo;
import com.shiant.rmi.user.vo.OrganizationRmiVo;
import com.shiant.rmi.user.vo.UserRmiVo;
import com.shiant.user.core.dao.ExpertToEnterpriseDao;
import com.shiant.user.core.dao.ExpertToEnterpriseRepository;
import com.shiant.user.core.model.ExpertToEnterprise;
import com.shiant.user.core.model.Organization;
import com.shiant.user.core.model.User;
import com.shiant.user.core.service.ExpertToEnterpriseService;
import com.shiant.user.core.service.UserService;
import com.shiant.user.core.transfer.ExpertToEnterpriseTransfer;
import com.shiant.user.core.transfer.OrganizationTransfer;

import net.rubyeye.xmemcached.MemcachedClient;

@Service(value = "/expertToEnterpriseService")
public class ExpertToEnterpriseServiceImpl implements ExpertToEnterpriseService {

	@Autowired
	private ExpertToEnterpriseRepository expertToEnterpriseRepository;

	@Autowired
	private ExpertToEnterpriseDao expertToEnterpriseDao;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private MemcachedClient memcachedClient;
	
	public static String e2eKey = "memcache_e2e_";
	
	private static ExpertToEnterpriseTransfer transfer = new ExpertToEnterpriseTransfer();
	private static OrganizationTransfer organizationTransfer = new OrganizationTransfer();
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void addBean(ExpertToEnterpriseRmiVo bean, UserRmiVo user) throws ServiceException {
		try {
//			User entity = transfer.transferVoToEntity(bean);
//			entity.setCreateDate(new Date());
//			entity.setCreater(user.getUserRealName());
//			entity.setUpdateDate(new Date());
//			entity.setUpdater(user.getUserRealName());
//			entity.setDelete(false);
//			
//			Organization org = organizationService.findByid(bean.getOrgid(),user);
//			if(org == null) {
//				throw new ServiceException("未找到相关组织机构信息");
//			}
//			entity.setOrg(org);
//			if(bean.getListOfRole() != null) {
//				for(RoleRmiVo role : bean.getListOfRole()) {
//					Role r = roleService.findByid(role.getRoleid(), user);
//					entity.getListOfRole().add(r);
//				}
//			}
//			userRepository.save(entity);
//			bean.setUserid(entity.getUserid());
//			memcachedClient.delete(userKey+bean.getUserid());
//		} catch (ServiceException e) {
//			if (e.getErrorMsg() ==  null) {
//				e.setErrorMsg("添加用户失败");
//			}
//			throw e;
		} catch (Exception e) {
			throw new ServiceException("添加用户失败", e);
		}
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
	public void updateBean(ExpertToEnterpriseRmiVo vo, UserRmiVo user) throws ServiceException {
		try {
//			User bean = userRepository.findById(vo.getUserid()).orElse(null);
//			if(bean != null) {
//			}else {
//				throw new ServiceException("未找到相关用户信息!");
//			}
//			memcachedClient.delete(userKey+bean.getUserid());
//		}catch(ServiceException e){
//			if(e.getErrorMsg() == null){
//				e.setErrorMsg("更新用户");
//			}
//			throw new ServiceException(e.getErrorMsg(),e);
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
//			userRepository.deleteById(id);
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
	public Map<String, Object> getBeans(int from, int size, Long enterpriseid, UserRmiVo user)
			throws ServiceException {
		try {
			Map<String, Object> maps = new HashMap<String, Object>();
			Sort sort = Sort.by(Direction.DESC, "enterpriseid");
			Pageable pageable = PageRequest.of(from-1, size, sort);
			Page<ExpertToEnterprise> beans = null;
			List<ExpertToEnterpriseRmiVo> vos = null;
			Map<String, Object> hasMaps = memcachedClient.get(e2eKey+enterpriseid);
			if(hasMaps == null) {
				if(user.getUserid().intValue() == 1) {
					if(StringUtil.isBlank(enterpriseid)) {
						beans = expertToEnterpriseRepository.findAll(pageable);
					}else {
						beans = expertToEnterpriseRepository.findByEnterpriseid(enterpriseid,pageable);
					}
					if(beans.getSize()>0) {
						vos = (List<ExpertToEnterpriseRmiVo>) transfer
								.transferCollectionEntityToBaseVos(beans.getContent());
						
						maps.put("beans", vos);
					}else {
						maps.put("beans",new ArrayList<>());
					}
					maps.put("total", beans.getTotalElements());
					maps.put("totalPages", beans.getTotalPages());
				}else {
					vos = expertToEnterpriseDao.getBeansByEnterpriseid(enterpriseid);
					maps.put("beans", vos);
				}
				memcachedClient.add(e2eKey+enterpriseid, TimeToLiveEnums.HALF_HOUR.getDuration(), maps);
			}else {
				maps = hasMaps;
			}
			return maps;
		}catch(Exception e){
			throw new ServiceException("根据条件分页获取用户集合服务失败!",e);
		}
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
	public ExpertToEnterpriseRmiVo getBean(Long id, UserRmiVo user) throws ServiceException {
		try {
//			UserRmiVo u = memcachedClient.get(userKey+id);
//			if(u == null) {
//				User bean = userRepository.findById(id).orElse(null);
//				UserRmiVo vo = transfer.transferEntityToBaseVo(bean);
//				vo.setListOfRole((List<RoleRmiVo>)rtransfer.transferCollectionEntityToBaseVos(bean.getListOfRole()));
//				
//				JSONObject body = new JSONObject();
//				body.put("userId", bean.getUserid());
//				String result = HttpUtil.HttpPostMethod(sso_url+"/webservice/users/getAllUser", null, null, body.toString());
//				JSONObject json = JSONObject.fromObject(result);
//				JSONObject userJson = json.getJSONArray("users").getJSONObject(0);
//				vo.setUserRealName(userJson.getString("realUserName"));
//				vo.setPhone(userJson.getString("phone"));
//				
//				memcachedClient.add(userKey+id, TimeToLiveEnums.SEVEN_DAYS.getDuration(), vo);
//				u = vo;
//			}
//			return u;
		}catch(Exception e){
			throw new ServiceException("根据用户编号获取实体失败!",e);
		}
		return null;
	}

	@Override
	@Transactional(propagation = Propagation.NOT_SUPPORTED,rollbackFor = Exception.class)
	public ExpertToEnterprise findByid(Long id, UserRmiVo user) throws ServiceException {
		return expertToEnterpriseRepository.findById(id).orElse(null);
	}

	@Override
	@Transactional(propagation = Propagation.NOT_SUPPORTED,rollbackFor = Exception.class)
	public Map<String, Object> getBindBeans(int from, int size, Long enterpriseid, UserRmiVo user)
			throws ServiceException {
		try {
			Map<String, Object> maps = new HashMap<String, Object>();
			List<Organization> beans = expertToEnterpriseDao.getBindBeans((from-1)*size,size,enterpriseid);
			Long count = expertToEnterpriseDao.countBindBeans(enterpriseid);
			List<OrganizationRmiVo> vos = (List<OrganizationRmiVo>) organizationTransfer
					.transferCollectionEntityToBaseVos(beans);
			
			maps.put("beans", vos);
			maps.put("total", count);
			return maps;
		} catch (Exception e) {
			throw new ServiceException("获取已绑定专家对应企业失败",e);
		}
		
	}

	@Override
	@Transactional(propagation = Propagation.NOT_SUPPORTED,rollbackFor = Exception.class)
	public Map<String, Object> getUnbindBeans(int from, int size, Long enterpriseid, String orgName, UserRmiVo user)
			throws ServiceException {
		try {
			Map<String, Object> maps = new HashMap<String, Object>();
			List<Organization> beans = expertToEnterpriseDao.getUnbindBeans((from-1)*size,size,enterpriseid,orgName);
			Long count = expertToEnterpriseDao.countUnbindBeans(enterpriseid,orgName);
			List<OrganizationRmiVo> vos = (List<OrganizationRmiVo>) organizationTransfer
					.transferCollectionEntityToBaseVos(beans);
			
			maps.put("beans", vos);
			maps.put("total", count);
			return maps;
		} catch (Exception e) {
			throw new ServiceException("获取未绑定专家对应企业失败",e);
		}
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
	public void bind(Long orgid, Long bindid, UserRmiVo user) throws ServiceException {
		try {
			List<Long> roleids = new ArrayList<Long>();
			roleids.add(3L);
			List<User> users = userService.getBeanByOrgidAndRoleid(bindid, roleids, user);
			List<ExpertToEnterprise> beans = new ArrayList<>();
			if(users.isEmpty()){
				throw new ServiceException("当前企业没有老师");
			}
			for(User u : users) {
				ExpertToEnterprise bean = new ExpertToEnterprise();
				bean.setCreateDate(new Date());
				bean.setCreater(user.getUserRealName());
				bean.setUpdateDate(new Date());
				bean.setUpdater(user.getUserRealName());
				bean.setEnterpriseid(orgid);
				bean.setExpertid(u.getUserid());
				beans.add(bean);
			}
			expertToEnterpriseRepository.saveAll(beans);
			memcachedClient.delete(e2eKey+orgid);
		} catch (Exception e) {
			throw new ServiceException("绑定企业与专家关系失败",e);
		}
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
	public void unbind(Long orgid, Long unbindid, UserRmiVo user) throws ServiceException {
		try {
			List<Long> roleids = new ArrayList<Long>();
			roleids.add(3L);
			List<User> users = userService.getBeanByOrgidAndRoleid(unbindid, roleids, user);
			for(User u : users) {
				expertToEnterpriseRepository.deleteByExpertidAndEnterpriseid(u.getUserid(),orgid);
			}
			memcachedClient.delete(e2eKey+orgid);
		} catch (Exception e) {
			throw new ServiceException("解绑企业与专家关系失败",e);
		}
	}

}
