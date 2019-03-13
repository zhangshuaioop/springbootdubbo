package com.platform.springboot.entity.fdp;

import java.util.Date;

public class FdpDispatchProcessLog {
    private Integer id;

    private Integer dispatchOrderId;

    private Integer dealPersonId;

    private String dealPersonType;

    private String beforeStatus;

    private String afterStatus;

    private String dealContent;

    private Date dealTime;

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

    public Integer getDealPersonId() {
        return dealPersonId;
    }

    public void setDealPersonId(Integer dealPersonId) {
        this.dealPersonId = dealPersonId;
    }

    public String getDealPersonType() {
        return dealPersonType;
    }

    public void setDealPersonType(String dealPersonType) {
        this.dealPersonType = dealPersonType == null ? null : dealPersonType.trim();
    }

    public String getBeforeStatus() {
        return beforeStatus;
    }

    public void setBeforeStatus(String beforeStatus) {
        this.beforeStatus = beforeStatus == null ? null : beforeStatus.trim();
    }

    public String getAfterStatus() {
        return afterStatus;
    }

    public void setAfterStatus(String afterStatus) {
        this.afterStatus = afterStatus == null ? null : afterStatus.trim();
    }

    public String getDealContent() {
        return dealContent;
    }

    public void setDealContent(String dealContent) {
        this.dealContent = dealContent == null ? null : dealContent.trim();
    }

    public Date getDealTime() {
        return dealTime;
    }

    public void setDealTime(Date dealTime) {
        this.dealTime = dealTime;
    }
}