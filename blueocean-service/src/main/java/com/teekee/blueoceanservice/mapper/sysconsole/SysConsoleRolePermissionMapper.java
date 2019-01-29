package com.teekee.blueoceanservice.mapper.sysconsole;

import com.teekee.commoncomponets.base.BaseMapper;
import com.teekee.blueoceanservice.entity.sysconsole.SysConsoleRolePermission;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface SysConsoleRolePermissionMapper extends BaseMapper<SysConsoleRolePermission> {

    /**
     * 根据角色删除
     * @param sysConsoleRolePermission
     */
    void deleteByRoleId(SysConsoleRolePermission sysConsoleRolePermission);

    /**
     * 角色保存权限
     * @param roleId
     * @param createPerson
     * @param permissionIds
     */
    void saveRolePermission(@Param("roleId") Integer roleId,
                            @Param("createPerson") Integer createPerson,
                            @Param("permissionIds") String[] permissionIds);
}