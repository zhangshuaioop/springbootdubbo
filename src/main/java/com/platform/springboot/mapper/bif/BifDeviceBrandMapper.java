package com.platform.springboot.mapper.bif;

import com.github.pagehelper.Page;
import com.platform.springboot.base.BaseMapper;
import com.platform.springboot.entity.bif.BifDeviceBrand;
import com.platform.springboot.base.BaseMapper;
import com.platform.springboot.entity.bif.BifDeviceBrand;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BifDeviceBrandMapper extends BaseMapper<BifDeviceBrand> {

    int insertSelective(BifDeviceBrand record);

    BifDeviceBrand selectByPrimaryKey(Integer id);

    Page<BifDeviceBrand> selectList(BifDeviceBrand bifDeviceBrand);

    int updateByPrimaryKeySelective(BifDeviceBrand record);
}