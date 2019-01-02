package com.platform.springboot.entity.fdp;

import java.math.BigDecimal;
import java.util.Date;

public class FdpFaultDispatchHrRelation {
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

    private String userJobPerformance;

    private String userJobEndReason;

    private String clientCompleteProfileFile;

    private String clientCompleteProfileFileName;

    private Date clientCompleteTime;

    private Boolean flagUsed;

    private BigDecimal estimatedPrice;

    private String estimatedPriceUnit;

    private Date estimatedServiceTime;

    private String clientEvaluation;

    private String completeProfileUserType;

    private Integer completeProfileUserId;

    private String hrDispatchStatus;

    private String type;

    private String estimatedCostMemo;

    private String estimatedPriceMemo;

    private String processStage;

    private boolean flagNoPrice;

    private String extendProfileName;

    private String extendProfileUrl;

    private String extendProfileMemo;

    private String privateNote;

    private boolean flagEnableModifyProfile;

    private boolean flagPurchase;

    /**
     * 标签id
     */
    private String skillLabelIds;

    /**
     * 自定义标签
     */
    private String customLabel;

    private boolean flagDisplay;
    /**

     * 驳回人员原因
     */
    private String personRejectCauseContext;

    public boolean getFlagPurchase() {
        return flagPurchase;
    }

    public void setFlagPurchase(boolean flagPurchase) {
        this.flagPurchase = flagPurchase;
    }

    public boolean getFlagEnableModifyProfile() {
        return flagEnableModifyProfile;
    }

    public void setFlagEnableModifyProfile(boolean flagEnableModifyProfile) {
        this.flagEnableModifyProfile = flagEnableModifyProfile;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getHrDispatchStatus() {
        return hrDispatchStatus;
    }

    public void setHrDispatchStatus(String hrDispatchStatus) {
        this.hrDispatchStatus = hrDispatchStatus;
    }

    public String getClientEvaluation() {
        return clientEvaluation;
    }

    public void setClientEvaluation(String clientEvaluation) {
        this.clientEvaluation = clientEvaluation;
    }

    public String getCompleteProfileUserType() {
        return completeProfileUserType;
    }

    public void setCompleteProfileUserType(String completeProfileUserType) {
        this.completeProfileUserType = completeProfileUserType;
    }

    public Integer getCompleteProfileUserId() {
        return completeProfileUserId;
    }

    public void setCompleteProfileUserId(Integer completeProfileUserId) {
        this.completeProfileUserId = completeProfileUserId;
    }

    public Date getEstimatedServiceTime() {
        return estimatedServiceTime;
    }

    public void setEstimatedServiceTime(Date estimatedServiceTime) {
        this.estimatedServiceTime = estimatedServiceTime;
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

    public String getUserJobPerformance() {
        return userJobPerformance;
    }

    public void setUserJobPerformance(String userJobPerformance) {
        this.userJobPerformance = userJobPerformance == null ? null : userJobPerformance.trim();
    }

    public String getUserJobEndReason() {
        return userJobEndReason;
    }

    public void setUserJobEndReason(String userJobEndReason) {
        this.userJobEndReason = userJobEndReason == null ? null : userJobEndReason.trim();
    }

    public String getClientCompleteProfileFile() {
        return clientCompleteProfileFile;
    }

    public void setClientCompleteProfileFile(String clientCompleteProfileFile) {
        this.clientCompleteProfileFile = clientCompleteProfileFile == null ? null : clientCompleteProfileFile.trim();
    }

    public String getClientCompleteProfileFileName() {
        return clientCompleteProfileFileName;
    }

    public void setClientCompleteProfileFileName(String clientCompleteProfileFileName) {
        this.clientCompleteProfileFileName = clientCompleteProfileFileName == null ? null : clientCompleteProfileFileName.trim();
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

    public String getExtendProfileName() {
        return extendProfileName;
    }

    public void setExtendProfileName(String extendProfileName) {
        this.extendProfileName = extendProfileName;
    }

    public String getExtendProfileUrl() {
        return extendProfileUrl;
    }

    public void setExtendProfileUrl(String extendProfileUrl) {
        this.extendProfileUrl = extendProfileUrl;
    }

    public String getExtendProfileMemo() {
        return extendProfileMemo;
    }

    public void setExtendProfileMemo(String extendProfileMemo) {
        this.extendProfileMemo = extendProfileMemo;
    }

    public String getPrivateNote() {
        return privateNote;
    }

    public void setPrivateNote(String privateNote) {
        this.privateNote = privateNote;
    }

    public String getSkillLabelIds() {
        return skillLabelIds;
    }

    public void setSkillLabelIds(String skillLabelIds) {
        this.skillLabelIds = skillLabelIds;
    }

    public String getCustomLabel() {
        return customLabel;
    }

    public void setCustomLabel(String customLabel) {
        this.customLabel = customLabel;
    }

    public boolean isFlagDisplay() {
        return flagDisplay;
    }

    public void setFlagDisplay(boolean flagDisplay) {
        this.flagDisplay = flagDisplay;
    }

    public String getPersonRejectCauseContext() {
        return personRejectCauseContext;
    }

    public void setPersonRejectCauseContext(String personRejectCauseContext) {
        this.personRejectCauseContext = personRejectCauseContext;
    }
}