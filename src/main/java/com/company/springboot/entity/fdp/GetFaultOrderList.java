package com.company.springboot.entity.fdp;

import java.util.Date;

/**
 * 查询符合条件的故障工单列表
 *
 * @author Wujun
 * @create 2018年01月22日 14:25
 */
public class GetFaultOrderList {
    private String companyName;
    private int id;
    private String reportNumber;
    private int storeId;
    private String storeName;
    private String brandName;
    private String basicFaultType;
    private String faultType;
    private String opearteStatus;
    private String estimatedCost;
    private String actualCost;
    private String urgencyServiceDate;
    private String dealPerson;
    private int dealpersonId;
    private int processId;
    private Date updateTime;
    private int rootId;
    private int sortId;
    private Integer requestId;
    private int belongPersonId;
    private boolean flagUserself;
    private boolean flagHasMultiple;
    private String faultOrderNumber;
    private String estimatedPrice;
    private String estimatedPriceUnit;
    private String actualPrice;
    private String actualPriceUnit;
    private String dispatchStatus;
    private Integer createPerson;
    private Integer dispatchOrderId;
    private String inputType;
    private String processStage;
    private Date createTime;
    private boolean flagDispatcherConfirm;

    public boolean getFlagDispatcherConfirm() {
        return flagDispatcherConfirm;
    }

    public void setFlagDispatcherConfirm(boolean flagDispatcherConfirm) {
        this.flagDispatcherConfirm = flagDispatcherConfirm;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getProcessStage() {
        return processStage;
    }

    public void setProcessStage(String processStage) {
        this.processStage = processStage;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getInputType() {
        return inputType;
    }

    public void setInputType(String inputType) {
        this.inputType = inputType;
    }

    public Integer getDispatchOrderId() {
        return dispatchOrderId;
    }

    public void setDispatchOrderId(Integer dispatchOrderId) {
        this.dispatchOrderId = dispatchOrderId;
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

    public String getActualPriceUnit() {
        return actualPriceUnit;
    }

    public void setActualPriceUnit(String actualPriceUnit) {
        this.actualPriceUnit = actualPriceUnit;
    }

    public String getActualPrice() {
        return actualPrice;
    }

    public void setActualPrice(String actualPrice) {
        this.actualPrice = actualPrice;
    }

    public String getEstimatedPrice() {
        return estimatedPrice;
    }

    public void setEstimatedPrice(String estimatedPrice) {
        this.estimatedPrice = estimatedPrice;
    }

    public String getEstimatedPriceUnit() {
        return estimatedPriceUnit;
    }

    public void setEstimatedPriceUnit(String estimatedPriceUnit) {
        this.estimatedPriceUnit = estimatedPriceUnit;
    }

    public String getFaultOrderNumber() {
        return faultOrderNumber;
    }

    public void setFaultOrderNumber(String faultOrderNumber) {
        this.faultOrderNumber = faultOrderNumber;
    }

    public boolean isFlagHasMultiple() {
        return flagHasMultiple;
    }

    public void setFlagHasMultiple(boolean flagHasMultiple) {
        this.flagHasMultiple = flagHasMultiple;
    }

    public int getBelongPersonId() {
        return belongPersonId;
    }

    public void setBelongPersonId(int belongPersonId) {
        this.belongPersonId = belongPersonId;
    }

    public boolean isFlagUserself() {
        return flagUserself;
    }

    public void setFlagUserself(boolean flagUserself) {
        this.flagUserself = flagUserself;
    }
    private int sourceReportId;


    public int getSortId() {
        return sortId;
    }

    public void setSortId(int sortId) {
        this.sortId = sortId;
    }

    public int getSourceReportId() {
        return sourceReportId;
    }

    public void setSourceReportId(int sourceReportId) {
        this.sourceReportId = sourceReportId;
    }

    public String getFaultType() {
        return faultType;
    }

    public void setFaultType(String faultType) {
        this.faultType = faultType;
    }

    public Integer getRequestId() {
        return requestId;
    }

    public void setRequestId(Integer requestId) {
        this.requestId = requestId;
    }

    public int getRootId() {
        return rootId;
    }

    public void setRootId(int rootId) {
        this.rootId = rootId;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public int getProcessId() {
        return processId;
    }

    public void setProcessId(int processId) {
        this.processId = processId;
    }

    public String getEstimatedCost() {
        return estimatedCost;
    }

    public void setEstimatedCost(String estimatedCost) {
        this.estimatedCost = estimatedCost;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getReportNumber() {
        return reportNumber;
    }

    public void setReportNumber(String reportNumber) {
        this.reportNumber = reportNumber;
    }

    public int getStoreId() {
        return storeId;
    }

    public void setStoreId(int storeId) {
        this.storeId = storeId;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
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

    public String getActualCost() {
        return actualCost;
    }

    public void setActualCost(String actualCost) {
        this.actualCost = actualCost;
    }

    public String getUrgencyServiceDate() {
        return urgencyServiceDate;
    }

    public void setUrgencyServiceDate(String urgencyServiceDate) {
        this.urgencyServiceDate = urgencyServiceDate;
    }

    public String getDealPerson() {
        return dealPerson;
    }

    public void setDealPerson(String dealPerson) {
        this.dealPerson = dealPerson;
    }

    public int getDealpersonId() {
        return dealpersonId;
    }

    public void setDealpersonId(int dealpersonId) {
        this.dealpersonId = dealpersonId;
    }


}
