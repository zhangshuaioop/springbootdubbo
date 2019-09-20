package com.baojufeng.commoncomponets.entity.message.trc;

import com.baojufeng.commoncomponets.base.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "邮箱记录")
public class TrcEmailLog extends BaseEntity {

    @ApiModelProperty(value = "id", example = "1", required = true)
    private Integer id;

    @ApiModelProperty(value = "请求唯一id", example = "5afeeb16-8f68-43ac-b27a-d2e70afc80ab", required = true)
    private String messageId;

    @ApiModelProperty(value = "发送人名称", example = "保聚风", required = true)
    private String nickName;

    @ApiModelProperty(value = "发送标题", example = "呵呵呵呵呵呵呵呵", required = true)
    private String subject;

    @ApiModelProperty(value = "发送内容", example = "内容内容内容内容内容内容内容", required = true)
    private String context;

    @ApiModelProperty(value = "邮箱", example = "zhangshuaioop@163.com", required = true)
    private String emails;

    @ApiModelProperty(value = "业务类型", example = "KEFU", required = true)
    private String businessType;

    @ApiModelProperty(value = "状态0开始，1处理中，2成功", example = "1", required = true)
    private Integer status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName == null ? null : nickName.trim();
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject == null ? null : subject.trim();
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context == null ? null : context.trim();
    }

    public String getEmails() {
        return emails;
    }

    public void setEmails(String emails) {
        this.emails = emails == null ? null : emails.trim();
    }


    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMessageId() {
        return messageId;
    }

    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }

    public String getBusinessType() {
        return businessType;
    }

    public void setBusinessType(String businessType) {
        this.businessType = businessType;
    }

    @Override
    public String toString() {
        return "TrcEmailLog{" +
                "id=" + id +
                ", messageId='" + messageId + '\'' +
                ", nickName='" + nickName + '\'' +
                ", subject='" + subject + '\'' +
                ", context='" + context + '\'' +
                ", emails='" + emails + '\'' +
                ", businessType='" + businessType + '\'' +
                ", status=" + status +
                '}';
    }
}