package com.shiant.study.core.whiteList.vo;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.shiant.common.BaseVO;

public class WhiteListVo extends BaseVO implements Serializable  {

	private static final long serialVersionUID = -7672194008368511099L;
	
	private Long wlid;
	private String wlNo;
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date validDate;
	private int status;
	private Long orgid;
	private String orgName;
	private String commitmentFile;
	private int commitmentStatus;
	private String applyFile;
	private int applyStatus;
	private String informationFile;
	private int informationStatus;
	private String copyFile;
	private int copyStatus;
	private String conventionFile;
	private int conventionStatus;
	private String verificationFile;
	private int verificationStatus;
	private Date createDate;
	private Date updateDate;
	private String creater;
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
