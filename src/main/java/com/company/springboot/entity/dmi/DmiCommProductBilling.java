package com.company.springboot.entity.dmi;

import java.util.Date;

public class DmiCommProductBilling {
    private Integer id;

    private Integer storeId;

    private Integer companyId;

    private Boolean flagProductBill;

    private Integer objectId;

    private String contact;

    private String address;

    private String email;

    private String failureDealPerson;

    private String failureDealTel;

    private Boolean flagDeleted;

    private Date createTime;

    private Integer createPerson;

    private Integer updatePerson;

    private Date updateTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getStoreId() {
        return storeId;
    }

    public void setStoreId(Integer storeId) {
        this.storeId = storeId;
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public Boolean getFlagProductBill() {
        return flagProductBill;
    }

    public void setFlagProductBill(Boolean flagProductBill) {
        this.flagProductBill = flagProductBill;
    }

    public Integer getObjectId() {
        return objectId;
    }

    public void setObjectId(Integer objectId) {
        this.objectId = objectId;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact == null ? null : contact.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getFailureDealPerson() {
        return failureDealPerson;
    }

    public void setFailureDealPerson(String failureDealPerson) {
        this.failureDealPerson = failureDealPerson == null ? null : failureDealPerson.trim();
    }

    public String getFailureDealTel() {
        return failureDealTel;
    }

    public void setFailureDealTel(String failureDealTel) {
        this.failureDealTel = failureDealTel == null ? null : failureDealTel.trim();
    }

    public Boolean getFlagDeleted() {
        return flagDeleted;
    }

    public void setFlagDeleted(Boolean flagDeleted) {
        this.flagDeleted = flagDeleted;
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

    public Integer getUpdatePerson() {
        return updatePerson;
    }

    public void setUpdatePerson(Integer updatePerson) {
        this.updatePerson = updatePerson;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}