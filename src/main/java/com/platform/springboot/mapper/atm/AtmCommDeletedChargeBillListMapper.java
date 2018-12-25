package com.platform.springboot.mapper.atm;

import com.platform.springboot.entity.atm.AtmCommDeletedChargeBillList;
import com.platform.springboot.entity.atm.AtmCommDeletedChargeBillList;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AtmCommDeletedChargeBillListMapper {

    int insertSelective(AtmCommDeletedChargeBillList record);

    AtmCommDeletedChargeBillList selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AtmCommDeletedChargeBillList record);

}