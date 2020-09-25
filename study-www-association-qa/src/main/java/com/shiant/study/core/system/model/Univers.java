package com.shiant.study.core.system.model;

import com.shiant.common.BaseEntity;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "t_sys_univers_copy1")
public class Univers extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 4017357267843186648L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "un_id")
    private Long unId;

    @Column(name = "un_name")
    private String unName;

    @Column(name = "un_name_en")
    private String unNameEn;

    @Column(name = "un_addr_country")
    private String unAddrCountry;

    @Column(name = "un_addr_state")
    private String unAddrState;

    @Column(name = "un_addr_city")
    private String unAddrCity;

    @Column(name = "un_address")
    private String unAddress;

    @Column(name = "un_professional_count")
    private Integer unProfessionalCount;

    @Column(name = "un_logo")
    private String unLogo;

    @Column(name = "un_introduce")
    private String unIntroduce;

    @Column(name = "un_nature")
    private String unNature;

    @Column(name = "un_tuition")
    private Long unTuition;

    public Univers() {

    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getUnId() {
        return unId;
    }

    public void setUnId(Long unId) {
        this.unId = unId;
    }

    public String getUnName() {
        return unName;
    }

    public void setUnName(String unName) {
        this.unName = unName;
    }

    public String getUnNameEn() {
        return unNameEn;
    }

    public void setUnNameEn(String unNameEn) {
        this.unNameEn = unNameEn;
    }

    public String getUnAddrCountry() {
        return unAddrCountry;
    }

    public void setUnAddrCountry(String unAddrCountry) {
        this.unAddrCountry = unAddrCountry;
    }

    public String getUnAddrState() {
        return unAddrState;
    }

    public void setUnAddrState(String unAddrState) {
        this.unAddrState = unAddrState;
    }

    public String getUnAddrCity() {
        return unAddrCity;
    }

    public void setUnAddrCity(String unAddrCity) {
        this.unAddrCity = unAddrCity;
    }

    public String getUnAddress() {
        return unAddress;
    }

    public void setUnAddress(String unAddress) {
        this.unAddress = unAddress;
    }

    public Integer getUnProfessionalCount() {
        return unProfessionalCount;
    }

    public void setUnProfessionalCount(Integer unProfessionalCount) {
        this.unProfessionalCount = unProfessionalCount;
    }

    public String getUnLogo() {
        return unLogo;
    }

    public void setUnLogo(String unLogo) {
        this.unLogo = unLogo;
    }

    public String getUnIntroduce() {
        return unIntroduce;
    }

    public void setUnIntroduce(String unIntroduce) {
        this.unIntroduce = unIntroduce;
    }

    public String getUnNature() {
        return unNature;
    }

    public void setUnNature(String unNature) {
        this.unNature = unNature;
    }

    public Long getUnTuition() {
        return unTuition;
    }

    public void setUnTuition(Long unTuition) {
        this.unTuition = unTuition;
    }

    public Univers(Long unId, String unName, String unNameEn, String unAddrCountry, String unAddrState, String unAddrCity, String unAddress, Integer unProfessionalCount, String unLogo, String unIntroduce, String unNature, Long unTuition) {
        this.unId = unId;
        this.unName = unName;
        this.unNameEn = unNameEn;
        this.unAddrCountry = unAddrCountry;
        this.unAddrState = unAddrState;
        this.unAddrCity = unAddrCity;
        this.unAddress = unAddress;
        this.unProfessionalCount = unProfessionalCount;
        this.unLogo = unLogo;
        this.unIntroduce = unIntroduce;
        this.unNature = unNature;
        this.unTuition = unTuition;
    }
}
