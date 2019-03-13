package com.company.springboot.mapper.atm;

import com.company.springboot.entity.dto.atm.atmCommChargeList.ShouldChargedNotYetListDTO;
import com.company.springboot.entity.ret.atm.atmCommChargeList.ShouldChargedNotYetListRet;
import com.company.springboot.entity.atm.AtmCommChargeList;
import com.company.springboot.entity.atm.AtmCommDeletedChargeBillList;
import com.company.springboot.entity.dto.atm.atmCommChargeList.ShouldChargedNotYetListDTO;
import com.company.springboot.entity.ret.atm.atmCommChargeList.ShouldChargedNotYetListRet;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AtmCommChargeListMapper {

    int insertSelective(AtmCommChargeList record);

    AtmCommChargeList selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AtmCommChargeList record);

    void addAtmCommChargeList(List<AtmCommChargeList> record);

    List<AtmCommChargeList> activeChargeList(AtmCommChargeList record);

    void exitCharge(AtmCommChargeList record);

    AtmCommChargeList earliestChargeOfClosed(AtmCommChargeList record);

    AtmCommChargeList lastChargeOfOpened(AtmCommChargeList record);

    List<ShouldChargedNotYetListRet> shouldChargedNotYetListForProduct(ShouldChargedNotYetListDTO record);

    List<ShouldChargedNotYetListRet> shouldChargedNotYetListForCampaign(ShouldChargedNotYetListDTO record);

    List<ShouldChargedNotYetListRet> shouldChargedNotYetListForComm(ShouldChargedNotYetListDTO record);

    List<AtmCommDeletedChargeBillList> listByChargeBillId(Integer chargeBillId);

    AtmCommChargeList lastChargeTenementPeriodFee(AtmCommChargeList record);

    void updateAccountTotal(AtmCommChargeList record);
    void updateAllAccountTotal(AtmCommChargeList record);

}