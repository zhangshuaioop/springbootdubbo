package com.teekee.blackrockservice.entity.bif;

import com.teekee.commoncomponets.base.BaseEntity;
import io.swagger.annotations.ApiModel;

/**
 * @Author Niting
 * @date 2018/7/17
 **/
@ApiModel(value = "人力服务商登录参数")
public class HumanResourceLoginParam extends BaseEntity{
    private String account;
    private String password;
    private String keyword;
    private String code;
    private String firstName;
    private String lastName;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
