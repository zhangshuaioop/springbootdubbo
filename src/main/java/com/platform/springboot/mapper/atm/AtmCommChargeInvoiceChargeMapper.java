package com.platform.springboot.mapper.atm;

import com.platform.springboot.entity.atm.AtmCommChargeInvoiceCharge;
import com.platform.springboot.entity.ret.atm.atmCommChargeInvoiceCharge.InvoiceChargeListRet;
import com.platform.springboot.entity.atm.AtmCommChargeInvoiceCharge;
import com.platform.springboot.entity.ret.atm.atmCommChargeInvoiceCharge.InvoiceChargeListRet;
import org.apache.ibatis.annotations.Mapper;

import java.math.BigDecimal;
import java.util.List;

@Mapper
public interface AtmCommChargeInvoiceChargeMapper {

    int insertSelective(AtmCommChargeInvoiceCharge record);

    AtmCommChargeInvoiceCharge selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AtmCommChargeInvoiceCharge record);

    List<InvoiceChargeListRet> invoiceChargeList(Integer invoiceId);

    BigDecimal charge(Integer billId);
}