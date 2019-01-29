package com.teekee.blackrockservice.entity.cfg;

import io.swagger.annotations.ApiModel;

/**
 * @Author Niting
 * @date 2018/7/24
 **/
@ApiModel("地区list")
public class CfgRegionList {
    private Integer id;
    private String regionName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }
}
