package com.teekee.waterdropservice.mapper.dmi;

import com.teekee.waterdropservice.entity.dmi.DmiCommProductSpecialLine;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DmiCommProductSpecialLineMapper {

    int insertSelective(DmiCommProductSpecialLine record);

    DmiCommProductSpecialLine selectByPrimaryKey(Integer id);

    DmiCommProductSpecialLine selectByProductId(Integer productId);

    int updateByPrimaryKeySelective(DmiCommProductSpecialLine record);

    int updateByProductIdSelective(DmiCommProductSpecialLine record);

    List<DmiCommProductSpecialLine> selecAlltByProductId(Integer storeCommProductId);
}