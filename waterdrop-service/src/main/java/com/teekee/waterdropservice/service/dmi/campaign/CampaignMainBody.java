package com.teekee.waterdropservice.service.dmi.campaign;

import com.teekee.waterdropservice.entity.bif.BifCommunicationService;
import com.teekee.waterdropservice.entity.cfg.CfgCommunicationBrand;
import com.teekee.waterdropservice.entity.cfg.CfgCommunicationTypeCatalog;
import com.teekee.waterdropservice.entity.dmi.DmiCommProductMarketingCampaign;
import com.teekee.waterdropservice.entity.dmi.DmiStoreCommProduct;
import com.teekee.waterdropservice.entity.dmi.ret.dmiCommProductMarketingCampaign.MarketingCampaignGetProductListRet;
import com.teekee.waterdropservice.mapper.bif.BifCommunicationServiceContactMapper;
import com.teekee.waterdropservice.mapper.dmi.DmiBrandMapper;
import com.teekee.waterdropservice.mapper.dmi.DmiCommProductBillingMapper;
import com.teekee.waterdropservice.mapper.dmi.DmiCommProductMarketingCampaignMapper;
import com.teekee.waterdropservice.mapper.dmi.DmiCompanyInfoMapper;
import com.teekee.waterdropservice.service.bif.BifCommunicationServiceService;
import com.teekee.waterdropservice.service.cfg.CfgCommunicationBrandService;
import com.teekee.waterdropservice.service.cfg.CfgCommunicationTypeCatalogService;
import com.teekee.waterdropservice.service.dmi.*;
import com.teekee.commoncomponets.utils.Result;
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
