package com.shiant.user.core.transfer;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.shiant.common.exception.ServiceException;
import com.shiant.common.transfer.BaseTransfer;
import com.shiant.rmi.user.vo.OrganizationRmiVo;
import com.shiant.user.core.model.Organization;


public class OrganizationTransfer implements BaseTransfer<Organization,OrganizationRmiVo>{

	@Override
	public OrganizationRmiVo transferEntityToBaseVo(Organization entity) throws ServiceException {
		try {
			if (entity == null) {
				return null;
			}
			OrganizationRmiVo vo = new OrganizationRmiVo();
			vo.setOrgid(entity.getOrgid());
			vo.setParentid(entity.getParentid());
			vo.setOrgName(entity.getOrgName());
			vo.setOrgLogo(entity.getOrgLogo());
			vo.setCreateDate(entity.getCreateDate());
			vo.setCreater(entity.getCreater());
			vo.setUpdateDate(entity.getUpdateDate());
			vo.setUpdater(entity.getUpdater());
			vo.setAddress(entity.getAddress());
			vo.setCounty(entity.getCounty());
			vo.setCity(entity.getCity());
			vo.setCustomerNum(entity.getCustomerNum());
			vo.setIndustry(entity.getIndustry());
			vo.setOrgCode(entity.getOrgCode());
			vo.setOrgScale(entity.getOrgScale());
			vo.setProvince(entity.getProvince());
			vo.setLegalPerson(entity.getLegalPerson());
			vo.setLegalPersonPhone(entity.getLegalPersonPhone());
			vo.setDelete(entity.isDelete());
			vo.setBusinessLicense(entity.getBusinessLicense());
			vo.setConsultationPhone(entity.getConsultationPhone());
			vo.setFoundDate(entity.getFoundDate());
			vo.setLegalPersonIdCard(entity.getLegalPersonIdCard());
			vo.setOrgIntroduction(entity.getOrgIntroduction());
			vo.setQq(entity.getQq());
			vo.setStatus(entity.getStatus());
			vo.setWebsite(entity.getWebsite());
			vo.setWechat(entity.getWechat());
			vo.setWechatMp(entity.getWechatMp());
			vo.setWechatMpQrCode(entity.getWechatMpQrCode());
			vo.setWechatQrCode(entity.getWechatQrCode());
			vo.setWeibo(entity.getWeibo());
			vo.setReason(entity.getReason());
			vo.setVerifyDate(entity.getVerifyDate());
			return vo;
		} catch (Exception e) {
			throw new ServiceException("组织机构基本VO转换失败！", e);
		}
	}

	@Override
	public OrganizationRmiVo transferEntityToFullVo(Organization entity) throws ServiceException {
		try {
			return transferEntityToBaseVo(entity);
		} catch (Exception e) {
			throw new ServiceException("组织机构完整VO转换失败!", e);
		}
	}

	@Override
	public Organization transferVoToEntity(OrganizationRmiVo vo) throws ServiceException {
		try {
			if (vo == null) {
				return null;
			}
			Organization entity = new Organization();
			entity.setParentid(vo.getParentid());
			entity.setOrgid(vo.getOrgid());
			entity.setOrgName(vo.getOrgName());
			entity.setOrgLogo(vo.getOrgLogo());
			entity.setCreateDate(vo.getCreateDate());
			entity.setCreater(vo.getCreater());
			entity.setUpdater(vo.getUpdater());
			entity.setUpdateDate(vo.getUpdateDate());
			entity.setAddress(vo.getAddress());
			entity.setCounty(vo.getCounty());
			entity.setCity(vo.getCity());
			entity.setCustomerNum(vo.getCustomerNum());
			entity.setIndustry(vo.getIndustry());
			entity.setOrgCode(vo.getOrgCode());
			entity.setOrgScale(vo.getOrgScale());
			entity.setProvince(vo.getProvince());
			entity.setLegalPerson(vo.getLegalPerson());
			entity.setLegalPersonPhone(vo.getLegalPersonPhone());
			entity.setDelete(vo.isDelete());
			entity.setBusinessLicense(vo.getBusinessLicense());
			entity.setConsultationPhone(vo.getConsultationPhone());
			entity.setFoundDate(vo.getFoundDate());
			entity.setLegalPersonIdCard(vo.getLegalPersonIdCard());
			entity.setOrgIntroduction(vo.getOrgIntroduction());
			entity.setQq(vo.getQq());
			entity.setStatus(vo.getStatus());
			entity.setWebsite(vo.getWebsite());
			entity.setWechat(vo.getWechat());
			entity.setWechatMp(vo.getWechatMp());
			entity.setWechatMpQrCode(vo.getWechatMpQrCode());
			entity.setWechatQrCode(vo.getWechatQrCode());
			entity.setWeibo(vo.getWeibo());
			entity.setReason(vo.getReason());
			entity.setVerifyDate(vo.getVerifyDate());
			return entity;
		} catch (Exception e) {
			throw new ServiceException("组织机构转换失败",e);
		}
	}

	@Override
	public Collection<OrganizationRmiVo> transferCollectionEntityToBaseVos(Collection<Organization> entitys) throws ServiceException {
		List<OrganizationRmiVo> vos = new ArrayList<OrganizationRmiVo>();
		if (entitys != null) {
			for (Organization entity : entitys) {
				vos.add(transferEntityToBaseVo(entity));
			}
		}
		return vos;
	}

	@Override
	public Collection<OrganizationRmiVo> transferCollectionEntityToFullVos(Collection<Organization> entitys) throws ServiceException {
		List<OrganizationRmiVo> vos = new ArrayList<OrganizationRmiVo>();
		if(entitys != null){
			for(Organization entity : entitys){
				vos.add(transferEntityToFullVo(entity));
			}
		}
		return vos;
	}

	@Override
	public Collection<Organization> transferCollectionVoToEntitys(Collection<OrganizationRmiVo> entitys) throws ServiceException {
		List<Organization> vos = new ArrayList<>();
		if (entitys != null) {
			for (OrganizationRmiVo entity : entitys) {
				vos.add(transferVoToEntity(entity));
			}
		}
		return vos;
	}

}
