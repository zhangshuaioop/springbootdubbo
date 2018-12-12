package com.lxg.springboot.mapper.sysuser;

import com.lxg.springboot.base.BaseMapper;
import com.lxg.springboot.entity.sysuser.SysUsers;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SysUsersMapper extends BaseMapper<SysUsers> {

    /**
     * 根据用户名查询
     * @param username
     * @return
     */
    SysUsers selectByUserName(String username);
}