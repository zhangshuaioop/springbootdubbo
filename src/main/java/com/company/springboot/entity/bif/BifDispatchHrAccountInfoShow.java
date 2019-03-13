package com.company.springboot.entity.bif;

public class BifDispatchHrAccountInfoShow {

    private String fullName;

    private String bankName;

    private String account;

    private String alipayAccount;

    private String paymentMethod;

    private boolean flagDefault;

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

    public boolean isFlagDefault() {
        return flagDefault;
    }

    public void setFlagDefault(boolean flagDefault) {
        this.flagDefault = flagDefault;
    }
}
