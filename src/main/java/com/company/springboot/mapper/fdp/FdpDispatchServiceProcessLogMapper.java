package com.company.springboot.mapper.fdp;

import com.company.springboot.entity.fdp.FdpDispatchServiceProcessLog;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface FdpDispatchServiceProcessLogMapper {
    /**
     * 查询服务商历史记录
     */
    List<FdpDispatchServiceProcessLog> findList( @Param("dispatchOrderId") Integer dispatchOrderId);

}