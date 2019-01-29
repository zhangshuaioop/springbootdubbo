package com.teekee.blackrockservice.entity.bif;

import io.swagger.annotations.ApiModel;

/**
 * @Author Niting
 * @date 2018/7/20
 **/
@ApiModel("账户列表")
public class ListDispatchAccountInfo {
    private Integer id;

    private Integer hrId;

    private String fullName;

    private String bankName;

    private String account;

    private String alipayAccount;

    private String paymentMethod;

    private Boolean flagDefault;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getHrId() {
        return hrId;
    }

    public void setHrId(Integer hrId) {
        this.hrId = hrId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getAlipayAccount() {
        return alipayAccount;
    }

    public void setAlipayAccount(String alipayAccount) {
        this.alipayAccount = alipayAccount;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public Boolean getFlagDefault() {
        return flagDefault;
    }

    public void setFlagDefault(Boolean flagDefault) {
        this.flagDefault = flagDefault;
    }
}
