package com.company.springboot.entity.atm;

import javax.validation.constraints.Min;
import java.math.BigDecimal;
import java.util.Date;

public class AtmCommChargeInvoice {
    private Integer id;

    private Integer companyId;

    private Integer billId;

    private String invoiceNumber;

    private Date invoiceDate;

    private BigDecimal invoiceFee;

    private BigDecimal invoiceRate;

    @Min(value = 1, message = "发票模板不能为空！")
    private Integer invoiceModelId;

    private String memo;

    private Boolean flagStartCharge;

    private Boolean flagFinishCharge;

    private Boolean flagDeleted;

    private Date createInvoiceTime;

    private Integer createInvoicePerson;

    private Date updateInvoiceTime;

    private Integer updateInvoicePerson;

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

    public String getInvoiceNumber() {
        return invoiceNumber;
    }

    public void setInvoiceNumber(String invoiceNumber) {
        this.invoiceNumber = invoiceNumber == null ? null : invoiceNumber.trim();
    }

    public Date getInvoiceDate() {
        return invoiceDate;
    }

    public void setInvoiceDate(Date invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    public BigDecimal getInvoiceFee() {
        return invoiceFee;
    }

    public void setInvoiceFee(BigDecimal invoiceFee) {
        this.invoiceFee = invoiceFee;
    }

    public BigDecimal getInvoiceRate() {
        return invoiceRate;
    }

    public void setInvoiceRate(BigDecimal invoiceRate) {
        this.invoiceRate = invoiceRate;
    }

    public Integer getInvoiceModelId() {
        return invoiceModelId;
    }

    public void setInvoiceModelId(Integer invoiceModelId) {
        this.invoiceModelId = invoiceModelId;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo == null ? null : memo.trim();
    }

    public Boolean getFlagStartCharge() {
        return flagStartCharge;
    }

    public void setFlagStartCharge(Boolean flagStartCharge) {
        this.flagStartCharge = flagStartCharge;
    }

    public Boolean getFlagFinishCharge() {
        return flagFinishCharge;
    }

    public void setFlagFinishCharge(Boolean flagFinishCharge) {
        this.flagFinishCharge = flagFinishCharge;
    }

    public Boolean getFlagDeleted() {
        return flagDeleted;
    }

    public void setFlagDeleted(Boolean flagDeleted) {
        this.flagDeleted = flagDeleted;
    }

    public Date getCreateInvoiceTime() {
        return createInvoiceTime;
    }

    public void setCreateInvoiceTime(Date createInvoiceTime) {
        this.createInvoiceTime = createInvoiceTime;
    }

    public Integer getCreateInvoicePerson() {
        return createInvoicePerson;
    }

    public void setCreateInvoicePerson(Integer createInvoicePerson) {
        this.createInvoicePerson = createInvoicePerson;
    }

    public Date getUpdateInvoiceTime() {
        return updateInvoiceTime;
    }

    public void setUpdateInvoiceTime(Date updateInvoiceTime) {
        this.updateInvoiceTime = updateInvoiceTime;
    }

    public Integer getUpdateInvoicePerson() {
        return updateInvoicePerson;
    }

    public void setUpdateInvoicePerson(Integer updateInvoicePerson) {
        this.updateInvoicePerson = updateInvoicePerson;
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