package com.platform.springboot.entity.fdp;

import java.util.Date;

/**
 * @Author Niting
 * @date 2018/6/1
 **/
public class GetFaultReportRouteList {
    private Integer companyId;
    private String companyName;
    private String telephone;
    private String contactAddress;
    private boolean flagConfig;
    private String routeObject;
    private String vendorName;
    private Date updateTime;
    private Date createTime;

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getVendorName() {
        return vendorName;
    }

    public void setVendorName(String vendorName) {
        this.vendorName = vendorName;
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getContactAddress() {
        return contactAddress;
    }

    public void setContactAddress(String contactAddress) {
        this.contactAddress = contactAddress;
    }

    public boolean isFlagConfig() {
        return flagConfig;
    }

    public void setFlagConfig(boolean flagConfig) {
        this.flagConfig = flagConfig;
    }

    public String getRouteObject() {
        return routeObject;
    }

    public void setRouteObject(String routeObject) {
        this.routeObject = routeObject;
    }
}
