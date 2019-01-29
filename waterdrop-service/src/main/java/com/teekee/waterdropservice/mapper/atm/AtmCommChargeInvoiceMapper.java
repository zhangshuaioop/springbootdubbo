package com.teekee.waterdropservice.mapper.atm;

import com.teekee.waterdropservice.entity.atm.AtmCommChargeInvoice;
import com.teekee.waterdropservice.entity.dto.atm.atmCommChargeInvoice.NoChargeListDTO;
import com.teekee.waterdropservice.entity.ret.atm.atmCommChargeInvoice.DrawListRet;
import com.teekee.waterdropservice.entity.ret.atm.atmCommChargeInvoice.NoChargeListRet;
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