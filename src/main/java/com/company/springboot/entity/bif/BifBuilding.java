package com.company.springboot.entity.bif;

import com.company.springboot.base.BaseEntity;

import java.math.BigDecimal;
import java.util.Date;

public class BifBuilding extends BaseEntity {
    private Integer id;

    private BigDecimal longitude;

    private BigDecimal latitude;

    private String province;

    private String city;

    private String district;

    private String buildingName;

    private Boolean flagDeleted;

    private Date createTime;

    private Integer createPerson;

    private Date updateTime;

    private Integer updatePerson;

    private Integer applyId;

    private boolean flagAlongTheStreet;

    private Boolean flagAmend;

    private Boolean flagImport;

    public boolean isFlagAlongTheStreet() {
        return flagAlongTheStreet;
    }

    public void setFlagAlongTheStreet(boolean flagAlongTheStreet) {
        this.flagAlongTheStreet = flagAlongTheStreet;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigDecimal getLongitude() {
        return longitude;
    }

    public void setLongitude(BigDecimal longitude) {
        this.longitude = longitude;
    }

    public BigDecimal getLatitude() {
        return latitude;
    }

    public void setLatitude(BigDecimal latitude) {
        this.latitude = latitude;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province == null ? null : province.trim();
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city == null ? null : city.trim();
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district == null ? null : district.trim();
    }

    public String getBuildingName() {
        return buildingName;
    }

    public void setBuildingName(String buildingName) {
        this.buildingName = buildingName == null ? null : buildingName.trim();
    }

    public Boolean getFlagDeleted() {
        return flagDeleted;
    }

    public void setFlagDeleted(Boolean flagDeleted) {
        this.flagDeleted = flagDeleted;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getCreatePerson() {
        return createPerson;
    }

    public void setCreatePerson(Integer createPerson) {
        this.createPerson = createPerson;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getUpdatePerson() {
        return updatePerson;
    }

    public void setUpdatePerson(Integer updatePerson) {
        this.updatePerson = updatePerson;
    }

    public Integer getApplyId() {
        return applyId;
    }

    public void setApplyId(Integer applyId) {
        this.applyId = applyId;
    }

    public Boolean getFlagAmend() {
        return flagAmend;
    }

    public void setFlagAmend(Boolean flagAmend) {
        this.flagAmend = flagAmend;
    }

    public Boolean getFlagImport() {
        return flagImport;
    }

    public void setFlagImport(Boolean flagImport) {
        this.flagImport = flagImport;
    }

    @Override
    public String toString() {
        return "BifBuilding{" +
                "id=" + id +
                ", longitude=" + longitude +
                ", latitude=" + latitude +
                ", province='" + province + '\'' +
                ", city='" + city + '\'' +
                ", district='" + district + '\'' +
                ", buildingName='" + buildingName + '\'' +
                ", flagDeleted=" + flagDeleted +
                ", createTime=" + createTime +
                ", createPerson=" + createPerson +
                ", updateTime=" + updateTime +
                ", updatePerson=" + updatePerson +
                ", applyId=" + applyId +
                ", flagAlongTheStreet=" + flagAlongTheStreet +
                ", flagAmend=" + flagAmend +
                ", flagImport=" + flagImport +
                '}';
    }
}