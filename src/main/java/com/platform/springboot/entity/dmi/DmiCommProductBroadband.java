package com.platform.springboot.entity.dmi;

import java.util.Date;

public class DmiCommProductBroadband {
    private Integer id;

    private Integer storeId;

    private Integer companyId;

    private Integer productId;

    private Integer bandWidthUp;

    private Integer bandWidthDown;

    private String unitBandWidthUp;

    private String unitBandWidthDown;

    private Boolean flagFixedIp;

    private Boolean flagSymmetry;

    private String ipSectionBegin;

    private String ipSectionEnd;

    private String subnetMask;

    private String gateway;

    private String loginAccount;

    private String loginPassword;

    private Boolean flagDeleted;

    private Date createTime;

    private Integer createPerson;

    private Integer updatePerson;

    private Date updateTime;

    private String interconnectAddress;

    public String getInterconnectAddress() {
        return interconnectAddress;
    }

    public void setInterconnectAddress(String interconnectAddress) {
        this.interconnectAddress = interconnectAddress;
    }

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

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getBandWidthUp() {
        return bandWidthUp;
    }

    public void setBandWidthUp(Integer bandWidthUp) {
        this.bandWidthUp = bandWidthUp;
    }

    public Integer getBandWidthDown() {
        return bandWidthDown;
    }

    public void setBandWidthDown(Integer bandWidthDown) {
        this.bandWidthDown = bandWidthDown;
    }

    public String getUnitBandWidthUp() {
        return unitBandWidthUp;
    }

    public void setUnitBandWidthUp(String unitBandWidthUp) {
        this.unitBandWidthUp = unitBandWidthUp == null ? null : unitBandWidthUp.trim();
    }

    public String getUnitBandWidthDown() {
        return unitBandWidthDown;
    }

    public void setUnitBandWidthDown(String unitBandWidthDown) {
        this.unitBandWidthDown = unitBandWidthDown == null ? null : unitBandWidthDown.trim();
    }

    public Boolean getFlagFixedIp() {
        return flagFixedIp;
    }

    public void setFlagFixedIp(Boolean flagFixedIp) {
        this.flagFixedIp = flagFixedIp;
    }

    public Boolean getFlagSymmetry() {
        return flagSymmetry;
    }

    public void setFlagSymmetry(Boolean flagSymmetry) {
        this.flagSymmetry = flagSymmetry;
    }

    public String getIpSectionBegin() {
        return ipSectionBegin;
    }

    public void setIpSectionBegin(String ipSectionBegin) {
        this.ipSectionBegin = ipSectionBegin == null ? null : ipSectionBegin.trim();
    }

    public String getIpSectionEnd() {
        return ipSectionEnd;
    }

    public void setIpSectionEnd(String ipSectionEnd) {
        this.ipSectionEnd = ipSectionEnd == null ? null : ipSectionEnd.trim();
    }

    public String getSubnetMask() {
        return subnetMask;
    }

    public void setSubnetMask(String subnetMask) {
        this.subnetMask = subnetMask == null ? null : subnetMask.trim();
    }

    public String getGateway() {
        return gateway;
    }

    public void setGateway(String gateway) {
        this.gateway = gateway == null ? null : gateway.trim();
    }

    public String getLoginAccount() {
        return loginAccount;
    }

    public void setLoginAccount(String loginAccount) {
        this.loginAccount = loginAccount == null ? null : loginAccount.trim();
    }

    public String getLoginPassword() {
        return loginPassword;
    }

    public void setLoginPassword(String loginPassword) {
        this.loginPassword = loginPassword == null ? null : loginPassword.trim();
    }

    public Boolean getFlagDeleted() {
        return flagDeleted;
    }

    public void setFlagDeleted(Boolean flagDeleted) {
        this.flagDeleted = flagDeleted;
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
}