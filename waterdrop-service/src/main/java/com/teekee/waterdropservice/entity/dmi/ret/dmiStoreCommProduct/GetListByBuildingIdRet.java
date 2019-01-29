package com.teekee.waterdropservice.entity.dmi.ret.dmiStoreCommProduct;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 根据地址ID查询通信产品-返回对象
 *
 * @author Wujun
 * @create 2017年06月13日 17:16
 */
public class GetListByBuildingIdRet {
    // 设备号
    private String deviceNumber;
    // 产品描述
    private String productDescription;
    // 品牌
    private String brandName;
    // 产品分类
    private String catalogName;
    // 套餐名
    private String campaignName;
    // 是否套餐
    private Boolean flagIndependent;
    // 月单价
    private BigDecimal monthlyFee;
    // 产品ID
    private Integer id;

    private Date updateTime;

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDeviceNumber() {
        return deviceNumber;
    }

    public void setDeviceNumber(String deviceNumber) {
        this.deviceNumber = deviceNumber;
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

    public BigDecimal getMonthlyFee() {
        return monthlyFee;
    }

    public void setMonthlyFee(BigDecimal monthlyFee) {
        this.monthlyFee = monthlyFee;
    }
}
