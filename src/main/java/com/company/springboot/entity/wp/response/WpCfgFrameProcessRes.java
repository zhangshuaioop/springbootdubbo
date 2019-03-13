package com.company.springboot.entity.wp.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;


@ApiModel(value = "框架流程配置")
public class WpCfgFrameProcessRes {

    @ApiModelProperty(value = "id", example = "1", required = true)
    private Integer id;

    @ApiModelProperty(value = "公司名称", example = "1", required = true)
    private String companyName;

    @ApiModelProperty(value = "框架流程名称", example = "1", required = true)
    private String processName;

    @ApiModelProperty(value = "停用启用时间", example = "1", required = true)
    private Date companyActiveTime;

    @ApiModelProperty(value = "0甲方1乙方", example = "1", required = true)
    private Boolean flagIdentity;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getProcessName() {
        return processName;
    }

    public void setProcessName(String processName) {
        this.processName = processName;
    }

    public Date getCompanyActiveTime() {
        return companyActiveTime;
    }

    public void setCompanyActiveTime(Date companyActiveTime) {
        this.companyActiveTime = companyActiveTime;
    }

    public Boolean getFlagIdentity() {
        return flagIdentity;
    }

    public void setFlagIdentity(Boolean flagIdentity) {
        this.flagIdentity = flagIdentity;
    }

    @Override
    public String toString() {
        return "WpCfgFrameProcessRes{" +
                "id=" + id +
                ", companyName='" + companyName + '\'' +
                ", processName='" + processName + '\'' +
                ", companyActiveTime=" + companyActiveTime +
                ", flagIdentity=" + flagIdentity +
                '}';
    }
}