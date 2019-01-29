package com.teekee.blueoceanservice.mapper.syscompany;


import com.teekee.commoncomponets.base.BaseMapper;
import com.teekee.blueoceanservice.entity.syscompany.SysCompanyRole;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SysCompanyRoleMapper extends BaseMapper<SysCompanyRole> {

    /**
     * 保存角色返回id
     * @param sysCompanyRole
     */
    void insertGetId(SysCompanyRole sysCompanyRole);
}