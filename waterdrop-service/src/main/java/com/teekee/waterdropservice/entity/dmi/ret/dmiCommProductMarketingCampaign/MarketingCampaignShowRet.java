package com.teekee.waterdropservice.entity.dmi.ret.dmiCommProductMarketingCampaign;

import com.teekee.waterdropservice.entity.bif.BifCommunicationService;
import com.teekee.waterdropservice.entity.bif.BifCommunicationServiceContact;
import com.teekee.waterdropservice.entity.dmi.DmiCommCharge;
import com.teekee.waterdropservice.entity.dmi.DmiCommProductMarketingCampaign;
import com.teekee.waterdropservice.entity.dmi.ret.dmiCommPayment.PaymentShowRet;
import com.teekee.waterdropservice.entity.dmi.ret.dmiCommProductBilling.BillingShowRet;
import com.teekee.waterdropservice.entity.dmi.ret.dmiStoreCommProduct.MarketingCampaignShowProductRet;

import java.util.List;

/**
 * @author Wujun
 * @create 2017年06月09日 9:32
 */
public class MarketingCampaignShowRet {
    private DmiCommProductMarketingCampaign marketingCampaign;

    private String brandName;

    private PaymentShowRet paymentShowRet;

    private DmiCommCharge dmiCommCharge;

    // 账单信息
    private BillingShowRet billingInfo;

    // 包含产品信息
    private List<MarketingCampaignShowProductRet> productListInfo;

    private BifCommunicationService serviceInfo;

    private BifCommunicationServiceContact contactInfo;

    private String company;
    private String companyBrandName;
    private String storeName;

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

    public BifCommunicationServiceContact getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(BifCommunicationServiceContact contactInfo) {
        this.contactInfo = contactInfo;
    }

    public BifCommunicationService getServiceInfo() {
        return serviceInfo;
    }

    public void setServiceInfo(BifCommunicationService serviceInfo) {
        this.serviceInfo = serviceInfo;
    }

    public BillingShowRet getBillingInfo() {
        return billingInfo;
    }

    public void setBillingInfo(BillingShowRet billingInfo) {
        this.billingInfo = billingInfo;
    }

    public DmiCommProductMarketingCampaign getMarketingCampaign() {
        return marketingCampaign;
    }

    public void setMarketingCampaign(DmiCommProductMarketingCampaign marketingCampaign) {
        this.marketingCampaign = marketingCampaign;
    }

    public DmiCommCharge getDmiCommCharge() {
        return dmiCommCharge;
    }

    public void setDmiCommCharge(DmiCommCharge dmiCommCharge) {
        this.dmiCommCharge = dmiCommCharge;
    }

    public List<MarketingCampaignShowProductRet> getProductListInfo() {
        return productListInfo;
    }

    public void setProductListInfo(List<MarketingCampaignShowProductRet> productListInfo) {
        this.productListInfo = productListInfo;
    }

    public PaymentShowRet getPaymentShowRet() {
        return paymentShowRet;
    }

    public void setPaymentShowRet(PaymentShowRet paymentShowRet) {
        this.paymentShowRet = paymentShowRet;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }
}
