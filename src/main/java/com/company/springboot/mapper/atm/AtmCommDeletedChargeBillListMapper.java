package com.company.springboot.mapper.atm;

import com.company.springboot.entity.atm.AtmCommDeletedChargeBillList;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AtmCommDeletedChargeBillListMapper {

    int insertSelective(AtmCommDeletedChargeBillList record);

    AtmCommDeletedChargeBillList selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AtmCommDeletedChargeBillList record);

}