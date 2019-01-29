package com.teekee.waterdropservice.entity.dmi;

import java.util.Date;
import java.util.HashMap;

public class DmiInvoiceModelWithBLOBs extends DmiInvoiceModel {

    private String memo;

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo == null ? null : memo.trim();
    }

    public DmiInvoiceModelWithBLOBs() {
    }

    public DmiInvoiceModelWithBLOBs(HashMap<String, Object> map) {
        if (map.containsKey("invoice_account")) setInvoiceAccount(map.get("invoice_account").toString());
        if (map.containsKey("bank_name")) setBankName(map.get("bank_name").toString());
        if (map.containsKey("memo")) setMemo(map.get("memo").toString());
        if (map.containsKey("belong_object_id")) setBelongObjectId(Integer.parseInt(map.get("belong_object_id").toString()));
        if (map.containsKey("company_id")) setBelongObjectType(map.get("belong_object_type").toString());
        if (map.containsKey("contact_name")) setContactName(map.get("contact_name").toString());
        if (map.containsKey("contact_tel")) setContactTel(map.get("contact_tel").toString());
        if (map.containsKey("delivery_address")) setDeliveryAddress(map.get("delivery_address").toString());
        if (map.containsKey("dependence_company_id")) setDependenceCompanyId(Integer.parseInt(map.get("dependence_company_id").toString()));
        if (map.containsKey("invoice_address")) setInvoiceAddress(map.get("invoice_address").toString());
        if (map.containsKey("invoice_type")) setInvoiceType(map.get("invoice_type").toString());
        if (map.containsKey("id")) setId(Integer.parseInt(map.get("id").toString()));
        if (map.containsKey("flag_deleted")) setFlagDeleted(Boolean.parseBoolean(map.get("flag_deleted").toString()));
        if (map.containsKey("invoice_model_name")) setInvoiceModelName(map.get("invoice_model_name").toString());
        if (map.containsKey("invoice_title")) setInvoiceTitle(map.get("invoice_title").toString());
        if (map.containsKey("flag_available")) setFlagAvailable(Boolean.parseBoolean(map.get("flag_available").toString()));
        if (map.containsKey("taxpayer_number")) setTaxpayerNumber(map.get("taxpayer_number").toString());
        if (map.containsKey("update_time")) setUpdateTime((Date) map.get("update_time"));
    }
}