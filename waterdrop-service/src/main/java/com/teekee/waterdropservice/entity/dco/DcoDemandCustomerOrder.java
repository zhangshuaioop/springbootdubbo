package com.teekee.waterdropservice.entity.dco;

import java.util.Date;

public class DcoDemandCustomerOrder {
    private Integer id;

    private String orderCode;

    private String orderType;

    private String originUrgencyStatus;

    private String currentUrgencyStatus;

    private String contact;

    private String telephone;

    private Boolean flagDeleted;

    private Boolean needAssessment;

    private Integer companyId;

    private Integer storeId;

    private String processStatus;

    private Integer orderStatus;

    private Integer dealLastTime;

    private Integer dealPerson;

    private Date createTime;

    private Integer createPerson;

    private Date lastUpdateTime;

    private Integer lastUpdatePerson;

    private String orderContent;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode == null ? null : orderCode.trim();
    }

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType == null ? null : orderType.trim();
    }

    public String getOriginUrgencyStatus() {
        return originUrgencyStatus;
    }

    public void setOriginUrgencyStatus(String originUrgencyStatus) {
        this.originUrgencyStatus = originUrgencyStatus == null ? null : originUrgencyStatus.trim();
    }

    public String getCurrentUrgencyStatus() {
        return currentUrgencyStatus;
    }

    public void setCurrentUrgencyStatus(String currentUrgencyStatus) {
        this.currentUrgencyStatus = currentUrgencyStatus == null ? null : currentUrgencyStatus.trim();
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact == null ? null : contact.trim();
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone == null ? null : telephone.trim();
    }

    public Boolean getFlagDeleted() {
        return flagDeleted;
    }

    public void setFlagDeleted(Boolean flagDeleted) {
        this.flagDeleted = flagDeleted;
    }

    public Boolean getNeedAssessment() {
        return needAssessment;
    }

    public void setNeedAssessment(Boolean needAssessment) {
        this.needAssessment = needAssessment;
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

    public String getProcessStatus() {
        return processStatus;
    }

    public void setProcessStatus(String processStatus) {
        this.processStatus = processStatus == null ? null : processStatus.trim();
    }

    public Integer getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Integer getDealLastTime() {
        return dealLastTime;
    }

    public void setDealLastTime(Integer dealLastTime) {
        this.dealLastTime = dealLastTime;
    }

    public Integer getDealPerson() {
        return dealPerson;
    }

    public void setDealPerson(Integer dealPerson) {
        this.dealPerson = dealPerson;
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

    public Date getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(Date lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    public Integer getLastUpdatePerson() {
        return lastUpdatePerson;
    }

    public void setLastUpdatePerson(Integer lastUpdatePerson) {
        this.lastUpdatePerson = lastUpdatePerson;
    }

    public String getOrderContent() {
        return orderContent;
    }

    public void setOrderContent(String orderContent) {
        this.orderContent = orderContent == null ? null : orderContent.trim();
    }
}