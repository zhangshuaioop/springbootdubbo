package com.teekee.waterdropservice.entity.ret.atm.atmCommChargeInvoice;

import com.teekee.waterdropservice.entity.atm.AtmCommChargeInvoice;
import com.teekee.waterdropservice.entity.dmi.DmiInvoiceModelWithBLOBs;
import com.teekee.waterdropservice.entity.ret.atm.atmCommChargeBill.ShowOverAllRet;
import com.teekee.waterdropservice.entity.ret.atm.atmCommChargeInvoiceCharge.InvoiceChargeListRet;

import java.util.List;

/**
 * 查询发票详情-返回结果
 *
 * @author Wujun
 * @create 2017年09月21日 14:38
 */
public class ShowRet {
    private DmiInvoiceModelWithBLOBs invoiceModel;

    private AtmCommChargeInvoice chargeInvoice;

    private ShowOverAllRet billShowOverAllRet;

    private List<InvoiceChargeListRet> invoiceChargeListRet;

    public List<InvoiceChargeListRet> getInvoiceChargeListRet() {
        return invoiceChargeListRet;
    }

    public void setInvoiceChargeListRet(List<InvoiceChargeListRet> invoiceChargeListRet) {
        this.invoiceChargeListRet = invoiceChargeListRet;
    }

    public ShowOverAllRet getBillShowOverAllRet() {
        return billShowOverAllRet;
    }

    public void setBillShowOverAllRet(ShowOverAllRet billShowOverAllRet) {
        this.billShowOverAllRet = billShowOverAllRet;
    }

    public DmiInvoiceModelWithBLOBs getInvoiceModel() {
        return invoiceModel;
    }

    public void setInvoiceModel(DmiInvoiceModelWithBLOBs invoiceModel) {
        this.invoiceModel = invoiceModel;
    }

    public AtmCommChargeInvoice getChargeInvoice() {
        return chargeInvoice;
    }

    public void setChargeInvoice(AtmCommChargeInvoice chargeInvoice) {
        this.chargeInvoice = chargeInvoice;
    }
}
