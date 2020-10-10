package com.shiant.user.core.transfer;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.shiant.common.exception.ServiceException;
import com.shiant.common.transfer.BaseTransfer;
import com.shiant.rmi.user.vo.ExpertToEnterpriseRmiVo;
import com.shiant.user.core.model.ExpertToEnterprise;


public class ExpertToEnterpriseTransfer implements BaseTransfer<ExpertToEnterprise,ExpertToEnterpriseRmiVo>{

	@Override
	public ExpertToEnterpriseRmiVo transferEntityToBaseVo(ExpertToEnterprise entity) throws ServiceException {
		try {
			if (entity == null) {
				return null;
			}
			ExpertToEnterpriseRmiVo vo = new ExpertToEnterpriseRmiVo();
			vo.setE2eid(entity.getE2eid());
			vo.setEnterpriseid(entity.getEnterpriseid());
			vo.setExpertid(entity.getExpertid());
			vo.setCreateDate(entity.getCreateDate());
			vo.setCreater(entity.getCreater());
			vo.setUpdateDate(entity.getUpdateDate());
			vo.setUpdater(entity.getUpdater());
			return vo;
		} catch (Exception e) {
			throw new ServiceException("专家对应企业基本VO转换失败！", e);
		}
	}

	@Override
	public ExpertToEnterpriseRmiVo transferEntityToFullVo(ExpertToEnterprise entity) throws ServiceException {
		try {
			return transferEntityToBaseVo(entity);
		} catch (Exception e) {
			throw new ServiceException("专家对应企业完整VO转换失败!", e);
		}
	}

	@Override
	public ExpertToEnterprise transferVoToEntity(ExpertToEnterpriseRmiVo vo) throws ServiceException {
		try {
			if (vo == null) {
				return null;
			}
			ExpertToEnterprise entity = new ExpertToEnterprise();
			entity.setCreateDate(vo.getCreateDate());
			entity.setCreater(vo.getCreater());
			entity.setUpdater(vo.getUpdater());
			entity.setUpdateDate(vo.getUpdateDate());
			entity.setE2eid(vo.getE2eid());
			entity.setEnterpriseid(vo.getEnterpriseid());
			entity.setExpertid(vo.getExpertid());
			return entity;
		} catch (Exception e) {
			throw new ServiceException("专家对应企业转换失败",e);
		}
	}

	@Override
	public Collection<ExpertToEnterpriseRmiVo> transferCollectionEntityToBaseVos(Collection<ExpertToEnterprise> entitys) throws ServiceException {
		List<ExpertToEnterpriseRmiVo> vos = new ArrayList<ExpertToEnterpriseRmiVo>();
		if (entitys != null) {
			for (ExpertToEnterprise entity : entitys) {
				vos.add(transferEntityToBaseVo(entity));
			}
		}
		return vos;
	}

	@Override
	public Collection<ExpertToEnterpriseRmiVo> transferCollectionEntityToFullVos(Collection<ExpertToEnterprise> entitys) throws ServiceException {
		List<ExpertToEnterpriseRmiVo> vos = new ArrayList<ExpertToEnterpriseRmiVo>();
		if(entitys != null){
			for(ExpertToEnterprise entity : entitys){
				vos.add(transferEntityToFullVo(entity));
			}
		}
		return vos;
	}

	@Override
	public Collection<ExpertToEnterprise> transferCollectionVoToEntitys(Collection<ExpertToEnterpriseRmiVo> entitys) throws ServiceException {
		List<ExpertToEnterprise> vos = new ArrayList<>();
		if (entitys != null) {
			for (ExpertToEnterpriseRmiVo entity : entitys) {
				vos.add(transferVoToEntity(entity));
			}
		}
		return vos;
	}

}
