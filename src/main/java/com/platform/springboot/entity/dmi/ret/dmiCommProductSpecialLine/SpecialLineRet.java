package com.platform.springboot.entity.dmi.ret.dmiCommProductSpecialLine;

public class SpecialLineRet {

    private String aStore;

    private String aAddress;

    private String aPortType;

    private Integer aBandWidth;

    private String aBandWidthType;

    private String aLocalCode;

    private Integer zStore;

    private String zPortType;

    private Integer zBandWidth;

    private String zBandWidthType;

    private String zLocalCode;

    private Integer bandWidth;

    private String bandWidthType;

    public Integer getBandWidth() {
        return bandWidth;
    }

    public void setBandWidth(Integer bandWidth) {
        this.bandWidth = bandWidth;
    }

    public String getBandWidthType() {
        return bandWidthType;
    }

    public void setBandWidthType(String bandWidthType) {
        this.bandWidthType = bandWidthType;
    }

    public String getaPortType() {
        return aPortType;
    }

    public void setaPortType(String aPortType) {
        this.aPortType = aPortType == null ? null : aPortType.trim();
    }

    public Integer getaBandWidth() {
        return aBandWidth;
    }

    public void setaBandWidth(Integer aBandWidth) {
        this.aBandWidth = aBandWidth;
    }

    public String getaBandWidthType() {
        return aBandWidthType;
    }

    public void setaBandWidthType(String aBandWidthType) {
        this.aBandWidthType = aBandWidthType == null ? null : aBandWidthType.trim();
    }

    public String getaLocalCode() {
        return aLocalCode;
    }

    public void setaLocalCode(String aLocalCode) {
        this.aLocalCode = aLocalCode == null ? null : aLocalCode.trim();
    }

    public String getzPortType() {
        return zPortType;
    }

    public void setzPortType(String zPortType) {
        this.zPortType = zPortType == null ? null : zPortType.trim();
    }

    public Integer getzBandWidth() {
        return zBandWidth;
    }

    public void setzBandWidth(Integer zBandWidth) {
        this.zBandWidth = zBandWidth;
    }

    public String getzBandWidthType() {
        return zBandWidthType;
    }

    public void setzBandWidthType(String zBandWidthType) {
        this.zBandWidthType = zBandWidthType == null ? null : zBandWidthType.trim();
    }

    public String getzLocalCode() {
        return zLocalCode;
    }

    public void setzLocalCode(String zLocalCode) {
        this.zLocalCode = zLocalCode == null ? null : zLocalCode.trim();
    }

    public String getaStore() {
        return aStore;
    }

    public void setaStore(String aStore) {
        this.aStore = aStore;
    }

    public String getaAddress() {
        return aAddress;
    }

    public void setaAddress(String aAddress) {
        this.aAddress = aAddress;
    }

    public Integer getzStore() {
        return zStore;
    }

    public void setzStore(Integer zStore) {
        this.zStore = zStore;
    }
}