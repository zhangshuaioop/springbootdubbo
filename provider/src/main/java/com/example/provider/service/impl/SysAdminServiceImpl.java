package com.example.provider.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.example.componets.service.SysAdminService;
import com.example.componets.utils.Result;
import com.example.componets.utils.ResultUtil;

/**
 * @description: RPC调用业务逻辑处理
 * @author: zhangshuai
 * @create: 2019-09-18 16:05
 */
@Service(version = "1.0.0")
public class SysAdminServiceImpl implements SysAdminService {


    @Override
    public Result getDubbo() {
        return ResultUtil.success("RPC调用业务成功");
    }
}
