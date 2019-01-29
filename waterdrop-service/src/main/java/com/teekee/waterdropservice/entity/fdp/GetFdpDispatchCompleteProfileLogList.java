package com.teekee.waterdropservice.entity.fdp;/**
 * @Author Niting
 * @Create 2018/5/10
 */

import java.util.Date;

/**
 *
 *@Author Niting
 *@date 2018/5/10
 **/
public class GetFdpDispatchCompleteProfileLogList extends FdpFaultDispatchHrRelation {
    private Integer faultDispatchRequestId;

    private String userCompleteProfileFile;

    private String userCompleteProfileFileName;

    private String userCompleteProfilePhoto;

    private String userCompleteProfilePhotoName;

    private Date userCompleteTime;

    private String memo;

    private String dispatchDescription;

    public Integer getFaultDispatchRequestId() {
        return faultDispatchRequestId;
    }

    public void setFaultDispatchRequestId(Integer faultDispatchRequestId) {
        this.faultDispatchRequestId = faultDispatchRequestId;
    }

    public String getDispatchDescription() {
        return dispatchDescription;
    }

    public void setDispatchDescription(String dispatchDescription) {
        this.dispatchDescription = dispatchDescription;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public String getUserCompleteProfileFile() {
        return userCompleteProfileFile;
    }

    public void setUserCompleteProfileFile(String userCompleteProfileFile) {
        this.userCompleteProfileFile = userCompleteProfileFile;
    }

    public String getUserCompleteProfileFileName() {
        return userCompleteProfileFileName;
    }

    public void setUserCompleteProfileFileName(String userCompleteProfileFileName) {
        this.userCompleteProfileFileName = userCompleteProfileFileName;
    }

    public String getUserCompleteProfilePhoto() {
        return userCompleteProfilePhoto;
    }

    public void setUserCompleteProfilePhoto(String userCompleteProfilePhoto) {
        this.userCompleteProfilePhoto = userCompleteProfilePhoto;
    }

    public String getUserCompleteProfilePhotoName() {
        return userCompleteProfilePhotoName;
    }

    public void setUserCompleteProfilePhotoName(String userCompleteProfilePhotoName) {
        this.userCompleteProfilePhotoName = userCompleteProfilePhotoName;
    }

    public Date getUserCompleteTime() {
        return userCompleteTime;
    }

    public void setUserCompleteTime(Date userCompleteTime) {
        this.userCompleteTime = userCompleteTime;
    }
}
