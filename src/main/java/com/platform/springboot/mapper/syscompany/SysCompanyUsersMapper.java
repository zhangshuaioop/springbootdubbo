package com.platform.springboot.mapper.syscompany;

import com.github.pagehelper.Page;
import com.platform.springboot.base.BaseMapper;
import com.platform.springboot.entity.syscompany.SysCompanyUsers;
import com.platform.springboot.entity.syscompany.response.SysCompanyUsersAdminRes;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface SysCompanyUsersMapper extends BaseMapper<SysCompanyUsers> {

    /**
     * 根据用户名查询
     * @param username
     * @return
     */
    SysCompanyUsers selectByUserName(String username);


    SysCompanyUsers selectVendorIdByCreatePersonId(Integer createPerson);

    String selectVendorName(Integer vendorId);

    List<SysCompanyUsers> selectApplyUser(Integer userId);

    /**
     * 平台查看公司用户
     * @param sysCompanyUsers
     * @return
     */
    Page<SysCompanyUsers> findPageConsole(SysCompanyUsers sysCompanyUsers);

    /**
     * 获取公司超级管理员账号
     * @param companyId
     * @return
     */
    SysCompanyUsersAdminRes selectByAdmin(Integer companyId);
}