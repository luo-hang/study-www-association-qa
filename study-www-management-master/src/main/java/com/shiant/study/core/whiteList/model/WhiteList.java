package com.shiant.study.core.whiteList.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="t_study_white_list")
public class WhiteList implements Serializable {

	private static final long serialVersionUID = 8165520121471817520L;

	@Id
	@Column(name="wlid")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long wlid;
	
	@Column(name="wl_no")
	private String wlNo;

	@Column(name="valid_date")
	private Date validDate;
	
	@Column(name="status")
	private int status;
	
	@Column(name="org_id")
	private Long orgid;
	
	@Column(name="org_name")
	private String orgName;
	
	@Column(name="commitment_file")
	private String commitmentFile;
	
	@Column(name="commitment_status")
	private int commitmentStatus;
	
	@Column(name="apply_file")
	private String applyFile;
	
	@Column(name="apply_status")
	private int applyStatus;
	
	@Column(name="information_file")
	private String informationFile;
	
	@Column(name="information_status")
	private int informationStatus;
	
	@Column(name="copy_file")
	private String copyFile;
	
	@Column(name="copy_status")
	private int copyStatus;
	
	@Column(name="convention_file")
	private String conventionFile;
	
	@Column(name="convention_status")
	private int conventionStatus;
	
	@Column(name="verification_file")
	private String verificationFile;
	
	@Column(name="verification_status")
	private int verificationStatus;
	
	@Column(name="create_date")
	private Date createDate;

	@Column(name="update_date")
	private Date updateDate;
	
	@Column(name="creater")
	private String creater;
	
	@Column(name="updater")
	private String updater;

	public Long getWlid() {
		return wlid;
	}

	public void setWlid(Long wlid) {
		this.wlid = wlid;
	}

	public String getWlNo() {
		return wlNo;
	}

	public void setWlNo(String wlNo) {
		this.wlNo = wlNo;
	}

	public Date getValidDate() {
		return validDate;
	}

	public void setValidDate(Date validDate) {
		this.validDate = validDate;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
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

	public String getCommitmentFile() {
		return commitmentFile;
	}

	public void setCommitmentFile(String commitmentFile) {
		this.commitmentFile = commitmentFile;
	}

	public int getCommitmentStatus() {
		return commitmentStatus;
	}

	public void setCommitmentStatus(int commitmentStatus) {
		this.commitmentStatus = commitmentStatus;
	}

	public String getApplyFile() {
		return applyFile;
	}

	public void setApplyFile(String applyFile) {
		this.applyFile = applyFile;
	}

	public int getApplyStatus() {
		return applyStatus;
	}

	public void setApplyStatus(int applyStatus) {
		this.applyStatus = applyStatus;
	}

	public String getInformationFile() {
		return informationFile;
	}

	public void setInformationFile(String informationFile) {
		this.informationFile = informationFile;
	}

	public int getInformationStatus() {
		return informationStatus;
	}

	public void setInformationStatus(int informationStatus) {
		this.informationStatus = informationStatus;
	}

	public String getCopyFile() {
		return copyFile;
	}

	public void setCopyFile(String copyFile) {
		this.copyFile = copyFile;
	}

	public int getCopyStatus() {
		return copyStatus;
	}

	public void setCopyStatus(int copyStatus) {
		this.copyStatus = copyStatus;
	}

	public String getConventionFile() {
		return conventionFile;
	}

	public void setConventionFile(String conventionFile) {
		this.conventionFile = conventionFile;
	}

	public int getConventionStatus() {
		return conventionStatus;
	}

	public void setConventionStatus(int conventionStatus) {
		this.conventionStatus = conventionStatus;
	}

	public String getVerificationFile() {
		return verificationFile;
	}

	public void setVerificationFile(String verificationFile) {
		this.verificationFile = verificationFile;
	}

	public int getVerificationStatus() {
		return verificationStatus;
	}

	public void setVerificationStatus(int verificationStatus) {
		this.verificationStatus = verificationStatus;
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
