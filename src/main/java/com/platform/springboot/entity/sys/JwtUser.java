package com.platform.springboot.entity.sys;

import io.swagger.annotations.ApiModelProperty;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Date;

/**
 * Created by echisan on 2018/6/23
 */
public class JwtUser implements UserDetails {

    private Integer id;
    private String username;
    private String password;
    private Collection<? extends GrantedAuthority> authorities;

    @ApiModelProperty(value = "公司id", example = "1", required = true)
    private Integer companyId;

    @ApiModelProperty(value = "昵称", example = "1", required = true)
    private String nickname;

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
    private Integer actObjectId;

    @ApiModelProperty(value = "0关闭1打开", example = "1", required = true)
    private Boolean flagOpenStatus;

    @ApiModelProperty(value = "邮箱", example = "1", required = true)
    private String email;

    @ApiModelProperty(value = "是否有效1有效0无效", example = "1", required = true)
    private Boolean flagAvailable;

    @ApiModelProperty(value = "关系公司ids", example = "1", required = true)
    private String relationCompanyIds;

    @ApiModelProperty(value = "套餐版本id", example = "1", required = true)
    private Integer versionId;

    public JwtUser() {
    }

    // 写一个能直接使用user创建jwtUser的构造器
    public JwtUser(SysCompanyUsers sysCompanyUsers) {
        id = sysCompanyUsers.getId();
        username = sysCompanyUsers.getUsername();
        password = sysCompanyUsers.getPassword();
        companyId = sysCompanyUsers.getCompanyId();
        nickname = sysCompanyUsers.getNickname();
        headPortraitUrl = sysCompanyUsers.getHeadPortraitUrl();
        createTime = sysCompanyUsers.getCreateTime();
        updateTime = sysCompanyUsers.getUpdateTime();
        flagDeleted = sysCompanyUsers.getFlagDeleted();
        actType = sysCompanyUsers.getActType();
        actObjectId = sysCompanyUsers.getActObjectId();
        flagOpenStatus = sysCompanyUsers.getFlagOpenStatus();
        email = sysCompanyUsers.getEmail();
        flagAvailable = sysCompanyUsers.getFlagAvailable();
        relationCompanyIds = sysCompanyUsers.getRelationCompanyIds();
        versionId = sysCompanyUsers.getVersionId();
        authorities = sysCompanyUsers.getAuthorities();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getHeadPortraitUrl() {
        return headPortraitUrl;
    }

    public void setHeadPortraitUrl(String headPortraitUrl) {
        this.headPortraitUrl = headPortraitUrl;
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
        this.actType = actType;
    }

    public Integer getActObjectId() {
        return actObjectId;
    }

    public void setActObjectId(Integer actObjectId) {
        this.actObjectId = actObjectId;
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
        this.email = email;
    }

    public Boolean getFlagAvailable() {
        return flagAvailable;
    }

    public void setFlagAvailable(Boolean flagAvailable) {
        this.flagAvailable = flagAvailable;
    }

    public String getRelationCompanyIds() {
        return relationCompanyIds;
    }

    public void setRelationCompanyIds(String relationCompanyIds) {
        this.relationCompanyIds = relationCompanyIds;
    }

    public Integer getVersionId() {
        return versionId;
    }

    public void setVersionId(Integer versionId) {
        this.versionId = versionId;
    }

    @Override
    public String toString() {
        return "JwtUser{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", authorities=" + authorities +
                ", companyId=" + companyId +
                ", nickname='" + nickname + '\'' +
                ", headPortraitUrl='" + headPortraitUrl + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", flagDeleted=" + flagDeleted +
                ", actType='" + actType + '\'' +
                ", actObjectId=" + actObjectId +
                ", flagOpenStatus=" + flagOpenStatus +
                ", email='" + email + '\'' +
                ", flagAvailable=" + flagAvailable +
                ", relationCompanyIds=" + relationCompanyIds +
                ", versionId=" + versionId +
                '}';
    }
}
