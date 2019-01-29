package com.teekee.waterdropservice.mapper.bif;

import com.teekee.commoncomponets.base.BaseMapper;
import com.teekee.waterdropservice.entity.bif.BifDeviceModel;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BifDeviceModelMapper extends BaseMapper<BifDeviceModel> {
    int insertSelective(BifDeviceModel record);

    BifDeviceModel selectByPrimaryKey(Integer id);

    Page<BifDeviceModel> selectList(Integer seriesId);

    int updateByPrimaryKeySelective(BifDeviceModel record);

    int invalidBySeries(BifDeviceModel record);
}