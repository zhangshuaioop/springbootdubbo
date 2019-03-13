package com.company.springboot.mapper.atm;

import com.company.springboot.entity.dto.atm.atmCommChargeBill.ChargedBillListDTO;
import com.company.springboot.entity.dto.atm.atmCommChargeBill.NoInvoiceListDTO;
import com.company.springboot.entity.ret.atm.atmCommChargeBill.ChargedBillListRet;
import com.company.springboot.entity.ret.atm.atmCommChargeBill.NoInvoiceListRet;
import com.company.springboot.entity.ret.atm.atmCommChargeBill.ShowBillRet;
import com.company.springboot.entity.ret.atm.atmCommChargeBill.ShowChargeListRet;
import com.company.springboot.entity.atm.AtmCommChargeBill;
import com.company.springboot.entity.dto.atm.atmCommChargeBill.ChargedBillListDTO;
import com.company.springboot.entity.dto.atm.atmCommChargeBill.NoInvoiceListDTO;
import com.company.springboot.entity.ret.atm.atmCommChargeBill.ChargedBillListRet;
import com.company.springboot.entity.ret.atm.atmCommChargeBill.NoInvoiceListRet;
import com.company.springboot.entity.ret.atm.atmCommChargeBill.ShowBillRet;
import com.company.springboot.entity.ret.atm.atmCommChargeBill.ShowChargeListRet;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AtmCommChargeBillMapper {

    int insertSelective(AtmCommChargeBill record);

    AtmCommChargeBill selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AtmCommChargeBill record);

    List<NoInvoiceListRet> noInvoiceListForProduct(NoInvoiceListDTO record);

    List<NoInvoiceListRet> noInvoiceListForCampaign(NoInvoiceListDTO record);

    List<NoInvoiceListRet> noInvoiceListForComm(NoInvoiceListDTO record);

    ShowBillRet showBillRet(Integer id);

    List<ShowChargeListRet> showChargeListRet(Integer id);

    List<ChargedBillListRet> chargedBillListForProduct(ChargedBillListDTO record);

    List<ChargedBillListRet> chargedBillListForCampaign(ChargedBillListDTO record);

    List<ChargedBillListRet> chargedBillListForComm(ChargedBillListDTO record);

}