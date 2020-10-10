package com.shiant.rmi.user.vo;

import java.io.Serializable;
import java.util.Date;

import com.shiant.common.BaseVO;

public class RoleRmiVo extends BaseVO implements Serializable {
	
	private static final long serialVersionUID = 2645324299986530097L;
	
	private Long roleid;
	private String roleName;
	private OrganizationRmiVo org;
	private Date createDate;
	private Date updateDate;
	private String creater;
	private String updater;
	
	public Long getRoleid() {
		return roleid;
	}
	public void setRoleid(Long roleid) {
		this.roleid = roleid;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public OrganizationRmiVo getOrg() {
		return org;
	}
	public void setOrg(OrganizationRmiVo org) {
		this.org = org;
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
