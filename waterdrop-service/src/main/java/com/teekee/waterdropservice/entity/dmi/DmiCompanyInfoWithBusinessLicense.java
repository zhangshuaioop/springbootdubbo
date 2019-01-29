package com.teekee.waterdropservice.entity.dmi;


import com.teekee.waterdropservice.utils.DateUtil;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;

/**
 * Created by ray on 2017/1/3.
 */
public class DmiCompanyInfoWithBusinessLicense {
    private Integer id = 0;

    private String companyName;

    private String companyFullName;

    private String website;

    private String contactAddress;

    private String telephone;

    private String fax;

    private Integer businessLicenseId;

    private String logoUrl;

    private String memo;

    private String legalPerson;

    private String registerAddress;

    private String licenseCode;

    private BigDecimal registerCapital;

    private Date validDateStart;

    private Date validDateEnd;

    private Date registerDate;

    private String licenseImageUrl;

    private String licenseType;

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
        this.companyName = companyName;
    }

    public String getCompanyFullName() {
        return companyFullName;
    }

    public void setCompanyFullName(String companyFullName) {
        this.companyFullName = companyFullName;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getContactAddress() {
        return contactAddress;
    }

    public void setContactAddress(String contactAddress) {
        this.contactAddress = contactAddress;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
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
        this.logoUrl = logoUrl;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public String getLicenseType() {
        return licenseType;
    }

    public void setLicenseType(String licenseType) {
        this.licenseType = licenseType;
    }

    public String getLegalPerson() {
        return legalPerson;
    }

    public void setLegalPerson(String legalPerson) {
        this.legalPerson = legalPerson;
    }

    public String getRegisterAddress() {
        return registerAddress;
    }

    public void setRegisterAddress(String registerAddress) {
        this.registerAddress = registerAddress;
    }

    public String getLicenseCode() {
        return licenseCode;
    }

    public void setLicenseCode(String licenseCode) {
        this.licenseCode = licenseCode;
    }

    public BigDecimal getRegisterCapital() {
        return registerCapital;
    }

    public void setRegisterCapital(BigDecimal registerCapital) {
        this.registerCapital = registerCapital;
    }

    public Date getValidDateStart() {
        return validDateStart;
    }

    public void setValidDateStart(Date validDateStart) {
        this.validDateStart = validDateStart;
    }

    public Date getValidDateEnd() {
        return validDateEnd;
    }

    public void setValidDateEnd(Date validDateEnd) {
        this.validDateEnd = validDateEnd;
    }

    public Date getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(Date registerDate) {
        this.registerDate = registerDate;
    }

    public String getLicenseImageUrl() {
        return licenseImageUrl;
    }

    public void setLicenseImageUrl(String licenseImageUrl) {
        this.licenseImageUrl = licenseImageUrl;
    }

    public DmiCompanyInfoWithBusinessLicense() {
    }

    public DmiCompanyInfoWithBusinessLicense(HashMap<String, Object> map) {
        String cd = "";
        if (map != null && !map.isEmpty()) {
            if (map.containsKey("website")) setWebsite(map.get("website").toString());
            if (map.containsKey("logo_url")) setLogoUrl(map.get("logo_url").toString());
            if (map.containsKey("memo")) setMemo(map.get("memo").toString());
            if (map.containsKey("telephone")) setTelephone(map.get("telephone").toString());
            if (map.containsKey("business_license_id")) setBusinessLicenseId(Integer.parseInt(map.get("business_license_id").toString()));
            if (map.containsKey("company_name")) setCompanyName(map.get("company_name").toString());
            if (map.containsKey("id")) setId(Integer.parseInt(map.get("id").toString()));
            if (map.containsKey("company_full_name")) setCompanyFullName(map.get("company_full_name").toString());
            if (map.containsKey("fax")) setFax(map.get("fax").toString());
            if (map.containsKey("contact_address")) setContactAddress(map.get("contact_address").toString());
            if (map.containsKey("license_type")) setLicenseType(map.get("license_type").toString());
            if (map.containsKey("legal_person")) setLegalPerson(map.get("legal_person").toString());
            if (map.containsKey("license_code")) setLicenseCode(map.get("license_code").toString());
            if (map.containsKey("license_image_url")) setLicenseImageUrl(map.get("license_image_url").toString());
            if (map.containsKey("license_type")) setLicenseType(map.get("license_type").toString());
            if (map.containsKey("register_address")) setRegisterAddress(map.get("register_address").toString());
            if (map.containsKey("register_capital")) setRegisterCapital(new BigDecimal(map.get("register_capital").toString()));

            if (map.containsKey("valid_date_end")) {
                cd = map.get("valid_date_end").toString();
                if (cd.endsWith(".0")) cd = cd.substring(0, cd.length() - 2);
                if (map.containsKey("valid_date_end")) setValidDateEnd(DateUtil.formatString2Date(cd));
            }

            if (map.containsKey("valid_date_start")) {
                cd = map.get("valid_date_start").toString();
                if (cd.endsWith(".0")) cd = cd.substring(0, cd.length() - 2);
                if (map.containsKey("valid_date_start")) setValidDateStart(DateUtil.formatString2Date(cd));
            }

            if (map.containsKey("register_date")) {
                cd = map.get("register_date").toString();
                if (cd.endsWith(".0")) cd = cd.substring(0, cd.length() - 2);
                if (map.containsKey("register_date")) setRegisterDate(DateUtil.formatString2Date(cd));
            }
        }
    }
}
