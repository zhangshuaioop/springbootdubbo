package com.company.springboot.mapper.atm;

import com.company.springboot.entity.ret.atm.atmCommChargeInvoiceCharge.InvoiceChargeListRet;
import com.company.springboot.entity.atm.AtmCommChargeInvoiceCharge;
import com.company.springboot.entity.ret.atm.atmCommChargeInvoiceCharge.InvoiceChargeListRet;
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