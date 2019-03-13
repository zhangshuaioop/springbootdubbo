package com.company.springboot.entity.dto.bif.BifCommunicationServiceContact;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Min;

/**
 * 新增/编辑服务商联系人
 *
 * @author Wujun
 * @create 2017年09月07日 15:11
 */
public class HandleDTO {

    @Min(value = 0, message = "非法操作，请勿再次尝试")
    private int id;

    private String memo;

    @Min(value = 1, message = "非法操作，请勿再次尝试")
    private int serviceId;

    @NotBlank(message = "联系人姓名不能为空")
    @Length(max = 50, message = "联系人姓名不能超过50位")
    private String contactName;

    @Email(message = "请输入正确的邮箱地址")
    @Length(max = 100, message = "邮箱地址不能超过100位")
    private String email;

    @Length(max = 50, message = "手机号码不能超过50位")
    private String mobile;

    @Length(max = 50, message = "座机号码不能超过50位")
    private String telephone;

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

}
