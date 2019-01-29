package com.teekee.waterdropservice.entity.dto.dmi.DmiCompanyInfo;

import javax.validation.constraints.Min;
import java.util.Date;

/**
 * 根据某组条件，查询指定雇主下的通信资源列表
 *
 * @author Wujun
 * @create 2017年09月08日 13:27
 */
public class CommListDTO {

    @Min(value = 1, message = "非法请求，请勿再次尝试")
    private int companyId;

    @Min(value = 0, message = "非法请求，请勿再次尝试")
    private int commBrandId;

    @Min(value = 0, message = "非法请求，请勿再次尝试")
    private int catalogId;

    @Min(value = 0, message = "非法请求，请勿再次尝试")
    private int companyBrandId;

    @Min(value = 0, message = "非法请求，请勿再次尝试")
    private int storeId;

    private Boolean storeFlagAvailable;

    private String productCode;

    private String province;

    private String city;

    private String district;

    private Date chargeBeginDate;

    private Date chargeEndDate;

    private Boolean flagCampaign;

    public Boolean getFlagCampaign() {
        return flagCampaign;
    }

    public void setFlagCampaign(Boolean flagCampaign) {
        this.flagCampaign = flagCampaign;
    }

    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    public int getCommBrandId() {
        return commBrandId;
    }

    public void setCommBrandId(int commBrandId) {
        this.commBrandId = commBrandId;
    }

    public int getCatalogId() {
        return catalogId;
    }

    public void setCatalogId(int catalogId) {
        this.catalogId = catalogId;
    }

    public int getCompanyBrandId() {
        return companyBrandId;
    }

    public void setCompanyBrandId(int companyBrandId) {
        this.companyBrandId = companyBrandId;
    }

    public int getStoreId() {
        return storeId;
    }

    public void setStoreId(int storeId) {
        this.storeId = storeId;
    }

    public Boolean getStoreFlagAvailable() {
        return storeFlagAvailable;
    }

    public void setStoreFlagAvailable(Boolean storeFlagAvailable) {
        this.storeFlagAvailable = storeFlagAvailable;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public Date getChargeBeginDate() {
        return chargeBeginDate;
    }

    public void setChargeBeginDate(Date chargeBeginDate) {
        this.chargeBeginDate = chargeBeginDate;
    }

    public Date getChargeEndDate() {
        return chargeEndDate;
    }

    public void setChargeEndDate(Date chargeEndDate) {
        this.chargeEndDate = chargeEndDate;
    }
}
