package com.platform.springboot.entity.fdp;



import java.util.Date;

/**
 * @author Wujun
 * @create 2018年04月03日 13:12
 */
public class FdpDispatchRequestChatLog {

    private Integer id;

    private Integer faultDispatchRequestId;

    private String content;

    private  Integer processPersonId;

    private Date processTime;

    private boolean flagRead;

    private Date readTime;

    private String userType;

    private String dispatchOrderNumber;

    private String uploadFileName;

    private String uploadFileUrl;

    private String imageFileName;

    private String imageFileUrl;

    private Integer targetPersonId;

    public Integer getTargetPersonId() {
        return targetPersonId;
    }

    public void setTargetPersonId(Integer targetPersonId) {
        this.targetPersonId = targetPersonId;
    }

    public String getUploadFileName() {
        return uploadFileName;
    }

    public void setUploadFileName(String uploadFileName) {
        this.uploadFileName = uploadFileName;
    }

    public String getUploadFileUrl() {
        return uploadFileUrl;
    }

    public void setUploadFileUrl(String uploadFileUrl) {
        this.uploadFileUrl = uploadFileUrl;
    }

    public String getImageFileName() {
        return imageFileName;
    }

    public void setImageFileName(String imageFileName) {
        this.imageFileName = imageFileName;
    }

    public String getImageFileUrl() {
        return imageFileUrl;
    }

    public void setImageFileUrl(String imageFileUrl) {
        this.imageFileUrl = imageFileUrl;
    }

    public String getDispatchOrderNumber() {
        return dispatchOrderNumber;
    }

    public void setDispatchOrderNumber(String dispatchOrderNumber) {
        this.dispatchOrderNumber = dispatchOrderNumber;
    }

    public boolean isFlagRead() {
        return flagRead;
    }

    public void setFlagRead(boolean flagRead) {
        this.flagRead = flagRead;
    }

    public Date getReadTime() {
        return readTime;
    }

    public void setReadTime(Date readTime) {
        this.readTime = readTime;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getFaultDispatchRequestId() {
        return faultDispatchRequestId;
    }

    public void setFaultDispatchRequestId(Integer faultDispatchRequestId) {
        this.faultDispatchRequestId = faultDispatchRequestId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getProcessPersonId() {
        return processPersonId;
    }

    public void setProcessPersonId(Integer processPersonId) {
        this.processPersonId = processPersonId;
    }

    public Date getProcessTime() {
        return processTime;
    }

    public void setProcessTime(Date processTime) {
        this.processTime = processTime;
    }

}
