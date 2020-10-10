package com.shiant.rmi.course.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.shiant.common.BaseVO;

public class CourseRmiVo extends BaseVO implements Serializable {

	private static final long serialVersionUID = -2885956166402217616L;
	
	private Long cid;
	private Long typeid;
	private CourseTypeRmiVo type;
	private String title;
	private String content;
	private String url;
	private String coverFile;
	private Integer order;
	private Long orgid;
	private String orgName;
	private Long showTime;
	private Date createDate;
	private Date updateDate;
	private String creater;
	private String updater;
	private Long uploader;
	private boolean isPublic;
	private boolean isDelete;
	private List<CourseStepRmiVo> listOfCourseStep = new ArrayList<>();
	
	
	public Long getTypeid() {
		return typeid;
	}
	public void setTypeid(Long typeid) {
		this.typeid = typeid;
	}
	public CourseTypeRmiVo getType() {
		return type;
	}
	public void setType(CourseTypeRmiVo type) {
		this.type = type;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getCoverFile() {
		return coverFile;
	}
	public void setCoverFile(String coverFile) {
		this.coverFile = coverFile;
	}
	public Integer getOrder() {
		return order;
	}
	public void setOrder(Integer order) {
		this.order = order;
	}
	public Long getCid() {
		return cid;
	}
	public void setCid(Long cid) {
		this.cid = cid;
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
	public boolean isDelete() {
		return isDelete;
	}
	public void setDelete(boolean isDelete) {
		this.isDelete = isDelete;
	}
	public List<CourseStepRmiVo> getListOfCourseStep() {
		return listOfCourseStep;
	}
	public void setListOfCourseStep(List<CourseStepRmiVo> listOfCourseStep) {
		this.listOfCourseStep = listOfCourseStep;
	}
	public Long getUploader() {
		return uploader;
	}
	public void setUploader(Long uploader) {
		this.uploader = uploader;
	}
	public Long getShowTime() {
		return showTime;
	}
	public void setShowTime(Long showTime) {
		this.showTime = showTime;
	}
	
}
