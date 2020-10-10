package com.shiant.study.core.legal.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="t_study_complaint")
public class Complaint implements Serializable {

	private static final long serialVersionUID = 5954995846528483474L;

	@Id
	@Column(name="cid")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long cid;
	
	@Column(name="org_name")
	private String orgName;
	
	@Column(name="type")
	private String type;

	@Column(name="need")
	private String need;
	
	@Column(name="status")
	private int status;

	@Column(name="reason")
	private String reason;

	@Column(name="title")
	private String title;
	
	@Column(name="content")
	private String content;

	@Column(name="image_file_1")
	private String imageFile1;
	
	@Column(name="image_file_2")
	private String imageFile2;
	
	@Column(name="image_file_3")
	private String imageFile3;
	
	@Column(name="image_file_4")
	private String imageFile4;
	
	@Column(name="image_file_5")
	private String imageFile5;
	
	@Column(name="image_file_6")
	private String imageFile6;
	
	@Column(name="image_file_7")
	private String imageFile7;
	
	@Column(name="image_file_8")
	private String imageFile8;
	
	@Column(name="image_file_9")
	private String imageFile9;
	
	@Column(name="image_file_10")
	private String imageFile10;
	
	@Column(name="video_file_1")
	private String videoFile1;
	
	@Column(name="video_file_2")
	private String videoFile2;
	
	@Column(name="video_file_3")
	private String videoFile3;
	
	@Column(name="video_file_4")
	private String videoFile4;
	
	@Column(name="video_file_5")
	private String videoFile5;
	
	@Column(name="org_id")
	private Long orgid;
	
	@Column(name="create_date")
	private Date createDate;

	@Column(name="update_date")
	private Date updateDate;
	
	@Column(name="creater")
	private String creater;
	
	@Column(name="updater")
	private String updater;

	@Column(name="creater_id")
	private Long createrid;

	@Column(name="creater_type")
	private String createrType;
	
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

	public String getOrgName() {
		return orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
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

	public String getVideoFile1() {
		return videoFile1;
	}

	public void setVideoFile1(String videoFile1) {
		this.videoFile1 = videoFile1;
	}

	public String getVideoFile2() {
		return videoFile2;
	}

	public void setVideoFile2(String videoFile2) {
		this.videoFile2 = videoFile2;
	}

	public String getVideoFile3() {
		return videoFile3;
	}

	public void setVideoFile3(String videoFile3) {
		this.videoFile3 = videoFile3;
	}

	public String getVideoFile4() {
		return videoFile4;
	}

	public void setVideoFile4(String videoFile4) {
		this.videoFile4 = videoFile4;
	}

	public String getVideoFile5() {
		return videoFile5;
	}

	public void setVideoFile5(String videoFile5) {
		this.videoFile5 = videoFile5;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
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

	public Long getOrgid() {
		return orgid;
	}

	public void setOrgid(Long orgid) {
		this.orgid = orgid;
	}

	public String getNeed() {
		return need;
	}

	public void setNeed(String need) {
		this.need = need;
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

	public Long getCreaterid() {
		return createrid;
	}

	public void setCreaterid(Long createrid) {
		this.createrid = createrid;
	}

	public String getCreaterType() {
		return createrType;
	}

	public void setCreaterType(String createrType) {
		this.createrType = createrType;
	}

}
