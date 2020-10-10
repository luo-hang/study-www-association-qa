package com.shiant.user.core.transfer;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.shiant.common.exception.ServiceException;
import com.shiant.common.transfer.BaseTransfer;
import com.shiant.rmi.user.vo.RoleRmiVo;
import com.shiant.user.core.model.Role;


public class RoleTransfer implements BaseTransfer<Role,RoleRmiVo>{

	@Override
	public RoleRmiVo transferEntityToBaseVo(Role entity) throws ServiceException {
		try {
			if (entity == null) {
				return null;
			}
			RoleRmiVo vo = new RoleRmiVo();
			vo.setRoleid(entity.getRoleid());
			vo.setRoleName(entity.getRoleName());
			vo.setCreateDate(entity.getCreateDate());
			vo.setCreater(entity.getCreater());
			vo.setUpdateDate(entity.getUpdateDate());
			vo.setUpdater(entity.getUpdater());
			return vo;
		} catch (Exception e) {
			throw new ServiceException("角色基本VO转换失败！", e);
		}
	}

	@Override
	public RoleRmiVo transferEntityToFullVo(Role entity) throws ServiceException {
		try {
			RoleRmiVo vo = transferEntityToBaseVo(entity);
			OrganizationTransfer orgTransfer = new OrganizationTransfer();
			vo.setOrg(orgTransfer.transferEntityToBaseVo(entity.getOrg()));
			return vo;
		} catch (Exception e) {
			throw new ServiceException("角色完整VO转换失败!", e);
		}
	}

	@Override
	public Role transferVoToEntity(RoleRmiVo vo) throws ServiceException {
		try {
			if (vo == null) {
				return null;
			}
			Role entity = new Role();
			entity.setRoleid(vo.getRoleid());
			entity.setRoleName(vo.getRoleName());
			entity.setCreateDate(vo.getCreateDate());
			entity.setCreater(vo.getCreater());
			entity.setUpdateDate(vo.getUpdateDate());
			entity.setUpdater(vo.getUpdater());
			return entity;
		} catch (Exception e) {
			throw new ServiceException("角色转换失败",e);
		}
	}

	@Override
	public Collection<RoleRmiVo> transferCollectionEntityToBaseVos(Collection<Role> entitys) throws ServiceException {
		List<RoleRmiVo> vos = new ArrayList<RoleRmiVo>();
		if (entitys != null) {
			for (Role entity : entitys) {
				vos.add(transferEntityToBaseVo(entity));
			}
		}
		return vos;
	}

	@Override
	public Collection<RoleRmiVo> transferCollectionEntityToFullVos(Collection<Role> entitys) throws ServiceException {
		List<RoleRmiVo> vos = new ArrayList<RoleRmiVo>();
		if(entitys != null){
			for(Role entity : entitys){
				vos.add(transferEntityToFullVo(entity));
			}
		}
		return vos;
	}

	@Override
	public Collection<Role> transferCollectionVoToEntitys(Collection<RoleRmiVo> entitys) throws ServiceException {
		List<Role> vos = new ArrayList<>();
		if (entitys != null) {
			for (RoleRmiVo entity : entitys) {
				vos.add(transferVoToEntity(entity));
			}
		}
		return vos;
	}

}
