package com.teekee.waterdropservice.mapper.trc;


import com.teekee.waterdropservice.entity.trc.TrcEmailLog;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TrcEmailLogMapper{

    int insertSelective(TrcEmailLog trcEmailLog);
}