package com.company.springboot.entity.fdp;

import java.util.Date;

public class FdpFaultOrderRelatedCommProduct {
    private Integer id;

    private Integer faultOrderProcessId;

    private Integer faultReportId;

    private Integer storeCommProductId;

    private Integer commCatalogId;

    private Integer storeId;

    private Boolean flagDeleted;

    private Date updateTime;

    private Integer updatePerson;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getFaultOrderProcessId() {
        return faultOrderProcessId;
    }

    public void setFaultOrderProcessId(Integer faultOrderProcessId) {
        this.faultOrderProcessId = faultOrderProcessId;
    }

    public Integer getFaultReportId() {
        return faultReportId;
    }

    public void setFaultReportId(Integer faultReportId) {
        this.faultReportId = faultReportId;
    }

    public Integer getStoreCommProductId() {
        return storeCommProductId;
    }

    public void setStoreCommProductId(Integer storeCommProductId) {
        this.storeCommProductId = storeCommProductId;
    }

    public Integer getCommCatalogId() {
        return commCatalogId;
    }

    public void setCommCatalogId(Integer commCatalogId) {
        this.commCatalogId = commCatalogId;
    }

    public Integer getStoreId() {
        return storeId;
    }

    public void setStoreId(Integer storeId) {
        this.storeId = storeId;
    }

    public Boolean getFlagDeleted() {
        return flagDeleted;
    }

    public void setFlagDeleted(Boolean flagDeleted) {
        this.flagDeleted = flagDeleted;
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
}