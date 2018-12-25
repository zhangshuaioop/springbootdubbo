package com.platform.springboot.service.dmi;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.platform.springboot.base.BaseService;
import com.platform.springboot.entity.bif.BifCommunicationServiceContact;
import com.platform.springboot.entity.cfg.CfgCommunicationBrand;
import com.platform.springboot.entity.cfg.CfgCommunicationTypeCatalog;
import com.platform.springboot.entity.dmi.*;
import com.platform.springboot.entity.dmi.ret.dmiCommProductBilling.BillingShowRet;
import com.platform.springboot.entity.dmi.ret.dmiCommProductMarketingCampaign.MarketingCampaignShowRet;
import com.platform.springboot.entity.dmi.ret.dmiStoreCommProduct.*;
import com.platform.springboot.entity.dto.dmi.DmiStoreCommProduct.CommListDto;
import com.platform.springboot.entity.ret.dmi.DmiStoreCommProduct.CommListForChargeRet;
import com.platform.springboot.entity.sys.SysCompanyUsers;
import com.platform.springboot.mapper.dmi.DmiStoreCommProductMapper;
import com.platform.springboot.service.dmi.product.ProductMainBody;
import com.platform.springboot.utils.CurrentUtil;
import com.platform.springboot.utils.PageInfo;
import com.platform.springboot.utils.Result;
import com.platform.springboot.utils.ResultUtil;
import com.platform.springboot.service.dmi.product.ProductMainBody;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @description: 门店通信产品
 * @author: zhangshuai
 * @create: 2018-12-17 14:01
 */
@Service
public class DmiStoreCommProductService extends ProductMainBody {

    @Autowired
    private DmiStoreCommProductMapper dmiStoreCommProductMapper;

    /**
     * 查询门店中通信产品列表
     * @param dmiStoreCommProduct
     * @return
     */
    public Result findPage(DmiStoreCommProduct dmiStoreCommProduct) {

        //关联公司条件
//        dmiStoreCommProduct.setRelationCompanyIds(CurrentUtil.getCurrent().getRelationCompanyIds());

        PageHelper.startPage(dmiStoreCommProduct.getPageNum(), dmiStoreCommProduct.getPageSize());
        Page<DmiStoreCommProduct> persons = dmiStoreCommProductMapper.findPage(dmiStoreCommProduct);
        // 需要把Page包装成PageInfo对象才能序列化。该插件也默认实现了一个PageInfo
        PageInfo<DmiStoreCommProduct> pageInfo = new PageInfo<>(persons);
        return ResultUtil.success(pageInfo);
    }


    /**
     * 根据通信产品ID，失效通信产品
     * @param invalidParam
     * @param userId
     * @return
     */
    public Result handleInvalid(DmiStoreCommProduct invalidParam, Integer userId) {
        invalidParam.setFlagAvaliable(false);
        invalidParam.setUpdateTime(new Date());
        invalidParam.setUpdatePerson(userId);
        dmiStoreCommProductMapper.updateByPrimaryKeySelective(invalidParam);
        return ResultUtil.successMsg("失效成功");
    }


    /**
     * 根据通信产品ID，删除通信产品
     * @param deleteParam
     * @param userId
     * @return
     */
    public Result handleDelete(DmiStoreCommProduct deleteParam, Integer userId) {
        deleteParam.setFlagDeleted(true);
        deleteParam.setUpdateTime(new Date());
        deleteParam.setUpdatePerson(userId);
        dmiStoreCommProductMapper.updateByPrimaryKeySelective(deleteParam);
        return ResultUtil.successMsg("删除成功");
    }

    public List<DmiStoreCommProduct> getListByMarketingCampaignId(int marketingCampaignId) {
        return dmiStoreCommProductMapper.getListByMarketingCampaignId(marketingCampaignId);
    }


    public List<DmiStoreCommProduct> getIndependenceProductListByStoreId(int storeId) {
        return dmiStoreCommProductMapper.getIndependenceProductListByStoreId(storeId);
    }

    /**
     * 门店通信产品新增/编辑-宽带
     * @param requestJson
     * @param userId
     * @return
     */
    public Result handleBroadband(String requestJson, Integer userId) {

        DmiStoreCommProduct product = JSON.parseObject(requestJson, DmiStoreCommProduct.class);
        DmiCommProductBroadbandWithBLOBs broadband = JSON.parseObject(requestJson, DmiCommProductBroadbandWithBLOBs.class);
        BifCommunicationServiceContact contact = JSON.parseObject(requestJson, BifCommunicationServiceContact.class);
        DmiCommProductBilling billing = JSON.parseObject(requestJson, DmiCommProductBilling.class);
        if (!validInsertForCamp(product)) {
            return ResultUtil.successMsg("新增产品失败-该产品的通信品牌与套餐中的其他产品不一致");
        }

        // 系统生成产品概要描述
        if (product.getCatalogId() != null) {
            CfgCommunicationTypeCatalog typeCatalog = cfgCommunicationTypeCatalogMapper.selectByPrimaryKey(product.getCatalogId());
            if (typeCatalog != null) {
                String catalogName = typeCatalog.getCatalogName();
                String flagIp = "_无IP";
                if (broadband.getFlagFixedIp()) flagIp = "_有IP";
                String productDescription = catalogName + "_下行" + broadband.getBandWidthDown() + broadband.getUnitBandWidthDown() + "_上行"
                        + broadband.getBandWidthUp() + broadband.getUnitBandWidthUp() + flagIp;
                product.setProductDescription(productDescription);
            }
        }

        // 新增
        if (product.getId() == null || product.getId() == 0) {
            // 首先新增产品
            int productId = insertProduct(product, contact, userId, billing);
            // 产品ID
            broadband.setProductId(productId);
            // 是否上下行对称
            broadband.setFlagSymmetry(false);
            if (broadband.getBandWidthUp().intValue() == broadband.getBandWidthDown().intValue() && broadband.getUnitBandWidthUp().equals(broadband
                    .getUnitBandWidthDown())) {
                broadband.setFlagSymmetry(true);
            }
            // Ip段开始换算值
            String ipSectionBegin = broadband.getIpSectionBegin();
            if (StringUtils.isNotBlank(ipSectionBegin)) {
                String ipSectionBeginValue = ipSectionBegin.replace(".", "0");
                broadband.setIpSectionBeginValue(ipSectionBeginValue);
            }
            // 上行带宽为空时，设置为0
            if (broadband.getBandWidthUp() == null) broadband.setBandWidthUp(0);
            // 下行带宽为空时，设置为0
            if (broadband.getBandWidthDown() == null) broadband.setBandWidthDown(0);
            // Ip段结束换算值
            String ipSectioEnd = broadband.getIpSectionEnd();
            if (StringUtils.isNotBlank(ipSectioEnd)) {
                String ipSectionEndValue = ipSectioEnd.replace(".", "0");
                broadband.setIpSectionEndValue(ipSectionEndValue);
            }
            broadband.setCreatePerson(userId);
            broadband.setCreateTime(new Date());
            broadband.setUpdatePerson(userId);
            broadband.setUpdateTime(new Date());
            broadband.setFlagDeleted(false);
            if(broadbandMapper.insertSelective(broadband)>0){
                return ResultUtil.successMsg("新增成功");
            }
            return ResultUtil.errorBusinessMsg("新增失败");
        } else {
            // 更新
            updateProduct(product, contact, userId, billing);
            broadband.setProductId(product.getId());
            // 是否上下行对称
            broadband.setFlagSymmetry(false);
            if (broadband.getBandWidthUp().intValue() == broadband.getBandWidthDown().intValue() && broadband.getUnitBandWidthUp().equals(broadband
                    .getUnitBandWidthDown())) {
                broadband.setFlagSymmetry(true);
            }
            // Ip段开始换算值
            String ipSectionBegin = broadband.getIpSectionBegin();
            if (StringUtils.isNotBlank(ipSectionBegin)) {
                String ipSectionBeginValue = ipSectionBegin.replace(".", "0");
                broadband.setIpSectionBeginValue(ipSectionBeginValue);
            }
            // Ip段结束换算值
            String ipSectionEnd = broadband.getIpSectionEnd();
            if (StringUtils.isNotBlank(ipSectionEnd)) {
                String ipSectionEndValue = ipSectionEnd.replace(".", "0");
                broadband.setIpSectionEndValue(ipSectionEndValue);
            }
            broadband.setUpdatePerson(userId);
            broadband.setUpdateTime(new Date());
            if(broadbandMapper.updateByProductIdSelective(broadband)>0){
                return ResultUtil.successMsg("更新成功");
            }
            return ResultUtil.errorBusinessMsg("更新失败");

        }
    }


    /**
     * 门店通信产品新增/编辑-中继语音
     * @param requestJson
     * @param userId
     * @return
     */
    public Result handleTrunking(String requestJson, Integer userId) {

        DmiStoreCommProduct product = JSON.parseObject(requestJson, DmiStoreCommProduct.class);
        DmiCommProductTrunking trunking = JSON.parseObject(requestJson, DmiCommProductTrunking.class);
        BifCommunicationServiceContact contact = JSON.parseObject(requestJson, BifCommunicationServiceContact.class);
        DmiCommProductBilling billing = JSON.parseObject(requestJson, DmiCommProductBilling.class);

        if (!validInsertForCamp(product)) {
            return ResultUtil.successMsg("新增产品失败-该产品的通信品牌与套餐中的其他产品不一致");
        }

        // 系统生成产品概要描述
        String catalogName = getCatalogName(product);
        product.setProductDescription(catalogName);

        // 设备号
        if (StringUtils.isNotBlank(trunking.getDisplayNumber())) {
            product.setDeviceNumber(trunking.getDisplayNumber());
        }
        // 包含线路默认设成1
        if (trunking.getContainLines() == null) {
            trunking.setContainLines(1);
        }

        // 新增
        if (product.getId() == null || product.getId() == 0) {
            // 首先新增产品
            int productId = insertProduct(product, contact, userId, billing);
            // 产品ID
            trunking.setProductId(productId);
            trunking.setCreatePerson(userId);
            trunking.setCreateTime(new Date());
            trunking.setUpdatePerson(userId);
            trunking.setUpdateTime(new Date());
            trunking.setFlagDeleted(false);
            trunkingMapper.insertSelective(trunking);
            return ResultUtil.successMsg("新增成功");
        } else {
            // 更新
            updateProduct(product, contact, userId, billing);
            trunking.setProductId(product.getId());
            trunking.setUpdatePerson(userId);
            trunking.setUpdateTime(new Date());
            trunkingMapper.updateByProductIdSelective(trunking);
            return ResultUtil.successMsg("更新成功");
        }
    }


    /**
     * 门店通信产品新增/编辑-直线语音
     * @param requestJson
     * @param userId
     * @return
     */
    public Result handleStraightLine(String requestJson, Integer userId) {

        DmiStoreCommProduct product = JSON.parseObject(requestJson, DmiStoreCommProduct.class);
        DmiCommProductStraightLine straightLine = JSON.parseObject(requestJson, DmiCommProductStraightLine.class);
        BifCommunicationServiceContact contact = JSON.parseObject(requestJson, BifCommunicationServiceContact.class);
        DmiCommProductBilling billing = JSON.parseObject(requestJson, DmiCommProductBilling.class);

        if (!validInsertForCamp(product)) {
            return ResultUtil.successMsg("新增产品失败-该产品的通信品牌与套餐中的其他产品不一致");
        }

        // 系统生成产品概要描述
        String catalogName = getCatalogName(product);
        product.setProductDescription(catalogName);

        // 新增
        if (product.getId() == null || product.getId() == 0) {
            // 首先新增产品
            String deviceNumber = product.getDeviceNumber();
            String[] deviceNumbers = deviceNumber.split(",");
            for (int i = 0; i < deviceNumbers.length; i++) {
                product.setDeviceNumber(deviceNumbers[i]);
                if (i >= 1) product.setId(0);
                int productId = insertProduct(product, contact, userId, billing);
                // 产品ID
                straightLine.setProductId(productId);
                straightLine.setCreatePerson(userId);
                straightLine.setCreateTime(new Date());
                straightLine.setUpdatePerson(userId);
                straightLine.setUpdateTime(new Date());
                straightLine.setFlagDeleted(false);
                straightLineMapper.insertSelective(straightLine);
            }
            return ResultUtil.successMsg("新增成功");
        } else {
            // 更新
            updateProduct(product, contact, userId, billing);
            straightLine.setProductId(product.getId());
            straightLine.setUpdatePerson(userId);
            straightLine.setUpdateTime(new Date());
            straightLineMapper.updateByProductIdSelective(straightLine);
            return ResultUtil.successMsg("更新成功");
        }
    }


    /**
     * 门店通信产品新增/编辑-专线
     * @param requestJson
     * @param userId
     * @return
     */
    public Result handleSpecialLine(String requestJson, Integer userId) {

        DmiStoreCommProduct product = JSON.parseObject(requestJson, DmiStoreCommProduct.class);
        DmiCommProductSpecialLine specialLine = JSON.parseObject(requestJson, DmiCommProductSpecialLine.class);
        BifCommunicationServiceContact contact = JSON.parseObject(requestJson, BifCommunicationServiceContact.class);
        DmiCommProductBilling billing = JSON.parseObject(requestJson, DmiCommProductBilling.class);
        if (!validInsertForCamp(product)) {
            return ResultUtil.successMsg("新增产品失败-该产品的通信品牌与套餐中的其他产品不一致");
        }

        // 系统生成产品概要描述
        String catalogName = getCatalogName(product);
        catalogName = catalogName + "_" + specialLine.getBandWidth() + specialLine.getaBandWidthType() + "（速率）";
        product.setProductDescription(catalogName);

        // 新增
        if (product.getId() == null || product.getId() == 0) {
            // 首先新增产品
            int productId = insertProduct(product, contact, userId, billing);
            // 产品ID
            specialLine.setProductId(productId);
            // a端服务店
            int storeId = product.getStoreId();
            specialLine.setaStoreId(storeId);
            // a端安装地址
            DmiStoreWithBusinessLicense storeInfo = storeService.getStoreBasicInfo(storeId);
            specialLine.setaAddressId(storeInfo.getAddrListId());
            // z端安装地址
            int zStoreId = specialLine.getzStoreId();
            DmiStoreWithBusinessLicense zStoreInfo = storeService.getStoreBasicInfo(zStoreId);
            specialLine.setzAddressId(zStoreInfo.getAddrListId());
            // a端速率为空时，设置成0
            if (specialLine.getaBandWidth() == null) specialLine.setaBandWidth(0);
            // z端速率为空时，设置成0
            if (specialLine.getzBandWidth() == null) specialLine.setzBandWidth(0);
            // 专线常规字段
            specialLine.setCreatePerson(userId);
            specialLine.setCreateTime(new Date());
            specialLine.setUpdatePerson(userId);
            specialLine.setUpdateTime(new Date());
            specialLine.setFlagDeleted(false);
            specialLineMapper.insertSelective(specialLine);
            return ResultUtil.successMsg("新增成功");
        } else {
            // 更新
            updateProduct(product, contact, userId, billing);
            specialLine.setProductId(product.getId());
            // z端安装地址
            int zStoreId = specialLine.getzStoreId();
            DmiStoreWithBusinessLicense zStoreInfo = storeService.getStoreBasicInfo(zStoreId);
            specialLine.setzAddressId(zStoreInfo.getAddrListId());
            specialLine.setUpdatePerson(userId);
            specialLine.setUpdateTime(new Date());
            specialLineMapper.updateByProductIdSelective(specialLine);
            return ResultUtil.successMsg("更新成功");
        }
    }


    /**
     * 门店通信产品新增/编辑-移动
     * @param requestJson
     * @param userId
     * @return
     */
    public Result handleMobile(String requestJson,Integer userId) {

        DmiStoreCommProduct product = JSON.parseObject(requestJson, DmiStoreCommProduct.class);
        DmiCommProductMobile mobile = JSON.parseObject(requestJson, DmiCommProductMobile.class);
        BifCommunicationServiceContact contact = JSON.parseObject(requestJson, BifCommunicationServiceContact.class);
        DmiCommProductBilling billing = JSON.parseObject(requestJson, DmiCommProductBilling.class);

        if (!validInsertForCamp(product)) {
            return ResultUtil.successMsg("新增产品失败-该产品的通信品牌与套餐中的其他产品不一致");
        }

        // 系统生成产品概要描述
        String catalogName = getCatalogName(product);
        product.setProductDescription(catalogName);
        catalogName = catalogName + "_" + mobile.getNetworkType() + "（网络制式）";
        product.setProductDescription(catalogName);

        // 新增
        if (product.getId() == null || product.getId() == 0) {
            // 首先新增产品
            int productId = insertProduct(product, contact, userId, billing);
            // 产品ID
            mobile.setProductId(productId);
            // 专线常规字段
            mobile.setCreatePerson(userId);
            mobile.setCreateTime(new Date());
            mobile.setUpdatePerson(userId);
            mobile.setUpdateTime(new Date());
            mobile.setFlagDeleted(false);
            mobileMapper.insertSelective(mobile);
            return ResultUtil.successMsg("新增成功");
        } else {
            // 更新
            updateProduct(product, contact, userId, billing);
            mobile.setProductId(product.getId());
            mobile.setUpdatePerson(userId);
            mobile.setUpdateTime(new Date());
            mobileMapper.updateByProductIdSelective(mobile);
            return ResultUtil.successMsg("更新成功");
        }
    }


    /**
     * 根据楼宇ID，查询通信产品列表
     * @param id
     * @return
     */
    public Result getListByBuildingId(int id) {
        List<GetListByBuildingIdRet> result = new ArrayList<GetListByBuildingIdRet>();
        // 根据楼宇ID查询门店
        List<DmiStore> storeList = storeService.listByBuildingId(id);
        if (storeList != null) {
            for (DmiStore store : storeList) {
                // 根据门店查询通信产品列表
                List<GetListByStoreIdRet> prodicts = dmiStoreCommProductMapper.getListByStoreId(store.getId());
                for (GetListByStoreIdRet item : prodicts) {
                    result.add(dozer.map(item, GetListByBuildingIdRet.class));
                }
            }
        }
        return ResultUtil.success(result);
    }


    /**
     * 根据产品ID，查询产品基本信息以及产品所在套餐信息
     * @param id
     * @return
     */
    public Result getProductAndPackageInfo(Integer id) {
        ProductShowRet productShowRet = (ProductShowRet)show(id).getData();
        DmiStoreCommProduct sqlResult = dmiStoreCommProductMapper.selectByPrimaryKey(id);
        if (productShowRet != null) {
            GetProductAndPackageInfoRet result = new GetProductAndPackageInfoRet();

            // 镜像复制
            ProductInfo productInfo = dozer.map(productShowRet, ProductInfo.class);
            // 产品大小类
            CfgCommunicationTypeCatalog child = cfgCommunicationTypeCatalogMapper.selectByPrimaryKey(productShowRet.getDmiStoreCommProduct().getCatalogId());
            if (child != null) {
                CfgCommunicationTypeCatalog father = cfgCommunicationTypeCatalogMapper.selectByPrimaryKey(child.getParentId());
                if (father == null) productInfo.setFatherCategory(child.getCatalogName());
                else {
                    productInfo.setFatherCategory(father.getCatalogName());
                    productInfo.setChildCategory(child.getCatalogName());
                }
            }
            // 品牌
            if (productShowRet.getDmiStoreCommProduct() != null && productShowRet.getDmiStoreCommProduct().getBrandId() != null) {
                CfgCommunicationBrand brandInfo = cfgCommunicationBrandMapper.selectByPrimaryKey(productShowRet.getDmiStoreCommProduct().getBrandId());
                if (brandInfo != null) productInfo.setBrandName(brandInfo.getBrandName());
            }

            result.setProductInfo(productInfo);

            MarketingCampaignShowRet campaignShowRet = campaignService.show(Integer.parseInt(sqlResult.getMarketingCampaignId()));
            if (campaignShowRet != null) {
                result.setCampaignInfo(dozer.map(campaignShowRet, CampaignInfo.class));
            } else {
                result.setCampaignInfo(null);
            }
            return ResultUtil.success(result);
        } else {
            return ResultUtil.errorExceptionMsg("productShowRet为空");
        }
    }


    /**
     * 根据某组条件，查询通信产品列表
     * @param commListDto
     * @return
     */
    public Result getCommList(CommListDto commListDto) {

        List<CommListForChargeRet> list = new ArrayList<>();
        if (commListDto.getFlagCampaign() == null) {
            list = dmiStoreCommProductMapper.getCommList(commListDto);
        }
        if (commListDto.getFlagCampaign()) {
            list = dmiStoreCommProductMapper.getCampaignList(commListDto);
        } else {
            list = dmiStoreCommProductMapper.getProductList(commListDto);
        }
        return ResultUtil.success(list);
    }



    public Result show(int id) {
        ProductShowRet result = new ProductShowRet();

        // 产品基础信息
        DmiStoreCommProduct product = dmiStoreCommProductMapper.show(id);
        result.setDmiStoreCommProduct(product);
        int catalogId = product.getCatalogId();
        if (catalogId == 5 || catalogId == 6) {
            result.setObjectInfo(broadbandService.show(id));
        } else if (catalogId == 13 || catalogId == 14) {
            result.setObjectInfo(mobileService.show(id));
        } else if (catalogId == 10 || catalogId == 11 || catalogId == 12) {
            result.setObjectInfo(specialLineService.show(id));
        } else if (catalogId == 7) {
            result.setObjectInfo(straightLineService.show(id));
        } else {
            result.setObjectInfo(trunkingService.show(id));
        }

        DmiStoreOverallInfo storeOverallInfo = storeService.showOverall(product.getStoreId());
        if (storeOverallInfo != null && storeOverallInfo.getDmiStoreWithBusinessLicense() != null) {
            DmiStoreWithBusinessLicense storeWithBusinessLicense = storeOverallInfo.getDmiStoreWithBusinessLicense();
            // 雇主
            if (storeWithBusinessLicense.getCompnayId() != null) {
                DmiCompanyInfo companyInfo = dmiCompanyInfoMapper.selectByPrimaryKey(storeWithBusinessLicense.getCompnayId());
                if (companyInfo != null) {
                    result.setCompany(companyInfo.getCompanyName());
                }
            }
            // 雇主品牌
            if (storeWithBusinessLicense.getBrandId() != null) {
                DmiBrand dmiBrand = dmiBrandMapper.selectByPrimaryKey(storeWithBusinessLicense.getBrandId());
                if (dmiBrand != null) {
                    result.setCompanyBrandName(dmiBrand.getBrandName());
                }
            }
            // 门店
            if (product.getStoreId() != null) {
                result.setStoreName(storeWithBusinessLicense.getStoreName());
            }
        }

        // 品牌
        if (product.getBrandId() != null) {
            CfgCommunicationBrand brandInfo = cfgCommunicationBrandMapper.selectByPrimaryKey(product.getBrandId());
            if (brandInfo != null) result.setBrandName(brandInfo.getBrandName());
        }

        // 联系人信息
        if (product.getServiceContactId() != null) {
            result.setContactInfo(bifCommunicationServiceContactMapper.selectByPrimaryKey(product.getServiceContactId()));
        }

        // 产品收费信息
        DmiCommCharge charge = new DmiCommCharge();
        charge.setObjectId(id);
        charge.setObjectType("PRODUCT");
        result.setDmiCommCharge(commChargeService.showByObjectId(charge));

        // 产品付费信息
        result.setPaymentShowRet(paymentService.showByObject(id, "PRODUCT"));

        // 产品所属套餐信息
        if (!product.getFlagIndependent()) {
            result.setMarketingCampaign(campaignService.show(Integer.valueOf(product.getMarketingCampaignId())));
        }

        // 账单信息
        BillingShowRet billingShowRet = billingService.show(true, id);
        result.setBillingInfo(billingShowRet);

        // 产品类型
        Map<String, String> catalogMap = getCatalogNmList(catalogId);
        result.setCatalogInfo(catalogMap);

        return ResultUtil.success(result);
    }

}
