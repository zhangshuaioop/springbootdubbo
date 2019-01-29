package com.teekee.blueoceanservice.entity.fdp;

import java.math.BigDecimal;
import java.util.Date;

public class FdpFaultDispatchChangeLog {
    private Integer id;

    private Integer dispatchOrderId;

    private Integer faultDispatchRequestId;

    private Integer dispatchMainHrId;

    private Integer hrAccountInfoId;

    private Integer hrRelationId;

    private String changeType;

    private BigDecimal estimatedCost;

    private String estimatedMonetaryUnit;

    private BigDecimal estimatedPrice;

    private String estimatedPriceUnit;

    private Date createTime;

    private Integer createPerson;

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

    public Integer getFaultDispatchRequestId() {
        return faultDispatchRequestId;
    }

    public void setFaultDispatchRequestId(Integer faultDispatchRequestId) {
        this.faultDispatchRequestId = faultDispatchRequestId;
    }

    public Integer getDispatchMainHrId() {
        return dispatchMainHrId;
    }

    public void setDispatchMainHrId(Integer dispatchMainHrId) {
        this.dispatchMainHrId = dispatchMainHrId;
    }

    public Integer getHrAccountInfoId() {
        return hrAccountInfoId;
    }

    public void setHrAccountInfoId(Integer hrAccountInfoId) {
        this.hrAccountInfoId = hrAccountInfoId;
    }

    public Integer getHrRelationId() {
        return hrRelationId;
    }

    public void setHrRelationId(Integer hrRelationId) {
        this.hrRelationId = hrRelationId;
    }

    public String getChangeType() {
        return changeType;
    }

    public void setChangeType(String changeType) {
        this.changeType = changeType == null ? null : changeType.trim();
    }

    public BigDecimal getEstimatedCost() {
        return estimatedCost;
    }

    public void setEstimatedCost(BigDecimal estimatedCost) {
        this.estimatedCost = estimatedCost;
    }

    public String getEstimatedMonetaryUnit() {
        return estimatedMonetaryUnit;
    }

    public void setEstimatedMonetaryUnit(String estimatedMonetaryUnit) {
        this.estimatedMonetaryUnit = estimatedMonetaryUnit == null ? null : estimatedMonetaryUnit.trim();
    }

    public BigDecimal getEstimatedPrice() {
        return estimatedPrice;
    }

    public void setEstimatedPrice(BigDecimal estimatedPrice) {
        this.estimatedPrice = estimatedPrice;
    }

    public String getEstimatedPriceUnit() {
        return estimatedPriceUnit;
    }

    public void setEstimatedPriceUnit(String estimatedPriceUnit) {
        this.estimatedPriceUnit = estimatedPriceUnit == null ? null : estimatedPriceUnit.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getCreatePerson() {
        return createPerson;
    }

    public void setCreatePerson(Integer createPerson) {
        this.createPerson = createPerson;
    }
}