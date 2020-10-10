package com.shiant.study.core.system.vo;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.shiant.rmi.user.vo.OrganizationRmiVo;
import com.shiant.study.core.demo.vo.CaseVo;

public class OrganizationVo extends OrganizationRmiVo implements Serializable {

	private static final long serialVersionUID = 3045941687355004944L;
	
	private boolean isWl;
	private CaseVo caseVo;

	public boolean isWl() {
		return isWl;
	}

	public void setWl(boolean isWl) {
		this.isWl = isWl;
	}
	
	public CaseVo getCaseVo() {
		return caseVo;
	}

	public void setCaseVo(CaseVo caseVo) {
		this.caseVo = caseVo;
	}

	public OrganizationVo(OrganizationRmiVo org) {
		this.setOrgid(org.getOrgid());
		this.setParentid(org.getParentid());
		this.setOrgName(org.getOrgName());
		this.setOrgCode(org.getOrgCode());
		this.setOrgScale(org.getOrgScale());
		this.setOrgLogo(org.getOrgLogo());
		this.setOrgIntroduction(org.getOrgIntroduction());
		this.setCustomerNum(org.getCustomerNum());
		this.setIndustry(org.getIndustry());
		this.setProvince(org.getProvince());
		this.setCity(org.getCity());
		this.setCounty(org.getCounty());
		this.setAddress(org.getAddress());
		this.setConsultationPhone(org.getConsultationPhone());
		this.setWebsite(org.getWebsite());
		this.setQq(org.getQq());
		this.setWechat(org.getWechat());
		this.setWechatQrCode(org.getWechatQrCode());
		this.setWechatMp(org.getWechatMp());
		this.setWechatMpQrCode(org.getWechatMpQrCode());
		this.setWeibo(org.getWeibo());
		this.setLegalPerson(org.getLegalPerson());
		this.setLegalPersonIdCard(org.getLegalPersonIdCard());
		this.setLegalPersonPhone(org.getLegalPersonPhone());
		this.setBusinessLicense(org.getBusinessLicense());
		this.setFoundDate(org.getFoundDate());
		this.setCreateDate(org.getCreateDate());
		this.setUpdateDate(org.getUpdateDate());
		this.setCreater(org.getCreater());
		this.setUpdater(org.getUpdater());
		this.setDelete(org.isDelete());
		this.setStatus(org.getStatus());
		this.setReason(org.getReason());
		this.setVerifyDate(org.getVerifyDate());
	}
}
