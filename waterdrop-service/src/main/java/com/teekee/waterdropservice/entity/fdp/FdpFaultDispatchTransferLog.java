package com.teekee.waterdropservice.entity.fdp;

import java.util.Date;

public class FdpFaultDispatchTransferLog {
    private Integer id;

    private Integer dispatchOrderId;

    private Integer orgDealPersonId;

    private Integer newDealPersonId;

    private Integer transferPersonId;

    private Date transferTime;

    /**
     * 转移类型0采购转发1派工转发
     */
    private Integer transferType;

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

    public Integer getOrgDealPersonId() {
        return orgDealPersonId;
    }

    public void setOrgDealPersonId(Integer orgDealPersonId) {
        this.orgDealPersonId = orgDealPersonId;
    }

    public Integer getNewDealPersonId() {
        return newDealPersonId;
    }

    public void setNewDealPersonId(Integer newDealPersonId) {
        this.newDealPersonId = newDealPersonId;
    }

    public Integer getTransferPersonId() {
        return transferPersonId;
    }

    public void setTransferPersonId(Integer transferPersonId) {
        this.transferPersonId = transferPersonId;
    }

    public Date getTransferTime() {
        return transferTime;
    }

    public void setTransferTime(Date transferTime) {
        this.transferTime = transferTime;
    }

    public Integer getTransferType() {
        return transferType;
    }

    public void setTransferType(Integer transferType) {
        this.transferType = transferType;
    }
}