package com.baojufeng.commoncomponets.entity.message;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @description: 聊天信息
 * @author: zhangshuai
 * @create: 2018-11-03 12:32
 */
@ApiModel(value = "聊天信息")
public class Chat {

    @ApiModelProperty(value = "id", example = "30", required = true)
    private String cid;

    @ApiModelProperty(value = "消息", example = "{'nickname':'小明同学','content':'<p>请输入聊天信息...</p>'}", required = true)
    private String message;

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
