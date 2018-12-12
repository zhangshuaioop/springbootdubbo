package com.lxg.springboot.entity.sysuser;

import com.lxg.springboot.base.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

@ApiModel(value = "公司用户账号")
public class SysUsers extends BaseEntity {

    @ApiModelProperty(value = "id", example = "1", required = true)
    private Integer id;

    @ApiModelProperty(value = "用户名", example = "1", required = true)
    private String account;

    @ApiModelProperty(value = "密码", example = "1", required = true)
    private String password;

    @ApiModelProperty(value = "用户真实姓名", example = "1", required = true)
    private String username;

    @ApiModelProperty(value = "头像的图片地址", example = "1", required = true)
    private String headPortraitUrl;

    @ApiModelProperty(value = "创建时间", example = "1", required = true)
    private Date createTime;

    @ApiModelProperty(value = "更新时间", example = "1", required = true)
    private Date updateTime;

    @ApiModelProperty(value = "是否删除", example = "1", required = true)
    private Boolean flagDeleted;

    @ApiModelProperty(value = "账号类型：PLATFORM;VENDOR;DEMAND", example = "1", required = true)
    private String actType;

    @ApiModelProperty(value = "账号对应ID", example = "1", required = true)
    private String actObjectId;

    @ApiModelProperty(value = "0关闭1打开", example = "1", required = true)
    private Boolean flagOpenStatus;

    @ApiModelProperty(value = "邮箱", example = "1", required = true)
    private String email;

    @ApiModelProperty(value = "是否有效1有效0无效", example = "1", required = true)
    private Boolean flagAvailable;

    @ApiModelProperty(value = "公司id", example = "1", required = true)
    private Integer companyId;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account == null ? null : account.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getHeadPortraitUrl() {
        return headPortraitUrl;
    }

    public void setHeadPortraitUrl(String headPortraitUrl) {
        this.headPortraitUrl = headPortraitUrl == null ? null : headPortraitUrl.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Boolean getFlagDeleted() {
        return flagDeleted;
    }

    public void setFlagDeleted(Boolean flagDeleted) {
        this.flagDeleted = flagDeleted;
    }

    public String getActType() {
        return actType;
    }

    public void setActType(String actType) {
        this.actType = actType == null ? null : actType.trim();
    }

    public String getActObjectId() {
        return actObjectId;
    }

    public void setActObjectId(String actObjectId) {
        this.actObjectId = actObjectId == null ? null : actObjectId.trim();
    }

    public Boolean getFlagOpenStatus() {
        return flagOpenStatus;
    }

    public void setFlagOpenStatus(Boolean flagOpenStatus) {
        this.flagOpenStatus = flagOpenStatus;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public Boolean getFlagAvailable() {
        return flagAvailable;
    }

    public void setFlagAvailable(Boolean flagAvailable) {
        this.flagAvailable = flagAvailable;
    }


    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    @Override
    public String toString() {
        return "SysUsers{" +
                "id=" + id +
                ", account='" + account + '\'' +
                ", password='" + password + '\'' +
                ", username='" + username + '\'' +
                ", headPortraitUrl='" + headPortraitUrl + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", flagDeleted=" + flagDeleted +
                ", actType='" + actType + '\'' +
                ", actObjectId='" + actObjectId + '\'' +
                ", flagOpenStatus=" + flagOpenStatus +
                ", email='" + email + '\'' +
                ", flagAvailable=" + flagAvailable +
                ", companyId=" + companyId +
                '}';
    }
}