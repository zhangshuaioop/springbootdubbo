package com.company.springboot.entity.bif.ret.BifBuilding;

import java.math.BigDecimal;
import java.util.List;

/**
 * 查询楼宇地址详情-返回结果
 *
 * @author Wujun
 * @create 2017年06月28日 15:08
 */
public class AddressInfoRet {
    private String buildingName;
    private String province;
    private String city;
    private String district;
    private BigDecimal longitude;
    private BigDecimal latitude;
    private List<String> road;
    private String majorRoad;
    private boolean flagAlongTheStreet;
    private boolean flagAmend;

    public boolean isFlagAmend() {
        return flagAmend;
    }

    public void setFlagAmend(boolean flagAmend) {
        this.flagAmend = flagAmend;
    }

    public boolean isFlagAlongTheStreet() {
        return flagAlongTheStreet;
    }

    public void setFlagAlongTheStreet(boolean flagAlongTheStreet) {
        this.flagAlongTheStreet = flagAlongTheStreet;
    }

    public String getMajorRoad() {
        return majorRoad;
    }

    public void setMajorRoad(String majorRoad) {
        this.majorRoad = majorRoad;
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

    public List<String> getRoad() {
        return road;
    }

    public void setRoad(List<String> road) {
        this.road = road;
    }
}
