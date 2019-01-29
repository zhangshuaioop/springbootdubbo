package com.teekee.waterdropservice.entity.ret.atm.atmCommChargeBillTempList;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 查看临时账单详情-返回结果
 *
 * @author Wujun
 * @create 2017年09月19日 14:41
 */
public class ShowRet {

    private int id;

    private int companyId;

    private String company;

    private String companyBrand;

    private String store;

    private String type;

    private String commBrand;

    private String ispService;

    private String name;

    private Date accountPeriodStart;

    private Date accountPeriodEnd;

    private String accountPeriodNumber;

    private BigDecimal commPeriodFee;

    private BigDecimal commOneTimeFee;

    private BigDecimal tenementOneTimeFee;

    private BigDecimal tenementPeriodFee;

    private BigDecimal expectedTotalFee;

    private int accountIndex;

    private int accountTotal;

    private BigDecimal actualChargeFee;

    private int chargeListId;

    private BigDecimal actualFee;

    public BigDecimal getActualFee() {
        return actualFee;
    }

    public void setActualFee(BigDecimal actualFee) {
        this.actualFee = actualFee;
    }

    public int getChargeListId() {
        return chargeListId;
    }

    public void setChargeListId(int chargeListId) {
        this.chargeListId = chargeListId;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getCompanyBrand() {
        return companyBrand;
    }

    public void setCompanyBrand(String companyBrand) {
        this.companyBrand = companyBrand;
    }

    public String getStore() {
        return store;
    }

    public void setStore(String store) {
        this.store = store;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCommBrand() {
        return commBrand;
    }

    public void setCommBrand(String commBrand) {
        this.commBrand = commBrand;
    }

    public String getIspService() {
        return ispService;
    }

    public void setIspService(String ispService) {
        this.ispService = ispService;
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

    public String getAccountPeriodNumber() {
        return accountPeriodNumber;
    }

    public void setAccountPeriodNumber(String accountPeriodNumber) {
        this.accountPeriodNumber = accountPeriodNumber;
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

    public BigDecimal getActualChargeFee() {
        return actualChargeFee;
    }

    public void setActualChargeFee(BigDecimal actualChargeFee) {
        this.actualChargeFee = actualChargeFee;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }
}
