package com.company.springboot.entity.dmi;

import java.util.Date;

public class DmiCommProductTrunking {
    private Integer id;

    private Integer storeId;

    private Integer companyId;

    private Integer productId;

    private String zipCode;

    private Boolean flagCid;

    private Integer containLines;

    private Integer numberBegin;

    private Integer numberEnd;

    private String displayNumber;

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

    public Integer getContainLines() {
        return containLines;
    }

    public void setContainLines(Integer containLines) {
        this.containLines = containLines;
    }

    public Integer getNumberBegin() {
        return numberBegin;
    }

    public void setNumberBegin(Integer numberBegin) {
        this.numberBegin = numberBegin;
    }

    public Integer getNumberEnd() {
        return numberEnd;
    }

    public void setNumberEnd(Integer numberEnd) {
        this.numberEnd = numberEnd;
    }

    public String getDisplayNumber() {
        return displayNumber;
    }

    public void setDisplayNumber(String displayNumber) {
        this.displayNumber = displayNumber == null ? null : displayNumber.trim();
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