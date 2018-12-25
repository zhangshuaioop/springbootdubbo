package com.platform.springboot.mapper.trc;

import com.platform.springboot.entity.trc.TrcDeviceOperateLog;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TrcDeviceOperateLogMapper {

    int insertSelective(TrcDeviceOperateLog record);

    TrcDeviceOperateLog selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TrcDeviceOperateLog record);

    List<TrcDeviceOperateLog> selectDeviceOperate(int deviceId);

}