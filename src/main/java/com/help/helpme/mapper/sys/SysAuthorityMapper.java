package com.help.helpme.mapper.sys;

import com.help.helpme.base.BaseMapper;
import com.help.helpme.entity.sys.SysAuthority;
import com.help.helpme.entity.sys.SysRole;
import com.help.helpme.entity.sys.response.SysAuthorityRes;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SysAuthorityMapper extends BaseMapper<SysAuthority> {

    /**
     * 根据用户获取权限
     * @param adminId
     * @return
     */
    List<SysAuthorityRes>  selectByAdminId(Long adminId);

    /**
     * 系统权限列表
     * @return
     */
    List<SysAuthorityRes> selectAllTree(SysAuthority sysAuthority);


    /**
     * 根据角色获取系统权限列表
     * @param sysAuthority
     * @return
     */
    List<SysAuthorityRes> selectByRoleIdTree(SysAuthority sysAuthority);
}