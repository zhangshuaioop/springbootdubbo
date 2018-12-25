package com.platform.springboot.entity.ret.dmi.DmiCompanyInfo;

import com.platform.springboot.entity.dmi.DmiCommCharge;
import com.platform.springboot.entity.dmi.DmiStoreOverallInfo;
import com.platform.springboot.entity.dmi.DmiCommCharge;
import com.platform.springboot.entity.dmi.DmiStoreOverallInfo;

import java.util.Date;

/**
 * 根据某组条件，查询指定雇主下的通信资源列表
 *
 * @author Wujun
 * @create 2017年09月08日 13:50
 */
public class CommListRet {

    private int id;

    private int storeId;

    private String companyBrandName;

    private String storeName;

    private String province;

    private String commName;

    private String productCode;

    private String commBrandName;

    private String catalogName;

    private String service;

    private String bandWidthUp;

    private String bandWidthDown;

    private String deviceNumber;

    private String loginAccount;

    private String loginPassword;

    private String register;

    private String flagVendor;

    private String memo;

    private DmiCommCharge dmiCommCharge;

    private String campaignName;

    private String description;

    private Date updateTime;

    private Date createTime;

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
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

    public DmiCommCharge getDmiCommCharge() {
        return dmiCommCharge;
    }

    public void setDmiCommCharge(DmiCommCharge dmiCommCharge) {
        this.dmiCommCharge = dmiCommCharge;
    }

    public String getBandWidthUp() {
        return bandWidthUp;
    }

    public void setBandWidthUp(String bandWidthUp) {
        this.bandWidthUp = bandWidthUp;
    }

    public String getBandWidthDown() {
        return bandWidthDown;
    }

    public void setBandWidthDown(String bandWidthDown) {
        this.bandWidthDown = bandWidthDown;
    }

    public String getDeviceNumber() {
        return deviceNumber;
    }

    public void setDeviceNumber(String deviceNumber) {
        this.deviceNumber = deviceNumber;
    }

    public String getLoginAccount() {
        return loginAccount;
    }

    public void setLoginAccount(String loginAccount) {
        this.loginAccount = loginAccount;
    }

    public String getLoginPassword() {
        return loginPassword;
    }

    public void setLoginPassword(String loginPassword) {
        this.loginPassword = loginPassword;
    }

    public String getRegister() {
        return register;
    }

    public void setRegister(String register) {
        this.register = register;
    }

    public String getFlagVendor() {
        return flagVendor;
    }

    public void setFlagVendor(String flagVendor) {
        this.flagVendor = flagVendor;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    private boolean flagCampaign;

    private Date chargeStartDate;

    private DmiStoreOverallInfo dmiStoreOverallInfo;

    public DmiStoreOverallInfo getDmiStoreOverallInfo() {
        return dmiStoreOverallInfo;
    }

    public void setDmiStoreOverallInfo(DmiStoreOverallInfo dmiStoreOverallInfo) {
        this.dmiStoreOverallInfo = dmiStoreOverallInfo;
    }

    public int getStoreId() {
        return storeId;
    }

    public void setStoreId(int storeId) {
        this.storeId = storeId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCompanyBrandName() {
        return companyBrandName;
    }

    public void setCompanyBrandName(String companyBrandName) {
        this.companyBrandName = companyBrandName;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCommName() {
        return commName;
    }

    public void setCommName(String commName) {
        this.commName = commName;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getCommBrandName() {
        return commBrandName;
    }

    public void setCommBrandName(String commBrandName) {
        this.commBrandName = commBrandName;
    }

    public String getCatalogName() {
        return catalogName;
    }

    public void setCatalogName(String catalogName) {
        this.catalogName = catalogName;
    }

    public boolean isFlagCampaign() {
        return flagCampaign;
    }

    public void setFlagCampaign(boolean flagCampaign) {
        this.flagCampaign = flagCampaign;
    }

    public Date getChargeStartDate() {
        return chargeStartDate;
    }

    public void setChargeStartDate(Date chargeStartDate) {
        this.chargeStartDate = chargeStartDate;
    }
}
