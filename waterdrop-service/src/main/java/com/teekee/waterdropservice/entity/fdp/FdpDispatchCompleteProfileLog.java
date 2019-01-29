package com.teekee.waterdropservice.entity.fdp;

import java.util.Date;

public class FdpDispatchCompleteProfileLog extends ParamCompleteConfirm {
    private Integer id;

    private Integer dispatchOrderId;

    private Integer faultDispatchRequestId;

    private String userCompleteProfileFile;

    private String userCompleteProfileFileName;

    private String userCompleteProfilePhoto;

    private String userCompleteProfilePhotoName;

    private Date userCompleteTime;

    private String userJobPerformance;

    private String userJobEndReason;

    private Date createTime;

    private Integer completeProfileUserId;

    private String completeProfileUserType;

    private String userAssmMemo;

    public String getUserAssmMemo() {
        return userAssmMemo;
    }

    public void setUserAssmMemo(String userAssmMemo) {
        this.userAssmMemo = userAssmMemo;
    }

    public Integer getCompleteProfileUserId() {
        return completeProfileUserId;
    }

    public void setCompleteProfileUserId(Integer completeProfileUserId) {
        this.completeProfileUserId = completeProfileUserId;
    }

    public String getCompleteProfileUserType() {
        return completeProfileUserType;
    }

    public void setCompleteProfileUserType(String completeProfileUserType) {
        this.completeProfileUserType = completeProfileUserType;
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

    public Integer getFaultDispatchRequestId() {
        return faultDispatchRequestId;
    }

    public void setFaultDispatchRequestId(Integer faultDispatchRequestId) {
        this.faultDispatchRequestId = faultDispatchRequestId;
    }

    public String getUserCompleteProfileFile() {
        return userCompleteProfileFile;
    }

    public void setUserCompleteProfileFile(String userCompleteProfileFile) {
        this.userCompleteProfileFile = userCompleteProfileFile == null ? null : userCompleteProfileFile.trim();
    }

    public String getUserCompleteProfileFileName() {
        return userCompleteProfileFileName;
    }

    public void setUserCompleteProfileFileName(String userCompleteProfileFileName) {
        this.userCompleteProfileFileName = userCompleteProfileFileName == null ? null : userCompleteProfileFileName.trim();
    }

    public String getUserCompleteProfilePhoto() {
        return userCompleteProfilePhoto;
    }

    public void setUserCompleteProfilePhoto(String userCompleteProfilePhoto) {
        this.userCompleteProfilePhoto = userCompleteProfilePhoto == null ? null : userCompleteProfilePhoto.trim();
    }

    public String getUserCompleteProfilePhotoName() {
        return userCompleteProfilePhotoName;
    }

    public void setUserCompleteProfilePhotoName(String userCompleteProfilePhotoName) {
        this.userCompleteProfilePhotoName = userCompleteProfilePhotoName == null ? null : userCompleteProfilePhotoName.trim();
    }

    public Date getUserCompleteTime() {
        return userCompleteTime;
    }

    public void setUserCompleteTime(Date userCompleteTime) {
        this.userCompleteTime = userCompleteTime;
    }

    public String getUserJobPerformance() {
        return userJobPerformance;
    }

    public void setUserJobPerformance(String userJobPerformance) {
        this.userJobPerformance = userJobPerformance == null ? null : userJobPerformance.trim();
    }

    public String getUserJobEndReason() {
        return userJobEndReason;
    }

    public void setUserJobEndReason(String userJobEndReason) {
        this.userJobEndReason = userJobEndReason == null ? null : userJobEndReason.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}