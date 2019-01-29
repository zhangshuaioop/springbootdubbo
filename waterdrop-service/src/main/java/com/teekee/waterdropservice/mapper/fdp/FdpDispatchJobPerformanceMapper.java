package com.teekee.waterdropservice.mapper.fdp;

import com.teekee.waterdropservice.entity.fdp.FdpDispatchJobPerformance;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface FdpDispatchJobPerformanceMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(FdpDispatchJobPerformance record);

    int insertSelective(FdpDispatchJobPerformance record);

    FdpDispatchJobPerformance selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(FdpDispatchJobPerformance record);

    int updateByPrimaryKey(FdpDispatchJobPerformance record);

    List<FdpDispatchJobPerformance> selectFirstVersionByOrderId(int dispatchOrderId);

    List<FdpDispatchJobPerformance> selectNewVersionByOrderId(int dispatchOrderId);
}