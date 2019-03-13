package com.company.springboot.entity.dmi;

import java.util.List;

/**
 * @author Wujun
 * @create 2017年12月08日 11:13
 */
public class DmiDeviceAssignWithList {
    private List<DmiDeviceAssign> deviceAssignList;

    public List<DmiDeviceAssign> getDeviceAssignList() {
        return deviceAssignList;
    }

    public void setDeviceAssignList(List<DmiDeviceAssign> deviceAssignList) {
        this.deviceAssignList = deviceAssignList;
    }
}
