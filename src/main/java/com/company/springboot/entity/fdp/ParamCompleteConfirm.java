package com.company.springboot.entity.fdp;

import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 完工确认
 *
 * @author Wujun
 * @create 2018年01月30日 10:38
 */
public class ParamCompleteConfirm {

    private int id;
    private int requestId;
    private int processId;
    private BigDecimal actualCost;
    private String actualMonetaryUnit;
    private BigDecimal actualPrice;
    private String actualPriceUnit;
    private String dispatchDescription;
    private int userAssmAchievePoint;
    private int userAssmCommunicationPoint;
    private int userAssmTimelyPoint;
    private String userCompleteProfileFileName;
    private String userCompleteProfileFile;
    private String userCompleteProfilePhotoName;
    private String userCompleteProfilePhoto;
    private String userJobEndReason;
    private String memo;
    private String actualCostMemo;
    private String actualPriceMemo;
    private boolean flagNoPrice;
    private String privateNote;
    private Date userCompleteTime;

    @ApiModelProperty(value = "实际设备费用", example = "1", required = true)
    private BigDecimal actualDeviceCost;
    @ApiModelProperty(value = "实际设备费用备注", example = "1", required = true)
    private String actualDeviceMemo;

    @ApiModelProperty(value = "实际通信线路费用", example = "1", required = true)
    private BigDecimal actualCommResourceCost;
    @ApiModelProperty(value = "实际通信线路费用备注", example = "1", required = true)
    private String actualCommResourceMemo;

    @ApiModelProperty(value = "实际人力费用", example = "1", required = true)
    private BigDecimal actualHrCost;
    @ApiModelProperty(value = "实际人力费用备注", example = "1", required = true)
    private String actualHrMemo;

    @ApiModelProperty(value = "实际其他费用", example = "1", required = true)
    private BigDecimal actualOtherCost;
    @ApiModelProperty(value = "实际其他费用备注", example = "1", required = true)
    private String actualOtherMemo;

    public boolean getFlagNoPrice() {
        return flagNoPrice;
    }

    public void setFlagNoPrice(boolean flagNoPrice) {
        this.flagNoPrice = flagNoPrice;
    }

    public String getActualPriceMemo() {
        return actualPriceMemo;
    }

    public void setActualPriceMemo(String actualPriceMemo) {
        this.actualPriceMemo = actualPriceMemo;
    }

    public BigDecimal getActualCost() {
        return actualCost;
    }

    public void setActualCost(BigDecimal actualCost) {
        this.actualCost = actualCost;
    }

    public BigDecimal getActualPrice() {
        return actualPrice;
    }

    public void setActualPrice(BigDecimal actualPrice) {
        this.actualPrice = actualPrice;
    }

    public String getActualMonetaryUnit() {
        return actualMonetaryUnit;
    }

    public void setActualMonetaryUnit(String actualMonetaryUnit) {
        this.actualMonetaryUnit = actualMonetaryUnit;
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

    public void setId(int id) {
        this.id = id;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public int getRequestId() {
        return requestId;
    }

    public void setRequestId(int requestId) {
        this.requestId = requestId;
    }

    public String getUserJobEndReason() {
        return userJobEndReason;
    }

    public void setUserJobEndReason(String userJobEndReason) {
        this.userJobEndReason = userJobEndReason;
    }

    public int getProcessId() {
        return processId;
    }

    public void setProcessId(int processId) {
        this.processId = processId;
    }

    public String getDispatchDescription() {
        return dispatchDescription;
    }

    public void setDispatchDescription(String dispatchDescription) {
        this.dispatchDescription = dispatchDescription;
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

    public String getActualCostMemo() {
        return actualCostMemo;
    }

    public void setActualCostMemo(String actualCostMemo) {
        this.actualCostMemo = actualCostMemo;
    }

    public String getPrivateNote() {
        return privateNote;
    }

    public void setPrivateNote(String privateNote) {
        this.privateNote = privateNote;
    }

    public Date getUserCompleteTime() {
        return userCompleteTime;
    }

    public void setUserCompleteTime(Date userCompleteTime) {
        this.userCompleteTime = userCompleteTime;
    }

    public BigDecimal getActualDeviceCost() {
        return actualDeviceCost;
    }

    public void setActualDeviceCost(BigDecimal actualDeviceCost) {
        this.actualDeviceCost = actualDeviceCost;
    }

    public String getActualDeviceMemo() {
        return actualDeviceMemo;
    }

    public void setActualDeviceMemo(String actualDeviceMemo) {
        this.actualDeviceMemo = actualDeviceMemo;
    }

    public BigDecimal getActualCommResourceCost() {
        return actualCommResourceCost;
    }

    public void setActualCommResourceCost(BigDecimal actualCommResourceCost) {
        this.actualCommResourceCost = actualCommResourceCost;
    }

    public String getActualCommResourceMemo() {
        return actualCommResourceMemo;
    }

    public void setActualCommResourceMemo(String actualCommResourceMemo) {
        this.actualCommResourceMemo = actualCommResourceMemo;
    }

    public BigDecimal getActualHrCost() {
        return actualHrCost;
    }

    public void setActualHrCost(BigDecimal actualHrCost) {
        this.actualHrCost = actualHrCost;
    }

    public String getActualHrMemo() {
        return actualHrMemo;
    }

    public void setActualHrMemo(String actualHrMemo) {
        this.actualHrMemo = actualHrMemo;
    }

    public BigDecimal getActualOtherCost() {
        return actualOtherCost;
    }

    public void setActualOtherCost(BigDecimal actualOtherCost) {
        this.actualOtherCost = actualOtherCost;
    }

    public String getActualOtherMemo() {
        return actualOtherMemo;
    }

    public void setActualOtherMemo(String actualOtherMemo) {
        this.actualOtherMemo = actualOtherMemo;
    }

    @Override
    public String toString() {
        return "ParamCompleteConfirm{" +
                "id=" + id +
                ", requestId=" + requestId +
                ", processId=" + processId +
                ", actualCost=" + actualCost +
                ", actualMonetaryUnit='" + actualMonetaryUnit + '\'' +
                ", actualPrice=" + actualPrice +
                ", actualPriceUnit='" + actualPriceUnit + '\'' +
                ", dispatchDescription='" + dispatchDescription + '\'' +
                ", userAssmAchievePoint=" + userAssmAchievePoint +
                ", userAssmCommunicationPoint=" + userAssmCommunicationPoint +
                ", userAssmTimelyPoint=" + userAssmTimelyPoint +
                ", userCompleteProfileFileName='" + userCompleteProfileFileName + '\'' +
                ", userCompleteProfileFile='" + userCompleteProfileFile + '\'' +
                ", userCompleteProfilePhotoName='" + userCompleteProfilePhotoName + '\'' +
                ", userCompleteProfilePhoto='" + userCompleteProfilePhoto + '\'' +
                ", userJobEndReason='" + userJobEndReason + '\'' +
                ", memo='" + memo + '\'' +
                ", actualCostMemo='" + actualCostMemo + '\'' +
                ", actualPriceMemo='" + actualPriceMemo + '\'' +
                ", flagNoPrice=" + flagNoPrice +
                ", privateNote='" + privateNote + '\'' +
                ", userCompleteTime=" + userCompleteTime +
                ", actualDeviceCost=" + actualDeviceCost +
                ", actualDeviceMemo='" + actualDeviceMemo + '\'' +
                ", actualCommResourceCost=" + actualCommResourceCost +
                ", actualCommResourceMemo='" + actualCommResourceMemo + '\'' +
                ", actualHrCost=" + actualHrCost +
                ", actualHrMemo='" + actualHrMemo + '\'' +
                ", actualOtherCost=" + actualOtherCost +
                ", actualOtherMemo='" + actualOtherMemo + '\'' +
                '}';
    }
}
