package com.platform.springboot.entity.fdp;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 查看派工信息
 *
 * @author Wujun
 * @create 2018年01月26日 16:19
 */
public class FdpFaultOrderDispatchRequestShow {
    private BigDecimal longitude;
    private BigDecimal latitude;
    private Date lastDealTime;
    private String lastDealPerson;
    private String firstName;
    private String lastName;
    private String mobile;
    private Date estimatedServiceTime;
    private BigDecimal actualCost;
    private String actualMonetaryUnit;
    private String dispatchDescription;
    private String fullName;
    private String bankName;
    private String account;
    private String alipayAccount;
    private String paymentMethod;
    private boolean flagProvideInvoice;
    private String actualInvoiceType;
    private BigDecimal actualInvoiceRate;
    private String memo;
    private String dispatchModelRequest;
    private String otherRequest;
    private String dispatchOrderNumber;
    private Date lastDispatchTime;
    private int dispatchCount;
    private BigDecimal dispatchMaxFee;
    private BigDecimal dispatchAvgFee;
    private BigDecimal userAssmAchieveAvgPoint;
    private BigDecimal userAssmCommunicationAvgPoint;
    private BigDecimal userAssmTimelyAvgPoint;
    private String contactAssmAvgPoint;
    private String equipmentRequest;
    private BigDecimal estimatedCost;
    private String estimatedMonetaryUnit;
    private Integer hrCount;
    private String serviceAddress;
    private String serviceProvince;
    private String serviceCity;
    private String serviceDistrict;
    private String urgencyRequest;
    private Date serviceDate;
    private int serviceTimeStart;
    private int serviceTimeEnd;
    private Date applyTime;
    private String estimatedPriceUnit;
    private BigDecimal estimatedPrice;
    private String backupDeviceRequest;
    private String companyName;
    private String storeName;
    private String otherBrand;
    private String otherStore;
    private String estimatedInvoiceType;
    private BigDecimal estimatedInvoiceRate;
    private Integer vendorId;
    private String uploadFileName;
    private String uploadFileUrl;
    private BigDecimal actualPrice;
    private String actualPriceUnit;
    private String faultOrderNumber;
    private String hrRelationMemo;
    private Integer expectReplyHours;
    private Date expectReplyTime;
    private String estimatedPriceMemo;
    private String estimatedCostMemo;
    private String actualCostMemo;
    private String actualPriceMemo;
    private String requestEstimatedPriceUnit;
    private BigDecimal requestEstimatedPrice;
    private boolean flagFixedPrice;
    private boolean flagNoPrice;
    private Date expectCompleteTime;
    private String otherSystemNumber;
    private String privateNote;
    private boolean flagNoHr;
    private boolean flagNoPoint;
    private Integer userAssmAchievePoint;
    private Integer userAssmCommunicationPoint;
    private Integer userAssmTimelyPoint;
    private Date submitTime;
    private Date updateTime;
    private String createPersonName;
    private String updatePersonName;
    private boolean flagFuzzyAddress;
    private String hrDispatchStatus;
    private Date userCompletetime;
    /**
     * 外派人员开始服务时间
     */
    private Date hrStartServiceTime;
    /**
     *外派人员出发时间
     */
    private Date hrStartOffTime;
    /**
     *外派人员完成服务时间
     */
    private Date hrFinishServiceTime;
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
     * 是否自动提交完工
     */
    private boolean flagAutoCommit;

    private String personRejectCauseContext;

    private String materialRejectCauseContext;

    public boolean getFlagFuzzyAddress() {
        return flagFuzzyAddress;
    }

    public void setFlagFuzzyAddress(boolean flagFuzzyAddress) {
        this.flagFuzzyAddress = flagFuzzyAddress;
    }

    public Date getSubmitTime() {
        return submitTime;
    }

    public void setSubmitTime(Date submitTime) {
        this.submitTime = submitTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
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

    public Integer getUserAssmAchievePoint() {
        return userAssmAchievePoint;
    }

    public void setUserAssmAchievePoint(Integer userAssmAchievePoint) {
        this.userAssmAchievePoint = userAssmAchievePoint;
    }

    public Integer getUserAssmCommunicationPoint() {
        return userAssmCommunicationPoint;
    }

    public void setUserAssmCommunicationPoint(Integer userAssmCommunicationPoint) {
        this.userAssmCommunicationPoint = userAssmCommunicationPoint;
    }

    public Integer getUserAssmTimelyPoint() {
        return userAssmTimelyPoint;
    }

    public void setUserAssmTimelyPoint(Integer userAssmTimelyPoint) {
        this.userAssmTimelyPoint = userAssmTimelyPoint;
    }

    public boolean getFlagNoHr() {
        return flagNoHr;
    }

    public void setFlagNoHr(boolean flagNoHr) {
        this.flagNoHr = flagNoHr;
    }

    public boolean getFlagNoPoint() {
        return flagNoPoint;
    }

    public void setFlagNoPoint(boolean flagNoPoint) {
        this.flagNoPoint = flagNoPoint;
    }

    public boolean getFlagNoPrice() {
        return flagNoPrice;
    }

    public void setFlagNoPrice(boolean flagNoPrice) {
        this.flagNoPrice = flagNoPrice;
    }

    public String getRequestEstimatedPriceUnit() {
        return requestEstimatedPriceUnit;
    }

    public void setRequestEstimatedPriceUnit(String requestEstimatedPriceUnit) {
        this.requestEstimatedPriceUnit = requestEstimatedPriceUnit;
    }

    public BigDecimal getRequestEstimatedPrice() {
        return requestEstimatedPrice;
    }

    public void setRequestEstimatedPrice(BigDecimal requestEstimatedPrice) {
        this.requestEstimatedPrice = requestEstimatedPrice;
    }

    public boolean getFlagFixedPrice() {
        return flagFixedPrice;
    }

    public void setFlagFixedPrice(boolean flagFixedPrice) {
        this.flagFixedPrice = flagFixedPrice;
    }

    public String getEstimatedCostMemo() {
        return estimatedCostMemo;
    }

    public void setEstimatedCostMemo(String estimatedCostMemo) {
        this.estimatedCostMemo = estimatedCostMemo;
    }

    public String getActualPriceMemo() {
        return actualPriceMemo;
    }

    public void setActualPriceMemo(String actualPriceMemo) {
        this.actualPriceMemo = actualPriceMemo;
    }

    public String getEstimatedPriceMemo() {
        return estimatedPriceMemo;
    }

    public void setEstimatedPriceMemo(String estimatedPriceMemo) {
        this.estimatedPriceMemo = estimatedPriceMemo;
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

    public String getHrRelationMemo() {
        return hrRelationMemo;
    }

    public void setHrRelationMemo(String hrRelationMemo) {
        this.hrRelationMemo = hrRelationMemo;
    }

    public String getFaultOrderNumber() {
        return faultOrderNumber;
    }

    public void setFaultOrderNumber(String faultOrderNumber) {
        this.faultOrderNumber = faultOrderNumber;
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

    public Integer getVendorId() {
        return vendorId;
    }

    public void setVendorId(Integer vendorId) {
        this.vendorId = vendorId;
    }

    public String getEstimatedInvoiceType() {
        return estimatedInvoiceType;
    }

    public void setEstimatedInvoiceType(String estimatedInvoiceType) {
        this.estimatedInvoiceType = estimatedInvoiceType;
    }

    public BigDecimal getEstimatedInvoiceRate() {
        return estimatedInvoiceRate;
    }

    public void setEstimatedInvoiceRate(BigDecimal estimatedInvoiceRate) {
        this.estimatedInvoiceRate = estimatedInvoiceRate;
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

    public String getOtherBrand() {
        return otherBrand;
    }

    public void setOtherBrand(String otherBrand) {
        this.otherBrand = otherBrand;
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

    public String getEstimatedPriceUnit() {
        return estimatedPriceUnit;
    }

    public void setEstimatedPriceUnit(String estimatedPriceUnit) {
        this.estimatedPriceUnit = estimatedPriceUnit;
    }

    public BigDecimal getEstimatedPrice() {
        return estimatedPrice;
    }

    public void setEstimatedPrice(BigDecimal estimatedPrice) {
        this.estimatedPrice = estimatedPrice;
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

    public Integer getHrCount() {
        return hrCount;
    }

    public void setHrCount(Integer hrCount) {
        this.hrCount = hrCount;
    }

    public String getDispatchOrderNumber() {
        return dispatchOrderNumber;
    }

    public void setDispatchOrderNumber(String dispatchOrderNumber) {
        this.dispatchOrderNumber = dispatchOrderNumber;
    }

    public BigDecimal getEstimatedCost() {
        return estimatedCost;
    }

    public void setEstimatedCost(BigDecimal estimatedCost) {
        this.estimatedCost = estimatedCost;
    }

    public String getEstimatedMonetaryUnit() {
        return estimatedMonetaryUnit;
    }

    public void setEstimatedMonetaryUnit(String estimatedMonetaryUnit) {
        this.estimatedMonetaryUnit = estimatedMonetaryUnit;
    }

    public Date getApplyTime() {
        return applyTime;
    }

    public void setApplyTime(Date applyTime) {
        this.applyTime = applyTime;
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

    public int getServiceTimeStart() {
        return serviceTimeStart;
    }

    public void setServiceTimeStart(int serviceTimeStart) {
        this.serviceTimeStart = serviceTimeStart;
    }

    public int getServiceTimeEnd() {
        return serviceTimeEnd;
    }

    public void setServiceTimeEnd(int serviceTimeEnd) {
        this.serviceTimeEnd = serviceTimeEnd;
    }

    public String getEquipmentRequest() {
        return equipmentRequest;
    }

    public void setEquipmentRequest(String equipmentRequest) {
        this.equipmentRequest = equipmentRequest;
    }

    public Date getLastDealTime() {
        return lastDealTime;
    }

    public void setLastDealTime(Date lastDealTime) {
        this.lastDealTime = lastDealTime;
    }

    public String getLastDealPerson() {
        return lastDealPerson;
    }

    public void setLastDealPerson(String lastDealPerson) {
        this.lastDealPerson = lastDealPerson;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public Date getEstimatedServiceTime() {
        return estimatedServiceTime;
    }

    public void setEstimatedServiceTime(Date estimatedServiceTime) {
        this.estimatedServiceTime = estimatedServiceTime;
    }

    public BigDecimal getActualCost() {
        return actualCost;
    }

    public void setActualCost(BigDecimal actualCost) {
        this.actualCost = actualCost;
    }

    public String getActualMonetaryUnit() {
        return actualMonetaryUnit;
    }

    public void setActualMonetaryUnit(String actualMonetaryUnit) {
        this.actualMonetaryUnit = actualMonetaryUnit;
    }

    public String getDispatchDescription() {
        return dispatchDescription;
    }

    public void setDispatchDescription(String dispatchDescription) {
        this.dispatchDescription = dispatchDescription;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getAlipayAccount() {
        return alipayAccount;
    }

    public void setAlipayAccount(String alipayAccount) {
        this.alipayAccount = alipayAccount;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public boolean isFlagProvideInvoice() {
        return flagProvideInvoice;
    }

    public void setFlagProvideInvoice(boolean flagProvideInvoice) {
        this.flagProvideInvoice = flagProvideInvoice;
    }

    public String getActualInvoiceType() {
        return actualInvoiceType;
    }

    public void setActualInvoiceType(String actualInvoiceType) {
        this.actualInvoiceType = actualInvoiceType;
    }

    public BigDecimal getActualInvoiceRate() {
        return actualInvoiceRate;
    }

    public void setActualInvoiceRate(BigDecimal actualInvoiceRate) {
        this.actualInvoiceRate = actualInvoiceRate;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public String getDispatchModelRequest() {
        return dispatchModelRequest;
    }

    public void setDispatchModelRequest(String dispatchModelRequest) {
        this.dispatchModelRequest = dispatchModelRequest;
    }

    public String getOtherRequest() {
        return otherRequest;
    }

    public void setOtherRequest(String otherRequest) {
        this.otherRequest = otherRequest;
    }

    public Date getLastDispatchTime() {
        return lastDispatchTime;
    }

    public void setLastDispatchTime(Date lastDispatchTime) {
        this.lastDispatchTime = lastDispatchTime;
    }

    public int getDispatchCount() {
        return dispatchCount;
    }

    public void setDispatchCount(int dispatchCount) {
        this.dispatchCount = dispatchCount;
    }

    public BigDecimal getDispatchMaxFee() {
        return dispatchMaxFee;
    }

    public void setDispatchMaxFee(BigDecimal dispatchMaxFee) {
        this.dispatchMaxFee = dispatchMaxFee;
    }

    public BigDecimal getDispatchAvgFee() {
        return dispatchAvgFee;
    }

    public void setDispatchAvgFee(BigDecimal dispatchAvgFee) {
        this.dispatchAvgFee = dispatchAvgFee;
    }

    public BigDecimal getUserAssmAchieveAvgPoint() {
        return userAssmAchieveAvgPoint;
    }

    public void setUserAssmAchieveAvgPoint(BigDecimal userAssmAchieveAvgPoint) {
        this.userAssmAchieveAvgPoint = userAssmAchieveAvgPoint;
    }

    public BigDecimal getUserAssmCommunicationAvgPoint() {
        return userAssmCommunicationAvgPoint;
    }

    public void setUserAssmCommunicationAvgPoint(BigDecimal userAssmCommunicationAvgPoint) {
        this.userAssmCommunicationAvgPoint = userAssmCommunicationAvgPoint;
    }

    public BigDecimal getUserAssmTimelyAvgPoint() {
        return userAssmTimelyAvgPoint;
    }

    public void setUserAssmTimelyAvgPoint(BigDecimal userAssmTimelyAvgPoint) {
        this.userAssmTimelyAvgPoint = userAssmTimelyAvgPoint;
    }

    public String getContactAssmAvgPoint() {
        return contactAssmAvgPoint;
    }

    public void setContactAssmAvgPoint(String contactAssmAvgPoint) {
        this.contactAssmAvgPoint = contactAssmAvgPoint;
    }


    public String getActualCostMemo() {
        return actualCostMemo;
    }

    public void setActualCostMemo(String actualCostMemo) {
        this.actualCostMemo = actualCostMemo;
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

    public String getPrivateNote() {
        return privateNote;
    }

    public void setPrivateNote(String privateNote) {
        this.privateNote = privateNote;
    }

    public Date getHrStartServiceTime() {
        return hrStartServiceTime;
    }

    public void setHrStartServiceTime(Date hrStartServiceTime) {
        this.hrStartServiceTime = hrStartServiceTime;
    }

    public Date getHrStartOffTime() {
        return hrStartOffTime;
    }

    public void setHrStartOffTime(Date hrStartOffTime) {
        this.hrStartOffTime = hrStartOffTime;
    }

    public Date getHrFinishServiceTime() {
        return hrFinishServiceTime;
    }

    public void setHrFinishServiceTime(Date hrFinishServiceTime) {
        this.hrFinishServiceTime = hrFinishServiceTime;
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

    public Date getUserCompletetime() {
        return userCompletetime;
    }

    public void setUserCompletetime(Date userCompletetime) {
        this.userCompletetime = userCompletetime;
    }

    public String getPersonRejectCauseContext() {
        return personRejectCauseContext;
    }

    public void setPersonRejectCauseContext(String personRejectCauseContext) {
        this.personRejectCauseContext = personRejectCauseContext;
    }

    public String getMaterialRejectCauseContext() {
        return materialRejectCauseContext;
    }

    public void setMaterialRejectCauseContext(String materialRejectCauseContext) {
        this.materialRejectCauseContext = materialRejectCauseContext;
    }
}
