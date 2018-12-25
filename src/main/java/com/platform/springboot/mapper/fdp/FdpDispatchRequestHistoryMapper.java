package com.platform.springboot.mapper.fdp;

import com.platform.springboot.entity.fdp.FdpDispatchRequestHistory;
import com.platform.springboot.entity.fdp.FdpDispatchRequestHistoryShow;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface FdpDispatchRequestHistoryMapper {

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