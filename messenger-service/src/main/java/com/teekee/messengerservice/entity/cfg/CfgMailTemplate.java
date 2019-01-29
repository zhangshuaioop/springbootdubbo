package com.teekee.messengerservice.entity.cfg;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

@ApiModel(value = "邮件模板")
public class CfgMailTemplate {

    @ApiModelProperty(value = "id", example = "30", required = true)
    private Integer id;

    @ApiModelProperty(value = "类型，DISPATCH_COMFIRM", example = "30", required = true)
    private String type;

    @ApiModelProperty(value = "标题", example = "30", required = true)
    private String title;

    @ApiModelProperty(value = "是否有效", example = "30", required = true)
    private Boolean flagAvailable;

    @ApiModelProperty(value = "创建时间", example = "30", required = true)
    private Date createTime;

    @ApiModelProperty(value = "内容", example = "30", required = true)
    private String content;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public Boolean getFlagAvailable() {
        return flagAvailable;
    }

    public void setFlagAvailable(Boolean flagAvailable) {
        this.flagAvailable = flagAvailable;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    @Override
    public String toString() {
        return "CfgMailTemplate{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", title='" + title + '\'' +
                ", flagAvailable=" + flagAvailable +
                ", createTime=" + createTime +
                ", content='" + content + '\'' +
                '}';
    }
}