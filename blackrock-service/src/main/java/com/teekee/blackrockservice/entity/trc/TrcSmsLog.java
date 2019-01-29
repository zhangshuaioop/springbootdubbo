package com.teekee.blackrockservice.entity.trc;

import java.util.Date;

public class TrcSmsLog {
    private Integer id;

    private String sendModule;

    private String keyword;

    private String content;

    private Integer userId;

    private String mobile;

    private String serialNumber;

    private Boolean flagSendSuccessful;

    private Date createTime;

    private Date validTime;

    private Boolean flagValid;



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Boolean getFlagValid() {
        return flagValid;
    }

    public void setFlagValid(Boolean flagValid) {
        this.flagValid = flagValid;
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
}