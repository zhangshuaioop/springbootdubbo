package com.teekee.blueoceanservice.entity.bif.ret.BifBuilding;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 根据省市区和楼宇名（模糊查询），获取楼列表-返回结果
 *
 * @author Wujun
 * @create 2017年06月28日 14:34
 */
public class ListRet {
    private Integer id;
    private String buildingName;
    private String province;
    private String city;
    private String district;
    private String road;
    private Date createTime;
    private String createPerson;
    private BigDecimal longitude;
    private BigDecimal latitude;
    private Integer addressId;
    private Date updateTime;
    private Boolean flagImport;

    public Boolean getFlagImport() {
        return flagImport;
    }

    public void setFlagImport(Boolean flagImport) {
        this.flagImport = flagImport;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getAddressId() {
        return addressId;
    }

    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBuildingName() {
        return buildingName;
    }

    public void setBuildingName(String buildingName) {
        this.buildingName = buildingName;
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

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getRoad() {
        return road;
    }

    public void setRoad(String road) {
        this.road = road;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getCreatePerson() {
        return createPerson;
    }

    public void setCreatePerson(String createPerson) {
        this.createPerson = createPerson;
    }
}
