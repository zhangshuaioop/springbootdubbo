package com.platform.springboot.entity.dco;

import java.util.Date;

public class DcoDemandCustomerOrderOperation {
    private Integer id;

    private Integer orderId;

    private Integer operationType;

    private String beforeStatus;

    private String afterStatus;

    private Boolean needAssessment;

    private Boolean upgradeUrgencyStatus;

    private Integer dealLastTime;

    private Date operationTime;

    private Integer operationPerson;

    private String operationContent;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getOperationType() {
        return operationType;
    }

    public void setOperationType(Integer operationType) {
        this.operationType = operationType;
    }

    public String getBeforeStatus() {
        return beforeStatus;
    }

    public void setBeforeStatus(String beforeStatus) {
        this.beforeStatus = beforeStatus == null ? null : beforeStatus.trim();
    }

    public String getAfterStatus() {
        return afterStatus;
    }

    public void setAfterStatus(String afterStatus) {
        this.afterStatus = afterStatus == null ? null : afterStatus.trim();
    }

    public Boolean getNeedAssessment() {
        return needAssessment;
    }

    public void setNeedAssessment(Boolean needAssessment) {
        this.needAssessment = needAssessment;
    }

    public Boolean getUpgradeUrgencyStatus() {
        return upgradeUrgencyStatus;
    }

    public void setUpgradeUrgencyStatus(Boolean upgradeUrgencyStatus) {
        this.upgradeUrgencyStatus = upgradeUrgencyStatus;
    }

    public Integer getDealLastTime() {
        return dealLastTime;
    }

    public void setDealLastTime(Integer dealLastTime) {
        this.dealLastTime = dealLastTime;
    }

    public Date getOperationTime() {
        return operationTime;
    }

    public void setOperationTime(Date operationTime) {
        this.operationTime = operationTime;
    }

    public Integer getOperationPerson() {
        return operationPerson;
    }

    public void setOperationPerson(Integer operationPerson) {
        this.operationPerson = operationPerson;
    }

    public String getOperationContent() {
        return operationContent;
    }

    public void setOperationContent(String operationContent) {
        this.operationContent = operationContent == null ? null : operationContent.trim();
    }
}