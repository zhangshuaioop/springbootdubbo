package com.company.springboot.mapper.atm;

import com.company.springboot.entity.dmi.DmiCompanyInfo;
import com.company.springboot.entity.ret.atm.atmCommChargeBillTempList.ShowRet;
import com.company.springboot.entity.atm.AtmCommChargeBillTempList;
import com.company.springboot.entity.dmi.DmiCompanyInfo;
import com.company.springboot.entity.ret.atm.atmCommChargeBillTempList.ShowRet;
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