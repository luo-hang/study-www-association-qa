package com.shiant.rmi.video.vo;

import java.io.Serializable;
import java.util.Date;

import com.shiant.common.BaseVO;

public class VideoTypeRmiVo extends BaseVO implements Serializable {

	private static final long serialVersionUID = -5158743978418862654L;
	
	private Long vtid;
	private String name;
	private String alias;
	private Long orgid;
	private boolean isShow;
	private boolean isDelete;
	private Integer order;
	private Date createDate;
	private Date updateDate;
	private String creater;
	private String updater;
	
	
	public Long getVtid() {
		return vtid;
	}
	public void setVtid(Long vtid) {
		this.vtid = vtid;
	}
	public Long getOrgid() {
		return orgid;
	}
	public void setOrgid(Long orgid) {
		this.orgid = orgid;
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
