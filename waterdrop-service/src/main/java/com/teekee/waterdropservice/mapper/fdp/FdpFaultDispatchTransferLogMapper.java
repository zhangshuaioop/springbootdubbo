package com.teekee.waterdropservice.mapper.fdp;

import com.teekee.waterdropservice.entity.fdp.FdpFaultDispatchTransferLog;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Mapper
public interface FdpFaultDispatchTransferLogMapper {

    int insertSelective(FdpFaultDispatchTransferLog record);

    FdpFaultDispatchTransferLog selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(FdpFaultDispatchTransferLog record);

    List<FdpFaultDispatchTransferLog> show(Integer dispatchOrderId);

    void insertTransferLog(HashMap mapStransfer);

    void insertDispatchTransferLog(Map mapStransfer);




}