package com.company.springboot.entity.fdp;

import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @Author Niting
 * @date 2018/10/22
 **/
public class GetFdpFaultDispatchHrRelationShow {
    private String firstName;
    private String lastName;
    private String mobile;
    private BigDecimal actualCost;
    private String actualMonetaryUnit;
    private String fullName;
    private String bankName;
    private String account;
    private String alipayAccount;
    private String paymentMethod;
    private String actualInvoiceType;
    private BigDecimal actualInvoiceRate;
    private String memo;
    private BigDecimal estimatedCost;
    private String estimatedMonetaryUnit;
    private String estimatedPriceUnit;
    private BigDecimal estimatedPrice;
    private String estimatedInvoiceType;
    private BigDecimal estimatedInvoiceRate;
    private BigDecimal actualPrice;
    private String actualPriceUnit;
    private String estimatedPriceMemo;
    private String estimatedCostMemo;
    private String actualCostMemo;
    private String actualPriceMemo;
    private String dispatchOrderNumber;
    private Date estimatedServiceTime;
    private String phone;
    private Date hrFinishServiceTime;
    private Date hrStartOffTime;
    private Date hrStartServiceTime;
    private Date userCompleteTime;
    private boolean flagDisplay;
    private Integer requestId;
    private String materialRejectCauseContext;
    private String personRejectCauseContext;

    @ApiModelProperty(value = "预计设备费用", example = "1", required = true)
    private BigDecimal estimatedDeviceCost;
    @ApiModelProperty(value = "预计设备费用备注", example = "1", required = true)
    private String estimatedDeviceMemo;

    @ApiModelProperty(value = "预计通信线路费用", example = "1", required = true)
    private BigDecimal estimatedCommResourceCost;
    @ApiModelProperty(value = "预计通信线路费用备注", example = "1", required = true)
    private String estimatedCommResourceMemo;

    @ApiModelProperty(value = "预计人力费用", example = "1", required = true)
    private BigDecimal estimatedHrCost;
    @ApiModelProperty(value = "预计人力费用备注", example = "1", required = true)
    private String estimatedHrMemo;

    @ApiModelProperty(value = "预计其他费用", example = "1", required = true)
    private BigDecimal estimatedOtherCost;
    @ApiModelProperty(value = "预计其他费用备注", example = "1", required = true)
    private String estimatedOtherMemo;

    @ApiModelProperty(value = "实际设备费用", example = "1", required = true)
    private BigDecimal actualDeviceCost;
    @ApiModelProperty(value = "实际设备费用备注", example = "1", required = true)
    private String actualDeviceMemo;

    @ApiModelProperty(value = "实际通信线路费用", example = "1", required = true)
    private BigDecimal actualCommResourceCost;
    @ApiModelProperty(value = "实际通信线路费用备注", example = "1", required = true)
    private String actualCommResourceMemo;

    @ApiModelProperty(value = "实际人力费用", example = "1", required = true)
    private BigDecimal actualHrCost;
    @ApiModelProperty(value = "实际人力费用备注", example = "1", required = true)
    private String actualHrMemo;

    @ApiModelProperty(value = "实际其他费用", example = "1", required = true)
    private BigDecimal actualOtherCost;
    @ApiModelProperty(value = "实际其他费用备注", example = "1", required = true)
    private String actualOtherMemo;

    public BigDecimal getEstimatedDeviceCost() {
        return estimatedDeviceCost;
    }

    public void setEstimatedDeviceCost(BigDecimal estimatedDeviceCost) {
        this.estimatedDeviceCost = estimatedDeviceCost;
    }

    public String getEstimatedDeviceMemo() {
        return estimatedDeviceMemo;
    }

    public void setEstimatedDeviceMemo(String estimatedDeviceMemo) {
        this.estimatedDeviceMemo = estimatedDeviceMemo;
    }

    public BigDecimal getEstimatedCommResourceCost() {
        return estimatedCommResourceCost;
    }

    public void setEstimatedCommResourceCost(BigDecimal estimatedCommResourceCost) {
        this.estimatedCommResourceCost = estimatedCommResourceCost;
    }

    public String getEstimatedCommResourceMemo() {
        return estimatedCommResourceMemo;
    }

    public void setEstimatedCommResourceMemo(String estimatedCommResourceMemo) {
        this.estimatedCommResourceMemo = estimatedCommResourceMemo;
    }

    public BigDecimal getEstimatedHrCost() {
        return estimatedHrCost;
    }

    public void setEstimatedHrCost(BigDecimal estimatedHrCost) {
        this.estimatedHrCost = estimatedHrCost;
    }

    public String getEstimatedHrMemo() {
        return estimatedHrMemo;
    }

    public void setEstimatedHrMemo(String estimatedHrMemo) {
        this.estimatedHrMemo = estimatedHrMemo;
    }

    public BigDecimal getEstimatedOtherCost() {
        return estimatedOtherCost;
    }

    public void setEstimatedOtherCost(BigDecimal estimatedOtherCost) {
        this.estimatedOtherCost = estimatedOtherCost;
    }

    public String getEstimatedOtherMemo() {
        return estimatedOtherMemo;
    }

    public void setEstimatedOtherMemo(String estimatedOtherMemo) {
        this.estimatedOtherMemo = estimatedOtherMemo;
    }

    public BigDecimal getActualDeviceCost() {
        return actualDeviceCost;
    }

    public void setActualDeviceCost(BigDecimal actualDeviceCost) {
        this.actualDeviceCost = actualDeviceCost;
    }

    public String getActualDeviceMemo() {
        return actualDeviceMemo;
    }

    public void setActualDeviceMemo(String actualDeviceMemo) {
        this.actualDeviceMemo = actualDeviceMemo;
    }

    public BigDecimal getActualCommResourceCost() {
        return actualCommResourceCost;
    }

    public void setActualCommResourceCost(BigDecimal actualCommResourceCost) {
        this.actualCommResourceCost = actualCommResourceCost;
    }

    public String getActualCommResourceMemo() {
        return actualCommResourceMemo;
    }

    public void setActualCommResourceMemo(String actualCommResourceMemo) {
        this.actualCommResourceMemo = actualCommResourceMemo;
    }

    public BigDecimal getActualHrCost() {
        return actualHrCost;
    }

    public void setActualHrCost(BigDecimal actualHrCost) {
        this.actualHrCost = actualHrCost;
    }

    public String getActualHrMemo() {
        return actualHrMemo;
    }

    public void setActualHrMemo(String actualHrMemo) {
        this.actualHrMemo = actualHrMemo;
    }

    public BigDecimal getActualOtherCost() {
        return actualOtherCost;
    }

    public void setActualOtherCost(BigDecimal actualOtherCost) {
        this.actualOtherCost = actualOtherCost;
    }

    public String getActualOtherMemo() {
        return actualOtherMemo;
    }

    public void setActualOtherMemo(String actualOtherMemo) {
        this.actualOtherMemo = actualOtherMemo;
    }

    public Date getHrFinishServiceTime() {
        return hrFinishServiceTime;
    }

    public void setHrFinishServiceTime(Date hrFinishServiceTime) {
        this.hrFinishServiceTime = hrFinishServiceTime;
    }

    public Date getHrStartOffTime() {
        return hrStartOffTime;
    }

    public void setHrStartOffTime(Date hrStartOffTime) {
        this.hrStartOffTime = hrStartOffTime;
    }

    public Date getHrStartServiceTime() {
        return hrStartServiceTime;
    }

    public void setHrStartServiceTime(Date hrStartServiceTime) {
        this.hrStartServiceTime = hrStartServiceTime;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getEstimatedServiceTime() {
        return estimatedServiceTime;
    }

    public void setEstimatedServiceTime(Date estimatedServiceTime) {
        this.estimatedServiceTime = estimatedServiceTime;
    }

    public String getDispatchOrderNumber() {
        return dispatchOrderNumber;
    }

    public void setDispatchOrderNumber(String dispatchOrderNumber) {
        this.dispatchOrderNumber = dispatchOrderNumber;
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

    public String getEstimatedPriceMemo() {
        return estimatedPriceMemo;
    }

    public void setEstimatedPriceMemo(String estimatedPriceMemo) {
        this.estimatedPriceMemo = estimatedPriceMemo;
    }

    public String getEstimatedCostMemo() {
        return estimatedCostMemo;
    }

    public void setEstimatedCostMemo(String estimatedCostMemo) {
        this.estimatedCostMemo = estimatedCostMemo;
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

    public Date getUserCompleteTime() {
        return userCompleteTime;
    }

    public void setUserCompleteTime(Date userCompleteTime) {
        this.userCompleteTime = userCompleteTime;
    }

    public boolean getFlagDisplay() {
        return flagDisplay;
    }

    public void setFlagDisplay(boolean flagDisplay) {
        this.flagDisplay = flagDisplay;
    }

    public Integer getRequestId() {
        return requestId;
    }

    public void setRequestId(Integer requestId) {
        this.requestId = requestId;
    }

    public String getMaterialRejectCauseContext() {
        return materialRejectCauseContext;
    }

    public void setMaterialRejectCauseContext(String materialRejectCauseContext) {
        this.materialRejectCauseContext = materialRejectCauseContext;
    }

    public String getPersonRejectCauseContext() {
        return personRejectCauseContext;
    }

    public void setPersonRejectCauseContext(String personRejectCauseContext) {
        this.personRejectCauseContext = personRejectCauseContext;
    }

    @Override
    public String toString() {
        return "GetFdpFaultDispatchHrRelationShow{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", mobile='" + mobile + '\'' +
                ", actualCost=" + actualCost +
                ", actualMonetaryUnit='" + actualMonetaryUnit + '\'' +
                ", fullName='" + fullName + '\'' +
                ", bankName='" + bankName + '\'' +
                ", account='" + account + '\'' +
                ", alipayAccount='" + alipayAccount + '\'' +
                ", paymentMethod='" + paymentMethod + '\'' +
                ", actualInvoiceType='" + actualInvoiceType + '\'' +
                ", actualInvoiceRate=" + actualInvoiceRate +
                ", memo='" + memo + '\'' +
                ", estimatedCost=" + estimatedCost +
                ", estimatedMonetaryUnit='" + estimatedMonetaryUnit + '\'' +
                ", estimatedPriceUnit='" + estimatedPriceUnit + '\'' +
                ", estimatedPrice=" + estimatedPrice +
                ", estimatedInvoiceType='" + estimatedInvoiceType + '\'' +
                ", estimatedInvoiceRate=" + estimatedInvoiceRate +
                ", actualPrice=" + actualPrice +
                ", actualPriceUnit='" + actualPriceUnit + '\'' +
                ", estimatedPriceMemo='" + estimatedPriceMemo + '\'' +
                ", estimatedCostMemo='" + estimatedCostMemo + '\'' +
                ", actualCostMemo='" + actualCostMemo + '\'' +
                ", actualPriceMemo='" + actualPriceMemo + '\'' +
                ", dispatchOrderNumber='" + dispatchOrderNumber + '\'' +
                ", estimatedServiceTime=" + estimatedServiceTime +
                ", phone='" + phone + '\'' +
                ", hrFinishServiceTime=" + hrFinishServiceTime +
                ", hrStartOffTime=" + hrStartOffTime +
                ", hrStartServiceTime=" + hrStartServiceTime +
                ", userCompleteTime=" + userCompleteTime +
                ", flagDisplay=" + flagDisplay +
                ", requestId=" + requestId +
                ", materialRejectCauseContext='" + materialRejectCauseContext + '\'' +
                ", personRejectCauseContext='" + personRejectCauseContext + '\'' +
                '}';
    }
}

