package com.teekee.blueoceanservice.entity.fdp;

/**
 * @Author Niting
 * @date 2018/10/16
 **/
public class GetFdpRequestHistoryList {
    private String version;
    private Integer requestId;
    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public Integer getRequestId() {
        return requestId;
    }

    public void setRequestId(Integer requestId) {
        this.requestId = requestId;
    }
}
