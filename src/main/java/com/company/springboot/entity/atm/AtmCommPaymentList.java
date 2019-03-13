package com.company.springboot.entity.atm;

import java.math.BigDecimal;
import java.util.Date;

public class AtmCommPaymentList {
    private Integer id;

    private Integer objectId;

    private String objectType;

    private Integer contractId;

    private String accountPeriodNumber;

    private Date accountPeriodStart;

    private Date accountPeriodEnd;

    private Integer accountIndex;

    private Integer accountTotal;

    private BigDecimal commPeriodFee;

    private BigDecimal fiberDeviceFee;

    private BigDecimal firstInstallFee;

    private BigDecimal fiberFee;

    private BigDecimal tenementOneTimeFee;

    private BigDecimal tenementPeriodFee;

    private BigDecimal expectedTotalFee;

    private BigDecimal actualChargeFee;

    private String paymentBillId;

    private Boolean flagFeeDifferent;

    private Boolean flagChangeFee;

    private Boolean flagProvideInvoice;

    private Boolean flagCompletedCharge;

    private Boolean flagActivate;

    private Boolean flagClosed;

    private String memo;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Integer getContractId() {
        return contractId;
    }

    public void setContractId(Integer contractId) {
        this.contractId = contractId;
    }

    public String getAccountPeriodNumber() {
        return accountPeriodNumber;
    }

    public void setAccountPeriodNumber(String accountPeriodNumber) {
        this.accountPeriodNumber = accountPeriodNumber == null ? null : accountPeriodNumber.trim();
    }

    public Date getAccountPeriodStart() {
        return accountPeriodStart;
    }

    public void setAccountPeriodStart(Date accountPeriodStart) {
        this.accountPeriodStart = accountPeriodStart;
    }

    public Date getAccountPeriodEnd() {
        return accountPeriodEnd;
    }

    public void setAccountPeriodEnd(Date accountPeriodEnd) {
        this.accountPeriodEnd = accountPeriodEnd;
    }

    public Integer getAccountIndex() {
        return accountIndex;
    }

    public void setAccountIndex(Integer accountIndex) {
        this.accountIndex = accountIndex;
    }

    public Integer getAccountTotal() {
        return accountTotal;
    }

    public void setAccountTotal(Integer accountTotal) {
        this.accountTotal = accountTotal;
    }

    public BigDecimal getCommPeriodFee() {
        return commPeriodFee;
    }

    public void setCommPeriodFee(BigDecimal commPeriodFee) {
        this.commPeriodFee = commPeriodFee;
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

    public BigDecimal getFiberFee() {
        return fiberFee;
    }

    public void setFiberFee(BigDecimal fiberFee) {
        this.fiberFee = fiberFee;
    }

    public BigDecimal getTenementOneTimeFee() {
        return tenementOneTimeFee;
    }

    public void setTenementOneTimeFee(BigDecimal tenementOneTimeFee) {
        this.tenementOneTimeFee = tenementOneTimeFee;
    }

    public BigDecimal getTenementPeriodFee() {
        return tenementPeriodFee;
    }

    public void setTenementPeriodFee(BigDecimal tenementPeriodFee) {
        this.tenementPeriodFee = tenementPeriodFee;
    }

    public BigDecimal getExpectedTotalFee() {
        return expectedTotalFee;
    }

    public void setExpectedTotalFee(BigDecimal expectedTotalFee) {
        this.expectedTotalFee = expectedTotalFee;
    }

    public BigDecimal getActualChargeFee() {
        return actualChargeFee;
    }

    public void setActualChargeFee(BigDecimal actualChargeFee) {
        this.actualChargeFee = actualChargeFee;
    }

    public String getPaymentBillId() {
        return paymentBillId;
    }

    public void setPaymentBillId(String paymentBillId) {
        this.paymentBillId = paymentBillId == null ? null : paymentBillId.trim();
    }

    public Boolean getFlagFeeDifferent() {
        return flagFeeDifferent;
    }

    public void setFlagFeeDifferent(Boolean flagFeeDifferent) {
        this.flagFeeDifferent = flagFeeDifferent;
    }

    public Boolean getFlagChangeFee() {
        return flagChangeFee;
    }

    public void setFlagChangeFee(Boolean flagChangeFee) {
        this.flagChangeFee = flagChangeFee;
    }

    public Boolean getFlagProvideInvoice() {
        return flagProvideInvoice;
    }

    public void setFlagProvideInvoice(Boolean flagProvideInvoice) {
        this.flagProvideInvoice = flagProvideInvoice;
    }

    public Boolean getFlagCompletedCharge() {
        return flagCompletedCharge;
    }

    public void setFlagCompletedCharge(Boolean flagCompletedCharge) {
        this.flagCompletedCharge = flagCompletedCharge;
    }

    public Boolean getFlagActivate() {
        return flagActivate;
    }

    public void setFlagActivate(Boolean flagActivate) {
        this.flagActivate = flagActivate;
    }

    public Boolean getFlagClosed() {
        return flagClosed;
    }

    public void setFlagClosed(Boolean flagClosed) {
        this.flagClosed = flagClosed;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo == null ? null : memo.trim();
    }
}