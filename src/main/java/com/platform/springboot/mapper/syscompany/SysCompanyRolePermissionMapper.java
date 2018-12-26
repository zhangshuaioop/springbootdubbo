package com.platform.springboot.mapper.syscompany;

import com.platform.springboot.base.BaseMapper;
import com.platform.springboot.entity.syscompany.SysCompanyRolePermission;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface SysCompanyRolePermissionMapper extends BaseMapper<SysCompanyRolePermission> {

    /**
     * 保存权限
     * @param roleId
     * @param companyId
     * @param createPerson
     * @param updatePerson
     * @param permissionIds
     */
    void saveRoleAuthority(@Param("roleId") Integer roleId,@Param("companyId") Integer companyId,
                           @Param("createPerson") Integer createPerson,
                           @Param("updatePerson") Integer updatePerson,
                           @Param("permissionIds") String[] permissionIds);

    /**
     * 删除权限
     * @param sysCompanyRolePermission
     */
    void deleteByRoleAndCompanyId(SysCompanyRolePermission sysCompanyRolePermission);
}