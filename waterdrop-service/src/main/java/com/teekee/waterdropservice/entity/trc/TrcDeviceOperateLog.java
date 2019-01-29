package com.teekee.waterdropservice.entity.trc;

import java.util.Date;

public class TrcDeviceOperateLog {
    private Integer id;

    private String opType;

    private String opFromObjType;

    private Integer opFromObjId;

    private String opFromObjName;

    private String opToObjType;

    private Integer opToObjId;

    private String opToObjName;

    private String opDescription;

    private Date createTime;

    private Integer createPerson;

    private Integer deviceId;

    private Integer belongCompanyId;

    public Integer getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(Integer deviceId) {
        this.deviceId = deviceId;
    }

    public Integer getBelongCompanyId() {
        return belongCompanyId;
    }

    public void setBelongCompanyId(Integer belongCompanyId) {
        this.belongCompanyId = belongCompanyId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOpType() {
        return opType;
    }

    public void setOpType(String opType) {
        this.opType = opType == null ? null : opType.trim();
    }

    public String getOpFromObjType() {
        return opFromObjType;
    }

    public void setOpFromObjType(String opFromObjType) {
        this.opFromObjType = opFromObjType == null ? null : opFromObjType.trim();
    }

    public Integer getOpFromObjId() {
        return opFromObjId;
    }

    public void setOpFromObjId(Integer opFromObjId) {
        this.opFromObjId = opFromObjId;
    }

    public String getOpFromObjName() {
        return opFromObjName;
    }

    public void setOpFromObjName(String opFromObjName) {
        this.opFromObjName = opFromObjName == null ? null : opFromObjName.trim();
    }

    public String getOpToObjType() {
        return opToObjType;
    }

    public void setOpToObjType(String opToObjType) {
        this.opToObjType = opToObjType == null ? null : opToObjType.trim();
    }

    public Integer getOpToObjId() {
        return opToObjId;
    }

    public void setOpToObjId(Integer opToObjId) {
        this.opToObjId = opToObjId;
    }

    public String getOpToObjName() {
        return opToObjName;
    }

    public void setOpToObjName(String opToObjName) {
        this.opToObjName = opToObjName == null ? null : opToObjName.trim();
    }

    public String getOpDescription() {
        return opDescription;
    }

    public void setOpDescription(String opDescription) {
        this.opDescription = opDescription == null ? null : opDescription.trim();
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
}