package com.teekee.blackrockservice.entity.fdp;

import io.swagger.annotations.ApiModel;

import java.util.List;

/**
 *@Author Niting
 *@Date 2018/11/07
 **/
@ApiModel("工作内容list")
public class FdpDispatchJobPerformanceList {

    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    private FdpFaultDispatchHrRelation hrRelation;

    public FdpFaultDispatchHrRelation getHrRelation() {
        return hrRelation;
    }

    public void setHrRelation(FdpFaultDispatchHrRelation hrRelation) {
        this.hrRelation = hrRelation;
    }

    private List<FdpDispatchJobPerformance> jobPerformanceLists;

    private String memo;

    private String userJobEndReason;

    public String getUserJobEndReason() {
        return userJobEndReason;
    }

    public void setUserJobEndReason(String userJobEndReason) {
        this.userJobEndReason = userJobEndReason;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public List<FdpDispatchJobPerformance> getJobPerformanceLists() {
        return jobPerformanceLists;
    }

    public void setJobPerformanceLists(List<FdpDispatchJobPerformance> jobPerformanceLists) {
        this.jobPerformanceLists = jobPerformanceLists;
    }
}
