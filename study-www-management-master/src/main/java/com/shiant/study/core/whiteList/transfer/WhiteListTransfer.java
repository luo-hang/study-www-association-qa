package com.shiant.study.core.whiteList.transfer;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.shiant.common.exception.ServiceException;
import com.shiant.common.transfer.BaseTransfer;
import com.shiant.study.core.whiteList.model.WhiteList;
import com.shiant.study.core.whiteList.vo.WhiteListVo;


public class WhiteListTransfer implements BaseTransfer<WhiteList,WhiteListVo>{

	@Override
	public WhiteListVo transferEntityToBaseVo(WhiteList entity) throws ServiceException {
		try {
			if (entity == null) {
				return null;
			}
			WhiteListVo vo = new WhiteListVo();
			vo.setWlid(entity.getWlid());
			vo.setWlNo(entity.getWlNo());
			vo.setValidDate(entity.getValidDate());
			vo.setStatus(entity.getStatus());
			vo.setOrgid(entity.getOrgid());
			vo.setOrgName(entity.getOrgName());
			vo.setCommitmentFile(entity.getCommitmentFile());
			vo.setCommitmentStatus(entity.getCommitmentStatus());
			vo.setApplyFile(entity.getApplyFile());
			vo.setApplyStatus(entity.getApplyStatus());
			vo.setInformationFile(entity.getInformationFile());
			vo.setInformationStatus(entity.getInformationStatus());
			vo.setCopyFile(entity.getCopyFile());
			vo.setCopyStatus(entity.getCopyStatus());
			vo.setConventionFile(entity.getConventionFile());
			vo.setConventionStatus(entity.getConventionStatus());
			vo.setVerificationFile(entity.getVerificationFile());
			vo.setVerificationStatus(entity.getVerificationStatus());
			vo.setCreateDate(entity.getCreateDate());
			vo.setCreater(entity.getCreater());
			vo.setUpdateDate(entity.getUpdateDate());
			vo.setUpdater(entity.getUpdater());
			return vo;
		} catch (Exception e) {
			throw new ServiceException("白名单条目基本VO转换失败！", e);
		}
	}

	@Override
	public WhiteListVo transferEntityToFullVo(WhiteList entity) throws ServiceException {
		try {
			return transferEntityToBaseVo(entity);
		} catch (Exception e) {
			throw new ServiceException("白名单条目完整VO转换失败!", e);
		}
	}

	@Override
	public WhiteList transferVoToEntity(WhiteListVo vo) throws ServiceException {
		try {
			if (vo == null) {
				return null;
			}
			WhiteList entity = new WhiteList();
			entity.setWlid(vo.getWlid());
			entity.setWlNo(vo.getWlNo());
			entity.setValidDate(vo.getValidDate());
			entity.setStatus(vo.getStatus());
			entity.setOrgid(vo.getOrgid());
			entity.setOrgName(vo.getOrgName());
			entity.setCommitmentFile(vo.getCommitmentFile());
			entity.setCommitmentStatus(vo.getCommitmentStatus());
			entity.setApplyFile(vo.getApplyFile());
			entity.setApplyStatus(vo.getApplyStatus());
			entity.setInformationFile(vo.getInformationFile());
			entity.setInformationStatus(vo.getInformationStatus());
			entity.setCopyFile(vo.getCopyFile());
			entity.setCopyStatus(vo.getCopyStatus());
			entity.setConventionFile(vo.getConventionFile());
			entity.setConventionStatus(vo.getConventionStatus());
			entity.setVerificationFile(vo.getVerificationFile());
			entity.setVerificationStatus(vo.getVerificationStatus());
			entity.setCreateDate(vo.getCreateDate());
			entity.setCreater(vo.getCreater());
			entity.setUpdateDate(vo.getUpdateDate());
			entity.setUpdater(vo.getUpdater());
			return entity;
		} catch (Exception e) {
			throw new ServiceException("白名单条目转换失败",e);
		}
	}

	@Override
	public Collection<WhiteListVo> transferCollectionEntityToBaseVos(Collection<WhiteList> entitys) throws ServiceException {
		List<WhiteListVo> vos = new ArrayList<WhiteListVo>();
		if (entitys != null) {
			for (WhiteList entity : entitys) {
				vos.add(transferEntityToBaseVo(entity));
			}
		}
		return vos;
	}

	@Override
	public Collection<WhiteListVo> transferCollectionEntityToFullVos(Collection<WhiteList> entitys) throws ServiceException {
		List<WhiteListVo> vos = new ArrayList<WhiteListVo>();
		if(entitys != null){
			for(WhiteList entity : entitys){
				vos.add(transferEntityToFullVo(entity));
			}
		}
		return vos;
	}

	@Override
	public Collection<WhiteList> transferCollectionVoToEntitys(Collection<WhiteListVo> entitys) throws ServiceException {
		List<WhiteList> vos = new ArrayList<>();
		if (entitys != null) {
			for (WhiteListVo entity : entitys) {
				vos.add(transferVoToEntity(entity));
			}
		}
		return vos;
	}

}
