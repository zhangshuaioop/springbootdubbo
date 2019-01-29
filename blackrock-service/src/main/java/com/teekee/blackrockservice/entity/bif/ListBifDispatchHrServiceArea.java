package com.teekee.blackrockservice.entity.bif;

import com.teekee.commoncomponets.base.BaseEntity;
import io.swagger.annotations.ApiModel;

/**
 * @Author Niting
 * @date 2018/7/20
 **/
@ApiModel("服务商服务区域列表")
public class ListBifDispatchHrServiceArea extends BaseEntity{
    private Integer id;

    private Integer hrId;

    private String province;

    private String city;

    private Boolean flagDefault;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getHrId() {
        return hrId;
    }

    public void setHrId(Integer hrId) {
        this.hrId = hrId;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Boolean getFlagDefault() {
        return flagDefault;
    }

    public void setFlagDefault(Boolean flagDefault) {
        this.flagDefault = flagDefault;
    }
}
