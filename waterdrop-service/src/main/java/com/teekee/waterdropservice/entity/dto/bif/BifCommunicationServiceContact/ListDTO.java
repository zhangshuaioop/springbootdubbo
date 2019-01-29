package com.teekee.waterdropservice.entity.dto.bif.BifCommunicationServiceContact;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;

/**
 * 根据条件，查询联系人列表
 *
 * @author Wujun
 * @create 2017年09月07日 15:11
 */
public class ListDTO {

    private int serviceId;

    @Length(max = 50, message = "联系人姓名不能超过50位")
    private String contactName;

    @Email(message = "请输入正确的邮箱地址")
    @Length(max = 100, message = "邮箱地址不能超过100位")
    private String email;

    @Length(max = 50, message = "手机号码不能超过50位")
    private String mobile;

    @Length(max = 50, message = "座机号码不能超过50位")
    private String telephone;

    private Boolean flagAvailable;

    public int getServiceId() {
        return serviceId;
    }

    public void setServiceId(int serviceId) {
        this.serviceId = serviceId;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public Boolean getFlagAvailable() {
        return flagAvailable;
    }

    public void setFlagAvailable(Boolean flagAvailable) {
        this.flagAvailable = flagAvailable;
    }
}
