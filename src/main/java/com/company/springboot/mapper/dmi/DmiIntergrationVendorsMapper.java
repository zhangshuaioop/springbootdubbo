package com.company.springboot.mapper.dmi;

import com.company.springboot.entity.dmi.DmiIntergrationVendors;
import com.company.springboot.entity.dmi.DmiIntergrationVendors;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DmiIntergrationVendorsMapper {

    int insertSelective(DmiIntergrationVendors record);

    DmiIntergrationVendors selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(DmiIntergrationVendors record);

    List<DmiIntergrationVendors> list();

}