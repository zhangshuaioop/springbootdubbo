package com.platform.springboot.entity.cfg;

import com.platform.springboot.base.BaseEntity;

import java.util.List;

public class CfgDispatchDetailConfig extends BaseEntity {
    private Integer id;

    private String dispatchType;

    private String title;

    private String catalogName;

    private Integer level;

    private Integer parentId;

    private Integer orderId;

    private String description;

    private int modelId;

    private List<CfgDispatchDetailConfig> children;

    public List<CfgDispatchDetailConfig> getChildren() {
        return children;
    }

    public void setChildren(List<CfgDispatchDetailConfig> children) {
        this.children = children;
    }

    public int getModelId() {
        return modelId;
    }

    public void setModelId(int modelId) {
        this.modelId = modelId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDispatchType() {
        return dispatchType;
    }

    public void setDispatchType(String dispatchType) {
        this.dispatchType = dispatchType == null ? null : dispatchType.trim();
    }
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }


    public String getCatalogName() {
        return catalogName;
    }

    public void setCatalogName(String catalogName) {
        this.catalogName = catalogName == null ? null : catalogName.trim();
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

}