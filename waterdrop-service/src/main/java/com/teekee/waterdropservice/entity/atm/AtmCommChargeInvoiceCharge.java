package com.teekee.waterdropservice.entity.atm;

import java.math.BigDecimal;
import java.util.Date;

public class AtmCommChargeInvoiceCharge {
    private Integer id;

    private Integer companyId;

    private Integer billId;

    private String invoiceId;

    private BigDecimal chargeFee;

    private BigDecimal remainFee;

    private String memo;

    private Date chargeTime;

    private Integer chargePerson;

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

    public Integer getBillId() {
        return billId;
    }

    public void setBillId(Integer billId) {
        this.billId = billId;
    }

    public String getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(String invoiceId) {
        this.invoiceId = invoiceId == null ? null : invoiceId.trim();
    }

    public BigDecimal getChargeFee() {
        return chargeFee;
    }

    public void setChargeFee(BigDecimal chargeFee) {
        this.chargeFee = chargeFee;
    }

    public BigDecimal getRemainFee() {
        return remainFee;
    }

    public void setRemainFee(BigDecimal remainFee) {
        this.remainFee = remainFee;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo == null ? null : memo.trim();
    }

    public Date getChargeTime() {
        return chargeTime;
    }

    public void setChargeTime(Date chargeTime) {
        this.chargeTime = chargeTime;
    }

    public Integer getChargePerson() {
        return chargePerson;
    }

    public void setChargePerson(Integer chargePerson) {
        this.chargePerson = chargePerson;
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