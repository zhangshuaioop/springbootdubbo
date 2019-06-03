package com.help.helpme.mapper.sys;

import com.help.helpme.base.BaseMapper;
import com.help.helpme.entity.sys.SysRole;
import com.help.helpme.entity.sys.SysRoleAuthority;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SysRoleAuthorityMapper extends BaseMapper<SysRoleAuthority> {


    /**
     * 批量保存
     * @param sysRoleAuthority
     */
    void saves(SysRoleAuthority sysRoleAuthority);

    /**
     * 根据角色id删除
     * @param roleId
     */
    void deleteByRoleId(Long roleId);
}