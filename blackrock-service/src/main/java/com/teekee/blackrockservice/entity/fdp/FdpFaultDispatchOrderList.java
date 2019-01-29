package com.teekee.blackrockservice.entity.fdp;


public class FdpFaultDispatchOrderList {

    private FdpFaultDispatchOrderInfo orderInfo;

    private FdpDispatchJobPerformanceList jobPerformanceList;

    private FdpFaultDispatchHrRelation hrRelation;

    public FdpFaultDispatchHrRelation getHrRelation() {
        return hrRelation;
    }

    public void setHrRelation(FdpFaultDispatchHrRelation hrRelation) {
        this.hrRelation = hrRelation;
    }

    public FdpFaultDispatchOrderInfo getOrderInfo() {
        return orderInfo;
    }

    public void setOrderInfo(FdpFaultDispatchOrderInfo orderInfo) {
        this.orderInfo = orderInfo;
    }

    public FdpDispatchJobPerformanceList getJobPerformanceList() {
        return jobPerformanceList;
    }

    public void setJobPerformanceList(FdpDispatchJobPerformanceList jobPerformanceList) {
        this.jobPerformanceList = jobPerformanceList;
    }
}
