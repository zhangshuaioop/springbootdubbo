package com.company.springboot.entity.wp;

import com.company.springboot.base.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

@ApiModel(value = "流程配置")
public class WpCfgProcess extends BaseEntity {
    @ApiModelProperty(value = "id", example = "1", required = true)
    private Integer id;

    @ApiModelProperty(value = "创建公司ID", example = "1", required = true)
    private Integer companyId;

    @ApiModelProperty(value = "流程名称", example = "1", required = true)
    private String processName;

    @ApiModelProperty(value = "描述", example = "1", required = true)
    private String description;

    @ApiModelProperty(value = "框架流程编号。同一套框架流程多次编辑时，此编号不变化。", example = "1", required = true)
    private String processCode;

    @ApiModelProperty(value = "是否生效", example = "1", required = true)
    private Boolean flagAvaliable;

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

    @ApiModelProperty(value = "生效时间", example = "1", required = true)
    private Date avaliableTime;

    @ApiModelProperty(value = "配置版本Id", example = "1", required = true)
    private Integer versionId;

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

    public String getProcessCode() {
        return processCode;
    }

    public void setProcessCode(String processCode) {
        this.processCode = processCode == null ? null : processCode.trim();
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

    public Integer getVersionId() {
        return versionId;
    }

    public void setVersionId(Integer versionId) {
        this.versionId = versionId;
    }

    @Override
    public String toString() {
        return "WpCfgProcess{" +
                "id=" + id +
                ", companyId=" + companyId +
                ", processName='" + processName + '\'' +
                ", description='" + description + '\'' +
                ", processCode='" + processCode + '\'' +
                ", flagAvaliable=" + flagAvaliable +
                ", flagDeleted=" + flagDeleted +
                ", createPerson=" + createPerson +
                ", createTime=" + createTime +
                ", updatePerson=" + updatePerson +
                ", updateTime=" + updateTime +
                ", avaliableTime=" + avaliableTime +
                ", versionId=" + versionId +
                '}';
    }
}