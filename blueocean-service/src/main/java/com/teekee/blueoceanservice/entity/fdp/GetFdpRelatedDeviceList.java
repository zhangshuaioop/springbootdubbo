package com.teekee.blueoceanservice.entity.fdp;

import java.util.Date;

/**
 * @Author Niting
 * @date 2018/6/26
 **/
public class GetFdpRelatedDeviceList {
    private Integer id;
    private Integer faultOrderProcessId;
    private Integer deviceId;
    private Integer storeId;
    private Integer deviceAssignId;
    private String deviceName;
    private String deviceSn;
    private String assetSn;
    private String brand;
    private String model;
    private String createPerson;
    private Date warrantyExpireDate;
    private String catalogName;
    private Date assignDate;
    private Date createTime;

    public String getAssetSn() {
        return assetSn;
    }

    public void setAssetSn(String assetSn) {
        this.assetSn = assetSn;
    }

    public String getCreatePerson() {
        return createPerson;
    }

    public void setCreatePerson(String createPerson) {
        this.createPerson = createPerson;
    }

    public Date getWarrantyExpireDate() {
        return warrantyExpireDate;
    }

    public void setWarrantyExpireDate(Date warrantyExpireDate) {
        this.warrantyExpireDate = warrantyExpireDate;
    }

    public String getCatalogName() {
        return catalogName;
    }

    public void setCatalogName(String catalogName) {
        this.catalogName = catalogName;
    }

    public Date getAssignDate() {
        return assignDate;
    }

    public void setAssignDate(Date assignDate) {
        this.assignDate = assignDate;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getFaultOrderProcessId() {
        return faultOrderProcessId;
    }

    public void setFaultOrderProcessId(Integer faultOrderProcessId) {
        this.faultOrderProcessId = faultOrderProcessId;
    }

    public Integer getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(Integer deviceId) {
        this.deviceId = deviceId;
    }

    public Integer getStoreId() {
        return storeId;
    }

    public void setStoreId(Integer storeId) {
        this.storeId = storeId;
    }

    public Integer getDeviceAssignId() {
        return deviceAssignId;
    }

    public void setDeviceAssignId(Integer deviceAssignId) {
        this.deviceAssignId = deviceAssignId;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public String getDeviceSn() {
        return deviceSn;
    }

    public void setDeviceSn(String deviceSn) {
        this.deviceSn = deviceSn;
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
}
