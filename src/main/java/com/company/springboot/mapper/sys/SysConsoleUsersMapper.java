package com.company.springboot.mapper.sys;

import com.company.springboot.base.BaseMapper;
import com.company.springboot.entity.fdp.FdpFaultOrderDispatchRequest;
import com.company.springboot.entity.sys.SysConsoleUsers;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SysConsoleUsersMapper extends BaseMapper<SysConsoleUsers> {

    List<SysConsoleUsers> findPersonOpen(FdpFaultOrderDispatchRequest fdpFaultOrderDispatchRequest);
}