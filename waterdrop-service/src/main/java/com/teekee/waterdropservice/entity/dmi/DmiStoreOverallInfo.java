package com.teekee.waterdropservice.entity.dmi;

import com.teekee.waterdropservice.entity.bif.BifDeviceDetail;
import com.teekee.waterdropservice.entity.dmi.ret.dmiStore.IndieProductInfo;
import com.teekee.waterdropservice.entity.dmi.ret.dmiStore.MarketingCampaignInfo;

import java.util.List;

/**
 * Created by ray on 2017/1/3.
 */
public class DmiStoreOverallInfo {
    //门店基础信息
    private DmiStoreWithBusinessLicense dmiStoreWithBusinessLicense;

    //门店联系人信息
    private List<DmiContactStoreRelationDetail> dmiContactStoreRelationDetailList;

    //门店设备信息
    private List<BifDeviceDetail> dmiDeviceList;

    //门店通信资源信息
    private List<MarketingCampaignInfo> marketingCampaignInfoList;
    private List<IndieProductInfo> indieProductInfoList;

    // 门店资料
//    private List<DmiStoreUploadFile> storeUploadFileList;
//
//    public List<DmiStoreUploadFile> getStoreUploadFileList() {
//        return storeUploadFileList;
//    }
//
//    public void setStoreUploadFileList(List<DmiStoreUploadFile> storeUploadFileList) {
//        this.storeUploadFileList = storeUploadFileList;
//    }

    public List<MarketingCampaignInfo> getMarketingCampaignInfoList() {
        return marketingCampaignInfoList;
    }

    public void setMarketingCampaignInfoList(List<MarketingCampaignInfo> marketingCampaignInfoList) {
        this.marketingCampaignInfoList = marketingCampaignInfoList;
    }

    public List<IndieProductInfo> getIndieProductInfoList() {
        return indieProductInfoList;
    }

    public void setIndieProductInfoList(List<IndieProductInfo> indieProductInfoList) {
        this.indieProductInfoList = indieProductInfoList;
    }

    public DmiStoreWithBusinessLicense getDmiStoreWithBusinessLicense() {
        return dmiStoreWithBusinessLicense;
    }

    public void setDmiStoreWithBusinessLicense(DmiStoreWithBusinessLicense dmiStoreWithBusinessLicense) {
        this.dmiStoreWithBusinessLicense = dmiStoreWithBusinessLicense;
    }

    public List<DmiContactStoreRelationDetail> getDmiContactStoreRelationDetailList() {
        return dmiContactStoreRelationDetailList;
    }

    public void setDmiContactStoreRelationDetailList(List<DmiContactStoreRelationDetail> dmiContactStoreRelationDetailList) {
        this.dmiContactStoreRelationDetailList = dmiContactStoreRelationDetailList;
    }

    public List<BifDeviceDetail> getDmiDeviceList() {
        return dmiDeviceList;
    }

    public void setDmiDeviceList(List<BifDeviceDetail> dmiDeviceList) {
        this.dmiDeviceList = dmiDeviceList;
    }

}
