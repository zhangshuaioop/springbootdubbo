package com.company.springboot.entity.wp;

import java.util.Date;

public class WpCfgFrameProcessVersion {
    private Integer id;

    private Integer version;

    private Integer cfgFrameProcessId;

    private Boolean flagAvaliable;

    private Integer createPerson;

    private Date createTime;

    private Integer updatePerson;

    private Date updateTime;

    private Boolean flagIsLast;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public Integer getCfgFrameProcessId() {
        return cfgFrameProcessId;
    }

    public void setCfgFrameProcessId(Integer cfgFrameProcessId) {
        this.cfgFrameProcessId = cfgFrameProcessId;
    }

    public Boolean getFlagAvaliable() {
        return flagAvaliable;
    }

    public void setFlagAvaliable(Boolean flagAvaliable) {
        this.flagAvaliable = flagAvaliable;
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

    public Boolean getFlagIsLast() {
        return flagIsLast;
    }

    public void setFlagIsLast(Boolean flagIsLast) {
        this.flagIsLast = flagIsLast;
    }
}