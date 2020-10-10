package com.shiant.study.core.school.transfer;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.shiant.common.exception.ServiceException;
import com.shiant.common.transfer.BaseTransfer;
import com.shiant.study.core.school.model.School;
import com.shiant.study.core.school.vo.SchoolVo;

public class SchoolTransfer implements BaseTransfer<School,SchoolVo>{

	@Override
	public SchoolVo transferEntityToBaseVo(School entity) throws ServiceException {
		try {
			if (entity == null) {
				return null;
			}
			SchoolVo vo = new SchoolVo();
			vo.setId(entity.getId());
			vo.setCity(entity.getCity());
			vo.setCreateDate(entity.getCreateDate());
			vo.setProvince(entity.getProvince());
			vo.setUpdateDate(entity.getUpdateDate());
			vo.setSchoolAbout(entity.getSchoolAbout());
			vo.setSchoolAddress(entity.getSchoolAddress());
			vo.setSchoolCountry(entity.getSchoolCountry());
			vo.setSchoolImg(entity.getSchoolImg());
			vo.setSchooLing(entity.getSchooLing());
			vo.setSchoolLogo(entity.getSchoolLogo());
			vo.setSchoolNameC(entity.getSchoolNameC());
			vo.setSchoolNameE(entity.getSchoolNameE());
			vo.setSchoolProperty(entity.getSchoolProperty());
			vo.setStudentsEnrollment(entity.getStudentsEnrollment());
			return vo;
		} catch (Exception e) {
			throw new ServiceException("院校基本VO转换失败！", e);
		}
	}

	@Override
	public SchoolVo transferEntityToFullVo(School entity) throws ServiceException {
		try {
			return transferEntityToBaseVo(entity);
		} catch (Exception e) {
			throw new ServiceException("院校完整VO转换失败!", e);
		}
	}

	@Override
	public School transferVoToEntity(SchoolVo vo) throws ServiceException {
		try {
			if (vo == null) {
				return null;
			}
			School entity = new School();
			entity.setId(vo.getId());
			entity.setCity(vo.getCity());
			entity.setCreateDate(vo.getCreateDate());
			entity.setProvince(vo.getProvince());
			entity.setUpdateDate(vo.getUpdateDate());
			entity.setSchoolAbout(vo.getSchoolAbout());
			entity.setSchoolAddress(vo.getSchoolAddress());
			entity.setSchoolCountry(vo.getSchoolCountry());
			entity.setSchoolImg(vo.getSchoolImg());
			entity.setSchooLing(vo.getSchooLing());
			entity.setSchoolLogo(vo.getSchoolLogo());
			entity.setSchoolNameC(vo.getSchoolNameC());
			entity.setSchoolNameE(vo.getSchoolNameE());
			entity.setSchoolProperty(vo.getSchoolProperty());
			entity.setStudentsEnrollment(vo.getStudentsEnrollment());
			return entity;
		} catch (Exception e) {
			throw new ServiceException("院校转换失败",e);
		}
	}

	@Override
	public Collection<SchoolVo> transferCollectionEntityToBaseVos(Collection<School> entitys) throws ServiceException {
		List<SchoolVo> vos = new ArrayList<SchoolVo>();
		if (entitys != null) {
			for (School entity : entitys) {
				vos.add(transferEntityToBaseVo(entity));
			}
		}
		return vos;
	}

	@Override
	public Collection<SchoolVo> transferCollectionEntityToFullVos(Collection<School> entitys) throws ServiceException {
		List<SchoolVo> vos = new ArrayList<SchoolVo>();
		if(entitys != null){
			for(School entity : entitys){
				vos.add(transferEntityToFullVo(entity));
			}
		}
		return vos;
	}

	@Override
	public Collection<School> transferCollectionVoToEntitys(Collection<SchoolVo> entitys) throws ServiceException {
		List<School> vos = new ArrayList<>();
		if (entitys != null) {
			for (SchoolVo entity : entitys) {
				vos.add(transferVoToEntity(entity));
			}
		}
		return vos;
	}

}
