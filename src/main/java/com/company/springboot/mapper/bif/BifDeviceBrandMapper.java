package com.company.springboot.mapper.bif;

import com.github.pagehelper.Page;
import com.company.springboot.base.BaseMapper;
import com.company.springboot.entity.bif.BifDeviceBrand;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BifDeviceBrandMapper extends BaseMapper<BifDeviceBrand> {

    int insertSelective(BifDeviceBrand record);

    BifDeviceBrand selectByPrimaryKey(Integer id);

    Page<BifDeviceBrand> selectList(BifDeviceBrand bifDeviceBrand);

    int updateByPrimaryKeySelective(BifDeviceBrand record);
}