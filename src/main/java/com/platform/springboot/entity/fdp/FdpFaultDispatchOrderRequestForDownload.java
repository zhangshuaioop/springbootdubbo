package com.platform.springboot.entity.fdp;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 导出列表
 *@Author Niting
 *@date: 2018/4/26
 **/
public class FdpFaultDispatchOrderRequestForDownload {
    private String companyName;

    private String storeName;

    private Integer faultOrderId;

    private Integer rootFaultOrderId;

    private String faultOrderNumber;

    private Integer hrCount;

    private String serviceAddress;

    private String serviceProvince;

    private String serviceCity;

    private String serviceDistrict;

    private String otherRequest;

    private String dispatchDescription;

    private String memo;

    private String urgencyRequest;

    private Date serviceDate;

    private Integer serviceTimeStart;

    private Integer serviceTimeEnd;

    private Boolean flagDeleted;

    private Boolean flagAvailable;

    private Boolean flagHasDispatched;

    private Integer createPerson;

    private Date createTime;

    private Integer updatePerson;

    private Date updateTime;

    private String dispatchModelRequest;

    private String equipmentRequest;

    private BigDecimal longitude;

    private BigDecimal latitude;

    private String otherBrand;

    private String sourceType;

    private String otherStore;

    private String backupDeviceRequest;

    private String dealPerson;

    private Integer requestId;

    private String brandName;

    private String userName;

    private Integer lastDealPersonId;

    private String updatePersonName;

    public String getUpdatePersonName() {
        return updatePersonName;
    }

    public void setUpdatePersonName(String updatePersonName) {
        this.updatePersonName = updatePersonName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public Integer getFaultOrderId() {
        return faultOrderId;
    }

    public void setFaultOrderId(Integer faultOrderId) {
        this.faultOrderId = faultOrderId;
    }

    public Integer getRootFaultOrderId() {
        return rootFaultOrderId;
    }

    public void setRootFaultOrderId(Integer rootFaultOrderId) {
        this.rootFaultOrderId = rootFaultOrderId;
    }

    public String getFaultOrderNumber() {
        return faultOrderNumber;
    }

    public void setFaultOrderNumber(String faultOrderNumber) {
        this.faultOrderNumber = faultOrderNumber;
    }

    public Integer getHrCount() {
        return hrCount;
    }

    public void setHrCount(Integer hrCount) {
        this.hrCount = hrCount;
    }

    public String getServiceAddress() {
        return serviceAddress;
    }

    public void setServiceAddress(String serviceAddress) {
        this.serviceAddress = serviceAddress;
    }

    public String getServiceProvince() {
        return serviceProvince;
    }

    public void setServiceProvince(String serviceProvince) {
        this.serviceProvince = serviceProvince;
    }

    public String getServiceCity() {
        return serviceCity;
    }

    public void setServiceCity(String serviceCity) {
        this.serviceCity = serviceCity;
    }

    public String getServiceDistrict() {
        return serviceDistrict;
    }

    public void setServiceDistrict(String serviceDistrict) {
        this.serviceDistrict = serviceDistrict;
    }

    public String getOtherRequest() {
        return otherRequest;
    }

    public void setOtherRequest(String otherRequest) {
        this.otherRequest = otherRequest;
    }

    public String getDispatchDescription() {
        return dispatchDescription;
    }

    public void setDispatchDescription(String dispatchDescription) {
        this.dispatchDescription = dispatchDescription;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public String getUrgencyRequest() {
        return urgencyRequest;
    }

    public void setUrgencyRequest(String urgencyRequest) {
        this.urgencyRequest = urgencyRequest;
    }

    public Date getServiceDate() {
        return serviceDate;
    }

    public void setServiceDate(Date serviceDate) {
        this.serviceDate = serviceDate;
    }

    public Integer getServiceTimeStart() {
        return serviceTimeStart;
    }

    public void setServiceTimeStart(Integer serviceTimeStart) {
        this.serviceTimeStart = serviceTimeStart;
    }

    public Integer getServiceTimeEnd() {
        return serviceTimeEnd;
    }

    public void setServiceTimeEnd(Integer serviceTimeEnd) {
        this.serviceTimeEnd = serviceTimeEnd;
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

    public Boolean getFlagHasDispatched() {
        return flagHasDispatched;
    }

    public void setFlagHasDispatched(Boolean flagHasDispatched) {
        this.flagHasDispatched = flagHasDispatched;
    }

    public Integer getCreatePerson() {
        return createPerson;
    }

    public void setCreatePerson(Integer createPerson) {
        this.createPerson = createPerson;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
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

    public String getDispatchModelRequest() {
        return dispatchModelRequest;
    }

    public void setDispatchModelRequest(String dispatchModelRequest) {
        this.dispatchModelRequest = dispatchModelRequest;
    }

    public String getEquipmentRequest() {
        return equipmentRequest;
    }

    public void setEquipmentRequest(String equipmentRequest) {
        this.equipmentRequest = equipmentRequest;
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

    public String getOtherBrand() {
        return otherBrand;
    }

    public void setOtherBrand(String otherBrand) {
        this.otherBrand = otherBrand;
    }

    public String getSourceType() {
        return sourceType;
    }

    public void setSourceType(String sourceType) {
        this.sourceType = sourceType;
    }

    public String getOtherStore() {
        return otherStore;
    }

    public void setOtherStore(String otherStore) {
        this.otherStore = otherStore;
    }

    public String getBackupDeviceRequest() {
        return backupDeviceRequest;
    }

    public void setBackupDeviceRequest(String backupDeviceRequest) {
        this.backupDeviceRequest = backupDeviceRequest;
    }

    public String getDealPerson() {
        return dealPerson;
    }

    public void setDealPerson(String dealPerson) {
        this.dealPerson = dealPerson;
    }

    public Integer getRequestId() {
        return requestId;
    }

    public void setRequestId(Integer requestId) {
        this.requestId = requestId;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getLastDealPersonId() {
        return lastDealPersonId;
    }

    public void setLastDealPersonId(Integer lastDealPersonId) {
        this.lastDealPersonId = lastDealPersonId;
    }
}


