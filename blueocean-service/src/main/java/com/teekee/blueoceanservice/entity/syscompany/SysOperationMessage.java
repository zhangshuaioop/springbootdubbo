package com.teekee.blueoceanservice.entity.syscompany;

import java.util.Date;

/**
 * @author zhanghao
 * @Title: SysOperationMessage
 * @ProjectName WaterDrop
 * @Description: 业务操作消息
 * @date 2018/12/20下午3:20
 */
public class SysOperationMessage {

    private Integer id;

    private Integer userId;

    private String messageOperation;

    private String messageObjCode;

    private Integer messageObjId;

    private String content;

    private Date createTime;

    private Date readTime;

    private Boolean flagRead;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getMessageOperation() {
        return messageOperation;
    }

    public void setMessageOperation(String messageOperation) {
        this.messageOperation = messageOperation == null ? null : messageOperation.trim();
    }

    public String getMessageObjCode() {
        return messageObjCode;
    }

    public void setMessageObjCode(String messageObjCode) {
        this.messageObjCode = messageObjCode == null ? null : messageObjCode.trim();
    }

    public Integer getMessageObjId() {
        return messageObjId;
    }

    public void setMessageObjId(Integer messageObjId) {
        this.messageObjId = messageObjId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getReadTime() {
        return readTime;
    }

    public void setReadTime(Date readTime) {
        this.readTime = readTime;
    }

    public Boolean getFlagRead() {
        return flagRead;
    }

    public void setFlagRead(Boolean flagRead) {
        this.flagRead = flagRead;
    }
}
