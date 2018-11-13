package com.baojufeng.commoncomponets.entity.message;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @description:
 * @author: zhangshuai
 * @create: 2018-11-12 16:38
 */
@ApiModel(value = "邮箱")
public class Email {


    @ApiModelProperty(value = "发送人名称", example = "保聚风", required = true)
    private String nickName;

    @ApiModelProperty(value = "发送标题", example = "保聚风提醒", required = true)
    private String subject;

    @ApiModelProperty(value = "发送内容", example = "你好！我是保聚风，巴拉巴拉巴拉", required = true)
    private String context;

    @ApiModelProperty(value = "邮箱", example = "zhangshuaioop@163.com,964554760@qq.com", required = true)
    private String emails;


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
}
