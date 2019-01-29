package com.teekee.waterdropservice.entity.dmi.ret.dmiCommProductMarketingCampaign;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author Wujun
 * @create 2017年06月09日 9:32
 */
public class MarketingCampaignGetProductListRet {
    // 产品ID
    private Integer id;
    // 设备号
    private String productCode;
    // 产品描述
    private String productDescription;
    // 品牌
    private String brandName;
    // 分类
    private String catalogName;
    // 计费开始日
    private Date chargeDate;
    // 停机日
    private Date closeDate;
    // 价格
    private BigDecimal monthlyFee;
    // 是否有效
    private Boolean flagAvaliable;
    // 套餐名
    private String campaignName;
    // 是否套餐
    private Boolean flagIndependent;

    private String deviceNumber;

    private boolean flagVendor;

    private String serviceName;

    private Date updateTime;

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public boolean isFlagVendor() {
        return flagVendor;
    }

    public void setFlagVendor(boolean flagVendor) {
        this.flagVendor = flagVendor;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getDeviceNumber() {
        return deviceNumber;
    }

    public void setDeviceNumber(String deviceNumber) {
        this.deviceNumber = deviceNumber;
    }

    public String getCampaignName() {
        return campaignName;
    }

    public void setCampaignName(String campaignName) {
        this.campaignName = campaignName;
    }

    public Boolean getFlagIndependent() {
        return flagIndependent;
    }

    public void setFlagIndependent(Boolean flagIndependent) {
        this.flagIndependent = flagIndependent;
    }

    public Boolean getFlagAvaliable() {
        return flagAvaliable;
    }

    public void setFlagAvaliable(Boolean flagAvaliable) {
        this.flagAvaliable = flagAvaliable;
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

    public Date getChargeDate() {
        return chargeDate;
    }

    public void setChargeDate(Date chargeDate) {
        this.chargeDate = chargeDate;
    }

    public Date getCloseDate() {
        return closeDate;
    }

    public void setCloseDate(Date closeDate) {
        this.closeDate = closeDate;
    }

    public BigDecimal getMonthlyFee() {
        return monthlyFee;
    }

    public void setMonthlyFee(BigDecimal monthlyFee) {
        this.monthlyFee = monthlyFee;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }
}
