package com.platform.springboot.mapper.syscompany;


import com.platform.springboot.base.BaseMapper;
import com.platform.springboot.entity.syscompany.SysCompanyRole;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SysCompanyRoleMapper extends BaseMapper<SysCompanyRole> {

    /**
     * 保存角色返回id
     * @param sysCompanyRole
     */
    void insertGetId(SysCompanyRole sysCompanyRole);
}