package com.platform.springboot.entity.dmi;

public class DmiCommProductBroadbandWithBLOBs extends DmiCommProductBroadband {
    private String ipSectionBeginValue;

    private String ipSectionEndValue;

    public String getIpSectionBeginValue() {
        return ipSectionBeginValue;
    }

    public void setIpSectionBeginValue(String ipSectionBeginValue) {
        this.ipSectionBeginValue = ipSectionBeginValue == null ? null : ipSectionBeginValue.trim();
    }

    public String getIpSectionEndValue() {
        return ipSectionEndValue;
    }

    public void setIpSectionEndValue(String ipSectionEndValue) {
        this.ipSectionEndValue = ipSectionEndValue == null ? null : ipSectionEndValue.trim();
    }
}