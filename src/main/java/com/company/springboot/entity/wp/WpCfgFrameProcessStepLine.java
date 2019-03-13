package com.company.springboot.entity.wp;

import com.company.springboot.base.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "框架流程步骤间的连接线")
public class WpCfgFrameProcessStepLine extends BaseEntity {

    @ApiModelProperty(value = "id", example = "1", required = true)
    private Integer id;

    @ApiModelProperty(value = "框架框架流程ID", example = "1", required = true)
    private Integer cfgFrameProcessId;

    @ApiModelProperty(value = "版本ID", example = "1", required = true)
    private Integer versionId;

    @ApiModelProperty(value = "出发点步骤Code", example = "1", required = true)
    private String startStepCode;

    @ApiModelProperty(value = "到达点步骤Code", example = "1", required = true)
    private String endStepCode;

    @ApiModelProperty(value = "描述", example = "1", required = true)
    private String description;

    @ApiModelProperty(value = "控件类型，STRAIGHT：直线，CURVE：曲线，BROKEN：折线", example = "1", required = true)
    private String unitType;

    @ApiModelProperty(value = "出发点X轴坐标", example = "1", required = true)
    private Integer startX;

    @ApiModelProperty(value = "出发点Y轴坐标", example = "1", required = true)
    private Integer startY;

    @ApiModelProperty(value = "到达点X轴坐标", example = "1", required = true)
    private Integer endX;

    @ApiModelProperty(value = "到达点Y轴坐标", example = "1", required = true)
    private Integer endY;

    @ApiModelProperty(value = "执行规则类型，暂未定义", example = "1", required = true)
    private String executionRules;

    @ApiModelProperty(value = "执行规则类型的数据", example = "1", required = true)
    private Integer executionRulesNumber;

    @ApiModelProperty(value = "是否删除", example = "1", required = true)
    private Boolean flagDeleted;

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

    public String getStartStepCode() {
        return startStepCode;
    }

    public void setStartStepCode(String startStepCode) {
        this.startStepCode = startStepCode;
    }

    public String getEndStepCode() {
        return endStepCode;
    }

    public void setEndStepCode(String endStepCode) {
        this.endStepCode = endStepCode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public String getUnitType() {
        return unitType;
    }

    public void setUnitType(String unitType) {
        this.unitType = unitType == null ? null : unitType.trim();
    }

    public Integer getStartX() {
        return startX;
    }

    public void setStartX(Integer startX) {
        this.startX = startX;
    }

    public Integer getStartY() {
        return startY;
    }

    public void setStartY(Integer startY) {
        this.startY = startY;
    }

    public Integer getEndX() {
        return endX;
    }

    public void setEndX(Integer endX) {
        this.endX = endX;
    }

    public Integer getEndY() {
        return endY;
    }

    public void setEndY(Integer endY) {
        this.endY = endY;
    }

    public String getExecutionRules() {
        return executionRules;
    }

    public void setExecutionRules(String executionRules) {
        this.executionRules = executionRules == null ? null : executionRules.trim();
    }

    public Integer getExecutionRulesNumber() {
        return executionRulesNumber;
    }

    public void setExecutionRulesNumber(Integer executionRulesNumber) {
        this.executionRulesNumber = executionRulesNumber;
    }

    public Boolean getFlagDeleted() {
        return flagDeleted;
    }

    public void setFlagDeleted(Boolean flagDeleted) {
        this.flagDeleted = flagDeleted;
    }

    @Override
    public String toString() {
        return "WpCfgFrameProcessStepLine{" +
                "id=" + id +
                ", cfgFrameProcessId=" + cfgFrameProcessId +
                ", versionId=" + versionId +
                ", startStepCode='" + startStepCode + '\'' +
                ", endStepCode='" + endStepCode + '\'' +
                ", description='" + description + '\'' +
                ", unitType='" + unitType + '\'' +
                ", startX=" + startX +
                ", startY=" + startY +
                ", endX=" + endX +
                ", endY=" + endY +
                ", executionRules='" + executionRules + '\'' +
                ", executionRulesNumber=" + executionRulesNumber +
                ", flagDeleted=" + flagDeleted +
                '}';
    }
}