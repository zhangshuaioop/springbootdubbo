package com.company.springboot.entity.wp;

import com.company.springboot.base.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

@ApiModel(value = "框架流程")
public class WpFrameProcess extends BaseEntity {

    @ApiModelProperty(value = "id", example = "1", required = true)
    private Integer id;

    @ApiModelProperty(value = "创建公司ID", example = "1", required = true)
    private Integer frameProcessCfgId;

    @ApiModelProperty(value = "框架流程code", example = "1", required = true)
    private String frameProcessCode;

    @ApiModelProperty(value = "版本id", example = "1", required = true)
    private Integer versionId;

    @ApiModelProperty(value = "是否删除", example = "1", required = true)
    private Boolean flagDeleted;

    @ApiModelProperty(value = "派工方创建人ID", example = "1", required = true)
    private Integer createPerson;

    @ApiModelProperty(value = "采购方创建人ID", example = "1", required = true)
    private Integer purchaseCreatePerson;

    @ApiModelProperty(value = "创建时间", example = "1", required = true)
    private Date createTime;

    @ApiModelProperty(value = "框架流程状态", example = "1", required = true)
    private String frameProcessStatus;

    @ApiModelProperty(value = "当前流程步骤id", example = "1", required = true)
    private Integer currentProcessStepId;

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

    public Integer getCurrentProcessStepId() {
        return currentProcessStepId;
    }

    public void setCurrentProcessStepId(Integer currentProcessStepId) {
        this.currentProcessStepId = currentProcessStepId;
    }

    public Integer getPurchaseCreatePerson() {
        return purchaseCreatePerson;
    }

    public void setPurchaseCreatePerson(Integer purchaseCreatePerson) {
        this.purchaseCreatePerson = purchaseCreatePerson;
    }

    @Override
    public String toString() {
        return "WpFrameProcess{" +
                "id=" + id +
                ", frameProcessCfgId=" + frameProcessCfgId +
                ", frameProcessCode='" + frameProcessCode + '\'' +
                ", versionId=" + versionId +
                ", flagDeleted=" + flagDeleted +
                ", createPerson=" + createPerson +
                ", purchaseCreatePerson=" + purchaseCreatePerson +
                ", createTime=" + createTime +
                ", frameProcessStatus='" + frameProcessStatus + '\'' +
                ", currentProcessStepId=" + currentProcessStepId +
                '}';
    }
}