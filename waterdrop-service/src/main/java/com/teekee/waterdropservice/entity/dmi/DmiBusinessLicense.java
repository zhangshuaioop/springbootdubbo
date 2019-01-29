package com.teekee.waterdropservice.entity.dmi;

import com.teekee.commoncomponets.base.BaseEntity;

import java.math.BigDecimal;
import java.util.Date;

public class DmiBusinessLicense extends BaseEntity {
    private Integer id;

    private String companyName;

    private String licenseType;

    private String legalPerson;

    private String registerAddress;

    private String licenseCodeType;

    private String licenseCode;

    private String registerPlace;

    private BigDecimal registerCapital;

    private String monetaryUnit;

    private Date validDateStart;

    private Date validDateEnd;

    private Date registerDate;

    private String registerOffice;

    private Date issuingDate;

    private Boolean flagIntegrated;

    private String licenseImageUrl;

    private Boolean flagDeleted;

    private Boolean flagAvailable;

    private Integer companyId;

    private Date createTime;

    private Integer createPerson;

    private Date updateTime;

    private Integer updatePerson;

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

    public String getLicenseType() {
        return licenseType;
    }

    public void setLicenseType(String licenseType) {
        this.licenseType = licenseType == null ? null : licenseType.trim();
    }

    public String getLegalPerson() {
        return legalPerson;
    }

    public void setLegalPerson(String legalPerson) {
        this.legalPerson = legalPerson == null ? null : legalPerson.trim();
    }

    public String getRegisterAddress() {
        return registerAddress;
    }

    public void setRegisterAddress(String registerAddress) {
        this.registerAddress = registerAddress == null ? null : registerAddress.trim();
    }

    public String getLicenseCodeType() {
        return licenseCodeType;
    }

    public void setLicenseCodeType(String licenseCodeType) {
        this.licenseCodeType = licenseCodeType == null ? null : licenseCodeType.trim();
    }

    public String getLicenseCode() {
        return licenseCode;
    }

    public void setLicenseCode(String licenseCode) {
        this.licenseCode = licenseCode == null ? null : licenseCode.trim();
    }

    public String getRegisterPlace() {
        return registerPlace;
    }

    public void setRegisterPlace(String registerPlace) {
        this.registerPlace = registerPlace == null ? null : registerPlace.trim();
    }

    public BigDecimal getRegisterCapital() {
        return registerCapital;
    }

    public void setRegisterCapital(BigDecimal registerCapital) {
        this.registerCapital = registerCapital;
    }

    public String getMonetaryUnit() {
        return monetaryUnit;
    }

    public void setMonetaryUnit(String monetaryUnit) {
        this.monetaryUnit = monetaryUnit == null ? null : monetaryUnit.trim();
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

    public String getRegisterOffice() {
        return registerOffice;
    }

    public void setRegisterOffice(String registerOffice) {
        this.registerOffice = registerOffice == null ? null : registerOffice.trim();
    }

    public Date getIssuingDate() {
        return issuingDate;
    }

    public void setIssuingDate(Date issuingDate) {
        this.issuingDate = issuingDate;
    }

    public Boolean getFlagIntegrated() {
        return flagIntegrated;
    }

    public void setFlagIntegrated(Boolean flagIntegrated) {
        this.flagIntegrated = flagIntegrated;
    }

    public String getLicenseImageUrl() {
        return licenseImageUrl;
    }

    public void setLicenseImageUrl(String licenseImageUrl) {
        this.licenseImageUrl = licenseImageUrl == null ? null : licenseImageUrl.trim();
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

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
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

    @Override
    public String toString() {
        return "DmiBusinessLicense{" +
                "id=" + id +
                ", companyName='" + companyName + '\'' +
                ", licenseType='" + licenseType + '\'' +
                ", legalPerson='" + legalPerson + '\'' +
                ", registerAddress='" + registerAddress + '\'' +
                ", licenseCodeType='" + licenseCodeType + '\'' +
                ", licenseCode='" + licenseCode + '\'' +
                ", registerPlace='" + registerPlace + '\'' +
                ", registerCapital=" + registerCapital +
                ", monetaryUnit='" + monetaryUnit + '\'' +
                ", validDateStart=" + validDateStart +
                ", validDateEnd=" + validDateEnd +
                ", registerDate=" + registerDate +
                ", registerOffice='" + registerOffice + '\'' +
                ", issuingDate=" + issuingDate +
                ", flagIntegrated=" + flagIntegrated +
                ", licenseImageUrl='" + licenseImageUrl + '\'' +
                ", flagDeleted=" + flagDeleted +
                ", flagAvailable=" + flagAvailable +
                ", companyId=" + companyId +
                ", createTime=" + createTime +
                ", createPerson=" + createPerson +
                ", updateTime=" + updateTime +
                ", updatePerson=" + updatePerson +
                '}';
    }
}