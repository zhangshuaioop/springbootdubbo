package com.company.springboot.service.dmi.product;

import com.company.springboot.entity.bif.BifCommunicationServiceContact;
import com.company.springboot.entity.cfg.CfgCommunicationTypeCatalog;
import com.company.springboot.entity.dmi.DmiCommProductBilling;
import com.company.springboot.entity.dmi.DmiStoreCommProduct;
import com.company.springboot.mapper.bif.BifCommunicationServiceContactMapper;
import com.company.springboot.mapper.cfg.CfgCommunicationBrandMapper;
import com.company.springboot.mapper.cfg.CfgCommunicationTypeCatalogMapper;
import com.company.springboot.mapper.dmi.*;
import com.company.springboot.service.bif.BifCommunicationServiceContactService;
import com.company.springboot.service.bif.BifCommunicationServiceService;
import com.company.springboot.service.dmi.*;
import com.company.springboot.utils.DateUtil;
import com.company.springboot.utils.Result;
import com.company.springboot.utils.ResultUtil;
import com.company.springboot.entity.bif.BifCommunicationServiceContact;
import com.company.springboot.entity.cfg.CfgCommunicationTypeCatalog;
import com.company.springboot.entity.dmi.DmiCommProductBilling;
import com.company.springboot.entity.dmi.DmiStoreCommProduct;
import com.company.springboot.mapper.bif.BifCommunicationServiceContactMapper;
import com.company.springboot.mapper.cfg.CfgCommunicationBrandMapper;
import com.company.springboot.mapper.cfg.CfgCommunicationTypeCatalogMapper;
import com.company.springboot.mapper.dmi.*;
import com.company.springboot.service.bif.BifCommunicationServiceContactService;
import com.company.springboot.service.bif.BifCommunicationServiceService;
import com.company.springboot.service.dmi.*;
import com.company.springboot.utils.DateUtil;
import com.company.springboot.utils.Result;
import com.company.springboot.utils.ResultUtil;
import org.apache.commons.lang.StringUtils;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * 产品实现类主体
 *
 * @author Wujun
 * @create 2017年08月29日 9:29
 */
@Service
public class ProductMainBody extends CommonBiz {

    @Autowired
    protected DmiStoreCommProductMapper dmiStoreCommProductMapper;
    @Autowired
    protected DmiCommProductBroadbandMapper broadbandMapper;
    @Autowired
    protected DmiCommProductTrunkingMapper trunkingMapper;
    @Autowired
    protected DmiCommProductStraightLineMapper straightLineMapper;
    @Autowired
    protected DmiCommProductSpecialLineMapper specialLineMapper;
    @Autowired
    protected DmiCommProductMobileMapper mobileMapper;
    @Autowired
    protected CfgCommunicationTypeCatalogMapper cfgCommunicationTypeCatalogMapper;
    @Autowired
    protected BifCommunicationServiceContactService communicationServiceContactService;
    @Autowired
    protected DmiCommProductBillingMapper billingMapper;

    @Autowired
    protected DmiStoreService storeService;

    @Autowired
    protected CfgCommunicationBrandMapper cfgCommunicationBrandMapper;

    @Autowired
    protected DmiCommProductMarketingCampaignService campaignService;

    @Autowired
    protected DmiCommChargeService commChargeService;


    @Autowired
    protected DmiCompanyInfoMapper dmiCompanyInfoMapper;

    @Autowired
    protected DmiBrandMapper dmiBrandMapper;

    @Autowired
    protected DmiCommProductBillingService billingService;

    @Autowired
    protected BifCommunicationServiceService serviceService;

    @Autowired
    protected BifCommunicationServiceContactMapper bifCommunicationServiceContactMapper;

    @Autowired
    protected DmiStoreCommProductService productService;

    @Autowired
    protected DmiCommProductBroadbandService broadbandService;

    @Autowired
    protected DmiCommProductMobileService mobileService;

    @Autowired
    protected DmiCommProductSpecialLineService specialLineService;

    @Autowired
    protected DmiCommProductStraightLineService straightLineService;

    @Autowired
    protected DmiCommProductTrunkingService trunkingService;

    @Autowired
    protected DmiCommPaymentService paymentService;

    @Autowired
    protected Mapper dozer;

    protected boolean validInsertForCamp(DmiStoreCommProduct product) {
        if (StringUtils.isNotBlank(product.getMarketingCampaignId())) {
            List<DmiStoreCommProduct> products = dmiStoreCommProductMapper.getListByMarketingCampaignId(Integer.valueOf(product.getMarketingCampaignId()));
            if (products != null && !products.isEmpty()) {
                DmiStoreCommProduct item = products.get(0);
                if (item.getBrandId() != product.getBrandId()) {
                    return false;
                }
            }
        }
        return true;
    }

    protected int insertProduct(DmiStoreCommProduct product, BifCommunicationServiceContact contact, int userId, DmiCommProductBilling billing) {
        Date now = new Date();
        product = buildProduct(product, contact, userId);
        product.setCreatePerson(userId);
        product.setCreateTime(now);
        product.setFlagDeleted(false);
        product.setFlagAvaliable(true);
        product.setStatus("NEW");
        product.setFlagInfoConfirm(false);
        product.setUpdatePerson(userId);
        product.setUpdateTime(now);
        dmiStoreCommProductMapper.insertSelective(product);
        // 产品ID
        int productId = product.getId();
        // 新增账单信息
        billing.setId(null);
        billing.setObjectId(productId);
        billing.setFlagDeleted(false);
        billing.setCreateTime(now);
        billing.setCreatePerson(userId);
        billing.setUpdatePerson(userId);
        billing.setUpdateTime(now);
        billing.setFlagProductBill(true);
        billingMapper.insertSelective(billing);
        return productId;
    }

    protected DmiStoreCommProduct buildProduct(DmiStoreCommProduct product, BifCommunicationServiceContact contact, int userId) {
        // 服务商联系人
        if (StringUtils.isNotBlank(contact.getContactName()) && (product.getServiceContactId() == null || product.getServiceContactId() == 0)) {
            contact.setId(null);
            contact.setServiceId(product.getServiceId());
            BifCommunicationServiceContact sqlResult = communicationServiceContactService.showByService(contact.getServiceId(), contact.getContactName());
            int contactId;
            if (sqlResult != null) {
                contactId = sqlResult.getId();
                sqlResult.setTelephone(contact.getTelephone());
                communicationServiceContactService.update(sqlResult, userId);
            } else {
                contactId = communicationServiceContactService.insert(contact, userId);
            }
            product.setServiceContactId(contactId);
        } else {
            contact.setId(product.getServiceContactId());
            communicationServiceContactService.update(contact, userId);
        }
        /** 以下字段为空时，全部设置为0 */
        // 套餐ID
        if (StringUtils.isBlank(product.getMarketingCampaignId())) product.setMarketingCampaignId("0");

        // 生成产品虚拟设备号
        product.setProductCode(getProductCode(product.getCatalogId()));
        product.setUpdatePerson(userId);
        product.setUpdateTime(new Date());
        return product;
    }

    protected void updateProduct(DmiStoreCommProduct product, BifCommunicationServiceContact contact, int userId, DmiCommProductBilling billing) {
        if (product.getId() != null && product.getId() != 0) {
            product.setMarketingCampaignId(dmiStoreCommProductMapper.show(product.getId()).getMarketingCampaignId());
        }
        product = buildProduct(product, contact, userId);

        // 更新账单信息
        billing.setFlagProductBill(true);
        billing.setObjectId(product.getId());
        billing.setUpdatePerson(userId);
        billing.setUpdateTime(new Date());
        billingMapper.updateByObjectId(billing);
        dmiStoreCommProductMapper.updateByPrimaryKeySelective(product);
    }

    protected String getCatalogName(DmiStoreCommProduct product) {
        if (product.getCatalogId() != null) {
            CfgCommunicationTypeCatalog typeCatalog = cfgCommunicationTypeCatalogMapper.selectByPrimaryKey(product.getCatalogId());
            if (typeCatalog != null) {
                String catalogName = typeCatalog.getCatalogName();
                return catalogName;
            }
        }
        return "";
    }

    /**
     * 获取通信产品描述
     *
     * @param catalogId
     * @return
     */
    protected String getProductCode(int catalogId) {
        CfgCommunicationTypeCatalog typeCatalog = cfgCommunicationTypeCatalogMapper.selectByPrimaryKey(catalogId);
        if (typeCatalog != null) {
            String description = typeCatalog.getDescription();
            return description + "_" + DateUtil.getMilliDateString(new Date());
        }
        return "";
    }

    public Result insert(DmiStoreCommProduct record, int userId) {
        record.setCreatePerson(userId);
        record.setCreateTime(new Date());
        record.setFlagAvaliable(true);
        record.setFlagDeleted(false);
        dmiStoreCommProductMapper.insertSelective(record);
        return ResultUtil.successMsg("新增成功");
    }

    public Result update(DmiStoreCommProduct record, int userId) {
        record.setUpdatePerson(userId);
        record.setUpdateTime(new Date());
        dmiStoreCommProductMapper.updateByPrimaryKeySelective(record);
        return ResultUtil.successMsg("更新成功");
    }

    public Result invalid(int id, int userId) {
        DmiStoreCommProduct product = new DmiStoreCommProduct();
        product.setId(id);
        product.setFlagAvaliable(false);
        product.setUpdateTime(new Date());
        product.setUpdatePerson(userId);
        dmiStoreCommProductMapper.updateByPrimaryKeySelective(product);
        return ResultUtil.successMsg("失效成功");
    }

    public Result delete(int id, int userId) {
        DmiStoreCommProduct product = new DmiStoreCommProduct();
        product.setId(id);
        product.setFlagDeleted(true);
        product.setUpdateTime(new Date());
        product.setUpdatePerson(userId);
        dmiStoreCommProductMapper.updateByPrimaryKeySelective(product);
        return ResultUtil.successMsg("删除成功");
    }

}
