package com.teekee.blueoceanservice.entity.cfg;

import com.teekee.commoncomponets.base.BaseTreeGrid;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

@ApiModel(value = "细则")
public class CfgDispatchRouteDetail extends BaseTreeGrid {

    @ApiModelProperty(value = "规则id", example = "1", required = true)
    private Integer routeId;

    @ApiModelProperty(value = "细则id", example = "1", required = true)
    private Integer detailId;

    @ApiModelProperty(value = "省名称", example = "1", required = true)
    private String province;

    @ApiModelProperty(value = "区域名称", example = "1", required = true)
    private String region;

    @ApiModelProperty(value = "紧急分配人员", example = "1", required = true)
    private String emergencyPerson;

    @ApiModelProperty(value = "不急分配人员", example = "1", required = true)
    private String noEmergencyPerson;

    @ApiModelProperty(value = "是否默认规则0不是1是", example = "1", required = true)
    private Boolean flagDefault;

    @ApiModelProperty(value = "提示颜色", example = "1", required = true)
    private String colour;

    @ApiModelProperty(value = "创建时间", example = "1", required = true)
    private Date createTime;

    @ApiModelProperty(value = "创建人", example = "1", required = true)
    private Integer createPerson;

    @ApiModelProperty(value = "1选中0未选中", example = "1", required = true)
    private Boolean checkStatus;

    public Integer getRouteId() {
        return routeId;
    }

    public void setRouteId(Integer routeId) {
        this.routeId = routeId;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province == null ? null : province.trim();
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region == null ? null : region.trim();
    }

    public String getEmergencyPerson() {
        return emergencyPerson;
    }

    public void setEmergencyPerson(String emergencyPerson) {
        this.emergencyPerson = emergencyPerson == null ? null : emergencyPerson.trim();
    }

    public String getNoEmergencyPerson() {
        return noEmergencyPerson;
    }

    public void setNoEmergencyPerson(String noEmergencyPerson) {
        this.noEmergencyPerson = noEmergencyPerson == null ? null : noEmergencyPerson.trim();
    }

    public Boolean getFlagDefault() {
        return flagDefault;
    }

    public void setFlagDefault(Boolean flagDefault) {
        this.flagDefault = flagDefault;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour == null ? null : colour.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getCreatePerson() {
        return createPerson;
    }

    public void setCreatePerson(Integer createPerson) {
        this.createPerson = createPerson;
    }

    public Integer getDetailId() {
        return detailId;
    }

    public void setDetailId(Integer detailId) {
        this.detailId = detailId;
    }

    public Boolean getCheckStatus() {
        return checkStatus;
    }

    public void setCheckStatus(Boolean checkStatus) {
        this.checkStatus = checkStatus;
    }

    @Override
    public String toString() {
        return "CfgDispatchRouteDetail{" +
                "routeId=" + routeId +
                ", detailId=" + detailId +
                ", province='" + province + '\'' +
                ", region='" + region + '\'' +
                ", emergencyPerson='" + emergencyPerson + '\'' +
                ", noEmergencyPerson='" + noEmergencyPerson + '\'' +
                ", flagDefault=" + flagDefault +
                ", colour='" + colour + '\'' +
                ", createTime=" + createTime +
                ", createPerson=" + createPerson +
                ", checkStatus=" + checkStatus +
                '}';
    }
}