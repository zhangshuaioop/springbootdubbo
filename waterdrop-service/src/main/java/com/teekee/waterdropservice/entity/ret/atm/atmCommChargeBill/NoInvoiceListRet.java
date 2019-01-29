package com.teekee.waterdropservice.entity.ret.atm.atmCommChargeBill;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 查询待出票收费账单列表-RET
 *
 * @author Wujun
 * @create 2017年09月21日 9:33
 */
public class NoInvoiceListRet {

    private int id;

    private String companyName;

    private String billNumber;

    private int productCount;

    private BigDecimal estimatedFee;

    private BigDecimal actualFee;

    private Date createBillTime;

    private Boolean flagCompletedCharge;

    private Date updateTime;

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Boolean getFlagCompletedCharge() {
        return flagCompletedCharge;
    }

    public void setFlagCompletedCharge(Boolean flagCompletedCharge) {
        this.flagCompletedCharge = flagCompletedCharge;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
