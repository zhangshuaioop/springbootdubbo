package com.company.springboot.entity.dmi.dto.dmiCommProductMarketingCampaign;

/**
 * 套餐中添加产品-对象
 *
 * @author Wujun
 * @create 2017年06月13日 9:38
 */
public class MarketingCampaignAddProductDTO {

    // 产品ID
    private Integer productId;
    // 套餐ID
    private Integer marketingCampaignId;

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getMarketingCampaignId() {
        return marketingCampaignId;
    }

    public void setMarketingCampaignId(Integer marketingCampaignId) {
        this.marketingCampaignId = marketingCampaignId;
    }
}
