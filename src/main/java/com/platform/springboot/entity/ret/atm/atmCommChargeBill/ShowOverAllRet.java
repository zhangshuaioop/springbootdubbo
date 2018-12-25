package com.platform.springboot.entity.ret.atm.atmCommChargeBill;

import com.platform.springboot.entity.ret.atm.atmCommChargeInvoice.ShowRet;

import java.util.List;

/**
 * 账单详情（包含收费清单信息）-返回结果
 *
 * @author Wujun
 * @create 2017年09月21日 11:30
 */
public class ShowOverAllRet {

    private ShowBillRet showBillRet;

    private List<ShowChargeListRet> showChargeListRetList;

    private List<ShowRet> invoiceListRet;

    public List<ShowRet> getInvoiceListRet() {
        return invoiceListRet;
    }

    public void setInvoiceListRet(List<ShowRet> invoiceListRet) {
        this.invoiceListRet = invoiceListRet;
    }

    public ShowBillRet getShowBillRet() {
        return showBillRet;
    }

    public void setShowBillRet(ShowBillRet showBillRet) {
        this.showBillRet = showBillRet;
    }

    public List<ShowChargeListRet> getShowChargeListRetList() {
        return showChargeListRetList;
    }

    public void setShowChargeListRetList(List<ShowChargeListRet> showChargeListRetList) {
        this.showChargeListRetList = showChargeListRetList;
    }
}
