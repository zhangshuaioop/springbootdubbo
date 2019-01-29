package com.teekee.blueoceanservice.mapper.sysconsole;

import com.teekee.commoncomponets.base.BaseMapper;
import com.teekee.blueoceanservice.entity.sysconsole.SysConsolePermission;
import com.teekee.blueoceanservice.entity.sysconsole.response.SysConsolePermissionRes;
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