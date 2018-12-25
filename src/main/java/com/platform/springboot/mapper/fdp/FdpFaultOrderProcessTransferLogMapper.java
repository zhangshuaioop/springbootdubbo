package com.platform.springboot.mapper.fdp;

import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;

@Mapper
public interface FdpFaultOrderProcessTransferLogMapper {


    void insertTransferLog(HashMap<String, Object> map);
}
