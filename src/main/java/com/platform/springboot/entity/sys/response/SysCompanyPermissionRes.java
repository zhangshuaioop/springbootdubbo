package com.platform.springboot.entity.sys.response;

import com.platform.springboot.base.BaseTreeGrid;
import com.platform.springboot.base.BaseTreeGrid;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

@ApiModel(value = "系统权限资源表")
public class SysCompanyPermissionRes extends BaseTreeGrid {


    @ApiModelProperty(value = "资源的中文解释", example = "1", required = true)
    private String name;

    @ApiModelProperty(value = "资源路径", example = "1", required = true)
    private String url;

    @ApiModelProperty(value = "级别", example = "1", required = true)
    private Integer level;


    @ApiModelProperty(value = "排序", example = "1", required = true)
    private Integer orderId;

    @ApiModelProperty(value = "创建时间", example = "1", required = true)
    private Date createTime;

    @ApiModelProperty(value = "更新时间", example = "1", required = true)
    private Date updateTime;

    @ApiModelProperty(value = "是否删除", example = "1", required = true)
    private Boolean flagDeleted;


    @ApiModelProperty(value = "公司id", example = "1", required = true)
    private Integer companyId;

    @ApiModelProperty(value = "用户id", example = "1", required = true)
    private Integer userId;

    @ApiModelProperty(value = "是否选中： true选中，false未选中", example = "1", required = true)
    private boolean flagSelect;

    @ApiModelProperty(value = "接口地址", example = "1", required = true)
    private String apiUrl;

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

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public boolean isFlagSelect() {
        return flagSelect;
    }

    public void setFlagSelect(boolean flagSelect) {
        this.flagSelect = flagSelect;
    }

    public String getApiUrl() {
        return apiUrl;
    }

    public void setApiUrl(String apiUrl) {
        this.apiUrl = apiUrl;
    }

    @Override
    public String toString() {
        return "SysCompanyPermissionRes{" +
                "name='" + name + '\'' +
                ", url='" + url + '\'' +
                ", level=" + level +
                ", orderId=" + orderId +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", flagDeleted=" + flagDeleted +
                ", companyId=" + companyId +
                ", userId=" + userId +
                ", flagSelect=" + flagSelect +
                ", apiUrl='" + apiUrl + '\'' +
                '}';
    }
}