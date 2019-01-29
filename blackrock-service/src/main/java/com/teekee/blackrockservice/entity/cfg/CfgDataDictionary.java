package com.teekee.blackrockservice.entity.cfg;

import com.teekee.commoncomponets.base.BaseEntity;
import io.swagger.annotations.ApiModel;

@ApiModel("基础数据字典表")
public class CfgDataDictionary extends BaseEntity{
    private Integer id;

    private String type;

    private String value;

    private Integer orderId;

    private String description;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value == null ? null : value.trim();
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }
}