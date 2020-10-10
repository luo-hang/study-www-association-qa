package com.shiant.study.core.demo.transfer;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.shiant.common.exception.ServiceException;
import com.shiant.common.transfer.BaseTransfer;
import com.shiant.study.core.demo.model.Case;
import com.shiant.study.core.demo.vo.CaseVo;

public class CaseTransfer implements BaseTransfer<Case,CaseVo>{

	@Override
	public CaseVo transferEntityToBaseVo(Case entity) throws ServiceException {
		try {
			if (entity == null) {
				return null;
			}
			CaseVo vo = new CaseVo();
			vo.setCid(entity.getCid());
			vo.setTitle(entity.getTitle());
			vo.setCoverFile(entity.getCoverFile());
			vo.setContent(entity.getContent());
			vo.setStudentName(entity.getStudentName());
			vo.setSchool(entity.getSchool());
			vo.setMajor(entity.getMajor());
			vo.setGrade(entity.getGrade());
			vo.setOrder(entity.getOrder());
			vo.setOrgid(entity.getOrgid());
			vo.setOrgName(entity.getOrgName());
			vo.setShowTime(entity.getShowTime());
			vo.setCreateDate(entity.getCreateDate());
			vo.setCreater(entity.getCreater());
			vo.setUpdateDate(entity.getUpdateDate());
			vo.setUpdater(entity.getUpdater());
			vo.setPublic(entity.isPublic());
			return vo;
		} catch (Exception e) {
			throw new ServiceException("案例基本VO转换失败！", e);
		}
	}

	@Override
	public CaseVo transferEntityToFullVo(Case entity) throws ServiceException {
		try {
			return transferEntityToBaseVo(entity);
		} catch (Exception e) {
			throw new ServiceException("案例完整VO转换失败!", e);
		}
	}

	@Override
	public Case transferVoToEntity(CaseVo vo) throws ServiceException {
		try {
			if (vo == null) {
				return null;
			}
			Case entity = new Case();
			entity.setCid(vo.getCid());
			entity.setTitle(vo.getTitle());
			entity.setCoverFile(vo.getCoverFile());
			entity.setContent(vo.getContent());
			entity.setStudentName(vo.getStudentName());
			entity.setSchool(vo.getSchool());
			entity.setMajor(vo.getMajor());
			entity.setGrade(vo.getGrade());
			entity.setOrder(vo.getOrder());
			entity.setOrgid(vo.getOrgid());
			entity.setOrgName(vo.getOrgName());
			entity.setShowTime(vo.getShowTime());
			entity.setPublic(vo.isPublic());
			entity.setCreateDate(vo.getCreateDate());
			entity.setCreater(vo.getCreater());
			entity.setUpdateDate(vo.getUpdateDate());
			entity.setUpdater(vo.getUpdater());
			return entity;
		} catch (Exception e) {
			throw new ServiceException("案例转换失败",e);
		}
	}

	@Override
	public Collection<CaseVo> transferCollectionEntityToBaseVos(Collection<Case> entitys) throws ServiceException {
		List<CaseVo> vos = new ArrayList<CaseVo>();
		if (entitys != null) {
			for (Case entity : entitys) {
				vos.add(transferEntityToBaseVo(entity));
			}
		}
		return vos;
	}

	@Override
	public Collection<CaseVo> transferCollectionEntityToFullVos(Collection<Case> entitys) throws ServiceException {
		List<CaseVo> vos = new ArrayList<CaseVo>();
		if(entitys != null){
			for(Case entity : entitys){
				vos.add(transferEntityToFullVo(entity));
			}
		}
		return vos;
	}

	@Override
	public Collection<Case> transferCollectionVoToEntitys(Collection<CaseVo> entitys) throws ServiceException {
		List<Case> vos = new ArrayList<>();
		if (entitys != null) {
			for (CaseVo entity : entitys) {
				vos.add(transferVoToEntity(entity));
			}
		}
		return vos;
	}

}
