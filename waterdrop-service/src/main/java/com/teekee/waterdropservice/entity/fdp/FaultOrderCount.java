package com.teekee.waterdropservice.entity.fdp;

import java.math.BigDecimal;

public class FaultOrderCount {
    private int orderCountAll;
    private int orderCountComplete;
    private int orderCountUnComplete;
    private int orderCountCancel;
    private String companyName;
    private BigDecimal SumEstimatedPrice;
    private BigDecimal SumUnEstimatedPrice;
    private BigDecimal SumEstimatedCost;
    private BigDecimal SumUnEstimatedCost;
    private BigDecimal SumActualPrice;
    private BigDecimal SumUnActualPrice;
    private BigDecimal SumActualCost;
    private BigDecimal SumUnActualCost;
    private String estimatedPriceUnit;
    private String actualPriceUnit;
    private String actualMonetaryUnit;
    private String estimatedMonetaryUnit;

    public String getEstimatedPriceUnit() {
        return estimatedPriceUnit;
    }

    public void setEstimatedPriceUnit(String estimatedPriceUnit) {
        this.estimatedPriceUnit = estimatedPriceUnit;
    }

    public String getActualPriceUnit() {
        return actualPriceUnit;
    }

    public void setActualPriceUnit(String actualPriceUnit) {
        this.actualPriceUnit = actualPriceUnit;
    }

    public String getActualMonetaryUnit() {
        return actualMonetaryUnit;
    }

    public void setActualMonetaryUnit(String actualMonetaryUnit) {
        this.actualMonetaryUnit = actualMonetaryUnit;
    }

    public String getEstimatedMonetaryUnit() {
        return estimatedMonetaryUnit;
    }

    public void setEstimatedMonetaryUnit(String estimatedMonetaryUnit) {
        this.estimatedMonetaryUnit = estimatedMonetaryUnit;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public int getOrderCountAll() {
        return orderCountAll;
    }

    public void setOrderCountAll(int orderCountAll) {
        this.orderCountAll = orderCountAll;
    }

    public int getOrderCountComplete() {
        return orderCountComplete;
    }

    public void setOrderCountComplete(int orderCountComplete) {
        this.orderCountComplete = orderCountComplete;
    }

    public int getOrderCountUnComplete() {
        return orderCountUnComplete;
    }

    public void setOrderCountUnComplete(int orderCountUnComplete) {
        this.orderCountUnComplete = orderCountUnComplete;
    }

    public int getOrderCountCancel() {
        return orderCountCancel;
    }

    public void setOrderCountCancel(int orderCountCancel) {
        this.orderCountCancel = orderCountCancel;
    }

    public BigDecimal getSumEstimatedPrice() {
        return SumEstimatedPrice;
    }

    public void setSumEstimatedPrice(BigDecimal sumEstimatedPrice) {
        SumEstimatedPrice = sumEstimatedPrice;
    }

    public BigDecimal getSumUnEstimatedPrice() {
        return SumUnEstimatedPrice;
    }

    public void setSumUnEstimatedPrice(BigDecimal sumUnEstimatedPrice) {
        SumUnEstimatedPrice = sumUnEstimatedPrice;
    }

    public BigDecimal getSumEstimatedCost() {
        return SumEstimatedCost;
    }

    public void setSumEstimatedCost(BigDecimal sumEstimatedCost) {
        SumEstimatedCost = sumEstimatedCost;
    }

    public BigDecimal getSumUnEstimatedCost() {
        return SumUnEstimatedCost;
    }

    public void setSumUnEstimatedCost(BigDecimal sumUnEstimatedCost) {
        SumUnEstimatedCost = sumUnEstimatedCost;
    }

    public BigDecimal getSumActualPrice() {
        return SumActualPrice;
    }

    public void setSumActualPrice(BigDecimal sumActualPrice) {
        SumActualPrice = sumActualPrice;
    }

    public BigDecimal getSumUnActualPrice() {
        return SumUnActualPrice;
    }

    public void setSumUnActualPrice(BigDecimal sumUnActualPrice) {
        SumUnActualPrice = sumUnActualPrice;
    }

    public BigDecimal getSumActualCost() {
        return SumActualCost;
    }

    public void setSumActualCost(BigDecimal sumActualCost) {
        SumActualCost = sumActualCost;
    }

    public BigDecimal getSumUnActualCost() {
        return SumUnActualCost;
    }

    public void setSumUnActualCost(BigDecimal sumUnActualCost) {
        SumUnActualCost = sumUnActualCost;
    }
}
