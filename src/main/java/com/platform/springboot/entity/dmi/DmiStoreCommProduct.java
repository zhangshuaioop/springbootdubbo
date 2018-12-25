package com.platform.springboot.entity.dmi;

import com.platform.springboot.base.BaseEntity;
import com.platform.springboot.base.BaseEntity;

import java.math.BigDecimal;
import java.util.Date;

public class DmiStoreCommProduct extends BaseEntity {
    private Integer id;

    private Integer storeId;

    private Integer companyId;

    private Integer catalogId;

    private Integer brandId;

    private String subBrand;

    private String productCode;

    private String deviceNumber;

    private String ispService;

    private String productDescription;

    private Date purchaseDate;

    private Date installDate;

    private Boolean flagIndependent;

    private String marketingCampaignId;

    private String memo;

    private Integer serviceId;

    private BigDecimal payBalance;

    private String commServicePassword;

    private String register;

    private String registerType;

    private String registerCode;

    private String status;

    private Boolean flagAvaliable;

    private Boolean flagDeleted;

    private Boolean flagInfoConfirm;

    private Date createTime;

    private Integer createPerson;

    private Integer updatePerson;

    private Date updateTime;

    private Boolean flagVendor;

    private Integer serviceContactId;

    private boolean flagChargeAgency;

    private String pmsCode;

    public String getPmsCode() {
        return pmsCode;
    }

    public void setPmsCode(String pmsCode) {
        this.pmsCode = pmsCode;
    }

    public boolean isFlagChargeAgency() {
        return flagChargeAgency;
    }

    public void setFlagChargeAgency(boolean flagChargeAgency) {
        this.flagChargeAgency = flagChargeAgency;
    }

    public Integer getServiceContactId() {
        return serviceContactId;
    }

    public void setServiceContactId(Integer serviceContactId) {
        this.serviceContactId = serviceContactId;
    }

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

    public Integer getCatalogId() {
        return catalogId;
    }

    public void setCatalogId(Integer catalogId) {
        this.catalogId = catalogId;
    }

    public Integer getBrandId() {
        return brandId;
    }

    public void setBrandId(Integer brandId) {
        this.brandId = brandId;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode == null ? null : productCode.trim();
    }

    public String getDeviceNumber() {
        return deviceNumber;
    }

    public void setDeviceNumber(String deviceNumber) {
        this.deviceNumber = deviceNumber == null ? null : deviceNumber.trim();
    }

    public String getIspService() {
        return ispService;
    }

    public void setIspService(String ispService) {
        this.ispService = ispService == null ? null : ispService.trim();
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription == null ? null : productDescription.trim();
    }

    public Date getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(Date purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public Date getInstallDate() {
        return installDate;
    }

    public void setInstallDate(Date installDate) {
        this.installDate = installDate;
    }

    public Boolean getFlagIndependent() {
        return flagIndependent;
    }

    public void setFlagIndependent(Boolean flagIndependent) {
        this.flagIndependent = flagIndependent;
    }

    public String getMarketingCampaignId() {
        return marketingCampaignId;
    }

    public void setMarketingCampaignId(String marketingCampaignId) {
        this.marketingCampaignId = marketingCampaignId == null ? null : marketingCampaignId.trim();
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo == null ? null : memo.trim();
    }

    public Integer getServiceId() {
        return serviceId;
    }

    public void setServiceId(Integer serviceId) {
        this.serviceId = serviceId;
    }

    public BigDecimal getPayBalance() {
        return payBalance;
    }

    public void setPayBalance(BigDecimal payBalance) {
        this.payBalance = payBalance;
    }

    public String getCommServicePassword() {
        return commServicePassword;
    }

    public void setCommServicePassword(String commServicePassword) {
        this.commServicePassword = commServicePassword == null ? null : commServicePassword.trim();
    }

    public String getRegister() {
        return register;
    }

    public void setRegister(String register) {
        this.register = register == null ? null : register.trim();
    }

    public String getRegisterType() {
        return registerType;
    }

    public void setRegisterType(String registerType) {
        this.registerType = registerType == null ? null : registerType.trim();
    }

    public String getRegisterCode() {
        return registerCode;
    }

    public void setRegisterCode(String registerCode) {
        this.registerCode = registerCode == null ? null : registerCode.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public Boolean getFlagAvaliable() {
        return flagAvaliable;
    }

    public void setFlagAvaliable(Boolean flagAvaliable) {
        this.flagAvaliable = flagAvaliable;
    }

    public Boolean getFlagDeleted() {
        return flagDeleted;
    }

    public void setFlagDeleted(Boolean flagDeleted) {
        this.flagDeleted = flagDeleted;
    }

    public Boolean getFlagInfoConfirm() {
        return flagInfoConfirm;
    }

    public void setFlagInfoConfirm(Boolean flagInfoConfirm) {
        this.flagInfoConfirm = flagInfoConfirm;
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

    public String getSubBrand() {
        return subBrand;
    }

    public void setSubBrand(String subBrand) {
        this.subBrand = subBrand;
    }

    public Boolean getFlagVendor() {
        return flagVendor;
    }

    public void setFlagVendor(Boolean flagVendor) {
        this.flagVendor = flagVendor;
    }

    @Override
    public String toString() {
        return "DmiStoreCommProduct{" +
                "id=" + id +
                ", storeId=" + storeId +
                ", companyId=" + companyId +
                ", catalogId=" + catalogId +
                ", brandId=" + brandId +
                ", subBrand='" + subBrand + '\'' +
                ", productCode='" + productCode + '\'' +
                ", deviceNumber='" + deviceNumber + '\'' +
                ", ispService='" + ispService + '\'' +
                ", productDescription='" + productDescription + '\'' +
                ", purchaseDate=" + purchaseDate +
                ", installDate=" + installDate +
                ", flagIndependent=" + flagIndependent +
                ", marketingCampaignId='" + marketingCampaignId + '\'' +
                ", memo='" + memo + '\'' +
                ", serviceId=" + serviceId +
                ", payBalance=" + payBalance +
                ", commServicePassword='" + commServicePassword + '\'' +
                ", register='" + register + '\'' +
                ", registerType='" + registerType + '\'' +
                ", registerCode='" + registerCode + '\'' +
                ", status='" + status + '\'' +
                ", flagAvaliable=" + flagAvaliable +
                ", flagDeleted=" + flagDeleted +
                ", flagInfoConfirm=" + flagInfoConfirm +
                ", createTime=" + createTime +
                ", createPerson=" + createPerson +
                ", updatePerson=" + updatePerson +
                ", updateTime=" + updateTime +
                ", flagVendor=" + flagVendor +
                ", serviceContactId=" + serviceContactId +
                ", flagChargeAgency=" + flagChargeAgency +
                ", pmsCode='" + pmsCode + '\'' +
                '}';
    }
}