package com.example.identification.mapper.sys;

import com.example.identification.base.BaseMapper;
import com.example.identification.entity.sys.SysUsersAccount;
import org.apache.ibatis.annotations.Mapper;

/**
 * 平台用户账号表
 */
@Mapper
public interface SysUsersAccountMapper extends BaseMapper<SysUsersAccount> {

    /**
     * 根据用户名查询用户信息
     * @param sysUsersAccount
     * @return
     */
    SysUsersAccount selectByUserName(SysUsersAccount sysUsersAccount);
}