package com.shiant.user.core.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="t_pms_organization")
public class Organization implements Serializable {

	private static final long serialVersionUID = -1494393664023163453L;

	@Id
	@Column(name="org_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long orgid;

	@Column(name="parent_id")
	private Long parentid;

	@Column(name="org_name")
	private String orgName;
	
	@Column(name="org_code")
	private String orgCode;
	
	@Column(name="org_scale")
	private String orgScale;
	
	@Column(name="org_logo")
	private String orgLogo;

	@Column(name="org_introduction")
	private String orgIntroduction;
	
	@Column(name="customer_num")
	private String customerNum;
	
	@Column(name="industry")
	private String industry;
	
	@Column(name="province")
	private String province;
	
	@Column(name="city")
	private String city;
	
	@Column(name="county")
	private String county;
	
	@Column(name="address")
	private String address;

	@Column(name="consultation_phone")
	private String consultationPhone;

	@Column(name="website")
	private String website;

	@Column(name="qq")
	private String qq;

	@Column(name="wechat")
	private String wechat;
	
	@Column(name="wechat_qr_code")
	private String wechatQrCode;
	
	@Column(name="wechat_mp")
	private String wechatMp;
	
	@Column(name="wechat_mp_qr_code")
	private String wechatMpQrCode;
	
	@Column(name="weibo")
	private String weibo;
	
	@Column(name="legal_person")
	private String legalPerson;

	@Column(name="legal_person_id_card")
	private String legalPersonIdCard;
	
	@Column(name="legal_person_phone")
	private String legalPersonPhone;

	@Column(name="business_license")
	private String businessLicense;
	
	@Column(name="found_date")
	private Date foundDate;

	@Column(name="create_date")
	private Date createDate;

	@Column(name="update_date")
	private Date updateDate;
	
	@Column(name="creater")
	private String creater;
	
	@Column(name="updater")
	private String updater;
	
	@Column(name="is_delete")
	private boolean isDelete;
	
	@Column(name="status")
	private int status;
	
	@Column(name="reason")
	private String reason;

	@Column(name="verify_date")
	private Date verifyDate;

	public Long getOrgid() {
		return orgid;
	}

	public void setOrgid(Long orgid) {
		this.orgid = orgid;
	}

	public Long getParentid() {
		return parentid;
	}

	public void setParentid(Long parentid) {
		this.parentid = parentid;
	}

	public String getOrgName() {
		return orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

	public String getOrgLogo() {
		return orgLogo;
	}

	public void setOrgLogo(String orgLogo) {
		this.orgLogo = orgLogo;
	}

	public String getOrgCode() {
		return orgCode;
	}

	public void setOrgCode(String orgCode) {
		this.orgCode = orgCode;
	}

	public String getOrgScale() {
		return orgScale;
	}

	public void setOrgScale(String orgScale) {
		this.orgScale = orgScale;
	}

	public String getCustomerNum() {
		return customerNum;
	}

	public void setCustomerNum(String customerNum) {
		this.customerNum = customerNum;
	}

	public String getIndustry() {
		return industry;
	}

	public void setIndustry(String industry) {
		this.industry = industry;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCounty() {
		return county;
	}

	public void setCounty(String county) {
		this.county = county;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getLegalPerson() {
		return legalPerson;
	}

	public void setLegalPerson(String legalPerson) {
		this.legalPerson = legalPerson;
	}

	public String getLegalPersonPhone() {
		return legalPersonPhone;
	}

	public void setLegalPersonPhone(String legalPersonPhone) {
		this.legalPersonPhone = legalPersonPhone;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public String getCreater() {
		return creater;
	}

	public void setCreater(String creater) {
		this.creater = creater;
	}

	public String getUpdater() {
		return updater;
	}

	public void setUpdater(String updater) {
		this.updater = updater;
	}

	public boolean isDelete() {
		return isDelete;
	}

	public void setDelete(boolean isDelete) {
		this.isDelete = isDelete;
	}

	public String getOrgIntroduction() {
		return orgIntroduction;
	}

	public void setOrgIntroduction(String orgIntroduction) {
		this.orgIntroduction = orgIntroduction;
	}

	public String getConsultationPhone() {
		return consultationPhone;
	}

	public void setConsultationPhone(String consultationPhone) {
		this.consultationPhone = consultationPhone;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public String getQq() {
		return qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}

	public String getWechat() {
		return wechat;
	}

	public void setWechat(String wechat) {
		this.wechat = wechat;
	}

	public String getWechatQrCode() {
		return wechatQrCode;
	}

	public void setWechatQrCode(String wechatQrCode) {
		this.wechatQrCode = wechatQrCode;
	}

	public String getWechatMp() {
		return wechatMp;
	}

	public void setWechatMp(String wechatMp) {
		this.wechatMp = wechatMp;
	}

	public String getWechatMpQrCode() {
		return wechatMpQrCode;
	}

	public void setWechatMpQrCode(String wechatMpQrCode) {
		this.wechatMpQrCode = wechatMpQrCode;
	}

	public String getWeibo() {
		return weibo;
	}

	public void setWeibo(String weibo) {
		this.weibo = weibo;
	}

	public String getLegalPersonIdCard() {
		return legalPersonIdCard;
	}

	public void setLegalPersonIdCard(String legalPersonIdCard) {
		this.legalPersonIdCard = legalPersonIdCard;
	}

	public String getBusinessLicense() {
		return businessLicense;
	}

	public void setBusinessLicense(String businessLicense) {
		this.businessLicense = businessLicense;
	}

	public Date getFoundDate() {
		return foundDate;
	}

	public void setFoundDate(Date foundDate) {
		this.foundDate = foundDate;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public Date getVerifyDate() {
		return verifyDate;
	}

	public void setVerifyDate(Date verifyDate) {
		this.verifyDate = verifyDate;
	}

}
