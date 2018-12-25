package com.platform.springboot.entity.dmi.ret.dmiCommProductTrunking;

/**
 * 查询通信产品中继-返回结果
 *
 * @author Wujun
 * @create 2017年06月05日 14:19
 */
public class TrunkShowRet {

    private String zipCode;

    private Boolean flagCid;

    private Integer containLines;

    private Integer numberBegin;

    private Integer numberEnd;

    private String displayNumber;

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

    public Integer getContainLines() {
        return containLines;
    }

    public void setContainLines(Integer containLines) {
        this.containLines = containLines;
    }

    public Integer getNumberBegin() {
        return numberBegin;
    }

    public void setNumberBegin(Integer numberBegin) {
        this.numberBegin = numberBegin;
    }

    public Integer getNumberEnd() {
        return numberEnd;
    }

    public void setNumberEnd(Integer numberEnd) {
        this.numberEnd = numberEnd;
    }

    public String getDisplayNumber() {
        return displayNumber;
    }

    public void setDisplayNumber(String displayNumber) {
        this.displayNumber = displayNumber;
    }
}
