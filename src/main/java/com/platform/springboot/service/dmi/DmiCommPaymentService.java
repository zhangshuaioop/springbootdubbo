package com.platform.springboot.service.dmi;

import com.platform.springboot.entity.dmi.DmiCommPayment;
import com.platform.springboot.entity.dmi.ret.dmiCommPayment.PaymentShowRet;
import com.platform.springboot.mapper.dmi.DmiCommMarketingCampaignReturnMapper;
import com.platform.springboot.mapper.dmi.DmiCommPaymentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * @description:
 * @author: zhangshuai
 * @create: 2018-12-17 16:33
 */
@Service
public class DmiCommPaymentService {


    @Autowired
    private DmiCommPaymentMapper mapper;
    @Autowired
    private DmiCommMarketingCampaignReturnMapper returnMapper;

    public PaymentShowRet showByObject(int objectId, String objectType) {
        PaymentShowRet result = new PaymentShowRet();

        // 付费信息
        DmiCommPayment record = new DmiCommPayment();
        record.setObjectId(objectId);
        record.setObjectType(objectType);
        DmiCommPayment payment = mapper.showByObject(record);
        result.setPaymentInfo(payment);

        // 返还信息
        if ("CAMPAIGN".equals(objectType) && payment != null) {
            result.setReturnInfo(returnMapper.showByContractId(payment.getId()));
        }

        return result;
    }
}
