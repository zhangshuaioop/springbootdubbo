package com.company.springboot.mapper.fdp;

import com.company.springboot.entity.fdp.FdpDispatchJobContent;
import com.company.springboot.entity.fdp.FdpDispatchJobContent;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface FdpDispatchJobContentMapper {

    int insertSelective(FdpDispatchJobContent record);

    FdpDispatchJobContent selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(FdpDispatchJobContent record);
    /**
     * 查询历史工作内容
     * @param id
     * @return
     * @Author:Niting
     * @Date:2018/10/16
     */
    List<FdpDispatchJobContent> selectByHistoryId(Integer id);

    /**
     * 将工单之前的工作内容改为无效
     * @param orderId
     * @return
     * @Author:zhanghao
     * @Date:2018/12/6
     */
    int updateFlagIsLastByFaultOrderId(@Param("dispatchOrderId") int orderId);

    List<FdpDispatchJobContent> seleteByDispatchRequestId(@Param("faultDispatchRequestId") Integer faultDispatchRequestId);
}