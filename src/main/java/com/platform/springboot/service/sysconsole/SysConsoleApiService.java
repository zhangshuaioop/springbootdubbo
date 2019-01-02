package com.platform.springboot.service.sysconsole;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.platform.springboot.base.BaseService;
import com.platform.springboot.entity.sysconsole.SysConsoleApi;
import com.platform.springboot.mapper.sysconsole.SysConsoleApiMapper;
import com.platform.springboot.utils.PageInfo;
import com.platform.springboot.utils.Result;
import com.platform.springboot.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @description: 平台模式权限接口
 * @author: zhangshuai
 * @create: 2018-12-25 13:43
 */
@Service
public class SysConsoleApiService extends BaseService<SysConsoleApiMapper, SysConsoleApi> {

    @Autowired
    private SysConsoleApiMapper sysConsoleApiMapper;

    /**
     * 分页权限接口列表
     * @param sysConsoleApi
     * @return
     */
    public Result findPage(SysConsoleApi sysConsoleApi){
        PageHelper.startPage(sysConsoleApi.getPageNum(), sysConsoleApi.getPageSize());
        Page<SysConsoleApi> persons = sysConsoleApiMapper.findPage(sysConsoleApi);
        // 需要把Page包装成PageInfo对象才能序列化。该插件也默认实现了一个PageInfo
        PageInfo<SysConsoleApi> pageInfo = new PageInfo<>(persons);
        return ResultUtil.success(pageInfo);
    }

}
