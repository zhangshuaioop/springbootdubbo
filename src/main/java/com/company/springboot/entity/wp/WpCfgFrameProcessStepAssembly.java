package com.company.springboot.entity.wp;

import com.company.springboot.base.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

@ApiModel(value = "框架流程步骤的子流程配置")
public class WpCfgFrameProcessStepAssembly extends BaseEntity {

    @ApiModelProperty(value = "id", example = "1", required = true)
    private Integer id;

    @ApiModelProperty(value = "步骤id", example = "1", required = true)
    private Integer cfgFrameProcessStepId;

    @ApiModelProperty(value = "子流程id", example = "1", required = true)
    private Integer cfgProcessId;

    @ApiModelProperty(value = "子流程版本id", example = "1", required = true)
    private Integer cfgProcessVersionId;

    @ApiModelProperty(value = "是否删除", example = "1", required = true)
    private Boolean flagDeleted;

    @ApiModelProperty(value = "创建时间", example = "1", required = true)
    private Date createTime;

    @ApiModelProperty(value = "创建人", example = "1", required = true)
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

    public Integer getCfgProcessVersionId() {
        return cfgProcessVersionId;
    }

    public void setCfgProcessVersionId(Integer cfgProcessVersionId) {
        this.cfgProcessVersionId = cfgProcessVersionId;
    }

    @Override
    public String toString() {
        return "WpCfgFrameProcessStepAssembly{" +
                "id=" + id +
                ", cfgFrameProcessStepId=" + cfgFrameProcessStepId +
                ", cfgProcessId=" + cfgProcessId +
                ", cfgProcessVersionId=" + cfgProcessVersionId +
                ", flagDeleted=" + flagDeleted +
                ", createTime=" + createTime +
                ", createPerson=" + createPerson +
                '}';
    }
}