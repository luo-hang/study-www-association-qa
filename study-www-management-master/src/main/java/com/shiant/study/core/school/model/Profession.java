package com.shiant.study.core.school.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="t_study_profession")
public class Profession implements Serializable {

	private static final long serialVersionUID = -6525091076544600637L;

	@Id
	@Column(name="pid")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long pid;	//编号
	
	@Column(name="sid")
	private Long sid;	//学院编号
	
	@Column(name="name")
	private String name;	//专业名称

	@Column(name="college")
	private String college;	//所属学院

	@Column(name="degree")
	private String degree;	//毕业学位
	
	@Column(name="semester")
	private int semester;	//学期

	@Column(name="fee")
	private int fee;	//学费

	@Column(name="advantage")
	private boolean advantage;	//是否是优势专业

	@Column(name="create_date")
	private Date createDate;

	@Column(name="update_date")
	private Date updateDate;
	
	@Column(name="creater")
	private String creater;
	
	@Column(name="updater")
	private String updater;

	public Long getPid() {
		return pid;
	}

	public void setPid(Long pid) {
		this.pid = pid;
	}

	public Long getSid() {
		return sid;
	}

	public void setSid(Long sid) {
		this.sid = sid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCollege() {
		return college;
	}

	public void setCollege(String college) {
		this.college = college;
	}

	public String getDegree() {
		return degree;
	}

	public void setDegree(String degree) {
		this.degree = degree;
	}

	public int getSemester() {
		return semester;
	}

	public void setSemester(int semester) {
		this.semester = semester;
	}

	public int getFee() {
		return fee;
	}

	public void setFee(int fee) {
		this.fee = fee;
	}

	public boolean isAdvantage() {
		return advantage;
	}

	public void setAdvantage(boolean advantage) {
		this.advantage = advantage;
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
