package com.company.springboot.entity.fdp;

import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

public class FdpDispatchServiceProcessLog {

    @ApiModelProperty(value = "ID", example = "1", required = true)
    private Integer id;
    @ApiModelProperty(value = "派工订单ID", example = "1", required = true)
    private Integer dispatchOrderId;
    @ApiModelProperty(value = "服务商ID", example = "1", required = true)
    private Integer hrId;
    @ApiModelProperty(value = "操作时间", example = "1", required = true)
    private Date operateTime;
    @ApiModelProperty(value = "操作描述", example = "1", required = true)
    private String operateDescription;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDispatchOrderId() {
        return dispatchOrderId;
    }

    public void setDispatchOrderId(Integer dispatchOrderId) {
        this.dispatchOrderId = dispatchOrderId;
    }

    public Integer getHrId() {
        return hrId;
    }

    public void setHrId(Integer hrId) {
        this.hrId = hrId;
    }

    public Date getOperateTime() {
        return operateTime;
    }

    public void setOperateTime(Date operateTime) {
        this.operateTime = operateTime;
    }

    public String getOperateDescription() {
        return operateDescription;
    }

    public void setOperateDescription(String operateDescription) {
        this.operateDescription = operateDescription;
    }

    @Override
    public String toString() {
        return "FdpDispatchServiceProcessLog{" +
                "id=" + id +
                ", dispatchOrderId=" + dispatchOrderId +
                ", hrId=" + hrId +
                ", operateTime=" + operateTime +
                ", operateDescription='" + operateDescription + '\'' +
                '}';
    }
}
