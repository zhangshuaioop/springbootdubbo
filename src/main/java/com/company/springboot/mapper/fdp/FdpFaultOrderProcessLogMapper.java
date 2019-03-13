package com.company.springboot.mapper.fdp;

import com.company.springboot.entity.fdp.FdpFaultOrderProcessLog;
import com.company.springboot.entity.fdp.FdpFaultOrderProcessLog;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface FdpFaultOrderProcessLogMapper {

    /**
     * 新增故障工单流程日志
     *
     * @param record

     * @author liukan
     * @create 2018年04月25日 10:39
     * @return
     */
    int insertSelective(FdpFaultOrderProcessLog record);

    FdpFaultOrderProcessLog selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(FdpFaultOrderProcessLog record);

    List<FdpFaultOrderProcessLog> getFaultOrderProcess(Integer faultOrderProcessId);

    int insertFaultConfirmbyTheOtherParty(FdpFaultOrderProcessLog record);


}