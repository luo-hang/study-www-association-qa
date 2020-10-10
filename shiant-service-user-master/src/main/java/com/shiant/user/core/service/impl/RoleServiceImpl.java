package com.shiant.user.core.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.shiant.common.exception.ServiceException;
import com.shiant.rmi.user.vo.RoleRmiVo;
import com.shiant.rmi.user.vo.UserRmiVo;
import com.shiant.user.core.dao.RoleRepository;
import com.shiant.user.core.model.Organization;
import com.shiant.user.core.model.Role;
import com.shiant.user.core.service.OrganizationService;
import com.shiant.user.core.service.RoleService;
import com.shiant.user.core.transfer.RoleTransfer;


@Service(value = "/roleService")
public class RoleServiceImpl implements RoleService {

	@Autowired
	private RoleRepository roleRepository;

	@Autowired
	private OrganizationService organizationService;
	
	private static RoleTransfer transfer = new RoleTransfer();
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void addBean(RoleRmiVo bean,UserRmiVo user) throws ServiceException {
		try {
			Role entity = transfer.transferVoToEntity(bean);
			entity.setRoleid(null);
			entity.setCreateDate(new Date());
			entity.setCreater(user.getUserRealName());
			entity.setUpdateDate(new Date());
			entity.setUpdater(user.getUserRealName());
			
			Organization org = organizationService.findByid(user.getOrgid(),user);
			if(org == null) {
				throw new ServiceException("未找到相关角色信息!");
			}
			roleRepository.save(entity);
			bean.setRoleid(entity.getRoleid());
		} catch (ServiceException e) {
			if (e.getErrorMsg() ==  null) {
				e.setErrorMsg("添加角色步骤失败!");
			}
			throw e;
		} catch (Exception e) {
			throw new ServiceException("添加角色失败!", e);
		}
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
	public void updateBean(RoleRmiVo vo, UserRmiVo user) throws ServiceException {
		try {
			Role bean = roleRepository.findById(vo.getRoleid()).orElse(null);
			if(bean != null) {
				bean.setUpdateDate(new Date());
				bean.setUpdater(user.getUserRealName());
				bean.setRoleName(vo.getRoleName());
				
			}else {
				throw new ServiceException("未找到相关角色信息!");
			}
		}catch(ServiceException e){
			if(e.getErrorMsg() == null){
				e.setErrorMsg("更新角色步骤");
			}
			throw new ServiceException(e.getErrorMsg(),e);
		}catch(Exception e){
			throw new ServiceException("更新角色步骤失败!",e);
		}
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
	public void deleteBean(Long id,UserRmiVo user) throws ServiceException {
		try {
			roleRepository.deleteById(id);
//			Role bean = roleRepository.findById(id).orElse(null);
//			bean.setDelete(true);
//			bean.setUpdater(user.getUserRealName());
//			bean.setUpdateDate(new Date());
		} catch (Exception e) {
			throw new ServiceException("删除角色失败!",e);
		}
	}

	@Override
	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public Map<String, Object> getBeans(int from,int size,String condition,UserRmiVo user) throws ServiceException {
		try {
			Map<String, Object> maps = new HashMap<String, Object>();
			List<Object> params = new ArrayList<>();
			params.add(user.getOrgName());
			params.add(false);
//			String condition = "";
//			if(isCarousel) {
//				params.add("轮播");
//				condition = " AND e.domain = ?1 AND e.deleteFlag = ?2 AND e.type = ?3 ORDER BY e.order ";
//			}else {
//				condition = " AND e.domain = ?1 AND e.deleteFlag = ?2 ORDER BY e.order ";
//			}
//			List<Role> beans = roleRepository.findEntitys(from-1, size, condition, params);
//			long count = roleRepository.count(" WHERE domain = '"+condition+"' ");
//			List<RoleVo> vos = (List<RoleVo>) transfer.transferCollectionEntityToBaseVos(beans);
//			maps.put("beans", vos);
			return maps;
//		}catch(ServiceException e){
//			if(e.getErrorMsg() == null){
//				e.setErrorMsg("根据条件分页获取角色集合");
//			}
//			throw new ServiceException(e.getErrorMsg(),e);
		}catch(Exception e){
			throw new ServiceException("根据条件分页获取角色集合失败!",e);
		}
	}
	
	@Override
	@Transactional(propagation = Propagation.NOT_SUPPORTED,rollbackFor = Exception.class)
	public RoleRmiVo getBean(Long id, UserRmiVo user) throws ServiceException {
		try {
			return transfer.transferEntityToBaseVo(roleRepository.findById(id).orElse(null));
		}catch(Exception e){
			throw new ServiceException("根据角色编号获取实体失败!",e);
		}
	}

	@Override
	@Transactional(propagation = Propagation.NOT_SUPPORTED,rollbackFor = Exception.class)
	public Role findByid(Long id, UserRmiVo user) throws ServiceException {
		return roleRepository.findById(id).orElse(null);
	}

}
