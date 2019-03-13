package com.company.springboot.entity.wp;

import com.company.springboot.base.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

@ApiModel(value = "公司内业务流程")
public class WpProcess extends BaseEntity {

    @ApiModelProperty(value = "id", example = "1", required = true)
    private Integer id;

    @ApiModelProperty(value = "创建公司ID", example = "1", required = true)
    private Integer frameProcessId;

    @ApiModelProperty(value = "流程配置id", example = "1", required = true)
    private Integer processCfgId;

    @ApiModelProperty(value = "版本id", example = "1", required = true)
    private Integer versionId;

    @ApiModelProperty(value = "是否删除", example = "1", required = true)
    private Boolean flagDeleted;

    @ApiModelProperty(value = "创建人ID", example = "1", required = true)
    private Integer createPerson;

    @ApiModelProperty(value = "创建时间", example = "1", required = true)
    private Date createTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getFrameProcessId() {
        return frameProcessId;
    }

    public void setFrameProcessId(Integer frameProcessId) {
        this.frameProcessId = frameProcessId;
    }

    public Integer getProcessCfgId() {
        return processCfgId;
    }

    public void setProcessCfgId(Integer processCfgId) {
        this.processCfgId = processCfgId;
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

    @Override
    public String toString() {
        return "WpProcess{" +
                "id=" + id +
                ", frameProcessId=" + frameProcessId +
                ", processCfgId=" + processCfgId +
                ", versionId=" + versionId +
                ", flagDeleted=" + flagDeleted +
                ", createPerson=" + createPerson +
                ", createTime=" + createTime +
                '}';
    }
}