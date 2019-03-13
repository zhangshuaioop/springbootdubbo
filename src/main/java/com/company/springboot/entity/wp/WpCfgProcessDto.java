package com.company.springboot.entity.wp;

import com.company.springboot.base.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

@ApiModel(value = "流程步骤和连接线")
public class WpCfgProcessDto extends BaseEntity {


    @ApiModelProperty(value = "流程步骤配置", example = "1", required = true)
    List<WpCfgProcessStep> listProStep;

    @ApiModelProperty(value = "流程步骤间的连接线", example = "1", required = true)
    List<WpCfgProcessStepLine> listProStepLine;

    public List<WpCfgProcessStep> getListProStep() {
        return listProStep;
    }

    public void setListProStep(List<WpCfgProcessStep> listProStep) {
        this.listProStep = listProStep;
    }

    public List<WpCfgProcessStepLine> getListProStepLine() {
        return listProStepLine;
    }

    public void setListProStepLine(List<WpCfgProcessStepLine> listProStepLine) {
        this.listProStepLine = listProStepLine;
    }

    @Override
    public String toString() {
        return "WpCfgProcessDto{" +
                "listProStep=" + listProStep +
                ", listProStepLine=" + listProStepLine +
                '}';
    }
}