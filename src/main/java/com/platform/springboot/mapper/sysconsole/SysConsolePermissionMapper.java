package com.platform.springboot.mapper.sysconsole;

import com.platform.springboot.base.BaseMapper;
import com.platform.springboot.entity.sysconsole.SysConsolePermission;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SysConsolePermissionMapper extends BaseMapper<SysConsolePermission> {

    /**
     * 查询平台个人权限
     * @param userId
     * @return
     */
    List<SysConsolePermission> selectPermission(Integer userId);
}