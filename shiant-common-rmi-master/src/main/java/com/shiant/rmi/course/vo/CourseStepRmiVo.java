package com.shiant.rmi.course.vo;

import java.io.Serializable;
import java.util.Date;

import com.shiant.common.BaseVO;

public class CourseStepRmiVo extends BaseVO implements Serializable {

	private static final long serialVersionUID = 4553713938318582014L;
	
	private Long csid;
	private String title;
	private String content;
	private String url;
	private Integer order;
	private String coverFile;
	private String videoFile;
	private String imageFile1;
	private String imageFile2;
	private String imageFile3;
	private String imageFile4;
	private String imageFile5;
	private String imageFile6;
	private String imageFile7;
	private String imageFile8;
	private String imageFile9;
	private String imageFile10;
	private String orgName;
	private Date createDate;
	private Date updateDate;
	private String creater;
	private String updater;
	private boolean isPublic;
	private boolean isDelete;
	private CourseRmiVo parentCourse;
	private Long courseid;
	
	public Long getCsid() {
		return csid;
	}

	public void setCsid(Long csid) {
		this.csid = csid;
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

	public CourseRmiVo getParentCourse() {
		return parentCourse;
	}

	public void setParentCourse(CourseRmiVo parentCourse) {
		this.parentCourse = parentCourse;
	}

	public Long getCourseid() {
		return courseid;
	}

	public void setCourseid(Long courseid) {
		this.courseid = courseid;
	}

	public String getVideoFile() {
		return videoFile;
	}

	public void setVideoFile(String videoFile) {
		this.videoFile = videoFile;
	}

	public String getImageFile1() {
		return imageFile1;
	}

	public void setImageFile1(String imageFile1) {
		this.imageFile1 = imageFile1;
	}

	public String getImageFile2() {
		return imageFile2;
	}

	public void setImageFile2(String imageFile2) {
		this.imageFile2 = imageFile2;
	}

	public String getImageFile3() {
		return imageFile3;
	}

	public void setImageFile3(String imageFile3) {
		this.imageFile3 = imageFile3;
	}

	public String getImageFile4() {
		return imageFile4;
	}

	public void setImageFile4(String imageFile4) {
		this.imageFile4 = imageFile4;
	}

	public String getImageFile5() {
		return imageFile5;
	}

	public void setImageFile5(String imageFile5) {
		this.imageFile5 = imageFile5;
	}

	public String getImageFile6() {
		return imageFile6;
	}

	public void setImageFile6(String imageFile6) {
		this.imageFile6 = imageFile6;
	}

	public String getImageFile7() {
		return imageFile7;
	}

	public void setImageFile7(String imageFile7) {
		this.imageFile7 = imageFile7;
	}

	public String getImageFile8() {
		return imageFile8;
	}

	public void setImageFile8(String imageFile8) {
		this.imageFile8 = imageFile8;
	}

	public String getImageFile9() {
		return imageFile9;
	}

	public void setImageFile9(String imageFile9) {
		this.imageFile9 = imageFile9;
	}

	public String getImageFile10() {
		return imageFile10;
	}

	public void setImageFile10(String imageFile10) {
		this.imageFile10 = imageFile10;
	}
}
