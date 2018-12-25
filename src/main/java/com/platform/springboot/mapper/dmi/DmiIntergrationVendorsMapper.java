package com.platform.springboot.mapper.dmi;

import com.platform.springboot.entity.dmi.DmiIntergrationVendors;
import com.platform.springboot.entity.dmi.DmiIntergrationVendors;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DmiIntergrationVendorsMapper {

    int insertSelective(DmiIntergrationVendors record);

    DmiIntergrationVendors selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(DmiIntergrationVendors record);

    List<DmiIntergrationVendors> list();

}