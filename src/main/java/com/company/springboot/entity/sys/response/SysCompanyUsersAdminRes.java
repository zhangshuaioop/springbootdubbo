package com.company.springboot.entity.sys.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @description: 超级管理员
 * @author: zhangshuai
 * @create: 2019-01-08 16:57
 */
@ApiModel(value = "超级管理员")
public class SysCompanyUsersAdminRes {

    @ApiModelProperty(value = "id", example = "1", required = true)
    private Integer id;

    @ApiModelProperty(value = "角色id", example = "1", required = true)
    private Integer roleId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }


    @Override
    public String toString() {
        return "SysCompanyUsersAdminRes{" +
                "id=" + id +
                ", roleId=" + roleId +
                '}';
    }
}
