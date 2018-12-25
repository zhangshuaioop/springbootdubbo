package com.platform.springboot.mapper.bif;

import com.github.pagehelper.Page;
import com.platform.springboot.base.BaseMapper;
import com.platform.springboot.entity.bif.BifDeviceModel;
import com.platform.springboot.base.BaseMapper;
import com.platform.springboot.entity.bif.BifDeviceModel;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BifDeviceModelMapper extends BaseMapper<BifDeviceModel> {
    int insertSelective(BifDeviceModel record);

    BifDeviceModel selectByPrimaryKey(Integer id);

    Page<BifDeviceModel> selectList(Integer seriesId);

    int updateByPrimaryKeySelective(BifDeviceModel record);

    int invalidBySeries(BifDeviceModel record);
}