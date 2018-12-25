package com.platform.springboot.controller;

import com.platform.springboot.entity.sys.SysCompanyUsers;
import com.platform.springboot.service.sys.SysCompanyUsersService;
import com.platform.springboot.utils.Result;
import com.platform.springboot.utils.ResultUtil;
import com.platform.springboot.service.sys.SysCompanyUsersService;
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
            responseReference = "com.platform.springboot.utils.Result"
    )
    @SuppressWarnings("unchecked")
    @RequestMapping(value = "/getUserPermission",method=RequestMethod.GET)
    public Result getUserPermission() {

        logger.info("当前权限及相关信息开始,入参:无");
        Result result = sysCompanyUsersService.findUserView();
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
            responseReference = "com.platform.springboot.utils.Result"
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
            responseReference = "com.platform.springboot.utils.Result"
    )
    @SuppressWarnings("unchecked")
    @RequestMapping(value = "/saveOrUpdateUsers",method=RequestMethod.POST)
    public Result saveOrUpdateUsers(@RequestBody SysCompanyUsers sysCompanyUsers) {


        logger.info("账号保存/修改开始,入参:sysCompanyUsers="+sysCompanyUsers.toString());
        Result result = ResultUtil.success(sysCompanyUsersService.saveOrUpdateUsers(sysCompanyUsers));
        logger.info("账号保存/修改结束,出参:"+result.toString());
        return result;
    }

}
