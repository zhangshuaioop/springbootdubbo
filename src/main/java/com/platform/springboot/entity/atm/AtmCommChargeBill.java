package com.platform.springboot.entity.atm;

import java.math.BigDecimal;
import java.util.Date;

public class AtmCommChargeBill {
    private Integer id;

    private Integer companyId;

    private String billNumber;

    private BigDecimal estimatedFee;

    private BigDecimal actualFee;

    private Integer productCount;

    private String memo;

    private Boolean flagStartProvideInvoice;

    private Boolean flagProvideInvoice;

    private Boolean flagCompletedCharge;

    private Boolean flagDeleted;

    private Date createBillTime;

    private Integer createBillPerson;

    private Date updateBillTime;

    private Integer updateBillPerson;

    private Date updateTime;

    private Integer updatePerson;

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

    public String getBillNumber() {
        return billNumber;
    }

    public void setBillNumber(String billNumber) {
        this.billNumber = billNumber == null ? null : billNumber.trim();
    }

    public BigDecimal getEstimatedFee() {
        return estimatedFee;
    }

    public void setEstimatedFee(BigDecimal estimatedFee) {
        this.estimatedFee = estimatedFee;
    }

    public BigDecimal getActualFee() {
        return actualFee;
    }

    public void setActualFee(BigDecimal actualFee) {
        this.actualFee = actualFee;
    }

    public Integer getProductCount() {
        return productCount;
    }

    public void setProductCount(Integer productCount) {
        this.productCount = productCount;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo == null ? null : memo.trim();
    }

    public Boolean getFlagStartProvideInvoice() {
        return flagStartProvideInvoice;
    }

    public void setFlagStartProvideInvoice(Boolean flagStartProvideInvoice) {
        this.flagStartProvideInvoice = flagStartProvideInvoice;
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

    public Boolean getFlagDeleted() {
        return flagDeleted;
    }

    public void setFlagDeleted(Boolean flagDeleted) {
        this.flagDeleted = flagDeleted;
    }

    public Date getCreateBillTime() {
        return createBillTime;
    }

    public void setCreateBillTime(Date createBillTime) {
        this.createBillTime = createBillTime;
    }

    public Integer getCreateBillPerson() {
        return createBillPerson;
    }

    public void setCreateBillPerson(Integer createBillPerson) {
        this.createBillPerson = createBillPerson;
    }

    public Date getUpdateBillTime() {
        return updateBillTime;
    }

    public void setUpdateBillTime(Date updateBillTime) {
        this.updateBillTime = updateBillTime;
    }

    public Integer getUpdateBillPerson() {
        return updateBillPerson;
    }

    public void setUpdateBillPerson(Integer updateBillPerson) {
        this.updateBillPerson = updateBillPerson;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getUpdatePerson() {
        return updatePerson;
    }

    public void setUpdatePerson(Integer updatePerson) {
        this.updatePerson = updatePerson;
    }
}