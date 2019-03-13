package com.company.springboot.entity.trc;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;
import java.util.Date;

@ApiModel(value = "设备GPS地址位置日志表")
public class TrcDeviceGpsLog {

    @ApiModelProperty(value = "id", example = "1", required = true)
    private Integer id;

    @ApiModelProperty(value = "HR表的ID", example = "", required = true)
    private Integer hrId;

    @ApiModelProperty(value = "设备唯一标示", example = "", required = true)
    private String imei;

    @ApiModelProperty(value = "设备SN", example = "", required = true)
    private String sn;

    @ApiModelProperty(value = "经度", example = "", required = true)
    private BigDecimal longitude;

    @ApiModelProperty(value = "纬度", example = "", required = true)
    private BigDecimal latitude;

    @ApiModelProperty(value = "采集时间", example = "", required = true)
    private Date gatherTime;

    @ApiModelProperty(value = "创建时间", example = "", required = true)
    private Date createTime;

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

    public String getImei() {
        return imei;
    }

    public void setImei(String imei) {
        this.imei = imei;
    }

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn;
    }

    public BigDecimal getLongitude() {
        return longitude;
    }

    public void setLongitude(BigDecimal longitude) {
        this.longitude = longitude;
    }

    public BigDecimal getLatitude() {
        return latitude;
    }

    public void setLatitude(BigDecimal latitude) {
        this.latitude = latitude;
    }

    public Date getGatherTime() {
        return gatherTime;
    }

    public void setGatherTime(Date gatherTime) {
        this.gatherTime = gatherTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "TrcDeviceGpsLog{" +
                "id=" + id +
                ", hrId=" + hrId +
                ", imei='" + imei + '\'' +
                ", sn='" + sn + '\'' +
                ", longitude=" + longitude +
                ", latitude=" + latitude +
                ", gatherTime=" + gatherTime +
                ", createTime=" + createTime +
                '}';
    }
}