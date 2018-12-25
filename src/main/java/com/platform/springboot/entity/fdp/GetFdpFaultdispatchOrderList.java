package com.platform.springboot.entity.fdp;

import java.math.BigDecimal;
import java.util.Date;

public class GetFdpFaultdispatchOrderList {
    private int companyId;
    private String dispatchStatus;
    private Integer lastDealPersonId;
    private String createPerson;
    private Date createTimeStart;
    private Date createTimeEnd;
    private Date userCompleteTimeStart;
    private Date userCompleteTimeEnd;
    private BigDecimal actualCostStart;
    private BigDecimal actualCostEnd;
    private BigDecimal estimatedCostStart;
    private BigDecimal estimatedCostEnd;
    private BigDecimal actualPriceStart;
    private BigDecimal actualPriceEnd;
    private BigDecimal estimatedPriceStart;
    private BigDecimal estimatedPriceEnd;
    private String province;
    private Integer vendorId;
    private Integer type;
    private String city;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Integer getVendorId() {
        return vendorId;
    }

    public void setVendorId(Integer vendorId) {
        this.vendorId = vendorId;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getCreatePerson() {
        return createPerson;
    }

    public void setCreatePerson(String createPerson) {
        this.createPerson = createPerson;
    }

    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    public String getDispatchStatus() {
        return dispatchStatus;
    }

    public void setDispatchStatus(String dispatchStatus) {
        this.dispatchStatus = dispatchStatus;
    }

    public Integer getLastDealPersonId() {
        return lastDealPersonId;
    }

    public void setLastDealPersonId(Integer lastDealPersonId) {
        this.lastDealPersonId = lastDealPersonId;
    }

    public Date getCreateTimeStart() {
        return createTimeStart;
    }

    public void setCreateTimeStart(Date createTimeStart) {
        this.createTimeStart = createTimeStart;
    }

    public Date getCreateTimeEnd() {
        return createTimeEnd;
    }

    public void setCreateTimeEnd(Date createTimeEnd) {
        this.createTimeEnd = createTimeEnd;
    }

    public Date getUserCompleteTimeStart() {
        return userCompleteTimeStart;
    }

    public void setUserCompleteTimeStart(Date userCompleteTimeStart) {
        this.userCompleteTimeStart = userCompleteTimeStart;
    }

    public Date getUserCompleteTimeEnd() {
        return userCompleteTimeEnd;
    }

    public void setUserCompleteTimeEnd(Date userCompleteTimeEnd) {
        this.userCompleteTimeEnd = userCompleteTimeEnd;
    }

    public BigDecimal getActualCostStart() {
        return actualCostStart;
    }

    public void setActualCostStart(BigDecimal actualCostStart) {
        this.actualCostStart = actualCostStart;
    }

    public BigDecimal getActualCostEnd() {
        return actualCostEnd;
    }

    public void setActualCostEnd(BigDecimal actualCostEnd) {
        this.actualCostEnd = actualCostEnd;
    }

    public BigDecimal getEstimatedCostStart() {
        return estimatedCostStart;
    }

    public void setEstimatedCostStart(BigDecimal estimatedCostStart) {
        this.estimatedCostStart = estimatedCostStart;
    }

    public BigDecimal getEstimatedCostEnd() {
        return estimatedCostEnd;
    }

    public void setEstimatedCostEnd(BigDecimal estimatedCostEnd) {
        this.estimatedCostEnd = estimatedCostEnd;
    }

    public BigDecimal getActualPriceStart() {
        return actualPriceStart;
    }

    public void setActualPriceStart(BigDecimal actualPriceStart) {
        this.actualPriceStart = actualPriceStart;
    }

    public BigDecimal getActualPriceEnd() {
        return actualPriceEnd;
    }

    public void setActualPriceEnd(BigDecimal actualPriceEnd) {
        this.actualPriceEnd = actualPriceEnd;
    }

    public BigDecimal getEstimatedPriceStart() {
        return estimatedPriceStart;
    }

    public void setEstimatedPriceStart(BigDecimal estimatedPriceStart) {
        this.estimatedPriceStart = estimatedPriceStart;
    }

    public BigDecimal getEstimatedPriceEnd() {
        return estimatedPriceEnd;
    }

    public void setEstimatedPriceEnd(BigDecimal estimatedPriceEnd) {
        this.estimatedPriceEnd = estimatedPriceEnd;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }


}
