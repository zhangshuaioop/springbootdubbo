package com.teekee.blueoceanservice.mapper.fdp;

import com.teekee.commoncomponets.base.BaseMapper;
import com.teekee.blueoceanservice.entity.fdp.FdpDispatchRequestHistory;
import com.teekee.blueoceanservice.entity.fdp.FdpDispatchRequestHistoryShow;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author zhanghao
 * @Title: FdpDispatchRequestHistoryMapper
 * @ProjectName BlueOcean
 * @Description: 派工历史记录
 * @date 2019/1/9下午1:30
 */
@Mapper
public interface FdpDispatchRequestHistoryMapper extends BaseMapper<FdpDispatchRequestHistory> {

    int insertSelective(FdpDispatchRequestHistory record);

    FdpDispatchRequestHistory selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(FdpDispatchRequestHistory record);

    /**
     * 根据requestId查询最新版本派工历史
     * @param requestId
     * @return
     * @Author:Niting
     */
    Integer selectMaxVersionByRequestId(Integer requestId);
    /**
     * 查询派工单历史
     * @param requestId
     * @return
     * @Author:Niting
     * @Date:2018/10/16
     */
    List<FdpDispatchRequestHistory> getListByRequestId(int requestId);
    /**
     * 查询派工单历史详情
     * @param id
     * @return
     * @Author:Niting
     * @Date:2018/10/16
     */
    FdpDispatchRequestHistoryShow show(int id);
}
