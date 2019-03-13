package com.company.springboot.entity.fdp;

import java.math.BigDecimal;
import java.util.Date;

public class FdpFaultOrderInsertParam {



    private String firstName;

    private String lastName;

    private String mobile;

    private BigDecimal estimatedCost;

    private String estimatedMonetaryUnit;

    private String fullName;

    private String bankName;

    private String account;

    private String alipayAccount;

    private String paymentMethod;

    private Boolean flagProvideInvoice;

    private String actualInvoiceType;

    private BigDecimal actualInvoiceRate;

    private String userAssmMemo;

    private int id;

    private int dispatchOrderId;

    private Integer requestId;

    private int accountId;

    private Integer dispatchMainHrId;

    private int companyId;

    private int storeId;

    private Integer faultOrderId;

    private int rootFaultOrderId;

    private int faultDispatchRequestId;

    private BigDecimal actualCost;

    private BigDecimal actualMonetaryUnit;

    private int hrAccountInfoId;

    private boolean flagDeleted;

    private boolean flagAvailable;

    private boolean flagPaid;

    private String actualInvoiceTitle;

    private int lastDealPersonId;

    private Date lastDealTime;

    private int hrCount;

    private Date estimatedServiceTime;

    private boolean flagFinish;

    private String finishType;

    private String actualInvoiceTaxIdNumber;

    private String actualInvoiceNumber;

    private BigDecimal actualInvoiceFee;

    private String estimatedInvoiceType;

    private BigDecimal estimatedInvoiceRate;

    private int userAssmAchievePoint;

    private int userAssmCommunicationPoint;

    private int userAssmTimelyPoint;

    private int clientAssmAchievePoint;

    private int clientAssmCommunicationPoint;

    private int clientAssmTimelyPoint;

    private String userCompleteProfileFileName;

    private String userCompleteProfileFile;

    private String userCompleteProfilePhotoName;

    private String userCompleteProfilePhoto;

    private Date userCompleteTime;

    private String userJobPerformance;

    private String userJobEndReason;

    private String ClientCompleteProfileFileName;

    private String ClientCompleteProfileFile;

    private Date clientCompleteTime;

    private String dispatchStatus;

    private Boolean flagUsed;

    private BigDecimal estimatedPrice;

    private String estimatedPriceUnit;

    private String dispatchOtherNumber;

    private Integer vendorId;

    private String dispatchOrderNumber;

    private String hrDispatchStatus;

    private String memo;

    private String estimatedCostMemo;

    private String estimatedPriceMemo;

    private String privateNote;

    private boolean flagEnableModifyProfile;

    /**
     * 标签id
     */
    private String skillLabelIds;

    /**
     * 自定义标签
     */
    private String customLabel;

    public boolean getFlagEnableModifyProfile() {
        return flagEnableModifyProfile;
    }

    public void setFlagEnableModifyProfile(boolean flagEnableModifyProfile) {
        this.flagEnableModifyProfile = flagEnableModifyProfile;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public String getHrDispatchStatus() {
        return hrDispatchStatus;
    }

    public void setHrDispatchStatus(String hrDispatchStatus) {
        this.hrDispatchStatus = hrDispatchStatus;
    }

    public String getDispatchOrderNumber() {
        return dispatchOrderNumber;
    }

    public void setDispatchOrderNumber(String dispatchOrderNumber) {
        this.dispatchOrderNumber = dispatchOrderNumber;
    }

    public Integer getVendorId() {
        return vendorId;
    }

    public void setVendorId(Integer vendorId) {
        this.vendorId = vendorId;
    }

    public String getDispatchOtherNumber() {
        return dispatchOtherNumber;
    }

    public void setDispatchOtherNumber(String dispatchOtherNumber) {
        this.dispatchOtherNumber = dispatchOtherNumber;
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

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public Date getEstimatedServiceTime() {
        return estimatedServiceTime;
    }

    public void setEstimatedServiceTime(Date estimatedServiceTime) {
        this.estimatedServiceTime = estimatedServiceTime;
    }

    public boolean isFlagFinish() {
        return flagFinish;
    }

    public void setFlagFinish(boolean flagFinish) {
        this.flagFinish = flagFinish;
    }

    public String getFinishType() {
        return finishType;
    }

    public void setFinishType(String finishType) {
        this.finishType = finishType;
    }

    public String getActualInvoiceTaxIdNumber() {
        return actualInvoiceTaxIdNumber;
    }

    public void setActualInvoiceTaxIdNumber(String actualInvoiceTaxIdNumber) {
        this.actualInvoiceTaxIdNumber = actualInvoiceTaxIdNumber;
    }

    public String getActualInvoiceNumber() {
        return actualInvoiceNumber;
    }

    public void setActualInvoiceNumber(String actualInvoiceNumber) {
        this.actualInvoiceNumber = actualInvoiceNumber;
    }

    public BigDecimal getActualInvoiceFee() {
        return actualInvoiceFee;
    }

    public void setActualInvoiceFee(BigDecimal actualInvoiceFee) {
        this.actualInvoiceFee = actualInvoiceFee;
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

    public int getUserAssmAchievePoint() {
        return userAssmAchievePoint;
    }

    public void setUserAssmAchievePoint(int userAssmAchievePoint) {
        this.userAssmAchievePoint = userAssmAchievePoint;
    }

    public int getUserAssmCommunicationPoint() {
        return userAssmCommunicationPoint;
    }

    public void setUserAssmCommunicationPoint(int userAssmCommunicationPoint) {
        this.userAssmCommunicationPoint = userAssmCommunicationPoint;
    }

    public int getUserAssmTimelyPoint() {
        return userAssmTimelyPoint;
    }

    public void setUserAssmTimelyPoint(int userAssmTimelyPoint) {
        this.userAssmTimelyPoint = userAssmTimelyPoint;
    }

    public int getClientAssmAchievePoint() {
        return clientAssmAchievePoint;
    }

    public void setClientAssmAchievePoint(int clientAssmAchievePoint) {
        this.clientAssmAchievePoint = clientAssmAchievePoint;
    }

    public int getClientAssmCommunicationPoint() {
        return clientAssmCommunicationPoint;
    }

    public void setClientAssmCommunicationPoint(int clientAssmCommunicationPoint) {
        this.clientAssmCommunicationPoint = clientAssmCommunicationPoint;
    }

    public int getClientAssmTimelyPoint() {
        return clientAssmTimelyPoint;
    }

    public void setClientAssmTimelyPoint(int clientAssmTimelyPoint) {
        this.clientAssmTimelyPoint = clientAssmTimelyPoint;
    }

    public String getUserCompleteProfileFileName() {
        return userCompleteProfileFileName;
    }

    public void setUserCompleteProfileFileName(String userCompleteProfileFileName) {
        this.userCompleteProfileFileName = userCompleteProfileFileName;
    }

    public String getUserCompleteProfileFile() {
        return userCompleteProfileFile;
    }

    public void setUserCompleteProfileFile(String userCompleteProfileFile) {
        this.userCompleteProfileFile = userCompleteProfileFile;
    }

    public String getUserCompleteProfilePhotoName() {
        return userCompleteProfilePhotoName;
    }

    public void setUserCompleteProfilePhotoName(String userCompleteProfilePhotoName) {
        this.userCompleteProfilePhotoName = userCompleteProfilePhotoName;
    }

    public String getUserCompleteProfilePhoto() {
        return userCompleteProfilePhoto;
    }

    public void setUserCompleteProfilePhoto(String userCompleteProfilePhoto) {
        this.userCompleteProfilePhoto = userCompleteProfilePhoto;
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

    public String getClientCompleteProfileFileName() {
        return ClientCompleteProfileFileName;
    }

    public void setClientCompleteProfileFileName(String clientCompleteProfileFileName) {
        ClientCompleteProfileFileName = clientCompleteProfileFileName;
    }

    public String getClientCompleteProfileFile() {
        return ClientCompleteProfileFile;
    }

    public void setClientCompleteProfileFile(String clientCompleteProfileFile) {
        ClientCompleteProfileFile = clientCompleteProfileFile;
    }

    public Date getClientCompleteTime() {
        return clientCompleteTime;
    }

    public void setClientCompleteTime(Date clientCompleteTime) {
        this.clientCompleteTime = clientCompleteTime;
    }

    public String getDispatchStatus() {
        return dispatchStatus;
    }

    public void setDispatchStatus(String dispatchStatus) {
        this.dispatchStatus = dispatchStatus;
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

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getAlipayAccount() {
        return alipayAccount;
    }

    public void setAlipayAccount(String alipayAccount) {
        this.alipayAccount = alipayAccount;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public Boolean getFlagProvideInvoice() {
        return flagProvideInvoice;
    }

    public void setFlagProvideInvoice(Boolean flagProvideInvoice) {
        this.flagProvideInvoice = flagProvideInvoice;
    }

    public String getActualInvoiceType() {
        return actualInvoiceType;
    }

    public void setActualInvoiceType(String actualInvoiceType) {
        this.actualInvoiceType = actualInvoiceType;
    }

    public BigDecimal getActualInvoiceRate() {
        return actualInvoiceRate;
    }

    public void setActualInvoiceRate(BigDecimal actualInvoiceRate) {
        this.actualInvoiceRate = actualInvoiceRate;
    }

    public String getUserAssmMemo() {
        return userAssmMemo;
    }

    public void setUserAssmMemo(String userAssmMemo) {
        this.userAssmMemo = userAssmMemo;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDispatchOrderId() {
        return dispatchOrderId;
    }

    public void setDispatchOrderId(Integer dispatchOrderId) {
        this.dispatchOrderId = dispatchOrderId;
    }

    public Boolean getFlagUsed() {
        return flagUsed;
    }

    public void setFlagUsed(Boolean flagUsed) {
        this.flagUsed = flagUsed;
    }

    public void setDispatchOrderId(int dispatchOrderId) {
        this.dispatchOrderId = dispatchOrderId;
    }

    public Integer getRequestId() {
        return requestId;
    }

    public void setRequestId(Integer requestId) {
        this.requestId = requestId;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public Integer getDispatchMainHrId() {
        return dispatchMainHrId;
    }

    public void setDispatchMainHrId(Integer dispatchMainHrId) {
        this.dispatchMainHrId = dispatchMainHrId;
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

    public Integer getFaultOrderId() {
        return faultOrderId;
    }

    public void setFaultOrderId(Integer faultOrderId) {
        this.faultOrderId = faultOrderId;
    }

    public int getRootFaultOrderId() {
        return rootFaultOrderId;
    }

    public void setRootFaultOrderId(int rootFaultOrderId) {
        this.rootFaultOrderId = rootFaultOrderId;
    }

    public int getFaultDispatchRequestId() {
        return faultDispatchRequestId;
    }

    public void setFaultDispatchRequestId(int faultDispatchRequestId) {
        this.faultDispatchRequestId = faultDispatchRequestId;
    }

    public BigDecimal getActualCost() {
        return actualCost;
    }

    public void setActualCost(BigDecimal actualCost) {
        this.actualCost = actualCost;
    }

    public BigDecimal getActualMonetaryUnit() {
        return actualMonetaryUnit;
    }

    public void setActualMonetaryUnit(BigDecimal actualMonetaryUnit) {
        this.actualMonetaryUnit = actualMonetaryUnit;
    }

    public int getHrAccountInfoId() {
        return hrAccountInfoId;
    }

    public void setHrAccountInfoId(int hrAccountInfoId) {
        this.hrAccountInfoId = hrAccountInfoId;
    }

    public boolean isFlagDeleted() {
        return flagDeleted;
    }

    public void setFlagDeleted(boolean flagDeleted) {
        this.flagDeleted = flagDeleted;
    }

    public boolean isFlagAvailable() {
        return flagAvailable;
    }

    public void setFlagAvailable(boolean flagAvailable) {
        this.flagAvailable = flagAvailable;
    }

    public boolean isFlagPaid() {
        return flagPaid;
    }

    public void setFlagPaid(boolean flagPaid) {
        this.flagPaid = flagPaid;
    }

    public String getActualInvoiceTitle() {
        return actualInvoiceTitle;
    }

    public void setActualInvoiceTitle(String actualInvoiceTitle) {
        this.actualInvoiceTitle = actualInvoiceTitle;
    }

    public int getLastDealPersonId() {
        return lastDealPersonId;
    }

    public void setLastDealPersonId(int lastDealPersonId) {
        this.lastDealPersonId = lastDealPersonId;
    }

    public Date getLastDealTime() {
        return lastDealTime;
    }

    public void setLastDealTime(Date lastDealTime) {
        this.lastDealTime = lastDealTime;
    }

    public int getHrCount() {
        return hrCount;
    }

    public void setHrCount(int hrCount) {
        this.hrCount = hrCount;
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

    @Override
    public String toString() {
        return "FdpFaultOrderInsertParam{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", mobile='" + mobile + '\'' +
                ", estimatedCost=" + estimatedCost +
                ", estimatedMonetaryUnit='" + estimatedMonetaryUnit + '\'' +
                ", fullName='" + fullName + '\'' +
                ", bankName='" + bankName + '\'' +
                ", account='" + account + '\'' +
                ", alipayAccount='" + alipayAccount + '\'' +
                ", paymentMethod='" + paymentMethod + '\'' +
                ", flagProvideInvoice=" + flagProvideInvoice +
                ", actualInvoiceType='" + actualInvoiceType + '\'' +
                ", actualInvoiceRate=" + actualInvoiceRate +
                ", userAssmMemo='" + userAssmMemo + '\'' +
                ", id=" + id +
                ", dispatchOrderId=" + dispatchOrderId +
                ", requestId=" + requestId +
                ", accountId=" + accountId +
                ", dispatchMainHrId=" + dispatchMainHrId +
                ", companyId=" + companyId +
                ", storeId=" + storeId +
                ", faultOrderId=" + faultOrderId +
                ", rootFaultOrderId=" + rootFaultOrderId +
                ", faultDispatchRequestId=" + faultDispatchRequestId +
                ", actualCost=" + actualCost +
                ", actualMonetaryUnit=" + actualMonetaryUnit +
                ", hrAccountInfoId=" + hrAccountInfoId +
                ", flagDeleted=" + flagDeleted +
                ", flagAvailable=" + flagAvailable +
                ", flagPaid=" + flagPaid +
                ", actualInvoiceTitle='" + actualInvoiceTitle + '\'' +
                ", lastDealPersonId=" + lastDealPersonId +
                ", lastDealTime=" + lastDealTime +
                ", hrCount=" + hrCount +
                ", estimatedServiceTime=" + estimatedServiceTime +
                ", flagFinish=" + flagFinish +
                ", finishType='" + finishType + '\'' +
                ", actualInvoiceTaxIdNumber='" + actualInvoiceTaxIdNumber + '\'' +
                ", actualInvoiceNumber='" + actualInvoiceNumber + '\'' +
                ", actualInvoiceFee=" + actualInvoiceFee +
                ", estimatedInvoiceType='" + estimatedInvoiceType + '\'' +
                ", estimatedInvoiceRate=" + estimatedInvoiceRate +
                ", userAssmAchievePoint=" + userAssmAchievePoint +
                ", userAssmCommunicationPoint=" + userAssmCommunicationPoint +
                ", userAssmTimelyPoint=" + userAssmTimelyPoint +
                ", clientAssmAchievePoint=" + clientAssmAchievePoint +
                ", clientAssmCommunicationPoint=" + clientAssmCommunicationPoint +
                ", clientAssmTimelyPoint=" + clientAssmTimelyPoint +
                ", userCompleteProfileFileName='" + userCompleteProfileFileName + '\'' +
                ", userCompleteProfileFile='" + userCompleteProfileFile + '\'' +
                ", userCompleteProfilePhotoName='" + userCompleteProfilePhotoName + '\'' +
                ", userCompleteProfilePhoto='" + userCompleteProfilePhoto + '\'' +
                ", userCompleteTime=" + userCompleteTime +
                ", userJobPerformance='" + userJobPerformance + '\'' +
                ", userJobEndReason='" + userJobEndReason + '\'' +
                ", ClientCompleteProfileFileName='" + ClientCompleteProfileFileName + '\'' +
                ", ClientCompleteProfileFile='" + ClientCompleteProfileFile + '\'' +
                ", clientCompleteTime=" + clientCompleteTime +
                ", dispatchStatus='" + dispatchStatus + '\'' +
                ", flagUsed=" + flagUsed +
                ", estimatedPrice=" + estimatedPrice +
                ", estimatedPriceUnit='" + estimatedPriceUnit + '\'' +
                ", dispatchOtherNumber='" + dispatchOtherNumber + '\'' +
                ", vendorId=" + vendorId +
                ", dispatchOrderNumber='" + dispatchOrderNumber + '\'' +
                ", hrDispatchStatus='" + hrDispatchStatus + '\'' +
                ", memo='" + memo + '\'' +
                ", estimatedCostMemo='" + estimatedCostMemo + '\'' +
                ", estimatedPriceMemo='" + estimatedPriceMemo + '\'' +
                ", privateNote='" + privateNote + '\'' +
                ", flagEnableModifyProfile=" + flagEnableModifyProfile +
                ", skillLabelIds='" + skillLabelIds + '\'' +
                ", customLabel='" + customLabel + '\'' +
                '}';
    }
}
