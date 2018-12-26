package com.platform.springboot.service.sysconsole;

import com.platform.springboot.base.BaseService;
import com.platform.springboot.entity.sysconsole.SysConsolePermission;
import com.platform.springboot.mapper.sysconsole.SysConsolePermissionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @description: 平台模式权限功能
 * @author: zhangshuai
 * @create: 2018-12-25 13:46
 */
@Service
public class SysConsolePermissionService extends BaseService<SysConsolePermissionMapper,SysConsolePermission> {

    @Autowired
    private SysConsolePermissionMapper sysConsolePermissionMapper;

    /**
     * 查询平台个人权限
     * @param userId
     * @return
     */
    public List<SysConsolePermission> findPermission(Integer userId){
        return sysConsolePermissionMapper.selectPermission(userId);
    }
}
