package com.shiant.study.core.school.transfer;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.shiant.common.exception.ServiceException;
import com.shiant.common.transfer.BaseTransfer;
import com.shiant.study.core.school.model.Profession;
import com.shiant.study.core.school.vo.ProfessionVo;

public class ProfessionTransfer implements BaseTransfer<Profession,ProfessionVo>{

	@Override
	public ProfessionVo transferEntityToBaseVo(Profession entity) throws ServiceException {
		try {
			if (entity == null) {
				return null;
			}
			ProfessionVo vo = new ProfessionVo();
			vo.setPid(entity.getPid());
			vo.setAdvantage(entity.isAdvantage());
			vo.setCreateDate(entity.getCreateDate());
			vo.setCreater(entity.getCreater());
			vo.setUpdateDate(entity.getUpdateDate());
			vo.setUpdater(entity.getUpdater());
			vo.setCollege(entity.getCollege());
			vo.setDegree(entity.getDegree());
			vo.setFee(entity.getFee());
			vo.setName(entity.getName());
			vo.setSemester(entity.getSemester());
			vo.setSid(entity.getSid());
			return vo;
		} catch (Exception e) {
			throw new ServiceException("专业基本VO转换失败！", e);
		}
	}

	@Override
	public ProfessionVo transferEntityToFullVo(Profession entity) throws ServiceException {
		try {
			return transferEntityToBaseVo(entity);
		} catch (Exception e) {
			throw new ServiceException("专业完整VO转换失败!", e);
		}
	}

	@Override
	public Profession transferVoToEntity(ProfessionVo vo) throws ServiceException {
		try {
			if (vo == null) {
				return null;
			}
			Profession entity = new Profession();
			entity.setPid(vo.getPid());
			entity.setAdvantage(vo.isAdvantage());
			entity.setCreateDate(vo.getCreateDate());
			entity.setCreater(vo.getCreater());
			entity.setUpdateDate(vo.getUpdateDate());
			entity.setUpdater(vo.getUpdater());
			entity.setCollege(vo.getCollege());
			entity.setDegree(vo.getDegree());
			entity.setFee(vo.getFee());
			entity.setName(vo.getName());
			entity.setSemester(vo.getSemester());
			entity.setSid(vo.getSid());
			return entity;
		} catch (Exception e) {
			throw new ServiceException("专业转换失败",e);
		}
	}

	@Override
	public Collection<ProfessionVo> transferCollectionEntityToBaseVos(Collection<Profession> entitys) throws ServiceException {
		List<ProfessionVo> vos = new ArrayList<ProfessionVo>();
		if (entitys != null) {
			for (Profession entity : entitys) {
				vos.add(transferEntityToBaseVo(entity));
			}
		}
		return vos;
	}

	@Override
	public Collection<ProfessionVo> transferCollectionEntityToFullVos(Collection<Profession> entitys) throws ServiceException {
		List<ProfessionVo> vos = new ArrayList<ProfessionVo>();
		if(entitys != null){
			for(Profession entity : entitys){
				vos.add(transferEntityToFullVo(entity));
			}
		}
		return vos;
	}

	@Override
	public Collection<Profession> transferCollectionVoToEntitys(Collection<ProfessionVo> entitys) throws ServiceException {
		List<Profession> vos = new ArrayList<>();
		if (entitys != null) {
			for (ProfessionVo entity : entitys) {
				vos.add(transferVoToEntity(entity));
			}
		}
		return vos;
	}

}
