package com.platform.springboot.entity.fdp;

/**
 * @description:
 * @author: zhangshuai
 * @create: 2018-12-26 14:43
 */
public class FdpFaultDispatchOrderRes {

    //requestId
    private String faultDispatchRequestId;

    //派工工单号
    private String dispatchOrderNumber;

    //集成商名称
    private String vendorName;

    //公司名称
    private String companyName;

    //系统编号
    private String otherSystemNumber;

    //门店名称
    private String storeName;

    //派工地址
    private String serviceAddress;

    //发起时间
    private String submitTime;

    //期望完成时间
    private String expectCompleteTime;

    //完成时间
    private String finishTime;

    //派工人员姓名
    private String fullName;

    //手机号
    private String mobile;

    //预计成本
    private String estimatedCost;

    //预计成本备注
    private String estimatedcostMemo;

    //预计售价
    private String estimatedPrice;

    //预计售价备注
    private String estimatedPriceMemo;

    //实际成本
    private String actualCost;

    //实际成本备注
    private String actualCostMemo;

    //实际售价
    private String actualPrice;

    //实际售价备注
    private String actualPriceMemo;

    public String getFaultDispatchRequestId() {
        return faultDispatchRequestId;
    }

    public void setFaultDispatchRequestId(String faultDispatchRequestId) {
        this.faultDispatchRequestId = faultDispatchRequestId;
    }

    public String getDispatchOrderNumber() {
        return dispatchOrderNumber;
    }

    public void setDispatchOrderNumber(String dispatchOrderNumber) {
        this.dispatchOrderNumber = dispatchOrderNumber;
    }

    public String getVendorName() {
        return vendorName;
    }

    public void setVendorName(String vendorName) {
        this.vendorName = vendorName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getOtherSystemNumber() {
        return otherSystemNumber;
    }

    public void setOtherSystemNumber(String otherSystemNumber) {
        this.otherSystemNumber = otherSystemNumber;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getServiceAddress() {
        return serviceAddress;
    }

    public void setServiceAddress(String serviceAddress) {
        this.serviceAddress = serviceAddress;
    }

    public String getSubmitTime() {
        return submitTime;
    }

    public void setSubmitTime(String submitTime) {
        this.submitTime = submitTime;
    }

    public String getExpectCompleteTime() {
        return expectCompleteTime;
    }

    public void setExpectCompleteTime(String expectCompleteTime) {
        this.expectCompleteTime = expectCompleteTime;
    }

    public String getFinishTime() {
        return finishTime;
    }

    public void setFinishTime(String finishTime) {
        this.finishTime = finishTime;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEstimatedCost() {
        return estimatedCost;
    }

    public void setEstimatedCost(String estimatedCost) {
        this.estimatedCost = estimatedCost;
    }

    public String getEstimatedcostMemo() {
        return estimatedcostMemo;
    }

    public void setEstimatedcostMemo(String estimatedcostMemo) {
        this.estimatedcostMemo = estimatedcostMemo;
    }

    public String getEstimatedPrice() {
        return estimatedPrice;
    }

    public void setEstimatedPrice(String estimatedPrice) {
        this.estimatedPrice = estimatedPrice;
    }

    public String getEstimatedPriceMemo() {
        return estimatedPriceMemo;
    }

    public void setEstimatedPriceMemo(String estimatedPriceMemo) {
        this.estimatedPriceMemo = estimatedPriceMemo;
    }

    public String getActualCost() {
        return actualCost;
    }

    public void setActualCost(String actualCost) {
        this.actualCost = actualCost;
    }

    public String getActualCostMemo() {
        return actualCostMemo;
    }

    public void setActualCostMemo(String actualCostMemo) {
        this.actualCostMemo = actualCostMemo;
    }

    public String getActualPrice() {
        return actualPrice;
    }

    public void setActualPrice(String actualPrice) {
        this.actualPrice = actualPrice;
    }

    public String getActualPriceMemo() {
        return actualPriceMemo;
    }

    public void setActualPriceMemo(String actualPriceMemo) {
        this.actualPriceMemo = actualPriceMemo;
    }

    @Override
    public String toString() {
        return "FdpFaultDispatchOrderRes{" +
                "faultDispatchRequestId='" + faultDispatchRequestId + '\'' +
                ", dispatchOrderNumber='" + dispatchOrderNumber + '\'' +
                ", vendorName='" + vendorName + '\'' +
                ", companyName='" + companyName + '\'' +
                ", otherSystemNumber='" + otherSystemNumber + '\'' +
                ", storeName='" + storeName + '\'' +
                ", serviceAddress='" + serviceAddress + '\'' +
                ", submitTime='" + submitTime + '\'' +
                ", expectCompleteTime='" + expectCompleteTime + '\'' +
                ", finishTime='" + finishTime + '\'' +
                ", fullName='" + fullName + '\'' +
                ", mobile='" + mobile + '\'' +
                ", estimatedCost='" + estimatedCost + '\'' +
                ", estimatedcostMemo='" + estimatedcostMemo + '\'' +
                ", estimatedPrice='" + estimatedPrice + '\'' +
                ", estimatedPriceMemo='" + estimatedPriceMemo + '\'' +
                ", actualCost='" + actualCost + '\'' +
                ", actualCostMemo='" + actualCostMemo + '\'' +
                ", actualPrice='" + actualPrice + '\'' +
                ", actualPriceMemo='" + actualPriceMemo + '\'' +
                '}';
    }
}
