package com.company.springboot.entity.dmi.ret.dmiCommPayment;

import com.company.springboot.entity.dmi.DmiCommMarketingCampaignReturn;
import com.company.springboot.entity.dmi.DmiCommPayment;
import com.company.springboot.entity.dmi.DmiCommMarketingCampaignReturn;
import com.company.springboot.entity.dmi.DmiCommPayment;

/**
 * 通信资源付费-返回信息
 *
 * @author Wujun
 * @create 2017年08月30日 10:57
 */
public class PaymentShowRet {
    private DmiCommPayment paymentInfo;

    private DmiCommMarketingCampaignReturn returnInfo;

    public DmiCommPayment getPaymentInfo() {
        return paymentInfo;
    }

    public void setPaymentInfo(DmiCommPayment paymentInfo) {
        this.paymentInfo = paymentInfo;
    }

    public DmiCommMarketingCampaignReturn getReturnInfo() {
        return returnInfo;
    }

    public void setReturnInfo(DmiCommMarketingCampaignReturn returnInfo) {
        this.returnInfo = returnInfo;
    }
}
