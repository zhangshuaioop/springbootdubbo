package com.platform.springboot.entity.fdp;

import java.util.Date;

public class FdpFaultReportRoute {
    private Integer id;

    private String source;

    private Integer companyId;

    private String routeObject;

    private Integer createPerson;

    private Date createTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source == null ? null : source.trim();
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public String getRouteObject() {
        return routeObject;
    }

    public void setRouteObject(String routeObject) {
        this.routeObject = routeObject == null ? null : routeObject.trim();
    }

    public Integer getCreatePerson() {
        return createPerson;
    }

    public void setCreatePerson(Integer createPerson) {
        this.createPerson = createPerson;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}