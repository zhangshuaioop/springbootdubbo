package com.teekee.waterdropservice.mapper.atm;

import com.teekee.waterdropservice.entity.atm.AtmCommChargeBillTempList;
import com.teekee.waterdropservice.entity.dmi.DmiCompanyInfo;
import com.teekee.waterdropservice.entity.ret.atm.atmCommChargeBillTempList.ShowRet;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AtmCommChargeBillTempListMapper {

    int deleteByPrimaryKey(Integer id);

    int insertSelective(AtmCommChargeBillTempList record);

    AtmCommChargeBillTempList selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AtmCommChargeBillTempList record);

    List<ShowRet> show(String tempBillNumber);

    List<AtmCommChargeBillTempList> selectByBillNumber(String tempBillNumber);

    List<DmiCompanyInfo> selectCompanyCount(List<Integer> list);

    void updateByBillNumAndChargeListId(AtmCommChargeBillTempList record);

}