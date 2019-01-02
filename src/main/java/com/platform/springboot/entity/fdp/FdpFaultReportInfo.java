package com.platform.springboot.entity.fdp;

import java.util.Date;

public class FdpFaultReportInfo {
    private Integer id;

    private Integer companyId;

    private Integer storeId;

    private String address;

    private String basicFaultType;

    private String otherFaultType;

    private Integer faultTypeModelId;

    private Date reportDate;

    private Boolean flagSimilarFault;

    private Integer similarFaultId;

    private String contactName;

    private String telephone;

    private Integer contactId;

    private String reportNumber;

    private String faultImagesUrl;

    private String responsesType;

    private String faultDescription;

    private Boolean flagDeleted;

    private Boolean flagAvailable;

    private Boolean flagDeal;

    private Integer dealPersonId;

    private Date dealTime;

    private String mobile;

    private String inputType;

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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getBasicFaultType() {
        return basicFaultType;
    }

    public void setBasicFaultType(String basicFaultType) {
        this.basicFaultType = basicFaultType;
    }

    public String getOtherFaultType() {
        return otherFaultType;
    }

    public void setOtherFaultType(String otherFaultType) {
        this.otherFaultType = otherFaultType;
    }

    public Integer getFaultTypeModelId() {
        return faultTypeModelId;
    }

    public void setFaultTypeModelId(Integer faultTypeModelId) {
        this.faultTypeModelId = faultTypeModelId;
    }

    public Date getReportDate() {
        return reportDate;
    }

    public void setReportDate(Date reportDate) {
        this.reportDate = reportDate;
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

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public Integer getContactId() {
        return contactId;
    }

    public void setContactId(Integer contactId) {
        this.contactId = contactId;
    }

    public String getReportNumber() {
        return reportNumber;
    }

    public void setReportNumber(String reportNumber) {
        this.reportNumber = reportNumber;
    }

    public String getFaultImagesUrl() {
        return faultImagesUrl;
    }

    public void setFaultImagesUrl(String faultImagesUrl) {
        this.faultImagesUrl = faultImagesUrl;
    }

    public String getResponsesType() {
        return responsesType;
    }

    public void setResponsesType(String responsesType) {
        this.responsesType = responsesType;
    }

    public String getFaultDescription() {
        return faultDescription;
    }

    public void setFaultDescription(String faultDescription) {
        this.faultDescription = faultDescription;
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

    public Boolean getFlagDeal() {
        return flagDeal;
    }

    public void setFlagDeal(Boolean flagDeal) {
        this.flagDeal = flagDeal;
    }

    public Integer getDealPersonId() {
        return dealPersonId;
    }

    public void setDealPersonId(Integer dealPersonId) {
        this.dealPersonId = dealPersonId;
    }

    public Date getDealTime() {
        return dealTime;
    }

    public void setDealTime(Date dealTime) {
        this.dealTime = dealTime;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getInputType() {
        return inputType;
    }

    public void setInputType(String inputType) {
        this.inputType = inputType;
    }
}