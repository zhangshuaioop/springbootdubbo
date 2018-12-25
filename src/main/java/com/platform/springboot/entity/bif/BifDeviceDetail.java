package com.platform.springboot.entity.bif;

import com.platform.springboot.base.BaseEntity;
import com.platform.springboot.base.BaseEntity;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class BifDeviceDetail extends BaseEntity {
    private Integer id;

    private String deviceName;

    private String deviceSn;

    private Integer modelId;

    private Integer catalogId;

    private Boolean flagDeleted;

    private Boolean flagAvailable;

    private Date createTime;
    private Date createTimeMax;
    private Date createTimeMin;

    private Integer createPerson;

    private Date updateTime;

    private Integer updatePerson;

    private String memo;
    private String storeMemo;

    public String getStoreMemo() {
        return storeMemo;
    }

    public void setStoreMemo(String storeMemo) {
        this.storeMemo = storeMemo;
    }

    private Date beginTime;

    private Date endTime;

    private Integer seriesId;
    private String series;

    private Integer brandId;

    private Integer flagUse;

    private String brand;

    private String model;

    private String catalogName;

    private String assetSn;

    private Date purchaseDateMax;
    private Date purchaseDateMin;
    private Integer companyId;

    private Date purchaseDate;

    private Integer deviceCompanyRelationId;

    private String childNode;
    private String fatherNode;
    private String grandFatherNode;

    private Integer deviceStoreRelationId;

    private Date installDate;
    private Date installDateMax;
    private Date installDateMin;

    private Integer storeId;

    private Date expireDate;
    private String deviceCompanyRelationMemo;
    private String deviceStoreRelationMemo;

    private Date uninstallDate;

    private String supplyCompanyName;
    private BigDecimal purchasePrice;
    private String monetaryUnit;
    private Date warrantyExpireDate;
    private Date useExpireDate;
    private String techParam;
    private Boolean flagUsable;
    private Boolean flagWarranty;
    private Integer supplyCompanyId;
    private Date startUsingDate;

    private Date assignDate;
    private String assignType;
    private String assignTypeName;
    private String org;
    private Integer assignId;

    public Integer getAssignId() {
        return assignId;
    }

    public void setAssignId(Integer assignId) {
        this.assignId = assignId;
    }

    public Date getAssignDate() {
        return assignDate;
    }

    public void setAssignDate(Date assignDate) {
        this.assignDate = assignDate;
    }

    public String getAssignType() {
        return assignType;
    }

    public void setAssignType(String assignType) {
        this.assignType = assignType;
    }

    public String getAssignTypeName() {
        return assignTypeName;
    }

    public void setAssignTypeName(String assignTypeName) {
        this.assignTypeName = assignTypeName;
    }

    public String getOrg() {
        return org;
    }

    public void setOrg(String org) {
        this.org = org;
    }

    private List<BifDeviceUploadFile> deviceUploadFileList;

    public List<BifDeviceUploadFile> getDeviceUploadFileList() {
        return deviceUploadFileList;
    }

    public void setDeviceUploadFileList(List<BifDeviceUploadFile> deviceUploadFileList) {
        this.deviceUploadFileList = deviceUploadFileList;
    }

    public Date getStartUsingDate() {
        return startUsingDate;
    }

    public void setStartUsingDate(Date startUsingDate) {
        this.startUsingDate = startUsingDate;
    }

    public Integer getSupplyCompanyId() {
        return supplyCompanyId;
    }

    public void setSupplyCompanyId(Integer supplyCompanyId) {
        this.supplyCompanyId = supplyCompanyId;
    }

    public String getTechParam() {
        return techParam;
    }

    public void setTechParam(String techParam) {
        this.techParam = techParam;
    }

    public Boolean getFlagUsable() {
        return flagUsable;
    }

    public void setFlagUsable(Boolean flagUsable) {
        this.flagUsable = flagUsable;
    }

    public Boolean getFlagWarranty() {
        return flagWarranty;
    }

    public void setFlagWarranty(Boolean flagWarranty) {
        this.flagWarranty = flagWarranty;
    }

    public String getSupplyCompanyName() {
        return supplyCompanyName;
    }

    public void setSupplyCompanyName(String supplyCompanyName) {
        this.supplyCompanyName = supplyCompanyName;
    }

    public BigDecimal getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(BigDecimal purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public String getMonetaryUnit() {
        return monetaryUnit;
    }

    public void setMonetaryUnit(String monetaryUnit) {
        this.monetaryUnit = monetaryUnit;
    }

    public Date getWarrantyExpireDate() {
        return warrantyExpireDate;
    }

    public void setWarrantyExpireDate(Date warrantyExpireDate) {
        this.warrantyExpireDate = warrantyExpireDate;
    }

    public Date getUseExpireDate() {
        return useExpireDate;
    }

    public void setUseExpireDate(Date useExpireDate) {
        this.useExpireDate = useExpireDate;
    }

    public String getGrandFatherNode() {
        return grandFatherNode;
    }

    public void setGrandFatherNode(String grandFatherNode) {
        this.grandFatherNode = grandFatherNode;
    }

    public String getDeviceStoreRelationMemo() {
        return deviceStoreRelationMemo;
    }

    public void setDeviceStoreRelationMemo(String deviceStoreRelationMemo) {
        this.deviceStoreRelationMemo = deviceStoreRelationMemo;
    }

    public Date getUninstallDate() {
        return uninstallDate;
    }

    public void setUninstallDate(Date uninstallDate) {
        this.uninstallDate = uninstallDate;
    }

    public Date getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(Date expireDate) {
        this.expireDate = expireDate;
    }

    public String getDeviceCompanyRelationMemo() {
        return deviceCompanyRelationMemo;
    }

    public void setDeviceCompanyRelationMemo(String deviceCompanyRelationMemo) {
        this.deviceCompanyRelationMemo = deviceCompanyRelationMemo;
    }

    public Integer getStoreId() {
        return storeId;
    }

    public void setStoreId(Integer storeId) {
        this.storeId = storeId;
    }

    public Date getInstallDate() {
        return installDate;
    }

    public void setInstallDate(Date installDate) {
        this.installDate = installDate;
    }

    public Date getInstallDateMax() {
        return installDateMax;
    }

    public void setInstallDateMax(Date installDateMax) {
        this.installDateMax = installDateMax;
    }

    public Date getInstallDateMin() {
        return installDateMin;
    }

    public void setInstallDateMin(Date installDateMin) {
        this.installDateMin = installDateMin;
    }

    public Integer getDeviceStoreRelationId() {
        return deviceStoreRelationId;
    }

    public void setDeviceStoreRelationId(Integer deviceStoreRelationId) {
        this.deviceStoreRelationId = deviceStoreRelationId;
    }

    public String getSeries() {
        return series;
    }

    public void setSeries(String series) {
        this.series = series;
    }

    public String getChildNode() {
        return childNode;
    }

    public void setChildNode(String childNode) {
        this.childNode = childNode;
    }

    public String getFatherNode() {
        return fatherNode;
    }

    public void setFatherNode(String fatherNode) {
        this.fatherNode = fatherNode;
    }

    public Integer getDeviceCompanyRelationId() {
        return deviceCompanyRelationId;
    }

    public void setDeviceCompanyRelationId(Integer deviceCompanyRelationId) {
        this.deviceCompanyRelationId = deviceCompanyRelationId;
    }

    public Date getCreateTimeMax() {
        return createTimeMax;
    }

    public void setCreateTimeMax(Date createTimeMax) {
        this.createTimeMax = createTimeMax;
    }

    public Date getCreateTimeMin() {
        return createTimeMin;
    }

    public void setCreateTimeMin(Date createTimeMin) {
        this.createTimeMin = createTimeMin;
    }

    public Date getPurchaseDateMax() {
        return purchaseDateMax;
    }

    public void setPurchaseDateMax(Date purchaseDateMax) {
        this.purchaseDateMax = purchaseDateMax;
    }

    public Date getPurchaseDateMin() {
        return purchaseDateMin;
    }

    public void setPurchaseDateMin(Date purchaseDateMin) {
        this.purchaseDateMin = purchaseDateMin;
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public Date getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(Date purchaseDate) {
        this.purchaseDate = purchaseDate;
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

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Integer getFlagUse() {
        return flagUse;
    }

    public void setFlagUse(Integer flagUse) {
        this.flagUse = flagUse;
    }

    public Integer getSeriesId() {
        return seriesId;
    }

    public void setSeriesId(Integer seriesId) {
        this.seriesId = seriesId;
    }

    public Integer getBrandId() {
        return brandId;
    }

    public void setBrandId(Integer brandId) {
        this.brandId = brandId;
    }

    public Date getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(Date beginTime) {
        this.beginTime = beginTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
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
        this.deviceName = deviceName == null ? null : deviceName.trim();
    }

    public String getDeviceSn() {
        return deviceSn;
    }

    public void setDeviceSn(String deviceSn) {
        this.deviceSn = deviceSn == null ? null : deviceSn.trim();
    }

    public Integer getModelId() {
        return modelId;
    }

    public void setModelId(Integer modelId) {
        this.modelId = modelId;
    }

    public Integer getCatalogId() {
        return catalogId;
    }

    public void setCatalogId(Integer catalogId) {
        this.catalogId = catalogId;
    }

    public Boolean getFlagDeleted() {
        return flagDeleted;
    }

    public void setFlagDeleted(Boolean flagDeleted) {
        this.flagDeleted = flagDeleted;
    }

    public Boolean getFlagAvailable() {
        return flagAvailable;
    }

    public void setFlagAvailable(Boolean flagAvailable) {
        this.flagAvailable = flagAvailable;
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

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo == null ? null : memo.trim();
    }

}