package com.shiant.rmi.course.vo;

import java.io.Serializable;
import java.util.Date;

import com.shiant.common.BaseVO;

public class CourseTypeRmiVo extends BaseVO implements Serializable {

	private static final long serialVersionUID = 3015014020719741606L;
	
	private Long ctid;
	private String name;
	private String alias;
	private Long orgid;
	private String orgName;
	private boolean isShow;
	private boolean isDelete;
	private Integer order;
	private Date createDate;
	private Date updateDate;
	private String creater;
	private String updater;
	
	public Long getCtid() {
		return ctid;
	}
	public void setCtid(Long ctid) {
		this.ctid = ctid;
	}
	public Long getOrgid() {
		return orgid;
	}
	public void setOrgid(Long orgid) {
		this.orgid = orgid;
	}
	public String getOrgName() {
		return orgName;
	}
	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAlias() {
		return alias;
	}
	public void setAlias(String alias) {
		this.alias = alias;
	}
	public boolean isShow() {
		return isShow;
	}
	public void setShow(boolean isShow) {
		this.isShow = isShow;
	}
	public boolean isDelete() {
		return isDelete;
	}
	public void setDelete(boolean isDelete) {
		this.isDelete = isDelete;
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
	public Integer getOrder() {
		return order;
	}
	public void setOrder(Integer order) {
		this.order = order;
	}
}
