package com.platform.springboot.entity.dmi;

import com.platform.springboot.base.BaseEntity;
import com.platform.springboot.base.BaseEntity;
import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author zhanghao
 * @Title: DmiCommProductMarketingCampaignPage
 * @ProjectName WaterDrop
 * @date 2018/12/24下午3:40
 */
public class DmiCommProductMarketingCampaignPage extends BaseEntity {

    private Integer id;

    private Integer storeId;

    private Integer companyId;

    private String campaignName;

    private String description;

    private Date purchaseDate;

    private Date installDate;

    private Integer serviceId;

    private BigDecimal payBalance;

    private String register;

    private String registerType;

    private String registerCode;

    private String status;

    private Boolean flagAvaliable;

    private Boolean flagDeleted;

    private Boolean flagChargeSingal;

    private Boolean flagInfoConfirm;

    private Date createTime;

    private Integer createPerson;

    private Integer updatePerson;

    private Date updateTime;

    private Integer brandId;

    private Boolean flagVendor;

    private Integer serviceContactId;

    private String productCode;

    private String ispService;

    private boolean flagChargeAgency;

    private String memo;

    private String BrandName;

    private String ServiceName;

    private Integer productCount;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getStoreId() {
        return storeId;
    }

    public void setStoreId(Integer storeId) {
        this.storeId = storeId;
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public String getCampaignName() {
        return campaignName;
    }

    public void setCampaignName(String campaignName) {
        this.campaignName = campaignName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(Date purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public Date getInstallDate() {
        return installDate;
    }

    public void setInstallDate(Date installDate) {
        this.installDate = installDate;
    }

    public Integer getServiceId() {
        return serviceId;
    }

    public void setServiceId(Integer serviceId) {
        this.serviceId = serviceId;
    }

    public BigDecimal getPayBalance() {
        return payBalance;
    }

    public void setPayBalance(BigDecimal payBalance) {
        this.payBalance = payBalance;
    }

    public String getRegister() {
        return register;
    }

    public void setRegister(String register) {
        this.register = register;
    }

    public String getRegisterType() {
        return registerType;
    }

    public void setRegisterType(String registerType) {
        this.registerType = registerType;
    }

    public String getRegisterCode() {
        return registerCode;
    }

    public void setRegisterCode(String registerCode) {
        this.registerCode = registerCode;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Boolean getFlagAvaliable() {
        return flagAvaliable;
    }

    public void setFlagAvaliable(Boolean flagAvaliable) {
        this.flagAvaliable = flagAvaliable;
    }

    public Boolean getFlagDeleted() {
        return flagDeleted;
    }

    public void setFlagDeleted(Boolean flagDeleted) {
        this.flagDeleted = flagDeleted;
    }

    public Boolean getFlagChargeSingal() {
        return flagChargeSingal;
    }

    public void setFlagChargeSingal(Boolean flagChargeSingal) {
        this.flagChargeSingal = flagChargeSingal;
    }

    public Boolean getFlagInfoConfirm() {
        return flagInfoConfirm;
    }

    public void setFlagInfoConfirm(Boolean flagInfoConfirm) {
        this.flagInfoConfirm = flagInfoConfirm;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getCreatePerson() {
        return createPerson;
    }

    public void setCreatePerson(Integer createPerson) {
        this.createPerson = createPerson;
    }

    public Integer getUpdatePerson() {
        return updatePerson;
    }

    public void setUpdatePerson(Integer updatePerson) {
        this.updatePerson = updatePerson;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getBrandId() {
        return brandId;
    }

    public void setBrandId(Integer brandId) {
        this.brandId = brandId;
    }

    public Boolean getFlagVendor() {
        return flagVendor;
    }

    public void setFlagVendor(Boolean flagVendor) {
        this.flagVendor = flagVendor;
    }

    public Integer getServiceContactId() {
        return serviceContactId;
    }

    public void setServiceContactId(Integer serviceContactId) {
        this.serviceContactId = serviceContactId;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getIspService() {
        return ispService;
    }

    public void setIspService(String ispService) {
        this.ispService = ispService;
    }

    public boolean isFlagChargeAgency() {
        return flagChargeAgency;
    }

    public void setFlagChargeAgency(boolean flagChargeAgency) {
        this.flagChargeAgency = flagChargeAgency;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public String getBrandName() {
        return BrandName;
    }

    public void setBrandName(String brandName) {
        BrandName = brandName;
    }

    public String getServiceName() {
        return ServiceName;
    }

    public void setServiceName(String serviceName) {
        ServiceName = serviceName;
    }

    public Integer getProductCount() {
        return productCount;
    }

    public void setProductCount(Integer productCount) {
        this.productCount = productCount;
    }
}
