package com.company.springboot.entity.cfg;

/**
 * @author Wujun
 * @create 2018年04月20日 14:55
 */
public class CfgDispatchRequestModelImportConfig {

    private  Integer id;

    private String importType;

    private String dispatchType;

    private Integer dispatchVersion;

    private String requestModel;

    private Boolean flagDeleted;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getImportType() {
        return importType;
    }

    public void setImportType(String importType) {
        this.importType = importType;
    }

    public String getDispatchType() {
        return dispatchType;
    }

    public void setDispatchType(String dispatchType) {
        this.dispatchType = dispatchType;
    }

    public Integer getDispatchVersion() {
        return dispatchVersion;
    }

    public void setDispatchVersion(Integer dispatchVersion) {
        this.dispatchVersion = dispatchVersion;
    }

    public String getRequestModel() {
        return requestModel;
    }

    public void setRequestModel(String requestModel) {
        this.requestModel = requestModel;
    }

    public Boolean getFlagDeleted() {
        return flagDeleted;
    }

    public void setFlagDeleted(Boolean flagDeleted) {
        this.flagDeleted = flagDeleted;
    }
}
