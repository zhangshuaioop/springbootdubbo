package com.platform.springboot.service.sysconsole;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.platform.springboot.base.BaseService;
import com.platform.springboot.entity.sysconsole.SysConsoleRole;
import com.platform.springboot.mapper.sysconsole.SysConsoleRoleMapper;
import com.platform.springboot.utils.PageInfo;
import com.platform.springboot.utils.Result;
import com.platform.springboot.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @description: 平台角色
 * @author: zhangshuai
 * @create: 2018-12-25 13:50
 */
@Service
public class SysConsoleRoleService extends BaseService<SysConsoleRoleMapper,SysConsoleRole> {

    @Autowired
    private SysConsoleRoleMapper sysConsoleRoleMapper;

    /**
     * 分页角色列表
     * @param sysConsoleRole
     * @return
     */
    public Result findPage(SysConsoleRole sysConsoleRole){

        PageHelper.startPage(sysConsoleRole.getPageNum(), sysConsoleRole.getPageSize());
        Page<SysConsoleRole> persons = sysConsoleRoleMapper.findPage(sysConsoleRole);
        // 需要把Page包装成PageInfo对象才能序列化。该插件也默认实现了一个PageInfo
        PageInfo<SysConsoleRole> pageInfo = new PageInfo<>(persons);
        return ResultUtil.success(pageInfo);
    }

}
