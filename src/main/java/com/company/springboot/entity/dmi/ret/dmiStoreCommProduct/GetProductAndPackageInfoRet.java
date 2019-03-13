package com.company.springboot.entity.dmi.ret.dmiStoreCommProduct;

/**
 * @author Wujun
 * @create 2017年06月14日 9:33
 */
public class GetProductAndPackageInfoRet {
    private ProductInfo productInfo;

    private CampaignInfo campaignInfo;

    public ProductInfo getProductInfo() {
        return productInfo;
    }

    public void setProductInfo(ProductInfo productInfo) {
        this.productInfo = productInfo;
    }

    public CampaignInfo getCampaignInfo() {
        return campaignInfo;
    }

    public void setCampaignInfo(CampaignInfo campaignInfo) {
        this.campaignInfo = campaignInfo;
    }
}
