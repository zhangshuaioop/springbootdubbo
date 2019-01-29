package com.teekee.waterdropservice.entity.fdp;

import java.util.Date;

/**
 * @Author Niting
 * @date 2018/8/21
 **/
public class ParamServiceDispatchOrder {
    private Integer hrId;
    private String type;
    private String serviceCity;
    private String brandName;
    private String storeName;
    private String dispatchStatus;
    private Date hrConfirmTimeStart;
    private Date hrConfirmTimeEnd;
    private Date hrStartOffTimeStart;
    private Date hrStartOffTimeEnd;
    private Date hrFinishServiceTimeStart;
    private Date hrFinishServiceTimeEnd;
    private Date lastDealTimeStart;
    private Date lastDealTimeEnd;

    public Integer getHrId() {
        return hrId;
    }

    public void setHrId(Integer hrId) {
        this.hrId = hrId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getServiceCity() {
        return serviceCity;
    }

    public void setServiceCity(String serviceCity) {
        this.serviceCity = serviceCity;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getDispatchStatus() {
        return dispatchStatus;
    }

    public void setDispatchStatus(String dispatchStatus) {
        this.dispatchStatus = dispatchStatus;
    }

    public Date getHrConfirmTimeStart() {
        return hrConfirmTimeStart;
    }

    public void setHrConfirmTimeStart(Date hrConfirmTimeStart) {
        this.hrConfirmTimeStart = hrConfirmTimeStart;
    }

    public Date getHrConfirmTimeEnd() {
        return hrConfirmTimeEnd;
    }

    public void setHrConfirmTimeEnd(Date hrConfirmTimeEnd) {
        this.hrConfirmTimeEnd = hrConfirmTimeEnd;
    }

    public Date getHrStartOffTimeStart() {
        return hrStartOffTimeStart;
    }

    public void setHrStartOffTimeStart(Date hrStartOffTimeStart) {
        this.hrStartOffTimeStart = hrStartOffTimeStart;
    }

    public Date getHrStartOffTimeEnd() {
        return hrStartOffTimeEnd;
    }

    public void setHrStartOffTimeEnd(Date hrStartOffTimeEnd) {
        this.hrStartOffTimeEnd = hrStartOffTimeEnd;
    }

    public Date getHrFinishServiceTimeStart() {
        return hrFinishServiceTimeStart;
    }

    public void setHrFinishServiceTimeStart(Date hrFinishServiceTimeStart) {
        this.hrFinishServiceTimeStart = hrFinishServiceTimeStart;
    }

    public Date getHrFinishServiceTimeEnd() {
        return hrFinishServiceTimeEnd;
    }

    public void setHrFinishServiceTimeEnd(Date hrFinishServiceTimeEnd) {
        this.hrFinishServiceTimeEnd = hrFinishServiceTimeEnd;
    }

    public Date getLastDealTimeStart() {
        return lastDealTimeStart;
    }

    public void setLastDealTimeStart(Date lastDealTimeStart) {
        this.lastDealTimeStart = lastDealTimeStart;
    }

    public Date getLastDealTimeEnd() {
        return lastDealTimeEnd;
    }

    public void setLastDealTimeEnd(Date lastDealTimeEnd) {
        this.lastDealTimeEnd = lastDealTimeEnd;
    }

    @Override
    public String toString() {
        return "ParamServiceDispatchOrder{" +
                "hrId=" + hrId +
                ", type='" + type + '\'' +
                ", serviceCity='" + serviceCity + '\'' +
                ", brandName='" + brandName + '\'' +
                ", storeName='" + storeName + '\'' +
                ", dispatchStatus='" + dispatchStatus + '\'' +
                ", hrConfirmTimeStart=" + hrConfirmTimeStart +
                ", hrConfirmTimeEnd=" + hrConfirmTimeEnd +
                ", hrStartOffTimeStart=" + hrStartOffTimeStart +
                ", hrStartOffTimeEnd=" + hrStartOffTimeEnd +
                ", hrFinishServiceTimeStart=" + hrFinishServiceTimeStart +
                ", hrFinishServiceTimeEnd=" + hrFinishServiceTimeEnd +
                ", lastDealTimeStart=" + lastDealTimeStart +
                ", lastDealTimeEnd=" + lastDealTimeEnd +
                '}';
    }
}
