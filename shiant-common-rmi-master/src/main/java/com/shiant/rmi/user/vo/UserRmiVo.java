package com.shiant.rmi.user.vo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.shiant.common.BaseVO;

import io.swagger.annotations.ApiModelProperty;

public class UserRmiVo extends BaseVO implements Serializable {

	private static final long serialVersionUID = 4295977267879680007L;
	
	@ApiModelProperty(value = "用户编号")  
	private Long userid;
	@ApiModelProperty(value = "账号")  
	private String userName;
	@ApiModelProperty(value = "真实名称")  
	private String userRealName;
	@ApiModelProperty(value = "密码")  
	private String userPwd;
	@ApiModelProperty(value = "电话")  
	private String phone;
	@ApiModelProperty(value = "邮件")  
	private String email;
	@ApiModelProperty(value = "机构编号")  
	private Long orgid;
	@ApiModelProperty(value = "父级编号")  
	private Long parentid;
	@ApiModelProperty(value = "机构名称")  
	private String orgName;
	@ApiModelProperty(value = "机构图标")  
	private String orgLogo;
	@ApiModelProperty(value = "是否删除")  
	private boolean isDelete;
	@ApiModelProperty(value = "创建时间")  
	private Date createDate;
	@ApiModelProperty(value = "更新时间")  
	private Date updateDate;
	@ApiModelProperty(value = "创建人")  
	private String creater;
	@ApiModelProperty(value = "更新人")  
	private String updater;
	@ApiModelProperty(value = "角色集合")  
	private List<RoleRmiVo> listOfRole;

	public UserRmiVo() {
		
	}
	
	public UserRmiVo(String userName,String userPwd) {
		this.userName = userName;
		this.userPwd = userPwd;
	}

	public UserRmiVo(Long userid) {
		this.userid = userid;
	}
	
	public Long getUserid() {
		return userid;
	}

	public void setUserid(Long userid) {
		this.userid = userid;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserRealName() {
		return userRealName;
	}

	public void setUserRealName(String userRealName) {
		this.userRealName = userRealName;
	}

	
	public Long getParentid() {
		return parentid;
	}
	public void setParentid(Long parentid) {
		this.parentid = parentid;
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

	public String getOrgLogo() {
		return orgLogo;
	}
	public void setOrgLogo(String orgLogo) {
		this.orgLogo = orgLogo;
	}
	public String getUserPwd() {
		return userPwd;
	}

	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
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
	public List<RoleRmiVo> getListOfRole() {
		return listOfRole;
	}
	public void setListOfRole(List<RoleRmiVo> listOfRole) {
		this.listOfRole = listOfRole;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
}
