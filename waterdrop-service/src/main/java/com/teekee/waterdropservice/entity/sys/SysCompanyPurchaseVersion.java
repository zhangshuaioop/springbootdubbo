package com.teekee.waterdropservice.entity.sys;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

@ApiModel(value = "系统发布版本公司关联表")
public class SysCompanyPurchaseVersion {
    @ApiModelProperty(value = "id", example = "1", required = true)
    private Integer id;

    @ApiModelProperty(value = "公司id", example = "1", required = true)
    private Integer companyId;

    @ApiModelProperty(value = "版本id", example = "1", required = true)
    private Integer versionId;

    @ApiModelProperty(value = "到期时间", example = "1", required = true)
    private Date expireDate;

    @ApiModelProperty(value = "创建时间", example = "1", required = true)
    private Date createTime;

    @ApiModelProperty(value = "创建人", example = "1", required = true)
    private Integer createPerson;

    @ApiModelProperty(value = "更新时间", example = "1", required = true)
    private Date updateTime;

    @ApiModelProperty(value = "更新人id", example = "1", required = true)
    private Integer updatePerson;

    @ApiModelProperty(value = "是否删除", example = "0", required = true)
    private Boolean flagDeleted;

    @ApiModelProperty(value = "版本ids", example = "1,2,3", required = true)
    private String versionIds;

    @ApiModelProperty(value = "用户id", example = "1,2,3", required = true)
    private Integer userId;

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

    public Integer getVersionId() {
        return versionId;
    }

    public void setVersionId(Integer versionId) {
        this.versionId = versionId;
    }

    public Date getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(Date expireDate) {
        this.expireDate = expireDate;
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

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getUpdatePerson() {
        return updatePerson;
    }

    public void setUpdatePerson(Integer updatePerson) {
        this.updatePerson = updatePerson;
    }

    public Boolean getFlagDeleted() {
        return flagDeleted;
    }

    public void setFlagDeleted(Boolean flagDeleted) {
        this.flagDeleted = flagDeleted;
    }

    public String getVersionIds() {
        return versionIds;
    }

    public void setVersionIds(String versionIds) {
        this.versionIds = versionIds;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "SysCompanyPurchaseVersion{" +
                "id=" + id +
                ", companyId=" + companyId +
                ", versionId=" + versionId +
                ", expireDate=" + expireDate +
                ", createTime=" + createTime +
                ", createPerson=" + createPerson +
                ", updateTime=" + updateTime +
                ", updatePerson=" + updatePerson +
                ", flagDeleted=" + flagDeleted +
                ", versionIds='" + versionIds + '\'' +
                ", userId=" + userId +
                '}';
    }
}