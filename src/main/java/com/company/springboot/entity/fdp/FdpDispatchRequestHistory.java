package com.company.springboot.entity.fdp;

import java.math.BigDecimal;
import java.util.Date;

public class FdpDispatchRequestHistory {
    private Integer id;

    private Integer companyId;

    private Integer storeId;

    private Integer faultOrderId;

    private Integer rootFaultOrderId;

    private String faultOrderNumber;

    private Integer hrCount;

    private String serviceAddress;

    private String serviceProvince;

    private String serviceCity;

    private String serviceDistrict;

    private String equipmentRequest;

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

    private String otherBrand;

    private String otherStore;

    private BigDecimal longitude;

    private BigDecimal latitude;

    private String sourceType;

    private Integer createPerson;

    private Date createTime;

    private Integer updatePerson;

    private Date updateTime;

    private String uploadFileName;

    private String uploadFileUrl;

    private Integer dispatchModelId;

    private String backupDeviceRequest;

    private String completeProfileTemplateUrl;

    private String completeProfileTemplateName;

    private Integer expectReplyHours;

    private Date expectReplyTime;

    private Date expectCompleteTime;

    private String otherSystemNumber;

    private String requestVersionCode;

    private Integer rootRequestId;

    private Integer createHistoryPerson;

    private Date createHistoryTime;

    private String dispatchModelRequest;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public Integer getStoreId() {
        return storeId;
    }

    public void setStoreId(Integer storeId) {
        this.storeId = storeId;
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
        this.faultOrderNumber = faultOrderNumber == null ? null : faultOrderNumber.trim();
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
        this.serviceAddress = serviceAddress == null ? null : serviceAddress.trim();
    }

    public String getServiceProvince() {
        return serviceProvince;
    }

    public void setServiceProvince(String serviceProvince) {
        this.serviceProvince = serviceProvince == null ? null : serviceProvince.trim();
    }

    public String getServiceCity() {
        return serviceCity;
    }

    public void setServiceCity(String serviceCity) {
        this.serviceCity = serviceCity == null ? null : serviceCity.trim();
    }

    public String getServiceDistrict() {
        return serviceDistrict;
    }

    public void setServiceDistrict(String serviceDistrict) {
        this.serviceDistrict = serviceDistrict == null ? null : serviceDistrict.trim();
    }

    public String getEquipmentRequest() {
        return equipmentRequest;
    }

    public void setEquipmentRequest(String equipmentRequest) {
        this.equipmentRequest = equipmentRequest == null ? null : equipmentRequest.trim();
    }

    public String getOtherRequest() {
        return otherRequest;
    }

    public void setOtherRequest(String otherRequest) {
        this.otherRequest = otherRequest == null ? null : otherRequest.trim();
    }

    public String getDispatchDescription() {
        return dispatchDescription;
    }

    public void setDispatchDescription(String dispatchDescription) {
        this.dispatchDescription = dispatchDescription == null ? null : dispatchDescription.trim();
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo == null ? null : memo.trim();
    }

    public String getUrgencyRequest() {
        return urgencyRequest;
    }

    public void setUrgencyRequest(String urgencyRequest) {
        this.urgencyRequest = urgencyRequest == null ? null : urgencyRequest.trim();
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

    public String getOtherBrand() {
        return otherBrand;
    }

    public void setOtherBrand(String otherBrand) {
        this.otherBrand = otherBrand == null ? null : otherBrand.trim();
    }

    public String getOtherStore() {
        return otherStore;
    }

    public void setOtherStore(String otherStore) {
        this.otherStore = otherStore == null ? null : otherStore.trim();
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

    public String getSourceType() {
        return sourceType;
    }

    public void setSourceType(String sourceType) {
        this.sourceType = sourceType == null ? null : sourceType.trim();
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

    public String getUploadFileName() {
        return uploadFileName;
    }

    public void setUploadFileName(String uploadFileName) {
        this.uploadFileName = uploadFileName == null ? null : uploadFileName.trim();
    }

    public String getUploadFileUrl() {
        return uploadFileUrl;
    }

    public void setUploadFileUrl(String uploadFileUrl) {
        this.uploadFileUrl = uploadFileUrl == null ? null : uploadFileUrl.trim();
    }

    public Integer getDispatchModelId() {
        return dispatchModelId;
    }

    public void setDispatchModelId(Integer dispatchModelId) {
        this.dispatchModelId = dispatchModelId;
    }

    public String getBackupDeviceRequest() {
        return backupDeviceRequest;
    }

    public void setBackupDeviceRequest(String backupDeviceRequest) {
        this.backupDeviceRequest = backupDeviceRequest == null ? null : backupDeviceRequest.trim();
    }

    public String getCompleteProfileTemplateUrl() {
        return completeProfileTemplateUrl;
    }

    public void setCompleteProfileTemplateUrl(String completeProfileTemplateUrl) {
        this.completeProfileTemplateUrl = completeProfileTemplateUrl == null ? null : completeProfileTemplateUrl.trim();
    }

    public String getCompleteProfileTemplateName() {
        return completeProfileTemplateName;
    }

    public void setCompleteProfileTemplateName(String completeProfileTemplateName) {
        this.completeProfileTemplateName = completeProfileTemplateName == null ? null : completeProfileTemplateName.trim();
    }

    public Integer getExpectReplyHours() {
        return expectReplyHours;
    }

    public void setExpectReplyHours(Integer expectReplyHours) {
        this.expectReplyHours = expectReplyHours;
    }

    public Date getExpectReplyTime() {
        return expectReplyTime;
    }

    public void setExpectReplyTime(Date expectReplyTime) {
        this.expectReplyTime = expectReplyTime;
    }

    public Date getExpectCompleteTime() {
        return expectCompleteTime;
    }

    public void setExpectCompleteTime(Date expectCompleteTime) {
        this.expectCompleteTime = expectCompleteTime;
    }

    public String getOtherSystemNumber() {
        return otherSystemNumber;
    }

    public void setOtherSystemNumber(String otherSystemNumber) {
        this.otherSystemNumber = otherSystemNumber == null ? null : otherSystemNumber.trim();
    }

    public String getRequestVersionCode() {
        return requestVersionCode;
    }

    public void setRequestVersionCode(String requestVersionCode) {
        this.requestVersionCode = requestVersionCode == null ? null : requestVersionCode.trim();
    }

    public Integer getRootRequestId() {
        return rootRequestId;
    }

    public void setRootRequestId(Integer rootRequestId) {
        this.rootRequestId = rootRequestId;
    }

    public Integer getCreateHistoryPerson() {
        return createHistoryPerson;
    }

    public void setCreateHistoryPerson(Integer createHistoryPerson) {
        this.createHistoryPerson = createHistoryPerson;
    }

    public Date getCreateHistoryTime() {
        return createHistoryTime;
    }

    public void setCreateHistoryTime(Date createHistoryTime) {
        this.createHistoryTime = createHistoryTime;
    }

    public String getDispatchModelRequest() {
        return dispatchModelRequest;
    }

    public void setDispatchModelRequest(String dispatchModelRequest) {
        this.dispatchModelRequest = dispatchModelRequest == null ? null : dispatchModelRequest.trim();
    }
}