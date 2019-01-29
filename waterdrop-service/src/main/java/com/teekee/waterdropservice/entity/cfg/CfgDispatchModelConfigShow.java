package com.teekee.waterdropservice.entity.cfg;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @Author Niting
 * @date 2018/10/8
 **/
public class CfgDispatchModelConfigShow {
    private Integer id;

    private Integer companyId;

    private Integer projectId;

    private String modelName;

    private Integer dispatchModelId;

    private String belongObjectType;

    private Integer belongObjectId;

    private String equipmentRequest;

    private String otherRequest;

    private String dispatchDescription;

    private String backupDeviceRequest;

    private BigDecimal suggestPrice;

    private String suggestUnit;

    private Boolean flagFixedPrice;

    private Boolean flagDeleted;

    private Boolean flagAvaliable;

    private Integer createPerson;

    private Date createTime;

    private Integer updatePerson;

    private Date updateTime;

    private String dispatchModelRequest;

    private String companyName;

    private String projectName;

    private String uploadFileName;

    private String uploadFileUrl;
    /**
     * 是否自动提交完工
     */
    private boolean flagAutoCommit;
    /**
     * 完工资料模板URL
     */
    private String completeProfileTemplateUrl;
    /**
     * 完工资料模板名称
     */
    private String completeProfileTemplateName;

    public String getUploadFileName() {
        return uploadFileName;
    }

    public void setUploadFileName(String uploadFileName) {
        this.uploadFileName = uploadFileName;
    }

    public String getUploadFileUrl() {
        return uploadFileUrl;
    }

    public void setUploadFileUrl(String uploadFileUrl) {
        this.uploadFileUrl = uploadFileUrl;
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

    public Integer getProjectId() {
        return projectId;
    }

    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public Integer getDispatchModelId() {
        return dispatchModelId;
    }

    public void setDispatchModelId(Integer dispatchModelId) {
        this.dispatchModelId = dispatchModelId;
    }

    public String getBelongObjectType() {
        return belongObjectType;
    }

    public void setBelongObjectType(String belongObjectType) {
        this.belongObjectType = belongObjectType;
    }

    public Integer getBelongObjectId() {
        return belongObjectId;
    }

    public void setBelongObjectId(Integer belongObjectId) {
        this.belongObjectId = belongObjectId;
    }

    public String getEquipmentRequest() {
        return equipmentRequest;
    }

    public void setEquipmentRequest(String equipmentRequest) {
        this.equipmentRequest = equipmentRequest;
    }

    public String getOtherRequest() {
        return otherRequest;
    }

    public void setOtherRequest(String otherRequest) {
        this.otherRequest = otherRequest;
    }

    public String getDispatchDescription() {
        return dispatchDescription;
    }

    public void setDispatchDescription(String dispatchDescription) {
        this.dispatchDescription = dispatchDescription;
    }

    public String getBackupDeviceRequest() {
        return backupDeviceRequest;
    }

    public void setBackupDeviceRequest(String backupDeviceRequest) {
        this.backupDeviceRequest = backupDeviceRequest;
    }

    public BigDecimal getSuggestPrice() {
        return suggestPrice;
    }

    public void setSuggestPrice(BigDecimal suggestPrice) {
        this.suggestPrice = suggestPrice;
    }

    public String getSuggestUnit() {
        return suggestUnit;
    }

    public void setSuggestUnit(String suggestUnit) {
        this.suggestUnit = suggestUnit;
    }

    public Boolean getFlagFixedPrice() {
        return flagFixedPrice;
    }

    public void setFlagFixedPrice(Boolean flagFixedPrice) {
        this.flagFixedPrice = flagFixedPrice;
    }

    public Boolean getFlagDeleted() {
        return flagDeleted;
    }

    public void setFlagDeleted(Boolean flagDeleted) {
        this.flagDeleted = flagDeleted;
    }

    public Boolean getFlagAvaliable() {
        return flagAvaliable;
    }

    public void setFlagAvaliable(Boolean flagAvaliable) {
        this.flagAvaliable = flagAvaliable;
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

    public String getDispatchModelRequest() {
        return dispatchModelRequest;
    }

    public void setDispatchModelRequest(String dispatchModelRequest) {
        this.dispatchModelRequest = dispatchModelRequest;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public boolean isFlagAutoCommit() {
        return flagAutoCommit;
    }

    public void setFlagAutoCommit(boolean flagAutoCommit) {
        this.flagAutoCommit = flagAutoCommit;
    }

    public String getCompleteProfileTemplateUrl() {
        return completeProfileTemplateUrl;
    }

    public void setCompleteProfileTemplateUrl(String completeProfileTemplateUrl) {
        this.completeProfileTemplateUrl = completeProfileTemplateUrl;
    }

    public String getCompleteProfileTemplateName() {
        return completeProfileTemplateName;
    }

    public void setCompleteProfileTemplateName(String completeProfileTemplateName) {
        this.completeProfileTemplateName = completeProfileTemplateName;
    }
}
