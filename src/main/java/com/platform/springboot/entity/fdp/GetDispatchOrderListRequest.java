package com.platform.springboot.entity.fdp;

import com.platform.springboot.base.BaseEntity;

import java.util.Date;

/**
 * 查询符合条件的派工工单列表-请求参数
 *
 * @author Wujun
 * @create 2018年01月30日 17:01
 */
public class GetDispatchOrderListRequest extends BaseEntity {
    private int companyId;
    private int storeId;
    private int dealPersonId;
    private String dispatchRequest;
    private Date requestDateStart;
    private Date requestDateEnd;
    private Date dispatchDateStart;
    private Date dispatchDateEnd;
    private String dispatchType;
    private String dispatchOrderNumber;
    private String dispatchStatus;
    private Integer vendorId;
    private String status;
    private String warningStatus;
    //批次号
    private String batchNumber;

    public String getBatchNumber() {
        return batchNumber;
    }

    public void setBatchNumber(String batchNumber) {
        this.batchNumber = batchNumber;
    }

    public String getWarningStatus() {
        return warningStatus;
    }

    public void setWarningStatus(String warningStatus) {
        this.warningStatus = warningStatus;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDispatchOrderNumber() {
        return dispatchOrderNumber;
    }

    public void setDispatchOrderNumber(String dispatchOrderNumber) {
        this.dispatchOrderNumber = dispatchOrderNumber;
    }

    public String getDispatchStatus() {
        return dispatchStatus;
    }

    public void setDispatchStatus(String dispatchStatus) {
        this.dispatchStatus = dispatchStatus;
    }

    public Integer getVendorId() {
        return vendorId;
    }

    public void setVendorId(Integer vendorId) {
        this.vendorId = vendorId;
    }

    public String getDispatchType() {
        return dispatchType;
    }

    public void setDispatchType(String dispatchType) {
        this.dispatchType = dispatchType;
    }

    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    public int getStoreId() {
        return storeId;
    }

    public void setStoreId(int storeId) {
        this.storeId = storeId;
    }

    public int getDealPersonId() {
        return dealPersonId;
    }

    public void setDealPersonId(int dealPersonId) {
        this.dealPersonId = dealPersonId;
    }

    public String getDispatchRequest() {
        return dispatchRequest;
    }

    public void setDispatchRequest(String dispatchRequest) {
        this.dispatchRequest = dispatchRequest;
    }

    public Date getRequestDateStart() {
        return requestDateStart;
    }

    public void setRequestDateStart(Date requestDateStart) {
        this.requestDateStart = requestDateStart;
    }

    public Date getRequestDateEnd() {
        return requestDateEnd;
    }

    public void setRequestDateEnd(Date requestDateEnd) {
        this.requestDateEnd = requestDateEnd;
    }

    public Date getDispatchDateStart() {
        return dispatchDateStart;
    }

    public void setDispatchDateStart(Date dispatchDateStart) {
        this.dispatchDateStart = dispatchDateStart;
    }

    public Date getDispatchDateEnd() {
        return dispatchDateEnd;
    }

    public void setDispatchDateEnd(Date dispatchDateEnd) {
        this.dispatchDateEnd = dispatchDateEnd;
    }

    @Override
    public String toString() {
        return "GetDispatchOrderListRequest{" +
                "companyId=" + companyId +
                ", storeId=" + storeId +
                ", dealPersonId=" + dealPersonId +
                ", dispatchRequest='" + dispatchRequest + '\'' +
                ", requestDateStart=" + requestDateStart +
                ", requestDateEnd=" + requestDateEnd +
                ", dispatchDateStart=" + dispatchDateStart +
                ", dispatchDateEnd=" + dispatchDateEnd +
                ", dispatchType='" + dispatchType + '\'' +
                ", dispatchOrderNumber='" + dispatchOrderNumber + '\'' +
                ", dispatchStatus='" + dispatchStatus + '\'' +
                ", vendorId=" + vendorId +
                ", status='" + status + '\'' +
                ", warningStatus='" + warningStatus + '\'' +
                ", batchNumber='" + batchNumber + '\'' +
                '}';
    }
}
