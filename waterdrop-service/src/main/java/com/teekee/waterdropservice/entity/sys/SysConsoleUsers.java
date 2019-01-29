package com.teekee.waterdropservice.entity.sys;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

@ApiModel(value = "公司用户账号")
public class SysConsoleUsers {
    @ApiModelProperty(value = "id", example = "1", required = true)
    private Integer id;

    @ApiModelProperty(value = "nickname", example = "1", required = true)
    private String nickname;

    @ApiModelProperty(value = "id", example = "1", required = true)
    private String password;

    @ApiModelProperty(value = "id", example = "1", required = true)
    private String username;

    @ApiModelProperty(value = "id", example = "1", required = true)
    private String headPortraitUrl;

    @ApiModelProperty(value = "id", example = "1", required = true)
    private Date createTime;

    @ApiModelProperty(value = "id", example = "1", required = true)
    private Date updateTime;

    @ApiModelProperty(value = "id", example = "1", required = true)
    private Boolean flagDeleted;

    @ApiModelProperty(value = "id", example = "1", required = true)
    private String actType;

    @ApiModelProperty(value = "id", example = "1", required = true)
    private String actObjectId;

    @ApiModelProperty(value = "id", example = "1", required = true)
    private Boolean flagOpenStatus;

    @ApiModelProperty(value = "id", example = "1", required = true)
    private String email;

    @ApiModelProperty(value = "id", example = "1", required = true)
    private Boolean flagAvailable;

    private String realName;

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
}