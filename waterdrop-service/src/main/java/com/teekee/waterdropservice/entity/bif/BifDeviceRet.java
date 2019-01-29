package com.teekee.waterdropservice.entity.bif;

import com.teekee.commoncomponets.base.BaseEntity;

import java.util.Date;

public class BifDeviceRet extends BaseEntity {
    private Integer id;
    private String deviceName;
    private String brand;
    private String model;
    private String catalogName;
    private String deviceSn;
    private String assetSn;
    private Date createTime;
    private String status;
    private String warrantySituation;
    private Date purchaseDate;
    private String flagAssign;

    private String assignType;
    private String assignName;
    private Integer assignId;
    private Integer assignEmployeeId;

    private Date updateTime;

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public void setAssignId(Integer assignId) {
        this.assignId = assignId;
    }

    public Integer getAssignEmployeeId() {
        return assignEmployeeId;
    }

    public void setAssignEmployeeId(Integer assignEmployeeId) {
        this.assignEmployeeId = assignEmployeeId;
    }

    public Integer getAssignId() {
        return assignId;
    }

    public String getAssignType() {
        return assignType;
    }

    public void setAssignType(String assignType) {
        this.assignType = assignType;
    }

    public String getAssignName() {
        return assignName;
    }

    public void setAssignName(String assignName) {
        this.assignName = assignName;
    }

    public String getFlagAssign() {
        return flagAssign;
    }

    public void setFlagAssign(String flagAssign) {
        this.flagAssign = flagAssign;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getCatalogName() {
        return catalogName;
    }

    public void setCatalogName(String catalogName) {
        this.catalogName = catalogName;
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

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getWarrantySituation() {
        return warrantySituation;
    }

    public void setWarrantySituation(String warrantySituation) {
        this.warrantySituation = warrantySituation;
    }

    public Date getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(Date purchaseDate) {
        this.purchaseDate = purchaseDate;
    }
}