package com.company.springboot.entity.dmi.ret.dmiStore;

import com.company.springboot.entity.dmi.DmiCommCharge;
import com.company.springboot.entity.dmi.DmiCommProductMarketingCampaign;
import com.company.springboot.entity.dmi.DmiCommCharge;
import com.company.springboot.entity.dmi.DmiCommProductMarketingCampaign;
import com.company.springboot.entity.dmi.ret.dmiCommPayment.PaymentShowRet;

import java.util.List;

/**
 * 门店中-套餐信息
 *
 * @author Wujun
 * @create 2017年06月13日 10:59
 */
public class MarketingCampaignInfo {
    private DmiCommProductMarketingCampaign marketingCampaign;

    private PaymentShowRet paymentShowRet;

    private DmiCommCharge dmiCommCharge;

    // 包含产品信息
    private List<ProductInfo> productListInfo;

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

    public List<ProductInfo> getProductListInfo() {
        return productListInfo;
    }

    public void setProductListInfo(List<ProductInfo> productListInfo) {
        this.productListInfo = productListInfo;
    }

    public PaymentShowRet getPaymentShowRet() {
        return paymentShowRet;
    }

    public void setPaymentShowRet(PaymentShowRet paymentShowRet) {
        this.paymentShowRet = paymentShowRet;
    }
}
