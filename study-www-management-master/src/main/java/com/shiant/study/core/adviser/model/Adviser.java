package com.shiant.study.core.adviser.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="t_study_adviser")
public class Adviser implements Serializable {

	private static final long serialVersionUID = 5951369755031720354L;

	@Id
	@Column(name="aid")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long aid;

	@Column(name="name")
	private String name;
	
	@Column(name="cover_file")
	private String coverFile;
	
	@Column(name="title")
	private String title;//职称
	
	@Column(name="background")
	private String background;//教育背景
	
	@Column(name="working_time")
	private String workingTime;//从业时间

	@Column(name="items")
	private String items;//主要项目
	
	@Column(name="city")
	private String city;//所在城市

	@Column(name="content")
	private String content;
	
	@Column(name="[order]")
	private Integer order;
	
	@Column(name="org_id")
	private Long orgid;

	@Column(name="org_name")
	private String orgName;

	@Column(name="show_time")
	private Long showTime;
	
	@Column(name="create_date")
	private Date createDate;

	@Column(name="update_date")
	private Date updateDate;
	
	@Column(name="creater")
	private String creater;
	
	@Column(name="updater")
	private String updater;
	
	@Column(name="is_public")
	private boolean isPublic;
	
	@Column(name="ability_1")
	private String ability1;
	
	@Column(name="ability_2")
	private String ability2;
	
	@Column(name="ability_3")
	private String ability3;
	
	@Column(name="ability_4")
	private String ability4;
	
	@Column(name="ability_5")
	private String ability5;
	
	@Column(name="ability_6")
	private String ability6;
	
	@Column(name="ability_7")
	private String ability7;
	
	@Column(name="ability_8")
	private String ability8;
	
	@Column(name="ability_9")
	private String ability9;
	
	@Column(name="ability_10")
	private String ability10;
	
	@Column(name="ability_11")
	private String ability11;
	
	@Column(name="ability_12")
	private String ability12;
	
	@Column(name="ability_13")
	private String ability13;
	
	@Column(name="ability_14")
	private String ability14;
	
	@Column(name="ability_15")
	private String ability15;
	
	@Column(name="ability_16")
	private String ability16;
	
	@Column(name="ability_17")
	private String ability17;
	
	@Column(name="ability_18")
	private String ability18;
	
	@Column(name="ability_19")
	private String ability19;
	
	@Column(name="ability_20")
	private String ability20;

	public Long getAid() {
		return aid;
	}

	public void setAid(Long aid) {
		this.aid = aid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public String getBackground() {
		return background;
	}

	public void setBackground(String background) {
		this.background = background;
	}

	public String getWorkingTime() {
		return workingTime;
	}

	public void setWorkingTime(String workingTime) {
		this.workingTime = workingTime;
	}

	public String getItems() {
		return items;
	}

	public void setItems(String items) {
		this.items = items;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
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

	public boolean isPublic() {
		return isPublic;
	}

	public void setPublic(boolean isPublic) {
		this.isPublic = isPublic;
	}

	public String getAbility1() {
		return ability1;
	}

	public void setAbility1(String ability1) {
		this.ability1 = ability1;
	}

	public String getAbility2() {
		return ability2;
	}

	public void setAbility2(String ability2) {
		this.ability2 = ability2;
	}

	public String getAbility3() {
		return ability3;
	}

	public void setAbility3(String ability3) {
		this.ability3 = ability3;
	}

	public String getAbility4() {
		return ability4;
	}

	public void setAbility4(String ability4) {
		this.ability4 = ability4;
	}

	public String getAbility5() {
		return ability5;
	}

	public void setAbility5(String ability5) {
		this.ability5 = ability5;
	}

	public String getAbility6() {
		return ability6;
	}

	public void setAbility6(String ability6) {
		this.ability6 = ability6;
	}

	public String getAbility7() {
		return ability7;
	}

	public void setAbility7(String ability7) {
		this.ability7 = ability7;
	}

	public String getAbility8() {
		return ability8;
	}

	public void setAbility8(String ability8) {
		this.ability8 = ability8;
	}

	public String getAbility9() {
		return ability9;
	}

	public void setAbility9(String ability9) {
		this.ability9 = ability9;
	}

	public String getAbility10() {
		return ability10;
	}

	public void setAbility10(String ability10) {
		this.ability10 = ability10;
	}

	public String getAbility11() {
		return ability11;
	}

	public void setAbility11(String ability11) {
		this.ability11 = ability11;
	}

	public String getAbility12() {
		return ability12;
	}

	public void setAbility12(String ability12) {
		this.ability12 = ability12;
	}

	public String getAbility13() {
		return ability13;
	}

	public void setAbility13(String ability13) {
		this.ability13 = ability13;
	}

	public String getAbility14() {
		return ability14;
	}

	public void setAbility14(String ability14) {
		this.ability14 = ability14;
	}

	public String getAbility15() {
		return ability15;
	}

	public void setAbility15(String ability15) {
		this.ability15 = ability15;
	}

	public String getAbility16() {
		return ability16;
	}

	public void setAbility16(String ability16) {
		this.ability16 = ability16;
	}

	public String getAbility17() {
		return ability17;
	}

	public void setAbility17(String ability17) {
		this.ability17 = ability17;
	}

	public String getAbility18() {
		return ability18;
	}

	public void setAbility18(String ability18) {
		this.ability18 = ability18;
	}

	public String getAbility19() {
		return ability19;
	}

	public void setAbility19(String ability19) {
		this.ability19 = ability19;
	}

	public String getAbility20() {
		return ability20;
	}

	public void setAbility20(String ability20) {
		this.ability20 = ability20;
	}

}
