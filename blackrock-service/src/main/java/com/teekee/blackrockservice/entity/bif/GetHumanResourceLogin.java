package com.teekee.blackrockservice.entity.bif;

import com.teekee.commoncomponets.base.BaseEntity;

/**
 * 服务商登录实体
 * @Author Niting
 * @date 2018/7/17
 **/

public class GetHumanResourceLogin extends BaseEntity{
    private Integer id;
    private Boolean flagInfo;
    private Boolean flagVaild;
    private String Token;
    private String mobile;
    private String wechatOpenId;

    public String getWechatOpenId() {
        return wechatOpenId;
    }

    public void setWechatOpenId(String wechatOpenId) {
        this.wechatOpenId = wechatOpenId;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getToken() {
        return Token;
    }

    public void setToken(String token) {
        Token = token;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Boolean getFlagInfo() {
        return flagInfo;
    }

    public void setFlagInfo(Boolean flagInfo) {
        this.flagInfo = flagInfo;
    }

    public Boolean getFlagVaild() {
        return flagVaild;
    }

    public void setFlagVaild(Boolean flagVaild) {
        this.flagVaild = flagVaild;
    }
}
