package com.shiant.study.core.legal.transfer;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.shiant.common.exception.ServiceException;
import com.shiant.common.transfer.BaseTransfer;
import com.shiant.study.core.legal.model.Complaint;
import com.shiant.study.core.legal.vo.ComplaintVo;

public class ComplaintTransfer implements BaseTransfer<Complaint,ComplaintVo>{

	@Override
	public ComplaintVo transferEntityToBaseVo(Complaint entity) throws ServiceException {
		try {
			if (entity == null) {
				return null;
			}
			ComplaintVo vo = new ComplaintVo();
			vo.setCid(entity.getCid());
			vo.setOrgName(entity.getOrgName());
			vo.setType(entity.getType());
			vo.setTitle(entity.getTitle());
			vo.setContent(entity.getContent());
			vo.setOrgid(entity.getOrgid());
			vo.setReason(entity.getReason());
			vo.setImageFile1(entity.getImageFile1());
			vo.setImageFile2(entity.getImageFile2());
			vo.setImageFile3(entity.getImageFile3());
			vo.setImageFile4(entity.getImageFile4());
			vo.setImageFile5(entity.getImageFile5());
			vo.setImageFile6(entity.getImageFile6());
			vo.setImageFile7(entity.getImageFile7());
			vo.setImageFile8(entity.getImageFile8());
			vo.setImageFile9(entity.getImageFile9());
			vo.setImageFile10(entity.getImageFile10());
			vo.setVideoFile1(entity.getVideoFile1());
			vo.setVideoFile2(entity.getVideoFile2());
			vo.setVideoFile3(entity.getVideoFile3());
			vo.setVideoFile4(entity.getVideoFile4());
			vo.setVideoFile5(entity.getVideoFile5());
			vo.setStatus(entity.getStatus());
			vo.setNeed(entity.getNeed());
			vo.setCreateDate(entity.getCreateDate());
			vo.setCreater(entity.getCreater());
			vo.setCreaterid(entity.getCreaterid());
			vo.setCreaterType(entity.getCreaterType());
			vo.setUpdateDate(entity.getUpdateDate());
			vo.setUpdater(entity.getUpdater());
			return vo;
		} catch (Exception e) {
			throw new ServiceException("投诉基本VO转换失败！", e);
		}
	}

	@Override
	public ComplaintVo transferEntityToFullVo(Complaint entity) throws ServiceException {
		try {
			return transferEntityToBaseVo(entity);
		} catch (Exception e) {
			throw new ServiceException("投诉完整VO转换失败!", e);
		}
	}

	@Override
	public Complaint transferVoToEntity(ComplaintVo vo) throws ServiceException {
		try {
			if (vo == null) {
				return null;
			}
			Complaint entity = new Complaint();
			entity.setCid(vo.getCid());
			entity.setOrgName(vo.getOrgName());
			entity.setType(vo.getType());
			entity.setTitle(vo.getTitle());
			entity.setContent(vo.getContent());
			entity.setOrgid(vo.getOrgid());
			entity.setReason(vo.getReason());
			entity.setImageFile1(vo.getImageFile1());
			entity.setImageFile2(vo.getImageFile2());
			entity.setImageFile3(vo.getImageFile3());
			entity.setImageFile4(vo.getImageFile4());
			entity.setImageFile5(vo.getImageFile5());
			entity.setImageFile6(vo.getImageFile6());
			entity.setImageFile7(vo.getImageFile7());
			entity.setImageFile8(vo.getImageFile8());
			entity.setImageFile9(vo.getImageFile9());
			entity.setImageFile10(vo.getImageFile10());
			entity.setVideoFile1(vo.getVideoFile1());
			entity.setVideoFile2(vo.getVideoFile2());
			entity.setVideoFile3(vo.getVideoFile3());
			entity.setVideoFile4(vo.getVideoFile4());
			entity.setVideoFile5(vo.getVideoFile5());
			entity.setStatus(vo.getStatus());
			entity.setNeed(vo.getNeed());
			entity.setCreateDate(vo.getCreateDate());
			entity.setCreater(vo.getCreater());
			entity.setCreaterid(vo.getCreaterid());
			entity.setCreaterType(vo.getCreaterType());
			entity.setUpdateDate(vo.getUpdateDate());
			entity.setUpdater(vo.getUpdater());
			return entity;
		} catch (Exception e) {
			throw new ServiceException("投诉转换失败",e);
		}
	}

	@Override
	public Collection<ComplaintVo> transferCollectionEntityToBaseVos(Collection<Complaint> entitys) throws ServiceException {
		List<ComplaintVo> vos = new ArrayList<ComplaintVo>();
		if (entitys != null) {
			for (Complaint entity : entitys) {
				vos.add(transferEntityToBaseVo(entity));
			}
		}
		return vos;
	}

	@Override
	public Collection<ComplaintVo> transferCollectionEntityToFullVos(Collection<Complaint> entitys) throws ServiceException {
		List<ComplaintVo> vos = new ArrayList<ComplaintVo>();
		if(entitys != null){
			for(Complaint entity : entitys){
				vos.add(transferEntityToFullVo(entity));
			}
		}
		return vos;
	}

	@Override
	public Collection<Complaint> transferCollectionVoToEntitys(Collection<ComplaintVo> entitys) throws ServiceException {
		List<Complaint> vos = new ArrayList<>();
		if (entitys != null) {
			for (ComplaintVo entity : entitys) {
				vos.add(transferVoToEntity(entity));
			}
		}
		return vos;
	}

}
