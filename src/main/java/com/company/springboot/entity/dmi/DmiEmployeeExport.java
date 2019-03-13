package com.company.springboot.entity.dmi;

/**
 * @author Wujun
 * @create 2017年12月01日 14:00
 */
public class DmiEmployeeExport extends DmiEmployee {

    private String companyName;

    private String organizationName;

    private String flagManualString;

    private String flagAvailableString;

    private String organizationCode;

    public String getOrganizationCode() {
        return organizationCode;
    }

    public void setOrganizationCode(String organizationCode) {
        this.organizationCode = organizationCode;
    }

    public String getFlagAvailableString() {
        return flagAvailableString;
    }

    public void setFlagAvailableString(String flagAvailableString) {
        this.flagAvailableString = flagAvailableString;
    }

    public String getFlagManualString() {
        return flagManualString;
    }

    public void setFlagManualString(String flagManualString) {
        this.flagManualString = flagManualString;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getOrganizationName() {
        return organizationName;
    }

    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
    }

}
