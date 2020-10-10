package com.shiant.user.core.transfer;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.shiant.common.exception.ServiceException;
import com.shiant.common.transfer.BaseTransfer;
import com.shiant.rmi.user.vo.UserRmiVo;
import com.shiant.user.core.model.User;

public class UserTransfer implements BaseTransfer<User,UserRmiVo>{

	@Override
	public UserRmiVo transferEntityToBaseVo(User entity) throws ServiceException {
		try {
			if (entity == null) {
				return null;
			}
			UserRmiVo vo = new UserRmiVo();
			vo.setUserid(entity.getUserid());
			vo.setCreateDate(entity.getCreateDate());
			vo.setCreater(entity.getCreater());
			vo.setDelete(entity.isDelete());
			vo.setUpdater(entity.getUpdater());
			vo.setUpdateDate(entity.getUpdateDate());
			if(entity.getOrg()!=null) {
				vo.setOrgid(entity.getOrg().getOrgid());
				vo.setOrgName(entity.getOrg().getOrgName());
				vo.setOrgLogo(entity.getOrg().getOrgLogo());
			}
			vo.setUserName(entity.getUserName());
			return vo;
		} catch (Exception e) {
			throw new ServiceException("用户信息基本VO转换失败！", e);
		}
	}

	@Override
	public UserRmiVo transferEntityToFullVo(User entity) throws ServiceException {
		try {
			UserRmiVo vo = transferEntityToBaseVo(entity);
			vo.setOrgid(entity.getOrg().getOrgid());
			vo.setOrgName(entity.getOrg().getOrgName());
			vo.setOrgLogo(entity.getOrg().getOrgLogo());
			return vo;
		} catch (Exception e) {
			throw new ServiceException("用户信息完整VO转换失败!", e);
		}
	}

	@Override
	public User transferVoToEntity(UserRmiVo vo) throws ServiceException {
		try {
			if (vo == null) {
				return null;
			}
			User entity = new User();
			entity.setUserid(vo.getUserid());
			entity.setCreateDate(vo.getCreateDate());
			entity.setCreater(vo.getCreater());
			entity.setDelete(vo.isDelete());
			entity.setUpdater(vo.getUpdater());
			entity.setUpdateDate(vo.getUpdateDate());
			entity.setUserName(vo.getUserName());
			return entity;
		} catch (Exception e) {
			throw new ServiceException("用户信息转换失败",e);
		}
	}

	@Override
	public Collection<UserRmiVo> transferCollectionEntityToBaseVos(Collection<User> entitys) throws ServiceException {
		List<UserRmiVo> vos = new ArrayList<UserRmiVo>();
		if (entitys != null) {
			for (User entity : entitys) {
				vos.add(transferEntityToBaseVo(entity));
			}
		}
		return vos;
	}
	
	public Collection<UserRmiVo> transferCollectionEntityToVosWithOrg(Collection<User> entitys) throws ServiceException {
		List<UserRmiVo> vos = new ArrayList<UserRmiVo>();
		if (entitys != null) {
			for (User entity : entitys) {
				UserRmiVo vo = transferEntityToBaseVo(entity);
				vo.setOrgid(entity.getOrg().getOrgid());
				vo.setOrgName(entity.getOrg().getOrgName());
				vo.setOrgLogo(entity.getOrg().getOrgLogo());
				vos.add(vo);
			}
		}
		return vos;
	}

	@Override
	public Collection<UserRmiVo> transferCollectionEntityToFullVos(Collection<User> entitys) throws ServiceException {
		List<UserRmiVo> vos = new ArrayList<UserRmiVo>();
		if(entitys != null){
			for(User entity : entitys){
				vos.add(transferEntityToFullVo(entity));
			}
		}
		return vos;
	}

	@Override
	public Collection<User> transferCollectionVoToEntitys(Collection<UserRmiVo> entitys) throws ServiceException {
		List<User> vos = new ArrayList<>();
		if (entitys != null) {
			for (UserRmiVo entity : entitys) {
				vos.add(transferVoToEntity(entity));
			}
		}
		return vos;
	}

}
