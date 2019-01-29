package com.teekee.blackrockservice.mapper.fdp;

import com.teekee.commoncomponets.base.BaseMapper;
import com.teekee.blackrockservice.entity.fdp.*;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface FdpFaultDispatchOrderMapper extends BaseMapper<FdpFaultDispatchOrder>{


    /**
     * 查询该订单的详情
     * @param id
     * @return
     * liukan
     * DATE 2018-7-18
     */
    FdpFaultDispatchOrderInfo selectOrderById(Integer id);

    /**
     * 接单状态数量统计
     * @return
     * @Author:Niting
     * @Date:2018/07/19
     */
    GetDispatchOrderServiceStatusList selectStatusCollect(FdpFaultDispatchOrder order);
    /**
     * 待完工资料查询
     * @return
     * @Author:Niting
     * @Date:2018/07/23
     */
    GetFdpDispatchHrRelationFinishShow queryFinishShow(Integer orderId);
    /**
     * 查询工单详情粗略信息
     * @return
     * @Author:Niting
     * @Date:2018/07/23
     */
    GetFdpDispatchOrderRoughInfoShow orderRoughInfo(Integer orderId);
}
