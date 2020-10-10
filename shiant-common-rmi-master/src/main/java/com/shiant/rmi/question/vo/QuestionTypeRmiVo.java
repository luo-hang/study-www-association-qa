package com.shiant.rmi.question.vo;

import java.io.Serializable;
import java.util.Date;

import com.shiant.common.BaseVO;

import io.swagger.annotations.ApiModelProperty;

public class QuestionTypeRmiVo extends BaseVO implements Serializable {

	private static final long serialVersionUID = -986791609110741839L;
	
	@ApiModelProperty(value = "问题类型编号")  
	private Long qtid;
	@ApiModelProperty(value = "名称")  
	private String name;
	@ApiModelProperty(value = "父级")  
	private Long parentid;
	@ApiModelProperty(value = "是否显示")  
	private boolean isShow;
	@ApiModelProperty(value = "排序")  
	private Integer order;
	@ApiModelProperty(value = "创建时间")  
	private Date createDate;
	@ApiModelProperty(value = "更新时间")  
	private Date updateDate;
	@ApiModelProperty(value = "创建人")  
	private String creater;
	@ApiModelProperty(value = "更新人")  
	private String updater;
	
	
	public Long getQtid() {
		return qtid;
	}
	public void setQtid(Long qtid) {
		this.qtid = qtid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean isShow() {
		return isShow;
	}
	public void setShow(boolean isShow) {
		this.isShow = isShow;
	}
	public Long getParentid() {
		return parentid;
	}
	public void setParentid(Long parentid) {
		this.parentid = parentid;
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
	public Integer getOrder() {
		return order;
	}
	public void setOrder(Integer order) {
		this.order = order;
	}
}
