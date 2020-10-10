package com.shiant.rmi.question.vo;

import java.io.Serializable;
import java.util.Date;

import com.shiant.common.BaseVO;

import io.swagger.annotations.ApiModelProperty;

public class QuestionBaseRmiVo extends BaseVO implements Serializable {

	private static final long serialVersionUID = -1124840534636062616L;
	
	@ApiModelProperty(value = "问题编号") 
	private Long qid;
	@ApiModelProperty(value = "实训编号") 
	private Long csid;
	@ApiModelProperty(value = "问题标题") 
	private String title;
	@ApiModelProperty(value = "问题类型") 
	private String type;
	@ApiModelProperty(value = "问题内容") 
	private String content;
	@ApiModelProperty(value = "问题外联地址") 
	private String url;
	@ApiModelProperty(value = "问题标记") 
	private String tip;
	@ApiModelProperty(value = "机构编号") 
	private Long orgid;
	@ApiModelProperty(value = "机构名称") 
	private String orgName;
	@ApiModelProperty(value = "创建人") 
	private String creater;
	@ApiModelProperty(value = "创建时间") 
	private Date createDate;
	@ApiModelProperty(value = "回答人编号") 
	private Long solver;
	@ApiModelProperty(value = "提问人编号") 
	private Long questioner;
	@ApiModelProperty(value = "提问人头像地址") 
	private String questionerLogo;
	@ApiModelProperty(value = "处理人编号") 
	private Long handler;
	@ApiModelProperty(value = "处理人名称") 
	private String handlerName;
	@ApiModelProperty(value = "是否解决") 
	private boolean isSolve;
	@ApiModelProperty(value = "是否删除") 
	private boolean isDelete;
	@ApiModelProperty(value = "分类一") 
	private String class1;
	@ApiModelProperty(value = "分类二") 
	private String class2;	
	@ApiModelProperty(value = "分类三") 
	private String class3;
	@ApiModelProperty(value = "分类四") 
	private String class4;
	
	public Long getQid() {
		return qid;
	}
	public void setQid(Long qid) {
		this.qid = qid;
	}
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
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
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
	public String getCreater() {
		return creater;
	}
	public void setCreater(String creater) {
		this.creater = creater;
	}
	public boolean isSolve() {
		return isSolve;
	}
	public void setSolve(boolean isSolve) {
		this.isSolve = isSolve;
	}
	public boolean isDelete() {
		return isDelete;
	}
	public void setDelete(boolean isDelete) {
		this.isDelete = isDelete;
	}
	public Long getSolver() {
		return solver;
	}
	public void setSolver(Long solver) {
		this.solver = solver;
	}
	public Long getQuestioner() {
		return questioner;
	}
	public void setQuestioner(Long questioner) {
		this.questioner = questioner;
	}
	public String getQuestionerLogo() {
		return questionerLogo;
	}
	public void setQuestionerLogo(String questionerLogo) {
		this.questionerLogo = questionerLogo;
	}
	public String getTip() {
		return tip;
	}
	public void setTip(String tip) {
		this.tip = tip;
	}
	public Long getOrgid() {
		return orgid;
	}
	public void setOrgid(Long orgid) {
		this.orgid = orgid;
	}
	public Long getHandler() {
		return handler;
	}
	public void setHandler(Long handler) {
		this.handler = handler;
	}
	public String getHandlerName() {
		return handlerName;
	}
	public void setHandlerName(String handlerName) {
		this.handlerName = handlerName;
	}
	public String getClass1() {
		return class1;
	}
	public void setClass1(String class1) {
		this.class1 = class1;
	}
	public String getClass2() {
		return class2;
	}
	public void setClass2(String class2) {
		this.class2 = class2;
	}
	public String getClass3() {
		return class3;
	}
	public void setClass3(String class3) {
		this.class3 = class3;
	}
	public String getClass4() {
		return class4;
	}
	public void setClass4(String class4) {
		this.class4 = class4;
	}
	
}
