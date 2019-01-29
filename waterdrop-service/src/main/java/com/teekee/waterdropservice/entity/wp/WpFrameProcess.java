package com.teekee.waterdropservice.entity.wp;

import java.util.Date;

public class WpFrameProcess {
    private Integer id;

    private Integer frameProcessCfgId;

    private String frameProcessCode;

    private Integer versionId;

    private Boolean flagDeleted;

    private Integer createPerson;

    private Date createTime;

    private String frameProcessStatus;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getFrameProcessCfgId() {
        return frameProcessCfgId;
    }

    public void setFrameProcessCfgId(Integer frameProcessCfgId) {
        this.frameProcessCfgId = frameProcessCfgId;
    }

    public String getFrameProcessCode() {
        return frameProcessCode;
    }

    public void setFrameProcessCode(String frameProcessCode) {
        this.frameProcessCode = frameProcessCode == null ? null : frameProcessCode.trim();
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

    public String getFrameProcessStatus() {
        return frameProcessStatus;
    }

    public void setFrameProcessStatus(String frameProcessStatus) {
        this.frameProcessStatus = frameProcessStatus == null ? null : frameProcessStatus.trim();
    }
}