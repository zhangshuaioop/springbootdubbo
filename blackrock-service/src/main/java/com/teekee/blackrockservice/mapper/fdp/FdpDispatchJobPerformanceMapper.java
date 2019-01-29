package com.teekee.blackrockservice.mapper.fdp;

import com.teekee.commoncomponets.base.BaseMapper;
import com.teekee.blackrockservice.entity.fdp.FdpDispatchJobPerformance;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface FdpDispatchJobPerformanceMapper extends BaseMapper<FdpDispatchJobPerformance> {


    List<FdpDispatchJobPerformance> selectFirstVersionByOrderId(int dispatchOrderId);

    List<FdpDispatchJobPerformance> selectNewVersionByOrderId(int dispatchOrderId);

    void updateIsLastByOrderId(Integer dispatchOrderId);

    void updateFinishByOrderId(Integer id);

    int selectVersionByOrderId(Integer id);

    /**
     * 查询已完成工作内容
     * @param reportId
     * @return
     * @Author：Niting
     * @Date:2018/08/07
     */
    List<FdpDispatchJobPerformance> selectJobDescription(Integer reportId);


    /**
     * 查看流程历史记录版本时间点
     * @param orderId
     * @return
     * @Author：Chenliwen
     * @Date:2018/12/24
     */
    List<FdpDispatchJobPerformance> selectHistoryTime(Integer orderId);

    /**
     * 查看流程历史记录
     * @return
     * @Author:Chenliwen
     * @Date:2018/12/24
     */
    List<FdpDispatchJobPerformance> selectHistory(FdpDispatchJobPerformance jobPerformance);
}