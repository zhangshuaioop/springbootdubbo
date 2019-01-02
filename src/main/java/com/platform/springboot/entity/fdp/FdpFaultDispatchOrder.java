package com.platform.springboot.entity.fdp;

import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;
import java.util.Date;

public class FdpFaultDispatchOrder {

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

    private Date sendHrInfoConfirmTime;

    private Date customerHrInfoConfirmTime;

    private Date dispatcherFinalConfirmTime;

    private Date customerFinalConfirmTime;

    private String processStage;

    private String cancelReason;

    private String abandonReason;

    private String actualCostMemo;

    private String actualPriceMemo;

    private boolean flagNoPrice;

    private String privateNote;
    /**
     * 附件名称
     */
    private String uploadFileName;
    /**
     * 附件URL
     */
    private String uploadFileUrl;
    /**
     * 完工资料模板URL
     */
    private String completeProfileTemplateUrl;
    /**
     * 完工资料模板名称
     */
    private String completeProfileTemplateName;
    /**
     * 是否自动提交完工
     */
    private boolean flagAutoCommit;

    private String batchNumber;

    /**
     * 结束时间
     */
    private Date finishTime;

    @ApiModelProperty(value = "人员驳回原因", example = "1", required = true)
    private String personRejectCauseContext;

    @ApiModelProperty(value = "完工资料驳回原因", example = "1", required = true)
    private String materialRejectCauseContext;

    public String getBatchNumber() {
        return batchNumber;
    }

    public void setBatchNumber(String batchNumber) {
        this.batchNumber = batchNumber;
    }

    public boolean getFlagNoPrice() {
        return flagNoPrice;
    }

    public void setFlagNoPrice(boolean flagNoPrice) {
        this.flagNoPrice = flagNoPrice;
    }

    public String getProcessStage() {
        return processStage;
    }

    public void setProcessStage(String processStage) {
        this.processStage = processStage;
    }

    public Date getDispatcherFinalConfirmTime() {
        return dispatcherFinalConfirmTime;
    }

    public void setDispatcherFinalConfirmTime(Date dispatcherFinalConfirmTime) {
        this.dispatcherFinalConfirmTime = dispatcherFinalConfirmTime;
    }

    public Date getCustomerFinalConfirmTime() {
        return customerFinalConfirmTime;
    }

    public void setCustomerFinalConfirmTime(Date customerFinalConfirmTime) {
        this.customerFinalConfirmTime = customerFinalConfirmTime;
    }

    public Date getCustomerHrInfoConfirmTime() {
        return customerHrInfoConfirmTime;
    }

    public void setCustomerHrInfoConfirmTime(Date customerHrInfoConfirmTime) {
        this.customerHrInfoConfirmTime = customerHrInfoConfirmTime;
    }

    public Date getSendHrInfoConfirmTime() {
        return sendHrInfoConfirmTime;
    }

    public void setSendHrInfoConfirmTime(Date sendHrInfoConfirmTime) {
        this.sendHrInfoConfirmTime = sendHrInfoConfirmTime;
    }

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

    public String getCancelReason() {
        return cancelReason;
    }

    public void setCancelReason(String cancelReason) {
        this.cancelReason = cancelReason;
    }

    public String getAbandonReason() {
        return abandonReason;
    }

    public void setAbandonReason(String abandonReason) {
        this.abandonReason = abandonReason;
    }

    public String getActualCostMemo() {
        return actualCostMemo;
    }

    public void setActualCostMemo(String actualCostMemo) {
        this.actualCostMemo = actualCostMemo;
    }

    public String getActualPriceMemo() {
        return actualPriceMemo;
    }

    public void setActualPriceMemo(String actualPriceMemo) {
        this.actualPriceMemo = actualPriceMemo;
    }

    public String getPrivateNote() {
        return privateNote;
    }

    public void setPrivateNote(String privateNote) {
        this.privateNote = privateNote;
    }

    public String getUploadFileName() {
        return uploadFileName;
    }

    public void setUploadFileName(String uploadFileName) {
        this.uploadFileName = uploadFileName;
    }

    public String getUploadFileUrl() {
        return uploadFileUrl;
    }

    public void setUploadFileUrl(String uploadFileUrl) {
        this.uploadFileUrl = uploadFileUrl;
    }

    public String getCompleteProfileTemplateUrl() {
        return completeProfileTemplateUrl;
    }

    public void setCompleteProfileTemplateUrl(String completeProfileTemplateUrl) {
        this.completeProfileTemplateUrl = completeProfileTemplateUrl;
    }

    public String getCompleteProfileTemplateName() {
        return completeProfileTemplateName;
    }

    public void setCompleteProfileTemplateName(String completeProfileTemplateName) {
        this.completeProfileTemplateName = completeProfileTemplateName;
    }

    public boolean isFlagAutoCommit() {
        return flagAutoCommit;
    }

    public void setFlagAutoCommit(boolean flagAutoCommit) {
        this.flagAutoCommit = flagAutoCommit;
    }

    public Date getFinishTime() {
        return finishTime;
    }

    public void setFinishTime(Date finishTime) {
        this.finishTime = finishTime;
    }

    public String getPersonRejectCauseContext() {
        return personRejectCauseContext;
    }

    public void setPersonRejectCauseContext(String personRejectCauseContext) {
        this.personRejectCauseContext = personRejectCauseContext;
    }

    public String getMaterialRejectCauseContext() {
        return materialRejectCauseContext;
    }

    public void setMaterialRejectCauseContext(String materialRejectCauseContext) {
        this.materialRejectCauseContext = materialRejectCauseContext;
    }
}