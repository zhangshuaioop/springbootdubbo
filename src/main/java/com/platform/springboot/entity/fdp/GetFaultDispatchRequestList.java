package com.platform.springboot.entity.fdp;

import com.platform.springboot.base.BaseEntity;
import com.platform.springboot.base.BaseEntity;

import java.math.BigDecimal;
import java.util.Date;

public class GetFaultDispatchRequestList extends BaseEntity {
    private int companyId;
    private int lastDealPersonId;
    private String dispatchStatus;
    private String opearteStatus;
    private Date reportDateStart;
    private Date reportDateEnd;
    private Date userCompleteTimeStart;
    private Date userCompleteTimeEnd;
    private String province;
    private String city;
    private BigDecimal actualPriceStart;
    private BigDecimal actualPriceEnd;
    private BigDecimal estimatedPriceStart;
    private BigDecimal estimatedPriceEnd;
    private BigDecimal estimatedCostStart;
    private BigDecimal estimatedCostEnd;
    private BigDecimal actualCostStart;
    private BigDecimal actualCostEnd;
    private Date createTimeStart;
    private Date createTimeEnd;
    private Integer createPerson;
    private int vendorId;
    private int actVendorId;
    private Integer type;
    private String actType;
    private Date updateTime;

    public int getActVendorId() {
        return actVendorId;
    }

    public void setActVendorId(int actVendorId) {
        this.actVendorId = actVendorId;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
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

    public String getActType() {
        return actType;
    }

    public void setActType(String actType) {
        this.actType = actType;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getCreatePerson() {
        return createPerson;
    }

    public void setCreatePerson(Integer createPerson) {
        this.createPerson = createPerson;
    }

    public String getDispatchStatus() {
        return dispatchStatus;
    }

    public void setDispatchStatus(String dispatchStatus) {
        this.dispatchStatus = dispatchStatus;
    }

    public int getVendorId() {
        return vendorId;
    }

    public void setVendorId(int vendorId) {
        this.vendorId = vendorId;
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

    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }


    public int getLastDealPersonId() {
        return lastDealPersonId;
    }

    public void setLastDealPersonId(int lastDealPersonId) {
        this.lastDealPersonId = lastDealPersonId;
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

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
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
}
