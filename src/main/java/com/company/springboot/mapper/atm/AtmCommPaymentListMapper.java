package com.company.springboot.mapper.atm;

import com.company.springboot.entity.atm.AtmCommPaymentList;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AtmCommPaymentListMapper {

    int insertSelective(AtmCommPaymentList record);

    AtmCommPaymentList selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AtmCommPaymentList record);

}