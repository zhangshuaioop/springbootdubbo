package com.platform.springboot.service.dmi.campaign;

import com.platform.springboot.entity.bif.BifCommunicationService;
import com.platform.springboot.entity.cfg.CfgCommunicationBrand;
import com.platform.springboot.entity.cfg.CfgCommunicationTypeCatalog;
import com.platform.springboot.entity.dmi.DmiCommProductMarketingCampaign;
import com.platform.springboot.entity.dmi.DmiStoreCommProduct;
import com.platform.springboot.entity.dmi.ret.dmiCommProductMarketingCampaign.MarketingCampaignGetProductListRet;
import com.platform.springboot.mapper.bif.BifCommunicationServiceContactMapper;
import com.platform.springboot.mapper.dmi.DmiBrandMapper;
import com.platform.springboot.mapper.dmi.DmiCommProductBillingMapper;
import com.platform.springboot.mapper.dmi.DmiCommProductMarketingCampaignMapper;
import com.platform.springboot.mapper.dmi.DmiCompanyInfoMapper;
import com.platform.springboot.service.bif.BifCommunicationServiceService;
import com.platform.springboot.service.cfg.CfgCommunicationBrandService;
import com.platform.springboot.service.cfg.CfgCommunicationTypeCatalogService;
import com.platform.springboot.service.dmi.*;
import com.platform.springboot.utils.Result;
import com.platform.springboot.service.bif.BifCommunicationServiceService;
import com.platform.springboot.service.cfg.CfgCommunicationBrandService;
import com.platform.springboot.service.cfg.CfgCommunicationTypeCatalogService;
import com.platform.springboot.service.dmi.CommonBiz;
import com.platform.springboot.service.dmi.DmiCommChargeService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * 套餐实现类主体
 * @Author Niting
 * @date 2018/12/18
 **/
public class CampaignMainBody extends CommonBiz {
    @Autowired
    protected CfgCommunicationBrandService brandService;
    @Autowired
    protected CfgCommunicationTypeCatalogService catalogService;
    @Autowired
    protected BifCommunicationServiceService communicationServiceService;
    @Autowired
    protected DmiCommProductMarketingCampaignMapper marketingCampaignMapper;

    @Autowired
    protected DmiStoreService storeService;

    @Autowired
    protected DmiCompanyInfoMapper dmiCompanyInfoMapper;

    @Autowired
    protected DmiCommProductBillingMapper billingMapper;

    @Autowired
    protected DmiCommChargeService commChargeService;

    @Autowired
    protected DmiCommProductBillingService billingService;

    @Autowired
    protected DmiStoreCommProductService productService;

    @Autowired
    protected BifCommunicationServiceContactMapper bifCommunicationServiceContactMapper;

    @Autowired
    protected BifCommunicationServiceService serviceService;

    @Autowired
    protected DmiBrandMapper dmiBrandMapper;

    protected List<MarketingCampaignGetProductListRet> buildProductList(List<DmiStoreCommProduct> sqlRsult) {
        List<MarketingCampaignGetProductListRet> result = new ArrayList<MarketingCampaignGetProductListRet>();
        if (sqlRsult != null && !sqlRsult.isEmpty()) {
            for (DmiStoreCommProduct item : sqlRsult) {
                MarketingCampaignGetProductListRet outItem = new MarketingCampaignGetProductListRet();
                // 产品ID
                outItem.setId(item.getId());
                // 设备号
                outItem.setProductCode(item.getProductCode());
                outItem.setDeviceNumber(item.getDeviceNumber());
                // 产品描述
                outItem.setProductDescription(item.getProductDescription());
                // 品牌
                CfgCommunicationBrand brandInfo = brandService.show(item.getBrandId());
                if (brandInfo != null) outItem.setBrandName(brandInfo.getBrandName());
                // 分类
                CfgCommunicationTypeCatalog catalogInfo = catalogService.getByPrimaryKey(item.getCatalogId());
                if (catalogInfo != null) outItem.setCatalogName(catalogInfo.getCatalogName());
                // 是否有效
                outItem.setFlagAvaliable(item.getFlagAvaliable());
                // 是否套餐
                outItem.setFlagIndependent(item.getFlagIndependent());
                outItem.setFlagVendor(item.getFlagVendor());
                Result<BifCommunicationService> serviceInfo = communicationServiceService.getCommunicationService(item.getServiceId());
                if (serviceInfo != null) outItem.setServiceName(serviceInfo.getData().getServiceName());
                // 套餐名字
                if (!item.getFlagIndependent()) {
                    DmiCommProductMarketingCampaign marketingCampaign = marketingCampaignMapper.selectByPrimaryKey(Integer.parseInt(item
                            .getMarketingCampaignId()));
                    outItem.setCampaignName(marketingCampaign.getCampaignName());
                } else {
                    outItem.setCampaignName("");
                }
                outItem.setUpdateTime(item.getUpdateTime());
                result.add(outItem);
            }
        }
        return result;
    }
}
