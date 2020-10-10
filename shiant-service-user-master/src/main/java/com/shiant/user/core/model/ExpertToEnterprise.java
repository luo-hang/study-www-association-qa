package com.shiant.user.core.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="t_buss_expert_to_enterprise")
public class ExpertToEnterprise implements Serializable {

	private static final long serialVersionUID = -1533827796144404223L;

	@Id
	@Column(name="e2e_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long e2eid;

	@Column(name="expert_id")
	private Long expertid;

	@Column(name="enterprise_id")
	private Long enterpriseid;

	@Column(name="create_date")
	private Date createDate;

	@Column(name="update_date")
	private Date updateDate;
	
	@Column(name="creater")
	private String creater;
	
	@Column(name="updater")
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
