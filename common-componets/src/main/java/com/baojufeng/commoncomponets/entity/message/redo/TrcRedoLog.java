package com.baojufeng.commoncomponets.entity.message.redo;

import com.baojufeng.commoncomponets.base.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "redo异常处理")
public class TrcRedoLog extends BaseEntity {

    @ApiModelProperty(value = "id", example = "1", required = true)
    private Integer id;

    @ApiModelProperty(value = "请求唯一id", example = "1", required = true)
    private String messageId;

    @ApiModelProperty(value = "请求路径", example = "1", required = true)
    private String requestUrl;

    @ApiModelProperty(value = "请求报文", example = "1", required = true)
    private String requestBody;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMessageId() {
        return messageId;
    }

    public void setMessageId(String messageId) {
        this.messageId = messageId == null ? null : messageId.trim();
    }

    public String getRequestUrl() {
        return requestUrl;
    }

    public void setRequestUrl(String requestUrl) {
        this.requestUrl = requestUrl == null ? null : requestUrl.trim();
    }

    public String getRequestBody() {
        return requestBody;
    }

    public void setRequestBody(String requestBody) {
        this.requestBody = requestBody == null ? null : requestBody.trim();
    }

    @Override
    public String toString() {
        return "TrcRedoLog{" +
                "id=" + id +
                ", messageId='" + messageId + '\'' +
                ", requestUrl='" + requestUrl + '\'' +
                ", requestBody='" + requestBody + '\'' +
                '}';
    }
}