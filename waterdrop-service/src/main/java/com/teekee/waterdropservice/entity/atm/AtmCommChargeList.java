package com.teekee.waterdropservice.entity.atm;

import com.teekee.waterdropservice.utils.DateUtil;

import java.math.BigDecimal;
import java.util.Date;

public class AtmCommChargeList {
    private Integer id;

    private Integer objectId;

    private String objectType;

    private Integer contractId;

    private String accountPeriodNumber;

    private Date accountPeriodStart;

    private Date accountPeriodEnd;

    private Integer accountIndex;

    private Integer accountTotal;

    private BigDecimal commPeriodFee;

    private BigDecimal commOneTimeFee;

    private BigDecimal fiberFee;

    private BigDecimal tenementOneTimeFee;

    private BigDecimal tenementPeriodFee;

    private BigDecimal expectedTotalFee;

    private BigDecimal actualChargeFee;

    private Integer chargeBillId;

    private Boolean flagFeeDifferent;

    private Boolean flagChangeFee;

    private Boolean flagProvideInvoice;

    private Boolean flagCompletedCharge;

    private Boolean flagActivate;

    private Boolean flagClosed;

    private String memo;

    private Date createTime;

    private Integer createPerson;

    private Date updateTime;

    private Integer updatePerson;

    private Date activateDate;

    private String handler;

    public String getHandler() {
        return handler;
    }

    public void setHandler(String handler) {
        this.handler = handler;
    }

    public Date getActivateDate() {
        return activateDate;
    }

    public void setActivateDate(Date activateDate) {
        this.activateDate = activateDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getObjectId() {
        return objectId;
    }

    public void setObjectId(Integer objectId) {
        this.objectId = objectId;
    }

    public String getObjectType() {
        return objectType;
    }

    public void setObjectType(String objectType) {
        this.objectType = objectType == null ? null : objectType.trim();
    }

    public Integer getContractId() {
        return contractId;
    }

    public void setContractId(Integer contractId) {
        this.contractId = contractId;
    }

    public String getAccountPeriodNumber() {
        return accountPeriodNumber;
    }

    public void setAccountPeriodNumber(String accountPeriodNumber) {
        this.accountPeriodNumber = accountPeriodNumber == null ? null : accountPeriodNumber.trim();
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

    public Integer getAccountIndex() {
        return accountIndex;
    }

    public void setAccountIndex(Integer accountIndex) {
        this.accountIndex = accountIndex;
    }

    public Integer getAccountTotal() {
        return accountTotal;
    }

    public void setAccountTotal(Integer accountTotal) {
        this.accountTotal = accountTotal;
    }

    public BigDecimal getCommPeriodFee() {
        return commPeriodFee;
    }

    public void setCommPeriodFee(BigDecimal commPeriodFee) {
        this.commPeriodFee = commPeriodFee;
    }

    public BigDecimal getCommOneTimeFee() {
        return commOneTimeFee;
    }

    public void setCommOneTimeFee(BigDecimal commOneTimeFee) {
        this.commOneTimeFee = commOneTimeFee;
    }

    public BigDecimal getFiberFee() {
        return fiberFee;
    }

    public void setFiberFee(BigDecimal fiberFee) {
        this.fiberFee = fiberFee;
    }

    public BigDecimal getTenementOneTimeFee() {
        return tenementOneTimeFee;
    }

    public void setTenementOneTimeFee(BigDecimal tenementOneTimeFee) {
        this.tenementOneTimeFee = tenementOneTimeFee;
    }

    public BigDecimal getTenementPeriodFee() {
        return tenementPeriodFee;
    }

    public void setTenementPeriodFee(BigDecimal tenementPeriodFee) {
        this.tenementPeriodFee = tenementPeriodFee;
    }

    public BigDecimal getExpectedTotalFee() {
        return expectedTotalFee;
    }

    public void setExpectedTotalFee(BigDecimal expectedTotalFee) {
        this.expectedTotalFee = expectedTotalFee;
    }

    public BigDecimal getActualChargeFee() {
        return actualChargeFee;
    }

    public void setActualChargeFee(BigDecimal actualChargeFee) {
        this.actualChargeFee = actualChargeFee;
    }

    public Integer getChargeBillId() {
        return chargeBillId;
    }

    public void setChargeBillId(Integer chargeBillId) {
        this.chargeBillId = chargeBillId;
    }

    public Boolean getFlagFeeDifferent() {
        return flagFeeDifferent;
    }

    public void setFlagFeeDifferent(Boolean flagFeeDifferent) {
        this.flagFeeDifferent = flagFeeDifferent;
    }

    public Boolean getFlagChangeFee() {
        return flagChangeFee;
    }

    public void setFlagChangeFee(Boolean flagChangeFee) {
        this.flagChangeFee = flagChangeFee;
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

    public Boolean getFlagActivate() {
        return flagActivate;
    }

    public void setFlagActivate(Boolean flagActivate) {
        this.flagActivate = flagActivate;
    }

    public Boolean getFlagClosed() {
        return flagClosed;
    }

    public void setFlagClosed(Boolean flagClosed) {
        this.flagClosed = flagClosed;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo == null ? null : memo.trim();
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

    @Override
    public String toString() {
        return "AtmCommChargeList{" +
                "账期='" + accountPeriodNumber + '\'' +
                ", 开始时间=" + DateUtil.getWebDateString(accountPeriodStart) +
                ", 结束时间=" + DateUtil.getWebDateString(accountPeriodEnd) +
                ", 当前账期数=" + accountIndex +
                ", 通信周期费用=" + commPeriodFee +
                ", 通信一次性费用=" + commOneTimeFee +
                ", 尾纤费=" + fiberFee +
                ", 物业一次性费用=" + tenementOneTimeFee +
                ", 物业周期费用=" + tenementPeriodFee +
                '}';
    }
}