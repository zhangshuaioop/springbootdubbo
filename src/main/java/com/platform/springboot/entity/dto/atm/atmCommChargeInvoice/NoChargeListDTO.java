package com.platform.springboot.entity.dto.atm.atmCommChargeInvoice;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 待销账发票列表-DTO
 *
 * @author Wujun
 * @create 2017年09月22日 11:34
 */
public class NoChargeListDTO {

    private int companyId;

    private String invoiceType;

    private String invoiceNumber;

    private Date invoiceDateStart;

    private Date invoiceDateEnd;

    private String invoiceAccount;

    private String taxpayerNumber;

    private BigDecimal invoiceFeeStart;

    private BigDecimal invoiceFeeEnd;

    private String invoiceTitle;

    private String billNumber;

    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    public String getInvoiceType() {
        return invoiceType;
    }

    public void setInvoiceType(String invoiceType) {
        this.invoiceType = invoiceType;
    }

    public String getInvoiceNumber() {
        return invoiceNumber;
    }

    public void setInvoiceNumber(String invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    public Date getInvoiceDateStart() {
        return invoiceDateStart;
    }

    public void setInvoiceDateStart(Date invoiceDateStart) {
        this.invoiceDateStart = invoiceDateStart;
    }

    public Date getInvoiceDateEnd() {
        return invoiceDateEnd;
    }

    public void setInvoiceDateEnd(Date invoiceDateEnd) {
        this.invoiceDateEnd = invoiceDateEnd;
    }

    public String getInvoiceAccount() {
        return invoiceAccount;
    }

    public void setInvoiceAccount(String invoiceAccount) {
        this.invoiceAccount = invoiceAccount;
    }

    public String getTaxpayerNumber() {
        return taxpayerNumber;
    }

    public void setTaxpayerNumber(String taxpayerNumber) {
        this.taxpayerNumber = taxpayerNumber;
    }

    public BigDecimal getInvoiceFeeStart() {
        return invoiceFeeStart;
    }

    public void setInvoiceFeeStart(BigDecimal invoiceFeeStart) {
        this.invoiceFeeStart = invoiceFeeStart;
    }

    public BigDecimal getInvoiceFeeEnd() {
        return invoiceFeeEnd;
    }

    public void setInvoiceFeeEnd(BigDecimal invoiceFeeEnd) {
        this.invoiceFeeEnd = invoiceFeeEnd;
    }

    public String getInvoiceTitle() {
        return invoiceTitle;
    }

    public void setInvoiceTitle(String invoiceTitle) {
        this.invoiceTitle = invoiceTitle;
    }

    public String getBillNumber() {
        return billNumber;
    }

    public void setBillNumber(String billNumber) {
        this.billNumber = billNumber;
    }
}
