package com.teekee.blueoceanservice.mapper.fdp;

import com.teekee.commoncomponets.base.BaseMapper;
import com.teekee.blueoceanservice.entity.fdp.FdpDispatchJobPerformance;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author zhanghao
 * @Title: FdpDispatchJobPerformanceMapper
 * @ProjectName BlueOcean
 * @Description: TODO
 * @date 2018/12/29上午11:15
 */
@Mapper
public interface FdpDispatchJobPerformanceMapper extends BaseMapper<FdpDispatchJobPerformance> {

    int deleteByPrimaryKey(Integer id);

    int insert(FdpDispatchJobPerformance record);

    int insertSelective(FdpDispatchJobPerformance record);

    FdpDispatchJobPerformance selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(FdpDispatchJobPerformance record);

    int updateByPrimaryKey(FdpDispatchJobPerformance record);

    List<FdpDispatchJobPerformance> selectFirstVersionByOrderId(int dispatchOrderId);

    List<FdpDispatchJobPerformance> selectNewVersionByOrderId(int dispatchOrderId);
}
