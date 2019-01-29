package com.teekee.blueoceanservice.entity.sysconsole.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @description: vue权限所需对象
 * @author: zhangshuai
 * @create: 2019-01-09 11:56
 */
@ApiModel(value = "vue权限所需对象")
public class Meta {

    /**
     * 当前页面是否缓存
     */
    @ApiModelProperty(value = "当前页面是否缓存", example = "1", required = true)
    private Boolean notCache = true;

    /**
     * 是否显示面包削
     */
    @ApiModelProperty(value = "是否显示面包削", example = "1", required = true)
    private Boolean hideInBread = false;

    /**
     * 是否显示菜单
     */
    @ApiModelProperty(value = "是否显示菜单", example = "1", required = true)
    private Boolean hideInMenu = false;

    /**
     * 图标
     */
    @ApiModelProperty(value = "图标", example = "1", required = true)
    private String icon;

    /**
     * 标题
     */
    @ApiModelProperty(value = "标题", example = "1", required = true)
    private String title;


    public Boolean getNotCache() {
        return notCache;
    }

    public void setNotCache(Boolean notCache) {
        this.notCache = notCache;
    }

    public Boolean getHideInBread() {
        return hideInBread;
    }

    public void setHideInBread(Boolean hideInBread) {
        this.hideInBread = hideInBread;
    }

    public Boolean getHideInMenu() {
        return hideInMenu;
    }

    public void setHideInMenu(Boolean hideInMenu) {
        this.hideInMenu = hideInMenu;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    @Override
    public String toString() {
        return "Meta{" +
                "notCache=" + notCache +
                ", hideInBread=" + hideInBread +
                ", hideInMenu=" + hideInMenu +
                ", icon='" + icon + '\'' +
                ", title='" + title + '\'' +
                '}';
    }
}
