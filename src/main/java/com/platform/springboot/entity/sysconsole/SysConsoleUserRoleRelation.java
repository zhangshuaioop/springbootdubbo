package com.platform.springboot.entity.sysconsole;

import com.platform.springboot.base.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

@ApiModel(value = "平台账号角色表")
public class SysConsoleUserRoleRelation extends BaseEntity {

    @ApiModelProperty(value = "id", example = "1", required = true)
    private Integer id;

    @ApiModelProperty(value = "用户id", example = "1", required = true)
    private Integer userId;

    @ApiModelProperty(value = "角色id", example = "1", required = true)
    private Integer roleId;

    @ApiModelProperty(value = "创建时间", example = "1", required = true)
    private Date createTime;

    @ApiModelProperty(value = "创建人id", example = "1", required = true)
    private Integer createPerson;

    @ApiModelProperty(value = "是否删除0正常1删除", example = "1", required = true)
    private Boolean flagDeleted;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getCreatePerson() {
        return createPerson;
    }

    public void setCreatePerson(Integer createPerson) {
        this.createPerson = createPerson;
    }

    public Boolean getFlagDeleted() {
        return flagDeleted;
    }

    public void setFlagDeleted(Boolean flagDeleted) {
        this.flagDeleted = flagDeleted;
    }

    @Override
    public String toString() {
        return "SysConsoleUserRoleRelation{" +
                "id=" + id +
                ", userId=" + userId +
                ", roleId=" + roleId +
                ", createTime=" + createTime +
                ", createPerson=" + createPerson +
                ", flagDeleted=" + flagDeleted +
                '}';
    }
}