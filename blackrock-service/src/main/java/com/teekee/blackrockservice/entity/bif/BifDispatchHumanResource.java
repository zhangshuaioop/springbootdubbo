package com.teekee.blackrockservice.entity.bif;

import com.teekee.commoncomponets.base.BaseEntity;
import io.swagger.annotations.ApiModel;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @Author Niting
 * @date 2018/11/2
 **/
@ApiModel(value = "人力服务商")
public class BifDispatchHumanResource extends BaseEntity{
    private Integer id;

    private String account;

    private String password;

    private String nickname;

    private String firstName;

    private String lastName;

    private String headPortraitUrl;

    private String sex;

    private String mobile;

    private String defaultNation;

    private String defaultProvice;

    private String defaultCity;

    private String defaultDistrict;

    private Integer dispatchCount;

    private Integer dispatchSuccessfulCount;

    private BigDecimal dispatchAvgFee;

    private BigDecimal dispatchTotalFee;

    private BigDecimal dispatchMaxFee;

    private String idType;

    private String idCode;

    private String belongCompany;

    private String belongCompanyBussinessLicenseCode;

    private String email;

    private String wechat;

    private String qq;

    private Boolean flagProvideInvoice;

    private String provideInvoiceType;

    private BigDecimal provideInvoiceRate;

    private String memo;

    private Boolean flagDeleted;

    private Boolean flagAvailable;

    private Date createTime;

    private Integer createPerson;

    private Date updateTime;

    private Integer updatePerson;

    private Date registerTime;

    private Date validApplyTime;

    private Date validTime;

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

    private BigDecimal userEvaluatePoint;

    private Integer clientAssmAchieveTotalPoint;

    private Integer clientAssmCommunicationTotalPoint;

    private Integer clientAssmTimelyTotalPoint;

    private BigDecimal clientAssmAchieveAvgPoint;

    private BigDecimal clientAssmCommunicationAvgPoint;

    private BigDecimal clientAssmTimelyAvgPoint;

    private BigDecimal contactAssmTotalPoint;

    private Integer contactAssmAvgPoint;

    private String validStatus;

    private Integer page;

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
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

    public String getHeadPortraitUrl() {
        return headPortraitUrl;
    }

    public void setHeadPortraitUrl(String headPortraitUrl) {
        this.headPortraitUrl = headPortraitUrl == null ? null : headPortraitUrl.trim();
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    public String getDefaultNation() {
        return defaultNation;
    }

    public void setDefaultNation(String defaultNation) {
        this.defaultNation = defaultNation == null ? null : defaultNation.trim();
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

    public String getIdType() {
        return idType;
    }

    public void setIdType(String idType) {
        this.idType = idType == null ? null : idType.trim();
    }

    public String getIdCode() {
        return idCode;
    }

    public void setIdCode(String idCode) {
        this.idCode = idCode == null ? null : idCode.trim();
    }

    public String getBelongCompany() {
        return belongCompany;
    }

    public void setBelongCompany(String belongCompany) {
        this.belongCompany = belongCompany == null ? null : belongCompany.trim();
    }

    public String getBelongCompanyBussinessLicenseCode() {
        return belongCompanyBussinessLicenseCode;
    }

    public void setBelongCompanyBussinessLicenseCode(String belongCompanyBussinessLicenseCode) {
        this.belongCompanyBussinessLicenseCode = belongCompanyBussinessLicenseCode == null ? null : belongCompanyBussinessLicenseCode.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getWechat() {
        return wechat;
    }

    public void setWechat(String wechat) {
        this.wechat = wechat == null ? null : wechat.trim();
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq == null ? null : qq.trim();
    }

    public Boolean getFlagProvideInvoice() {
        return flagProvideInvoice;
    }

    public void setFlagProvideInvoice(Boolean flagProvideInvoice) {
        this.flagProvideInvoice = flagProvideInvoice;
    }

    public String getProvideInvoiceType() {
        return provideInvoiceType;
    }

    public void setProvideInvoiceType(String provideInvoiceType) {
        this.provideInvoiceType = provideInvoiceType == null ? null : provideInvoiceType.trim();
    }

    public BigDecimal getProvideInvoiceRate() {
        return provideInvoiceRate;
    }

    public void setProvideInvoiceRate(BigDecimal provideInvoiceRate) {
        this.provideInvoiceRate = provideInvoiceRate;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo == null ? null : memo.trim();
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

    public Date getRegisterTime() {
        return registerTime;
    }

    public void setRegisterTime(Date registerTime) {
        this.registerTime = registerTime;
    }

    public Date getValidApplyTime() {
        return validApplyTime;
    }

    public void setValidApplyTime(Date validApplyTime) {
        this.validApplyTime = validApplyTime;
    }

    public Date getValidTime() {
        return validTime;
    }

    public void setValidTime(Date validTime) {
        this.validTime = validTime;
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

    public BigDecimal getUserEvaluatePoint() {
        return userEvaluatePoint;
    }

    public void setUserEvaluatePoint(BigDecimal userEvaluatePoint) {
        this.userEvaluatePoint = userEvaluatePoint;
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

    public Integer getContactAssmAvgPoint() {
        return contactAssmAvgPoint;
    }

    public void setContactAssmAvgPoint(Integer contactAssmAvgPoint) {
        this.contactAssmAvgPoint = contactAssmAvgPoint;
    }

    public String getValidStatus() {
        return validStatus;
    }

    public void setValidStatus(String validStatus) {
        this.validStatus = validStatus == null ? null : validStatus.trim();
    }
}
