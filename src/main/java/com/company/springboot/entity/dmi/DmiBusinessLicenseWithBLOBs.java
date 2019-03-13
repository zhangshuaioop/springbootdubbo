package com.company.springboot.entity.dmi;

public class DmiBusinessLicenseWithBLOBs extends DmiBusinessLicense {
    private String businessArea;

    private String memo;

    public String getBusinessArea() {
        return businessArea;
    }

    public void setBusinessArea(String businessArea) {
        this.businessArea = businessArea == null ? null : businessArea.trim();
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo == null ? null : memo.trim();
    }
}