package com.company.springboot.entity.wp;

import com.company.springboot.base.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

@ApiModel(value = "框架流程步骤配置")
public class WpCfgFrameProcessStep extends BaseEntity {

    @ApiModelProperty(value = "id", example = "1", required = true)
    private Integer id;

    @ApiModelProperty(value = "框架流程ID", example = "1", required = true)
    private Integer cfgFrameProcessId;

    @ApiModelProperty(value = "版本id", example = "1", required = true)
    private Integer versionId;

    @ApiModelProperty(value = "步骤名称", example = "1", required = true)
    private String stepName;

    @ApiModelProperty(value = "编号", example = "1", required = true)
    private String stepCode;

    @ApiModelProperty(value = "描述", example = "1", required = true)
    private String description;
    @ApiModelProperty(value = "流程步骤排序，从1开始", example = "1", required = true)
    private Integer sortId;

    @ApiModelProperty(value = "是否已经完成测试", example = "1", required = true)
    private Integer companyId;

    @ApiModelProperty(value = "是否删除", example = "1", required = true)
    private Boolean flagDeleted;

    @ApiModelProperty(value = "创建人ID", example = "1", required = true)
    private Integer createPerson;

    @ApiModelProperty(value = "创建时间", example = "1", required = true)
    private Date createTime;

    @ApiModelProperty(value = "更新人", example = "1", required = true)
    private Integer updatePerson;

    @ApiModelProperty(value = "更新时间", example = "1", required = true)
    private Date updateTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCfgFrameProcessId() {
        return cfgFrameProcessId;
    }

    public void setCfgFrameProcessId(Integer cfgFrameProcessId) {
        this.cfgFrameProcessId = cfgFrameProcessId;
    }

    public Integer getVersionId() {
        return versionId;
    }

    public void setVersionId(Integer versionId) {
        this.versionId = versionId;
    }

    public String getStepName() {
        return stepName;
    }

    public void setStepName(String stepName) {
        this.stepName = stepName == null ? null : stepName.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public Integer getSortId() {
        return sortId;
    }

    public void setSortId(Integer sortId) {
        this.sortId = sortId;
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
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

    public String getStepCode() {
        return stepCode;
    }

    public void setStepCode(String stepCode) {
        this.stepCode = stepCode;
    }

    @Override
    public String toString() {
        return "WpCfgFrameProcessStep{" +
                "id=" + id +
                ", cfgFrameProcessId=" + cfgFrameProcessId +
                ", versionId=" + versionId +
                ", stepName='" + stepName + '\'' +
                ", description='" + description + '\'' +
                ", sortId=" + sortId +
                ", companyId=" + companyId +
                ", flagDeleted=" + flagDeleted +
                ", createPerson=" + createPerson +
                ", createTime=" + createTime +
                ", updatePerson=" + updatePerson +
                ", updateTime=" + updateTime +
                ", stepCode='" + stepCode + '\'' +
                '}';
    }
}