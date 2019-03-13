package com.company.springboot.mapper.sys;


import com.company.springboot.base.BaseMapper;
import com.company.springboot.base.BaseMapper;
import com.company.springboot.entity.sys.SysCompanyRole;
import com.company.springboot.entity.sys.response.RedisCompanyPermissionApiRes;
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