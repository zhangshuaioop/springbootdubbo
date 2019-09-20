package com.example.consumer.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.example.componets.service.SysAdminService;
import com.example.componets.utils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description: Dubbo测试
 * @author: zhangshuai
 * @create: 2019-09-18 16:07
 */
@RestController
@RequestMapping("/sysUsers")
@Api(description = "公司用户")
public class DubboController {

    @Reference(version = "1.0.0")
    private SysAdminService sysAdminService;

    @ApiOperation(
            value = "Dubbo测试",
            notes = "Dubbo测试",
            consumes = "application/json",
            responseReference = "com.company.springboot.utils.Result"
    )
    @SuppressWarnings("unchecked")
    @RequestMapping(value = "/getDubbo",method=RequestMethod.GET)
    public Result getDubbo(){
        Result resultInfo=sysAdminService.getDubbo();
        return resultInfo;
    }
}
