package com.company.springboot.entity.fdp;

import com.company.springboot.entity.dmi.*;
import com.company.springboot.entity.dmi.*;

import java.util.List;

public class FdpFaultOrderRelatedCommProductList {



    private List<DmiCommProductBroadbandWithBLOBs> broadbandList;

    private List<DmiCommProductMobile> mobileList;

    private List<DmiCommProductTrunking> trunkingList;

    private List<DmiCommProductStraightLine> straightLineList;

    private List<DmiCommProductSpecialLine> specialLineList;

    public List<DmiCommProductBroadbandWithBLOBs> getBroadbandList() {
        return broadbandList;
    }

    public void setBroadbandList(List<DmiCommProductBroadbandWithBLOBs> broadbandList) {
        this.broadbandList = broadbandList;
    }

    public List<DmiCommProductMobile> getMobileList() {
        return mobileList;
    }

    public void setMobileList(List<DmiCommProductMobile> mobileList) {
        this.mobileList = mobileList;
    }

    public List<DmiCommProductTrunking> getTrunkingList() {
        return trunkingList;
    }

    public void setTrunkingList(List<DmiCommProductTrunking> trunkingList) {
        this.trunkingList = trunkingList;
    }

    public List<DmiCommProductStraightLine> getStraightLineList() {
        return straightLineList;
    }

    public void setStraightLineList(List<DmiCommProductStraightLine> straightLineList) {
        this.straightLineList = straightLineList;
    }

    public List<DmiCommProductSpecialLine> getSpecialLineList() {
        return specialLineList;
    }

    public void setSpecialLineList(List<DmiCommProductSpecialLine> specialLineList) {
        this.specialLineList = specialLineList;
    }
}
