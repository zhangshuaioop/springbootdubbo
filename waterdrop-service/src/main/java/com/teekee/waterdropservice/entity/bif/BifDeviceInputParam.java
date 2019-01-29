package com.teekee.waterdropservice.entity.bif;

import com.teekee.commoncomponets.base.BaseEntity;

import java.util.Date;
import java.util.List;

public class BifDeviceInputParam extends BaseEntity {
    private Integer storeId;
    private Integer companyId;
    private Integer brandId;
    private Integer seriesId;
    private Integer modelId;
    private Integer catalogId;
    private String deviceSn;
    private Date purchaseDateMin;
    private Date purchaseDateMax;
    private Boolean flagUsable;
    private Boolean flagWarranty;
    private String assetSn;
    private Boolean flagAssign;
    private List<Integer> catalogIdList;
    private Date createTimeMin;
    private Date createTimeMax;

    private String type;
    private Integer typeId;
    private List<Integer> personIdList;
    private String employeeName;
    private String employeeCode;
    private String mobile;
    private String email;

    public List<Integer> getPersonIdList() {
        return personIdList;
    }

    public void setPersonIdList(List<Integer> personIdList) {
        this.personIdList = personIdList;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmployeeCode() {
        return employeeCode;
    }

    public void setEmployeeCode(String employeeCode) {
        this.employeeCode = employeeCode;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getCreateTimeMin() {
        return createTimeMin;
    }

    public void setCreateTimeMin(Date createTimeMin) {
        this.createTimeMin = createTimeMin;
    }

    public Date getCreateTimeMax() {
        return createTimeMax;
    }

    public void setCreateTimeMax(Date createTimeMax) {
        this.createTimeMax = createTimeMax;
    }

    public String getAssetSn() {
        return assetSn;
    }

    public void setAssetSn(String assetSn) {
        this.assetSn = assetSn;
    }

    public Boolean getFlagAssign() {
        return flagAssign;
    }

    public void setFlagAssign(Boolean flagAssign) {
        this.flagAssign = flagAssign;
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

    public Integer getBrandId() {
        return brandId;
    }

    public void setBrandId(Integer brandId) {
        this.brandId = brandId;
    }

    public Integer getSeriesId() {
        return seriesId;
    }

    public void setSeriesId(Integer seriesId) {
        this.seriesId = seriesId;
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

    public String getDeviceSn() {
        return deviceSn;
    }

    public void setDeviceSn(String deviceSn) {
        this.deviceSn = deviceSn;
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

    public List<Integer> getCatalogIdList() {
        return catalogIdList;
    }

    public void setCatalogIdList(List<Integer> catalogIdList) {
        this.catalogIdList = catalogIdList;
    }

    public Date getPurchaseDateMin() {
        return purchaseDateMin;
    }

    public void setPurchaseDateMin(Date purchaseDateMin) {
        this.purchaseDateMin = purchaseDateMin;
    }

    public Date getPurchaseDateMax() {
        return purchaseDateMax;
    }

    public void setPurchaseDateMax(Date purchaseDateMax) {
        this.purchaseDateMax = purchaseDateMax;
    }
}