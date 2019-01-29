package com.teekee.waterdropservice.mapper.atm;

import com.teekee.waterdropservice.entity.atm.AtmCommPaymentList;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AtmCommPaymentListMapper {

    int insertSelective(AtmCommPaymentList record);

    AtmCommPaymentList selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AtmCommPaymentList record);

}