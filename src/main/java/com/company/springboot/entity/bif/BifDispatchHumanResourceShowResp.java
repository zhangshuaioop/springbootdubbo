package com.company.springboot.entity.bif;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 查看派工人员详情-返回结果
 *
 * @author Wujun
 * @create 2018年02月01日 11:14
 */
public class BifDispatchHumanResourceShowResp {
    private String firstName;

    private String lastName;

    private String mobile;

    private String fullName;

    private String bankName;

    private String account;

    private String alipayAccount;

    private String paymentMethod;

    private boolean flagdefault;

    private Integer id;

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

    private Integer contactAssmTotalPoint;

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

    public String getDefaultDistrict() {
        return defaultDistrict;
    }

    public void setDefaultDistrict(String defaultDistrict) {
        this.defaultDistrict = defaultDistrict;
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

    public Integer getContactAssmTotalPoint() {
        return contactAssmTotalPoint;
    }

    public void setContactAssmTotalPoint(Integer contactAssmTotalPoint) {
        this.contactAssmTotalPoint = contactAssmTotalPoint;
    }

    public String getContactAssmAvgPoint() {
        return contactAssmAvgPoint;
    }

    public void setContactAssmAvgPoint(String contactAssmAvgPoint) {
        this.contactAssmAvgPoint = contactAssmAvgPoint;
    }

    public int getDispatchOrderId() {
        return dispatchOrderId;
    }

    public void setDispatchOrderId(int dispatchOrderId) {
        this.dispatchOrderId = dispatchOrderId;
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public boolean isFlagdefault() {
        return flagdefault;
    }

    public void setFlagdefault(boolean flagdefault) {
        this.flagdefault = flagdefault;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getAlipayAccount() {
        return alipayAccount;
    }

    public void setAlipayAccount(String alipayAccount) {
        this.alipayAccount = alipayAccount;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }
}
