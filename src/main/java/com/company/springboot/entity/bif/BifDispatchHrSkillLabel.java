package com.company.springboot.entity.bif;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

@ApiModel(value = "服务商标签")
public class BifDispatchHrSkillLabel {

    @ApiModelProperty(value = "id", example = "1", required = true)
    private Integer id;

    @ApiModelProperty(value = "名称", example = "1", required = true)
    private String labelName;

    @ApiModelProperty(value = "级别", example = "1", required = true)
    private Integer level;

    @ApiModelProperty(value = "父id", example = "1", required = true)
    private Integer parentId;

    @ApiModelProperty(value = "排序id", example = "1", required = true)
    private Integer orderId;

    @ApiModelProperty(value = "描述", example = "1", required = true)
    private String description;

    @ApiModelProperty(value = "0不选中1选中", example = "1", required = true)
    private Integer isNoSelect;

    @ApiModelProperty(value = "自定义标签", example = "1", required = true)
    private String customLabel;

    private List<BifDispatchHrSkillLabel> child;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLabelName() {
        return labelName;
    }

    public void setLabelName(String labelName) {
        this.labelName = labelName == null ? null : labelName.trim();
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

    public List<BifDispatchHrSkillLabel> getChild() {
        return child;
    }

    public void setChild(List<BifDispatchHrSkillLabel> child) {
        this.child = child;
    }

    public Integer getIsNoSelect() {
        return isNoSelect;
    }

    public void setIsNoSelect(Integer isNoSelect) {
        this.isNoSelect = isNoSelect;
    }

    public String getCustomLabel() {
        return customLabel;
    }

    public void setCustomLabel(String customLabel) {
        this.customLabel = customLabel;
    }
}