package com.teekee.blackrockservice.mapper.fdp;

import com.teekee.commoncomponets.base.BaseMapper;
import com.teekee.blackrockservice.entity.fdp.FdpDispatchCompleteProfileLog;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface FdpDispatchCompleteProfileLogMapper extends BaseMapper<FdpDispatchCompleteProfileLog> {
    int deleteByPrimaryKey(Integer id);

    int insert(FdpDispatchCompleteProfileLog record);

    int insertSelective(FdpDispatchCompleteProfileLog record);

    FdpDispatchCompleteProfileLog selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(FdpDispatchCompleteProfileLog record);

    int updateByPrimaryKey(FdpDispatchCompleteProfileLog record);


}