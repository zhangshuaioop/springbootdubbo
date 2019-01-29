package com.teekee.blueoceanservice.controller.sysconsole.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @description: 用户密码
 * @author: zhangshuai
 * @create: 2019-01-03 17:21
 */
@ApiModel(value = "用户密码入参")
public class SysConsoleUserPassword {

    @ApiModelProperty(value = "新密码", example = "1", required = true)
    private String newPassword;

    @ApiModelProperty(value = "原密码", example = "1", required = true)
    private String password;

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "SysConsoleUserPassword{" +
                "newPassword='" + newPassword + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
