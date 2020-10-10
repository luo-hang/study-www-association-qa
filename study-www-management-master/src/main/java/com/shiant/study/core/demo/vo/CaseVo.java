package com.shiant.study.core.demo.vo;

import java.io.Serializable;
import java.util.Date;

import com.shiant.common.BaseVO;

public class CaseVo extends BaseVO implements Serializable  {

	private static final long serialVersionUID = -2746179897333732441L;
	
	private Long cid;
	private String title;
	private String coverFile;
	private String content;
	private String studentName;
	private String school;
	private String major;
	private String grade;
	private Integer order;
	private Long orgid;
	private String orgName;
	private Long showTime;
	private Date createDate;
	private Date updateDate;
	private String creater;
	private String updater;
	private boolean isPublic;
	private String aids;
	
	public Long getCid() {
		return cid;
	}
	public void setCid(Long cid) {
		this.cid = cid;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getCoverFile() {
		return coverFile;
	}
	public void setCoverFile(String coverFile) {
		this.coverFile = coverFile;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public String getSchool() {
		return school;
	}
	public void setSchool(String school) {
		this.school = school;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public Integer getOrder() {
		return order;
	}
	public void setOrder(Integer order) {
		this.order = order;
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
	public Long getShowTime() {
		return showTime;
	}
	public void setShowTime(Long showTime) {
		this.showTime = showTime;
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
	public boolean isPublic() {
		return isPublic;
	}
	public void setPublic(boolean isPublic) {
		this.isPublic = isPublic;
	}
	public String getAids() {
		return aids;
	}
	public void setAids(String aids) {
		this.aids = aids;
	}

}
