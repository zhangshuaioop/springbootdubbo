package com.platform.springboot.mapper.bif;

import com.platform.springboot.entity.bif.BifDispatchHrNegativeLog;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BifDispatchHrNegativeLogMapper {

    int insertSelective(BifDispatchHrNegativeLog record);

    BifDispatchHrNegativeLog selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(BifDispatchHrNegativeLog record);

    BifDispatchHrNegativeLog selectByHrid(Integer hrId);

}