package com.shiant.rmi.product.vo;

import java.io.Serializable;
import java.util.Date;

import com.shiant.common.BaseVO;

public class ProductRmiVo extends BaseVO implements Serializable {

	private static final long serialVersionUID = -6374489303059007449L;
	
	private Long pid;
	private String title;
	private String content;
	private String specs;
	private String price;
	private String url;
	private String coverFile;
	private String fileUrl;
	private Integer order;
	private String orgName;
	private Long showTime;
	private Date createDate;
	private Date updateDate;
	private String creater;
	private String updater;
	private String uploader;
	private boolean isPublic;
	private boolean isDelete;
	
	
	public Long getPid() {
		return pid;
	}
	public void setPid(Long pid) {
		this.pid = pid;
	}
	public String getFileUrl() {
		return fileUrl;
	}
	public void setFileUrl(String fileUrl) {
		this.fileUrl = fileUrl;
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
	public String getSpecs() {
		return specs;
	}
	public void setSpecs(String specs) {
		this.specs = specs;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
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
	public String getUploader() {
		return uploader;
	}
	public void setUploader(String uploader) {
		this.uploader = uploader;
	}
	public Long getShowTime() {
		return showTime;
	}
	public void setShowTime(Long showTime) {
		this.showTime = showTime;
	}
	
}
