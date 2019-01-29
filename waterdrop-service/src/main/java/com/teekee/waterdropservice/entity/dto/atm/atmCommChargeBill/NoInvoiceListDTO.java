package com.teekee.waterdropservice.entity.dto.atm.atmCommChargeBill;

import java.util.Date;

/**
 * 查询待出票收费账单列表-DTO
 *
 * @author Wujun
 * @create 2017年09月21日 9:21
 */
public class NoInvoiceListDTO {

    private int companyId;

    private int companyBrandId;

    private int storeId;

    private String province;

    private String city;

    private String district;

    private Boolean flagCampaign;

    private int communicationBrandId;

    private int catalogId;

    private String accountPeriodNumber;

    private Date createBillTimeStart;

    private Date createBillTimeEnd;

    private String billNumber;

    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    public int getCompanyBrandId() {
        return companyBrandId;
    }

    public void setCompanyBrandId(int companyBrandId) {
        this.companyBrandId = companyBrandId;
    }

    public int getStoreId() {
        return storeId;
    }

    public void setStoreId(int storeId) {
        this.storeId = storeId;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public Boolean getFlagCampaign() {
        return flagCampaign;
    }

    public void setFlagCampaign(Boolean flagCampaign) {
        this.flagCampaign = flagCampaign;
    }

    public int getCommunicationBrandId() {
        return communicationBrandId;
    }

    public void setCommunicationBrandId(int communicationBrandId) {
        this.communicationBrandId = communicationBrandId;
    }

    public int getCatalogId() {
        return catalogId;
    }

    public void setCatalogId(int catalogId) {
        this.catalogId = catalogId;
    }

    public String getAccountPeriodNumber() {
        return accountPeriodNumber;
    }

    public void setAccountPeriodNumber(String accountPeriodNumber) {
        this.accountPeriodNumber = accountPeriodNumber;
    }

    public Date getCreateBillTimeStart() {
        return createBillTimeStart;
    }

    public void setCreateBillTimeStart(Date createBillTimeStart) {
        this.createBillTimeStart = createBillTimeStart;
    }

    public Date getCreateBillTimeEnd() {
        return createBillTimeEnd;
    }

    public void setCreateBillTimeEnd(Date createBillTimeEnd) {
        this.createBillTimeEnd = createBillTimeEnd;
    }

    public String getBillNumber() {
        return billNumber;
    }

    public void setBillNumber(String billNumber) {
        this.billNumber = billNumber;
    }
}
