package com.platform.springboot.entity.dmi;

import java.util.Date;

public class DmiCommProductSpecialLine {
    private Integer id;

    private Integer storeId;

    private Integer companyId;

    private Integer productId;

    private Integer aStoreId;

    private Integer aAddressId;

    private String aPortType;

    private Integer aBandWidth;

    private String aBandWidthType;

    private String aLocalCode;

    private Integer zStoreId;

    private Integer zAddressId;

    private String zPortType;

    private Integer zBandWidth;

    private String zBandWidthType;

    private String zLocalCode;

    private Integer bandWidth;

    private String bandWidthType;

    private Boolean flagDeleted;

    private Date createTime;

    private Integer createPerson;

    private Integer updatePerson;

    private Date updateTime;

    public Integer getBandWidth() {
        return bandWidth;
    }

    public void setBandWidth(Integer bandWidth) {
        this.bandWidth = bandWidth;
    }

    public String getBandWidthType() {
        return bandWidthType;
    }

    public void setBandWidthType(String bandWidthType) {
        this.bandWidthType = bandWidthType;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getStoreId() {
        return storeId;
    }

    public void setStoreId(Integer storeId) {
        this.storeId = storeId;
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getaStoreId() {
        return aStoreId;
    }

    public void setaStoreId(Integer aStoreId) {
        this.aStoreId = aStoreId;
    }

    public Integer getaAddressId() {
        return aAddressId;
    }

    public void setaAddressId(Integer aAddressId) {
        this.aAddressId = aAddressId;
    }

    public String getaPortType() {
        return aPortType;
    }

    public void setaPortType(String aPortType) {
        this.aPortType = aPortType == null ? null : aPortType.trim();
    }

    public Integer getaBandWidth() {
        return aBandWidth;
    }

    public void setaBandWidth(Integer aBandWidth) {
        this.aBandWidth = aBandWidth;
    }

    public String getaBandWidthType() {
        return aBandWidthType;
    }

    public void setaBandWidthType(String aBandWidthType) {
        this.aBandWidthType = aBandWidthType == null ? null : aBandWidthType.trim();
    }

    public String getaLocalCode() {
        return aLocalCode;
    }

    public void setaLocalCode(String aLocalCode) {
        this.aLocalCode = aLocalCode == null ? null : aLocalCode.trim();
    }

    public Integer getzStoreId() {
        return zStoreId;
    }

    public void setzStoreId(Integer zStoreId) {
        this.zStoreId = zStoreId;
    }

    public Integer getzAddressId() {
        return zAddressId;
    }

    public void setzAddressId(Integer zAddressId) {
        this.zAddressId = zAddressId;
    }

    public String getzPortType() {
        return zPortType;
    }

    public void setzPortType(String zPortType) {
        this.zPortType = zPortType == null ? null : zPortType.trim();
    }

    public Integer getzBandWidth() {
        return zBandWidth;
    }

    public void setzBandWidth(Integer zBandWidth) {
        this.zBandWidth = zBandWidth;
    }

    public String getzBandWidthType() {
        return zBandWidthType;
    }

    public void setzBandWidthType(String zBandWidthType) {
        this.zBandWidthType = zBandWidthType == null ? null : zBandWidthType.trim();
    }

    public String getzLocalCode() {
        return zLocalCode;
    }

    public void setzLocalCode(String zLocalCode) {
        this.zLocalCode = zLocalCode == null ? null : zLocalCode.trim();
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

    public Integer getUpdatePerson() {
        return updatePerson;
    }

    public void setUpdatePerson(Integer updatePerson) {
        this.updatePerson = updatePerson;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}