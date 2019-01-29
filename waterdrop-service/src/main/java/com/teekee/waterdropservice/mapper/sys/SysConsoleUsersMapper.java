package com.teekee.waterdropservice.mapper.sys;

import com.teekee.commoncomponets.base.BaseMapper;
import com.teekee.waterdropservice.entity.fdp.FdpFaultOrderDispatchRequest;
import com.teekee.waterdropservice.entity.sys.SysConsoleUsers;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SysConsoleUsersMapper extends BaseMapper<SysConsoleUsers> {

    List<SysConsoleUsers> findPersonOpen(FdpFaultOrderDispatchRequest fdpFaultOrderDispatchRequest);
}