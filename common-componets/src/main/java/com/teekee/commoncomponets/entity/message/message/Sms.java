package com.teekee.commoncomponets.entity.message.message;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @description: 短信
 * @author: zhangshuai
 * @create: 2018-11-23 23:58
 */
@ApiModel(value = "短信")
public class Sms {

    @ApiModelProperty(value = "请求唯一id", example = "5afeeb16-8f68-43ac-b27a-d2e70adc80ab", required = true)
    private String messageId;

    @ApiModelProperty(value = "手机号", example = "18301983703,16621188327", required = true)
    private String mobile;

    @ApiModelProperty(value = "内容", example = "尊敬的用户你好，我是巴拉巴拉", required = true)
    private String content;

    @ApiModelProperty(value = "业务类型", example = "YZM", required = true)
    private String businessType;

    @ApiModelProperty(value = "短信记录id", example = "26", required = true)
    private Integer trcSmsLogId;

    @ApiModelProperty(value = "验证码", example = "675546", required = true)
    private String code;

    public String getMessageId() {
        return messageId;
    }

    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getBusinessType() {
        return businessType;
    }

    public void setBusinessType(String businessType) {
        this.businessType = businessType;
    }

    public Integer getTrcSmsLogId() {
        return trcSmsLogId;
    }

    public void setTrcSmsLogId(Integer trcSmsLogId) {
        this.trcSmsLogId = trcSmsLogId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "Sms{" +
                "messageId='" + messageId + '\'' +
                ", mobile='" + mobile + '\'' +
                ", content='" + content + '\'' +
                ", businessType='" + businessType + '\'' +
                ", trcSmsLogId=" + trcSmsLogId +
                ", code='" + code + '\'' +
                '}';
    }
}
