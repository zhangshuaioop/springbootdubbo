package com.example.messenger.entity.publicss;

import com.example.messenger.base.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

@ApiModel(value = "用户")
public class User extends BaseEntity {
    @ApiModelProperty(value = "id", example = "1", required = true)
    private Long id;

    @ApiModelProperty(value = "创建时间", example = "1", required = true)
    private Date createDate;

    @ApiModelProperty(value = "更新时间", example = "1", required = true)
    private Date modifyDate;

    @ApiModelProperty(value = "部门", example = "1", required = true)
    private String dept;

    @ApiModelProperty(value = "是否启用0启用1禁用", example = "1", required = true)
    private Boolean isEnabled;

    @ApiModelProperty(value = "登陆时间", example = "1", required = true)
    private Date loginDate;

    @ApiModelProperty(value = "登陆ip", example = "1", required = true)
    private String loginIp;

    @ApiModelProperty(value = "头像", example = "1", required = true)
    private String headUrl;

    @ApiModelProperty(value = "姓名", example = "1", required = true)
    private String name;

    @ApiModelProperty(value = "密码", example = "1", required = true)
    private String password;

    @ApiModelProperty(value = "用户名", example = "1", required = true)
    private String username;

    @ApiModelProperty(value = "邮箱", example = "1", required = true)
    private String email;

    @ApiModelProperty(value = "是否删除0删除1正常", example = "1", required = true)
    private Boolean isDel;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept == null ? null : dept.trim();
    }

    public Boolean getIsEnabled() {
        return isEnabled;
    }

    public void setIsEnabled(Boolean isEnabled) {
        this.isEnabled = isEnabled;
    }

    public Date getLoginDate() {
        return loginDate;
    }

    public void setLoginDate(Date loginDate) {
        this.loginDate = loginDate;
    }

    public String getLoginIp() {
        return loginIp;
    }

    public void setLoginIp(String loginIp) {
        this.loginIp = loginIp == null ? null : loginIp.trim();
    }

    public String getHeadUrl() {
        return headUrl;
    }

    public void setHeadUrl(String headUrl) {
        this.headUrl = headUrl == null ? null : headUrl.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public Boolean getIsDel() {
        return isDel;
    }

    public void setIsDel(Boolean isDel) {
        this.isDel = isDel;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", createDate=" + createDate +
                ", modifyDate=" + modifyDate +
                ", dept='" + dept + '\'' +
                ", isEnabled=" + isEnabled +
                ", loginDate=" + loginDate +
                ", loginIp='" + loginIp + '\'' +
                ", headUrl='" + headUrl + '\'' +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", isDel=" + isDel +
                '}';
    }
}