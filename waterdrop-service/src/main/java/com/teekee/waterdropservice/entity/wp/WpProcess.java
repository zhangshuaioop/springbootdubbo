package com.teekee.waterdropservice.entity.wp;

import java.util.Date;

public class WpProcess {
    private Integer id;

    private Integer frameProcessId;

    private Integer processCfgId;

    private Integer versionId;

    private Boolean flagDeleted;

    private Integer createPerson;

    private Date createTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getFrameProcessId() {
        return frameProcessId;
    }

    public void setFrameProcessId(Integer frameProcessId) {
        this.frameProcessId = frameProcessId;
    }

    public Integer getProcessCfgId() {
        return processCfgId;
    }

    public void setProcessCfgId(Integer processCfgId) {
        this.processCfgId = processCfgId;
    }

    public Integer getVersionId() {
        return versionId;
    }

    public void setVersionId(Integer versionId) {
        this.versionId = versionId;
    }

    public Boolean getFlagDeleted() {
        return flagDeleted;
    }

    public void setFlagDeleted(Boolean flagDeleted) {
        this.flagDeleted = flagDeleted;
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