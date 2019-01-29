package com.teekee.blueoceanservice.entity.fdp;

import java.util.Date;

/**
 * 查询符合条件的故障工单列表-request
 *
 * @author Wujun
 * @create 2018年01月22日 14:55
 */
public class GetFaultOrderListRequest {

    private int companyId;
    private int storeId;
    private int dealpersonId;
    private String basicFaultType;
    private String faultType;
    private String opearteStatus;
    private Date reportDateStart;
    private Date reportDateEnd;
    private Date userCompleteTimeStart;
    private Date userCompleteTimeEnd;
    private String faultOrderNumber;
    private String actType;
    private Integer actObjectId;
    private String status;
    private String inputType;

    public String getInputType() {
        return inputType;
    }

    public void setInputType(String inputType) {
        this.inputType = inputType;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getActType() {
        return actType;
    }

    public void setActType(String actType) {
        this.actType = actType;
    }

    public Integer getActObjectId() {
        return actObjectId;
    }

    public void setActObjectId(Integer actObjectId) {
        this.actObjectId = actObjectId;
    }

    public String getFaultOrderNumber() {
        return faultOrderNumber;
    }

    public void setFaultOrderNumber(String faultOrderNumber) {
        this.faultOrderNumber = faultOrderNumber;
    }

    public String getFaultType() {
        return faultType;
    }

    public void setFaultType(String faultType) {
        this.faultType = faultType;
    }

    public Date getUserCompleteTimeEnd() {
        return userCompleteTimeEnd;
    }

    public void setUserCompleteTimeEnd(Date userCompleteTimeEnd) {
        this.userCompleteTimeEnd = userCompleteTimeEnd;
    }

    public Date getUserCompleteTimeStart() {
        return userCompleteTimeStart;
    }

    public void setUserCompleteTimeStart(Date userCompleteTimeStart) {
        this.userCompleteTimeStart = userCompleteTimeStart;
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

    public int getDealpersonId() {
        return dealpersonId;
    }

    public void setDealpersonId(int dealpersonId) {
        this.dealpersonId = dealpersonId;
    }

    public String getBasicFaultType() {
        return basicFaultType;
    }

    public void setBasicFaultType(String basicFaultType) {
        this.basicFaultType = basicFaultType;
    }

    public String getOpearteStatus() {
        return opearteStatus;
    }

    public void setOpearteStatus(String opearteStatus) {
        this.opearteStatus = opearteStatus;
    }

    public Date getReportDateStart() {
        return reportDateStart;
    }

    public void setReportDateStart(Date reportDateStart) {
        this.reportDateStart = reportDateStart;
    }

    public Date getReportDateEnd() {
        return reportDateEnd;
    }

    public void setReportDateEnd(Date reportDateEnd) {
        this.reportDateEnd = reportDateEnd;
    }
}
