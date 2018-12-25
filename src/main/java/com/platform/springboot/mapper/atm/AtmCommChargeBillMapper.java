package com.platform.springboot.mapper.atm;

import com.platform.springboot.entity.atm.AtmCommChargeBill;
import com.platform.springboot.entity.dto.atm.atmCommChargeBill.ChargedBillListDTO;
import com.platform.springboot.entity.dto.atm.atmCommChargeBill.NoInvoiceListDTO;
import com.platform.springboot.entity.ret.atm.atmCommChargeBill.ChargedBillListRet;
import com.platform.springboot.entity.ret.atm.atmCommChargeBill.NoInvoiceListRet;
import com.platform.springboot.entity.ret.atm.atmCommChargeBill.ShowBillRet;
import com.platform.springboot.entity.ret.atm.atmCommChargeBill.ShowChargeListRet;
import com.platform.springboot.entity.atm.AtmCommChargeBill;
import com.platform.springboot.entity.dto.atm.atmCommChargeBill.ChargedBillListDTO;
import com.platform.springboot.entity.dto.atm.atmCommChargeBill.NoInvoiceListDTO;
import com.platform.springboot.entity.ret.atm.atmCommChargeBill.ChargedBillListRet;
import com.platform.springboot.entity.ret.atm.atmCommChargeBill.NoInvoiceListRet;
import com.platform.springboot.entity.ret.atm.atmCommChargeBill.ShowBillRet;
import com.platform.springboot.entity.ret.atm.atmCommChargeBill.ShowChargeListRet;
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