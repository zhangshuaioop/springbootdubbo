package com.platform.springboot.entity.ret.atm.atmCommChargeInvoiceCharge;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 销账记录-返回结果
 *
 * @author Wujun
 * @create 2017年09月22日 15:41
 */
public class InvoiceChargeListRet {

    private String invoiceNumber;

    private String invoiceTitle;

    private BigDecimal invoiceFee;

    private BigDecimal remainFee;

    private BigDecimal chargeFee;

    private Date chargeTime;

    private Date updateTime;

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
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

    public BigDecimal getRemainFee() {
        return remainFee;
    }

    public void setRemainFee(BigDecimal remainFee) {
        this.remainFee = remainFee;
    }

    public BigDecimal getChargeFee() {
        return chargeFee;
    }

    public void setChargeFee(BigDecimal chargeFee) {
        this.chargeFee = chargeFee;
    }

    public Date getChargeTime() {
        return chargeTime;
    }

    public void setChargeTime(Date chargeTime) {
        this.chargeTime = chargeTime;
    }
}
