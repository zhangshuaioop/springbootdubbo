package com.teekee.waterdropservice.entity.cfg;

import com.teekee.commoncomponets.base.BaseEntity;

import java.util.Date;

public class CfgDispatchDetailModel extends BaseEntity {
    private Integer id;

    private String dispatchType;

    private Integer version;

    private String modelUserType;

    private Integer modelUserObjId;

    private Date createTime;

    private Integer createPerson;

    private String createPersonName;

    private Integer companyId;

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

    public String getDispatchType() {
        return dispatchType;
    }

    public void setDispatchType(String dispatchType) {
        this.dispatchType = dispatchType == null ? null : dispatchType.trim();
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

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }
}