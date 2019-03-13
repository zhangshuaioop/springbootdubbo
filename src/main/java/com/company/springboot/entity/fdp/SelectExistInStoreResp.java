package com.company.springboot.entity.fdp;

/**
 * 查询是否存在联系人-返回结果
 *
 * @author Wujun
 * @create 2018年01月08日 16:58
 */
public class SelectExistInStoreResp {
    private int storeId;
    private int companyId;
    private int contactId;

    public int getStoreId() {
        return storeId;
    }

    public void setStoreId(int storeId) {
        this.storeId = storeId;
    }

    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    public int getContactId() {
        return contactId;
    }

    public void setContactId(int contactId) {
        this.contactId = contactId;
    }
}
