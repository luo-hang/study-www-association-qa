package com.shiant.rmi.question.vo;

import java.io.Serializable;
import java.util.Date;

import com.shiant.common.BaseVO;

import io.swagger.annotations.ApiModelProperty;

public class AnswerRmiVo extends BaseVO implements Serializable {

	private static final long serialVersionUID = 1080972666871443930L;
	
	@ApiModelProperty(value = "回答编号")  
	private Long aid;
	@ApiModelProperty(value = "内容")  
	private String content;
	@ApiModelProperty(value = "外联地址")  
	private String url;
	@ApiModelProperty(value = "排序")  
	private Integer order;
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
	@ApiModelProperty(value = "机构编号") 
	private Long orgid;
	@ApiModelProperty(value = "机构名称") 
	private String orgName;
	@ApiModelProperty(value = "创建人") 
	private String creater;
	@ApiModelProperty(value = "创建时间") 
	private Date createDate;
	@ApiModelProperty(value = "更新时间") 
	private Date updateDate;
	@ApiModelProperty(value = "更新人") 
	private String updater;
	@ApiModelProperty(value = "解决人编号") 
	private Long solver;
	@ApiModelProperty(value = "解决人头像地址") 
	private String solverLogo;
	@ApiModelProperty(value = "是否删除") 
	private boolean isDelete;
	@ApiModelProperty(value = "问题对象") 
	private QuestionBaseRmiVo question;
	@ApiModelProperty(value = "问题编号") 
	private Long qid;
	
	public Long getAid() {
		return aid;
	}
	public void setAid(Long aid) {
		this.aid = aid;
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
	public Integer getOrder() {
		return order;
	}
	public void setOrder(Integer order) {
		this.order = order;
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
	public boolean isDelete() {
		return isDelete;
	}
	public void setDelete(boolean isDelete) {
		this.isDelete = isDelete;
	}
	public QuestionBaseRmiVo getQuestion() {
		return question;
	}
	public void setQuestion(QuestionBaseRmiVo question) {
		this.question = question;
	}
	public Long getQid() {
		return qid;
	}
	public void setQid(Long qid) {
		this.qid = qid;
	}
	public String getSolverLogo() {
		return solverLogo;
	}
	public void setSolverLogo(String solverLogo) {
		this.solverLogo = solverLogo;
	}
	public Long getOrgid() {
		return orgid;
	}
	public void setOrgid(Long orgid) {
		this.orgid = orgid;
	}
	public Long getSolver() {
		return solver;
	}
	public void setSolver(Long solver) {
		this.solver = solver;
	}
}
