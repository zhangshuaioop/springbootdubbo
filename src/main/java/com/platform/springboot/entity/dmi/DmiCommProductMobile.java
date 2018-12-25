package com.platform.springboot.entity.dmi;

import java.util.Date;

public class DmiCommProductMobile {
    private Integer id;

    private Integer storeId;

    private Integer companyId;

    private Integer productId;

    private String puk;

    private String networkType;

    private String useType;

    private Integer capacity;

    private String unitBandWidth;

    private String offLimitsOperator;

    private String useRate;

    private Boolean flagDdd;

    private Boolean flagIdd;

    private Boolean flagDeleted;

    private Date createTime;

    private Integer createPerson;

    private Integer updatePerson;

    private Date updateTime;

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

    public String getPuk() {
        return puk;
    }

    public void setPuk(String puk) {
        this.puk = puk == null ? null : puk.trim();
    }

    public String getNetworkType() {
        return networkType;
    }

    public void setNetworkType(String networkType) {
        this.networkType = networkType == null ? null : networkType.trim();
    }

    public String getUseType() {
        return useType;
    }

    public void setUseType(String useType) {
        this.useType = useType == null ? null : useType.trim();
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public String getUnitBandWidth() {
        return unitBandWidth;
    }

    public void setUnitBandWidth(String unitBandWidth) {
        this.unitBandWidth = unitBandWidth == null ? null : unitBandWidth.trim();
    }

    public String getOffLimitsOperator() {
        return offLimitsOperator;
    }

    public void setOffLimitsOperator(String offLimitsOperator) {
        this.offLimitsOperator = offLimitsOperator == null ? null : offLimitsOperator.trim();
    }

    public String getUseRate() {
        return useRate;
    }

    public void setUseRate(String useRate) {
        this.useRate = useRate == null ? null : useRate.trim();
    }

    public Boolean getFlagDdd() {
        return flagDdd;
    }

    public void setFlagDdd(Boolean flagDdd) {
        this.flagDdd = flagDdd;
    }

    public Boolean getFlagIdd() {
        return flagIdd;
    }

    public void setFlagIdd(Boolean flagIdd) {
        this.flagIdd = flagIdd;
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