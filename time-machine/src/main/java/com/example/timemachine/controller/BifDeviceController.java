package com.example.timemachine.controller;

import com.example.timemachine.entity.BifDevice;
import com.example.timemachine.service.BifDeviceService;
import com.example.timemachine.utils.PageInfo;
import com.example.timemachine.utils.Result;
import com.example.timemachine.utils.ResultUtil;
import com.github.pagehelper.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * @description: 设备基本信息服务
 * @author: zhangshuai
 * @create: 2018-10-25 14:49
 */
@Api(value = "BifDeviceController", tags = "bifDevice-service")
@RestController
@RequestMapping(value = "/bifDevice")
public class BifDeviceController {

    private final Logger logger = Logger.getLogger(getClass());

    @Autowired
    private BifDeviceService bifDeviceService;

    @ApiOperation(
            value = "分页查询",
            notes = "分页查询",
            consumes = "application/json",
            responseReference = "com.example.timemachine.utils.Result"
    )
    @SuppressWarnings("unchecked")
    @PostMapping(value = "/findPage")
    public Result findPage(@RequestBody BifDevice bifDevice) {

        Page<BifDevice> persons = bifDeviceService.findPage(bifDevice);
        // 需要把Page包装成PageInfo对象才能序列化。该插件也默认实现了一个PageInfo
        PageInfo<BifDevice> pageInfo = new PageInfo<>(persons);

        return ResultUtil.success(pageInfo);
    }



}
