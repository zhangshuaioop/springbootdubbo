package com.platform.springboot.mapper.atm;

import com.platform.springboot.entity.atm.AtmCommChargeBillTempList;
import com.platform.springboot.entity.dmi.DmiCompanyInfo;
import com.platform.springboot.entity.ret.atm.atmCommChargeBillTempList.ShowRet;
import com.platform.springboot.entity.atm.AtmCommChargeBillTempList;
import com.platform.springboot.entity.dmi.DmiCompanyInfo;
import com.platform.springboot.entity.ret.atm.atmCommChargeBillTempList.ShowRet;
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