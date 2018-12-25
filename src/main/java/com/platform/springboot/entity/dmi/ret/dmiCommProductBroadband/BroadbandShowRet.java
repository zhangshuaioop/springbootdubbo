package com.platform.springboot.entity.dmi.ret.dmiCommProductBroadband;

/**
 * 查询通信产品宽带-返回结果
 *
 * @author Wujun
 * @create 2017年06月05日 10:33
 */
public class BroadbandShowRet {
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
    private String interconnectAddress;

    public String getInterconnectAddress() {
        return interconnectAddress;
    }

    public void setInterconnectAddress(String interconnectAddress) {
        this.interconnectAddress = interconnectAddress;
    }

    public String getUnitBandWidthUp() {
        return unitBandWidthUp;
    }

    public void setUnitBandWidthUp(String unitBandWidthUp) {
        this.unitBandWidthUp = unitBandWidthUp;
    }

    public String getUnitBandWidthDown() {
        return unitBandWidthDown;
    }

    public void setUnitBandWidthDown(String unitBandWidthDown) {
        this.unitBandWidthDown = unitBandWidthDown;
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
        this.ipSectionBegin = ipSectionBegin;
    }

    public String getIpSectionEnd() {
        return ipSectionEnd;
    }

    public void setIpSectionEnd(String ipSectionEnd) {
        this.ipSectionEnd = ipSectionEnd;
    }

    public String getSubnetMask() {
        return subnetMask;
    }

    public void setSubnetMask(String subnetMask) {
        this.subnetMask = subnetMask;
    }

    public String getGateway() {
        return gateway;
    }

    public void setGateway(String gateway) {
        this.gateway = gateway;
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
}
