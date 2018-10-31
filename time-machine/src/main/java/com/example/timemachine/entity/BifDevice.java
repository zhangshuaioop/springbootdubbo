package com.example.timemachine.entity;

import com.example.timemachine.base.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

@ApiModel(value = "设备基本信息")
public class BifDevice extends BaseEntity {
    @ApiModelProperty(value = "id", example = "1", required = true)
    private Integer id;

    @ApiModelProperty(value = "deviceName", example = "1", required = true)
    private String deviceName;

    private String deviceSn;

    private String brand;

    private String model;

    private Integer modelId;

    private Integer catalogId;

    private String techParam;

    private Boolean flagDeleted;

    private Boolean flagUsable;

    private Boolean flagWarranty;

    private Date warrantyExpireDate;

    private Date useExpireDate;

    private Date createTime;

    private Integer createPerson;

    private Date updateTime;

    private Integer updatePerson;

    private String memo;

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

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand == null ? null : brand.trim();
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model == null ? null : model.trim();
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

    public String getTechParam() {
        return techParam;
    }

    public void setTechParam(String techParam) {
        this.techParam = techParam == null ? null : techParam.trim();
    }

    public Boolean getFlagDeleted() {
        return flagDeleted;
    }

    public void setFlagDeleted(Boolean flagDeleted) {
        this.flagDeleted = flagDeleted;
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