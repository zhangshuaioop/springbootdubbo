package com.teekee.blueoceanservice.service.sysconsole;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.teekee.commoncomponets.base.BaseService;
import com.teekee.blueoceanservice.entity.sysconsole.SysConsoleApi;
import com.teekee.blueoceanservice.mapper.sysconsole.SysConsoleApiMapper;
import com.teekee.commoncomponets.utils.PageInfo;
import com.teekee.commoncomponets.utils.Result;
import com.teekee.commoncomponets.utils.ResultUtil;
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
