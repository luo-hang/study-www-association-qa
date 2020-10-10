package com.shiant.rmi.video.vo;

import java.io.Serializable;
import java.util.Date;

import com.shiant.common.BaseVO;

public class VideoRmiVo extends BaseVO implements Serializable {

	private static final long serialVersionUID = -6374489303059007449L;
	
	private Long vid;
	private Long typeid;
	private VideoTypeRmiVo type;
	private String title;
	private String content;
	private String url;
	private String coverFile;
	private String fileUrl;
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
	
	
	public Long getVid() {
		return vid;
	}
	public void setVid(Long vid) {
		this.vid = vid;
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
	public Long getTypeid() {
		return typeid;
	}
	public void setTypeid(Long typeid) {
		this.typeid = typeid;
	}
	public VideoTypeRmiVo getType() {
		return type;
	}
	public void setType(VideoTypeRmiVo type) {
		this.type = type;
	}
	
}
