package com.company.springboot.entity.wp;

import java.util.Date;

public class WpProcessOperateLog {
    private Integer id;

    private Integer frameProcessId;

    private Integer processId;

    private Integer operatePerson;

    private Date operateTime;

    private String photosUrl;

    private String photosName;

    private String filesUrl;

    private String filesName;

    private String operateResult;

    private Integer timeUsed;

    private Boolean flagTimeout;

    private String description;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getFrameProcessId() {
        return frameProcessId;
    }

    public void setFrameProcessId(Integer frameProcessId) {
        this.frameProcessId = frameProcessId;
    }

    public Integer getProcessId() {
        return processId;
    }

    public void setProcessId(Integer processId) {
        this.processId = processId;
    }

    public Integer getOperatePerson() {
        return operatePerson;
    }

    public void setOperatePerson(Integer operatePerson) {
        this.operatePerson = operatePerson;
    }

    public Date getOperateTime() {
        return operateTime;
    }

    public void setOperateTime(Date operateTime) {
        this.operateTime = operateTime;
    }

    public String getPhotosUrl() {
        return photosUrl;
    }

    public void setPhotosUrl(String photosUrl) {
        this.photosUrl = photosUrl == null ? null : photosUrl.trim();
    }

    public String getPhotosName() {
        return photosName;
    }

    public void setPhotosName(String photosName) {
        this.photosName = photosName == null ? null : photosName.trim();
    }

    public String getFilesUrl() {
        return filesUrl;
    }

    public void setFilesUrl(String filesUrl) {
        this.filesUrl = filesUrl == null ? null : filesUrl.trim();
    }

    public String getFilesName() {
        return filesName;
    }

    public void setFilesName(String filesName) {
        this.filesName = filesName == null ? null : filesName.trim();
    }

    public String getOperateResult() {
        return operateResult;
    }

    public void setOperateResult(String operateResult) {
        this.operateResult = operateResult == null ? null : operateResult.trim();
    }

    public Integer getTimeUsed() {
        return timeUsed;
    }

    public void setTimeUsed(Integer timeUsed) {
        this.timeUsed = timeUsed;
    }

    public Boolean getFlagTimeout() {
        return flagTimeout;
    }

    public void setFlagTimeout(Boolean flagTimeout) {
        this.flagTimeout = flagTimeout;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }
}