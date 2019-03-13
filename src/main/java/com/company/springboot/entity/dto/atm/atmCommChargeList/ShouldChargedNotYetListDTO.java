package com.company.springboot.entity.dto.atm.atmCommChargeList;

import javax.validation.constraints.Min;
import java.util.Date;

/**
 * 查询应收未收账期列表-DTO
 *
 * @author Wujun
 * @create 2017年09月18日 17:00
 */
public class ShouldChargedNotYetListDTO {

    @Min(value = 0, message = "非法操作，请勿再次尝试！")
    private int companyId;

    @Min(value = 0, message = "非法操作，请勿再次尝试！")
    private int companyBrandId;

    @Min(value = 0, message = "非法操作，请勿再次尝试！")
    private int storeId;

    private String province;

    private String city;

    private String district;

    private Boolean flagCampaign;

    @Min(value = 0, message = "非法操作，请勿再次尝试！")
    private int communicationBrandId;

    @Min(value = 0, message = "非法操作，请勿再次尝试！")
    private int catalogId;

    private String accountPeriodNumber;

    private Date accountPeriodStart;

    private Date accountPeriodEnd;

    private boolean flagAdd;

    private String tempBillNumber;

    public String getTempBillNumber() {
        return tempBillNumber;
    }

    public void setTempBillNumber(String tempBillNumber) {
        this.tempBillNumber = tempBillNumber;
    }

    public boolean isFlagAdd() {
        return flagAdd;
    }

    public void setFlagAdd(boolean flagAdd) {
        this.flagAdd = flagAdd;
    }

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
}
