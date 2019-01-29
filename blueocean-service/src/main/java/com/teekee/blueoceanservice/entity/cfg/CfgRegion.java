package com.teekee.blueoceanservice.entity.cfg;

public class CfgRegion {
    private Integer id;

    private String regionCode;

    private String regionName;

    private Double parentId;

    private Double level;

    private Double orderId;

    private String nameEn;

    private String shortnameEn;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRegionCode() {
        return regionCode;
    }

    public void setRegionCode(String regionCode) {
        this.regionCode = regionCode == null ? null : regionCode.trim();
    }

    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName == null ? null : regionName.trim();
    }

    public Double getParentId() {
        return parentId;
    }

    public void setParentId(Double parentId) {
        this.parentId = parentId;
    }

    public Double getLevel() {
        return level;
    }

    public void setLevel(Double level) {
        this.level = level;
    }

    public Double getOrderId() {
        return orderId;
    }

    public void setOrderId(Double orderId) {
        this.orderId = orderId;
    }

    public String getNameEn() {
        return nameEn;
    }

    public void setNameEn(String nameEn) {
        this.nameEn = nameEn == null ? null : nameEn.trim();
    }

    public String getShortnameEn() {
        return shortnameEn;
    }

    public void setShortnameEn(String shortnameEn) {
        this.shortnameEn = shortnameEn == null ? null : shortnameEn.trim();
    }
}