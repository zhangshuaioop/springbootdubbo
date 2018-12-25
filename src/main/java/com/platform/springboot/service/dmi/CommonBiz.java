package com.platform.springboot.service.dmi;

import com.platform.springboot.entity.cfg.CfgCommunicationTypeCatalog;
import com.platform.springboot.entity.dmi.DmiCommProductMarketingCampaign;
import com.platform.springboot.entity.dmi.DmiStoreCommProduct;
import com.platform.springboot.mapper.cfg.CfgCommunicationTypeCatalogMapper;
import com.platform.springboot.mapper.dmi.DmiCommProductMarketingCampaignMapper;
import com.platform.springboot.mapper.dmi.DmiStoreCommProductMapper;
import com.platform.springboot.utils.Result;
import com.platform.springboot.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * 通用业务方法
 *
 * @author Wujun
 * @create 2017年08月29日 11:05
 */
@Service
public class CommonBiz {

    @Autowired
    private DmiCommProductBroadbandService broadbandService;
    @Autowired
    private DmiCommProductSpecialLineService specialLineService;
    @Autowired
    private DmiCommProductStraightLineService straightLineService;
    @Autowired
    private DmiCommProductTrunkingService trunkingService;
    @Autowired
    private DmiCommProductMobileService mobileService;
    @Autowired
    protected CfgCommunicationTypeCatalogMapper cfgCommunicationTypeCatalogMapper;
    @Autowired
    protected DmiStoreCommProductMapper dmiStoreCommProductMapper;
    @Autowired
    protected DmiCommProductMarketingCampaignMapper campaignMapper;



    public String CATALOG_MAP_FATHER_KEY = "FATHER";

    public String CATALOG_MAP_CHILD_KEY = "CHILD";

    /**
     * 根据通信产品的类型id，对应查询得到相应的产品专有信息
     *
     * @param catalogId
     * @return
     */
    public Object getObjectProductByCatalog(int catalogId, int productId) {
        if (catalogId == 5 || catalogId == 6) {
            return broadbandService.show(productId);
        } else if (catalogId == 13 || catalogId == 14) {
            return mobileService.show(productId);
        } else if (catalogId == 9 || catalogId == 10 || catalogId == 11 || catalogId == 12) {
            return specialLineService.show(productId);
        } else if (catalogId == 7) {
            return straightLineService.show(productId);
        } else {
            return trunkingService.show(productId);
        }
    }

    /**
     * 根据通信产品的类型id，查新父级类型名字和子级类型名字
     *
     * @param catalogId
     * @return
     */
    public Map<String, String> getCatalogNmList(int catalogId) {
        Map<String, String> result = new HashMap<String, String>();
        CfgCommunicationTypeCatalog child = cfgCommunicationTypeCatalogMapper.selectByPrimaryKey(catalogId);
        if (child != null) {
            CfgCommunicationTypeCatalog father = cfgCommunicationTypeCatalogMapper.selectByPrimaryKey(child.getParentId());
            if (father == null) {
                result.put(CATALOG_MAP_FATHER_KEY, child.getCatalogName());
                result.put(CATALOG_MAP_CHILD_KEY, null);
            } else {
                result.put(CATALOG_MAP_FATHER_KEY, father.getCatalogName());
                result.put(CATALOG_MAP_CHILD_KEY, child.getCatalogName());
            }
        }
        return result;
    }

    /**
     * 信息确认
     *
     * @param id
     * @return
     */
    public Result confirmInfo(int id, String type) {
        if ("PRODUCT".equals(type)) {
            DmiStoreCommProduct product = new DmiStoreCommProduct();
            product.setStatus("CONFIRM");
            product.setId(id);
            product.setFlagInfoConfirm(true);
            dmiStoreCommProductMapper.updateByPrimaryKeySelective(product);
            return ResultUtil.successMsg("信息确认成功");
        } else {
            DmiCommProductMarketingCampaign campaign = new DmiCommProductMarketingCampaign();
            campaign.setStatus("CONFIRM");
            campaign.setId(id);
            campaign.setFlagInfoConfirm(true);
            campaignMapper.updateByPrimaryKeySelective(campaign);
            return ResultUtil.successMsg("信息确认成功");
        }

    }


    public Result needCheckInfo(int id, String type) {
        if ("PRODUCT".equals(type)) {
            DmiStoreCommProduct product = new DmiStoreCommProduct();
            product.setStatus("NEED_CHECK");
            product.setId(id);
            dmiStoreCommProductMapper.updateByPrimaryKeySelective(product);
            return ResultUtil.successMsg("信息提交成功");
        } else {
            DmiCommProductMarketingCampaign campaign = new DmiCommProductMarketingCampaign();
            campaign.setStatus("NEED_CHECK");
            campaign.setId(id);
            campaignMapper.updateByPrimaryKeySelective(campaign);
            return ResultUtil.successMsg("信息提交成功");
        }

    }


    public Result checkInfo(int id, String type) {
        if ("PRODUCT".equals(type)) {
            DmiStoreCommProduct product = new DmiStoreCommProduct();
            product.setStatus("CHECKED");
            product.setId(id);
            dmiStoreCommProductMapper.updateByPrimaryKeySelective(product);
            return ResultUtil.successMsg("审核通过");
        } else {
            DmiCommProductMarketingCampaign campaign = new DmiCommProductMarketingCampaign();
            campaign.setStatus("CHECKED");
            campaign.setId(id);
            campaignMapper.updateByPrimaryKeySelective(campaign);
            return ResultUtil.successMsg("审核通过");
        }

    }

    public Result checkNoInfo(int id, String type) {
        if ("PRODUCT".equals(type)) {
            DmiStoreCommProduct product = new DmiStoreCommProduct();
            product.setStatus("NEW");
            product.setId(id);
            dmiStoreCommProductMapper.updateByPrimaryKeySelective(product);
            return ResultUtil.successMsg("审核不通过");
        } else {
            DmiCommProductMarketingCampaign campaign = new DmiCommProductMarketingCampaign();
            campaign.setStatus("NEW");
            campaign.setId(id);
            campaignMapper.updateByPrimaryKeySelective(campaign);
            return ResultUtil.successMsg("审核不通过");
        }

    }


}
