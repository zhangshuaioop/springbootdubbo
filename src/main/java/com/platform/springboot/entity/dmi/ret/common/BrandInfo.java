package com.platform.springboot.entity.dmi.ret.common;

import io.swagger.annotations.ApiModelProperty;

/**
 * 挺返回参数携带品牌，区域，子品牌的返回类
 *
 * @author Wujun
 * @create 2017年08月31日 9:43
 */
public class BrandInfo {
    @ApiModelProperty(value = "品牌", example = "1", required = true)
    private String brandName;

    private String areaName;

    private String subBrandName;

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public String getSubBrandName() {
        return subBrandName;
    }

    public void setSubBrandName(String subBrandName) {
        this.subBrandName = subBrandName;
    }
}
