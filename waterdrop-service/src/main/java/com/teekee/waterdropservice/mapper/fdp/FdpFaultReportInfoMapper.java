package com.teekee.waterdropservice.mapper.fdp;

import com.teekee.waterdropservice.entity.fdp.FdpFaultReportInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.Map;

@Mapper
public interface FdpFaultReportInfoMapper {

    int insertSelective(FdpFaultReportInfo record);

    FdpFaultReportInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(FdpFaultReportInfo record);

    FdpFaultReportInfo selectByPrimaryNew(Integer id);

    FdpFaultReportInfo selectByPrimaryNewProcess(int id);

    Map selectByProcessId(int id);

    Map selectByPrimaryNewNew(int id);
}