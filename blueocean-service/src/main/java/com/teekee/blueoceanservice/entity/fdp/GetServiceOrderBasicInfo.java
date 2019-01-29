package com.teekee.blueoceanservice.entity.fdp;

import java.util.Date;

/**
 * @Author Niting
 * @date 2018/8/22
 **/
public class GetServiceOrderBasicInfo {
    private String dispatchOrderNumber;
    private Date estimatedServiceTime;
    private Date hrFinishServiceTime;

    public String getDispatchOrderNumber() {
        return dispatchOrderNumber;
    }

    public void setDispatchOrderNumber(String dispatchOrderNumber) {
        this.dispatchOrderNumber = dispatchOrderNumber;
    }

    public Date getEstimatedServiceTime() {
        return estimatedServiceTime;
    }

    public void setEstimatedServiceTime(Date estimatedServiceTime) {
        this.estimatedServiceTime = estimatedServiceTime;
    }

    public Date getHrFinishServiceTime() {
        return hrFinishServiceTime;
    }

    public void setHrFinishServiceTime(Date hrFinishServiceTime) {
        this.hrFinishServiceTime = hrFinishServiceTime;
    }
}
