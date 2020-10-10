package com.shiant.study.core.system.vo;

import com.shiant.common.BaseVO;

import javax.persistence.Column;
import java.io.Serializable;

public class UniversVo extends BaseVO implements Serializable,Comparable<UniversVo> {

    private static final long serialVersionUID = -3095015730348027315L;

    private Long unId;
    private String unName;
    private String unNameEn;
    private String unAddrCountry;
    private String unAddrState;
    private String unAddrCity;
    private String unAddress;
    private Integer unProfessionalCount;
    private String unLogo;
    private String unIntroduce;
    private String unNature;
    private Long unTuition;

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

    @Override
    public int compareTo(UniversVo o) {
        return 0;
    }
}
