package com.company.springboot.utils;

import com.company.springboot.entity.cfg.CfgCommunicationTypeCatalog;
import com.company.springboot.entity.cfg.CfgDeviceTypeCatalog;
import com.company.springboot.entity.dmi.DmiOrganization;

import java.util.HashMap;

/**
 * @author Wujun
 * @create 2017年04月25日 11:25
 */
public class TransBean2Map {

    /**
     * 复制Model数据至Map中
     *
     * @param obj
     * @return
     */
    public static HashMap<String, Object> copyObject2Map(Object obj) {
        HashMap<String, Object> map = new HashMap<String, Object>();
        if (obj == null) {
            return map;
        }

        if (obj instanceof DmiOrganization) {
            DmiOrganization dmiOrganization = (DmiOrganization) obj;
            map.put("belongsCompanyId", dmiOrganization.getBelongsCompanyId());
            map.put("businessLicenseId", dmiOrganization.getBusinessLicenseId());
            map.put("id", dmiOrganization.getId());
            map.put("isAvailable", dmiOrganization.getFlagAvailable());
            map.put("isFiliale", dmiOrganization.getFlagFiliale());
            map.put("level", dmiOrganization.getLevel());
            map.put("memo", dmiOrganization.getMemo());
            map.put("orderId", dmiOrganization.getOrderId());
            map.put("organizationCode", dmiOrganization.getOrganizationCode());
            map.put("organizationName", dmiOrganization.getOrganizationName());
            map.put("parentId", dmiOrganization.getParentId());
            return map;
        }

        if (obj instanceof CfgDeviceTypeCatalog) {
            CfgDeviceTypeCatalog cfgDeviceTypeCatalog = (CfgDeviceTypeCatalog) obj;
            map.put("catalog_name", cfgDeviceTypeCatalog.getCatalogName());
            map.put("id", cfgDeviceTypeCatalog.getId());
            map.put("level", cfgDeviceTypeCatalog.getLevel());
            map.put("orderId", cfgDeviceTypeCatalog.getOrderId());
            map.put("description", cfgDeviceTypeCatalog.getDescription());
            map.put("parentId", cfgDeviceTypeCatalog.getParentId());
            return map;
        }

        if (obj instanceof CfgCommunicationTypeCatalog) {
            CfgCommunicationTypeCatalog cfgCommunicationTypeCatalog = (CfgCommunicationTypeCatalog) obj;
            map.put("catalog_name", cfgCommunicationTypeCatalog.getCatalogName());
            map.put("id", cfgCommunicationTypeCatalog.getId());
            map.put("level", cfgCommunicationTypeCatalog.getLevel());
            map.put("orderId", cfgCommunicationTypeCatalog.getOrderId());
            map.put("description", cfgCommunicationTypeCatalog.getDescription());
            map.put("parentId", cfgCommunicationTypeCatalog.getParentId());
        }
        return map;
    }

}
