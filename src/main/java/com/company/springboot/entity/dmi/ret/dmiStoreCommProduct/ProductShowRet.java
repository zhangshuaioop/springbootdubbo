package com.company.springboot.entity.dmi.ret.dmiStoreCommProduct;

import com.company.springboot.entity.dmi.DmiCommCharge;
import com.company.springboot.entity.dmi.DmiStoreCommProduct;
import com.company.springboot.entity.dmi.ret.dmiCommPayment.PaymentShowRet;
import com.company.springboot.entity.dmi.ret.dmiCommProductBilling.BillingShowRet;
import com.company.springboot.entity.dmi.DmiCommCharge;
import com.company.springboot.entity.dmi.DmiStoreCommProduct;
import com.company.springboot.entity.dmi.ret.dmiCommPayment.PaymentShowRet;
import com.company.springboot.entity.dmi.ret.dmiCommProductBilling.BillingShowRet;
import com.company.springboot.entity.dmi.ret.dmiCommProductMarketingCampaign.MarketingCampaignShowRet;

/**
 * 根据通信产品ID，查询通信产品详情 - 返回结果
 *
 * @author Wujun
 * @create 2017年06月05日 9:22
 */
public class ProductShowRet {
    private DmiStoreCommProduct dmiStoreCommProduct;

    private PaymentShowRet paymentShowRet;

    private DmiCommCharge dmiCommCharge;

    private Object objectInfo;

    private MarketingCampaignShowRet marketingCampaign;

    private Object catalogInfo;

    private Object contactInfo;

    private String brandName;

    private String company;
    private String companyBrandName;
    private String storeName;

    // 账单信息
    private BillingShowRet billingInfo;

    public BillingShowRet getBillingInfo() {
        return billingInfo;
    }

    public void setBillingInfo(BillingShowRet billingInfo) {
        this.billingInfo = billingInfo;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getCompanyBrandName() {
        return companyBrandName;
    }

    public void setCompanyBrandName(String companyBrandName) {
        this.companyBrandName = companyBrandName;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public Object getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(Object contactInfo) {
        this.contactInfo = contactInfo;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public Object getCatalogInfo() {
        return catalogInfo;
    }

    public void setCatalogInfo(Object catalogInfo) {
        this.catalogInfo = catalogInfo;
    }

    public Object getObjectInfo() {
        return objectInfo;
    }

    public void setObjectInfo(Object objectInfo) {
        this.objectInfo = objectInfo;
    }

    public DmiStoreCommProduct getDmiStoreCommProduct() {
        return dmiStoreCommProduct;
    }

    public MarketingCampaignShowRet getMarketingCampaign() {
        return marketingCampaign;
    }

    public void setMarketingCampaign(MarketingCampaignShowRet marketingCampaign) {
        this.marketingCampaign = marketingCampaign;
    }

    public void setDmiStoreCommProduct(DmiStoreCommProduct dmiStoreCommProduct) {
        this.dmiStoreCommProduct = dmiStoreCommProduct;
    }

    public DmiCommCharge getDmiCommCharge() {
        return dmiCommCharge;
    }

    public void setDmiCommCharge(DmiCommCharge dmiCommCharge) {
        this.dmiCommCharge = dmiCommCharge;
    }

    public PaymentShowRet getPaymentShowRet() {
        return paymentShowRet;
    }

    public void setPaymentShowRet(PaymentShowRet paymentShowRet) {
        this.paymentShowRet = paymentShowRet;
    }
}
