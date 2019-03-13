package com.company.springboot.entity.dmi;

import com.company.springboot.base.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;
@ApiModel(value = "雇主/门店联系人")
public class DmiContact extends BaseEntity{
    @ApiModelProperty(value = "id", example = "1", required = true)
    private Integer id;

    @ApiModelProperty(value = "联系人姓名", example = "1", required = true)
    private String contactName;

    @ApiModelProperty(value = "联系人中文名", example = "1", required = true)
    private String contactNameCn;

    @ApiModelProperty(value = "联系人英文名", example = "1", required = true)
    private String contactNameEn;

    @ApiModelProperty(value = "联系电话-座机", example = "1", required = true)
    private String telephone;

    @ApiModelProperty(value = "手机", example = "1", required = true)
    private String mobile;

    @ApiModelProperty(value = "QQ号", example = "1", required = true)
    private String qq;

    @ApiModelProperty(value = "微信号", example = "1", required = true)
    private String wechat;

    @ApiModelProperty(value = "是否已删除", example = "1", required = true)
    private Boolean flagDeleted;

    @ApiModelProperty(value = "是否有效", example = "1", required = true)
    private Boolean flagAvailable;

    private Date createTime;

    private Integer createPerson;

    private Date updateTime;

    private Integer updatePerson;

    @ApiModelProperty(value = "备注", example = "1", required = true)
    private String memo;

    //@ApiModelProperty(value = "所属公司ID", example = "1", required = false)
    private Integer belongCompanyId;

    @ApiModelProperty(value = "邮箱", example = "1", required = true)
    private String email;

    @ApiModelProperty(value = "数据来源", example = "1", required = true)
    private String sourceType;

    @ApiModelProperty(value = "用户账号", example = "1", required = true)
    private String account;

    @ApiModelProperty(value = "密码", example = "1", required = true)
    private String password;

    @ApiModelProperty(value = "手机地区码", example = "1", required = true)
    private String mobileAreaCode;

    @ApiModelProperty(value = "所属门店id", example = "1", required = true)
    private String storeId;

    @ApiModelProperty(value = "是否为主要联系人", example ="1", required = true)
    private Boolean flagMajor;

    public String getStoreId() {
        return storeId;
    }

    public void setStoreId(String storeId) {
        this.storeId = storeId;
    }

    public String getMobileAreaCode() {
        return mobileAreaCode;
    }

    public void setMobileAreaCode(String mobileAreaCode) {
        this.mobileAreaCode = mobileAreaCode;
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

    public String getSourceType() {
        return sourceType;
    }

    public void setSourceType(String sourceType) {
        this.sourceType = sourceType;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName == null ? null : contactName.trim();
    }

    public String getContactNameCn() {
        return contactNameCn;
    }

    public void setContactNameCn(String contactNameCn) {
        this.contactNameCn = contactNameCn == null ? null : contactNameCn.trim();
    }

    public String getContactNameEn() {
        return contactNameEn;
    }

    public void setContactNameEn(String contactNameEn) {
        this.contactNameEn = contactNameEn == null ? null : contactNameEn.trim();
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone == null ? null : telephone.trim();
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq == null ? null : qq.trim();
    }

    public String getWechat() {
        return wechat;
    }

    public void setWechat(String wechat) {
        this.wechat = wechat == null ? null : wechat.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getCreatePerson() {
        return createPerson;
    }

    public void setCreatePerson(Integer createPerson) {
        this.createPerson = createPerson;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getUpdatePerson() {
        return updatePerson;
    }

    public void setUpdatePerson(Integer updatePerson) {
        this.updatePerson = updatePerson;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo == null ? null : memo.trim();
    }

    public Integer getBelongCompanyId() {
        return belongCompanyId;
    }

    public void setBelongCompanyId(Integer belongCompanyId) {
        this.belongCompanyId = belongCompanyId;
    }

    public Boolean getFlagDeleted() {
        return flagDeleted;
    }

    public void setFlagDeleted(Boolean flagDeleted) {
        this.flagDeleted = flagDeleted;
    }

    public Boolean getFlagAvailable() {
        return flagAvailable;
    }

    public void setFlagAvailable(Boolean flagAvailable) {
        this.flagAvailable = flagAvailable;
    }

    public Boolean getFlagMajor() {
        return flagMajor;
    }

    public void setFlagMajor(Boolean flagMajor) {
        this.flagMajor = flagMajor;
    }
}