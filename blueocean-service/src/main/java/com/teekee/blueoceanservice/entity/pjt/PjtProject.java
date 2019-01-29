package com.teekee.blueoceanservice.entity.pjt;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

@ApiModel(value = "项目信息")
public class PjtProject {
    @ApiModelProperty(value = "id", example = "1", required = true)
    private Integer id;

    @ApiModelProperty(value = "公司id", example = "1", required = true)
    private Integer companyId;

    @ApiModelProperty(value = "项目名称", example = "1", required = true)
    private String projectName;

    @ApiModelProperty(value = "项目编号", example = "1", required = true)
    private String projectCode;

    @ApiModelProperty(value = "是否有效", example = "1", required = true)
    private Boolean flagAvailable;

    @ApiModelProperty(value = "是否删除", example = "1", required = true)
    private Boolean flagDeleted;

    @ApiModelProperty(value = "所属类型：DEMAND，雇主；VENDOR：集成商；", example = "1", required = true)
    private String belongObjectType;

    @ApiModelProperty(value = "所属类型的ID", example = "1", required = true)
    private Integer belongObjectId;

    @ApiModelProperty(value = "创建人", example = "1", required = true)
    private Integer createPerson;

    @ApiModelProperty(value = "创建时间", example = "1", required = true)
    private Date createTime;

    @ApiModelProperty(value = "更新人", example = "1", required = true)
    private Integer updatePerson;

    @ApiModelProperty(value = "更新时间", example = "1", required = true)
    private Date updateTime;

    @ApiModelProperty(value = "默认项目1是0不是", example = "1", required = true)
    private Boolean flagDefault;

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
}