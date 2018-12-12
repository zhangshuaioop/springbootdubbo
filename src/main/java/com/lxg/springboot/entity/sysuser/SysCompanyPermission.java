package com.lxg.springboot.entity.sysuser;

import com.lxg.springboot.base.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

@ApiModel(value = "系统权限资源表")
public class SysCompanyPermission extends BaseEntity {

    @ApiModelProperty(value = "id", example = "1", required = true)
    private Integer id;

    @ApiModelProperty(value = "资源的中文解释", example = "1", required = true)
    private String name;

    @ApiModelProperty(value = "资源路径", example = "1", required = true)
    private String url;

    @ApiModelProperty(value = "级别", example = "1", required = true)
    private Integer level;

    @ApiModelProperty(value = "父id", example = "1", required = true)
    private Integer parentId;

    @ApiModelProperty(value = "排序", example = "1", required = true)
    private Integer orderId;

    @ApiModelProperty(value = "创建时间", example = "1", required = true)
    private Date createTime;

    @ApiModelProperty(value = "更新时间", example = "1", required = true)
    private Date updateTime;

    @ApiModelProperty(value = "是否删除", example = "1", required = true)
    private Boolean flagDeleted;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
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
}