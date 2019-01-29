package com.teekee.waterdropservice.entity.ret.dmi.DmiStoreCommProduct;

import java.util.Date;

/**
 * 通信收费账务信息-通信产品列表-返回结果
 *
 * @author Wujun
 * @create 2017年08月22日 18:47
 */
public class CommListForChargeRet {

    /**
     * id
     */
    private int id;

    /**
     * 产品/套餐名
     */
    private String name;

    /**
     * 雇主品牌
     */
    private String companyBrand;

    /**
     * 门店
     */
    private String storeName;

    /**
     * 通信品牌
     */
    private String communicationBrand;

    /**
     * 产品分类
     */
    private String commTypeCatalogNm;

    /**
     * 开始收费日期
     */
    private Date chargeStartDate;

    /**
     * 是否套餐
     */
    private Boolean flagCampaign;

    /**
     * 是否有效
     */
    private Boolean flagAvailable;

    /**
     * 是否包含在套餐内
     */
    private boolean flagInsideCampaign;

    private String status;

    /**
     * 是否单品收费
     */
    private Boolean flagChargeSingal;

    private Boolean flagInfoConfirm;

    private Boolean flagVendor;

    private Date updateTime;

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public boolean isFlagInsideCampaign() {
        return flagInsideCampaign;
    }

    public void setFlagInsideCampaign(boolean flagInsideCampaign) {
        this.flagInsideCampaign = flagInsideCampaign;
    }

    public Boolean getFlagVendor() {
        return flagVendor;
    }

    public void setFlagVendor(Boolean flagVendor) {
        this.flagVendor = flagVendor;
    }

    public Boolean getFlagInfoConfirm() {
        return flagInfoConfirm;
    }

    public void setFlagInfoConfirm(Boolean flagInfoConfirm) {
        this.flagInfoConfirm = flagInfoConfirm;
    }

    public Boolean getFlagChargeSingal() {
        return flagChargeSingal;
    }

    public void setFlagChargeSingal(Boolean flagChargeSingal) {
        this.flagChargeSingal = flagChargeSingal;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCompanyBrand() {
        return companyBrand;
    }

    public void setCompanyBrand(String companyBrand) {
        this.companyBrand = companyBrand;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getCommunicationBrand() {
        return communicationBrand;
    }

    public void setCommunicationBrand(String communicationBrand) {
        this.communicationBrand = communicationBrand;
    }

    public String getCommTypeCatalogNm() {
        return commTypeCatalogNm;
    }

    public void setCommTypeCatalogNm(String commTypeCatalogNm) {
        this.commTypeCatalogNm = commTypeCatalogNm;
    }

    public Date getChargeStartDate() {
        return chargeStartDate;
    }

    public void setChargeStartDate(Date chargeStartDate) {
        this.chargeStartDate = chargeStartDate;
    }

    public Boolean getFlagCampaign() {
        return flagCampaign;
    }

    public void setFlagCampaign(Boolean flagCampaign) {
        this.flagCampaign = flagCampaign;
    }

    public Boolean getFlagAvailable() {
        return flagAvailable;
    }

    public void setFlagAvailable(Boolean flagAvailable) {
        this.flagAvailable = flagAvailable;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
