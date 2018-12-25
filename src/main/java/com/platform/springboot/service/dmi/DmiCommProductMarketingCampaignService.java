package com.platform.springboot.service.dmi;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.platform.springboot.entity.bif.BifCommunicationService;
import com.platform.springboot.entity.bif.BifCommunicationServiceContact;
import com.platform.springboot.entity.cfg.CfgCommunicationBrand;
import com.platform.springboot.entity.cfg.CfgCommunicationTypeCatalog;
import com.platform.springboot.entity.cfg.CfgDispatchDetailModel;
import com.platform.springboot.entity.dmi.*;
import com.platform.springboot.entity.dmi.dto.dmiCommProductMarketingCampaign.MarketingCampaignAddProductDTO;
import com.platform.springboot.entity.dmi.ret.common.BrandInfo;
import com.platform.springboot.entity.dmi.ret.dmiCommProductBilling.BillingShowRet;
import com.platform.springboot.entity.dmi.ret.dmiCommProductMarketingCampaign.ListRet;
import com.platform.springboot.entity.dmi.ret.dmiCommProductMarketingCampaign.MarketingCampaignGetProductListRet;
import com.platform.springboot.entity.dmi.ret.dmiCommProductMarketingCampaign.MarketingCampaignShowRet;
import com.platform.springboot.entity.dmi.ret.dmiStore.MarketingCampaignInfo;
import com.platform.springboot.entity.dmi.ret.dmiStore.ProductInfo;
import com.platform.springboot.entity.dmi.ret.dmiStoreCommProduct.MarketingCampaignShowProductRet;
import com.platform.springboot.mapper.cfg.CfgCommunicationBrandMapper;
import com.platform.springboot.mapper.dmi.DmiCommProductMarketingCampaignMapper;
import com.platform.springboot.mapper.dmi.DmiStoreCommProductMapper;
import com.platform.springboot.service.bif.BifCommunicationServiceContactService;
import com.platform.springboot.service.bif.BifCommunicationServiceService;
import com.platform.springboot.service.cfg.CfgCommunicationBrandService;
import com.platform.springboot.service.dmi.campaign.CampaignMainBody;
import com.platform.springboot.service.dmi.product.ProductMainBody;
import com.platform.springboot.utils.Constant;
import com.platform.springboot.utils.PageInfo;
import com.platform.springboot.utils.Result;
import com.platform.springboot.utils.ResultUtil;
import com.platform.springboot.service.bif.BifCommunicationServiceContactService;
import com.platform.springboot.service.bif.BifCommunicationServiceService;
import com.sun.org.apache.regexp.internal.RE;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

/**
 * @description:
 * @author: zhangshuai
 * @create: 2018-12-17 16:29
 */
@Service
public class DmiCommProductMarketingCampaignService extends CampaignMainBody {

    @Autowired
    protected DmiCommProductMarketingCampaignMapper marketingCampaignMapper;

    @Autowired
    protected DmiCommPaymentService paymentService;

    @Autowired
    protected CfgCommunicationBrandService communicationBrandService;

    @Autowired
    protected BifCommunicationServiceService communicationServiceService;

    @Autowired
    protected DmiStoreCommProductService storeCommProductService;

    @Autowired
    protected BifCommunicationServiceContactService bifCommunicationServiceContactService;


    @Autowired
    protected CfgCommunicationBrandMapper cfgCommunicationBrandMapper;

    @Autowired
    protected DmiStoreCommProductMapper productMapper;

    /**
     * 信息确认
     * @param:
     * @return:
     * @Author Niting
     * @date: 2018/12/18
     */
    public Result confirmInfo(int id) {
        return super.confirmInfo(id, "CAMPAIGN");
    }

    /**
     * 信息待审核
     * @param:
     * @return:
     * @Author Niting
     * @date: 2018/12/18
     */
    public Result needCheckInfo(int id) {
        return super.needCheckInfo(id, "CAMPAIGN");
    }

    /**
     * 信息已审核
     * @param:
     * @return:
     * @Author Niting
     * @date: 2018/12/18
     */
    public Result checkInfo(int id) {
        return super.checkInfo(id, "CAMPAIGN");
    }

    /**
     * 审核不通过
     * @param:
     * @return:
     * @Author Niting
     * @date: 2018/12/18
     */
    public Result checkNoInfo(int id) {
        return super.checkNoInfo(id, "CAMPAIGN");
    }

    /**
     * 根据套餐ID，查询套餐详情
     * @param:
     * @return:
     * @Author Niting
     * @date: 2018/12/19
     */
    public MarketingCampaignShowRet show(int id) {
        DmiCommProductMarketingCampaign sqlResult = marketingCampaignMapper.selectByPrimaryKey(id);
        MarketingCampaignShowRet result = new MarketingCampaignShowRet();
        if (sqlResult != null) {
            // 品牌
            if (sqlResult.getBrandId() != null) {
                CfgCommunicationBrand brandInfo = cfgCommunicationBrandMapper.selectByPrimaryKey(sqlResult.getBrandId());
                if (brandInfo != null) result.setBrandName(brandInfo.getBrandName());
            }

            DmiStoreOverallInfo storeOverallInfo = storeService.showOverall(sqlResult.getStoreId());
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
                if (sqlResult.getStoreId() != null) {
                    result.setStoreName(storeWithBusinessLicense.getStoreName());
                }
            }

            // 套餐基本信息
            result.setMarketingCampaign(sqlResult);

            // 账单信息
            BillingShowRet billingShowRet = billingService.show(false, sqlResult.getId());
            result.setBillingInfo(billingShowRet);

            // 服务商信息
            if (sqlResult.getServiceId() != null) {
                Result<BifCommunicationService> serviceInfo = serviceService.getCommunicationService(sqlResult.getServiceId());
                result.setServiceInfo(serviceInfo.getData());
            }

            // 服务商联系人信息
            if (sqlResult.getServiceContactId() != null) {
                result.setContactInfo(bifCommunicationServiceContactMapper.selectByPrimaryKey(sqlResult.getServiceContactId()));
            }

            // 包含产品信息
            List<DmiStoreCommProduct> productInfoList = productService.getListByMarketingCampaignId(sqlResult.getId());
            List<MarketingCampaignShowProductRet> productListInfo = new ArrayList<MarketingCampaignShowProductRet>();
            for (DmiStoreCommProduct item : productInfoList) {
                MarketingCampaignShowProductRet outItem = new MarketingCampaignShowProductRet();
                outItem.setProductDescription(item.getProductDescription());
                CfgCommunicationTypeCatalog catalogInfo = cfgCommunicationTypeCatalogMapper.selectByPrimaryKey(item.getCatalogId());
                outItem.setCatalogName(catalogInfo.getCatalogName());
                outItem.setProductCode(item.getProductCode());
                outItem.setDeviceNumber(item.getDeviceNumber());
                productListInfo.add(outItem);
            }
            result.setProductListInfo(productListInfo);

            // 收费信息
            DmiCommCharge dmiCommCharge = new DmiCommCharge();
            dmiCommCharge.setObjectId(id);
            dmiCommCharge.setObjectType("CAMPAIGN");
            result.setDmiCommCharge(commChargeService.showByObjectId(dmiCommCharge));

            // 付费信息
            result.setPaymentShowRet(paymentService.showByObject(id, "CAMPAIGN"));

        }
        return result;
    }


    public Result getListByStoreId(DmiCommProductMarketingCampaign dmiCommProductMarketingCampaign) {

        PageHelper.startPage(dmiCommProductMarketingCampaign.getPageNum(), dmiCommProductMarketingCampaign.getPageSize());
        Page<DmiCommProductMarketingCampaignPage> persons = marketingCampaignMapper.getPageListByStoreId(dmiCommProductMarketingCampaign.getStoreId());
        // 需要把Page包装成PageInfo对象才能序列化。该插件也默认实现了一个PageInfo
        PageInfo<DmiCommProductMarketingCampaignPage> pageInfo = new PageInfo<>(persons);
        List<DmiCommProductMarketingCampaignPage> sqlResult = pageInfo.getList();
        for (DmiCommProductMarketingCampaignPage item : sqlResult) {
            // 包含产品的数量
            List<DmiStoreCommProduct> products = storeCommProductService.getListByMarketingCampaignId(item.getId());
            if (products != null){
                item.setProductCount(products.size());
            }else{
                item.setProductCount(0);
            }
        }
        return ResultUtil.success(pageInfo);
    }

    /**
     * 新增/编辑套餐
     * @param:
     * @return:
     * @Author Niting
     * @date: 2018/12/18
     */
    @Transactional(rollbackFor = Exception.class)
    public Result handle(DmiCommProductMarketingCampaign marketingCampaign, DmiCommProductBilling billing, BifCommunicationServiceContact contact, int userId) {
        // 服务商联系人
        if (StringUtils.isNotBlank(contact.getContactName()) && (marketingCampaign.getServiceContactId() == null || marketingCampaign.getServiceContactId()
                == 0)) {
            contact.setId(null);
            int contactId = bifCommunicationServiceContactService.insert(contact, userId);
            marketingCampaign.setServiceContactId(contactId);
        }

        /** 新增 */
        if (marketingCampaign.getId() == null || marketingCampaign.getId() == 0) {
            marketingCampaign.setProductCode("TC_" + System.currentTimeMillis());
            marketingCampaign.setStatus(Constant.COMM_STATUS_NEW);
            marketingCampaign.setFlagAvaliable(true);
            marketingCampaign.setFlagDeleted(false);
            marketingCampaign.setCreateTime(new Date());
            marketingCampaign.setCreatePerson(userId);
            marketingCampaign.setUpdatePerson(userId);
            marketingCampaign.setUpdateTime(new Date());
            marketingCampaign.setFlagInfoConfirm(false);
            marketingCampaignMapper.insertSelective(marketingCampaign);
            // 新增账单信息
            billing.setId(null);
            billing.setObjectId(marketingCampaign.getId());
            billing.setFlagDeleted(false);
            billing.setCreateTime(new Date());
            billing.setCreatePerson(userId);
            billing.setUpdatePerson(userId);
            billing.setUpdateTime(new Date());
            billing.setFlagProductBill(false);
            billingMapper.insertSelective(billing);
            return ResultUtil.successMsg("新增套餐成功！");
        } else {
            /** 更新 */
            // 已包含产品的套餐，不能修改通信品牌
            DmiCommProductMarketingCampaign campaignSqlResult = marketingCampaignMapper.selectByPrimaryKey(marketingCampaign.getId());
            List<DmiStoreCommProduct> productsInCampaign = storeCommProductService.getListByMarketingCampaignId(marketingCampaign.getId());
            if (marketingCampaign.getBrandId() != campaignSqlResult.getBrandId() && productsInCampaign != null && !productsInCampaign.isEmpty()) {
                return ResultUtil.errorExceptionMsg("操作失败，该套餐的通信品牌已经生效，不能修改");
            }
            marketingCampaign.setUpdatePerson(userId);
            marketingCampaign.setUpdateTime(new Date());
            marketingCampaignMapper.updateByPrimaryKeySelective(marketingCampaign);
            // 更新账单信息
            billing.setFlagProductBill(false);
            billing.setObjectId(marketingCampaign.getId());
            billing.setUpdatePerson(userId);
            billing.setUpdateTime(new Date());
            billingMapper.updateByObjectId(billing);
            return ResultUtil.successMsg("更新套餐信息成功！");
        }
    }

    /**
     * 套餐失效
     * @param:
     * @return:
     * @Author Niting
     * @date: 2018/12/18
     */
    @Transactional(rollbackFor = Exception.class)
    public Result handleInvalid(DmiCommProductMarketingCampaign marketingCampaign, int userId) {
        if (marketingCampaign.getId() == null || marketingCampaign.getId() == 0) {
            return ResultUtil.errorExceptionMsg("更新套餐失败-套餐ID不能为空！");
        }
        marketingCampaign.setUpdatePerson(userId);
        marketingCampaign.setUpdateTime(new Date());
        marketingCampaign.setFlagAvaliable(false);
        marketingCampaignMapper.updateByPrimaryKeySelective(marketingCampaign);
        return ResultUtil.successMsg("失效成功！");
    }

    /**
     * 删除套餐
     * @param:
     * @return:
     * @Author Niting
     * @date: 2018/12/18
     */
    @Transactional(rollbackFor = Exception.class)
    public Result handleDelete(DmiCommProductMarketingCampaign marketingCampaign, int userId) {
        if (marketingCampaign.getId() == null || marketingCampaign.getId() == 0) {
            return ResultUtil.errorExceptionMsg("更新套餐失败-套餐ID不能为空！");
        }

        // 查询套餐下面是否是否包含产品
        List<DmiStoreCommProduct> list = productMapper.getListByMarketingCampaignId(marketingCampaign.getId());
        if (list != null && !list.isEmpty()) {
            return ResultUtil.errorExceptionMsg("删除失败，该套餐下包含产品，不能删除！");
        }

        marketingCampaign.setUpdatePerson(userId);
        marketingCampaign.setUpdateTime(new Date());
        marketingCampaign.setFlagDeleted(true);
        marketingCampaignMapper.updateByPrimaryKeySelective(marketingCampaign);
        return ResultUtil.successMsg("删除成功！");
    }
    /**
     * 根据套餐ID，查询所有产品列表
     * @param:
     * @return:
     * @Author Niting
     * @date: 2018/12/18
     */
    public Result getProductListByPackageId(int id) {
        List<DmiStoreCommProduct> sqlRsult = productService.getListByMarketingCampaignId(id);
        return ResultUtil.success(sqlRsult);
    }

    /**
     * 根据门店ID，查询所有独立产品列表
     * @param:
     * @return:
     * @Author Niting
     * @date: 2018/12/18
     */
    public List<MarketingCampaignGetProductListRet> getIndependenceProductList(int id) {
        List<DmiStoreCommProduct> sqlRsult = productService.getIndependenceProductListByStoreId(id);
        return buildProductList(sqlRsult);
    }

    /**
     * 添加产品到套餐中
     * @param:
     * @return:
     * @Author Niting
     * @date: 2018/12/18
     */
    @Transactional(rollbackFor = Exception.class)
    public Result addProduct(MarketingCampaignAddProductDTO dto, int userId) {

        // 判断通信品牌是否相同
        DmiCommProductMarketingCampaign campaignInfo = marketingCampaignMapper.selectByPrimaryKey(dto.getMarketingCampaignId());
        DmiStoreCommProduct product = productMapper.selectByPrimaryKey(dto.getProductId());
        if (campaignInfo == null) {
            return ResultUtil.errorExceptionMsg("操作失败，套餐不存在！");
        }
        if (product == null) {
            return ResultUtil.errorExceptionMsg("操作失败，产品不存在！");
        }
        if (campaignInfo.getBrandId() == null || campaignInfo.getBrandId() == 0) {
            DmiCommProductMarketingCampaign updateDTO = new DmiCommProductMarketingCampaign();
            updateDTO.setBrandId(product.getBrandId());
            updateDTO.setId(dto.getMarketingCampaignId());
            marketingCampaignMapper.updateByPrimaryKeySelective(updateDTO);
        } else {
            if (campaignInfo.getBrandId() != product.getBrandId()) {
                return ResultUtil.errorExceptionMsg("操作失败，产品品牌不属于套餐品牌的范围！");
            }
        }

        DmiStoreCommProduct productInfo = new DmiStoreCommProduct();
        productInfo.setUpdateTime(new Date());
        productInfo.setUpdatePerson(userId);
        productInfo.setMarketingCampaignId(dto.getMarketingCampaignId().toString());
        productInfo.setFlagIndependent(false);
        productInfo.setId(dto.getProductId());
        productMapper.updateByPrimaryKeySelective(productInfo);

        return ResultUtil.successMsg("添加产品-成功！");
    }

    /**
     * 从套餐中移除产品
     * @param:
     * @return:
     * @Author Niting
     * @date: 2018/12/18
     */
    public Result handleRemove(MarketingCampaignAddProductDTO dto, int userId) {
        DmiStoreCommProduct productInfo = new DmiStoreCommProduct();
        productInfo.setUpdateTime(new Date());
        productInfo.setUpdatePerson(userId);
        productInfo.setMarketingCampaignId("0");
        productInfo.setFlagIndependent(true);
        productInfo.setId(dto.getProductId());
        productMapper.updateByPrimaryKeySelective(productInfo);
        return ResultUtil.successMsg("移除产品-成功！");
    }

    public List<MarketingCampaignInfo> showListByStoreId(int storeId) {
        List<MarketingCampaignInfo> result = new ArrayList<MarketingCampaignInfo>();

        List<DmiCommProductMarketingCampaign> sqlResult = marketingCampaignMapper.getListByStoreId(storeId);
        if (sqlResult != null && !sqlResult.isEmpty()) {
            for (DmiCommProductMarketingCampaign item : sqlResult) {
                MarketingCampaignInfo outItem = new MarketingCampaignInfo();

                // 套餐基本信息
                outItem.setMarketingCampaign(item);

                // 付费信息
                outItem.setPaymentShowRet(paymentService.showByObject(item.getId(), "CAMPAIGN"));

                // 收费信息
                DmiCommCharge charge = new DmiCommCharge();
                charge.setObjectId(item.getId());
                charge.setObjectType("CAMPAIGN");
                outItem.setDmiCommCharge(commChargeService.showByObjectId(charge));

                // 包含产品信息
                List<DmiStoreCommProduct> marketingCampaignProductList = productService.getListByMarketingCampaignId(item.getId());
                if (marketingCampaignProductList != null && !marketingCampaignProductList.isEmpty()) {
                    List<ProductInfo> productInfoList = new ArrayList<ProductInfo>();
                    for (DmiStoreCommProduct productItem : marketingCampaignProductList) {
                        ProductInfo productOutItem = new ProductInfo();
                        productOutItem.setSubBrand(productItem.getSubBrand());
                        // 产品名
                        productOutItem.setProductDescription(productItem.getProductDescription());
                        // 产品大小类
                        Map<String, String> catalogMap = getCatalogNmList(productItem.getCatalogId());
                        productOutItem.setFatherCategory(catalogMap.get(CATALOG_MAP_FATHER_KEY));
                        productOutItem.setChildCategory(catalogMap.get(CATALOG_MAP_CHILD_KEY));
                        // 品牌
                        if (productItem.getBrandId() != null) {
                            CfgCommunicationBrand brandInfo = cfgCommunicationBrandMapper.selectByPrimaryKey(productItem.getBrandId());
                            if (brandInfo != null) productOutItem.setBrandName(brandInfo.getBrandName());
                        }

                        // ISP服务商
                        productOutItem.setIspService(productItem.getIspService());
                        // 产品类型
                        String productCategoryType = cfgCommunicationTypeCatalogMapper.selectByPrimaryKey(productItem.getCatalogId()).getCatalogName();
                        productOutItem.setProductCategoryType(productCategoryType);
                        // 产品特有信息
                        productOutItem.setObjectInfo(getObjectProductByCatalog(productItem.getCatalogId(), productItem.getId()));
                        productInfoList.add(productOutItem);
                    }
                    outItem.setProductListInfo(productInfoList);
                } else {
                    outItem.setProductListInfo(null);
                }

                result.add(outItem);
            }
        }
        return result;
    }


}
