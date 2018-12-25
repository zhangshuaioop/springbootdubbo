package com.platform.springboot.entity.fdp;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author Wujun
 * @create 2018年04月03日 9:50
 */
public class FdpFaultDispatchOrderRequestForList {


    private Integer requestId;
    private Integer dispatchOrderId;
    private String faultOrderNumber;
    private String companyName;
    private String brandName;
    private String storeName;
    private BigDecimal actualCost;
    private Integer hrCount;
    private String serviceDistrict;
    private String serviceProvince;
    private String serviceCity;
    private String dispatchStatus;
    private Integer lastDealPersonId;
    private Integer createPersonId;
    private String createName;
    private Date updateTime;
    private Boolean flagUserself;
    private String sourceType;
    private String dispatchOrderNumber;
    private Integer vendorId;
    private Integer faultOrderId;
    private Boolean flagCustomerConfirm;
    private Boolean flagSee;
    private Date createTime;
    private String processStage;
    private boolean flagDispatcherConfirm;
    private BigDecimal requestEstimatedPrice;
    private String requestEstimatedPriceUnit;
    private boolean flagFixedPrice;
    private boolean flagDraft;
    private Date submitTime;
    private String hrDispatchStatus;

    /**
     * 更新人id
     */
    private Integer updatePerson;
    /**
     * 期望完工时间
     */
    private Date expectCompleteTime;
    /**
     * 工单进度
     */
    private Integer workSchedule;
    /**
     * 期望回复时间
     */
    private Date expectReplyTime;
    /**
     * 紧急状态0不急1紧急
     */
    private Integer flagEmergency;
    /**
     * 预警名称
     */
    private String warningName;
    /**
     * 预警颜色
     */
    private String warningColour;
    /**
     * 最后处理时间
     */
    private Date lastDealTime;
    /**
     * 项目名称
     */
    private String projectName;
    /**
     * 服务地址
     */
    private String serviceAddress;
    /**
     * 相关系统编号
     */
    private String otherSystemNumber;
    /**
     * 派工要求
     */
    private String dispatchModelRequest;
    /**
     * 工作内容
     */
    private String dispatchDescription;
    /**
     * 设备要求
     */
    private String equipmentRequest;
    /**
     * 备件要求
     */
    private String backupDeviceRequest;
    /**
     * 其他要求
     */
    private String otherRequest;

    //批次号
    private String batchNumber;

    private Date finishTime;

    public String getBatchNumber() {
        return batchNumber;
    }

    public void setBatchNumber(String batchNumber) {
        this.batchNumber = batchNumber;
    }

    public boolean getFlagDraft() {
        return flagDraft;
    }

    public void setFlagDraft(boolean flagDraft) {
        this.flagDraft = flagDraft;
    }

    public Date getSubmitTime() {
        return submitTime;
    }

    public void setSubmitTime(Date submitTime) {
        this.submitTime = submitTime;
    }

    public boolean setFlagDispatcherConfirm() {
        return flagDispatcherConfirm;
    }

    public BigDecimal getRequestEstimatedPrice() {
        return requestEstimatedPrice;
    }

    public void setRequestEstimatedPrice(BigDecimal requestEstimatedPrice) {
        this.requestEstimatedPrice = requestEstimatedPrice;
    }

    public String getRequestEstimatedPriceUnit() {
        return requestEstimatedPriceUnit;
    }

    public void setRequestEstimatedPriceUnit(String requestEstimatedPriceUnit) {
        this.requestEstimatedPriceUnit = requestEstimatedPriceUnit;
    }

    public boolean isFlagFixedPrice() {
        return flagFixedPrice;
    }

    public void setFlagFixedPrice(boolean flagFixedPrice) {
        this.flagFixedPrice = flagFixedPrice;
    }

    public boolean getFlagDispatcherConfirm() {
        return flagDispatcherConfirm;
    }

    public void setFlagDispatcherConfirm(boolean flagDispatcherConfirm) {
        this.flagDispatcherConfirm = flagDispatcherConfirm;
    }

    public String getProcessStage() {
        return processStage;
    }

    public void setProcessStage(String processStage) {
        this.processStage = processStage;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Boolean getFlagSee() {
        return flagSee;
    }

    public void setFlagSee(Boolean flagSee) {
        this.flagSee = flagSee;
    }

    public Boolean getFlagCustomerConfirm() {
        return flagCustomerConfirm;
    }

    public void setFlagCustomerConfirm(Boolean flagCustomerConfirm) {
        this.flagCustomerConfirm = flagCustomerConfirm;
    }

    public Integer getFaultOrderId() {
        return faultOrderId;
    }

    public void setFaultOrderId(Integer faultOrderId) {
        this.faultOrderId = faultOrderId;
    }

    public Integer getVendorId() {
        return vendorId;
    }

    public void setVendorId(Integer vendorId) {
        this.vendorId = vendorId;
    }

    public String getDispatchOrderNumber() {
        return dispatchOrderNumber;
    }

    public void setDispatchOrderNumber(String dispatchOrderNumber) {
        this.dispatchOrderNumber = dispatchOrderNumber;
    }

    private String actualMonetaryUnit;

    public String getActualMonetaryUnit() {
        return actualMonetaryUnit;
    }

    public void setActualMonetaryUnit(String actualMonetaryUnit) {
        this.actualMonetaryUnit = actualMonetaryUnit;
    }

    public Integer getRequestId() {
        return requestId;
    }

    public void setRequestId(Integer requestId) {
        this.requestId = requestId;
    }

    public Integer getDispatchOrderId() {
        return dispatchOrderId;
    }

    public void setDispatchOrderId(Integer dispatchOrderId) {
        this.dispatchOrderId = dispatchOrderId;
    }

    public String getFaultOrderNumber() {
        return faultOrderNumber;
    }

    public void setFaultOrderNumber(String faultOrderNumber) {
        this.faultOrderNumber = faultOrderNumber;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public BigDecimal getActualCost() {
        return actualCost;
    }

    public void setActualCost(BigDecimal actualCost) {
        this.actualCost = actualCost;
    }

    public Integer getHrCount() {
        return hrCount;
    }

    public void setHrCount(Integer hrCount) {
        this.hrCount = hrCount;
    }

    public String getServiceDistrict() {
        return serviceDistrict;
    }

    public void setServiceDistrict(String serviceDistrict) {
        this.serviceDistrict = serviceDistrict;
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

    public String getServiceAddress() {
        return serviceAddress;
    }

    public void setServiceAddress(String serviceAddress) {
        this.serviceAddress = serviceAddress;
    }

    public String getDispatchStatus() {
        return dispatchStatus;
    }

    public void setDispatchStatus(String dispatchStatus) {
        this.dispatchStatus = dispatchStatus;
    }

    public Integer getLastDealPersonId() {
        return lastDealPersonId;
    }

    public void setLastDealPersonId(Integer lastDealPersonId) {
        this.lastDealPersonId = lastDealPersonId;
    }

    public Integer getCreatePersonId() {
        return createPersonId;
    }

    public void setCreatePersonId(Integer createPersonId) {
        this.createPersonId = createPersonId;
    }

    public String getCreateName() {
        return createName;
    }

    public void setCreateName(String createName) {
        this.createName = createName;
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

    public Boolean getFlagUserself() {
        return flagUserself;
    }

    public void setFlagUserself(Boolean flagUserself) {
        this.flagUserself = flagUserself;
    }

    public String getSourceType() {
        return sourceType;
    }

    public void setSourceType(String sourceType) {
        this.sourceType = sourceType;
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

    public Integer getWorkSchedule() {
        return workSchedule;
    }

    public void setWorkSchedule(Integer workSchedule) {
        this.workSchedule = workSchedule;
    }

    public Date getExpectReplyTime() {
        return expectReplyTime;
    }

    public void setExpectReplyTime(Date expectReplyTime) {
        this.expectReplyTime = expectReplyTime;
    }

    public Integer getFlagEmergency() {
        return flagEmergency;
    }

    public void setFlagEmergency(Integer flagEmergency) {
        this.flagEmergency = flagEmergency;
    }

    public String getWarningName() {
        return warningName;
    }

    public void setWarningName(String warningName) {
        this.warningName = warningName;
    }

    public String getWarningColour() {
        return warningColour;
    }

    public void setWarningColour(String warningColour) {
        this.warningColour = warningColour;
    }

    public Date getLastDealTime() {
        return lastDealTime;
    }

    public void setLastDealTime(Date lastDealTime) {
        this.lastDealTime = lastDealTime;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getDispatchDescription() {
        return dispatchDescription;
    }

    public void setDispatchDescription(String dispatchDescription) {
        this.dispatchDescription = dispatchDescription;
    }

    public String getEquipmentRequest() {
        return equipmentRequest;
    }

    public void setEquipmentRequest(String equipmentRequest) {
        this.equipmentRequest = equipmentRequest;
    }

    public String getBackupDeviceRequest() {
        return backupDeviceRequest;
    }

    public void setBackupDeviceRequest(String backupDeviceRequest) {
        this.backupDeviceRequest = backupDeviceRequest;
    }

    public String getOtherRequest() {
        return otherRequest;
    }

    public void setOtherRequest(String otherRequest) {
        this.otherRequest = otherRequest;
    }

    public String getHrDispatchStatus() {
        return hrDispatchStatus;
    }

    public void setHrDispatchStatus(String hrDispatchStatus) {
        this.hrDispatchStatus = hrDispatchStatus;
    }

    public Integer getUpdatePerson() {
        return updatePerson;
    }

    public void setUpdatePerson(Integer updatePerson) {
        this.updatePerson = updatePerson;
    }

    public Date getFinishTime() {
        return finishTime;
    }

    public void setFinishTime(Date finishTime) {
        this.finishTime = finishTime;
    }
}
