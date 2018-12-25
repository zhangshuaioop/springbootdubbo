package com.platform.springboot.entity.cfg;

import com.platform.springboot.base.BaseEntity;
import com.platform.springboot.base.BaseEntity;

import java.math.BigDecimal;
import java.util.Date;

public class CfgDispatchModelConfig extends BaseEntity {
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

//    项目模板名称
    private String projectModelName;

    private Integer userId;

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
        this.modelName = modelName == null ? null : modelName.trim();
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
        this.belongObjectType = belongObjectType == null ? null : belongObjectType.trim();
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
        this.equipmentRequest = equipmentRequest == null ? null : equipmentRequest.trim();
    }

    public String getOtherRequest() {
        return otherRequest;
    }

    public void setOtherRequest(String otherRequest) {
        this.otherRequest = otherRequest == null ? null : otherRequest.trim();
    }

    public String getDispatchDescription() {
        return dispatchDescription;
    }

    public void setDispatchDescription(String dispatchDescription) {
        this.dispatchDescription = dispatchDescription == null ? null : dispatchDescription.trim();
    }

    public String getBackupDeviceRequest() {
        return backupDeviceRequest;
    }

    public void setBackupDeviceRequest(String backupDeviceRequest) {
        this.backupDeviceRequest = backupDeviceRequest == null ? null : backupDeviceRequest.trim();
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
        this.dispatchModelRequest = dispatchModelRequest == null ? null : dispatchModelRequest.trim();
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

    public String getProjectModelName() {
        return projectModelName;
    }

    public void setProjectModelName(String projectModelName) {
        this.projectModelName = projectModelName;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}