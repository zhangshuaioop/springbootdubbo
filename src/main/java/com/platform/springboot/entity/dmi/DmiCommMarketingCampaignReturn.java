package com.platform.springboot.entity.dmi;

import java.math.BigDecimal;
import java.util.Date;

public class DmiCommMarketingCampaignReturn {
    private Integer id;

    private Integer storeId;

    private Integer companyId;

    private Integer campaignId;

    private Integer contractId;

    private BigDecimal returnAmount;

    private Integer returnMonths;

    private BigDecimal monthlyReturnFee;

    private String changeFeeMonth;

    private BigDecimal changeFee;

    private Date createTime;

    private Integer createPerson;

    private Integer updatePerson;

    private Date updateTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getStoreId() {
        return storeId;
    }

    public void setStoreId(Integer storeId) {
        this.storeId = storeId;
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public Integer getCampaignId() {
        return campaignId;
    }

    public void setCampaignId(Integer campaignId) {
        this.campaignId = campaignId;
    }

    public Integer getContractId() {
        return contractId;
    }

    public void setContractId(Integer contractId) {
        this.contractId = contractId;
    }

    public BigDecimal getReturnAmount() {
        return returnAmount;
    }

    public void setReturnAmount(BigDecimal returnAmount) {
        this.returnAmount = returnAmount;
    }

    public Integer getReturnMonths() {
        return returnMonths;
    }

    public void setReturnMonths(Integer returnMonths) {
        this.returnMonths = returnMonths;
    }

    public BigDecimal getMonthlyReturnFee() {
        return monthlyReturnFee;
    }

    public void setMonthlyReturnFee(BigDecimal monthlyReturnFee) {
        this.monthlyReturnFee = monthlyReturnFee;
    }

    public String getChangeFeeMonth() {
        return changeFeeMonth;
    }

    public void setChangeFeeMonth(String changeFeeMonth) {
        this.changeFeeMonth = changeFeeMonth == null ? null : changeFeeMonth.trim();
    }

    public BigDecimal getChangeFee() {
        return changeFee;
    }

    public void setChangeFee(BigDecimal changeFee) {
        this.changeFee = changeFee;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getCreatePerson() {
        return createPerson;
    }

    public void setCreatePerson(Integer createPerson) {
        this.createPerson = createPerson;
    }

    public Integer getUpdatePerson() {
        return updatePerson;
    }

    public void setUpdatePerson(Integer updatePerson) {
        this.updatePerson = updatePerson;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}