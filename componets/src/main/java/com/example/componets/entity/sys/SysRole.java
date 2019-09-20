package com.example.componets.entity.sys;

import com.example.componets.base.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;
import java.util.List;

@ApiModel(value = "系统角色")
public class SysRole extends BaseEntity {
    @ApiModelProperty(value = "id", example = "1", required = true)
    private Long id;

    @ApiModelProperty(value = "角色名称", example = "1", required = true)
    private String name;

    @ApiModelProperty(value = "是否启用0禁用1启用", example = "1", required = true)
    private Boolean flagEnabled;

    @ApiModelProperty(value = "是否删除0未删除1删除", example = "1", required = true)
    private Boolean flagDelete;

    @ApiModelProperty(value = "描述", example = "1", required = true)
    private String description;

    @ApiModelProperty(value = "创建时间", example = "1", required = true)
    private Date createDate;

    @ApiModelProperty(value = "更新时间", example = "1", required = true)
    private Date updateDate;

    @ApiModelProperty(value = "全局搜索", example = "1", required = true)
    private String search;

    @ApiModelProperty(value = "权限ids", example = "1", required = true)
    private List<Long> authorityIds;

    //用户id
    private Long adminId;

    //是否选中
    private Boolean flagSelect;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
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

    public String getSearch() {
        return search;
    }

    public void setSearch(String search) {
        this.search = search;
    }


    public List<Long> getAuthorityIds() {
        return authorityIds;
    }

    public void setAuthorityIds(List<Long> authorityIds) {
        this.authorityIds = authorityIds;
    }

    public Long getAdminId() {
        return adminId;
    }

    public void setAdminId(Long adminId) {
        this.adminId = adminId;
    }

    public Boolean getFlagSelect() {
        return flagSelect;
    }

    public void setFlagSelect(Boolean flagSelect) {
        this.flagSelect = flagSelect;
    }

    @Override
    public String toString() {
        return "SysRole{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", flagEnabled=" + flagEnabled +
                ", flagDelete=" + flagDelete +
                ", description='" + description + '\'' +
                ", createDate=" + createDate +
                ", updateDate=" + updateDate +
                ", search='" + search + '\'' +
                ", authorityIds=" + authorityIds +
                ", adminId=" + adminId +
                ", flagSelect=" + flagSelect +
                '}';
    }
}