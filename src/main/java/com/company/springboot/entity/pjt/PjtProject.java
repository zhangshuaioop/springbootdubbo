package com.company.springboot.entity.pjt;

import java.util.Date;

public class PjtProject {
    private Integer id;

    private Integer companyId;

    private String projectName;

    private String projectCode;

    private Boolean flagAvailable;

    private Boolean flagDeleted;

    private String belongObjectType;

    private Integer belongObjectId;

    private Integer createPerson;

    private Date createTime;

    private Integer updatePerson;

    private Date updateTime;

    private String createPersonName;

    private Boolean flagDefault;

    public String getCreatePersonName() {
        return createPersonName;
    }

    public void setCreatePersonName(String createPersonName) {
        this.createPersonName = createPersonName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName == null ? null : projectName.trim();
    }

    public String getProjectCode() {
        return projectCode;
    }

    public void setProjectCode(String projectCode) {
        this.projectCode = projectCode == null ? null : projectCode.trim();
    }

    public Boolean getFlagAvailable() {
        return flagAvailable;
    }

    public void setFlagAvailable(Boolean flagAvailable) {
        this.flagAvailable = flagAvailable;
    }

    public Boolean getFlagDeleted() {
        return flagDeleted;
    }

    public void setFlagDeleted(Boolean flagDeleted) {
        this.flagDeleted = flagDeleted;
    }

    public String getBelongObjectType() {
        return belongObjectType;
    }

    public void setBelongObjectType(String belongObjectType) {
        this.belongObjectType = belongObjectType == null ? null : belongObjectType.trim();
    }

    public Integer getBelongObjectId() {
        return belongObjectId;
    }

    public void setBelongObjectId(Integer belongObjectId) {
        this.belongObjectId = belongObjectId;
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

    public Boolean getFlagDefault() {
        return flagDefault;
    }

    public void setFlagDefault(Boolean flagDefault) {
        this.flagDefault = flagDefault;
    }

    @Override
    public String toString() {
        return "PjtProject{" +
                "id=" + id +
                ", companyId=" + companyId +
                ", projectName='" + projectName + '\'' +
                ", projectCode='" + projectCode + '\'' +
                ", flagAvailable=" + flagAvailable +
                ", flagDeleted=" + flagDeleted +
                ", belongObjectType='" + belongObjectType + '\'' +
                ", belongObjectId=" + belongObjectId +
                ", createPerson=" + createPerson +
                ", createTime=" + createTime +
                ", updatePerson=" + updatePerson +
                ", updateTime=" + updateTime +
                ", createPersonName='" + createPersonName + '\'' +
                ", flagDefault=" + flagDefault +
                '}';
    }
}