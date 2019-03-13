package com.company.springboot.entity.bif;

import java.math.BigDecimal;
import java.util.Date;

public class BifDispatchHumanResource {
    private Integer id;

    private String account;

    private String password;

    private String nickname;

    private String firstName;

    private String lastName;

    private String headPortraitUrl;

    private String mobile;

    private String defaultProvice;

    private String defaultCity;

    private String defaultDistrict;

    private Integer dispatchCount;

    private Integer dispatchSuccessfulCount;

    private BigDecimal dispatchAvgFee;

    private BigDecimal dispatchTotalFee;

    private BigDecimal dispatchMaxFee;

    private Boolean flagDeleted;

    private Boolean flagAvailable;

    private Date createTime;

    private Integer createPerson;

    private Date updateTime;

    private Integer updatePerson;

    private Date userUpdateTime;

    private Integer userAssessmentCount;

    private Integer contactAssessmentCount;

    private Integer clientAssessmentCount;

    private Integer userAssmAchieveTotalPoint;

    private Integer userAssmCommunicationTotalPoint;

    private Integer userAssmTimelyTotalPoint;

    private BigDecimal userAssmAchieveAvgPoint;

    private BigDecimal userAssmCommunicationAvgPoint;

    private BigDecimal userAssmTimelyAvgPoint;

    private Integer clientAssmAchieveTotalPoint;

    private Integer clientAssmCommunicationTotalPoint;

    private Integer clientAssmTimelyTotalPoint;

    private BigDecimal clientAssmAchieveAvgPoint;

    private BigDecimal clientAssmCommunicationAvgPoint;

    private BigDecimal clientAssmTimelyAvgPoint;

    private BigDecimal contactAssmTotalPoint;

    private String contactAssmAvgPoint;

    private int dispatchOrderId;

    private String defaultNation;

    private String idType;

    private String idCode;

    private String belongCompany;

    private String email;

    private String wechat;

    private String qq;

    private String memo;

    private BigDecimal userEvaluatePoint;

    private String validStatus;

    private String sex;

    private Date validTime;

    /**
     * 标签id
     */
    private String skillLabelIds;

    /**
     * 标签名称
     */
    private String skillLabel;

    /**
     * 自定义标签
     */
    private String customLabel;

    private String areaProvice;

    private String areaCity;

    public String getHeadPortraitUrl() {
        return headPortraitUrl;
    }

    public void setHeadPortraitUrl(String headPortraitUrl) {
        this.headPortraitUrl = headPortraitUrl;
    }

    public Date getValidTime() {
        return validTime;
    }

    public void setValidTime(Date validTime) {
        this.validTime = validTime;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getValidStatus() {
        return validStatus;
    }

    public void setValidStatus(String validStatus) {
        this.validStatus = validStatus;
    }

    public BigDecimal getUserEvaluatePoint() {
        return userEvaluatePoint;
    }

    public void setUserEvaluatePoint(BigDecimal userEvaluatePoint) {
        this.userEvaluatePoint = userEvaluatePoint;
    }

    public String getDefaultNation() {
        return defaultNation;
    }

    public void setDefaultNation(String defaultNation) {
        this.defaultNation = defaultNation;
    }

    public String getIdType() {
        return idType;
    }

    public void setIdType(String idType) {
        this.idType = idType;
    }

    public String getIdCode() {
        return idCode;
    }

    public void setIdCode(String idCode) {
        this.idCode = idCode;
    }

    public String getBelongCompany() {
        return belongCompany;
    }

    public void setBelongCompany(String belongCompany) {
        this.belongCompany = belongCompany;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getWechat() {
        return wechat;
    }

    public void setWechat(String wechat) {
        this.wechat = wechat;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public int getDispatchOrderId() {
        return dispatchOrderId;
    }

    public void setDispatchOrderId(int dispatchOrderId) {
        this.dispatchOrderId = dispatchOrderId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account == null ? null : account.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname == null ? null : nickname.trim();
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName == null ? null : firstName.trim();
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName == null ? null : lastName.trim();
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    public String getDefaultProvice() {
        return defaultProvice;
    }

    public void setDefaultProvice(String defaultProvice) {
        this.defaultProvice = defaultProvice == null ? null : defaultProvice.trim();
    }

    public String getDefaultCity() {
        return defaultCity;
    }

    public void setDefaultCity(String defaultCity) {
        this.defaultCity = defaultCity == null ? null : defaultCity.trim();
    }

    public String getDefaultDistrict() {
        return defaultDistrict;
    }

    public void setDefaultDistrict(String defaultDistrict) {
        this.defaultDistrict = defaultDistrict == null ? null : defaultDistrict.trim();
    }

    public Integer getDispatchCount() {
        return dispatchCount;
    }

    public void setDispatchCount(Integer dispatchCount) {
        this.dispatchCount = dispatchCount;
    }

    public Integer getDispatchSuccessfulCount() {
        return dispatchSuccessfulCount;
    }

    public void setDispatchSuccessfulCount(Integer dispatchSuccessfulCount) {
        this.dispatchSuccessfulCount = dispatchSuccessfulCount;
    }

    public BigDecimal getDispatchAvgFee() {
        return dispatchAvgFee;
    }

    public void setDispatchAvgFee(BigDecimal dispatchAvgFee) {
        this.dispatchAvgFee = dispatchAvgFee;
    }

    public BigDecimal getDispatchTotalFee() {
        return dispatchTotalFee;
    }

    public void setDispatchTotalFee(BigDecimal dispatchTotalFee) {
        this.dispatchTotalFee = dispatchTotalFee;
    }

    public BigDecimal getDispatchMaxFee() {
        return dispatchMaxFee;
    }

    public void setDispatchMaxFee(BigDecimal dispatchMaxFee) {
        this.dispatchMaxFee = dispatchMaxFee;
    }

    public Boolean getFlagDeleted() {
        return flagDeleted;
    }

    public void setFlagDeleted(Boolean flagDeleted) {
        this.flagDeleted = flagDeleted;
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

    public Integer getCreatePerson() {
        return createPerson;
    }

    public void setCreatePerson(Integer createPerson) {
        this.createPerson = createPerson;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getUpdatePerson() {
        return updatePerson;
    }

    public void setUpdatePerson(Integer updatePerson) {
        this.updatePerson = updatePerson;
    }

    public Date getUserUpdateTime() {
        return userUpdateTime;
    }

    public void setUserUpdateTime(Date userUpdateTime) {
        this.userUpdateTime = userUpdateTime;
    }

    public Integer getUserAssessmentCount() {
        return userAssessmentCount;
    }

    public void setUserAssessmentCount(Integer userAssessmentCount) {
        this.userAssessmentCount = userAssessmentCount;
    }

    public Integer getContactAssessmentCount() {
        return contactAssessmentCount;
    }

    public void setContactAssessmentCount(Integer contactAssessmentCount) {
        this.contactAssessmentCount = contactAssessmentCount;
    }

    public Integer getClientAssessmentCount() {
        return clientAssessmentCount;
    }

    public void setClientAssessmentCount(Integer clientAssessmentCount) {
        this.clientAssessmentCount = clientAssessmentCount;
    }

    public Integer getUserAssmAchieveTotalPoint() {
        return userAssmAchieveTotalPoint;
    }

    public void setUserAssmAchieveTotalPoint(Integer userAssmAchieveTotalPoint) {
        this.userAssmAchieveTotalPoint = userAssmAchieveTotalPoint;
    }

    public Integer getUserAssmCommunicationTotalPoint() {
        return userAssmCommunicationTotalPoint;
    }

    public void setUserAssmCommunicationTotalPoint(Integer userAssmCommunicationTotalPoint) {
        this.userAssmCommunicationTotalPoint = userAssmCommunicationTotalPoint;
    }

    public Integer getUserAssmTimelyTotalPoint() {
        return userAssmTimelyTotalPoint;
    }

    public void setUserAssmTimelyTotalPoint(Integer userAssmTimelyTotalPoint) {
        this.userAssmTimelyTotalPoint = userAssmTimelyTotalPoint;
    }

    public BigDecimal getUserAssmAchieveAvgPoint() {
        return userAssmAchieveAvgPoint;
    }

    public void setUserAssmAchieveAvgPoint(BigDecimal userAssmAchieveAvgPoint) {
        this.userAssmAchieveAvgPoint = userAssmAchieveAvgPoint;
    }

    public BigDecimal getUserAssmCommunicationAvgPoint() {
        return userAssmCommunicationAvgPoint;
    }

    public void setUserAssmCommunicationAvgPoint(BigDecimal userAssmCommunicationAvgPoint) {
        this.userAssmCommunicationAvgPoint = userAssmCommunicationAvgPoint;
    }

    public BigDecimal getUserAssmTimelyAvgPoint() {
        return userAssmTimelyAvgPoint;
    }

    public void setUserAssmTimelyAvgPoint(BigDecimal userAssmTimelyAvgPoint) {
        this.userAssmTimelyAvgPoint = userAssmTimelyAvgPoint;
    }

    public Integer getClientAssmAchieveTotalPoint() {
        return clientAssmAchieveTotalPoint;
    }

    public void setClientAssmAchieveTotalPoint(Integer clientAssmAchieveTotalPoint) {
        this.clientAssmAchieveTotalPoint = clientAssmAchieveTotalPoint;
    }

    public Integer getClientAssmCommunicationTotalPoint() {
        return clientAssmCommunicationTotalPoint;
    }

    public void setClientAssmCommunicationTotalPoint(Integer clientAssmCommunicationTotalPoint) {
        this.clientAssmCommunicationTotalPoint = clientAssmCommunicationTotalPoint;
    }

    public Integer getClientAssmTimelyTotalPoint() {
        return clientAssmTimelyTotalPoint;
    }

    public void setClientAssmTimelyTotalPoint(Integer clientAssmTimelyTotalPoint) {
        this.clientAssmTimelyTotalPoint = clientAssmTimelyTotalPoint;
    }

    public BigDecimal getClientAssmAchieveAvgPoint() {
        return clientAssmAchieveAvgPoint;
    }

    public void setClientAssmAchieveAvgPoint(BigDecimal clientAssmAchieveAvgPoint) {
        this.clientAssmAchieveAvgPoint = clientAssmAchieveAvgPoint;
    }

    public BigDecimal getClientAssmCommunicationAvgPoint() {
        return clientAssmCommunicationAvgPoint;
    }

    public void setClientAssmCommunicationAvgPoint(BigDecimal clientAssmCommunicationAvgPoint) {
        this.clientAssmCommunicationAvgPoint = clientAssmCommunicationAvgPoint;
    }

    public BigDecimal getClientAssmTimelyAvgPoint() {
        return clientAssmTimelyAvgPoint;
    }

    public void setClientAssmTimelyAvgPoint(BigDecimal clientAssmTimelyAvgPoint) {
        this.clientAssmTimelyAvgPoint = clientAssmTimelyAvgPoint;
    }

    public BigDecimal getContactAssmTotalPoint() {
        return contactAssmTotalPoint;
    }

    public void setContactAssmTotalPoint(BigDecimal contactAssmTotalPoint) {
        this.contactAssmTotalPoint = contactAssmTotalPoint;
    }

    public String getContactAssmAvgPoint() {
        return contactAssmAvgPoint;
    }

    public void setContactAssmAvgPoint(String contactAssmAvgPoint) {
        this.contactAssmAvgPoint = contactAssmAvgPoint == null ? null : contactAssmAvgPoint.trim();
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


    public String getSkillLabel() {
        return skillLabel;
    }

    public void setSkillLabel(String skillLabel) {
        this.skillLabel = skillLabel;
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