package com.company.springboot.entity.dmi.ret.dmiStoreCommProduct;

import java.math.BigDecimal;

/**
 * @author Wujun
 * @create 2017年06月14日 9:34
 */
public class ProductInfo {
    // 产品描述
    private String productDescription;
    // 产品大类
    private String fatherCategory;
    // 产品小类
    private String childCategory;
    // 品牌
    private String brandName;
    // 子品牌
    private String subBrand;
    // ISP服务商
    private String ispService;
    // 周期
    private Integer availablePeriod;
    // 付费频率
    private String payFrequency;
    // 付费方式
    private String paymentMethod;
    // 一次性费用
    private BigDecimal oneTimeFee;
    // 付费单价
    private BigDecimal frequencyFee;
    // 月单价
    private BigDecimal monthlyFee;
    // 初装费
    private BigDecimal firstInstallFee;
    // 设备费
    private BigDecimal fiberDeviceFee;
    // 备注
    private String memo;
    // 尾纤费
    private BigDecimal fiberFee;
    // 物业付费方式
    private String tenementPeriodType;
    // 物业周期费用
    private BigDecimal tenementPeriodFee;
    // 物业一次费用
    private BigDecimal tenementFee;
    // 产品特殊信息
    private Object objectInfo;
    // 产品类型
    private String productCategoryType;
    private Boolean flagVendor;

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

    public String getProductCategoryType() {
        return productCategoryType;
    }

    public void setProductCategoryType(String productCategoryType) {
        this.productCategoryType = productCategoryType;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public String getFatherCategory() {
        return fatherCategory;
    }

    public void setFatherCategory(String fatherCategory) {
        this.fatherCategory = fatherCategory;
    }

    public String getChildCategory() {
        return childCategory;
    }

    public void setChildCategory(String childCategory) {
        this.childCategory = childCategory;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getIspService() {
        return ispService;
    }

    public void setIspService(String ispService) {
        this.ispService = ispService;
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

    public BigDecimal getOneTimeFee() {
        return oneTimeFee;
    }

    public void setOneTimeFee(BigDecimal oneTimeFee) {
        this.oneTimeFee = oneTimeFee;
    }

    public BigDecimal getFrequencyFee() {
        return frequencyFee;
    }

    public void setFrequencyFee(BigDecimal frequencyFee) {
        this.frequencyFee = frequencyFee;
    }

    public BigDecimal getMonthlyFee() {
        return monthlyFee;
    }

    public void setMonthlyFee(BigDecimal monthlyFee) {
        this.monthlyFee = monthlyFee;
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

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
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

    public BigDecimal getTenementFee() {
        return tenementFee;
    }

    public void setTenementFee(BigDecimal tenementFee) {
        this.tenementFee = tenementFee;
    }

    public Object getObjectInfo() {
        return objectInfo;
    }

    public void setObjectInfo(Object objectInfo) {
        this.objectInfo = objectInfo;
    }
}
