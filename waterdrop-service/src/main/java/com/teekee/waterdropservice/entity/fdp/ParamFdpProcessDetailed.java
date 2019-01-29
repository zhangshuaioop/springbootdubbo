package com.teekee.waterdropservice.entity.fdp;

import com.teekee.commoncomponets.base.BaseEntity;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @Author Niting
 * @date 2018/6/13
 **/
public class ParamFdpProcessDetailed extends BaseEntity {
    private Integer companyId;
    private String opearteStatus;
    private Integer dealPersonId;
    private Date createTimeStart;
    private Date createTimeEnd;
    private Date userCompleteTimeStart;
    private Date userCompleteTimeEnd;
    private BigDecimal actualPriceStart;
    private BigDecimal actualPriceEnd;
    private BigDecimal estimatedPriceStart;
    private BigDecimal estimatedPriceEnd;
    private String province;
    private String inputType;
    private Integer userId;
    private String actType;
    private String source;
    private String status;
    private String city;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getActType() {
        return actType;
    }

    public void setActType(String actType) {
        this.actType = actType;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public String getOpearteStatus() {
        return opearteStatus;
    }

    public void setOpearteStatus(String opearteStatus) {
        this.opearteStatus = opearteStatus;
    }

    public Integer getDealPersonId() {
        return dealPersonId;
    }

    public void setDealPersonId(Integer dealPersonId) {
        this.dealPersonId = dealPersonId;
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

    public String getInputType() {
        return inputType;
    }

    public void setInputType(String inputType) {
        this.inputType = inputType;
    }
}
