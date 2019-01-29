package com.teekee.blueoceanservice.mapper.sysconsole;

import com.teekee.commoncomponets.base.BaseMapper;
import com.teekee.blueoceanservice.entity.syscompany.response.RedisCompanyPermissionApiRes;
import com.teekee.blueoceanservice.entity.sysconsole.SysConsoleRole;
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