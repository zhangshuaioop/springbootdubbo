package com.platform.springboot.entity.dmi.ret.dmiStoreCommProduct;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 查询门店中通信产品列表-返回结果
 *
 * @author Wujun
 * @create 2017年06月02日 15:32
 */
public class GetListByStoreIdRet {
    private Integer catalogId;
    private String productDescription;

    private String brandName;

    private String catalogName;

    private Boolean flagIndependent;

    private String campaignName;

    private BigDecimal monthlyFee;

    private Boolean flagAvaliable;

    private Integer id;

    private String productCode;
    private String payFrequency;
    private BigDecimal frequencyFee;

    private String status;

    private boolean flagVendor;

    private boolean flagChargeSingal;

    private String deviceNumber;

    private boolean flagInfoConfirm;

    private String serviceName;

    private Date updateTime;
    private boolean flagUsed;

    public boolean isFlagUsed() {
        return flagUsed;
    }

    public void setFlagUsed(boolean flagUsed) {
        this.flagUsed = flagUsed;
    }

    private String fatherCategory;

    public String getFatherCategory() {
        return fatherCategory;
    }

    public void setFatherCategory(String fatherCategory) {
        this.fatherCategory = fatherCategory;
    }

    public Integer getCatalogId() {
        return catalogId;
    }

    public void setCatalogId(Integer catalogId) {
        this.catalogId = catalogId;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public boolean isFlagInfoConfirm() {
        return flagInfoConfirm;
    }

    public void setFlagInfoConfirm(boolean flagInfoConfirm) {
        this.flagInfoConfirm = flagInfoConfirm;
    }

    public boolean isFlagChargeSingal() {
        return flagChargeSingal;
    }

    public void setFlagChargeSingal(boolean flagChargeSingal) {
        this.flagChargeSingal = flagChargeSingal;
    }

    public String getDeviceNumber() {
        return deviceNumber;
    }

    public void setDeviceNumber(String deviceNumber) {
        this.deviceNumber = deviceNumber;
    }

    public boolean isFlagVendor() {
        return flagVendor;
    }

    public void setFlagVendor(boolean flagVendor) {
        this.flagVendor = flagVendor;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPayFrequency() {
        return payFrequency;
    }

    public void setPayFrequency(String payFrequency) {
        this.payFrequency = payFrequency;
    }

    public BigDecimal getFrequencyFee() {
        return frequencyFee;
    }

    public void setFrequencyFee(BigDecimal frequencyFee) {
        this.frequencyFee = frequencyFee;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getCatalogName() {
        return catalogName;
    }

    public void setCatalogName(String catalogName) {
        this.catalogName = catalogName;
    }

    public Boolean getFlagIndependent() {
        return flagIndependent;
    }

    public void setFlagIndependent(Boolean flagIndependent) {
        this.flagIndependent = flagIndependent;
    }

    public String getCampaignName() {
        return campaignName;
    }

    public void setCampaignName(String campaignName) {
        this.campaignName = campaignName;
    }

    public BigDecimal getMonthlyFee() {
        return monthlyFee;
    }

    public void setMonthlyFee(BigDecimal monthlyFee) {
        this.monthlyFee = monthlyFee;
    }

    public Boolean getFlagAvaliable() {
        return flagAvaliable;
    }

    public void setFlagAvaliable(Boolean flagAvaliable) {
        this.flagAvaliable = flagAvaliable;
    }

}
