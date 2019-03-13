package com.company.springboot.entity.dmi.ret.dmiCommProductStraightLine;

/**
 * 查询通信产品专线-返回结果
 *
 * @author Wujun
 * @create 2017年06月05日 13:53
 */
public class StraightLineRet {

    private String zipCode;

    private Boolean flagCid;

    private Boolean flagIpPhone;

    private Boolean flagDdd;

    private Boolean flagIdd;

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public Boolean getFlagCid() {
        return flagCid;
    }

    public void setFlagCid(Boolean flagCid) {
        this.flagCid = flagCid;
    }

    public Boolean getFlagIpPhone() {
        return flagIpPhone;
    }

    public void setFlagIpPhone(Boolean flagIpPhone) {
        this.flagIpPhone = flagIpPhone;
    }

    public Boolean getFlagDdd() {
        return flagDdd;
    }

    public void setFlagDdd(Boolean flagDdd) {
        this.flagDdd = flagDdd;
    }

    public Boolean getFlagIdd() {
        return flagIdd;
    }

    public void setFlagIdd(Boolean flagIdd) {
        this.flagIdd = flagIdd;
    }

}
