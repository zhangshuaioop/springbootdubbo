package com.company.springboot.entity.dmi.ret.dmiCommProductMarketingCampaign;

import com.company.springboot.entity.dmi.DmiCommProductMarketingCampaign;
import com.company.springboot.entity.dmi.ret.common.BrandInfo;
import com.company.springboot.entity.dmi.DmiCommProductMarketingCampaign;
import com.company.springboot.entity.dmi.ret.common.BrandInfo;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author Wujun
 * @create 2017年08月31日 9:41
 */
public class ListRet {

    private DmiCommProductMarketingCampaign campaign;

    private BrandInfo brandInfo;

    private String serviceName;

    private int productCount;

    public int getProductCount() {
        return productCount;
    }

    public void setProductCount(int productCount) {
        this.productCount = productCount;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public DmiCommProductMarketingCampaign getCampaign() {
        return campaign;
    }

    public void setCampaign(DmiCommProductMarketingCampaign campaign) {
        this.campaign = campaign;
    }

    public BrandInfo getBrandInfo() {
        return brandInfo;
    }

    public void setBrandInfo(BrandInfo brandInfo) {
        this.brandInfo = brandInfo;
    }
}
