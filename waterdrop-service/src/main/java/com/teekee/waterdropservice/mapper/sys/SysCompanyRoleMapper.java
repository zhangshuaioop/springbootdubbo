package com.teekee.waterdropservice.mapper.sys;


import com.teekee.commoncomponets.base.BaseMapper;
import com.teekee.waterdropservice.entity.sys.SysCompanyRole;
import com.teekee.waterdropservice.entity.sys.response.RedisCompanyPermissionApiRes;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SysCompanyRoleMapper extends BaseMapper<SysCompanyRole> {

    /**
     * 保存角色返回id
     * @param sysCompanyRole
     */
    void insertGetId(SysCompanyRole sysCompanyRole);

    /**
     * 根据用户id获取公司所有角色列表
     * @param redisCompanyPermissionApiRes
     * @return
     */
    List<SysCompanyRole> selectAllByUserId(RedisCompanyPermissionApiRes redisCompanyPermissionApiRes);
}