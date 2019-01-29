package com.teekee.waterdropservice.entity.dmi.ret.dmiCommProductMobile;

/**
 * 查询通信产品移动-返回结果
 *
 * @author Wujun
 * @create 2017年06月05日 11:38
 */
public class MobileShowRet {
    private String puk;
    private String networkType;
    private String useType;
    private Integer capacity;
    private String unitBandWidth;
    private String offLimitsOperator;
    private String useRate;
    private Boolean flagDdd;
    private Boolean flagIdd;

    public String getUnitBandWidth() {
        return unitBandWidth;
    }

    public void setUnitBandWidth(String unitBandWidth) {
        this.unitBandWidth = unitBandWidth;
    }

    public Boolean getFlagDdd() {
        return flagDdd;
    }

    public void setFlagDdd(Boolean flagDdd) {
        this.flagDdd = flagDdd;
    }

    public Boolean getFlagIdd() {
        return flagIdd;
    }

    public void setFlagIdd(Boolean flagIdd) {
        this.flagIdd = flagIdd;
    }

    public String getNetworkType() {
        return networkType;
    }

    public void setNetworkType(String networkType) {
        this.networkType = networkType;
    }

    public String getUseType() {
        return useType;
    }

    public void setUseType(String useType) {
        this.useType = useType;
    }

    public String getOffLimitsOperator() {
        return offLimitsOperator;
    }

    public void setOffLimitsOperator(String offLimitsOperator) {
        this.offLimitsOperator = offLimitsOperator;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public String getUseRate() {
        return useRate;
    }

    public void setUseRate(String useRate) {
        this.useRate = useRate;
    }

    public String getPuk() {
        return puk;
    }

    public void setPuk(String puk) {
        this.puk = puk;
    }
}
