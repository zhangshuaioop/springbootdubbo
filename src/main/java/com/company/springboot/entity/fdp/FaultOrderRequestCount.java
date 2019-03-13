package com.company.springboot.entity.fdp;

import java.math.BigDecimal;

public class FaultOrderRequestCount {
    private String companyName;
    private String username;
    private int requestCountAll;
    private int requestCountComplete;
    private int reqeustCountUncomplete;
    private int requestCountCancel;
    private BigDecimal estimatedPriceComplete;
    private BigDecimal estimatedPriceUncomplete;
    private BigDecimal actualPriceComplete;
    private BigDecimal actualPriceUncomplete;
    private String actualPriceUnit;
    private String estimatedPriceUnit;

    private Integer unCompleteCount;

    private Integer completeCount;



    public String getActualPriceUnit() {
        return actualPriceUnit;
    }

    public void setActualPriceUnit(String actualPriceUnit) {
        this.actualPriceUnit = actualPriceUnit;
    }

    public String getEstimatedPriceUnit() {
        return estimatedPriceUnit;
    }

    public void setEstimatedPriceUnit(String estimatedPriceUnit) {
        this.estimatedPriceUnit = estimatedPriceUnit;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public int getRequestCountAll() {
        return requestCountAll;
    }

    public void setRequestCountAll(int requestCountAll) {
        this.requestCountAll = requestCountAll;
    }

    public int getRequestCountComplete() {
        return requestCountComplete;
    }

    public void setRequestCountComplete(int requestCountComplete) {
        this.requestCountComplete = requestCountComplete;
    }

    public int getReqeustCountUncomplete() {
        return reqeustCountUncomplete;
    }

    public void setReqeustCountUncomplete(int reqeustCountUncomplete) {
        this.reqeustCountUncomplete = reqeustCountUncomplete;
    }

    public int getRequestCountCancel() {
        return requestCountCancel;
    }

    public void setRequestCountCancel(int requestCountCancel) {
        this.requestCountCancel = requestCountCancel;
    }

    public BigDecimal getEstimatedPriceComplete() {
        return estimatedPriceComplete;
    }

    public void setEstimatedPriceComplete(BigDecimal estimatedPriceComplete) {
        this.estimatedPriceComplete = estimatedPriceComplete;
    }

    public BigDecimal getEstimatedPriceUncomplete() {
        return estimatedPriceUncomplete;
    }

    public void setEstimatedPriceUncomplete(BigDecimal estimatedPriceUncomplete) {
        this.estimatedPriceUncomplete = estimatedPriceUncomplete;
    }

    public BigDecimal getActualPriceComplete() {
        return actualPriceComplete;
    }

    public void setActualPriceComplete(BigDecimal actualPriceComplete) {
        this.actualPriceComplete = actualPriceComplete;
    }

    public BigDecimal getActualPriceUncomplete() {
        return actualPriceUncomplete;
    }

    public void setActualPriceUncomplete(BigDecimal actualPriceUncomplete) {
        this.actualPriceUncomplete = actualPriceUncomplete;
    }

    public Integer getUnCompleteCount() {
        return unCompleteCount;
    }

    public void setUnCompleteCount(Integer unCompleteCount) {
        this.unCompleteCount = unCompleteCount;
    }

    public Integer getCompleteCount() {
        return completeCount;
    }

    public void setCompleteCount(Integer completeCount) {
        this.completeCount = completeCount;
    }

    @Override
    public String toString() {
        return "FaultOrderRequestCount{" +
                "companyName='" + companyName + '\'' +
                ", username='" + username + '\'' +
                ", requestCountAll=" + requestCountAll +
                ", requestCountComplete=" + requestCountComplete +
                ", reqeustCountUncomplete=" + reqeustCountUncomplete +
                ", requestCountCancel=" + requestCountCancel +
                ", estimatedPriceComplete=" + estimatedPriceComplete +
                ", estimatedPriceUncomplete=" + estimatedPriceUncomplete +
                ", actualPriceComplete=" + actualPriceComplete +
                ", actualPriceUncomplete=" + actualPriceUncomplete +
                ", actualPriceUnit='" + actualPriceUnit + '\'' +
                ", estimatedPriceUnit='" + estimatedPriceUnit + '\'' +
                ", unCompleteCount=" + unCompleteCount +
                ", completeCount=" + completeCount +
                '}';
    }
}
