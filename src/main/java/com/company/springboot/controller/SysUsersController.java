package com.company.springboot.controller;

import com.company.springboot.entity.sys.SysCompanyUserRoleRelation;
import com.company.springboot.entity.sys.SysCompanyUsers;
import com.company.springboot.entity.sys.request.SysCompanyUserPassword;
import com.company.springboot.utils.Result;
import com.company.springboot.utils.ResultUtil;
import com.company.springboot.service.sys.SysCompanyUsersService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @description:公司用户账号
 * @author: zhangshuai
 * @create: 2018-12-13 13:55
 */
@RestController
@RequestMapping("/sysUsers")
@Api(description = "公司用户")
public class SysUsersController {

    private final Logger logger = Logger.getLogger(getClass());

    @Autowired
    private SysCompanyUsersService sysCompanyUsersService;

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
        Result result = sysCompanyUsersService.findUserView();
        logger.info("当前权限及相关信息结束");

        return result;
    }



    @ApiOperation(
            value = "分页账号列表",
            notes = "分页账号列表",
            consumes = "application/json",
            responseReference = "com.company.springboot.utils.Result"
    )
    @SuppressWarnings("unchecked")
    @RequestMapping(value = "/findUsers",method=RequestMethod.POST)
    public Result findUsers(@RequestBody SysCompanyUsers sysCompanyUsers) {

        logger.info("账号列表开始,入参:sysCompanyUsers="+sysCompanyUsers.toString());
        Result result = sysCompanyUsersService.findPage(sysCompanyUsers);
        logger.info("账号列表结束,出参:"+result.toString());
        return result;
    }



    @ApiOperation(
            value = "账号列表详情",
            notes = "账号列表详情",
            consumes = "application/json",
            responseReference = "com.company.springboot.utils.Result"
    )
    @SuppressWarnings("unchecked")
    @RequestMapping(value = "/findUsersDetails",method=RequestMethod.GET)
    public Result findUsersDetails(@RequestParam Integer id) {

        logger.info("账号列表详情开始,入参:id="+id);
        Result result = ResultUtil.success(sysCompanyUsersService.get(id));
        logger.info("账号列表详情结束,出参:"+result.toString());
        return result;
    }


    @ApiOperation(
            value = "账号保存/修改",
            notes = "账号保存/修改",
            consumes = "application/json",
            responseReference = "com.company.springboot.utils.Result"
    )
    @SuppressWarnings("unchecked")
    @RequestMapping(value = "/saveOrUpdateUsers",method=RequestMethod.POST)
    public Result saveOrUpdateUsers(@RequestBody SysCompanyUsers sysCompanyUsers) {


        logger.info("账号保存/修改开始,入参:sysCompanyUsers="+sysCompanyUsers.toString());
        Result result = ResultUtil.success(sysCompanyUsersService.saveOrUpdateUsers(sysCompanyUsers));
        logger.info("账号保存/修改结束,出参:"+result.toString());
        return result;
    }




    @ApiOperation(
            value = "赋予账号角色",
            notes = "赋予账号角色",
            consumes = "application/json",
            responseReference = "com.company.springboot.utils.Result"
    )
    @SuppressWarnings("unchecked")
    @RequestMapping(value = "/updateUserRole",method=RequestMethod.POST)
    public Result updateUserRole(@RequestBody SysCompanyUserRoleRelation sysCompanyUserRoleRelation) {

        logger.info("赋予账号角色开始,入参:sysCompanyUserRoleRelation="+sysCompanyUserRoleRelation.toString());
        Result result = sysCompanyUsersService.updateUserRole(sysCompanyUserRoleRelation);
        logger.info("赋予账号角色结束,出参:"+result.toString());
        return result;
    }

    @ApiOperation(
            value = "修改密码",
            notes = "修改密码",
            consumes = "application/json",
            responseReference = "com.company.springboot.utils.Result"
    )
    @SuppressWarnings("unchecked")
    @RequestMapping(value = "/updatePassword",method=RequestMethod.POST)
    public Result updatePassword(@RequestBody SysCompanyUserPassword sysCompanyUserPassword) {

        logger.info("修改密码开始,入参:sysCompanyUserPassword="+sysCompanyUserPassword.toString());
        Result result = sysCompanyUsersService.updatePassword(sysCompanyUserPassword);
        logger.info("修改密码结束,出参:"+result.toString());
        return result;
    }


    @ApiOperation(
            value = "重置密码",
            notes = "重置密码",
            consumes = "application/json",
            responseReference = "com.company.springboot.utils.Result"
    )
    @SuppressWarnings("unchecked")
    @RequestMapping(value = "/resetPassword",method=RequestMethod.GET)
    public Result resetPassword(@RequestParam Integer userId) {

        logger.info("重置密码开始,入参:userId="+userId);
        Result result = sysCompanyUsersService.resetPassword(userId);
        logger.info("重置密码结束,出参:"+result.toString());
        return result;
    }


    @ApiOperation(
            value = "更新redis中角色权限",
            notes = "更新redis中角色权限",
            consumes = "application/json",
            responseReference = "com.company.springboot.utils.Result"
    )
    @SuppressWarnings("unchecked")
    @RequestMapping(value = "/updateRedisPermission",method=RequestMethod.GET)
    public Result updateRedisPermission() {
        logger.info("更新redis中角色权限开始,入参:无");
        Result result = sysCompanyUsersService.updateRedisPermission();
        logger.info("更新redis中角色权限结束,出参:"+result.toString());
        return result;
    }

    @ApiOperation(value = "用户打开关闭状态", httpMethod = "GET", notes = "status:0关闭 1打开")
    @GetMapping(value = "/userOpenClose")
    public Result userOpenClose(@RequestParam Integer userId ,@RequestParam boolean status) {
        logger.info("用户打开关闭状态-开始");
        Result  result = sysCompanyUsersService.userOpenClose(userId, status);
        logger.info("用户打开关闭状态-结束");
        return result;
    }

    @ApiOperation(value = "查看所有采购信息", httpMethod = "GET", notes = "查看所有采购信息")
    @GetMapping(value ="/listRelatedPurchaseService")
    public Result listRelatedPurchaseService(){
        logger.info("查看所有采购信息 - 开始");
        Result result =  sysCompanyUsersService.findUserList();
        logger.info("查看所有采购信息 - 结束");
        return  result;
    }

}
