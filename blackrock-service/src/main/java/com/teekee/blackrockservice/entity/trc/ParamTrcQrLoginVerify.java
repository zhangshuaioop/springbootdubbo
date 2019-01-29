package com.teekee.blackrockservice.entity.trc;

import io.swagger.annotations.ApiModel;

/**
 * @Author Niting
 * @date 2018/8/31
 **/
@ApiModel("验证二维码接口")
public class ParamTrcQrLoginVerify {
    private String code;
    private String wechatOpenId;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getWechatOpenId() {
        return wechatOpenId;
    }

    public void setWechatOpenId(String wechatOpenId) {
        this.wechatOpenId = wechatOpenId;
    }
}
