package com.help.helpme.entity;

import com.help.helpme.entity.sys.SysAdmin;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Date;

/**
 * Created by zhangshuai on 2019/1/31
 */
public class JwtUser implements UserDetails {

    private Long id;
    private String username;
    private String password;
    private Collection<? extends GrantedAuthority> authorities;

    @ApiModelProperty(value = "昵称", example = "1", required = true)
    private String nickName;

    @ApiModelProperty(value = "部门", example = "1", required = true)
    private String dept;

    @ApiModelProperty(value = "描述", example = "1", required = true)
    private String description;

    @ApiModelProperty(value = "头像", example = "1", required = true)
    private String headUrl;

    @ApiModelProperty(value = "邮箱", example = "1", required = true)
    private String email;

    @ApiModelProperty(value = "手机号", example = "1", required = true)
    private String mobile;

    @ApiModelProperty(value = "登陆时间", example = "1", required = true)
    private Date loginDate;

    @ApiModelProperty(value = "登陆ip", example = "1", required = true)
    private String loginIp;

    public JwtUser() {
    }

    // 写一个能直接使用user创建jwtUser的构造器
    public JwtUser(SysAdmin sysAdmin) {
        id = sysAdmin.getId();
        username = sysAdmin.getUsername();
        password = sysAdmin.getPassword();
        nickName = sysAdmin.getNickName();
        dept = sysAdmin.getDept();
        description = sysAdmin.getDescription();
        headUrl = sysAdmin.getHeadUrl();
        email = sysAdmin.getEmail();
        mobile = sysAdmin.getMobile();
        loginDate = sysAdmin.getLoginDate();
        loginIp = sysAdmin.getLoginIp();
        authorities = sysAdmin.getAuthorities();
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getHeadUrl() {
        return headUrl;
    }

    public void setHeadUrl(String headUrl) {
        this.headUrl = headUrl;
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
        this.loginIp = loginIp;
    }

    @Override
    public String toString() {
        return "JwtUser{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", authorities=" + authorities +
                ", nickName='" + nickName + '\'' +
                ", dept='" + dept + '\'' +
                ", description='" + description + '\'' +
                ", headUrl='" + headUrl + '\'' +
                ", email='" + email + '\'' +
                ", mobile='" + mobile + '\'' +
                ", loginDate=" + loginDate +
                ", loginIp='" + loginIp + '\'' +
                '}';
    }
}
