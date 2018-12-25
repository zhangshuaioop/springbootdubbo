package com.platform.springboot.entity.fdp;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class FdpFaultOrderProcess {
    private Integer id;

    private String companyName;

    private String storeName;

    private Integer companyId;

    private Integer storeId;

    private String faultOrderNumber;

    private String faultType;

    private String serviceAddress;

    private String contactName;

    private String telephone;

    private Integer contactId;

    private Boolean flagSimilarFault;

    private Integer similarFaultId;

    private String faultDescription;

    private String memo;

    private String opearteStatus;

    private String urgencyRequest;

    private Date serviceDate;

    private Integer serviceTimeStart;

    private Integer serviceTimeEnd;

    private Boolean flagDeleted;

    private Boolean flagAvailable;

    private Boolean flagDispatchRequest;

    private BigDecimal finalCost;

    private String monetaryUnit;

    private Integer sourceReportId;

    private Integer sortId;

    private Integer rootId;

    private Boolean flagFirstOrder;

    private Boolean flagHasMultiple;

    private Integer createPerson;

    private Date createTime;

    private Integer updatePerson;

    private Date updateTime;

    private Boolean flagUserAssm;

    private Boolean flagClientAssm;

    private Date faultInfoConfirmTime;

    private String otherFaultDevices;

    private Integer dealPersonId;

    private Integer belongPersonId;

    private boolean flagLastOrder;

    private Integer faultTypeModelId;

    private String inputType;

    private String Mobile;

    private String responsesType;

    private String cancelReason;

    public String getMobile() {
        return Mobile;
    }

    public void setMobile(String mobile) {
        Mobile = mobile;
    }

    private List<FdpFaultOrderRelatedCommProduct> product;


    private List<FdpFaultOrderRelatedDevice> device;

    public String getResponsesType() {
        return responsesType;
    }

    public void setResponsesType(String responsesType) {
        this.responsesType = responsesType;
    }

    public List<FdpFaultOrderRelatedCommProduct> getProduct() {
        return product;
    }

    public void setProduct(List<FdpFaultOrderRelatedCommProduct> product) {
        this.product = product;
    }

    public List<FdpFaultOrderRelatedDevice> getDevice() {
        return device;
    }

    public void setDevice(List<FdpFaultOrderRelatedDevice> device) {
        this.device = device;
    }

    public String getInputType() {
        return inputType;
    }

    public void setInputType(String inputType) {
        this.inputType = inputType;
    }

    public Integer getFaultTypeModelId() {
        return faultTypeModelId;
    }

    public void setFaultTypeModelId(Integer faultTypeModelId) {
        this.faultTypeModelId = faultTypeModelId;
    }

    public boolean isFlagLastOrder() {
        return flagLastOrder;
    }

    public void setFlagLastOrder(boolean flagLastOrder) {
        this.flagLastOrder = flagLastOrder;
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

    public Integer getDealPersonId() {
        return dealPersonId;
    }

    public void setDealPersonId(Integer dealPersonId) {
        this.dealPersonId = dealPersonId;
    }

    public Integer getBelongPersonId() {
        return belongPersonId;
    }

    public void setBelongPersonId(Integer belongPersonId) {
        this.belongPersonId = belongPersonId;
    }

    public String getOtherFaultDevices() {
        return otherFaultDevices;
    }

    public void setOtherFaultDevices(String otherFaultDevices) {
        this.otherFaultDevices = otherFaultDevices;
    }

    public Date getFaultInfoConfirmTime() {
        return faultInfoConfirmTime;
    }

    public void setFaultInfoConfirmTime(Date faultInfoConfirmTime) {
        this.faultInfoConfirmTime = faultInfoConfirmTime;
    }

    public Boolean getFlagUserAssm() {
        return flagUserAssm;
    }

    public void setFlagUserAssm(Boolean flagUserAssm) {
        this.flagUserAssm = flagUserAssm;
    }

    public Boolean getFlagClientAssm() {
        return flagClientAssm;
    }

    public void setFlagClientAssm(Boolean flagClientAssm) {
        this.flagClientAssm = flagClientAssm;
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

    public String getFaultOrderNumber() {
        return faultOrderNumber;
    }

    public void setFaultOrderNumber(String faultOrderNumber) {
        this.faultOrderNumber = faultOrderNumber;
    }

    public String getFaultType() {
        return faultType;
    }

    public void setFaultType(String faultType) {
        this.faultType = faultType == null ? null : faultType.trim();
    }

    public String getServiceAddress() {
        return serviceAddress;
    }

    public void setServiceAddress(String serviceAddress) {
        this.serviceAddress = serviceAddress == null ? null : serviceAddress.trim();
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName == null ? null : contactName.trim();
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone == null ? null : telephone.trim();
    }

    public Integer getContactId() {
        return contactId;
    }

    public void setContactId(Integer contactId) {
        this.contactId = contactId;
    }

    public Boolean getFlagSimilarFault() {
        return flagSimilarFault;
    }

    public void setFlagSimilarFault(Boolean flagSimilarFault) {
        this.flagSimilarFault = flagSimilarFault;
    }

    public Integer getSimilarFaultId() {
        return similarFaultId;
    }

    public void setSimilarFaultId(Integer similarFaultId) {
        this.similarFaultId = similarFaultId;
    }

    public String getFaultDescription() {
        return faultDescription;
    }

    public void setFaultDescription(String faultDescription) {
        this.faultDescription = faultDescription == null ? null : faultDescription.trim();
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo == null ? null : memo.trim();
    }

    public String getOpearteStatus() {
        return opearteStatus;
    }

    public void setOpearteStatus(String opearteStatus) {
        this.opearteStatus = opearteStatus == null ? null : opearteStatus.trim();
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

    public BigDecimal getFinalCost() {
        return finalCost;
    }

    public void setFinalCost(BigDecimal finalCost) {
        this.finalCost = finalCost;
    }

    public String getMonetaryUnit() {
        return monetaryUnit;
    }

    public void setMonetaryUnit(String monetaryUnit) {
        this.monetaryUnit = monetaryUnit == null ? null : monetaryUnit.trim();
    }

    public Integer getSourceReportId() {
        return sourceReportId;
    }

    public void setSourceReportId(Integer sourceReportId) {
        this.sourceReportId = sourceReportId;
    }

    public Integer getSortId() {
        return sortId;
    }

    public void setSortId(Integer sortId) {
        this.sortId = sortId;
    }

    public Integer getRootId() {
        return rootId;
    }

    public void setRootId(Integer rootId) {
        this.rootId = rootId;
    }

    public Boolean getFlagFirstOrder() {
        return flagFirstOrder;
    }

    public void setFlagFirstOrder(Boolean flagFirstOrder) {
        this.flagFirstOrder = flagFirstOrder;
    }

    public Boolean getFlagHasMultiple() {
        return flagHasMultiple;
    }

    public void setFlagHasMultiple(Boolean flagHasMultiple) {
        this.flagHasMultiple = flagHasMultiple;
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

    public Boolean getFlagDispatchRequest() {
        return flagDispatchRequest;
    }

    public void setFlagDispatchRequest(Boolean flagDispatchRequest) {
        this.flagDispatchRequest = flagDispatchRequest;
    }

    public String getCancelReason() {
        return cancelReason;
    }

    public void setCancelReason(String cancelReason) {
        this.cancelReason = cancelReason;
    }
}