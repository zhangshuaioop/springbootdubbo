package com.company.springboot.mapper.atm;

import com.company.springboot.entity.dto.atm.atmCommChargeInvoice.NoChargeListDTO;
import com.company.springboot.entity.ret.atm.atmCommChargeInvoice.DrawListRet;
import com.company.springboot.entity.ret.atm.atmCommChargeInvoice.NoChargeListRet;
import com.company.springboot.entity.atm.AtmCommChargeInvoice;
import com.company.springboot.entity.dto.atm.atmCommChargeInvoice.NoChargeListDTO;
import com.company.springboot.entity.ret.atm.atmCommChargeInvoice.DrawListRet;
import com.company.springboot.entity.ret.atm.atmCommChargeInvoice.NoChargeListRet;
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