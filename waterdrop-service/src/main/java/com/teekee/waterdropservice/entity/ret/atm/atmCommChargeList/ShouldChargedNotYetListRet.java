package com.teekee.waterdropservice.entity.ret.atm.atmCommChargeList;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 应收未收账期列表-返回结果
 *
 * @author Wujun
 * @create 2017年09月18日 18:11
 */
public class ShouldChargedNotYetListRet {

    private int id;

    private String accountPeriodNumber;

    private String company;

    private String store;

    private String name;

    private Date accountPeriodStart;

    private Date accountPeriodEnd;

    private BigDecimal expectedTotalFee;

    private int accountIndex;

    private int accountTotal;

    private Date activateDate;

    private Date updateTime;

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Date getActivateDate() {
        return activateDate;
    }

    public void setActivateDate(Date activateDate) {
        this.activateDate = activateDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAccountPeriodNumber() {
        return accountPeriodNumber;
    }

    public void setAccountPeriodNumber(String accountPeriodNumber) {
        this.accountPeriodNumber = accountPeriodNumber;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getStore() {
        return store;
    }

    public void setStore(String store) {
        this.store = store;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public BigDecimal getExpectedTotalFee() {
        return expectedTotalFee;
    }

    public void setExpectedTotalFee(BigDecimal expectedTotalFee) {
        this.expectedTotalFee = expectedTotalFee;
    }

    public int getAccountIndex() {
        return accountIndex;
    }

    public void setAccountIndex(int accountIndex) {
        this.accountIndex = accountIndex;
    }

    public int getAccountTotal() {
        return accountTotal;
    }

    public void setAccountTotal(int accountTotal) {
        this.accountTotal = accountTotal;
    }
}
