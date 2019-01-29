package com.teekee.blueoceanservice.entity.fdp;

import java.util.Date;
import java.util.List;

public class FdpDispatchJobPerformance {
    private Integer id;

    private Integer dispatchOrderId;

    private Integer dispatchRequestId;

    private Integer jobStepIndex;

    private String jobStepDescription;

    private String workConditionPhoto;

    private String workConditionPhotoName;

    private Integer jobPerformanceVersion;

    private Integer jobDefineVersion;

    private Boolean flagJobFinish;

    private Boolean flagIsLast;

    private String jobPerformanceDescription;

    private String voiceLogUrl;

    private String voiceLogLength;

    private String voiceLogTime;

    private Date createTime;

    private boolean flagUsed;

    private List<GetFdpJobPerformanceVoice> voiceList;

    public List<GetFdpJobPerformanceVoice> getVoiceList() {
        return voiceList;
    }

    public void setVoiceList(List<GetFdpJobPerformanceVoice> voiceList) {
        this.voiceList = voiceList;
    }

    public boolean isFlagUsed() {
        return flagUsed;
    }

    public void setFlagUsed(boolean flagUsed) {
        this.flagUsed = flagUsed;
    }

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

    public String getWorkConditionPhoto() {
        return workConditionPhoto;
    }

    public void setWorkConditionPhoto(String workConditionPhoto) {
        this.workConditionPhoto = workConditionPhoto == null ? null : workConditionPhoto.trim();
    }

    public String getWorkConditionPhotoName() {
        return workConditionPhotoName;
    }

    public void setWorkConditionPhotoName(String workConditionPhotoName) {
        this.workConditionPhotoName = workConditionPhotoName == null ? null : workConditionPhotoName.trim();
    }

    public Integer getJobPerformanceVersion() {
        return jobPerformanceVersion;
    }

    public void setJobPerformanceVersion(Integer jobPerformanceVersion) {
        this.jobPerformanceVersion = jobPerformanceVersion;
    }

    public Boolean getFlagJobFinish() {
        return flagJobFinish;
    }

    public void setFlagJobFinish(Boolean flagJobFinish) {
        this.flagJobFinish = flagJobFinish;
    }

    public Boolean getFlagIsLast() {
        return flagIsLast;
    }

    public void setFlagIsLast(Boolean flagIsLast) {
        this.flagIsLast = flagIsLast;
    }

    public String getJobPerformanceDescription() {
        return jobPerformanceDescription;
    }

    public void setJobPerformanceDescription(String jobPerformanceDescription) {
        this.jobPerformanceDescription = jobPerformanceDescription == null ? null : jobPerformanceDescription.trim();
    }

    public String getVoiceLogUrl() {
        return voiceLogUrl;
    }

    public void setVoiceLogUrl(String voiceLogUrl) {
        this.voiceLogUrl = voiceLogUrl == null ? null : voiceLogUrl.trim();
    }

    public String getVoiceLogLength() {
        return voiceLogLength;
    }

    public void setVoiceLogLength(String voiceLogLength) {
        this.voiceLogLength = voiceLogLength == null ? null : voiceLogLength.trim();
    }

    public String getVoiceLogTime() {
        return voiceLogTime;
    }

    public void setVoiceLogTime(String voiceLogTime) {
        this.voiceLogTime = voiceLogTime == null ? null : voiceLogTime.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getJobDefineVersion() {
        return jobDefineVersion;
    }

    public void setJobDefineVersion(Integer jobDefineVersion) {
        this.jobDefineVersion = jobDefineVersion;
    }
}