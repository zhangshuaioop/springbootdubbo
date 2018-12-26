package com.platform.springboot.entity.sysconsole;

import com.platform.springboot.base.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

@ApiModel(value = "平台模式功能对应接口表")
public class SysConsolePermissionApiRelation extends BaseEntity {

    @ApiModelProperty(value = "id", example = "1", required = true)
    private Integer id;

    @ApiModelProperty(value = "权限id", example = "1", required = true)
    private Integer permissionId;

    @ApiModelProperty(value = "接口Id", example = "1", required = true)
    private Integer apiId;

    @ApiModelProperty(value = "创建时间", example = "1", required = true)
    private Date createTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(Integer permissionId) {
        this.permissionId = permissionId;
    }

    public Integer getApiId() {
        return apiId;
    }

    public void setApiId(Integer apiId) {
        this.apiId = apiId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "SysConsolePermissionApiRelation{" +
                "id=" + id +
                ", permissionId=" + permissionId +
                ", apiId=" + apiId +
                ", createTime=" + createTime +
                '}';
    }
}