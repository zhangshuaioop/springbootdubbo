package com.company.springboot.mapper.bif;

import com.github.pagehelper.Page;
import com.company.springboot.base.BaseMapper;
import com.company.springboot.entity.bif.BifDeviceModel;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BifDeviceModelMapper extends BaseMapper<BifDeviceModel> {
    int insertSelective(BifDeviceModel record);

    BifDeviceModel selectByPrimaryKey(Integer id);

    Page<BifDeviceModel> selectList(Integer seriesId);

    int updateByPrimaryKeySelective(BifDeviceModel record);

    int invalidBySeries(BifDeviceModel record);
}