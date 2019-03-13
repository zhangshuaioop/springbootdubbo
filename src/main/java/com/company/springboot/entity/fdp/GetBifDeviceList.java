package com.company.springboot.entity.fdp;

import java.util.Date;

/**
 * @Author Niting
 * @date 2018/6/27
 **/
public class GetBifDeviceList {
    private Integer AssignId;
    private String deviceName;
    private String brand;
    private String model;
    private String deviceSn;
    private String assetSn;
    private String catalogName;
    private Integer deviceStoreRelationId;
    private Integer deviceCompanyRelationId;
    private String deviceCompanyRelationMemo;
    private String assignType;
    private Date updateTime;
    private Integer id;
    private Date warrantyExpireDate;
    private Date createTime;
    private Date assignDate;
    private boolean flagUsed;

    public boolean isFlagUsed() {
        return flagUsed;
    }

    public void setFlagUsed(boolean flagUsed) {
        this.flagUsed = flagUsed;
    }
    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Date getWarrantyExpireDate() {
        return warrantyExpireDate;
    }

    public void setWarrantyExpireDate(Date warrantyExpireDate) {
        this.warrantyExpireDate = warrantyExpireDate;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getAssignDate() {
        return assignDate;
    }

    public void setAssignDate(Date assignDate) {
        this.assignDate = assignDate;
    }

    public Integer getAssignId() {
        return AssignId;
    }

    public void setAssignId(Integer assignId) {
        AssignId = assignId;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getDeviceSn() {
        return deviceSn;
    }

    public void setDeviceSn(String deviceSn) {
        this.deviceSn = deviceSn;
    }

    public String getAssetSn() {
        return assetSn;
    }

    public void setAssetSn(String assetSn) {
        this.assetSn = assetSn;
    }

    public String getCatalogName() {
        return catalogName;
    }

    public void setCatalogName(String catalogName) {
        this.catalogName = catalogName;
    }

    public Integer getDeviceStoreRelationId() {
        return deviceStoreRelationId;
    }

    public void setDeviceStoreRelationId(Integer deviceStoreRelationId) {
        this.deviceStoreRelationId = deviceStoreRelationId;
    }

    public Integer getDeviceCompanyRelationId() {
        return deviceCompanyRelationId;
    }

    public void setDeviceCompanyRelationId(Integer deviceCompanyRelationId) {
        this.deviceCompanyRelationId = deviceCompanyRelationId;
    }

    public String getDeviceCompanyRelationMemo() {
        return deviceCompanyRelationMemo;
    }

    public void setDeviceCompanyRelationMemo(String deviceCompanyRelationMemo) {
        this.deviceCompanyRelationMemo = deviceCompanyRelationMemo;
    }

    public String getAssignType() {
        return assignType;
    }

    public void setAssignType(String assignType) {
        this.assignType = assignType;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
