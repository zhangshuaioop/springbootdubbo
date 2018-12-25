package com.platform.springboot.mapper.trc;


import com.platform.springboot.entity.trc.TrcEmailLog;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TrcEmailLogMapper{

    int insertSelective(TrcEmailLog trcEmailLog);
}