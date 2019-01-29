package com.teekee.blackrockservice.entity.fdp;

import com.teekee.commoncomponets.base.BaseEntity;

import java.math.BigDecimal;
import java.util.Date;

public class FdpFaultDispatchOrder extends BaseEntity{
    private Integer id;

    private Integer companyId;

    private Integer storeId;

    private Integer faultOrderId;

    private Integer rootFaultOrderId;

    private Integer faultDispatchRequestId;

    private Integer hrCount;

    private String dispatchOrderNumber;

    private Date estimatedServiceTime;

    private BigDecimal actualCost;

    private String actualMonetaryUnit;

    private String memo;

    private Boolean flagDeleted;

    private Boolean flagAvailable;

    private Boolean flagFinish;

    private String finishType;

    private Boolean flagPaid;

    private String actualInvoiceType;

    private String actualInvoiceTitle;

    private String actualInvoiceTaxIdNumber;

    private String actualInvoiceNumber;

    private BigDecimal actualInvoiceFee;

    private BigDecimal actualInvoiceRate;

    private BigDecimal actualPrice;

    private String actualPriceUnit;

    private Integer lastDealPersonId;

    private Date lastDealTime;

    private String dispatchStatus;

    private Integer vendorId;

    private boolean flagCustomerConfirm;


    private boolean flagDispatcherConfirm;

  //  private boolean flagHasdispatched;



//public boolean isFlagCustomerConfirm() {
    //    return flagCustomerConfirm;
    //}
    //
    //public boolean isFlagDispatcherConfirm() {
    //    return flagDispatcherConfirm;
    //}
    //
    //public boolean isFlagHasdispatched() {
    //    return flagHasdispatched;
    //}

    public void setFlagCustomerConfirm(boolean flagCustomerConfirm) {
        this.flagCustomerConfirm = flagCustomerConfirm;
    }
    public boolean getFlagCustomerConfirm() {
        return flagCustomerConfirm;
    }


    public boolean getFlagDispatcherConfirm() {
        return flagDispatcherConfirm;
    }

    public void setFlagDispatcherConfirm(boolean flagDispatcherConfirm) {
        this.flagDispatcherConfirm = flagDispatcherConfirm;
    }

    public Integer getVendorId() {
        return vendorId;
    }

    public void setVendorId(Integer vendorId) {
        this.vendorId = vendorId;
    }

    public BigDecimal getActualPrice() {
        return actualPrice;
    }

    public void setActualPrice(BigDecimal actualPrice) {
        this.actualPrice = actualPrice;
    }

    public String getActualPriceUnit() {
        return actualPriceUnit;
    }

    public void setActualPriceUnit(String actualPriceUnit) {
        this.actualPriceUnit = actualPriceUnit;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Integer getFaultOrderId() {
        return faultOrderId;
    }

    public void setFaultOrderId(Integer faultOrderId) {
        this.faultOrderId = faultOrderId;
    }

    public Integer getRootFaultOrderId() {
        return rootFaultOrderId;
    }

    public void setRootFaultOrderId(Integer rootFaultOrderId) {
        this.rootFaultOrderId = rootFaultOrderId;
    }

    public Integer getFaultDispatchRequestId() {
        return faultDispatchRequestId;
    }

    public void setFaultDispatchRequestId(Integer faultDispatchRequestId) {
        this.faultDispatchRequestId = faultDispatchRequestId;
    }

    public Integer getHrCount() {
        return hrCount;
    }

    public void setHrCount(Integer hrCount) {
        this.hrCount = hrCount;
    }

    public String getDispatchOrderNumber() {
        return dispatchOrderNumber;
    }

    public void setDispatchOrderNumber(String dispatchOrderNumber) {
        this.dispatchOrderNumber = dispatchOrderNumber == null ? null : dispatchOrderNumber.trim();
    }

    public Date getEstimatedServiceTime() {
        return estimatedServiceTime;
    }

    public void setEstimatedServiceTime(Date estimatedServiceTime) {
        this.estimatedServiceTime = estimatedServiceTime;
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
        this.actualMonetaryUnit = actualMonetaryUnit == null ? null : actualMonetaryUnit.trim();
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo == null ? null : memo.trim();
    }

    public Boolean getFlagDeleted() {
        return flagDeleted;
    }

    public void setFlagDeleted(Boolean flagDeleted) {
        this.flagDeleted = flagDeleted;
    }

    public Boolean getFlagAvailable() {
        return flagAvailable;
    }

    public void setFlagAvailable(Boolean flagAvailable) {
        this.flagAvailable = flagAvailable;
    }

    public Boolean getFlagFinish() {
        return flagFinish;
    }

    public void setFlagFinish(Boolean flagFinish) {
        this.flagFinish = flagFinish;
    }

    public String getFinishType() {
        return finishType;
    }

    public void setFinishType(String finishType) {
        this.finishType = finishType == null ? null : finishType.trim();
    }

    public Boolean getFlagPaid() {
        return flagPaid;
    }

    public void setFlagPaid(Boolean flagPaid) {
        this.flagPaid = flagPaid;
    }

    public String getActualInvoiceType() {
        return actualInvoiceType;
    }

    public void setActualInvoiceType(String actualInvoiceType) {
        this.actualInvoiceType = actualInvoiceType == null ? null : actualInvoiceType.trim();
    }

    public String getActualInvoiceTitle() {
        return actualInvoiceTitle;
    }

    public void setActualInvoiceTitle(String actualInvoiceTitle) {
        this.actualInvoiceTitle = actualInvoiceTitle == null ? null : actualInvoiceTitle.trim();
    }

    public String getActualInvoiceTaxIdNumber() {
        return actualInvoiceTaxIdNumber;
    }

    public void setActualInvoiceTaxIdNumber(String actualInvoiceTaxIdNumber) {
        this.actualInvoiceTaxIdNumber = actualInvoiceTaxIdNumber == null ? null : actualInvoiceTaxIdNumber.trim();
    }

    public String getActualInvoiceNumber() {
        return actualInvoiceNumber;
    }

    public void setActualInvoiceNumber(String actualInvoiceNumber) {
        this.actualInvoiceNumber = actualInvoiceNumber == null ? null : actualInvoiceNumber.trim();
    }

    public BigDecimal getActualInvoiceFee() {
        return actualInvoiceFee;
    }

    public void setActualInvoiceFee(BigDecimal actualInvoiceFee) {
        this.actualInvoiceFee = actualInvoiceFee;
    }

    public BigDecimal getActualInvoiceRate() {
        return actualInvoiceRate;
    }

    public void setActualInvoiceRate(BigDecimal actualInvoiceRate) {
        this.actualInvoiceRate = actualInvoiceRate;
    }

    public Integer getLastDealPersonId() {
        return lastDealPersonId;
    }

    public void setLastDealPersonId(Integer lastDealPersonId) {
        this.lastDealPersonId = lastDealPersonId;
    }

    public Date getLastDealTime() {
        return lastDealTime;
    }

    public void setLastDealTime(Date lastDealTime) {
        this.lastDealTime = lastDealTime;
    }

    public String getDispatchStatus() {
        return dispatchStatus;
    }

    public void setDispatchStatus(String dispatchStatus) {
        this.dispatchStatus = dispatchStatus == null ? null : dispatchStatus.trim();
    }
}