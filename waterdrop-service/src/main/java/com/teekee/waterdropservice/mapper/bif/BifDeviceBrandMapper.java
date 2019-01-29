package com.teekee.waterdropservice.mapper.bif;

import com.teekee.commoncomponets.base.BaseMapper;
import com.teekee.waterdropservice.entity.bif.BifDeviceBrand;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BifDeviceBrandMapper extends BaseMapper<BifDeviceBrand> {

    int insertSelective(BifDeviceBrand record);

    BifDeviceBrand selectByPrimaryKey(Integer id);

    Page<BifDeviceBrand> selectList(BifDeviceBrand bifDeviceBrand);

    int updateByPrimaryKeySelective(BifDeviceBrand record);
}