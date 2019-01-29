package com.teekee.commoncomponets.entity.message.message;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @description:
 * @author: zhangshuai
 * @create: 2018-11-12 16:38
 */
@ApiModel(value = "邮箱")
public class Email{

    @ApiModelProperty(value = "邮箱记录id", example = "1", required = true)
    private Integer trcEmaiLoglId;

    @ApiModelProperty(value = "请求唯一id", example = "5afeeb16-8f68-43ac-b27a-d2e70afc80ab", required = true)
    private String messageId;

    @ApiModelProperty(value = "发送人名称", example = "保聚风", required = true)
    private String nickName;

    @ApiModelProperty(value = "发送标题", example = "保聚风提醒", required = true)
    private String subject;

    @ApiModelProperty(value = "发送内容", example = "你好！我是保聚风，巴拉巴拉巴拉", required = true)
    private String context;

    @ApiModelProperty(value = "邮箱", example = "1390529699@qq.com,zhangshuaioop@163.com,964554760@qq.com", required = true)
    private String emails;


    @ApiModelProperty(value = "业务类型", example = "KEFU", required = true)
    private String businessType;


    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public String getEmails() {
        return emails;
    }

    public void setEmails(String emails) {
        this.emails = emails;
    }

    public String getBusinessType() {
        return businessType;
    }

    public void setBusinessType(String businessType) {
        this.businessType = businessType;
    }

    public String getMessageId() {
        return messageId;
    }

    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }

    public Integer getTrcEmaiLoglId() {
        return trcEmaiLoglId;
    }

    public void setTrcEmaiLoglId(Integer trcEmaiLoglId) {
        this.trcEmaiLoglId = trcEmaiLoglId;
    }

    @Override
    public String toString() {
        return "Email{" +
                "trcEmaiLoglId=" + trcEmaiLoglId +
                ", messageId='" + messageId + '\'' +
                ", nickName='" + nickName + '\'' +
                ", subject='" + subject + '\'' +
                ", context='" + context + '\'' +
                ", emails='" + emails + '\'' +
                ", businessType='" + businessType + '\'' +
                '}';
    }
}
