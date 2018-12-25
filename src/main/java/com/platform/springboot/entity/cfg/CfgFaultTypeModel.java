package com.platform.springboot.entity.cfg;

import com.platform.springboot.base.BaseEntity;
import com.platform.springboot.base.BaseEntity;

import java.util.Date;

public class CfgFaultTypeModel extends BaseEntity {
    private Integer id;

    private String faultDefineType;

    private Integer version;

    private String modelUserType;

    private Integer modelUserObjId;

    private Date createTime;

    private Integer createPerson;

    private String createPersonName;

    public String getCreatePersonName() {
        return createPersonName;
    }

    public void setCreatePersonName(String createPersonName) {
        this.createPersonName = createPersonName;
    }

    public Integer getCreatePerson() {
        return createPerson;
    }

    public void setCreatePerson(Integer createPerson) {
        this.createPerson = createPerson;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFaultDefineType() {
        return faultDefineType;
    }

    public void setFaultDefineType(String faultDefineType) {
        this.faultDefineType = faultDefineType == null ? null : faultDefineType.trim();
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public String getModelUserType() {
        return modelUserType;
    }

    public void setModelUserType(String modelUserType) {
        this.modelUserType = modelUserType == null ? null : modelUserType.trim();
    }

    public Integer getModelUserObjId() {
        return modelUserObjId;
    }

    public void setModelUserObjId(Integer modelUserObjId) {
        this.modelUserObjId = modelUserObjId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}