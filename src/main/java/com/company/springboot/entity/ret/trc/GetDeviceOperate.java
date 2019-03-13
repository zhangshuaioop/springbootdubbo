package com.company.springboot.entity.ret.trc;

import com.company.springboot.entity.trc.TrcDeviceOperateLog;

/**
 * @author Wujun
 * @create 2017年11月17日 16:15
 */
public class GetDeviceOperate extends TrcDeviceOperateLog {

    private String optPerson;

    public String getOptPerson() {
        return optPerson;
    }

    public void setOptPerson(String optPerson) {
        this.optPerson = optPerson;
    }
}
