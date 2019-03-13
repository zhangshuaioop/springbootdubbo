package com.company.springboot.entity.trc;

import java.util.Date;

public class TrcQrLoginCodeLog {
    private Integer id;

    private String sendModule;

    private String code;

    private Date avaliableTime;

    private Integer userId;

    private String userToken;

    private Boolean flagUsed;

    private Date createTime;

    private Date useTime;

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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    public Date getAvaliableTime() {
        return avaliableTime;
    }

    public void setAvaliableTime(Date avaliableTime) {
        this.avaliableTime = avaliableTime;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserToken() {
        return userToken;
    }

    public void setUserToken(String userToken) {
        this.userToken = userToken == null ? null : userToken.trim();
    }

    public Boolean getFlagUsed() {
        return flagUsed;
    }

    public void setFlagUsed(Boolean flagUsed) {
        this.flagUsed = flagUsed;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUseTime() {
        return useTime;
    }

    public void setUseTime(Date useTime) {
        this.useTime = useTime;
    }
}