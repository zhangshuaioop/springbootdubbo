package com.teekee.blueoceanservice.entity.fdp;

import java.util.Date;

/**
 * 查看指定报障信息
 *
 * @author Wujun
 * @create 2018年01月23日 10:10
 */
public class EntityFaultReportInfoDetail {
    private int companyId;
    private int storeId;
    private String companyName;
    private String storeName;
    private String reportNumber;
    private String serviceAddress;
    private int contactId;
    private String contactName;
    private String telephone;
    private String basicFaultType;
    private String faultDescription;
    private String memo;
    private String urgencyRequest;
    private Date serviceDate;
    private int serviceTimeStart;
    private int serviceTimeEnd;
    private Date faultInfoConfirmTime;

    public Date getFaultInfoConfirmTime() {
        return faultInfoConfirmTime;
    }

    public void setFaultInfoConfirmTime(Date faultInfoConfirmTime) {
        this.faultInfoConfirmTime = faultInfoConfirmTime;
    }

    public int getContactId() {
        return contactId;
    }

    public void setContactId(int contactId) {
        this.contactId = contactId;
    }

    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    public int getStoreId() {
        return storeId;
    }

    public void setStoreId(int storeId) {
        this.storeId = storeId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getReportNumber() {
        return reportNumber;
    }

    public void setReportNumber(String reportNumber) {
        this.reportNumber = reportNumber;
    }

    public String getServiceAddress() {
        return serviceAddress;
    }

    public void setServiceAddress(String serviceAddress) {
        this.serviceAddress = serviceAddress;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getBasicFaultType() {
        return basicFaultType;
    }

    public void setBasicFaultType(String basicFaultType) {
        this.basicFaultType = basicFaultType;
    }

    public String getFaultDescription() {
        return faultDescription;
    }

    public void setFaultDescription(String faultDescription) {
        this.faultDescription = faultDescription;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public int getServiceTimeStart() {
        return serviceTimeStart;
    }

    public void setServiceTimeStart(int serviceTimeStart) {
        this.serviceTimeStart = serviceTimeStart;
    }

    public int getServiceTimeEnd() {
        return serviceTimeEnd;
    }

    public void setServiceTimeEnd(int serviceTimeEnd) {
        this.serviceTimeEnd = serviceTimeEnd;
    }

    public String getUrgencyRequest() {
        return urgencyRequest;
    }

    public void setUrgencyRequest(String urgencyRequest) {
        this.urgencyRequest = urgencyRequest;
    }

    public Date getServiceDate() {
        return serviceDate;
    }

    public void setServiceDate(Date serviceDate) {
        this.serviceDate = serviceDate;
    }
}
