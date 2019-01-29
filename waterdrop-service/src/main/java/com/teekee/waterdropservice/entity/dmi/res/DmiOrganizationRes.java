package com.teekee.waterdropservice.entity.dmi.res;

import com.teekee.commoncomponets.base.BaseTreeGrid;

import java.util.Date;

public class DmiOrganizationRes extends BaseTreeGrid {

    private String title;

    private String organizationCode;

    private Integer level;

    private Integer orderId;

    private Integer belongsCompanyId;

    private Boolean flagFiliale;

    private Integer businessLicenseId;

    private Boolean flagDeleted;

    private Boolean flagAvailable;

    private Date createTime;

    private Integer createPerson;

    private Date updateTime;

    private Integer updatePerson;

    private String memo;

    private Boolean flagIsStore;

    private Integer storeId;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getOrganizationCode() {
        return organizationCode;
    }

    public void setOrganizationCode(String organizationCode) {
        this.organizationCode = organizationCode;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getBelongsCompanyId() {
        return belongsCompanyId;
    }

    public void setBelongsCompanyId(Integer belongsCompanyId) {
        this.belongsCompanyId = belongsCompanyId;
    }

    public Boolean getFlagFiliale() {
        return flagFiliale;
    }

    public void setFlagFiliale(Boolean flagFiliale) {
        this.flagFiliale = flagFiliale;
    }

    public Integer getBusinessLicenseId() {
        return businessLicenseId;
    }

    public void setBusinessLicenseId(Integer businessLicenseId) {
        this.businessLicenseId = businessLicenseId;
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

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getCreatePerson() {
        return createPerson;
    }

    public void setCreatePerson(Integer createPerson) {
        this.createPerson = createPerson;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getUpdatePerson() {
        return updatePerson;
    }

    public void setUpdatePerson(Integer updatePerson) {
        this.updatePerson = updatePerson;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public Boolean getFlagIsStore() {
        return flagIsStore;
    }

    public void setFlagIsStore(Boolean flagIsStore) {
        this.flagIsStore = flagIsStore;
    }

    public Integer getStoreId() {
        return storeId;
    }

    public void setStoreId(Integer storeId) {
        this.storeId = storeId;
    }

    @Override
    public String toString() {
        return "DmiOrganizationRes{" +
                "title='" + title + '\'' +
                ", organizationCode='" + organizationCode + '\'' +
                ", level=" + level +
                ", orderId=" + orderId +
                ", belongsCompanyId=" + belongsCompanyId +
                ", flagFiliale=" + flagFiliale +
                ", businessLicenseId=" + businessLicenseId +
                ", flagDeleted=" + flagDeleted +
                ", flagAvailable=" + flagAvailable +
                ", createTime=" + createTime +
                ", createPerson=" + createPerson +
                ", updateTime=" + updateTime +
                ", updatePerson=" + updatePerson +
                ", memo='" + memo + '\'' +
                ", flagIsStore=" + flagIsStore +
                ", storeId=" + storeId +
                '}';
    }
}