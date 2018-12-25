package com.platform.springboot.entity.dmi.ret.dmiStoreCommProduct;

/**
 * 套餐中包含产品的信息
 *
 * @author Wujun
 * @create 2017年06月09日 11:15
 */
public class MarketingCampaignShowProductRet {
    // 线路概述
    private String productDescription;
    // 产品分类
    private String catalogName;
    // 设备号
    private String productCode;
    private String deviceNumber;

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

    public String getCatalogName() {
        return catalogName;
    }

    public void setCatalogName(String catalogName) {
        this.catalogName = catalogName;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }
}
