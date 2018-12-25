package com.platform.springboot.mapper.sys;

import com.platform.springboot.base.BaseMapper;
import com.platform.springboot.entity.fdp.FdpFaultOrderDispatchRequest;
import com.platform.springboot.entity.sys.SysCompanyUsers;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SysCompanyUsersMapper extends BaseMapper<SysCompanyUsers> {

    /**
     * 根据用户名查询
     * @param username
     * @return
     */
    SysCompanyUsers selectByUserName(String username);

    List<SysCompanyUsers> findPersonOpen(FdpFaultOrderDispatchRequest fdpFaultOrderDispatchRequest);

    SysCompanyUsers selectVendorIdByCreatePersonId(Integer createPerson);

    String selectVendorName(Integer vendorId);

    List<SysCompanyUsers> selectApplyUser(Integer userId);
}