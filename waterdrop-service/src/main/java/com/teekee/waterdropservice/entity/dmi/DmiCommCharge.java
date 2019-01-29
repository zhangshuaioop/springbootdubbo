package com.teekee.waterdropservice.entity.dmi;

import com.teekee.commoncomponets.base.BaseEntity;
import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;
import java.util.Date;

public class DmiCommCharge extends BaseEntity {
    private Integer id;

    private Integer storeId;

    private Integer companyId;

    private Integer objectId;

    private String objectType;

    private String chargeType;

    @ApiModelProperty(value = "付费方式", example = "1", required = true)
    private String paymentMethod;

    @ApiModelProperty(value = "付费频率", example = "1", required = true)
    private String payFrequency;

    private String tenementFrequency;

    private Date chargeStartDate;

    private Date chargeEndDate;

    private Date chargeExitDate;

    private Integer chargeMonths;

    private BigDecimal totalFee;

    private BigDecimal tenementOneTimeFee;

    private BigDecimal fiberFee;

    private BigDecimal commOneTimeFee;

    private BigDecimal commPeriodFee;

    private BigDecimal tenementPeriodFee;

    private BigDecimal estimatedChargeFee;

    private Integer estimatedChargeTimes;

    private BigDecimal actualChargeFee;

    private Integer renewMonths;

    private Boolean flagAutoRenew;

    private Boolean flagAutoRenewContract;

    private Integer actualChargeTimes;

    private Boolean flagAvaliable;

    private Boolean flagStartCharge;

    private String memo;

    private Boolean flagDeleted;

    private Integer createPerson;

    private Date createTime;

    private Integer updatePerson;

    private Date updateTime;

    private Boolean flagLastest;

    private boolean flagChargeAgency;

    public boolean isFlagChargeAgency() {
        return flagChargeAgency;
    }

    public void setFlagChargeAgency(boolean flagChargeAgency) {
        this.flagChargeAgency = flagChargeAgency;
    }

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

    public String getChargeType() {
        return chargeType;
    }

    public void setChargeType(String chargeType) {
        this.chargeType = chargeType == null ? null : chargeType.trim();
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod == null ? null : paymentMethod.trim();
    }

    public String getPayFrequency() {
        return payFrequency;
    }

    public void setPayFrequency(String payFrequency) {
        this.payFrequency = payFrequency == null ? null : payFrequency.trim();
    }

    public String getTenementFrequency() {
        return tenementFrequency;
    }

    public void setTenementFrequency(String tenementFrequency) {
        this.tenementFrequency = tenementFrequency == null ? null : tenementFrequency.trim();
    }

    public Date getChargeStartDate() {
        return chargeStartDate;
    }

    public void setChargeStartDate(Date chargeStartDate) {
        this.chargeStartDate = chargeStartDate;
    }

    public Date getChargeEndDate() {
        return chargeEndDate;
    }

    public void setChargeEndDate(Date chargeEndDate) {
        this.chargeEndDate = chargeEndDate;
    }

    public Date getChargeExitDate() {
        return chargeExitDate;
    }

    public void setChargeExitDate(Date chargeExitDate) {
        this.chargeExitDate = chargeExitDate;
    }

    public Integer getChargeMonths() {
        return chargeMonths;
    }

    public void setChargeMonths(Integer chargeMonths) {
        this.chargeMonths = chargeMonths;
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

    public BigDecimal getCommOneTimeFee() {
        return commOneTimeFee;
    }

    public void setCommOneTimeFee(BigDecimal commOneTimeFee) {
        this.commOneTimeFee = commOneTimeFee;
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

    public BigDecimal getEstimatedChargeFee() {
        return estimatedChargeFee;
    }

    public void setEstimatedChargeFee(BigDecimal estimatedChargeFee) {
        this.estimatedChargeFee = estimatedChargeFee;
    }

    public Integer getEstimatedChargeTimes() {
        return estimatedChargeTimes;
    }

    public void setEstimatedChargeTimes(Integer estimatedChargeTimes) {
        this.estimatedChargeTimes = estimatedChargeTimes;
    }

    public BigDecimal getActualChargeFee() {
        return actualChargeFee;
    }

    public void setActualChargeFee(BigDecimal actualChargeFee) {
        this.actualChargeFee = actualChargeFee;
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

    public Integer getActualChargeTimes() {
        return actualChargeTimes;
    }

    public void setActualChargeTimes(Integer actualChargeTimes) {
        this.actualChargeTimes = actualChargeTimes;
    }

    public Boolean getFlagAvaliable() {
        return flagAvaliable;
    }

    public void setFlagAvaliable(Boolean flagAvaliable) {
        this.flagAvaliable = flagAvaliable;
    }

    public Boolean getFlagStartCharge() {
        return flagStartCharge;
    }

    public void setFlagStartCharge(Boolean flagStartCharge) {
        this.flagStartCharge = flagStartCharge;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo == null ? null : memo.trim();
    }

    public Boolean getFlagDeleted() {
        return flagDeleted;
    }

    public void setFlagDeleted(Boolean flagDeleted) {
        this.flagDeleted = flagDeleted;
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
}