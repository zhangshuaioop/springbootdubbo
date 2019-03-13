package com.company.springboot.entity.dco;

import java.math.BigDecimal;
import java.util.Date;

public class DcoDemandCustomerOrderFieldService {
    private Integer id;

    private Integer orderId;

    private Integer operationId;

    private String serviceStaffName;

    private String mobile;

    private String wechat;

    private String qq;

    private Date scheduledTime;

    private BigDecimal scheduledFee;

    private String serviceContent;

    private String withEquipment;

    private String memo;

    private Date createTime;

    private Integer createPerson;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getOperationId() {
        return operationId;
    }

    public void setOperationId(Integer operationId) {
        this.operationId = operationId;
    }

    public String getServiceStaffName() {
        return serviceStaffName;
    }

    public void setServiceStaffName(String serviceStaffName) {
        this.serviceStaffName = serviceStaffName == null ? null : serviceStaffName.trim();
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    public String getWechat() {
        return wechat;
    }

    public void setWechat(String wechat) {
        this.wechat = wechat == null ? null : wechat.trim();
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq == null ? null : qq.trim();
    }

    public Date getScheduledTime() {
        return scheduledTime;
    }

    public void setScheduledTime(Date scheduledTime) {
        this.scheduledTime = scheduledTime;
    }

    public BigDecimal getScheduledFee() {
        return scheduledFee;
    }

    public void setScheduledFee(BigDecimal scheduledFee) {
        this.scheduledFee = scheduledFee;
    }

    public String getServiceContent() {
        return serviceContent;
    }

    public void setServiceContent(String serviceContent) {
        this.serviceContent = serviceContent == null ? null : serviceContent.trim();
    }

    public String getWithEquipment() {
        return withEquipment;
    }

    public void setWithEquipment(String withEquipment) {
        this.withEquipment = withEquipment == null ? null : withEquipment.trim();
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo == null ? null : memo.trim();
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