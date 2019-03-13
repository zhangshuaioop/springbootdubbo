package com.platform.springboot.mapper.sysconsole;

import com.platform.springboot.base.BaseMapper;
import com.platform.springboot.entity.sysconsole.SysConsolePermission;
import com.platform.springboot.entity.sysconsole.response.SysConsolePermissionRes;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SysConsolePermissionMapper extends BaseMapper<SysConsolePermission> {

    /**
     * 查询平台个人权限
     * @param sysConsolePermission
     * @return
     */
    List<SysConsolePermissionRes> selectPermission(SysConsolePermission sysConsolePermission);


    /**
     * 获取所有权限
     * @param sysConsolePermission
     * @return
     */
    List<SysConsolePermissionRes> selectPermissionAll(SysConsolePermission sysConsolePermission);

}