package com.company.springboot.mapper.sys;

import com.company.springboot.base.BaseMapper;
import com.company.springboot.entity.sys.SysCompanyRolePermission;
import com.company.springboot.base.BaseMapper;
import com.company.springboot.entity.sys.SysCompanyRolePermission;
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