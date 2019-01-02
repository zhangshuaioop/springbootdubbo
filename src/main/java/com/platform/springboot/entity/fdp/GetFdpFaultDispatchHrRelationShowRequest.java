package com.platform.springboot.entity.fdp;/**
 * @Author Niting
 * @Create 2018/5/22
 */

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 *
 *@Author Niting
 *@date 2018/5/22
 **/
public class GetFdpFaultDispatchHrRelationShowRequest {
    private Integer id;

    private Integer dispatchOrderId;

    private Integer faultDispatchRequestId;

    private Integer dispatchMainHrId;

    private Integer hrAccountInfoId;

    private BigDecimal estimatedCost;

    private String estimatedMonetaryUnit;

    private String estimatedInvoiceType;

    private BigDecimal estimatedInvoiceRate;

    private Boolean flagProvideInvoice;

    private String memo;

    private Boolean flagDeleted;

    private Boolean flagAvailable;

    private Integer userAssmAchievePoint;

    private Integer userAssmCommunicationPoint;

    private Integer userAssmTimelyPoint;

    private Integer clientAssmAchievePoint;

    private Integer clientAssmCommunicationPoint;

    private Integer clientAssmTimelyPoint;

    private String userCompleteProfileFile;

    private String userCompleteProfileFileName;

    private String userCompleteProfilePhoto;

    private String userCompleteProfilePhotoName;

    private Date userCompleteTime;

    private String userJobPerformance;

    private String userJobEndReason;

    private String clientCompleteProfileFile;

    private String clientCompleteProfileFileName;

    private Date clientCompleteTime;

    private Boolean flagUsed;

    private BigDecimal estimatedPrice;

    private String estimatedPriceUnit;

    private Date estimatedServiceTime;

    private String  dispatchDescription;

    private BigDecimal actualCost;

    private String actualMonetaryUnit;

    private BigDecimal actualPrice;

    private String actualPriceUnit;

    private List<FdpDispatchJobPerformance> jobPerformances;

    private String actualPriceMemo;

    private String actualCostMemo;

    private String estimatedCostMemo;

    private String estimatedPriceMemo;

    private String privateNote;

    private String materialRejectCauseContext;

    private String personRejectCauseContext;

    public String getPersonRejectCauseContext() {
        return personRejectCauseContext;
    }

    public void setPersonRejectCauseContext(String personRejectCauseContext) {
        this.personRejectCauseContext = personRejectCauseContext;
    }

    public List<FdpDispatchJobPerformance> getJobPerformances() {
        return jobPerformances;
    }

    public void setJobPerformances(List<FdpDispatchJobPerformance> jobPerformances) {
        this.jobPerformances = jobPerformances;
    }

    public String getMaterialRejectCauseContext() {
        return materialRejectCauseContext;
    }

    public void setMaterialRejectCauseContext(String materialRejectCauseContext) {
        this.materialRejectCauseContext = materialRejectCauseContext;
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

    public Integer getDispatchOrderId() {
        return dispatchOrderId;
    }

    public void setDispatchOrderId(Integer dispatchOrderId) {
        this.dispatchOrderId = dispatchOrderId;
    }

    public Integer getFaultDispatchRequestId() {
        return faultDispatchRequestId;
    }

    public void setFaultDispatchRequestId(Integer faultDispatchRequestId) {
        this.faultDispatchRequestId = faultDispatchRequestId;
    }

    public Integer getDispatchMainHrId() {
        return dispatchMainHrId;
    }

    public void setDispatchMainHrId(Integer dispatchMainHrId) {
        this.dispatchMainHrId = dispatchMainHrId;
    }

    public Integer getHrAccountInfoId() {
        return hrAccountInfoId;
    }

    public void setHrAccountInfoId(Integer hrAccountInfoId) {
        this.hrAccountInfoId = hrAccountInfoId;
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

    public String getEstimatedInvoiceType() {
        return estimatedInvoiceType;
    }

    public void setEstimatedInvoiceType(String estimatedInvoiceType) {
        this.estimatedInvoiceType = estimatedInvoiceType;
    }

    public BigDecimal getEstimatedInvoiceRate() {
        return estimatedInvoiceRate;
    }

    public void setEstimatedInvoiceRate(BigDecimal estimatedInvoiceRate) {
        this.estimatedInvoiceRate = estimatedInvoiceRate;
    }

    public Boolean getFlagProvideInvoice() {
        return flagProvideInvoice;
    }

    public void setFlagProvideInvoice(Boolean flagProvideInvoice) {
        this.flagProvideInvoice = flagProvideInvoice;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
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

    public Integer getUserAssmAchievePoint() {
        return userAssmAchievePoint;
    }

    public void setUserAssmAchievePoint(Integer userAssmAchievePoint) {
        this.userAssmAchievePoint = userAssmAchievePoint;
    }

    public Integer getUserAssmCommunicationPoint() {
        return userAssmCommunicationPoint;
    }

    public void setUserAssmCommunicationPoint(Integer userAssmCommunicationPoint) {
        this.userAssmCommunicationPoint = userAssmCommunicationPoint;
    }

    public Integer getUserAssmTimelyPoint() {
        return userAssmTimelyPoint;
    }

    public void setUserAssmTimelyPoint(Integer userAssmTimelyPoint) {
        this.userAssmTimelyPoint = userAssmTimelyPoint;
    }

    public Integer getClientAssmAchievePoint() {
        return clientAssmAchievePoint;
    }

    public void setClientAssmAchievePoint(Integer clientAssmAchievePoint) {
        this.clientAssmAchievePoint = clientAssmAchievePoint;
    }

    public Integer getClientAssmCommunicationPoint() {
        return clientAssmCommunicationPoint;
    }

    public void setClientAssmCommunicationPoint(Integer clientAssmCommunicationPoint) {
        this.clientAssmCommunicationPoint = clientAssmCommunicationPoint;
    }

    public Integer getClientAssmTimelyPoint() {
        return clientAssmTimelyPoint;
    }

    public void setClientAssmTimelyPoint(Integer clientAssmTimelyPoint) {
        this.clientAssmTimelyPoint = clientAssmTimelyPoint;
    }

    public String getUserCompleteProfileFile() {
        return userCompleteProfileFile;
    }

    public void setUserCompleteProfileFile(String userCompleteProfileFile) {
        this.userCompleteProfileFile = userCompleteProfileFile;
    }

    public String getUserCompleteProfileFileName() {
        return userCompleteProfileFileName;
    }

    public void setUserCompleteProfileFileName(String userCompleteProfileFileName) {
        this.userCompleteProfileFileName = userCompleteProfileFileName;
    }

    public String getUserCompleteProfilePhoto() {
        return userCompleteProfilePhoto;
    }

    public void setUserCompleteProfilePhoto(String userCompleteProfilePhoto) {
        this.userCompleteProfilePhoto = userCompleteProfilePhoto;
    }

    public String getUserCompleteProfilePhotoName() {
        return userCompleteProfilePhotoName;
    }

    public void setUserCompleteProfilePhotoName(String userCompleteProfilePhotoName) {
        this.userCompleteProfilePhotoName = userCompleteProfilePhotoName;
    }

    public Date getUserCompleteTime() {
        return userCompleteTime;
    }

    public void setUserCompleteTime(Date userCompleteTime) {
        this.userCompleteTime = userCompleteTime;
    }

    public String getUserJobPerformance() {
        return userJobPerformance;
    }

    public void setUserJobPerformance(String userJobPerformance) {
        this.userJobPerformance = userJobPerformance;
    }

    public String getUserJobEndReason() {
        return userJobEndReason;
    }

    public void setUserJobEndReason(String userJobEndReason) {
        this.userJobEndReason = userJobEndReason;
    }

    public String getClientCompleteProfileFile() {
        return clientCompleteProfileFile;
    }

    public void setClientCompleteProfileFile(String clientCompleteProfileFile) {
        this.clientCompleteProfileFile = clientCompleteProfileFile;
    }

    public String getClientCompleteProfileFileName() {
        return clientCompleteProfileFileName;
    }

    public void setClientCompleteProfileFileName(String clientCompleteProfileFileName) {
        this.clientCompleteProfileFileName = clientCompleteProfileFileName;
    }

    public Date getClientCompleteTime() {
        return clientCompleteTime;
    }

    public void setClientCompleteTime(Date clientCompleteTime) {
        this.clientCompleteTime = clientCompleteTime;
    }

    public Boolean getFlagUsed() {
        return flagUsed;
    }

    public void setFlagUsed(Boolean flagUsed) {
        this.flagUsed = flagUsed;
    }

    public BigDecimal getEstimatedPrice() {
        return estimatedPrice;
    }

    public void setEstimatedPrice(BigDecimal estimatedPrice) {
        this.estimatedPrice = estimatedPrice;
    }

    public String getEstimatedPriceUnit() {
        return estimatedPriceUnit;
    }

    public void setEstimatedPriceUnit(String estimatedPriceUnit) {
        this.estimatedPriceUnit = estimatedPriceUnit;
    }

    public Date getEstimatedServiceTime() {
        return estimatedServiceTime;
    }

    public void setEstimatedServiceTime(Date estimatedServiceTime) {
        this.estimatedServiceTime = estimatedServiceTime;
    }

    public String getDispatchDescription() {
        return dispatchDescription;
    }

    public void setDispatchDescription(String dispatchDescription) {
        this.dispatchDescription = dispatchDescription;
    }

    public String getActualPriceMemo() {
        return actualPriceMemo;
    }

    public void setActualPriceMemo(String actualPriceMemo) {
        this.actualPriceMemo = actualPriceMemo;
    }

    public String getActualCostMemo() {
        return actualCostMemo;
    }

    public void setActualCostMemo(String actualCostMemo) {
        this.actualCostMemo = actualCostMemo;
    }

    public String getEstimatedCostMemo() {
        return estimatedCostMemo;
    }

    public void setEstimatedCostMemo(String estimatedCostMemo) {
        this.estimatedCostMemo = estimatedCostMemo;
    }

    public String getEstimatedPriceMemo() {
        return estimatedPriceMemo;
    }

    public void setEstimatedPriceMemo(String estimatedPriceMemo) {
        this.estimatedPriceMemo = estimatedPriceMemo;
    }

    public String getPrivateNote() {
        return privateNote;
    }

    public void setPrivateNote(String privateNote) {
        this.privateNote = privateNote;
    }
}
