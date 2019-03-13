package com.company.springboot.entity.wp;

import com.company.springboot.base.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

@ApiModel(value = "框架流程配置的版本管理")
public class WpCfgFrameProcessVersion extends BaseEntity {
    @ApiModelProperty(value = "id", example = "1", required = true)
    private Integer id;

    @ApiModelProperty(value = "版本号", example = "1", required = true)
    private Integer version;

    @ApiModelProperty(value = "框架流程配置编号", example = "1", required = true)
    private Integer cfgFrameProcessId;

    @ApiModelProperty(value = "是否生效", example = "1", required = true)
    private Boolean flagAvaliable;

    @ApiModelProperty(value = "创建人ID", example = "1", required = true)
    private Integer createPerson;

    @ApiModelProperty(value = "创建时间", example = "1", required = true)
    private Date createTime;

    @ApiModelProperty(value = "更新人", example = "1", required = true)
    private Integer updatePerson;

    @ApiModelProperty(value = "更新时间", example = "1", required = true)
    private Date updateTime;

    @ApiModelProperty(value = "是否是最新版本", example = "1", required = true)
    private Boolean flagIsLast;

    @ApiModelProperty(value = "公司侧点激活的人员ID", example = "1", required = true)
    private Integer companyUserId;

    @ApiModelProperty(value = "公司侧激活时间", example = "1", required = true)
    private Date companyActiveTime;

    @ApiModelProperty(value = "合作公司侧点激活的人员ID", example = "1", required = true)
    private Integer partnerCompanyUserId;

    @ApiModelProperty(value = "合作公司侧激活的时间", example = "1", required = true)
    private Date partnerCompanyActiveTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public Integer getCfgFrameProcessId() {
        return cfgFrameProcessId;
    }

    public void setCfgFrameProcessId(Integer cfgFrameProcessId) {
        this.cfgFrameProcessId = cfgFrameProcessId;
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

    public Boolean getFlagIsLast() {
        return flagIsLast;
    }

    public void setFlagIsLast(Boolean flagIsLast) {
        this.flagIsLast = flagIsLast;
    }

    public Integer getCompanyUserId() {
        return companyUserId;
    }

    public void setCompanyUserId(Integer companyUserId) {
        this.companyUserId = companyUserId;
    }

    public Date getCompanyActiveTime() {
        return companyActiveTime;
    }

    public void setCompanyActiveTime(Date companyActiveTime) {
        this.companyActiveTime = companyActiveTime;
    }

    public Integer getPartnerCompanyUserId() {
        return partnerCompanyUserId;
    }

    public void setPartnerCompanyUserId(Integer partnerCompanyUserId) {
        this.partnerCompanyUserId = partnerCompanyUserId;
    }

    public Date getPartnerCompanyActiveTime() {
        return partnerCompanyActiveTime;
    }

    public void setPartnerCompanyActiveTime(Date partnerCompanyActiveTime) {
        this.partnerCompanyActiveTime = partnerCompanyActiveTime;
    }

    @Override
    public String toString() {
        return "WpCfgFrameProcessVersion{" +
                "id=" + id +
                ", version=" + version +
                ", cfgFrameProcessId=" + cfgFrameProcessId +
                ", flagAvaliable=" + flagAvaliable +
                ", createPerson=" + createPerson +
                ", createTime=" + createTime +
                ", updatePerson=" + updatePerson +
                ", updateTime=" + updateTime +
                ", flagIsLast=" + flagIsLast +
                ", companyUserId=" + companyUserId +
                ", companyActiveTime=" + companyActiveTime +
                ", partnerCompanyUserId=" + partnerCompanyUserId +
                ", partnerCompanyActiveTime=" + partnerCompanyActiveTime +
                '}';
    }
}