package com.teekee.waterdropservice.mapper.atm;

import com.teekee.waterdropservice.entity.atm.AtmCommChargeList;
import com.teekee.waterdropservice.entity.atm.AtmCommDeletedChargeBillList;
import com.teekee.waterdropservice.entity.dto.atm.atmCommChargeList.ShouldChargedNotYetListDTO;
import com.teekee.waterdropservice.entity.ret.atm.atmCommChargeList.ShouldChargedNotYetListRet;
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