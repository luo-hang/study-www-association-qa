package com.shiant.user.core.model;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity(name="t_pms_user")
public class User implements Serializable {

	private static final long serialVersionUID = -1423665608108835424L;

	@Id
	@Column(name="user_id")
	private Long userid;

	@Column(name="user_name")
	private String userName;

	@Column(name="is_delete")
	private boolean isDelete;
	
	@Column(name="create_date")
	private Date createDate;

	@Column(name="update_date")
	private Date updateDate;
	
	@Column(name="creater")
	private String creater;
	
	@Column(name="updater")
	private String updater;
	
	@ManyToOne(cascade={CascadeType.REFRESH,CascadeType.DETACH}, optional=false,fetch=FetchType.EAGER)
//	@Fetch(value=FetchMode.JOIN) 
	@JoinColumn(name="org_id")
	private Organization org;
	
	@ManyToMany(cascade={CascadeType.ALL},fetch=FetchType.LAZY)
	@JoinTable(name = "t_pms_user_to_role",
		joinColumns = {@JoinColumn(name = "u_id", referencedColumnName = "user_id")},
		inverseJoinColumns = {@JoinColumn(name = "r_id", referencedColumnName ="role_id")})
	private Set<Role> listOfRole = new HashSet<Role>();

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

	public boolean isDelete() {
		return isDelete;
	}

	public void setDelete(boolean isDelete) {
		this.isDelete = isDelete;
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

	public Organization getOrg() {
		return org;
	}

	public void setOrg(Organization org) {
		this.org = org;
	}

	public Set<Role> getListOfRole() {
		return listOfRole;
	}

	public void setListOfRole(Set<Role> listOfRole) {
		this.listOfRole = listOfRole;
	}

}
