package com.company.springboot.entity.sys.response;

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
     * vue权限自定义id
     */
    private Integer id;

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


    public Boolean showAlways;//是否显示父级vue


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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Boolean getShowAlways() {
        return showAlways;
    }

    public void setShowAlways(Boolean showAlways) {
        this.showAlways = showAlways;
    }

    @Override
    public String toString() {
        return "Meta{" +
                "id=" + id +
                ", notCache=" + notCache +
                ", hideInBread=" + hideInBread +
                ", hideInMenu=" + hideInMenu +
                ", icon='" + icon + '\'' +
                ", title='" + title + '\'' +
                ", showAlways=" + showAlways +
                '}';
    }
}
