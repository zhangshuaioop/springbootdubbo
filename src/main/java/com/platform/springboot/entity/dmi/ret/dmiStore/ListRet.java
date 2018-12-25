package com.platform.springboot.entity.dmi.ret.dmiStore;

import com.platform.springboot.base.BaseEntity;
import com.platform.springboot.base.BaseEntity;

import javax.sql.rowset.BaseRowSet;
import java.util.Date;

/**
 * 根据区域品牌雇主，获取门店列表-返回结果
 *
 * @author Wujun
 * @create 2017年06月29日 16:11
 */
public class ListRet extends BaseEntity {
    private Integer id;
    private Integer addressId;
    private String importAddress;
    private String storeName;
    private String address;
    private String storeCode;
    private String contactName;
    private String mobile;
    private boolean flagAvailable;
    private String province;
    private String city;
    private String district;
    private String companyBrand;
    private int productCount;
    private Date updateTime;
    private Date createTime;
    private String createPerson;
    private String updatePerson;
    private String storeTokenImageUrl;

    public Integer getAddressId() {
        return addressId;
    }

    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
    }

    public String getImportAddress() {
        return importAddress;
    }

    public void setImportAddress(String importAddress) {
        this.importAddress = importAddress;
    }

    public String getStoreTokenImageUrl() {
        return storeTokenImageUrl;
    }

    public void setStoreTokenImageUrl(String storeTokenImageUrl) {
        this.storeTokenImageUrl = storeTokenImageUrl;
    }

    public String getCreatePerson() {
        return createPerson;
    }

    public void setCreatePerson(String createPerson) {
        this.createPerson = createPerson;
    }

    public String getUpdatePerson() {
        return updatePerson;
    }

    public void setUpdatePerson(String updatePerson) {
        this.updatePerson = updatePerson;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public int getProductCount() {
        return productCount;
    }

    public void setProductCount(int productCount) {
        this.productCount = productCount;
    }

    public String getCompanyBrand() {
        return companyBrand;
    }

    public void setCompanyBrand(String companyBrand) {
        this.companyBrand = companyBrand;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public boolean isFlagAvailable() {
        return flagAvailable;
    }

    public void setFlagAvailable(boolean flagAvailable) {
        this.flagAvailable = flagAvailable;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getStoreCode() {
        return storeCode;
    }

    public void setStoreCode(String storeCode) {
        this.storeCode = storeCode;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
}
