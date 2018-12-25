package com.platform.springboot.entity.dco;

public class DcoDemandCustomerOrderDetail extends DcoDemandCustomerOrder {
    private String companyName;

    private String address;
    private Integer addressId;
    private Integer buildingId;
    private String buildingCode;
    private String floor;
    private String roomCode;

    private String storeName;

    private String brandName;

    private String dealPersonName;

    private String createPersonName;

    private String createPersonType;

    private String currentUrgencyStatusName;

    private String dealPersonType;

    public String getBuildingCode() {
        return buildingCode;
    }

    public void setBuildingCode(String buildingCode) {
        this.buildingCode = buildingCode;
    }

    public String getFloor() {
        return floor;
    }

    public void setFloor(String floor) {
        this.floor = floor;
    }

    public String getRoomCode() {
        return roomCode;
    }

    public void setRoomCode(String roomCode) {
        this.roomCode = roomCode;
    }

    public Integer getBuildingId() {
        return buildingId;
    }

    public void setBuildingId(Integer buildingId) {
        this.buildingId = buildingId;
    }

    public Integer getAddressId() {
        return addressId;
    }

    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
    }

    public String getDealPersonType() {
        return dealPersonType;
    }

    public void setDealPersonType(String dealPersonType) {
        this.dealPersonType = dealPersonType;
    }

    public String getCreatePersonType() {
        return createPersonType;
    }

    public void setCreatePersonType(String createPersonType) {
        this.createPersonType = createPersonType;
    }

    public String getCurrentUrgencyStatusName() {
        return currentUrgencyStatusName;
    }

    public void setCurrentUrgencyStatusName(String currentUrgencyStatusName) {
        this.currentUrgencyStatusName = currentUrgencyStatusName;
    }

    public String getCreatePersonName() {
        return createPersonName;
    }

    public void setCreatePersonName(String createPersonName) {
        this.createPersonName = createPersonName;
    }

    public String getDealPersonName() {
        return dealPersonName;
    }

    public void setDealPersonName(String dealPersonName) {
        this.dealPersonName = dealPersonName;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}