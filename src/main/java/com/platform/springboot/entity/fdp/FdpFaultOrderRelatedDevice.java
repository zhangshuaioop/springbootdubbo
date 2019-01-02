package com.platform.springboot.entity.fdp;

import java.util.Date;
import java.util.List;

public class FdpFaultOrderRelatedDevice {
    private Integer id;

    private Integer faultOrderProcessId;

    private Integer faultReportId;

    private Integer deviceId;

    private Integer storeId;

    private Integer deviceAssignId;

    private Boolean flagDeleted;

    private Date updateTime;

    private Integer updatePerson;

    private List<FdpFaultOrderRelatedDevice> device;

    public List<FdpFaultOrderRelatedDevice> getDevice() {
        return device;
    }

    public void setDevice(List<FdpFaultOrderRelatedDevice> device) {
        this.device = device;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getFaultOrderProcessId() {
        return faultOrderProcessId;
    }

    public void setFaultOrderProcessId(Integer faultOrderProcessId) {
        this.faultOrderProcessId = faultOrderProcessId;
    }

    public Integer getFaultReportId() {
        return faultReportId;
    }

    public void setFaultReportId(Integer faultReportId) {
        this.faultReportId = faultReportId;
    }

    public Integer getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(Integer deviceId) {
        this.deviceId = deviceId;
    }

    public Integer getStoreId() {
        return storeId;
    }

    public void setStoreId(Integer storeId) {
        this.storeId = storeId;
    }

    public Integer getDeviceAssignId() {
        return deviceAssignId;
    }

    public void setDeviceAssignId(Integer deviceAssignId) {
        this.deviceAssignId = deviceAssignId;
    }

    public Boolean getFlagDeleted() {
        return flagDeleted;
    }

    public void setFlagDeleted(Boolean flagDeleted) {
        this.flagDeleted = flagDeleted;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getUpdatePerson() {
        return updatePerson;
    }

    public void setUpdatePerson(Integer updatePerson) {
        this.updatePerson = updatePerson;
    }
}