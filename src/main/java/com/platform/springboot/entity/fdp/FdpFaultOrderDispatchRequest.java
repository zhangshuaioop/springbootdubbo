package com.platform.springboot.entity.fdp;

import java.math.BigDecimal;
import java.util.Date;

public class FdpFaultOrderDispatchRequest {
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

    private String storeName;

    private String companyName;

    private String dealPerson;

    private Integer requestId;

    private String  brandName;

    private String userName;

    private Integer lastDealPersonId;

    private String uploadFileName;

    private String uploadFileUrl;

    private Integer dispatchModelId;

    private Date estimatedServiceTime;

    private Integer expectReplyHours;

    private Date expectReplyTime;

    private boolean flagFuzzyAddress;

    private String actualCostMemo;

    private String actualPriceMemo;

    private Integer projectId;

    private Integer requestModelId;

    private BigDecimal estimatedPrice;

    private String estimatedPriceUnit;

    private boolean flagFixedPrice;

    private boolean flagRequestModified;

    private boolean flagDraft;

    private Date submitTime;

    private boolean flagSubmit;

    private String createPersonName;

    private String updatePersonName;

    private String dispatchOrderNumber;

    private String hrDispatchStatus;
    /**
     * 完工资料模板URL
     */
    private String completeProfileTemplateUrl;
    /**
     * 完工资料模板名称
     */
    private String completeProfileTemplateName;
    /**
     * 完工资料模板更新时间
     */
    private Date completeProfileTemplateUpdateTime;
    /**
     * 完工资料模板更新人ID
     */
    private Integer completeProfileTemplateUpdatePerson;
    /**
     * 紧急状态0不急1紧急
     */
    private Integer flagEmergency;
    /**
     * 是否自动提交完工
     */
    private boolean flagAutoCommit;

    private String fileName;

    private String batchNumber;

    private String projectModelName;

    public String getBatchNumber() {
        return batchNumber;
    }

    public void setBatchNumber(String batchNumber) {
        this.batchNumber = batchNumber;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getDispatchOrderNumber() {
        return dispatchOrderNumber;
    }

    public void setDispatchOrderNumber(String dispatchOrderNumber) {
        this.dispatchOrderNumber = dispatchOrderNumber;
    }

    public String getCreatePersonName() {
        return createPersonName;
    }

    public void setCreatePersonName(String createPersonName) {
        this.createPersonName = createPersonName;
    }

    public String getUpdatePersonName() {
        return updatePersonName;
    }

    public void setUpdatePersonName(String updatePersonName) {
        this.updatePersonName = updatePersonName;
    }

    public boolean getFlagSubmit() {
        return flagSubmit;
    }

    public void setFlagSubmit(boolean flagSubmit) {
        this.flagSubmit = flagSubmit;
    }

    public Date getSubmitTime() {
        return submitTime;
    }

    public void setSubmitTime(Date submitTime) {
        this.submitTime = submitTime;
    }

    public boolean getFlagDraft() {
        return flagDraft;
    }

    public void setFlagDraft(boolean flagDraft) {
        this.flagDraft = flagDraft;
    }

    public boolean getFlagRequestModified() {
        return flagRequestModified;
    }

    public void setFlagRequestModified(boolean flagRequestModified) {
        this.flagRequestModified = flagRequestModified;
    }

    private Date expectCompleteTime;

    private String otherSystemNumber;

    public Integer getProjectId() {
        return projectId;
    }

    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }

    public Integer getRequestModelId() {
        return requestModelId;
    }

    public void setRequestModelId(Integer requestModelId) {
        this.requestModelId = requestModelId;
    }

    public BigDecimal getEstimatedPrice() {
        return estimatedPrice;
    }

    public void setEstimatedPrice(BigDecimal estimatedPrice) {
        this.estimatedPrice = estimatedPrice;
    }

    public String getEstimatedPriceUnit() {
        return estimatedPriceUnit;
    }

    public void setEstimatedPriceUnit(String estimatedPriceUnit) {
        this.estimatedPriceUnit = estimatedPriceUnit;
    }

    public boolean getFlagFixedPrice() {
        return flagFixedPrice;
    }

    public void setFlagFixedPrice(boolean flagFixedPrice) {
        this.flagFixedPrice = flagFixedPrice;
    }

    public boolean getFlagFuzzyAddress() {
        return flagFuzzyAddress;
    }

    public void setFlagFuzzyAddress(boolean flagFuzzyAddress) {
        this.flagFuzzyAddress = flagFuzzyAddress;
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

    public Date getEstimatedServiceTime() {
        return estimatedServiceTime;
    }

    public void setEstimatedServiceTime(Date estimatedServiceTime) {
        this.estimatedServiceTime = estimatedServiceTime;
    }

    public Integer getDispatchModelId() {
        return dispatchModelId;
    }

    public void setDispatchModelId(Integer dispatchModelId) {
        this.dispatchModelId = dispatchModelId;
    }

    public String getUploadFileName() {
        return uploadFileName;
    }

    public void setUploadFileName(String uploadFileName) {
        this.uploadFileName = uploadFileName;
    }

    public String getUploadFileUrl() {
        return uploadFileUrl;
    }

    public void setUploadFileUrl(String uploadFileUrl) {
        this.uploadFileUrl = uploadFileUrl;
    }

    public Integer getLastDealPersonId() {
        return lastDealPersonId;
    }

    public void setLastDealPersonId(Integer lastDealPersonId) {
        this.lastDealPersonId = lastDealPersonId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public Integer getHrCount() {
        return hrCount;
    }

    public void setHrCount(Integer hrCount) {
        this.hrCount = hrCount;
    }

    public Integer getRequestId() {
        return requestId;
    }

    public void setRequestId(Integer requestId) {
        this.requestId = requestId;
    }

    private String dispatchStatus;

    public String getDispatchStatus() {
        return dispatchStatus;
    }

    public void setDispatchStatus(String dispatchStatus) {
        this.dispatchStatus = dispatchStatus;
    }

    public String getDealPerson() {
        return dealPerson;
    }

    public void setDealPerson(String dealPerson) {
        this.dealPerson = dealPerson;
    }

    public Boolean getFlagHasDispatched() {
        return flagHasDispatched;
    }

    public void setFlagHasDispatched(Boolean flagHasDispatched) {
        this.flagHasDispatched = flagHasDispatched;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getBackupDeviceRequest() {
        return backupDeviceRequest;
    }

    public void setBackupDeviceRequest(String backupDeviceRequest) {
        this.backupDeviceRequest = backupDeviceRequest;
    }

    public String getOtherStore() {
        return otherStore;
    }

    public void setOtherStore(String otherStore) {
        this.otherStore = otherStore;
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

    public String getEquipmentRequest() {
        return equipmentRequest;
    }

    public void setEquipmentRequest(String equipmentRequest) {
        this.equipmentRequest = equipmentRequest;
    }

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
        this.dispatchModelRequest = dispatchModelRequest == null ? null : dispatchModelRequest.trim();
    }

    public String getActualCostMemo() {
        return actualCostMemo;
    }

    public void setActualCostMemo(String actualCostMemo) {
        this.actualCostMemo = actualCostMemo;
    }

    public String getActualPriceMemo() {
        return actualPriceMemo;
    }

    public void setActualPriceMemo(String actualPriceMemo) {
        this.actualPriceMemo = actualPriceMemo;
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
        this.otherSystemNumber = otherSystemNumber;
    }

    public String getCompleteProfileTemplateUrl() {
        return completeProfileTemplateUrl;
    }

    public void setCompleteProfileTemplateUrl(String completeProfileTemplateUrl) {
        this.completeProfileTemplateUrl = completeProfileTemplateUrl;
    }

    public String getCompleteProfileTemplateName() {
        return completeProfileTemplateName;
    }

    public void setCompleteProfileTemplateName(String completeProfileTemplateName) {
        this.completeProfileTemplateName = completeProfileTemplateName;
    }

    public Date getCompleteProfileTemplateUpdateTime() {
        return completeProfileTemplateUpdateTime;
    }

    public void setCompleteProfileTemplateUpdateTime(Date completeProfileTemplateUpdateTime) {
        this.completeProfileTemplateUpdateTime = completeProfileTemplateUpdateTime;
    }

    public Integer getCompleteProfileTemplateUpdatePerson() {
        return completeProfileTemplateUpdatePerson;
    }

    public void setCompleteProfileTemplateUpdatePerson(Integer completeProfileTemplateUpdatePerson) {
        this.completeProfileTemplateUpdatePerson = completeProfileTemplateUpdatePerson;
    }

    public Integer getFlagEmergency() {
        return flagEmergency;
    }

    public void setFlagEmergency(Integer flagEmergency) {
        this.flagEmergency = flagEmergency;
    }

    public boolean isFlagAutoCommit() {
        return flagAutoCommit;
    }

    public void setFlagAutoCommit(boolean flagAutoCommit) {
        this.flagAutoCommit = flagAutoCommit;
    }

    public String getHrDispatchStatus() {
        return hrDispatchStatus;
    }

    public void setHrDispatchStatus(String hrDispatchStatus) {
        this.hrDispatchStatus = hrDispatchStatus;
    }

    public String getProjectModelName() {
        return projectModelName;
    }

    public void setProjectModelName(String projectModelName) {
        this.projectModelName = projectModelName;
    }
}