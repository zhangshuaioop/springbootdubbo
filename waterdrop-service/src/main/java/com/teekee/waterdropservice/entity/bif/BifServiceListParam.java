package com.teekee.waterdropservice.entity.bif;

import com.teekee.commoncomponets.base.BaseEntity;

import java.util.Date;

public class BifServiceListParam extends BaseEntity {

    private String serviceName;
    private String mobile;
    private Integer register;
    private String defaultProvice;
    private String defaultCity;
    private String validStatus;
    private Date createTimeStart;
    private Date createTimeEnd;
    private String flagAvailable;

    /**
     * 标签id
     */
    private String skillLabelIds;

    /**
     * 自定义标签名称
     */
    private String customLabel;


    public Date getCreateTimeStart() {
        return createTimeStart;
    }

    public void setCreateTimeStart(Date createTimeStart) {
        this.createTimeStart = createTimeStart;
    }

    public Date getCreateTimeEnd() {
        return createTimeEnd;
    }

    public void setCreateTimeEnd(Date createTimeEnd) {
        this.createTimeEnd = createTimeEnd;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public Integer getRegister() {
        return register;
    }

    public void setRegister(Integer register) {
        this.register = register;
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

    public String getValidStatus() {
        return validStatus;
    }

    public void setValidStatus(String validStatus) {
        this.validStatus = validStatus;
    }

    public String getFlagAvailable() {
        return flagAvailable;
    }

    public void setFlagAvailable(String flagAvailable) {
        this.flagAvailable = flagAvailable;
    }

    public String getSkillLabelIds() {
        return skillLabelIds;
    }

    public void setSkillLabelIds(String skillLabelIds) {
        this.skillLabelIds = skillLabelIds;
    }

    public String getCustomLabel() {
        return customLabel;
    }

    public void setCustomLabel(String customLabel) {
        this.customLabel = customLabel;
    }
}
