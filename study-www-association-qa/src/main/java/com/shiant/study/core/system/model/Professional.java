package com.shiant.study.core.system.model;

import com.shiant.common.BaseEntity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "t_sys_professional")
public class Professional extends BaseEntity implements Serializable  {

    private static final long serialVersionUID = 536434544756673939L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pro_id")
    private Long proId;

    @Column(name = "pro_name")
    private String proName;

    @Column(name = "pro_college")
    private String proCollege;

    @Column(name = "pro_degree")
    private String proDegree;

    @Column(name = "pro_advantage")
    private String proAdvantage;

    @Column(name = "pro_semester")
    private Integer proSemester;

    @Column(name = "pro_tuition")
    private Long proTuition;

    public Professional (){

    }


    public Long getProId() {
        return proId;
    }

    public void setProId(Long proId) {
        this.proId = proId;
    }

    public String getProName() {
        return proName;
    }

    public void setProName(String proName) {
        this.proName = proName;
    }

    public String getProCollege() {
        return proCollege;
    }

    public void setProCollege(String proCollege) {
        this.proCollege = proCollege;
    }

    public String getProDegree() {
        return proDegree;
    }

    public void setProDegree(String proDegree) {
        this.proDegree = proDegree;
    }

    public String getProAdvantage() {
        return proAdvantage;
    }

    public void setProAdvantage(String proAdvantage) {
        this.proAdvantage = proAdvantage;
    }

    public Integer getProSemester() {
        return proSemester;
    }

    public void setProSemester(Integer proSemester) {
        this.proSemester = proSemester;
    }

    public Long getProTuition() {
        return proTuition;
    }

    public void setProTuition(Long proTuition) {
        this.proTuition = proTuition;
    }

    public Professional(Long proId, String proName, String proCollege, String proDegree, String proAdvantage, Integer proSemester, Long proTuition) {
        this.proId = proId;
        this.proName = proName;
        this.proCollege = proCollege;
        this.proDegree = proDegree;
        this.proAdvantage = proAdvantage;
        this.proSemester = proSemester;
        this.proTuition = proTuition;
    }

}
