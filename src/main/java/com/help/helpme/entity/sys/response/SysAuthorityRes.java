package com.help.helpme.entity.sys.response;

import com.help.helpme.base.BaseTreeGrid;

/**
 * @description: 权限树
 * @author: zhangshuai
 * @create: 2019-01-31 13:53
 */
public class SysAuthorityRes extends BaseTreeGrid {

    private String name;

    private String description;

    private String url;

    //是否选中
    private Boolean flagEnabled;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Boolean getFlagEnabled() {
        return flagEnabled;
    }

    public void setFlagEnabled(Boolean flagEnabled) {
        this.flagEnabled = flagEnabled;
    }

    @Override
    public String toString() {
        return "SysAuthorityRes{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", url='" + url + '\'' +
                ", flagEnabled=" + flagEnabled +
                '}';
    }
}
