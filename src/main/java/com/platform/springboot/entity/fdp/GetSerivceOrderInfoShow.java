package com.platform.springboot.entity.fdp;

import java.util.List;

/**
 * @Author Niting
 * @date 2018/8/22
 **/
public class GetSerivceOrderInfoShow {
    private GetServiceOrderBasicInfo serviceOrderBasicInfo;
    private List<FdpDispatchJobPerformance> jobPerformanceList;
    private GetServiceCompleteProfile serviceCompleteProfile;

    public GetServiceOrderBasicInfo getServiceOrderBasicInfo() {
        return serviceOrderBasicInfo;
    }

    public void setServiceOrderBasicInfo(GetServiceOrderBasicInfo serviceOrderBasicInfo) {
        this.serviceOrderBasicInfo = serviceOrderBasicInfo;
    }

    public List<FdpDispatchJobPerformance> getJobPerformanceList() {
        return jobPerformanceList;
    }

    public void setJobPerformanceList(List<FdpDispatchJobPerformance> jobPerformanceList) {
        this.jobPerformanceList = jobPerformanceList;
    }

    public GetServiceCompleteProfile getServiceCompleteProfile() {
        return serviceCompleteProfile;
    }

    public void setServiceCompleteProfile(GetServiceCompleteProfile serviceCompleteProfile) {
        this.serviceCompleteProfile = serviceCompleteProfile;
    }
}
