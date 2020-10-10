package com.shiant.study.core.adviser.transfer;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.shiant.common.exception.ServiceException;
import com.shiant.common.transfer.BaseTransfer;
import com.shiant.study.core.adviser.model.Adviser;
import com.shiant.study.core.adviser.vo.AdviserVo;

public class AdviserTransfer implements BaseTransfer<Adviser,AdviserVo>{

	@Override
	public AdviserVo transferEntityToBaseVo(Adviser entity) throws ServiceException {
		try {
			if (entity == null) {
				return null;
			}
			AdviserVo vo = new AdviserVo();
			vo.setTitle(entity.getTitle());
			vo.setCoverFile(entity.getCoverFile());
			vo.setContent(entity.getContent());
			vo.setOrder(entity.getOrder());
			vo.setOrgid(entity.getOrgid());
			vo.setOrgName(entity.getOrgName());
			vo.setShowTime(entity.getShowTime());
			vo.setCreateDate(entity.getCreateDate());
			vo.setCreater(entity.getCreater());
			vo.setUpdateDate(entity.getUpdateDate());
			vo.setUpdater(entity.getUpdater());
			vo.setIsPublic(entity.isPublic());
			vo.setAid(entity.getAid());
			vo.setAbility1(entity.getAbility1());
			vo.setAbility2(entity.getAbility2());
			vo.setAbility3(entity.getAbility3());
			vo.setAbility4(entity.getAbility4());
			vo.setAbility5(entity.getAbility5());
			vo.setAbility6(entity.getAbility6());
			vo.setAbility7(entity.getAbility7());
			vo.setAbility8(entity.getAbility8());
			vo.setAbility9(entity.getAbility9());
			vo.setAbility10(entity.getAbility10());
			vo.setAbility11(entity.getAbility11());
			vo.setAbility12(entity.getAbility12());
			vo.setAbility13(entity.getAbility13());
			vo.setAbility14(entity.getAbility14());
			vo.setAbility15(entity.getAbility15());
			vo.setAbility16(entity.getAbility16());
			vo.setAbility17(entity.getAbility17());
			vo.setAbility18(entity.getAbility18());
			vo.setAbility19(entity.getAbility19());
			vo.setAbility20(entity.getAbility20());
			vo.setBackground(entity.getBackground());
			vo.setCity(entity.getCity());
			vo.setItems(entity.getItems());
			vo.setName(entity.getName());
			vo.setWorkingTime(entity.getWorkingTime());
			return vo;
		} catch (Exception e) {
			throw new ServiceException("顾问基本VO转换失败！", e);
		}
	}

	@Override
	public AdviserVo transferEntityToFullVo(Adviser entity) throws ServiceException {
		try {
			return transferEntityToBaseVo(entity);
		} catch (Exception e) {
			throw new ServiceException("顾问完整VO转换失败!", e);
		}
	}

	@Override
	public Adviser transferVoToEntity(AdviserVo vo) throws ServiceException {
		try {
			if (vo == null) {
				return null;
			}
			Adviser entity = new Adviser();
			entity.setTitle(vo.getTitle());
			entity.setCoverFile(vo.getCoverFile());
			entity.setContent(vo.getContent());
			entity.setOrder(vo.getOrder());
			entity.setOrgid(vo.getOrgid());
			entity.setOrgName(vo.getOrgName());
			entity.setShowTime(vo.getShowTime());
			entity.setCreateDate(vo.getCreateDate());
			entity.setCreater(vo.getCreater());
			entity.setUpdateDate(vo.getUpdateDate());
			entity.setUpdater(vo.getUpdater());
			if(vo.getIsPublic()!=null) {
				entity.setPublic(vo.getIsPublic());
			}
			entity.setAid(vo.getAid());
			entity.setAbility1(vo.getAbility1());
			entity.setAbility2(vo.getAbility2());
			entity.setAbility3(vo.getAbility3());
			entity.setAbility4(vo.getAbility4());
			entity.setAbility5(vo.getAbility5());
			entity.setAbility6(vo.getAbility6());
			entity.setAbility7(vo.getAbility7());
			entity.setAbility8(vo.getAbility8());
			entity.setAbility9(vo.getAbility9());
			entity.setAbility10(vo.getAbility10());
			entity.setAbility11(vo.getAbility11());
			entity.setAbility12(vo.getAbility12());
			entity.setAbility13(vo.getAbility13());
			entity.setAbility14(vo.getAbility14());
			entity.setAbility15(vo.getAbility15());
			entity.setAbility16(vo.getAbility16());
			entity.setAbility17(vo.getAbility17());
			entity.setAbility18(vo.getAbility18());
			entity.setAbility19(vo.getAbility19());
			entity.setAbility20(vo.getAbility20());
			entity.setBackground(vo.getBackground());
			entity.setCity(vo.getCity());
			entity.setItems(vo.getItems());
			entity.setName(vo.getName());
			entity.setWorkingTime(vo.getWorkingTime());
			return entity;
		} catch (Exception e) {
			throw new ServiceException("顾问转换失败",e);
		}
	}

	@Override
	public Collection<AdviserVo> transferCollectionEntityToBaseVos(Collection<Adviser> entitys) throws ServiceException {
		List<AdviserVo> vos = new ArrayList<AdviserVo>();
		if (entitys != null) {
			for (Adviser entity : entitys) {
				vos.add(transferEntityToBaseVo(entity));
			}
		}
		return vos;
	}

	@Override
	public Collection<AdviserVo> transferCollectionEntityToFullVos(Collection<Adviser> entitys) throws ServiceException {
		List<AdviserVo> vos = new ArrayList<AdviserVo>();
		if(entitys != null){
			for(Adviser entity : entitys){
				vos.add(transferEntityToFullVo(entity));
			}
		}
		return vos;
	}

	@Override
	public Collection<Adviser> transferCollectionVoToEntitys(Collection<AdviserVo> entitys) throws ServiceException {
		List<Adviser> vos = new ArrayList<>();
		if (entitys != null) {
			for (AdviserVo entity : entitys) {
				vos.add(transferVoToEntity(entity));
			}
		}
		return vos;
	}

}
