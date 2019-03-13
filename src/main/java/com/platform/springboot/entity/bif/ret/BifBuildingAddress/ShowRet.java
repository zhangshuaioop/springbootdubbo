package com.platform.springboot.entity.bif.ret.BifBuildingAddress;

import java.math.BigDecimal;

/**
 * 查询地址详情-返回结果
 *
 * @author Wujun
 * @create 2017年06月29日 18:09
 */
public class ShowRet {
    private BigDecimal longitude;

    private BigDecimal latitude;

    private String province;

    private String city;

    private String district;

    private String buildingName;

    private String road;

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

    public String getBuildingName() {
        return buildingName;
    }

    public void setBuildingName(String buildingName) {
        this.buildingName = buildingName;
    }

    public String getRoad() {
        return road;
    }

    public void setRoad(String road) {
        this.road = road;
    }
}
