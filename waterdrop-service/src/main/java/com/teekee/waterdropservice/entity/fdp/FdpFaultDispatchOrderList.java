package com.teekee.waterdropservice.entity.fdp;

import java.math.BigDecimal;
import java.util.Date;

public class FdpFaultDispatchOrderList {
    private String dispatchOrderNumber;
    private String vendorName;
    private String companyName;
    private String storeName;
    private String dispatchModelRequest;
    private String province;
    private String city;
    private String serviceDistrict;
    private String serviceAddress;
    private String username;

    private String dispatchStatus;
    private Date updateTime;
    private Date finishTime;
    private Date createTime;
    private int hrCount;
    private String createPerson;
    private BigDecimal actualCost;
    private BigDecimal estimatedCost;
    private BigDecimal estimatedPrice;
    private BigDecimal actualPrice;
    private String dispatchDescription;
    private String equipmentRequest;
    private String otherRequest;
    private Integer lastDealPersonId;
    private String lastDealPerson;
    private boolean flagPaid;
//    private String actualInvoiceType;
//    private BigDecimal actualInvoiceFee;
//    private BigDecimal actualInvoiceRate;
    private String customerSource;
    private String actualMonetaryUnit;
    private String estimatedMonetaryUnit;
    private String actualPriceUnit;
    private String estimatedPriceUnit;
    private String otherSystemNumber;
    private String backupDeviceRequest;
    private Date lastDealTime;
    private Date serviceDate;
    private Date expectReplyTime;
    private Date expectCompleteTime;
    private Integer serviceTimeStart;
    private Integer serviceTimeEnd;

    public Date getExpectReplyTime() {
        return expectReplyTime;
    }

    public void setExpectReplyTime(Date expectReplyTime) {
        this.expectReplyTime = expectReplyTime;
    }

    public Date getExpectCompleteTime() {
        return expectCompleteTime;
    }

    public void setExpectCompleteTime(Date expectCompleteTime) {
        this.expectCompleteTime = expectCompleteTime;
    }

    public Integer getServiceTimeStart() {
        return serviceTimeStart;
    }

    public void setServiceTimeStart(Integer serviceTimeStart) {
        this.serviceTimeStart = serviceTimeStart;
    }

    public Integer getServiceTimeEnd() {
        return serviceTimeEnd;
    }

    public void setServiceTimeEnd(Integer serviceTimeEnd) {
        this.serviceTimeEnd = serviceTimeEnd;
    }

    public Date getServiceDate() {
        return serviceDate;
    }

    public void setServiceDate(Date serviceDate) {
        this.serviceDate = serviceDate;
    }

    public Date getLastDealTime() {
        return lastDealTime;
    }

    public void setLastDealTime(Date lastDealTime) {
        this.lastDealTime = lastDealTime;
    }

    public String getBackupDeviceRequest() {
        return backupDeviceRequest;
    }

    public void setBackupDeviceRequest(String backupDeviceRequest) {
        this.backupDeviceRequest = backupDeviceRequest;
    }

    public String getActualMonetaryUnit() {
        return actualMonetaryUnit;
    }

    public void setActualMonetaryUnit(String actualMonetaryUnit) {
        this.actualMonetaryUnit = actualMonetaryUnit;
    }

    public String getEstimatedMonetaryUnit() {
        return estimatedMonetaryUnit;
    }

    public void setEstimatedMonetaryUnit(String estimatedMonetaryUnit) {
        this.estimatedMonetaryUnit = estimatedMonetaryUnit;
    }

    public String getActualPriceUnit() {
        return actualPriceUnit;
    }

    public void setActualPriceUnit(String actualPriceUnit) {
        this.actualPriceUnit = actualPriceUnit;
    }

    public String getEstimatedPriceUnit() {
        return estimatedPriceUnit;
    }

    public void setEstimatedPriceUnit(String estimatedPriceUnit) {
        this.estimatedPriceUnit = estimatedPriceUnit;
    }

    public String getLastDealPerson() {
        return lastDealPerson;
    }

    public void setLastDealPerson(String lastDealPerson) {
        this.lastDealPerson = lastDealPerson;
    }

    public String getCustomerSource() {
        return customerSource;
    }

    public void setCustomerSource(String customerSource) {
        this.customerSource = customerSource;
    }

    public String getDispatchOrderNumber() {
        return dispatchOrderNumber;
    }

    public void setDispatchOrderNumber(String dispatchOrderNumber) {
        this.dispatchOrderNumber = dispatchOrderNumber;
    }

    public String getVendorName() {
        return vendorName;
    }

    public void setVendorName(String vendorName) {
        this.vendorName = vendorName;
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


    public String getDispatchModelRequest() {
        return dispatchModelRequest;
    }

    public void setDispatchModelRequest(String dispatchModelRequest) {
        this.dispatchModelRequest = dispatchModelRequest;
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

    public String getDispatchStatus() {
        return dispatchStatus;
    }

    public void setDispatchStatus(String dispatchStatus) {
        this.dispatchStatus = dispatchStatus;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Date getFinishTime() {
        return finishTime;
    }

    public void setFinishTime(Date finishTime) {
        this.finishTime = finishTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public int getHrCount() {
        return hrCount;
    }

    public void setHrCount(int hrCount) {
        this.hrCount = hrCount;
    }

    public String getCreatePerson() {
        return createPerson;
    }

    public void setCreatePerson(String createPerson) {
        this.createPerson = createPerson;
    }

    public BigDecimal getActualCost() {
        return actualCost;
    }

    public void setActualCost(BigDecimal actualCost) {
        this.actualCost = actualCost;
    }

    public BigDecimal getEstimatedCost() {
        return estimatedCost;
    }

    public void setEstimatedCost(BigDecimal estimatedCost) {
        this.estimatedCost = estimatedCost;
    }

    public BigDecimal getEstimatedPrice() {
        return estimatedPrice;
    }

    public void setEstimatedPrice(BigDecimal estimatedPrice) {
        this.estimatedPrice = estimatedPrice;
    }

    public BigDecimal getActualPrice() {
        return actualPrice;
    }

    public void setActualPrice(BigDecimal actualPrice) {
        this.actualPrice = actualPrice;
    }

    public String getDispatchDescription() {
        return dispatchDescription;
    }

    public void setDispatchDescription(String dispatchDescription) {
        this.dispatchDescription = dispatchDescription;
    }

    public String getEquipmentRequest() {
        return equipmentRequest;
    }

    public void setEquipmentRequest(String equipmentRequest) {
        this.equipmentRequest = equipmentRequest;
    }

    public String getOtherRequest() {
        return otherRequest;
    }

    public void setOtherRequest(String otherRequest) {
        this.otherRequest = otherRequest;
    }



    public Integer getLastDealPersonId() {
        return lastDealPersonId;
    }

    public void setLastDealPersonId(Integer lastDealPersonId) {
        this.lastDealPersonId = lastDealPersonId;
    }


    public boolean isFlagPaid() {
        return flagPaid;
    }

    public void setFlagPaid(boolean flagPaid) {
        this.flagPaid = flagPaid;
    }

    public String getServiceDistrict() {
        return serviceDistrict;
    }

    public void setServiceDistrict(String serviceDistrict) {
        this.serviceDistrict = serviceDistrict;
    }

    public String getServiceAddress() {
        return serviceAddress;
    }

    public void setServiceAddress(String serviceAddress) {
        this.serviceAddress = serviceAddress;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getOtherSystemNumber() {
        return otherSystemNumber;
    }

    public void setOtherSystemNumber(String otherSystemNumber) {
        this.otherSystemNumber = otherSystemNumber;
    }
    //    public String getActualInvoiceType() {
//        return actualInvoiceType;
//    }
//
//    public void setActualInvoiceType(String actualInvoiceType) {
//        this.actualInvoiceType = actualInvoiceType;
//    }
//
//    public BigDecimal getActualInvoiceFee() {
//        return actualInvoiceFee;
//    }
//
//    public void setActualInvoiceFee(BigDecimal actualInvoiceFee) {
//        this.actualInvoiceFee = actualInvoiceFee;
//    }
//
//    public BigDecimal getActualInvoiceRate() {
//        return actualInvoiceRate;
//    }
//
//    public void setActualInvoiceRate(BigDecimal actualInvoiceRate) {
//        this.actualInvoiceRate = actualInvoiceRate;
//    }
}
