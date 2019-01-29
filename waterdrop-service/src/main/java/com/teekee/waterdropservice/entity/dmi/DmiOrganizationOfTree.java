package com.teekee.waterdropservice.entity.dmi;

import java.util.List;

public class DmiOrganizationOfTree extends DmiOrganization {
    private List<DmiOrganizationOfTree> children;
    private boolean hasChildNode;

    private String storeAddr;
    private String storeCode;
    private boolean flagIsStore;

    public String getStoreAddr() {
        return storeAddr;
    }

    public void setStoreAddr(String storeAddr) {
        this.storeAddr = storeAddr;
    }

    public String getStoreCode() {
        return storeCode;
    }

    public void setStoreCode(String storeCode) {
        this.storeCode = storeCode;
    }

    public List<DmiOrganizationOfTree> getChildren() {
        return children;
    }

    public void setChildren(List<DmiOrganizationOfTree> children) {
        this.children = children;
    }

    public boolean isHasChildNode() {
        return hasChildNode;
    }

    public void setHasChildNode(boolean hasChildNode) {
        this.hasChildNode = hasChildNode;
    }

    public boolean isFlagIsStore() {
        return flagIsStore;
    }

    public void setFlagIsStore(boolean flagIsStore) {
        this.flagIsStore = flagIsStore;
    }

    @Override
    public String toString() {
        return "DmiOrganization{" +
                "id=" + super.getId() +
                ", level=" + super.getLevel() +
                ", parentId=" + super.getParentId() +
                '}';
    }

}