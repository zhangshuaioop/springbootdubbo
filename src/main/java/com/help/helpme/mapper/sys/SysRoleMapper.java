package com.help.helpme.mapper.sys;

import com.help.helpme.base.BaseMapper;
import com.help.helpme.entity.sys.SysRole;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SysRoleMapper extends BaseMapper<SysRole> {

    /**
     * 根据用户查询角色
     * @param sysRole
     * @return
     */
    List<SysRole> selectByAdminId(SysRole sysRole);
}