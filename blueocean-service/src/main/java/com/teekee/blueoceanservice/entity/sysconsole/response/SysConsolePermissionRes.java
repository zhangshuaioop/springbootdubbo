package com.teekee.blueoceanservice.entity.sysconsole.response;

import com.teekee.commoncomponets.base.BaseTreeGrid;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

@ApiModel(value = "平台模式权限功能表树")
public class SysConsolePermissionRes extends BaseTreeGrid {

    @ApiModelProperty(value = "id", example = "1", required = true)
    private Integer id;

    @ApiModelProperty(value = "名称", example = "1", required = true)
    private String name;

    @ApiModelProperty(value = "路由", example = "1", required = true)
    private String path;

    @ApiModelProperty(value = "路径", example = "1", required = true)
    private String url;

    @ApiModelProperty(value = "图标", example = "1", required = true)
    private String icon;

    @ApiModelProperty(value = "页面路径", example = "1", required = true)
    private String component;

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

    @ApiModelProperty(value = "是否删除0正常1删除", example = "1", required = true)
    private Boolean flagDeleted;

    @ApiModelProperty(value = "vue权限所需对象", example = "1", required = true)
    private Meta meta;

    @ApiModelProperty(value = "用户id", example = "1", required = true)
    private Integer userId;

    @ApiModelProperty(value = "是否菜单栏1是0不是", example = "1", required = true)
    private Boolean flagIsMenu;

    @ApiModelProperty(value = "是否选中： true选中，false未选中", example = "1", required = true)
    private boolean selected;

    @ApiModelProperty(value = "是否选中： true选中，false未选中", example = "1", required = true)
    private boolean checked;



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

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getComponent() {
        return component;
    }

    public void setComponent(String component) {
        this.component = component;
    }

    public Meta getMeta() {
        return meta;
    }

    public void setMeta(Meta meta) {
        this.meta = meta;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Boolean getFlagIsMenu() {
        return flagIsMenu;
    }

    public void setFlagIsMenu(Boolean flagIsMenu) {
        this.flagIsMenu = flagIsMenu;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }


    @Override
    public String toString() {
        return "SysConsolePermissionRes{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", path='" + path + '\'' +
                ", url='" + url + '\'' +
                ", icon='" + icon + '\'' +
                ", component='" + component + '\'' +
                ", level=" + level +
                ", parentId=" + parentId +
                ", orderId=" + orderId +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", flagDeleted=" + flagDeleted +
                ", meta=" + meta +
                ", userId=" + userId +
                ", flagIsMenu=" + flagIsMenu +
                ", selected=" + selected +
                ", checked=" + checked +
                '}';
    }
}