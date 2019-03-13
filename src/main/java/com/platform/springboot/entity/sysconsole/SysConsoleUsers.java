package com.platform.springboot.entity.sysconsole;

import com.platform.springboot.base.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;
import java.util.Date;

@ApiModel(value = "平台用户账号")
public class SysConsoleUsers extends BaseEntity {

    @ApiModelProperty(value = "id", example = "1", required = true)
    private Integer id;

    @ApiModelProperty(value = "昵称", example = "1", required = true)
    private String nickname;

    @ApiModelProperty(value = "真实姓名", example = "1", required = true)
    private String realName;

    @ApiModelProperty(value = "密码", example = "1", required = true)
    private String password;

    @ApiModelProperty(value = "用户名", example = "1", required = true)
    private String username;

    @ApiModelProperty(value = "头像", example = "1", required = true)
    private String headPortraitUrl;

    @ApiModelProperty(value = "创建时间", example = "1", required = true)
    private Date createTime;

    @ApiModelProperty(value = "更新时间", example = "1", required = true)
    private Date updateTime;

    @ApiModelProperty(value = "是否删除0正常1删除", example = "1", required = true)
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

    @ApiModelProperty(value = "手机号", example = "18025656789", required = true)
    private String mobile;

    @ApiModelProperty(value = "角色名称", example = "超级管理员", required = true)
    private String roleName;

    private Collection<? extends GrantedAuthority> authorities;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(Collection<? extends GrantedAuthority> authorities) {
        this.authorities = authorities;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    @Override
    public String toString() {
        return "SysConsoleUsers{" +
                "id=" + id +
                ", nickname='" + nickname + '\'' +
                ", realName='" + realName + '\'' +
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
                ", mobile='" + mobile + '\'' +
                ", roleName='" + roleName + '\'' +
                ", authorities=" + authorities +
                '}';
    }
}