package com.platform.springboot.entity.fdp;

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
    private Date userCompletetime;
    private boolean flagDisplay;

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

    public Date getUserCompletetime() {
        return userCompletetime;
    }

    public void setUserCompletetime(Date userCompletetime) {
        this.userCompletetime = userCompletetime;
    }

    public boolean getFlagDisplay() {
        return flagDisplay;
    }

    public void setFlagDisplay(boolean flagDisplay) {
        this.flagDisplay = flagDisplay;
    }
}

