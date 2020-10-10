package com.shiant.study.core.school.vo;

import java.io.Serializable;
import java.util.Date;

import com.shiant.common.BaseVO;

public class ProfessionVo extends BaseVO implements Serializable  {

	private static final long serialVersionUID = -2019699154566415479L;
	
	private Long pid;			//编号
	private Long sid;			//学院编号
	private String name;		//专业名称
	private String college;		//所属学院
	private String degree;		//毕业学位
	private int semester;		//学期
	private int fee;			//学费
	private boolean advantage;	//是否是优势专业
	private Date createDate;
	private Date updateDate;
	private String creater;
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
