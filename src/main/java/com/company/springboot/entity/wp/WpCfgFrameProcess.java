package com.company.springboot.entity.wp;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

@ApiModel(value = "框架流程配置")
public class WpCfgFrameProcess {
    @ApiModelProperty(value = "id", example = "1", required = true)
    private Integer id;

    @ApiModelProperty(value = "创建公司ID", example = "1", required = true)
    private Integer companyId;

    @ApiModelProperty(value = "合作公司ID", example = "1", required = true)
    private Integer partnerCompanyId;

    @ApiModelProperty(value = "框架流程名称", example = "1", required = true)
    private String processName;

    @ApiModelProperty(value = "描述", example = "1", required = true)
    private String description;

    @ApiModelProperty(value = "框架流程编号。同一套框架流程多次编辑时，此编号不变化。", example = "1", required = true)
    private String frameProcessCode;

    @ApiModelProperty(value = "是否生效", example = "1", required = true)
    private Boolean flagAvaliable;

    @ApiModelProperty(value = "是否删除", example = "1", required = true)
    private Boolean flagDeleted;

    @ApiModelProperty(value = "是否已经完成测试", example = "1", required = true)
    private Boolean flagTested;

    @ApiModelProperty(value = "创建人ID", example = "1", required = true)
    private Integer createPerson;

    @ApiModelProperty(value = "创建时间", example = "1", required = true)
    private Date createTime;

    @ApiModelProperty(value = "更新人", example = "1", required = true)
    private Integer updatePerson;

    @ApiModelProperty(value = "更新时间", example = "1", required = true)
    private Date updateTime;

    @ApiModelProperty(value = "生效时间", example = "1", required = true)
    private Date avaliableTime;

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

    public Integer getPartnerCompanyId() {
        return partnerCompanyId;
    }

    public void setPartnerCompanyId(Integer partnerCompanyId) {
        this.partnerCompanyId = partnerCompanyId;
    }

    public String getProcessName() {
        return processName;
    }

    public void setProcessName(String processName) {
        this.processName = processName == null ? null : processName.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public String getFrameProcessCode() {
        return frameProcessCode;
    }

    public void setFrameProcessCode(String frameProcessCode) {
        this.frameProcessCode = frameProcessCode == null ? null : frameProcessCode.trim();
    }

    public Boolean getFlagAvaliable() {
        return flagAvaliable;
    }

    public void setFlagAvaliable(Boolean flagAvaliable) {
        this.flagAvaliable = flagAvaliable;
    }

    public Boolean getFlagDeleted() {
        return flagDeleted;
    }

    public void setFlagDeleted(Boolean flagDeleted) {
        this.flagDeleted = flagDeleted;
    }

    public Boolean getFlagTested() {
        return flagTested;
    }

    public void setFlagTested(Boolean flagTested) {
        this.flagTested = flagTested;
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

    public Date getAvaliableTime() {
        return avaliableTime;
    }

    public void setAvaliableTime(Date avaliableTime) {
        this.avaliableTime = avaliableTime;
    }

    @Override
    public String toString() {
        return "WpCfgFrameProcess{" +
                "id=" + id +
                ", companyId=" + companyId +
                ", partnerCompanyId=" + partnerCompanyId +
                ", processName='" + processName + '\'' +
                ", description='" + description + '\'' +
                ", frameProcessCode='" + frameProcessCode + '\'' +
                ", flagAvaliable=" + flagAvaliable +
                ", flagDeleted=" + flagDeleted +
                ", flagTested=" + flagTested +
                ", createPerson=" + createPerson +
                ", createTime=" + createTime +
                ", updatePerson=" + updatePerson +
                ", updateTime=" + updateTime +
                ", avaliableTime=" + avaliableTime +
                '}';
    }
}