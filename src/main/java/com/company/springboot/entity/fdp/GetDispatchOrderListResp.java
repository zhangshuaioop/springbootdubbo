package com.company.springboot.entity.fdp;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 查询符合条件的派工工单列表-返回结果
 *
 * @author Wujun
 * @create 2018年01月30日 17:16
 */
public class GetDispatchOrderListResp {
    private int dispatchOrderId;
    private int dispatchRequestId;
    private String dispatchOrderNumber;
    private String reportNumber;
    private String companyName;
    private String storeName;
    private String dispatchRequest;
    private String serviceProvince;
    private String serviceCity;
    private BigDecimal actualCost;
    private Date serviceDate;
    private String dealPersonName;
    private String dispatchStatus;
    private Integer lastDealPersonId;
    private Boolean flagUserself;
    private String vendorName;
    private Integer vendorId;
    private Integer faultOrderId;
    private String urgencyRequest;
    private Boolean flagDispatcherConfirm;
    private BigDecimal estimatedPrice;
    private BigDecimal estimatedCost;
    private String processStage;
    private Date createTime;
    private String createPerson;
    private boolean flagNoPrice;
    private boolean flagEnableModifyProfile;
    private BigDecimal actualPrice;
    private String actualPriceUnit;
    private String hrDispatchStatus;
    /**
     * 期望完工时间
     */
    private Date expectCompleteTime;
    /**
     * 提交时间
     */
    private Date submitTime;
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
     * 附件名称
     */
    private String uploadFileName;
    /**
     * 模版名称
     */
    private String completeProfileTemplateName;
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

    //短工单编号
    private String shortOrderCode;

    public String getBatchNumber() {
        return batchNumber;
    }

    public void setBatchNumber(String batchNumber) {
        this.batchNumber = batchNumber;
    }

    public BigDecimal getActualPrice() {
        return actualPrice;
    }

    public void setActualPrice(BigDecimal actualPrice) {
        this.actualPrice = actualPrice;
    }

    public String getActualPriceUnit() {
        return actualPriceUnit;
    }

    public void setActualPriceUnit(String actualPriceUnit) {
        this.actualPriceUnit = actualPriceUnit;
    }

    public boolean getFlagEnableModifyProfile() {
        return flagEnableModifyProfile;
    }

    public void setFlagEnableModifyProfile(boolean flagEnableModifyProfile) {
        this.flagEnableModifyProfile = flagEnableModifyProfile;
    }

    public boolean getFlagNoPrice() {
        return flagNoPrice;
    }

    public void setFlagNoPrice(boolean flagNoPrice) {
        this.flagNoPrice = flagNoPrice;
    }

    public String getCreatePerson() {
        return createPerson;
    }

    public void setCreatePerson(String createPerson) {
        this.createPerson = createPerson;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getProcessStage() {
        return processStage;
    }

    public void setProcessStage(String processStage) {
        this.processStage = processStage;
    }

    public BigDecimal getEstimatedCost() {
        return estimatedCost;
    }

    public void setEstimatedCost(BigDecimal estimatedCost) {
        this.estimatedCost = estimatedCost;
    }

    public BigDecimal getEstimatedPrice() {
        return estimatedPrice;
    }

    public void setEstimatedPrice(BigDecimal estimatedPrice) {
        this.estimatedPrice = estimatedPrice;
    }

    public Boolean getFlagDispatcherConfirm() {
        return flagDispatcherConfirm;
    }

    public void setFlagDispatcherConfirm(Boolean flagDispatcherConfirm) {
        this.flagDispatcherConfirm = flagDispatcherConfirm;
    }

    public String getUrgencyRequest() {
        return urgencyRequest;
    }

    public void setUrgencyRequest(String urgencyRequest) {
        this.urgencyRequest = urgencyRequest;
    }

    public Integer getVendorId() {
        return vendorId;
    }

    public void setVendorId(Integer vendorId) {
        this.vendorId = vendorId;
    }

    public Integer getFaultOrderId() {
        return faultOrderId;
    }

    public void setFaultOrderId(Integer faultOrderId) {
        this.faultOrderId = faultOrderId;
    }

    public String getVendorName() {
        return vendorName;
    }

    public void setVendorName(String vendorName) {
        this.vendorName = vendorName;
    }

    public Boolean getFlagUserself() {
        return flagUserself;
    }

    public void setFlagUserself(Boolean flagUserself) {
        this.flagUserself = flagUserself;
    }

    public Integer getLastDealPersonId() {
        return lastDealPersonId;
    }

    public void setLastDealPersonId(Integer lastDealPersonId) {
        this.lastDealPersonId = lastDealPersonId;
    }

    public String getDispatchStatus() {
        return dispatchStatus;
    }

    public void setDispatchStatus(String dispatchStatus) {
        this.dispatchStatus = dispatchStatus;
    }

    public String getDispatchOrderNumber() {
        return dispatchOrderNumber;
    }

    public void setDispatchOrderNumber(String dispatchOrderNumber) {
        this.dispatchOrderNumber = dispatchOrderNumber;
    }

    public BigDecimal getActualCost() {
        return actualCost;
    }

    public void setActualCost(BigDecimal actualCost) {
        this.actualCost = actualCost;
    }

    private int processId;

    public int getDispatchRequestId() {
        return dispatchRequestId;
    }

    public void setDispatchRequestId(int dispatchRequestId) {
        this.dispatchRequestId = dispatchRequestId;
    }

    public int getProcessId() {
        return processId;
    }

    public void setProcessId(int processId) {
        this.processId = processId;
    }

    public int getDispatchOrderId() {
        return dispatchOrderId;
    }

    public void setDispatchOrderId(int dispatchOrderId) {
        this.dispatchOrderId = dispatchOrderId;
    }

    public String getReportNumber() {
        return reportNumber;
    }

    public void setReportNumber(String reportNumber) {
        this.reportNumber = reportNumber;
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

    public String getDispatchRequest() {
        return dispatchRequest;
    }

    public void setDispatchRequest(String dispatchRequest) {
        this.dispatchRequest = dispatchRequest;
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

    public Date getServiceDate() {
        return serviceDate;
    }

    public void setServiceDate(Date serviceDate) {
        this.serviceDate = serviceDate;
    }

    public String getDealPersonName() {
        return dealPersonName;
    }

    public void setDealPersonName(String dealPersonName) {
        this.dealPersonName = dealPersonName;
    }

    public Date getExpectCompleteTime() {
        return expectCompleteTime;
    }

    public void setExpectCompleteTime(Date expectCompleteTime) {
        this.expectCompleteTime = expectCompleteTime;
    }

    public Date getSubmitTime() {
        return submitTime;
    }

    public void setSubmitTime(Date submitTime) {
        this.submitTime = submitTime;
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

    public String getUploadFileName() {
        return uploadFileName;
    }

    public void setUploadFileName(String uploadFileName) {
        this.uploadFileName = uploadFileName;
    }

    public String getCompleteProfileTemplateName() {
        return completeProfileTemplateName;
    }

    public void setCompleteProfileTemplateName(String completeProfileTemplateName) {
        this.completeProfileTemplateName = completeProfileTemplateName;
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

    public String getServiceAddress() {
        return serviceAddress;
    }

    public void setServiceAddress(String serviceAddress) {
        this.serviceAddress = serviceAddress;
    }

    public String getOtherSystemNumber() {
        return otherSystemNumber;
    }

    public void setOtherSystemNumber(String otherSystemNumber) {
        this.otherSystemNumber = otherSystemNumber;
    }

    public String getDispatchModelRequest() {
        return dispatchModelRequest;
    }

    public void setDispatchModelRequest(String dispatchModelRequest) {
        this.dispatchModelRequest = dispatchModelRequest;
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

    public Date getFinishTime() {
        return finishTime;
    }

    public void setFinishTime(Date finishTime) {
        this.finishTime = finishTime;
    }

    public String getShortOrderCode() {
        return shortOrderCode;
    }

    public void setShortOrderCode(String shortOrderCode) {
        this.shortOrderCode = shortOrderCode;
    }
}
