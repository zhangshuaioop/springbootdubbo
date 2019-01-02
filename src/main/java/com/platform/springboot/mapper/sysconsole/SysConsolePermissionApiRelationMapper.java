package com.platform.springboot.mapper.sysconsole;

import com.platform.springboot.base.BaseMapper;
import com.platform.springboot.entity.sysconsole.SysConsolePermissionApiRelation;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface SysConsolePermissionApiRelationMapper extends BaseMapper<SysConsolePermissionApiRelation> {

    /**
     * 根据权限id删除
     * @param sysConsolePermissionApiRelation
     */
    void deleteByPermissionId(SysConsolePermissionApiRelation sysConsolePermissionApiRelation);

    /**
     * 保存当前权限接口
     * @param permissionId
     * @param apiIds
     */
    void savePermissionApi(@Param("permissionId") Integer permissionId,
                           @Param("apiIds") String[] apiIds);
}