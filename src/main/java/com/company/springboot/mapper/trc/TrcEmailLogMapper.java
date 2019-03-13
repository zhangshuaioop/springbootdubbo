package com.company.springboot.mapper.trc;


import com.company.springboot.entity.trc.TrcEmailLog;
import com.company.springboot.entity.trc.TrcEmailLog;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TrcEmailLogMapper{

    int insertSelective(TrcEmailLog trcEmailLog);
}