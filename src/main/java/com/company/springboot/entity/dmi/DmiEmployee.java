package com.company.springboot.entity.dmi;

import com.company.springboot.base.BaseEntity;

import java.util.Date;

public class DmiEmployee extends BaseEntity {
    private Integer id;

    private String employeeName;

    private String employeeNameEn;

    private String employeeCode;

    private Integer belongCompanyId;

    private Integer catalogId;

    private String sex;

    private String position;

    private String educationCertification;

    private String telephone;

    private String mobile;

    private String nativePlace;

    private String nation;

    private String idType;

    private String idCode;

    private String address;

    private String batchInsertCode;

    private Boolean flagManual;

    private Boolean flagDeleted;

    private Boolean flagAvailable;

    private Date createTime;

    private Integer createPerson;

    private Date updateTime;

    private Integer updatePerson;

    private String memo;

    private String email;

    private String catalogSourceList;

    private String catalogSourceListId;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName == null ? null : employeeName.trim();
    }

    public String getEmployeeNameEn() {
        return employeeNameEn;
    }

    public void setEmployeeNameEn(String employeeNameEn) {
        this.employeeNameEn = employeeNameEn == null ? null : employeeNameEn.trim();
    }

    public String getEmployeeCode() {
        return employeeCode;
    }

    public void setEmployeeCode(String employeeCode) {
        this.employeeCode = employeeCode == null ? null : employeeCode.trim();
    }

    public Integer getBelongCompanyId() {
        return belongCompanyId;
    }

    public void setBelongCompanyId(Integer belongCompanyId) {
        this.belongCompanyId = belongCompanyId;
    }

    public Integer getCatalogId() {
        return catalogId;
    }

    public void setCatalogId(Integer catalogId) {
        this.catalogId = catalogId;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position == null ? null : position.trim();
    }

    public String getEducationCertification() {
        return educationCertification;
    }

    public void setEducationCertification(String educationCertification) {
        this.educationCertification = educationCertification == null ? null : educationCertification.trim();
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone == null ? null : telephone.trim();
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    public String getNativePlace() {
        return nativePlace;
    }

    public void setNativePlace(String nativePlace) {
        this.nativePlace = nativePlace == null ? null : nativePlace.trim();
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation == null ? null : nation.trim();
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getBatchInsertCode() {
        return batchInsertCode;
    }

    public void setBatchInsertCode(String batchInsertCode) {
        this.batchInsertCode = batchInsertCode == null ? null : batchInsertCode.trim();
    }

    public Boolean getFlagManual() {
        return flagManual;
    }

    public void setFlagManual(Boolean flagManual) {
        this.flagManual = flagManual;
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
        this.memo = memo == null ? null : memo.trim();
    }

    public String getCatalogSourceList() {
        return catalogSourceList;
    }

    public void setCatalogSourceList(String catalogSourceList) {
        this.catalogSourceList = catalogSourceList;
    }

    public String getCatalogSourceListId() {
        return catalogSourceListId;
    }

    public void setCatalogSourceListId(String catalogSourceListId) {
        this.catalogSourceListId = catalogSourceListId;
    }
}