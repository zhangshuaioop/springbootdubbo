package com.help.helpme.mapper.sys;

import com.help.helpme.base.BaseMapper;
import com.help.helpme.entity.sys.SysAdminRole;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SysAdminRoleMapper extends BaseMapper<SysAdminRole> {

    /**
     * 批量保存
     * @param sysAdminRole
     */
    void saves(SysAdminRole sysAdminRole);


    /**
     * 删除用户角色
     * @param adminId
     */
    void deleteByAdminId(Long adminId);
}