package com.company.springboot.mapper.dmi;

import com.company.springboot.entity.dmi.DmiCommProductSpecialLine;
import com.company.springboot.entity.dmi.DmiCommProductSpecialLine;
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