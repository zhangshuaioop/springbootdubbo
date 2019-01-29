package com.teekee.blueoceanservice.mapper.bif;

import com.teekee.blueoceanservice.entity.bif.BifDispatchHrNegativeLog;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BifDispatchHrNegativeLogMapper {

    int insertSelective(BifDispatchHrNegativeLog record);

    BifDispatchHrNegativeLog selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(BifDispatchHrNegativeLog record);

    BifDispatchHrNegativeLog selectByHrid(Integer hrId);

}