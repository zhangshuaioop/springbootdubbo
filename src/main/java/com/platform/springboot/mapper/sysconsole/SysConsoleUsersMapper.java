package com.platform.springboot.mapper.sysconsole;

import com.platform.springboot.base.BaseMapper;
import com.platform.springboot.entity.sysconsole.SysConsoleUsers;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SysConsoleUsersMapper extends BaseMapper<SysConsoleUsers> {

    /**
     * 根据用户名查询用户信息
     * @param username
     * @return
     */
    SysConsoleUsers selectByUserName(String username);
}