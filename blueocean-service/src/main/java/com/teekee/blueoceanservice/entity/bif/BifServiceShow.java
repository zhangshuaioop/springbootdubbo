package com.teekee.blueoceanservice.entity.bif;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class BifServiceShow {

    private String firstName;

    private String lastName;

    private String mobile;

    private Date createTime;

    private String wechat;

    private String QQ;

    private String validStatus;

    private boolean register;

    private Boolean flagAvailable;

    private String sex;

    private String email;

    private BigDecimal userEvaluatePoint;

    private String belongCompany;

    private String belongCompanyBussinessLicenseCode;

    private boolean flagProvideInvoice;

    private String provideInvoiceType;

    private String provideInvoiceRate;

    private String idType;

    private String idCode;

    private Date validTime;

    private Date registerTime;

    private String defaultProvice;

    private String defaultCity;

    private String headPortraitUrl;

    public String getHeadPortraitUrl() {
        return headPortraitUrl;
    }

    public void setHeadPortraitUrl(String headPortraitUrl) {
        this.headPortraitUrl = headPortraitUrl;
    }

    public String getDefaultProvice() {
        return defaultProvice;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    private List<BifDispatchHrServiceAreaShow> proviceList;

    private List<BifDispatchHrAccountInfoShow> accountInfoList;

    public Date getRegisterTime() {
        return registerTime;
    }

    public void setRegisterTime(Date registerTime) {
        this.registerTime = registerTime;
    }

    public Date getValidTime() {
        return validTime;
    }

    public void setValidTime(Date validTime) {
        this.validTime = validTime;
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

    public boolean isFlagProvideInvoice() {
        return flagProvideInvoice;
    }

    public void setFlagProvideInvoice(boolean flagProvideInvoice) {
        this.flagProvideInvoice = flagProvideInvoice;
    }

    public String getProvideInvoiceType() {
        return provideInvoiceType;
    }

    public void setProvideInvoiceType(String provideInvoiceType) {
        this.provideInvoiceType = provideInvoiceType;
    }

    public String getProvideInvoiceRate() {
        return provideInvoiceRate;
    }

    public void setProvideInvoiceRate(String provideInvoiceRate) {
        this.provideInvoiceRate = provideInvoiceRate;
    }

    public String getBelongCompany() {
        return belongCompany;
    }

    public void setBelongCompany(String belongCompany) {
        this.belongCompany = belongCompany;
    }

    public String getBelongCompanyBussinessLicenseCode() {
        return belongCompanyBussinessLicenseCode;
    }

    public void setBelongCompanyBussinessLicenseCode(String belongCompanyBussinessLicenseCode) {
        this.belongCompanyBussinessLicenseCode = belongCompanyBussinessLicenseCode;
    }


    public List<BifDispatchHrServiceAreaShow> getProviceList() {
        return proviceList;
    }

    public void setProviceList(List<BifDispatchHrServiceAreaShow> proviceList) {
        this.proviceList = proviceList;
    }

    public List<BifDispatchHrAccountInfoShow> getAccountInfoList() {
        return accountInfoList;
    }

    public void setAccountInfoList(List<BifDispatchHrAccountInfoShow> accountInfoList) {
        this.accountInfoList = accountInfoList;
    }

    public BigDecimal getUserEvaluatePoint() {
        return userEvaluatePoint;
    }

    public void setUserEvaluatePoint(BigDecimal userEvaluatePoint) {
        this.userEvaluatePoint = userEvaluatePoint;
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

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getWechat() {
        return wechat;
    }

    public void setWechat(String wechat) {
        this.wechat = wechat;
    }

    public String getQQ() {
        return QQ;
    }

    public void setQQ(String QQ) {
        this.QQ = QQ;
    }

    public String getValidStatus() {
        return validStatus;
    }

    public void setValidStatus(String validStatus) {
        this.validStatus = validStatus;
    }

    public boolean isRegister() {
        return register;
    }

    public void setRegister(boolean register) {
        this.register = register;
    }

    public Boolean getFlagAvailable() {
        return flagAvailable;
    }

    public void setFlagAvailable(Boolean flagAvailable) {
        this.flagAvailable = flagAvailable;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getEmial() {
        return email;
    }

    public void setEmial(String emial) {
        this.email = emial;
    }

    @Override
    public String toString() {
        return "BifServiceShow{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", mobile='" + mobile + '\'' +
                ", createTime=" + createTime +
                ", wechat='" + wechat + '\'' +
                ", QQ='" + QQ + '\'' +
                ", validStatus='" + validStatus + '\'' +
                ", register=" + register +
                ", flagAvailable=" + flagAvailable +
                ", sex='" + sex + '\'' +
                ", email='" + email + '\'' +
                ", userEvaluatePoint=" + userEvaluatePoint +
                ", belongCompany='" + belongCompany + '\'' +
                ", belongCompanyBussinessLicenseCode='" + belongCompanyBussinessLicenseCode + '\'' +
                ", flagProvideInvoice=" + flagProvideInvoice +
                ", provideInvoiceType='" + provideInvoiceType + '\'' +
                ", provideInvoiceRate='" + provideInvoiceRate + '\'' +
                ", idType='" + idType + '\'' +
                ", idCode='" + idCode + '\'' +
                ", validTime=" + validTime +
                ", registerTime=" + registerTime +
                ", defaultProvice='" + defaultProvice + '\'' +
                ", defaultCity='" + defaultCity + '\'' +
                ", headPortraitUrl='" + headPortraitUrl + '\'' +
                ", proviceList=" + proviceList +
                ", accountInfoList=" + accountInfoList +
                '}';
    }
}
