package com.baojufeng.commoncomponets.entity.message.trc;

import com.baojufeng.commoncomponets.base.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

@ApiModel(value = "短信记录")
public class TrcSmsLog extends BaseEntity {
    @ApiModelProperty(value = "id", example = "1", required = true)
    private Integer id;

    @ApiModelProperty(value = "发送方类型", example = "wechat", required = true)
    private String sendModule;

    @ApiModelProperty(value = "关键字，如果验证码就存放验证码", example = "687654", required = true)
    private String keyword;

    @ApiModelProperty(value = "短信内容", example = "验证码：512906，验证码5分钟内有效，如非本人操作请忽略，谢谢。", required = true)
    private String content;

    @ApiModelProperty(value = "目标人员的ID", example = "1", required = true)
    private Integer userId;

    @ApiModelProperty(value = "目标手机号", example = "18376545676", required = true)
    private String mobile;

    @ApiModelProperty(value = "流水号，目前按照send_module_年月日时分秒毫秒_6位随机数生成", example = "20181026104043297351", required = true)
    private String serialNumber;

    @ApiModelProperty(value = "短信发送成功", example = "1", required = true)
    private Boolean flagSendSuccessful;

    @ApiModelProperty(value = "变更时间", example = "2018-10-26 12:19:58", required = true)
    private Date createTime;

    @ApiModelProperty(value = "有效时间", example = "2018-10-26 12:24:58", required = true)
    private Date validTime;

    @ApiModelProperty(value = "是否已验证", example = "1", required = true)
    private Boolean flagValid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSendModule() {
        return sendModule;
    }

    public void setSendModule(String sendModule) {
        this.sendModule = sendModule == null ? null : sendModule.trim();
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword == null ? null : keyword.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber == null ? null : serialNumber.trim();
    }

    public Boolean getFlagSendSuccessful() {
        return flagSendSuccessful;
    }

    public void setFlagSendSuccessful(Boolean flagSendSuccessful) {
        this.flagSendSuccessful = flagSendSuccessful;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getValidTime() {
        return validTime;
    }

    public void setValidTime(Date validTime) {
        this.validTime = validTime;
    }

    public Boolean getFlagValid() {
        return flagValid;
    }

    public void setFlagValid(Boolean flagValid) {
        this.flagValid = flagValid;
    }
}