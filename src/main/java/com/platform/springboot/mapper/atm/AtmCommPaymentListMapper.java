package com.platform.springboot.mapper.atm;

import com.platform.springboot.entity.atm.AtmCommPaymentList;
import com.platform.springboot.entity.atm.AtmCommPaymentList;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AtmCommPaymentListMapper {

    int insertSelective(AtmCommPaymentList record);

    AtmCommPaymentList selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AtmCommPaymentList record);

}