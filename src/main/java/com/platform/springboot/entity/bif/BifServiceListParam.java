package com.platform.springboot.entity.bif;

import com.platform.springboot.base.BaseEntity;

import java.util.Date;

/**
 * @author zhanghao
 * @Title: BifServiceListParam
 * @ProjectName BlueOcean
 * @Description: 人力服务商
 * @date 2018/12/28上午11:44
 */
public class BifServiceListParam  extends BaseEntity {

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

    @Override
    public String toString() {
        return "BifServiceListParam{" +
                "serviceName='" + serviceName + '\'' +
                ", mobile='" + mobile + '\'' +
                ", register=" + register +
                ", defaultProvice='" + defaultProvice + '\'' +
                ", defaultCity='" + defaultCity + '\'' +
                ", validStatus='" + validStatus + '\'' +
                ", createTimeStart=" + createTimeStart +
                ", createTimeEnd=" + createTimeEnd +
                ", flagAvailable='" + flagAvailable + '\'' +
                ", skillLabelIds='" + skillLabelIds + '\'' +
                ", customLabel='" + customLabel + '\'' +
                '}';
    }
}
