package com.shiant.study.core.article.vo;

import java.io.Serializable;
import java.util.Date;

import com.shiant.common.BaseVO;

public class ArticleVo extends BaseVO implements Serializable  {

	private static final long serialVersionUID = -2163572446961838046L;
	
	private Long aid;
	private String type;
	private String title;
	private String coverFile;
	private String content;
	private Long showTime;
	private Date createDate;
	private Date updateDate;
	private String creater;
	private String updater;
	
	public Long getAid() {
		return aid;
	}
	public void setAid(Long aid) {
		this.aid = aid;
	}
	public String getCoverFile() {
		return coverFile;
	}
	public void setCoverFile(String coverFile) {
		this.coverFile = coverFile;
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
	
}
