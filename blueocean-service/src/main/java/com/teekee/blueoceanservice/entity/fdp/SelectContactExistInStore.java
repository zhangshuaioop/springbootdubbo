package com.teekee.blueoceanservice.entity.fdp;

/**
 * 查询门店中是否存在指定联系人
 *
 * @author Wujun
 * @create 2018年01月08日 16:29
 */
public class SelectContactExistInStore {
    private int contactId;

    private String contactName;

    private String telephone;

    private int storeId;

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public int getStoreId() {
        return storeId;
    }

    public void setStoreId(int storeId) {
        this.storeId = storeId;
    }

    public int getContactId() {
        return contactId;
    }

    public void setContactId(int contactId) {
        this.contactId = contactId;
    }
}
