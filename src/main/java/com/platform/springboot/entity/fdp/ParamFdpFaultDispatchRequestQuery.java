package com.platform.springboot.entity.fdp;

import com.platform.springboot.base.BaseEntity;
import com.platform.springboot.base.BaseEntity;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 用于派工列表查询传入参数
 */
public class ParamFdpFaultDispatchRequestQuery extends BaseEntity {

	private Integer companyId;

	private Integer storeId;

	private Integer createPerson;

	private String dispatchType;

	private Date applyDateStart;

	private Date applyDateEnd;

	private Date finishDateStart;

	private Date finishDateEnd;

	private BigDecimal estimatedCost;

	private String estimatedMonetaryUnit;

	private BigDecimal actualCost;

	private String actualMonetaryUnit;

	private Integer userId;

	private String faultOrderNumber;

	private String dispatchStatus;


	private String dispatchOrderNumber;

	private String actType;

	private Integer actObjectId;

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

	public String getDispatchOrderNumber() {
		return dispatchOrderNumber;
	}

	public void setDispatchOrderNumber(String dispatchOrderNumber) {
		this.dispatchOrderNumber = dispatchOrderNumber;
	}

	public String getFaultOrderNumber() {
		return faultOrderNumber;
	}

	public void setFaultOrderNumber(String faultOrderNumber) {
		this.faultOrderNumber = faultOrderNumber;
	}

	public String getDispatchStatus() {
		return dispatchStatus;
	}

	public void setDispatchStatus(String dispatchStatus) {
		this.dispatchStatus = dispatchStatus;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
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
		this.estimatedMonetaryUnit = estimatedMonetaryUnit;
	}

	public BigDecimal getActualCost() {
		return actualCost;
	}

	public void setActualCost(BigDecimal actualCost) {
		this.actualCost = actualCost;
	}

	public String getActualMonetaryUnit() {
		return actualMonetaryUnit;
	}

	public void setActualMonetaryUnit(String actualMonetaryUnit) {
		this.actualMonetaryUnit = actualMonetaryUnit;
	}

	public Integer getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Integer companyId) {
		this.companyId = companyId;
	}

	public Integer getStoreId() {
		return storeId;
	}

	public void setStoreId(Integer storeId) {
		this.storeId = storeId;
	}

	public Integer getCreatePerson() {
		return createPerson;
	}

	public void setCreatePerson(Integer createPerson) {
		this.createPerson = createPerson;
	}

	public String getDispatchType() {
		return dispatchType;
	}

	public void setDispatchType(String dispatchType) {
		this.dispatchType = dispatchType;
	}

	public Date getApplyDateStart() {
		return applyDateStart;
	}

	public void setApplyDateStart(Date applyDateStart) {
		this.applyDateStart = applyDateStart;
	}

	public Date getApplyDateEnd() {
		return applyDateEnd;
	}

	public void setApplyDateEnd(Date applyDateEnd) {
		this.applyDateEnd = applyDateEnd;
	}

	public Date getFinishDateStart() {
		return finishDateStart;
	}

	public void setFinishDateStart(Date finishDateStart) {
		this.finishDateStart = finishDateStart;
	}

	public Date getFinishDateEnd() {
		return finishDateEnd;
	}

	public void setFinishDateEnd(Date finishDateEnd) {
		this.finishDateEnd = finishDateEnd;
	}
}
