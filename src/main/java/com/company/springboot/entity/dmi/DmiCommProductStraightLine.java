package com.company.springboot.entity.dmi;

import java.util.Date;

public class DmiCommProductStraightLine {
    private Integer id;

    private Integer storeId;

    private Integer companyId;

    private Integer productId;

    private String zipCode;

    private Boolean flagCid;

    private Boolean flagIpPhone;

    private Boolean flagDdd;

    private Boolean flagIdd;

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

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Boolean getFlagCid() {
        return flagCid;
    }

    public void setFlagCid(Boolean flagCid) {
        this.flagCid = flagCid;
    }

    public Boolean getFlagIpPhone() {
        return flagIpPhone;
    }

    public void setFlagIpPhone(Boolean flagIpPhone) {
        this.flagIpPhone = flagIpPhone;
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

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }
}