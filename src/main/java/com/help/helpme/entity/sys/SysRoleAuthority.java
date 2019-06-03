package com.help.helpme.entity.sys;

import com.help.helpme.base.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Arrays;
import java.util.List;

@ApiModel(value = "系统角色权限")
public class SysRoleAuthority extends BaseEntity {

    @ApiModelProperty(value = "id", example = "1", required = true)
    private Long id;

    @ApiModelProperty(value = "角色id", example = "1", required = true)
    private Long roleId;

    @ApiModelProperty(value = "权限id", example = "1", required = true)
    private Long authorityId;

    @ApiModelProperty(value = "权限id组", example = "1", required = true)
    private List<Long> AuthorityArr;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public Long getAuthorityId() {
        return authorityId;
    }

    public void setAuthorityId(Long authorityId) {
        this.authorityId = authorityId;
    }

    public List<Long> getAuthorityArr() {
        return AuthorityArr;
    }

    public void setAuthorityArr(List<Long> authorityArr) {
        AuthorityArr = authorityArr;
    }

    @Override
    public String toString() {
        return "SysRoleAuthority{" +
                "id=" + id +
                ", roleId=" + roleId +
                ", authorityId=" + authorityId +
                ", AuthorityArr=" + AuthorityArr +
                '}';
    }
}