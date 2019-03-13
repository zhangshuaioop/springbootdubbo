package com.company.springboot.entity.dmi;

import com.company.springboot.utils.DateUtil;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class DmiStoreWithBusinessLicense {
    private Integer id = 0;

    private String storeName;

    private String storeCode;

    private String manager;

    private String telephone;

    private String address;

    private BigDecimal longitude;

    private BigDecimal latitude;

    private Boolean flagDeleted;

    private Boolean flagAvailable;

    private String province;

    private String city;

    private String district;

    private String row;

    private String road;

    private String buildingName;

    private Integer buildingId;

    private Integer brandId;

    private Integer addrListId;

    private Integer areaId;

    private Integer compnayId;

    private Integer businessLicenseId;

    private Date createTime;

    private Integer createPerson;

    private Date updateTime;

    private Integer updatePerson;

    private String memo;

    private String licenseType;

    private String legalPerson;

    private String registerAddress;

    private String licenseCode;

    private String licenseCodeType;

    private String registerPlace;

    private BigDecimal registerCapital;

    private Date validDateStart;

    private Date validDateEnd;

    private Date registerDate;

    private String registerOffice;

    private Date issuingDate;

    private Boolean flagIntegrated;

    private String licenseImageUrl;

    private String licenseCompanyName;

    private String roomCode;

    private String floor;

    private String buildingCode;

    private String importAddress;

    private List<DmiStoreUploadFile> storeUploadFileList;

    public List<DmiStoreUploadFile> getStoreUploadFileList() {
        return storeUploadFileList;
    }

    public void setStoreUploadFileList(List<DmiStoreUploadFile> storeUploadFileList) {
        this.storeUploadFileList = storeUploadFileList;
    }

    public Integer getBuildingId() {
        return buildingId;
    }

    public void setBuildingId(Integer buildingId) {
        this.buildingId = buildingId;
    }

    public String getFloor() {
        return floor;
    }

    public void setFloor(String floor) {
        this.floor = floor;
    }

    public String getBuildingCode() {
        return buildingCode;
    }

    public void setBuildingCode(String buildingCode) {
        this.buildingCode = buildingCode;
    }

    public String getRoomCode() {
        return roomCode;
    }

    public void setRoomCode(String roomCode) {
        this.roomCode = roomCode;
    }

    public Integer getBrandId() {
        return brandId;
    }

    public void setBrandId(Integer brandId) {
        this.brandId = brandId;
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
        this.storeName = storeName == null ? null : storeName.trim();
    }

    public String getStoreCode() {
        return storeCode;
    }

    public void setStoreCode(String storeCode) {
        this.storeCode = storeCode == null ? null : storeCode.trim();
    }

    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager == null ? null : manager.trim();
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone == null ? null : telephone.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public BigDecimal getLongitude() {
        return longitude;
    }

    public void setLongitude(BigDecimal longitude) {
        this.longitude = longitude;
    }

    public BigDecimal getLatitude() {
        return latitude;
    }

    public void setLatitude(BigDecimal latitude) {
        this.latitude = latitude;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province == null ? null : province.trim();
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city == null ? null : city.trim();
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district == null ? null : district.trim();
    }

    public String getRow() {
        return row;
    }

    public void setRow(String row) {
        this.row = row == null ? null : row.trim();
    }

    public String getRoad() {
        return road;
    }

    public void setRoad(String road) {
        this.road = road == null ? null : road.trim();
    }

    public String getBuildingName() {
        return buildingName;
    }

    public void setBuildingName(String buildingName) {
        this.buildingName = buildingName == null ? null : buildingName.trim();
    }

    public Integer getAddrListId() {
        return addrListId;
    }

    public void setAddrListId(Integer addrListId) {
        this.addrListId = addrListId;
    }

    public Integer getAreaId() {
        return areaId;
    }

    public void setAreaId(Integer areaId) {
        this.areaId = areaId;
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

    public Integer getCompnayId() {
        return compnayId;
    }

    public void setCompnayId(Integer compnayId) {
        this.compnayId = compnayId;
    }

    public Integer getBusinessLicenseId() {
        return businessLicenseId;
    }

    public void setBusinessLicenseId(Integer businessLicenseId) {
        this.businessLicenseId = businessLicenseId;
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

    public String getLicenseCodeType() {
        return licenseCodeType;
    }

    public void setLicenseCodeType(String licenseCodeType) {
        this.licenseCodeType = licenseCodeType;
    }

    public String getRegisterPlace() {
        return registerPlace;
    }

    public void setRegisterPlace(String registerPlace) {
        this.registerPlace = registerPlace;
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

    public String getRegisterOffice() {
        return registerOffice;
    }

    public void setRegisterOffice(String registerOffice) {
        this.registerOffice = registerOffice;
    }

    public Date getIssuingDate() {
        return issuingDate;
    }

    public void setIssuingDate(Date issuingDate) {
        this.issuingDate = issuingDate;
    }

    public void setIsIntegrated(Boolean isIntegrated) {
        isIntegrated = isIntegrated;
    }

    public String getLicenseImageUrl() {
        return licenseImageUrl;
    }

    public void setLicenseImageUrl(String licenseImageUrl) {
        this.licenseImageUrl = licenseImageUrl;
    }

    public String getLicenseCompanyName() {
        return licenseCompanyName;
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

    public Boolean getFlagIntegrated() {
        return flagIntegrated;
    }

    public void setFlagIntegrated(Boolean flagIntegrated) {
        this.flagIntegrated = flagIntegrated;
    }

    public void setLicenseCompanyName(String licenseCompanyName) {
        this.licenseCompanyName = licenseCompanyName;
    }

    public String getImportAddress() {
        return importAddress;
    }

    public void setImportAddress(String importAddress) {
        this.importAddress = importAddress;
    }

    public DmiStoreWithBusinessLicense() {
    }

    public DmiStoreWithBusinessLicense(HashMap<String, Object> map) {
        if (map.containsKey("id")) setId(Integer.parseInt(map.get("id").toString()));
        if (map.containsKey("flag_deleted")) setFlagDeleted(Boolean.parseBoolean(map.get("flag_deleted").toString()));
        if (map.containsKey("memo")) setMemo(map.get("memo").toString());
        if (map.containsKey("flag_available")) setFlagAvailable(Boolean.parseBoolean(map.get("flag_available").toString()));
        if (map.containsKey("store_name")) setStoreName(map.get("store_name").toString());
        if (map.containsKey("store_code")) setStoreCode(map.get("store_code").toString());
        if (map.containsKey("manager")) setManager(map.get("manager").toString());
        if (map.containsKey("telephone")) setTelephone(map.get("telephone").toString());
        if (map.containsKey("address")) setAddress(map.get("address").toString());
        if (map.containsKey("longitude")) setLongitude(new BigDecimal(map.get("longitude").toString()));
        if (map.containsKey("latitude")) setLatitude(new BigDecimal(map.get("latitude").toString()));
        if (map.containsKey("province")) setProvince(map.get("province").toString());
        if (map.containsKey("city")) setCity(map.get("city").toString());
        if (map.containsKey("district")) setDistrict(map.get("district").toString());
        if (map.containsKey("row")) setRow(map.get("row").toString());
        if (map.containsKey("road")) setRoad(map.get("road").toString());
        if (map.containsKey("brand_id")) setBrandId(Integer.parseInt(map.get("brand_id").toString()));
        if (map.containsKey("building_name")) setBuildingName(map.get("building_name").toString());
        if (map.containsKey("addr_list_id")) setAddrListId(Integer.parseInt(map.get("addr_list_id").toString()));
        if (map.containsKey("area_id")) setAreaId(Integer.parseInt(map.get("area_id").toString()));
        if (map.containsKey("company_id")) setCompnayId(Integer.parseInt(map.get("company_id").toString()));
        if (map.containsKey("business_license_id")) setBusinessLicenseId(Integer.parseInt(map.get("business_license_id").toString()));
        if (map.containsKey("license_type")) setLicenseType(map.get("license_type").toString());
        if (map.containsKey("legal_person")) setLegalPerson(map.get("legal_person").toString());
        if (map.containsKey("register_address")) setRegisterAddress(map.get("register_address").toString());
        if (map.containsKey("license_code")) setLicenseCode(map.get("license_code").toString());
        if (map.containsKey("license_code_type")) setLicenseCodeType(map.get("license_code_type").toString());
        if (map.containsKey("register_place")) setRegisterPlace(map.get("register_place").toString());
        if (map.containsKey("flag_integrated")) setIsIntegrated(Boolean.parseBoolean(map.get("flag_integrated").toString()));
        if (map.containsKey("license_image_url")) setLicenseImageUrl(map.get("license_image_url").toString());
        if (map.containsKey("company_name")) setLicenseCompanyName(map.get("company_name").toString());
        if (map.containsKey("register_office")) setRegisterOffice(map.get("register_office").toString());
        if (map.containsKey("room_code")) setRoomCode(map.get("room_code").toString());
        if (map.containsKey("import_address")) setImportAddress(map.get("import_address").toString());

        if (map.containsKey("register_capital")) {
            if (map.get("register_capital") != null && map.get("register_capital").toString().length() > 0)
                setRegisterCapital(new BigDecimal(map.get("register_capital").toString()));
        }

        if (map.containsKey("valid_date_start")) {
            if (map.get("valid_date_start") != null && map.get("valid_date_start").toString().length() > 0)
                setValidDateStart(DateUtil.formatString2Date(map.get("valid_date_start").toString()));
        }

        if (map.containsKey("valid_date_end")) {
            if (map.get("valid_date_end") != null && map.get("valid_date_end").toString().length() > 0)
                setValidDateEnd(DateUtil.formatString2Date(map.get("valid_date_end").toString()));
        }

        if (map.containsKey("register_date")) {
            if (map.get("register_date") != null && map.get("register_date").toString().length() > 0)
                setRegisterDate(DateUtil.formatString2Date(map.get("register_date").toString()));
        }

        if (map.containsKey("issuing_date")) {
            if (map.get("issuing_date") != null && map.get("issuing_date").toString().length() > 0)
                setIssuingDate(DateUtil.formatString2Date(map.get("issuing_date").toString()));
        }
    }

}