package com.platform.springboot.entity.dco;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class DcoDemandCustomerOrderOperationDetail extends DcoDemandCustomerOrderOperation {
    private List<DcoDemandCustomerOrderUploadFile> uploadFileList;

    private String operatorType;

    // 外派服务的信息
    private String serviceStaffName;
    private String mobile;
    private String wechat;
    private String qq;
    private Date scheduledTime;
    private BigDecimal scheduledFee;
    private String serviceContent;
    private String withEquipment;
    private String memo;
    private boolean flagService;

    private Integer dealPerson;
    private String dealPersonName;

    public boolean isFlagService() {
        return flagService;
    }

    public void setFlagService(boolean flagService) {
        this.flagService = flagService;
    }

    public String getDealPersonName() {
        return dealPersonName;
    }

    public void setDealPersonName(String dealPersonName) {
        this.dealPersonName = dealPersonName;
    }

    public Integer getDealPerson() {
        return dealPerson;
    }

    public void setDealPerson(Integer dealPerson) {
        this.dealPerson = dealPerson;
    }

    public String getOperatorType() {
        return operatorType;
    }

    public String getServiceStaffName() {
        return serviceStaffName;
    }

    public void setServiceStaffName(String serviceStaffName) {
        this.serviceStaffName = serviceStaffName;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getWechat() {
        return wechat;
    }

    public void setWechat(String wechat) {
        this.wechat = wechat;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public Date getScheduledTime() {
        return scheduledTime;
    }

    public void setScheduledTime(Date scheduledTime) {
        this.scheduledTime = scheduledTime;
    }

    public String getServiceContent() {
        return serviceContent;
    }

    public void setServiceContent(String serviceContent) {
        this.serviceContent = serviceContent;
    }

    public String getWithEquipment() {
        return withEquipment;
    }

    public void setWithEquipment(String withEquipment) {
        this.withEquipment = withEquipment;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public void setOperatorType(String operatorType) {
        this.operatorType = operatorType;
    }

    public List<DcoDemandCustomerOrderUploadFile> getUploadFileList() {
        return uploadFileList;
    }

    public void setUploadFileList(List<DcoDemandCustomerOrderUploadFile> uploadFileList) {
        this.uploadFileList = uploadFileList;
    }

    public BigDecimal getScheduledFee() {
        return scheduledFee;
    }

    public void setScheduledFee(BigDecimal scheduledFee) {
        this.scheduledFee = scheduledFee;
    }
}