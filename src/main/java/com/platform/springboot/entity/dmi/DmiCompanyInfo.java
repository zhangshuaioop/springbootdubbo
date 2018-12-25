package com.platform.springboot.entity.dmi;

import com.platform.springboot.base.BaseEntity;
import com.platform.springboot.base.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;


@ApiModel(value = "公司信息")
public class DmiCompanyInfo extends BaseEntity {

    @ApiModelProperty(value = "id", example = "1", required = true)
    private Integer id = 0;

    @ApiModelProperty(value = "公司名", example = "1", required = true)
    private String companyName;

    @ApiModelProperty(value = "公司全称", example = "1", required = true)
    private String companyFullName;

    @ApiModelProperty(value = "公司官网", example = "1", required = true)
    private String website;

    @ApiModelProperty(value = "联系地址", example = "1", required = true)
    private String contactAddress;

    @ApiModelProperty(value = "联系电话", example = "1", required = true)
    private String telephone;

    @ApiModelProperty(value = "传真号", example = "1", required = true)
    private String fax;

    @ApiModelProperty(value = "营业执照关联ID", example = "1", required = true)
    private Integer businessLicenseId;

    @ApiModelProperty(value = "logo的图片路径", example = "1", required = true)
    private String logoUrl;

    @ApiModelProperty(value = "是否已删除", example = "1", required = true)
    private Boolean flagDeleted;

    @ApiModelProperty(value = "是否有效", example = "1", required = true)
    private Boolean flagAvailable;

    @ApiModelProperty(value = "创建时间", example = "1", required = true)
    private Date createTime;

    @ApiModelProperty(value = "创建人", example = "1", required = true)
    private Integer createPerson;

    @ApiModelProperty(value = "更新人", example = "1", required = true)
    private Date updateTime;

    @ApiModelProperty(value = "更新人", example = "1", required = true)
    private Integer updatePerson;

    @ApiModelProperty(value = "备注", example = "1", required = true)
    private String memo;

    @ApiModelProperty(value = "集成商ID", example = "1", required = true)
    private Integer vendorId;

    @ApiModelProperty(value = "公司名", example = "1", required = true)
    private String companyToken;

    @ApiModelProperty(value = "公司唯一标识", example = "1", required = true)
    private String companyTokenImage;

    public String getCompanyTokenImage() {
        return companyTokenImage;
    }

    public void setCompanyTokenImage(String companyTokenImage) {
        this.companyTokenImage = companyTokenImage;
    }

    public String getCompanyToken() {
        return companyToken;
    }

    public void setCompanyToken(String companyToken) {
        this.companyToken = companyToken;
    }

    public Integer getVendorId() {
        return vendorId;
    }

    public void setVendorId(Integer vendorId) {
        this.vendorId = vendorId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName == null ? null : companyName.trim();
    }

    public String getCompanyFullName() {
        return companyFullName;
    }

    public void setCompanyFullName(String companyFullName) {
        this.companyFullName = companyFullName == null ? null : companyFullName.trim();
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website == null ? null : website.trim();
    }

    public String getContactAddress() {
        return contactAddress;
    }

    public void setContactAddress(String contactAddress) {
        this.contactAddress = contactAddress == null ? null : contactAddress.trim();
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone == null ? null : telephone.trim();
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax == null ? null : fax.trim();
    }

    public Integer getBusinessLicenseId() {
        return businessLicenseId;
    }

    public void setBusinessLicenseId(Integer businessLicenseId) {
        this.businessLicenseId = businessLicenseId;
    }

    public String getLogoUrl() {
        return logoUrl;
    }

    public void setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl == null ? null : logoUrl.trim();
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

    @Override
    public String toString() {
        return "DmiCompanyInfo{" +
                "id=" + id +
                ", companyName='" + companyName + '\'' +
                ", companyFullName='" + companyFullName + '\'' +
                ", website='" + website + '\'' +
                ", contactAddress='" + contactAddress + '\'' +
                ", telephone='" + telephone + '\'' +
                ", fax='" + fax + '\'' +
                ", businessLicenseId=" + businessLicenseId +
                ", logoUrl='" + logoUrl + '\'' +
                ", flagDeleted=" + flagDeleted +
                ", flagAvailable=" + flagAvailable +
                ", createTime=" + createTime +
                ", createPerson=" + createPerson +
                ", updateTime=" + updateTime +
                ", updatePerson=" + updatePerson +
                ", memo='" + memo + '\'' +
                ", vendorId=" + vendorId +
                ", companyToken='" + companyToken + '\'' +
                ", companyTokenImage='" + companyTokenImage + '\'' +
                '}';
    }
}