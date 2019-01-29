package com.teekee.waterdropservice.entity.dmi;

import java.util.HashMap;
import java.util.List;

/**
 * Created by ray on 2017/1/3.
 */
public class DmiCompanyOverallInfo {
    //雇主企业基础信息
    private DmiCompanyInfoWithBusinessLicense dmiCompanyInfoWithBusinessLicense;

    //雇主公司联系人信息
    private List<DmiContactCompanyRelationDetail> dmiContactCompanyRelationDetailsList;

    //雇主公司发票信息
    private List<DmiInvoiceModelWithBLOBs> dmiInvoiceModelWithBOLBSList;

    //雇主公司组织结构信息
    private List<HashMap<String,Object>> dmiOrganizationTree ;

    //雇主公司品牌信息
    private List<DmiBrand> dmiBrandsList;


    public DmiCompanyInfoWithBusinessLicense getDmiCompanyInfoWithBusinessLicense() {
        return dmiCompanyInfoWithBusinessLicense;
    }

    public void setDmiCompanyInfoWithBusinessLicense(DmiCompanyInfoWithBusinessLicense dmiCompanyInfoWithBusinessLicense) {
        this.dmiCompanyInfoWithBusinessLicense = dmiCompanyInfoWithBusinessLicense;
    }

    public List<DmiContactCompanyRelationDetail> getDmiContactCompanyRelationDetailsList() {
        return dmiContactCompanyRelationDetailsList;
    }

    public void setDmiContactCompanyRelationDetailsList(List<DmiContactCompanyRelationDetail> dmiContactCompanyRelationDetailsList) {
        this.dmiContactCompanyRelationDetailsList = dmiContactCompanyRelationDetailsList;
    }

    public List<DmiInvoiceModelWithBLOBs> getDmiInvoiceModelWithContactsList() {
        return dmiInvoiceModelWithBOLBSList;
    }

    public void setDmiInvoiceModelWithContactsList(List<DmiInvoiceModelWithBLOBs> dmiInvoiceModelWithContactsList) {
        this.dmiInvoiceModelWithBOLBSList = dmiInvoiceModelWithContactsList;
    }

    public List<HashMap<String, Object>> getDmiOrganizationTree() {
        return dmiOrganizationTree;
    }

    public void setDmiOrganizationTree(List<HashMap<String, Object>> dmiOrganizationTree) {
        this.dmiOrganizationTree = dmiOrganizationTree;
    }

    public List<DmiBrand> getDmiBrandsList() {
        return dmiBrandsList;
    }

    public void setDmiBrandsList(List<DmiBrand> dmiBrandsList) {
        this.dmiBrandsList = dmiBrandsList;
    }
}
