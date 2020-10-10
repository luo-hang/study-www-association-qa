package com.shiant.study.core.school.model;

import com.shiant.common.BaseEntity;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @program: study-www-association
 * @description
 * @author: z p、
 * @create: 2020-09-17 14:28
 **/
@Entity
@DynamicUpdate
@DynamicInsert
@Table(name = "t_study_school")
public class School extends BaseEntity implements Serializable {

	private static final long serialVersionUID = -3815392151153765717L;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "school_name_c")
    private String schoolNameC;

    @Column(name = "school_name_e")
    private String schoolNameE;

    @Column(name = "school_img")
    private String schoolImg;

    @Column(name = "school_logo")
    private String schoolLogo;

    @Column(name = "schooling")
    private String schooLing;	//学费

    @Column(name = "school_property")
    private String schoolProperty;	//院校性质

    @Column(name = "new_students_enrollment")
    private String studentsEnrollment;	//招生人数

    @Column(name = "school_country")
    private String schoolCountry;
    
    @Column(name = "province")
    private String province;
    
    @Column(name = "city")
    private String city;
    
    @Column(name = "school_address")
    private String schoolAddress;

    @Column(name = "school_about")
    private String schoolAbout;

    @Column(name = "create_date")
    // @Temporal(TemporalType.TIMESTAMP)
    private String createDate;

    @Column(name = "update_date")
    // @Temporal(TemporalType.TIMESTAMP)
    private String updateDate;

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

	public School() {
    }

    public School(String schoolNameC, String schoolNameE, String schoolLogo, String schooLing, String schoolProperty, String studentsEnrollment, String schoolAddress, String schoolAbout, String createDate, String updateDate) {
        this.schoolNameC = schoolNameC;
        this.schoolNameE = schoolNameE;
        this.schoolLogo = schoolLogo;
        this.schooLing = schooLing;
        this.schoolProperty = schoolProperty;
        this.studentsEnrollment = studentsEnrollment;
        this.schoolAddress = schoolAddress;
        this.schoolAbout = schoolAbout;
        this.createDate = createDate;
        this.updateDate = updateDate;
    }
}
