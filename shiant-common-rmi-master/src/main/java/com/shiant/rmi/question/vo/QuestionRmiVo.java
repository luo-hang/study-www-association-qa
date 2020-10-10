package com.shiant.rmi.question.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import io.swagger.annotations.ApiModelProperty;

public class QuestionRmiVo extends QuestionBaseRmiVo implements Serializable {

	private static final long serialVersionUID = -3896117564687462503L;
	
	@ApiModelProperty(value = "视频文件路径")  
	private String videoFile;
	@ApiModelProperty(value = "图片一文件路径")  
	private String imageFile1;
	@ApiModelProperty(value = "图片二文件路径")  
	private String imageFile2;
	@ApiModelProperty(value = "图片三文件路径")  
	private String imageFile3;
	@ApiModelProperty(value = "图片四文件路径")  
	private String imageFile4;
	@ApiModelProperty(value = "图片五文件路径")  
	private String imageFile5;
	@ApiModelProperty(value = "图片六文件路径")  
	private String imageFile6;
	@ApiModelProperty(value = "图片七文件路径")  
	private String imageFile7;
	@ApiModelProperty(value = "图片八文件路径")  
	private String imageFile8;
	@ApiModelProperty(value = "图片九文件路径")  
	private String imageFile9;
	@ApiModelProperty(value = "图片十文件路径")  
	private String imageFile10;
	@ApiModelProperty(value = "更新时间")  
	private Date updateDate;
	@ApiModelProperty(value = "更新人")  
	private String updater;
	@ApiModelProperty(value = "答案对象")  
	private List<AnswerRmiVo> listOfAnswer = new ArrayList<>();

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
	public Date getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	public String getUpdater() {
		return updater;
	}
	public void setUpdater(String updater) {
		this.updater = updater;
	}
	public List<AnswerRmiVo> getListOfAnswer() {
		return listOfAnswer;
	}
	public void setListOfAnswer(List<AnswerRmiVo> listOfAnswer) {
		this.listOfAnswer = listOfAnswer;
	}
}
