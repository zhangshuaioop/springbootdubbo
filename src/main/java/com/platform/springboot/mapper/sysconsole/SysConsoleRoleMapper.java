package com.platform.springboot.mapper.sysconsole;

import com.platform.springboot.base.BaseMapper;
import com.platform.springboot.entity.syscompany.response.RedisCompanyPermissionApiRes;
import com.platform.springboot.entity.sysconsole.SysConsoleRole;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SysConsoleRoleMapper extends BaseMapper<SysConsoleRole> {

    /**
     * 根据用户id获取公司所有角色列表
     * @param redisCompanyPermissionApiRes
     * @return
     */
    List<SysConsoleRole> selectAllByUserId(RedisCompanyPermissionApiRes redisCompanyPermissionApiRes);
}