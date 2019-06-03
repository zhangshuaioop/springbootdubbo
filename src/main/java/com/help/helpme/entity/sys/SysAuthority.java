package com.help.helpme.entity.sys;

import com.help.helpme.base.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

@ApiModel(value = "系统权限")
public class SysAuthority extends BaseEntity {
    @ApiModelProperty(value = "id", example = "1", required = true)
    private Long id;

    @ApiModelProperty(value = "权限名称", example = "1", required = true)
    private String name;

    @ApiModelProperty(value = "描述", example = "1", required = true)
    private String description;

    @ApiModelProperty(value = "是否启用0禁用1启用", example = "1", required = true)
    private Boolean flagEnabled;

    @ApiModelProperty(value = "是否删除0未删除1删除", example = "1", required = true)
    private Boolean flagDelete;

    @ApiModelProperty(value = "创建时间", example = "1", required = true)
    private Date createDate;

    @ApiModelProperty(value = "更新时间", example = "1", required = true)
    private Date updateDate;

    @ApiModelProperty(value = "路由", example = "1", required = true)
    private String url;

    @ApiModelProperty(value = "图标", example = "1", required = true)
    private String icon;

    //角色id
    private Long roleId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public Boolean getFlagEnabled() {
        return flagEnabled;
    }

    public void setFlagEnabled(Boolean flagEnabled) {
        this.flagEnabled = flagEnabled;
    }

    public Boolean getFlagDelete() {
        return flagDelete;
    }

    public void setFlagDelete(Boolean flagDelete) {
        this.flagDelete = flagDelete;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    @Override
    public String toString() {
        return "SysAuthority{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", flagEnabled=" + flagEnabled +
                ", flagDelete=" + flagDelete +
                ", createDate=" + createDate +
                ", updateDate=" + updateDate +
                ", url='" + url + '\'' +
                ", icon='" + icon + '\'' +
                ", roleId=" + roleId +
                '}';
    }
}