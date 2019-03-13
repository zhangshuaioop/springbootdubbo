package com.company.springboot.entity.wp;

import com.company.springboot.base.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "流程审批实体")
public class WpApproval extends BaseEntity {


    @ApiModelProperty(value = "创建公司ID", example = "1", required = true)
    private Integer orderId;

    @ApiModelProperty(value = "框架流程id", example = "1", required = true)
    private Integer frameProcessId;

    @ApiModelProperty(value = "状态 0拒绝 1通过 2转发", example = "1", required = true)
    private Integer status;

    @ApiModelProperty(value = "用户id", example = "1", required = true)
    private Integer userId;

    @ApiModelProperty(value = "转发用户id", example = "1", required = true)
    private Integer forwardId;

    @ApiModelProperty(value = "图片路径", example = "1", required = true)
    private String photosUrl;

    @ApiModelProperty(value = "图片名称", example = "1", required = true)
    private String photosName;

    @ApiModelProperty(value = "文件路径", example = "1", required = true)
    private String filesUrl;

    @ApiModelProperty(value = "文件名称", example = "1", required = true)
    private String filesName;

    @ApiModelProperty(value = "描述", example = "1", required = true)
    private String description;

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getFrameProcessId() {
        return frameProcessId;
    }

    public void setFrameProcessId(Integer frameProcessId) {
        this.frameProcessId = frameProcessId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getForwardId() {
        return forwardId;
    }

    public void setForwardId(Integer forwardId) {
        this.forwardId = forwardId;
    }

    public String getPhotosUrl() {
        return photosUrl;
    }

    public void setPhotosUrl(String photosUrl) {
        this.photosUrl = photosUrl;
    }

    public String getPhotosName() {
        return photosName;
    }

    public void setPhotosName(String photosName) {
        this.photosName = photosName;
    }

    public String getFilesUrl() {
        return filesUrl;
    }

    public void setFilesUrl(String filesUrl) {
        this.filesUrl = filesUrl;
    }

    public String getFilesName() {
        return filesName;
    }

    public void setFilesName(String filesName) {
        this.filesName = filesName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "WpApproval{" +
                "orderId=" + orderId +
                ", frameProcessId=" + frameProcessId +
                ", status=" + status +
                ", userId=" + userId +
                ", forwardId=" + forwardId +
                ", photosUrl='" + photosUrl + '\'' +
                ", photosName='" + photosName + '\'' +
                ", filesUrl='" + filesUrl + '\'' +
                ", filesName='" + filesName + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}