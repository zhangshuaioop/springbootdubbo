package com.platform.springboot.controller;

import com.platform.springboot.controller.sysconsole.request.SysConsoleUserPassword;
import com.platform.springboot.entity.sysconsole.SysConsoleUserRoleRelation;
import com.platform.springboot.entity.sysconsole.SysConsoleUsers;
import com.platform.springboot.service.sysconsole.SysConsolePermissionService;
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

    @Autowired
    private SysConsolePermissionService sysConsolePermissionService;

    @ApiOperation(
            value = "当前权限及相关信息",
            notes = "当前权限及相关信息",
            consumes = "application/json",
            responseReference = "com.company.springboot.utils.Result"
    )
    @SuppressWarnings("unchecked")
    @RequestMapping(value = "/getUserPermission",method=RequestMethod.GET)
    public Result getUserPermission() {

        logger.info("当前权限及相关信息开始,入参:无");
        Result result = sysConsolePermissionService.findUserView();
        logger.info("当前权限及相关信息结束,出参:result="+result.toString());

        return result;
    }

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


    @ApiOperation(
            value = "修改平台密码",
            notes = "修改平台密码",
            consumes = "application/json",
            responseReference = "com.company.springboot.utils.Result"
    )
    @SuppressWarnings("unchecked")
    @RequestMapping(value = "/updatePassword",method=RequestMethod.POST)
    public Result updatePassword(@RequestBody SysConsoleUserPassword sysConsoleUserPassword) {

        logger.info("修改平台密码开始,入参:sysConsoleUserPassword="+sysConsoleUserPassword.toString());
        Result result = sysConsoleUsersService.updatePassword(sysConsoleUserPassword);
        logger.info("修改平台密码结束,出参:"+result.toString());
        return result;
    }


    @ApiOperation(
            value = "重置平台密码",
            notes = "重置平台密码",
            consumes = "application/json",
            responseReference = "com.company.springboot.utils.Result"
    )
    @SuppressWarnings("unchecked")
    @RequestMapping(value = "/resetPassword",method=RequestMethod.GET)
    public Result resetPassword(@RequestParam Integer userId) {

        logger.info("重置平台密码开始,入参:userId="+userId);
        Result result = sysConsoleUsersService.resetPassword(userId);
        logger.info("重置平台密码结束,出参:"+result.toString());
        return result;
    }

    @ApiOperation(value = "查看所有采购信息", httpMethod = "GET", notes = "查看所有采购信息")
    @GetMapping(value ="/listRelatedPurchaseService")
    public Result listRelatedPurchaseService(){
        logger.info("查看所有采购信息 - 开始");
        Result result =  sysConsoleUsersService.findUserList();
        logger.info("查看所有采购信息 - 结束");
        return  result;
    }
}
