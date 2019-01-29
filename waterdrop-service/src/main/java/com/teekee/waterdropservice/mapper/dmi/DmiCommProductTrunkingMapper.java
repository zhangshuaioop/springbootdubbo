package com.teekee.waterdropservice.mapper.dmi;

import com.teekee.waterdropservice.entity.dmi.DmiCommProductTrunking;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DmiCommProductTrunkingMapper {

    int insertSelective(DmiCommProductTrunking record);

    DmiCommProductTrunking selectByPrimaryKey(Integer id);

    DmiCommProductTrunking selectByProductId(Integer productId);

    int updateByPrimaryKeySelective(DmiCommProductTrunking record);

    int updateByProductIdSelective(DmiCommProductTrunking record);

    List<DmiCommProductTrunking> selectAllByProductId(Integer storeCommProductId);
}