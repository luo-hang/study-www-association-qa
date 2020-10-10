package com.shiant.rmi.user.vo;

import java.io.Serializable;
import java.util.Date;

import com.shiant.common.BaseVO;

public class ExpertToEnterpriseRmiVo extends BaseVO implements Serializable {

	private static final long serialVersionUID = 7073011341024212111L;
	
	private Long e2eid;
	private Long expertid;
	private Long expertOrgid;
	private Long enterpriseid;
	private Date createDate;
	private Date updateDate;
	private String creater;
	private String updater;
	
	public Long getE2eid() {
		return e2eid;
	}
	public void setE2eid(Long e2eid) {
		this.e2eid = e2eid;
	}
	public Long getExpertid() {
		return expertid;
	}
	public void setExpertid(Long expertid) {
		this.expertid = expertid;
	}
	public Long getExpertOrgid() {
		return expertOrgid;
	}
	public void setExpertOrgid(Long expertOrgid) {
		this.expertOrgid = expertOrgid;
	}
	public Long getEnterpriseid() {
		return enterpriseid;
	}
	public void setEnterpriseid(Long enterpriseid) {
		this.enterpriseid = enterpriseid;
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
	
	
}
