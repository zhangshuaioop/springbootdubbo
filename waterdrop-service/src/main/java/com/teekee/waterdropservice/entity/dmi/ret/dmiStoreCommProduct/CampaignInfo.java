package com.teekee.waterdropservice.entity.dmi.ret.dmiStoreCommProduct;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author Wujun
 * @create 2017年06月14日 9:34
 */
public class CampaignInfo {
    // 套餐名称
    private String campaignName;
    // 使用周期
    private Integer availablePeriod;
    // 付费频率
    private String payFrequency;
    // 付费方式
    private String paymentMethod;
    // 周期费用
    private BigDecimal frequencyFee;
    // 返还金额
    private BigDecimal returnAmount;
    // 返还月份
    private Integer returnMonths;
    // 每月返还
    private BigDecimal monthlyReturnFee;
    // 费用调整月份
    private String changeFeeMonth;
    // 调整金额
    private BigDecimal changeFee;
    // 初装费
    private BigDecimal firstInstallFee;
    // 设备费
    private BigDecimal fiberDeviceFee;
    // 套餐描述
    private String description;
    // 包含产品信息
    private List<MarketingCampaignShowProductRet> productListInfo;
    // 尾纤费
    private BigDecimal fiberFee;
    // 物业付费方式
    private String tenementPeriodType;
    // 物业周期费用
    private BigDecimal tenementPeriodFee;
    // 物业一次性费用
    private Object tenementFee;
    // 服务商信息
    private Object serviceInfo;

    public String getCampaignName() {
        return campaignName;
    }

    public void setCampaignName(String campaignName) {
        this.campaignName = campaignName;
    }

    public Integer getAvailablePeriod() {
        return availablePeriod;
    }

    public void setAvailablePeriod(Integer availablePeriod) {
        this.availablePeriod = availablePeriod;
    }

    public String getPayFrequency() {
        return payFrequency;
    }

    public void setPayFrequency(String payFrequency) {
        this.payFrequency = payFrequency;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public BigDecimal getFrequencyFee() {
        return frequencyFee;
    }

    public void setFrequencyFee(BigDecimal frequencyFee) {
        this.frequencyFee = frequencyFee;
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
        this.changeFeeMonth = changeFeeMonth;
    }

    public BigDecimal getChangeFee() {
        return changeFee;
    }

    public void setChangeFee(BigDecimal changeFee) {
        this.changeFee = changeFee;
    }

    public BigDecimal getFirstInstallFee() {
        return firstInstallFee;
    }

    public void setFirstInstallFee(BigDecimal firstInstallFee) {
        this.firstInstallFee = firstInstallFee;
    }

    public BigDecimal getFiberDeviceFee() {
        return fiberDeviceFee;
    }

    public void setFiberDeviceFee(BigDecimal fiberDeviceFee) {
        this.fiberDeviceFee = fiberDeviceFee;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<MarketingCampaignShowProductRet> getProductListInfo() {
        return productListInfo;
    }

    public void setProductListInfo(List<MarketingCampaignShowProductRet> productListInfo) {
        this.productListInfo = productListInfo;
    }

    public BigDecimal getFiberFee() {
        return fiberFee;
    }

    public void setFiberFee(BigDecimal fiberFee) {
        this.fiberFee = fiberFee;
    }

    public String getTenementPeriodType() {
        return tenementPeriodType;
    }

    public void setTenementPeriodType(String tenementPeriodType) {
        this.tenementPeriodType = tenementPeriodType;
    }

    public BigDecimal getTenementPeriodFee() {
        return tenementPeriodFee;
    }

    public void setTenementPeriodFee(BigDecimal tenementPeriodFee) {
        this.tenementPeriodFee = tenementPeriodFee;
    }

    public Object getTenementFee() {
        return tenementFee;
    }

    public void setTenementFee(Object tenementFee) {
        this.tenementFee = tenementFee;
    }

    public Object getServiceInfo() {
        return serviceInfo;
    }

    public void setServiceInfo(Object serviceInfo) {
        this.serviceInfo = serviceInfo;
    }
}
