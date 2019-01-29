package com.teekee.waterdropservice.mapper.trc;

import com.teekee.waterdropservice.entity.trc.TrcDeviceOperateLog;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TrcDeviceOperateLogMapper {

    int insertSelective(TrcDeviceOperateLog record);

    TrcDeviceOperateLog selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TrcDeviceOperateLog record);

    List<TrcDeviceOperateLog> selectDeviceOperate(int deviceId);

}