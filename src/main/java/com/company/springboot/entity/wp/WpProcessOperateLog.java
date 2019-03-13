package com.company.springboot.entity.wp;

import com.company.springboot.base.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

@ApiModel(value = "流程操作日志")
public class WpProcessOperateLog extends BaseEntity {

    @ApiModelProperty(value = "id", example = "1", required = true)
    private Integer id;

    @ApiModelProperty(value = "框架流程ID", example = "1", required = true)
    private Integer frameProcessId;

    @ApiModelProperty(value = "当前步骤ID", example = "1", required = true)
    private Integer cfgProcessStepId;

    @ApiModelProperty(value = "处理人ID", example = "1", required = true)
    private Integer operatePerson;

    @ApiModelProperty(value = "创建时间", example = "1", required = true)
    private Date operateTime;

    @ApiModelProperty(value = "图片路径", example = "1", required = true)
    private String photosUrl;

    @ApiModelProperty(value = "图片名称", example = "1", required = true)
    private String photosName;

    @ApiModelProperty(value = "文件路径", example = "1", required = true)
    private String filesUrl;

    @ApiModelProperty(value = "文件名称", example = "1", required = true)
    private String filesName;

    @ApiModelProperty(value = "操作结果，YES：同意，NO：拒绝，TRANSFER：转交", example = "1", required = true)
    private String operateResult;

    @ApiModelProperty(value = "已使用分钟数", example = "1", required = true)
    private Integer timeUsed;

    @ApiModelProperty(value = "是否超时", example = "1", required = true)
    private Boolean flagTimeout;

    @ApiModelProperty(value = "描述", example = "1", required = true)
    private String description;

    @ApiModelProperty(value = "订单id", example = "1", required = true)
    private Integer orderId;

    @ApiModelProperty(value = "用户昵称", example = "1", required = true)
    private String nickname;

    @ApiModelProperty(value = "节点名称", example = "1", required = true)
    private String stepName;

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

    public Integer getCfgProcessStepId() {
        return cfgProcessStepId;
    }

    public void setCfgProcessStepId(Integer cfgProcessStepId) {
        this.cfgProcessStepId = cfgProcessStepId;
    }

    public Integer getOperatePerson() {
        return operatePerson;
    }

    public void setOperatePerson(Integer operatePerson) {
        this.operatePerson = operatePerson;
    }

    public Date getOperateTime() {
        return operateTime;
    }

    public void setOperateTime(Date operateTime) {
        this.operateTime = operateTime;
    }

    public String getPhotosUrl() {
        return photosUrl;
    }

    public void setPhotosUrl(String photosUrl) {
        this.photosUrl = photosUrl == null ? null : photosUrl.trim();
    }

    public String getPhotosName() {
        return photosName;
    }

    public void setPhotosName(String photosName) {
        this.photosName = photosName == null ? null : photosName.trim();
    }

    public String getFilesUrl() {
        return filesUrl;
    }

    public void setFilesUrl(String filesUrl) {
        this.filesUrl = filesUrl == null ? null : filesUrl.trim();
    }

    public String getFilesName() {
        return filesName;
    }

    public void setFilesName(String filesName) {
        this.filesName = filesName == null ? null : filesName.trim();
    }

    public String getOperateResult() {
        return operateResult;
    }

    public void setOperateResult(String operateResult) {
        this.operateResult = operateResult == null ? null : operateResult.trim();
    }

    public Integer getTimeUsed() {
        return timeUsed;
    }

    public void setTimeUsed(Integer timeUsed) {
        this.timeUsed = timeUsed;
    }

    public Boolean getFlagTimeout() {
        return flagTimeout;
    }

    public void setFlagTimeout(Boolean flagTimeout) {
        this.flagTimeout = flagTimeout;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getStepName() {
        return stepName;
    }

    public void setStepName(String stepName) {
        this.stepName = stepName;
    }

    @Override
    public String toString() {
        return "WpProcessOperateLog{" +
                "id=" + id +
                ", frameProcessId=" + frameProcessId +
                ", cfgProcessStepId=" + cfgProcessStepId +
                ", operatePerson=" + operatePerson +
                ", operateTime=" + operateTime +
                ", photosUrl='" + photosUrl + '\'' +
                ", photosName='" + photosName + '\'' +
                ", filesUrl='" + filesUrl + '\'' +
                ", filesName='" + filesName + '\'' +
                ", operateResult='" + operateResult + '\'' +
                ", timeUsed=" + timeUsed +
                ", flagTimeout=" + flagTimeout +
                ", description='" + description + '\'' +
                ", orderId=" + orderId +
                ", nickname='" + nickname + '\'' +
                ", stepName='" + stepName + '\'' +
                '}';
    }
}