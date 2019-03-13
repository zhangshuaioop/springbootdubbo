package com.company.springboot.entity.fdp;


import java.util.Date;

/**
 * 故障流程的处理人转移日志
 *
 * @author youhaoran
 * @create 2018年03月20日 01：22
 */
public class FdpFaultOrderProcessTransferLogJourna {
    private  Integer id;
    private  Integer faultOrderId;    //派工订单ID
    private  Integer orgDealPersonId;//原始处理人ID
    private  Integer newDealPersonId;//目标处理人ID
    private  Integer transferpersonId;//转发人的ID
    private Date transferTime;        //转移时间
    private  String  transferType;      //转发类型  转发 BELONG   所属人 DEAL

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getFaultOrderId() {
        return faultOrderId;
    }

    public void setFaultOrderId(Integer faultOrderId) {
        this.faultOrderId = faultOrderId;
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

    public Integer getTransferpersonId() {
        return transferpersonId;
    }

    public void setTransferpersonId(Integer transferpersonId) {
        this.transferpersonId = transferpersonId;
    }

    public Date getTransferTime() {
        return transferTime;
    }

    public void setTransferTime(Date transferTime) {
        this.transferTime = transferTime;
    }

    public String getTransferType() {
        return transferType;
    }

    public void setTransferType(String transferType) {
        this.transferType = transferType;
    }

    @Override
    public String toString() {
        return "FdpFaultOrderProcessTransferLog{" +
                "id=" + id +
                ", faultOrderId=" + faultOrderId +
                ", orgDealPersonId=" + orgDealPersonId +
                ", newDealPersonId=" + newDealPersonId +
                ", transferpersonId=" + transferpersonId +
                ", transferTime=" + transferTime +
                ", transferType='" + transferType + '\'' +
                '}';
    }
}
