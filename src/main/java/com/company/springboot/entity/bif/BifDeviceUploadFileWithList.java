package com.company.springboot.entity.bif;

import com.company.springboot.entity.dmi.DmiStoreUploadFile;

import java.util.List;

public class BifDeviceUploadFileWithList extends BifDeviceUploadFile {

    private List<BifDeviceUploadFile> list;

    private List<DmiStoreUploadFile> storeUploadFileList;

    public List<BifDeviceUploadFile> getList() {
        return list;
    }

    public void setList(List<BifDeviceUploadFile> list) {
        this.list = list;
    }

    public List<DmiStoreUploadFile> getStoreUploadFileList() {
        return storeUploadFileList;
    }

    public void setStoreUploadFileList(List<DmiStoreUploadFile> storeUploadFileList) {
        this.storeUploadFileList = storeUploadFileList;
    }
}