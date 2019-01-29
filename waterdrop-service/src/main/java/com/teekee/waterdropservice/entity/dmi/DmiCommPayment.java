package com.teekee.waterdropservice.entity.dmi;

import com.teekee.commoncomponets.base.BaseEntity;

import java.math.BigDecimal;
import java.util.Date;

public class DmiCommPayment extends BaseEntity {
    private Integer id;

    private Integer storeId;

    private Integer companyId;

    private Integer objectId;

    private String objectType;

    private String paymentType;

    private String payFrequency;

    private String paymentMethod;

    private Date paymentStartDate;

    private Date paymentEndDate;

    private Date paymentExitDate;

    private Integer paymentMonths;

    private BigDecimal totalFee;

    private BigDecimal tenementOneTimeFee;

    private BigDecimal fiberFee;

    private BigDecimal fiberDeviceFee;

    private BigDecimal firstInstallFee;

    private BigDecimal commPeriodFee;

    private BigDecimal tenementPeriodFee;

    private BigDecimal estimatedPaymentFee;

    private Integer estimatedPaymentTimes;

    private BigDecimal actualPaymentFee;

    private Integer actualPaymentTimes;

    private String tenementFrequency;

    private Integer renewMonths;

    private Boolean flagAutoRenew;

    private Boolean flagAutoRenewContract;

    private Boolean flagAvaliable;

    private Boolean flagDeleted;

    private Boolean flagStartPay;

    private String memo;

    private Integer createPerson;

    private Date createTime;

    private Integer updatePerson;

    private Date updateTime;

    private Boolean flagLastest;

    private BigDecimal returnAmount;

    public Boolean getFlagLastest() {
        return flagLastest;
    }

    public void setFlagLastest(Boolean flagLastest) {
        this.flagLastest = flagLastest;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getStoreId() {
        return storeId;
    }

    public void setStoreId(Integer storeId) {
        this.storeId = storeId;
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public Integer getObjectId() {
        return objectId;
    }

    public void setObjectId(Integer objectId) {
        this.objectId = objectId;
    }

    public String getObjectType() {
        return objectType;
    }

    public void setObjectType(String objectType) {
        this.objectType = objectType == null ? null : objectType.trim();
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType == null ? null : paymentType.trim();
    }

    public String getPayFrequency() {
        return payFrequency;
    }

    public void setPayFrequency(String payFrequency) {
        this.payFrequency = payFrequency == null ? null : payFrequency.trim();
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod == null ? null : paymentMethod.trim();
    }

    public Date getPaymentStartDate() {
        return paymentStartDate;
    }

    public void setPaymentStartDate(Date paymentStartDate) {
        this.paymentStartDate = paymentStartDate;
    }

    public Date getPaymentEndDate() {
        return paymentEndDate;
    }

    public void setPaymentEndDate(Date paymentEndDate) {
        this.paymentEndDate = paymentEndDate;
    }

    public Date getPaymentExitDate() {
        return paymentExitDate;
    }

    public void setPaymentExitDate(Date paymentExitDate) {
        this.paymentExitDate = paymentExitDate;
    }

    public Integer getPaymentMonths() {
        return paymentMonths;
    }

    public void setPaymentMonths(Integer paymentMonths) {
        this.paymentMonths = paymentMonths;
    }

    public BigDecimal getTotalFee() {
        return totalFee;
    }

    public void setTotalFee(BigDecimal totalFee) {
        this.totalFee = totalFee;
    }

    public BigDecimal getTenementOneTimeFee() {
        return tenementOneTimeFee;
    }

    public void setTenementOneTimeFee(BigDecimal tenementOneTimeFee) {
        this.tenementOneTimeFee = tenementOneTimeFee;
    }

    public BigDecimal getFiberFee() {
        return fiberFee;
    }

    public void setFiberFee(BigDecimal fiberFee) {
        this.fiberFee = fiberFee;
    }

    public BigDecimal getFiberDeviceFee() {
        return fiberDeviceFee;
    }

    public void setFiberDeviceFee(BigDecimal fiberDeviceFee) {
        this.fiberDeviceFee = fiberDeviceFee;
    }

    public BigDecimal getFirstInstallFee() {
        return firstInstallFee;
    }

    public void setFirstInstallFee(BigDecimal firstInstallFee) {
        this.firstInstallFee = firstInstallFee;
    }

    public BigDecimal getCommPeriodFee() {
        return commPeriodFee;
    }

    public void setCommPeriodFee(BigDecimal commPeriodFee) {
        this.commPeriodFee = commPeriodFee;
    }

    public BigDecimal getTenementPeriodFee() {
        return tenementPeriodFee;
    }

    public void setTenementPeriodFee(BigDecimal tenementPeriodFee) {
        this.tenementPeriodFee = tenementPeriodFee;
    }

    public BigDecimal getEstimatedPaymentFee() {
        return estimatedPaymentFee;
    }

    public void setEstimatedPaymentFee(BigDecimal estimatedPaymentFee) {
        this.estimatedPaymentFee = estimatedPaymentFee;
    }

    public Integer getEstimatedPaymentTimes() {
        return estimatedPaymentTimes;
    }

    public void setEstimatedPaymentTimes(Integer estimatedPaymentTimes) {
        this.estimatedPaymentTimes = estimatedPaymentTimes;
    }

    public BigDecimal getActualPaymentFee() {
        return actualPaymentFee;
    }

    public void setActualPaymentFee(BigDecimal actualPaymentFee) {
        this.actualPaymentFee = actualPaymentFee;
    }

    public Integer getActualPaymentTimes() {
        return actualPaymentTimes;
    }

    public void setActualPaymentTimes(Integer actualPaymentTimes) {
        this.actualPaymentTimes = actualPaymentTimes;
    }

    public String getTenementFrequency() {
        return tenementFrequency;
    }

    public void setTenementFrequency(String tenementFrequency) {
        this.tenementFrequency = tenementFrequency == null ? null : tenementFrequency.trim();
    }

    public Integer getRenewMonths() {
        return renewMonths;
    }

    public void setRenewMonths(Integer renewMonths) {
        this.renewMonths = renewMonths;
    }

    public Boolean getFlagAutoRenew() {
        return flagAutoRenew;
    }

    public void setFlagAutoRenew(Boolean flagAutoRenew) {
        this.flagAutoRenew = flagAutoRenew;
    }

    public Boolean getFlagAutoRenewContract() {
        return flagAutoRenewContract;
    }

    public void setFlagAutoRenewContract(Boolean flagAutoRenewContract) {
        this.flagAutoRenewContract = flagAutoRenewContract;
    }

    public Boolean getFlagAvaliable() {
        return flagAvaliable;
    }

    public void setFlagAvaliable(Boolean flagAvaliable) {
        this.flagAvaliable = flagAvaliable;
    }

    public Boolean getFlagDeleted() {
        return flagDeleted;
    }

    public void setFlagDeleted(Boolean flagDeleted) {
        this.flagDeleted = flagDeleted;
    }

    public Boolean getFlagStartPay() {
        return flagStartPay;
    }

    public void setFlagStartPay(Boolean flagStartPay) {
        this.flagStartPay = flagStartPay;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo == null ? null : memo.trim();
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

    public BigDecimal getReturnAmount() {
        return returnAmount;
    }

    public void setReturnAmount(BigDecimal returnAmount) {
        this.returnAmount = returnAmount;
    }
}