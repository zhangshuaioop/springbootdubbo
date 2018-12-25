package com.platform.springboot.service.dmi;

import com.platform.springboot.entity.dmi.DmiCommProductBilling;
import com.platform.springboot.entity.dmi.ret.dmiCommProductBilling.BillingShowRet;
import com.platform.springboot.mapper.dmi.DmiCommProductBillingMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @description:
 * @author: zhangshuai
 * @create: 2018-12-17 17:00
 */
@Service
public class DmiCommProductBillingService {

    @Autowired
    private DmiCommProductBillingMapper billingMapper;

    public BillingShowRet show(boolean flagProductBill, int objectId) {
        DmiCommProductBilling bo = new DmiCommProductBilling();
        bo.setFlagProductBill(flagProductBill);
        bo.setObjectId(objectId);
        DmiCommProductBilling sqlResult = billingMapper.show(bo);
        if (sqlResult != null) {
            BillingShowRet result = new BillingShowRet();
            // 账单联系人
            result.setContact(sqlResult.getContact());
            // 账单地址
            result.setAddress(sqlResult.getAddress());
            // 电子账单地址
            result.setEmail(sqlResult.getEmail());
            // 报障联系人
            result.setFailureDealPerson(sqlResult.getFailureDealPerson());
            // 报障联系电话
            result.setFailureDealTel(sqlResult.getFailureDealTel());
            return result;
        } else {
            return null;
        }
    }

}
