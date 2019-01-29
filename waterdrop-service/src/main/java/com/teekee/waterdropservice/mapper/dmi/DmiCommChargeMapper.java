package com.teekee.waterdropservice.mapper.dmi;

import com.teekee.waterdropservice.entity.dmi.DmiCommCharge;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DmiCommChargeMapper {

    int insertSelective(DmiCommCharge record);

    DmiCommCharge selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(DmiCommCharge record);

    DmiCommCharge showByObjectId(DmiCommCharge record);

    List<DmiCommCharge> list(DmiCommCharge record);

    List<DmiCommCharge> selectByTimeDimension(DmiCommCharge record);

    DmiCommCharge selectLast(DmiCommCharge record);

}