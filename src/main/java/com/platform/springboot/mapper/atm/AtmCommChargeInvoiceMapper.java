package com.platform.springboot.mapper.atm;

import com.platform.springboot.entity.atm.AtmCommChargeInvoice;
import com.platform.springboot.entity.dto.atm.atmCommChargeInvoice.NoChargeListDTO;
import com.platform.springboot.entity.ret.atm.atmCommChargeInvoice.DrawListRet;
import com.platform.springboot.entity.ret.atm.atmCommChargeInvoice.NoChargeListRet;
import com.platform.springboot.entity.atm.AtmCommChargeInvoice;
import com.platform.springboot.entity.dto.atm.atmCommChargeInvoice.NoChargeListDTO;
import com.platform.springboot.entity.ret.atm.atmCommChargeInvoice.DrawListRet;
import com.platform.springboot.entity.ret.atm.atmCommChargeInvoice.NoChargeListRet;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AtmCommChargeInvoiceMapper {

    int insertSelective(AtmCommChargeInvoice record);

    AtmCommChargeInvoice selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AtmCommChargeInvoice record);

    List<DrawListRet> drawList(Integer id);

    List<NoChargeListRet> noChargeList(NoChargeListDTO record);

}