package com.company.springboot.mapper.fdp;

import com.company.springboot.entity.fdp.FdpDispatchRequestHistory;
import com.company.springboot.entity.fdp.FdpDispatchRequestHistoryShow;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Mapper;

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
    Page<FdpDispatchRequestHistory> getListByRequestId(int requestId);
    /**
     * 查询派工单历史详情
     * @param id
     * @return
     * @Author:Niting
     * @Date:2018/10/16
     */
    FdpDispatchRequestHistoryShow show(int id);
}