package com.teekee.waterdropservice.entity.dco;

import java.util.Date;

public class DcoDemandCustomerOrderDto {
    private Integer id;

    // 工单编号
    private String orderCode;

    // 品牌ID
    private Integer brandId;

    // 品牌名字
    private String brandName;

    // 门店名字
    private String storeName;

    // 工单描述
    private String orderContent;

    // 工单类型
    private String orderType;

    // 工单状态
    private Integer orderStatus;

    // 工作状态
    private String processStatus;

    // 当前紧急等级
    private String currentUrgencyStatus;

    // 受理人
    private Integer createPerson;

    // 受理时间
    private Date createTime;

    // 雇主ID
    private Integer companyId;

    // 当前处理人
    private Integer dealPerson;

    private String createPersonName;

    public String getProcessStatus() {
        return processStatus;
    }

    public void setProcessStatus(String processStatus) {
        this.processStatus = processStatus;
    }

    public Integer getDealPerson() {
        return dealPerson;
    }

    public void setDealPerson(Integer dealPerson) {
        this.dealPerson = dealPerson;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    public Integer getBrandId() {
        return brandId;
    }

    public void setBrandId(Integer brandId) {
        this.brandId = brandId;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getOrderContent() {
        return orderContent;
    }

    public void setOrderContent(String orderContent) {
        this.orderContent = orderContent;
    }

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    public Integer getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getCurrentUrgencyStatus() {
        return currentUrgencyStatus;
    }

    public void setCurrentUrgencyStatus(String currentUrgencyStatus) {
        this.currentUrgencyStatus = currentUrgencyStatus;
    }

    public Integer getCreatePerson() {
        return createPerson;
    }

    public void setCreatePerson(Integer createPerson) {
        this.createPerson = createPerson;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public String getCreatePersonName() {
        return createPersonName;
    }

    public void setCreatePersonName(String createPersonName) {
        this.createPersonName = createPersonName;
    }
}