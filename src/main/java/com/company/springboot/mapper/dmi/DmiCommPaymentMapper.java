package com.company.springboot.mapper.dmi;

import com.company.springboot.entity.dmi.DmiCommPayment;
import com.company.springboot.entity.dmi.DmiCommPayment;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DmiCommPaymentMapper {

    int insertSelective(DmiCommPayment record);

    DmiCommPayment selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(DmiCommPayment record);

    DmiCommPayment showByObject(DmiCommPayment record);

    List<DmiCommPayment> list(DmiCommPayment record);

    List<DmiCommPayment> selectByTimeDimension(DmiCommPayment record);

    DmiCommPayment selectLast(DmiCommPayment record);

}