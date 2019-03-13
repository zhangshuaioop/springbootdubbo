package com.company.springboot.entity.dto.dmi.DmiStoreCommProduct;

import com.company.springboot.base.BaseEntity;

/**
 * @author Wujun
 * @create 2017年08月22日 19:42
 */
public class CommListDto extends BaseEntity {
    private int companyId;

    private int companyBrandId;

    private int storeId;

    private String province;

    private String city;

    private String district;

    private Boolean flagCampaign;

    private int communicationBrandId;

    private int catalogId;

    private String status;

    private Boolean flagChargeSingal;

    public Boolean getFlagChargeSingal() {
        return flagChargeSingal;
    }

    public void setFlagChargeSingal(Boolean flagChargeSingal) {
        this.flagChargeSingal = flagChargeSingal;
    }

    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
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

    public Boolean getFlagCampaign() {
        return flagCampaign;
    }

    public void setFlagCampaign(Boolean flagCampaign) {
        this.flagCampaign = flagCampaign;
    }

    public int getCommunicationBrandId() {
        return communicationBrandId;
    }

    public void setCommunicationBrandId(int communicationBrandId) {
        this.communicationBrandId = communicationBrandId;
    }

    public int getCatalogId() {
        return catalogId;
    }

    public void setCatalogId(int catalogId) {
        this.catalogId = catalogId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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


    @Override
    public String toString() {
        return "CommListDto{" +
                "companyId=" + companyId +
                ", companyBrandId=" + companyBrandId +
                ", storeId=" + storeId +
                ", province='" + province + '\'' +
                ", city='" + city + '\'' +
                ", district='" + district + '\'' +
                ", flagCampaign=" + flagCampaign +
                ", communicationBrandId=" + communicationBrandId +
                ", catalogId=" + catalogId +
                ", status='" + status + '\'' +
                ", flagChargeSingal=" + flagChargeSingal +
                '}';
    }
}
