package com.company.springboot.entity.ret.atm.atmCommChargeInvoice;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 已出票发票列表-返回结果
 *
 * @author Wujun
 * @create 2017年09月21日 13:58
 */
public class DrawListRet {

    private int id;

    private String invoiceNumber;

    private String invoiceTitle;

    private BigDecimal invoiceFee;

    private String invoiceType;

    private Date createInvoiceTime;

    private Date updateTime;

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getInvoiceNumber() {
        return invoiceNumber;
    }

    public void setInvoiceNumber(String invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    public String getInvoiceTitle() {
        return invoiceTitle;
    }

    public void setInvoiceTitle(String invoiceTitle) {
        this.invoiceTitle = invoiceTitle;
    }

    public BigDecimal getInvoiceFee() {
        return invoiceFee;
    }

    public void setInvoiceFee(BigDecimal invoiceFee) {
        this.invoiceFee = invoiceFee;
    }

    public String getInvoiceType() {
        return invoiceType;
    }

    public void setInvoiceType(String invoiceType) {
        this.invoiceType = invoiceType;
    }

    public Date getCreateInvoiceTime() {
        return createInvoiceTime;
    }

    public void setCreateInvoiceTime(Date createInvoiceTime) {
        this.createInvoiceTime = createInvoiceTime;
    }
}
