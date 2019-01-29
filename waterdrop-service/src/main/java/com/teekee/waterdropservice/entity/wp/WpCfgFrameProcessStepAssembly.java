package com.teekee.waterdropservice.entity.wp;

import java.util.Date;

public class WpCfgFrameProcessStepAssembly {
    private Integer id;

    private Integer cfgFrameProcessStepId;

    private Integer cfgProcessId;

    private Boolean flagDeleted;

    private Date createTime;

    private Integer createPerson;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCfgFrameProcessStepId() {
        return cfgFrameProcessStepId;
    }

    public void setCfgFrameProcessStepId(Integer cfgFrameProcessStepId) {
        this.cfgFrameProcessStepId = cfgFrameProcessStepId;
    }

    public Integer getCfgProcessId() {
        return cfgProcessId;
    }

    public void setCfgProcessId(Integer cfgProcessId) {
        this.cfgProcessId = cfgProcessId;
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
}