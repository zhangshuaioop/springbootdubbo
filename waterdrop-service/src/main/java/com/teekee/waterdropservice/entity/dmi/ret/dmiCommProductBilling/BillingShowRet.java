package com.teekee.waterdropservice.entity.dmi.ret.dmiCommProductBilling;

/**
 * 显示账单信息-返回结果
 *
 * @author Wujun
 * @create 2017年06月09日 10:14
 */
public class BillingShowRet {
    // 账单联系人
    private String contact;
    // 账单地址
    private String address;
    // 电子账单地址
    private String email;
    // 报障联系人
    private String failureDealPerson;
    // 报障联系电话
    private String failureDealTel;

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFailureDealPerson() {
        return failureDealPerson;
    }

    public void setFailureDealPerson(String failureDealPerson) {
        this.failureDealPerson = failureDealPerson;
    }

    public String getFailureDealTel() {
        return failureDealTel;
    }

    public void setFailureDealTel(String failureDealTel) {
        this.failureDealTel = failureDealTel;
    }
}
