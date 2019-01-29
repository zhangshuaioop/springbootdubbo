package com.teekee.waterdropservice.mapper.atm;

import com.teekee.waterdropservice.entity.atm.AtmCommDeletedChargeBillList;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AtmCommDeletedChargeBillListMapper {

    int insertSelective(AtmCommDeletedChargeBillList record);

    AtmCommDeletedChargeBillList selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AtmCommDeletedChargeBillList record);

}