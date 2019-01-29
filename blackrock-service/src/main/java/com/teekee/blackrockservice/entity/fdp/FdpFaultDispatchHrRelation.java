package com.teekee.blackrockservice.entity.fdp;

import com.teekee.commoncomponets.base.BaseEntity;
import io.swagger.annotations.ApiModel;

import java.math.BigDecimal;
import java.util.Date;

@ApiModel("派工订单的人员")
public class FdpFaultDispatchHrRelation extends BaseEntity{
    private Integer id;

    private Integer dispatchOrderId;

    private Integer faultDispatchRequestId;

    private Integer dispatchMainHrId;

    private Integer hrAccountInfoId;

    private BigDecimal estimatedCost;

    private String estimatedMonetaryUnit;

    private BigDecimal estimatedPrice;

    private String estimatedPriceUnit;

    private String estimatedInvoiceType;

    private BigDecimal estimatedInvoiceRate;

    private Boolean flagProvideInvoice;

    private String userAssmMemo;

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

    private String userJobEndReason;

    private Boolean flagUsed;

    private String clientEvaluation;

    private String completeProfileUserType;

    private Integer completeProfileUserId;

    private Date hrConfirmTime;

    private Date hrStartOffTime;

    private Date hrStartServiceTime;

    private String memo;

    private String hrDispatchStatus;

    public String getHrDispatchStatus() {
        return hrDispatchStatus;
    }

    public void setHrDispatchStatus(String hrDispatchStatus) {
        this.hrDispatchStatus = hrDispatchStatus;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public Date getHrStartServiceTime() {
        return hrStartServiceTime;
    }
    private Date hrFinishServiceTime;

    private Integer hrJobPerformanceVersion;

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
        this.estimatedMonetaryUnit = estimatedMonetaryUnit == null ? null : estimatedMonetaryUnit.trim();
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
        this.estimatedPriceUnit = estimatedPriceUnit == null ? null : estimatedPriceUnit.trim();
    }

    public String getEstimatedInvoiceType() {
        return estimatedInvoiceType;
    }

    public void setEstimatedInvoiceType(String estimatedInvoiceType) {
        this.estimatedInvoiceType = estimatedInvoiceType == null ? null : estimatedInvoiceType.trim();
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

    public String getUserAssmMemo() {
        return userAssmMemo;
    }

    public void setUserAssmMemo(String userAssmMemo) {
        this.userAssmMemo = userAssmMemo;
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
        this.userCompleteProfileFile = userCompleteProfileFile == null ? null : userCompleteProfileFile.trim();
    }

    public String getUserCompleteProfileFileName() {
        return userCompleteProfileFileName;
    }

    public void setUserCompleteProfileFileName(String userCompleteProfileFileName) {
        this.userCompleteProfileFileName = userCompleteProfileFileName == null ? null : userCompleteProfileFileName.trim();
    }

    public String getUserCompleteProfilePhoto() {
        return userCompleteProfilePhoto;
    }

    public void setUserCompleteProfilePhoto(String userCompleteProfilePhoto) {
        this.userCompleteProfilePhoto = userCompleteProfilePhoto == null ? null : userCompleteProfilePhoto.trim();
    }

    public String getUserCompleteProfilePhotoName() {
        return userCompleteProfilePhotoName;
    }

    public void setUserCompleteProfilePhotoName(String userCompleteProfilePhotoName) {
        this.userCompleteProfilePhotoName = userCompleteProfilePhotoName == null ? null : userCompleteProfilePhotoName.trim();
    }

    public Date getUserCompleteTime() {
        return userCompleteTime;
    }

    public void setUserCompleteTime(Date userCompleteTime) {
        this.userCompleteTime = userCompleteTime;
    }

    public String getUserJobEndReason() {
        return userJobEndReason;
    }

    public void setUserJobEndReason(String userJobEndReason) {
        this.userJobEndReason = userJobEndReason == null ? null : userJobEndReason.trim();
    }

    public Boolean getFlagUsed() {
        return flagUsed;
    }

    public void setFlagUsed(Boolean flagUsed) {
        this.flagUsed = flagUsed;
    }

    public String getClientEvaluation() {
        return clientEvaluation;
    }

    public void setClientEvaluation(String clientEvaluation) {
        this.clientEvaluation = clientEvaluation == null ? null : clientEvaluation.trim();
    }

    public String getCompleteProfileUserType() {
        return completeProfileUserType;
    }

    public void setCompleteProfileUserType(String completeProfileUserType) {
        this.completeProfileUserType = completeProfileUserType == null ? null : completeProfileUserType.trim();
    }

    public Integer getCompleteProfileUserId() {
        return completeProfileUserId;
    }

    public void setCompleteProfileUserId(Integer completeProfileUserId) {
        this.completeProfileUserId = completeProfileUserId;
    }

    public Date getHrConfirmTime() {
        return hrConfirmTime;
    }

    public void setHrConfirmTime(Date hrConfirmTime) {
        this.hrConfirmTime = hrConfirmTime;
    }

    public Date getHrStartOffTime() {
        return hrStartOffTime;
    }

    public void setHrStartOffTime(Date hrStartOffTime) {
        this.hrStartOffTime = hrStartOffTime;
    }


    public void setHrStartServiceTime(Date hrStartServiceTime) {
        this.hrStartServiceTime = hrStartServiceTime;
    }

    public Date getHrFinishServiceTime() {
        return hrFinishServiceTime;
    }

    public void setHrFinishServiceTime(Date hrFinishServiceTime) {
        this.hrFinishServiceTime = hrFinishServiceTime;
    }

    public Integer getHrJobPerformanceVersion() {
        return hrJobPerformanceVersion;
    }

    public void setHrJobPerformanceVersion(Integer hrJobPerformanceVersion) {
        this.hrJobPerformanceVersion = hrJobPerformanceVersion;
    }
}