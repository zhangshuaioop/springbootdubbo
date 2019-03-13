package com.company.springboot.entity.wp;

import com.company.springboot.base.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "流程步骤配置")
public class WpCfgProcessStep extends BaseEntity {

    @ApiModelProperty(value = "id", example = "1", required = true)
    private Integer id;

    @ApiModelProperty(value = "框架流程ID", example = "1", required = true)
    private Integer cfgProcessId;

    @ApiModelProperty(value = "版本ID", example = "1", required = true)
    private Integer versionId;

    @ApiModelProperty(value = "步骤名称", example = "1", required = true)
    private String stepName;

    @ApiModelProperty(value = "描述", example = "1", required = true)
    private String description;

    @ApiModelProperty(value = "控件类型，START：开始，END：结束，INPUT：录入，APPROVAL：审批，COPYTO：抄送，GATHER：集合点", example = "1", required = true)
    private String unitType;

    @ApiModelProperty(value = "操作人员类型，SELF：本人，PERSON：某人，ORGANIZATION：部门，ROLE：角色", example = "1", required = true)
    private String operatorType;

    @ApiModelProperty(value = "操作者id，本人：id=0，组织&角色：对应组织&角色的id", example = "1", required = true)
    private String operatorId;

    @ApiModelProperty(value = "X轴坐标", example = "1", required = true)
    private Integer unitX;

    @ApiModelProperty(value = "Y轴坐标", example = "1", required = true)
    private Integer unitY;

    @ApiModelProperty(value = "控件长度", example = "1", required = true)
    private Integer length;

    @ApiModelProperty(value = "控件高度", example = "1", required = true)
    private Integer height;

    @ApiModelProperty(value = "执行规则类型，PERCENT：按百分比，NUMBER：按人数", example = "1", required = true)
    private String executionRules;

    @ApiModelProperty(value = "执行规则类型的数据", example = "1", required = true)
    private Integer executionRulesNumber;

    @ApiModelProperty(value = "审批限时分钟数", example = "1", required = true)
    private Integer timeExamMinute;

    @ApiModelProperty(value = "默认无审批人时规则，MANAGER：默认管理员，NEXTSTEP：直接下一步", example = "1", required = true)
    private String defaultNoOperatorRule;

    @ApiModelProperty(value = "是否删除", example = "1", required = true)
    private Boolean flagDeleted;

    @ApiModelProperty(value = "被授权字段，在完成完全体之前，用于判断", example = "1", required = true)
    private String authorizedFields;

    @ApiModelProperty(value = "操作类型，DEFAULT：默认，NEW：", example = "1", required = true)
    private String operateType;

    @ApiModelProperty(value = "步骤code", example = "1", required = true)
    private String stepCode;

    @ApiModelProperty(value = "框架流程的id", example = "1", required = true)
    private Integer cfgFrameProcessId;

    @ApiModelProperty(value = "框架流程的code", example = "1", required = true)
    private String frameStepCode;

    @ApiModelProperty(value = "框架流程的版本", example = "1", required = true)
    private Integer frameVersionId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCfgProcessId() {
        return cfgProcessId;
    }

    public void setCfgProcessId(Integer cfgProcessId) {
        this.cfgProcessId = cfgProcessId;
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

    public String getUnitType() {
        return unitType;
    }

    public void setUnitType(String unitType) {
        this.unitType = unitType == null ? null : unitType.trim();
    }

    public String getOperatorType() {
        return operatorType;
    }

    public void setOperatorType(String operatorType) {
        this.operatorType = operatorType == null ? null : operatorType.trim();
    }

    public Integer getUnitX() {
        return unitX;
    }

    public void setUnitX(Integer unitX) {
        this.unitX = unitX;
    }

    public Integer getUnitY() {
        return unitY;
    }

    public void setUnitY(Integer unitY) {
        this.unitY = unitY;
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
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

    public Integer getTimeExamMinute() {
        return timeExamMinute;
    }

    public void setTimeExamMinute(Integer timeExamMinute) {
        this.timeExamMinute = timeExamMinute;
    }

    public String getDefaultNoOperatorRule() {
        return defaultNoOperatorRule;
    }

    public void setDefaultNoOperatorRule(String defaultNoOperatorRule) {
        this.defaultNoOperatorRule = defaultNoOperatorRule == null ? null : defaultNoOperatorRule.trim();
    }

    public Boolean getFlagDeleted() {
        return flagDeleted;
    }

    public void setFlagDeleted(Boolean flagDeleted) {
        this.flagDeleted = flagDeleted;
    }

    public String getAuthorizedFields() {
        return authorizedFields;
    }

    public void setAuthorizedFields(String authorizedFields) {
        this.authorizedFields = authorizedFields == null ? null : authorizedFields.trim();
    }

    public String getOperateType() {
        return operateType;
    }

    public void setOperateType(String operateType) {
        this.operateType = operateType == null ? null : operateType.trim();
    }

    public String getStepCode() {
        return stepCode;
    }

    public void setStepCode(String stepCode) {
        this.stepCode = stepCode;
    }

    public String getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(String operatorId) {
        this.operatorId = operatorId;
    }

    public Integer getCfgFrameProcessId() {
        return cfgFrameProcessId;
    }

    public void setCfgFrameProcessId(Integer cfgFrameProcessId) {
        this.cfgFrameProcessId = cfgFrameProcessId;
    }

    public String getFrameStepCode() {
        return frameStepCode;
    }

    public void setFrameStepCode(String frameStepCode) {
        this.frameStepCode = frameStepCode;
    }

    public Integer getFrameVersionId() {
        return frameVersionId;
    }

    public void setFrameVersionId(Integer frameVersionId) {
        this.frameVersionId = frameVersionId;
    }

    @Override
    public String toString() {
        return "WpCfgProcessStep{" +
                "id=" + id +
                ", cfgProcessId=" + cfgProcessId +
                ", versionId=" + versionId +
                ", stepName='" + stepName + '\'' +
                ", description='" + description + '\'' +
                ", unitType='" + unitType + '\'' +
                ", operatorType='" + operatorType + '\'' +
                ", operatorId='" + operatorId + '\'' +
                ", unitX=" + unitX +
                ", unitY=" + unitY +
                ", length=" + length +
                ", height=" + height +
                ", executionRules='" + executionRules + '\'' +
                ", executionRulesNumber=" + executionRulesNumber +
                ", timeExamMinute=" + timeExamMinute +
                ", defaultNoOperatorRule='" + defaultNoOperatorRule + '\'' +
                ", flagDeleted=" + flagDeleted +
                ", authorizedFields='" + authorizedFields + '\'' +
                ", operateType='" + operateType + '\'' +
                ", stepCode='" + stepCode + '\'' +
                ", cfgFrameProcessId=" + cfgFrameProcessId +
                ", frameStepCode='" + frameStepCode + '\'' +
                ", frameVersionId=" + frameVersionId +
                '}';
    }
}