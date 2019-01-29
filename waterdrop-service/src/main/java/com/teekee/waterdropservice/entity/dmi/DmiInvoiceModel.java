package com.teekee.waterdropservice.entity.dmi;

import com.teekee.commoncomponets.base.BaseEntity;

import java.util.Date;

public class DmiInvoiceModel extends BaseEntity {
    private Integer id = 0;

    private String invoiceModelName;

    private String invoiceType;

    private String invoiceTitle;

    private String taxpayerNumber;

    private String invoiceAddress;

    private String bankName;

    private String invoiceAccount;

    private Integer dependenceCompanyId;

    private String deliveryAddress;

    private String contactName;

    private String contactTel;

    private Integer belongObjectId;

    private Boolean flagDeleted;

    private Boolean flagAvailable;

    private String belongObjectType;

    private Date createTime;

    private Integer createPerson;

    private Date updateTime;

    private Integer updatePerson;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getInvoiceModelName() {
        return invoiceModelName;
    }

    public void setInvoiceModelName(String invoiceModelName) {
        this.invoiceModelName = invoiceModelName == null ? null : invoiceModelName.trim();
    }

    public String getInvoiceType() {
        return invoiceType;
    }

    public void setInvoiceType(String invoiceType) {
        this.invoiceType = invoiceType == null ? null : invoiceType.trim();
    }

    public String getInvoiceTitle() {
        return invoiceTitle;
    }

    public void setInvoiceTitle(String invoiceTitle) {
        this.invoiceTitle = invoiceTitle == null ? null : invoiceTitle.trim();
    }

    public String getTaxpayerNumber() {
        return taxpayerNumber;
    }

    public void setTaxpayerNumber(String taxpayerNumber) {
        this.taxpayerNumber = taxpayerNumber == null ? null : taxpayerNumber.trim();
    }

    public String getInvoiceAddress() {
        return invoiceAddress;
    }

    public void setInvoiceAddress(String invoiceAddress) {
        this.invoiceAddress = invoiceAddress == null ? null : invoiceAddress.trim();
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName == null ? null : bankName.trim();
    }

    public Integer getDependenceCompanyId() {
        return dependenceCompanyId;
    }

    public void setDependenceCompanyId(Integer dependenceCompanyId) {
        this.dependenceCompanyId = dependenceCompanyId;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress == null ? null : deliveryAddress.trim();
    }

    public Integer getBelongObjectId() {
        return belongObjectId;
    }

    public void setBelongObjectId(Integer belongObjectId) {
        this.belongObjectId = belongObjectId;
    }

    public String getBelongObjectType() {
        return belongObjectType;
    }

    public void setBelongObjectType(String belongObjectType) {
        this.belongObjectType = belongObjectType == null ? null : belongObjectType.trim();
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


    public String getInvoiceAccount() {
        return invoiceAccount;
    }

    public void setInvoiceAccount(String invoiceAccount) {
        this.invoiceAccount = invoiceAccount == null ? null : invoiceAccount.trim();
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getContactTel() {
        return contactTel;
    }

    public void setContactTel(String contactTel) {
        this.contactTel = contactTel;
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
}