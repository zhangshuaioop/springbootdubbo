package com.example.identification.entity;

import com.example.identification.entity.sys.SysUsersAccount;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Date;

/**
 * Created by zhangshuai on 2019/1/31
 */
public class JwtUser implements UserDetails {

    private Integer id;
    private String username;
    private String password;
    private Collection<? extends GrantedAuthority> authorities;

    @ApiModelProperty(value = "昵称", example = "1", required = true)
    private String realName;

    @ApiModelProperty(value = "昵称", example = "1", required = true)
    private String nickName;

    @ApiModelProperty(value = "手机号", example = "1", required = true)
    private String mobile;

    @ApiModelProperty(value = "头像的图片地址", example = "1", required = true)
    private String headPortraitUrl;

    @ApiModelProperty(value = "邮箱", example = "1", required = true)
    private String email;

    public JwtUser() {
    }

    // 写一个能直接使用user创建jwtUser的构造器
    public JwtUser(SysUsersAccount sysUsersAccount) {
        id = sysUsersAccount.getId();
        username = sysUsersAccount.getAccount();
        password = sysUsersAccount.getPassword();
        mobile = sysUsersAccount.getMobile();
        realName = sysUsersAccount.getRealName();
        nickName = sysUsersAccount.getNickName();
        headPortraitUrl = sysUsersAccount.getHeadPortraitUrl();
        email = sysUsersAccount.getEmail();
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


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getHeadPortraitUrl() {
        return headPortraitUrl;
    }

    public void setHeadPortraitUrl(String headPortraitUrl) {
        this.headPortraitUrl = headPortraitUrl;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
