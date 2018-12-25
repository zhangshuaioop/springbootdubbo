package com.platform.springboot.mapper.dmi;

import com.platform.springboot.entity.dmi.DmiCommProductMobile;
import com.platform.springboot.entity.dmi.DmiCommProductMobile;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DmiCommProductMobileMapper {
    int insertSelective(DmiCommProductMobile record);

    DmiCommProductMobile selectByPrimaryKey(Integer id);

    DmiCommProductMobile selectByProductId(Integer productId);

    int updateByPrimaryKeySelective(DmiCommProductMobile record);

    int updateByProductIdSelective(DmiCommProductMobile record);


    List<DmiCommProductMobile> selectAllByProductId(Integer storeCommProductId);
}