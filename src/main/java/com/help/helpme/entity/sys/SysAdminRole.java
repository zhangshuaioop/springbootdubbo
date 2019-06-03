package com.help.helpme.entity.sys;

import com.help.helpme.base.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

@ApiModel(value = "系统用户角色")
public class SysAdminRole extends BaseEntity {
    @ApiModelProperty(value = "id", example = "1", required = true)
    private Long id;

    @ApiModelProperty(value = "用户id", example = "1", required = true)
    private Long adminId;

    @ApiModelProperty(value = "角色id", example = "1", required = true)
    private Long roleId;

    @ApiModelProperty(value = "角色id组", example = "1", required = true)
    private List<Long> roleIds;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAdminId() {
        return adminId;
    }

    public void setAdminId(Long adminId) {
        this.adminId = adminId;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public List<Long> getRoleIds() {
        return roleIds;
    }

    public void setRoleIds(List<Long> roleIds) {
        this.roleIds = roleIds;
    }

    @Override
    public String toString() {
        return "SysAdminRole{" +
                "id=" + id +
                ", adminId=" + adminId +
                ", roleId=" + roleId +
                ", roleIds=" + roleIds +
                '}';
    }
}