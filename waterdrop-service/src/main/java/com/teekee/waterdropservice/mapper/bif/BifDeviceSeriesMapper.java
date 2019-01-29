package com.teekee.waterdropservice.mapper.bif;

import com.teekee.commoncomponets.base.BaseMapper;
import com.teekee.waterdropservice.entity.bif.BifDeviceSeries;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BifDeviceSeriesMapper extends BaseMapper<BifDeviceSeries> {
    int insertSelective(BifDeviceSeries record);

    BifDeviceSeries selectByPrimaryKey(Integer id);

    Page<BifDeviceSeries> selectList(Integer modelId);

    int updateByPrimaryKeySelective(BifDeviceSeries record);
}