package com.teekee.waterdropservice.entity.wp;

public class WpCfgProcessStep {
    private Integer id;

    private Integer cfgProcessId;

    private Integer versionId;

    private String stepName;

    private String description;

    private String unitType;

    private String operatorType;

    private Integer operatorId;

    private Integer unitX;

    private Integer unitY;

    private Integer length;

    private Integer height;

    private String executionRules;

    private Integer executionRulesNumber;

    private Integer timeExamMinute;

    private String defaultNoOperatorRule;

    private Boolean flagDeleted;

    private String authorizedFields;

    private String operateType;

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

    public Integer getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(Integer operatorId) {
        this.operatorId = operatorId;
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
}