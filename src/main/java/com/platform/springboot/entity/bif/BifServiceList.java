package com.platform.springboot.entity.bif;

import java.math.BigDecimal;
import java.util.Date;

public class BifServiceList {
    private Integer id;

    private String name;

    private String mobile;

    private String defaultProvice;

    private String defaultCity;

    private boolean register;

    private String validStatus;

    private Boolean flagAvailable;

    private Date createTime;

    private String registerTime;

    private int dispatchCount;

    private BigDecimal userEvaluatePoint;

    /**
     * 标签名称
     */
    private String skillLabel;

    /**
     * 自定义标签名称
     */
    private String customLabel;

    private String areaProvice;

    private String areaCity;

    public String getRegisterTime() {
        return registerTime;
    }

    public void setRegisterTime(String registerTime) {
        this.registerTime = registerTime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getDefaultProvice() {
        return defaultProvice;
    }

    public void setDefaultProvice(String defaultProvice) {
        this.defaultProvice = defaultProvice;
    }

    public String getDefaultCity() {
        return defaultCity;
    }

    public void setDefaultCity(String defaultCity) {
        this.defaultCity = defaultCity;
    }

    public boolean isRegister() {
        return register;
    }

    public void setRegister(boolean register) {
        this.register = register;
    }

    public String getValidStatus() {
        return validStatus;
    }

    public void setValidStatus(String validStatus) {
        this.validStatus = validStatus;
    }

    public Boolean getFlagAvailable() {
        return flagAvailable;
    }

    public void setFlagAvailable(Boolean flagAvailable) {
        this.flagAvailable = flagAvailable;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public int getDispatchCount() {
        return dispatchCount;
    }

    public void setDispatchCount(int dispatchCount) {
        this.dispatchCount = dispatchCount;
    }

    public BigDecimal getUserEvaluatePoint() {
        return userEvaluatePoint;
    }

    public void setUserEvaluatePoint(BigDecimal userEvaluatePoint) {
        this.userEvaluatePoint = userEvaluatePoint;
    }

    public String getSkillLabel() {
        return skillLabel;
    }

    public void setSkillLabel(String skillLabel) {
        this.skillLabel = skillLabel;
    }

    public String getCustomLabel() {
        return customLabel;
    }

    public void setCustomLabel(String customLabel) {
        this.customLabel = customLabel;
    }

    public String getAreaProvice() {
        return areaProvice;
    }

    public void setAreaProvice(String areaProvice) {
        this.areaProvice = areaProvice;
    }

    public String getAreaCity() {
        return areaCity;
    }

    public void setAreaCity(String areaCity) {
        this.areaCity = areaCity;
    }
}
