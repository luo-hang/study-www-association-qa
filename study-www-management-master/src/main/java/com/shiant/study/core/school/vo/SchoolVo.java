package com.shiant.study.core.school.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.shiant.common.BaseVO;

public class SchoolVo extends BaseVO implements Serializable  {

	private static final long serialVersionUID = 5621160359079622723L;
	
	private Long id;
	private String schoolNameC;
	private String schoolNameE;
	private String schoolImg;
	private String schoolLogo;
	private String schooLing;
	private String schoolProperty;
	private String studentsEnrollment;
	private String schoolCountry;
    private String province;
    private String city;
    private String schoolAddress;
	private String schoolAbout;
	private String createDate;
	private String updateDate;
	private List<ProfessionVo> professions = new ArrayList<ProfessionVo>();
	private Long professionNum;
	private String profession;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getSchoolNameC() {
		return schoolNameC;
	}
	public void setSchoolNameC(String schoolNameC) {
		this.schoolNameC = schoolNameC;
	}
	public String getSchoolNameE() {
		return schoolNameE;
	}
	public void setSchoolNameE(String schoolNameE) {
		this.schoolNameE = schoolNameE;
	}
	public String getSchoolImg() {
		return schoolImg;
	}
	public void setSchoolImg(String schoolImg) {
		this.schoolImg = schoolImg;
	}
	public String getSchoolLogo() {
		return schoolLogo;
	}
	public void setSchoolLogo(String schoolLogo) {
		this.schoolLogo = schoolLogo;
	}
	public String getSchooLing() {
		return schooLing;
	}
	public void setSchooLing(String schooLing) {
		this.schooLing = schooLing;
	}
	public String getSchoolProperty() {
		return schoolProperty;
	}
	public void setSchoolProperty(String schoolProperty) {
		this.schoolProperty = schoolProperty;
	}
	public String getStudentsEnrollment() {
		return studentsEnrollment;
	}
	public void setStudentsEnrollment(String studentsEnrollment) {
		this.studentsEnrollment = studentsEnrollment;
	}
	public String getSchoolAddress() {
		return schoolAddress;
	}
	public void setSchoolAddress(String schoolAddress) {
		this.schoolAddress = schoolAddress;
	}
	public String getSchoolCountry() {
		return schoolCountry;
	}
	public void setSchoolCountry(String schoolCountry) {
		this.schoolCountry = schoolCountry;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getSchoolAbout() {
		return schoolAbout;
	}
	public void setSchoolAbout(String schoolAbout) {
		this.schoolAbout = schoolAbout;
	}
	public String getCreateDate() {
		return createDate;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	public String getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}
	public List<ProfessionVo> getProfessions() {
		return professions;
	}
	public void setProfessions(List<ProfessionVo> professions) {
		this.professions = professions;
	}
	public Long getProfessionNum() {
		return professionNum;
	}
	public void setProfessionNum(Long professionNum) {
		this.professionNum = professionNum;
	}
	public String getProfession() {
		return profession;
	}
	public void setProfession(String profession) {
		this.profession = profession;
	}
	
}
