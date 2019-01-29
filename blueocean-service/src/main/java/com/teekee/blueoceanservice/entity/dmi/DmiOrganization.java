package com.teekee.blueoceanservice.entity.dmi;

import com.teekee.commoncomponets.base.BaseEntity;

import java.util.Date;
import java.util.HashMap;

public class DmiOrganization extends BaseEntity {
    private Integer id = 0;

    private String organizationName;

    private String organizationCode;

    private Integer level;

    private Integer parentId;

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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOrganizationName() {
        return organizationName;
    }

    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName == null ? null : organizationName.trim();
    }

    public String getOrganizationCode() {
        return organizationCode;
    }

    public void setOrganizationCode(String organizationCode) {
        this.organizationCode = organizationCode == null ? null : organizationCode.trim();
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
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

    public Integer getBusinessLicenseId() {
        return businessLicenseId;
    }

    public void setBusinessLicenseId(Integer bussinessLicenseId) {
        this.businessLicenseId = bussinessLicenseId;
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
        this.memo = memo == null ? null : memo.trim();
    }

    public Boolean getFlagFiliale() {
        return flagFiliale;
    }

    public void setFlagFiliale(Boolean flagFiliale) {
        this.flagFiliale = flagFiliale;
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

    public DmiOrganization() {
    }

    public DmiOrganization(HashMap<String, Object> map) {
        if (map.containsKey("belongs_company_id")) setBelongsCompanyId(Integer.parseInt(map.get("belongs_company_id").toString()));
        if (map.containsKey("id")) setId(Integer.parseInt(map.get("id").toString()));
        if (map.containsKey("flag_deleted")) setFlagDeleted(Boolean.parseBoolean(map.get("flag_deleted").toString()));
        if (map.containsKey("memo")) setMemo(map.get("memo").toString());
        if (map.containsKey("flag_available")) setFlagAvailable(Boolean.parseBoolean(map.get("flag_available").toString()));
        if (map.containsKey("business_license_id")) setBusinessLicenseId(Integer.parseInt(map.get("business_license_id").toString()));
        if (map.containsKey("flag_filiale")) setFlagFiliale(Boolean.parseBoolean(map.get("flag_filiale").toString()));
        if (map.containsKey("level")) setLevel(Integer.parseInt(map.get("level").toString()));
        if (map.containsKey("order_id")) setOrderId(Integer.parseInt(map.get("order_id").toString()));
        if (map.containsKey("organization_code")) setOrganizationCode(map.get("organization_code").toString());
        if (map.containsKey("organization_name")) setOrganizationName(map.get("organization_name").toString());
        if (map.containsKey("parent_id")) setParentId(Integer.parseInt(map.get("parent_id").toString()));
    }

    @Override
    public String toString() {
        return "DmiOrganization{" +
                "id=" + id +
                ", organizationName='" + organizationName + '\'' +
                ", organizationCode='" + organizationCode + '\'' +
                ", level=" + level +
                ", parentId=" + parentId +
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
                '}';
    }
}