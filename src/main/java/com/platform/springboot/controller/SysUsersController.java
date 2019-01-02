package com.platform.springboot.controller;

import com.platform.springboot.entity.sysconsole.SysConsoleUserRoleRelation;
import com.platform.springboot.entity.sysconsole.SysConsoleUsers;
import com.platform.springboot.service.sysconsole.SysConsoleUsersService;
import com.platform.springboot.utils.Result;
import com.platform.springboot.utils.ResultUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @description:平台用户账号
 * @author: zhangshuai
 * @create: 2018-12-13 13:55
 */
@RestController
@RequestMapping("/sysUsers")
@Api(description = "平台用户")
public class SysUsersController {

    private final Logger logger = Logger.getLogger(getClass());

    @Autowired
    private SysConsoleUsersService sysConsoleUsersService;


    @ApiOperation(
            value = "分页账号列表",
            notes = "分页账号列表",
            consumes = "application/json",
            responseReference = "com.platform.springboot.utils.Result"
    )
    @SuppressWarnings("unchecked")
    @RequestMapping(value = "/findUsers",method=RequestMethod.POST)
    public Result findUsers(@RequestBody SysConsoleUsers sysConsoleUsers) {

        logger.info("分页账号列表开始,入参:sysConsoleUsers="+sysConsoleUsers.toString());
        Result result = sysConsoleUsersService.findPage(sysConsoleUsers);
        logger.info("分页账号列表结束,出参:"+result.toString());
        return result;
    }



    @ApiOperation(
            value = "账号列表详情",
            notes = "账号列表详情",
            consumes = "application/json",
            responseReference = "com.platform.springboot.utils.Result"
    )
    @SuppressWarnings("unchecked")
    @RequestMapping(value = "/findUsersDetails",method=RequestMethod.GET)
    public Result findUsersDetails(@RequestParam Integer id) {

        logger.info("账号列表详情开始,入参:id="+id);
        Result result = ResultUtil.success(sysConsoleUsersService.get(id));
        logger.info("账号列表详情结束,出参:"+result.toString());
        return result;
    }


    @ApiOperation(
            value = "账号保存/修改",
            notes = "账号保存/修改",
            consumes = "application/json",
            responseReference = "com.platform.springboot.utils.Result"
    )
    @SuppressWarnings("unchecked")
    @RequestMapping(value = "/saveOrUpdateUsers",method=RequestMethod.POST)
    public Result saveOrUpdateUsers(@RequestBody SysConsoleUsers sysConsoleUsers) {

        logger.info("账号保存/修改开始,入参:sysConsoleUsers="+sysConsoleUsers.toString());
        Result result = ResultUtil.success(sysConsoleUsersService.saveOrUpdateUsers(sysConsoleUsers));
        logger.info("账号保存/修改结束,出参:"+result.toString());
        return result;
    }



    @ApiOperation(
            value = "赋予账号角色",
            notes = "赋予账号角色",
            consumes = "application/json",
            responseReference = "com.platform.springboot.utils.Result"
    )
    @SuppressWarnings("unchecked")
    @RequestMapping(value = "/updateUserRole",method=RequestMethod.POST)
    public Result updateUserRole(@RequestBody SysConsoleUserRoleRelation sysConsoleUserRoleRelation) {

        logger.info("赋予账号角色开始,入参:sysConsoleUserRoleRelation="+sysConsoleUserRoleRelation.toString());
        Result result = sysConsoleUsersService.updateUserRole(sysConsoleUserRoleRelation);
        logger.info("赋予账号角色结束,出参:"+result.toString());
        return result;
    }

}
