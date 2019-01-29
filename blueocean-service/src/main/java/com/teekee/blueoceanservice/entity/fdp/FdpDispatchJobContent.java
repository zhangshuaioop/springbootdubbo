package com.teekee.blueoceanservice.entity.fdp;

import java.util.Date;

public class FdpDispatchJobContent {
    private Integer id;

    private Integer dispatchOrderId;

    private Integer dispatchRequestId;

    private Integer requestHistoryId;

    private Integer jobDefineVersion;

    private Integer jobStepIndex;

    private String jobStepDescription;

    private Boolean flagIsLast;

    private Date createTime;

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

    public Integer getDispatchRequestId() {
        return dispatchRequestId;
    }

    public void setDispatchRequestId(Integer dispatchRequestId) {
        this.dispatchRequestId = dispatchRequestId;
    }

    public Integer getRequestHistoryId() {
        return requestHistoryId;
    }

    public void setRequestHistoryId(Integer requestHistoryId) {
        this.requestHistoryId = requestHistoryId;
    }

    public Integer getJobDefineVersion() {
        return jobDefineVersion;
    }

    public void setJobDefineVersion(Integer jobDefineVersion) {
        this.jobDefineVersion = jobDefineVersion;
    }

    public Integer getJobStepIndex() {
        return jobStepIndex;
    }

    public void setJobStepIndex(Integer jobStepIndex) {
        this.jobStepIndex = jobStepIndex;
    }

    public String getJobStepDescription() {
        return jobStepDescription;
    }

    public void setJobStepDescription(String jobStepDescription) {
        this.jobStepDescription = jobStepDescription == null ? null : jobStepDescription.trim();
    }

    public Boolean getFlagIsLast() {
        return flagIsLast;
    }

    public void setFlagIsLast(Boolean flagIsLast) {
        this.flagIsLast = flagIsLast;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}