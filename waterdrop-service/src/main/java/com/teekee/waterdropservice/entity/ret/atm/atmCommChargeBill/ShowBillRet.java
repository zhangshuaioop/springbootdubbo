package com.teekee.waterdropservice.entity.ret.atm.atmCommChargeBill;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 账单详情-返回结果
 *
 * @author Wujun
 * @create 2017年09月21日 11:04
 */
public class ShowBillRet {

    private String companyName;

    private int companyId;

    private String billNumber;

    private int productCount;

    private BigDecimal estimatedFee;

    private BigDecimal actualFee;

    private Date createBillTime;

    private String createBillPersonName;

    private String memo;

    private BigDecimal allChargeFee;

    private int containInvoiceCount;

    private BigDecimal allInvoiceFee;

    private int id;

    public int getContainInvoiceCount() {
        return containInvoiceCount;
    }

    public void setContainInvoiceCount(int containInvoiceCount) {
        this.containInvoiceCount = containInvoiceCount;
    }

    public BigDecimal getAllInvoiceFee() {
        return allInvoiceFee;
    }

    public void setAllInvoiceFee(BigDecimal allInvoiceFee) {
        this.allInvoiceFee = allInvoiceFee;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public BigDecimal getAllChargeFee() {
        return allChargeFee;
    }

    public void setAllChargeFee(BigDecimal allChargeFee) {
        this.allChargeFee = allChargeFee;
    }

    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    public String getBillNumber() {
        return billNumber;
    }

    public void setBillNumber(String billNumber) {
        this.billNumber = billNumber;
    }

    public int getProductCount() {
        return productCount;
    }

    public void setProductCount(int productCount) {
        this.productCount = productCount;
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

    public Date getCreateBillTime() {
        return createBillTime;
    }

    public void setCreateBillTime(Date createBillTime) {
        this.createBillTime = createBillTime;
    }

    public String getCreateBillPersonName() {
        return createBillPersonName;
    }

    public void setCreateBillPersonName(String createBillPersonName) {
        this.createBillPersonName = createBillPersonName;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
}
