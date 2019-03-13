package com.company.springboot.mapper.trc;

import com.company.springboot.entity.trc.TrcDeviceGpsLog;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author zhanghao
 */
@Mapper
public interface TrcDeviceGpsLogMapper{


    /**
     * 根据订单id查询
     * @param orderId
     * @return
     */
    List<TrcDeviceGpsLog> selectByOrderId(@Param("orderId") Integer orderId);


}