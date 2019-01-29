package com.teekee.blackrockservice.entity.bif;

import com.teekee.commoncomponets.base.BaseEntity;
import io.swagger.annotations.ApiModel;

import java.util.Date;

@ApiModel("服务商实名认证实体")
public class BifDispatchHrAutonymValid extends BaseEntity{
    private Integer id;

    private Integer userId;

    private String userName;

    private String idType;

    private String idCode;

    private String positiveImageUrl;

    private String contraryImageUrl;

    private String handheldImageUrl;

    private Boolean flagLast;

    private Boolean flagValidStatus;

    private Date createTime;

    private Integer validPersonId;

    private Date dealTime;

    private Integer validDenyReasonId;

    private String validDenyMemo;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getIdType() {
        return idType;
    }

    public void setIdType(String idType) {
        this.idType = idType == null ? null : idType.trim();
    }

    public String getIdCode() {
        return idCode;
    }

    public void setIdCode(String idCode) {
        this.idCode = idCode == null ? null : idCode.trim();
    }

    public String getPositiveImageUrl() {
        return positiveImageUrl;
    }

    public void setPositiveImageUrl(String positiveImageUrl) {
        this.positiveImageUrl = positiveImageUrl == null ? null : positiveImageUrl.trim();
    }

    public String getContraryImageUrl() {
        return contraryImageUrl;
    }

    public void setContraryImageUrl(String contraryImageUrl) {
        this.contraryImageUrl = contraryImageUrl == null ? null : contraryImageUrl.trim();
    }

    public String getHandheldImageUrl() {
        return handheldImageUrl;
    }

    public void setHandheldImageUrl(String handheldImageUrl) {
        this.handheldImageUrl = handheldImageUrl == null ? null : handheldImageUrl.trim();
    }

    public Boolean getFlagLast() {
        return flagLast;
    }

    public void setFlagLast(Boolean flagLast) {
        this.flagLast = flagLast;
    }

    public Boolean getFlagValidStatus() {
        return flagValidStatus;
    }

    public void setFlagValidStatus(Boolean flagValidStatus) {
        this.flagValidStatus = flagValidStatus;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getValidPersonId() {
        return validPersonId;
    }

    public void setValidPersonId(Integer validPersonId) {
        this.validPersonId = validPersonId;
    }

    public Date getDealTime() {
        return dealTime;
    }

    public void setDealTime(Date dealTime) {
        this.dealTime = dealTime;
    }

    public Integer getValidDenyReasonId() {
        return validDenyReasonId;
    }

    public void setValidDenyReasonId(Integer validDenyReasonId) {
        this.validDenyReasonId = validDenyReasonId;
    }

    public String getValidDenyMemo() {
        return validDenyMemo;
    }

    public void setValidDenyMemo(String validDenyMemo) {
        this.validDenyMemo = validDenyMemo == null ? null : validDenyMemo.trim();
    }
}