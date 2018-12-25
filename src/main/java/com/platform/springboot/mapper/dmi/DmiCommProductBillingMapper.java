package com.platform.springboot.mapper.dmi;

import com.platform.springboot.entity.dmi.DmiCommProductBilling;
import com.platform.springboot.entity.dmi.DmiCommProductBilling;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DmiCommProductBillingMapper {

    int insertSelective(DmiCommProductBilling record);

    DmiCommProductBilling selectByPrimaryKey(Integer id);

    DmiCommProductBilling show(DmiCommProductBilling record);

    int updateByPrimaryKeySelective(DmiCommProductBilling record);

    int updateByObjectId(DmiCommProductBilling record);

}