package com.company.springboot.entity.dmi;

import java.util.Date;
import java.util.HashMap;

public class DmiCompanyInfoWithContact {
    private Integer id = 0;

    private String companyName;

    private String companyFullName;

    private String website;

    private String contactAddress;

    private String telephone;

    private String fax;

    private Integer businessLicenseId;

    private String logoUrl;

    private Boolean flagDeleted;

    private Boolean flagAvailable;

    private String memo;

    private String mainContact;

    private String contactMobile;

    private String contactTel;

    private Date updateTime;

    private String CompanyTokenImage;

    public String getCompanyTokenImage() {
        return CompanyTokenImage;
    }

    public void setCompanyTokenImage(String companyTokenImage) {
        CompanyTokenImage = companyTokenImage;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getMainContact() {
        return mainContact;
    }

    public void setMainContact(String mainContact) {
        this.mainContact = mainContact;
    }

    public String getContactMobile() {
        return contactMobile;
    }

    public void setContactMobile(String contactMobile) {
        this.contactMobile = contactMobile;
    }

    public String getContactTel() {
        return contactTel;
    }

    public void setContactTel(String contactTel) {
        this.contactTel = contactTel;
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

    public DmiCompanyInfoWithContact() {
    }

    public DmiCompanyInfoWithContact(HashMap<String, Object> map) {
        if (map.containsKey("website")) setWebsite(map.get("website").toString());
        if (map.containsKey("logo_url")) setLogoUrl(map.get("logo_url").toString());
        if (map.containsKey("memo")) setMemo(map.get("memo").toString());
        if (map.containsKey("contact_tel")) setContactTel(map.get("contact_tel").toString());
        if (map.containsKey("telephone")) setTelephone(map.get("telephone").toString());
        if (map.containsKey("flag_available")) setFlagAvailable(Boolean.parseBoolean(map.get("flag_available").toString()));
        if (map.containsKey("business_license_id")) setBusinessLicenseId(Integer.parseInt(map.get("business_license_id").toString()));
        if (map.containsKey("mainContact")) setMainContact(map.get("mainContact").toString());
        if (map.containsKey("company_name")) setCompanyName(map.get("company_name").toString());
        if (map.containsKey("id")) setId(Integer.parseInt(map.get("id").toString()));
        if (map.containsKey("flag_deleted")) setFlagDeleted(Boolean.parseBoolean(map.get("flag_deleted").toString()));
        if (map.containsKey("company_full_name")) setCompanyFullName(map.get("company_full_name").toString());
        if (map.containsKey("fax")) setId(Integer.parseInt(map.get("id").toString()));
        if (map.containsKey("contact_address")) setContactAddress(map.get("contact_address").toString());
        if (map.containsKey("contact_mobile")) setContactMobile(map.get("contact_mobile").toString());
        if (map.containsKey("update_time")) setUpdateTime((Date) map.get("update_time"));
        if (map.containsKey("company_token_image")) setCompanyTokenImage(map.get("company_token_image").toString());
    }
}