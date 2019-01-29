package com.teekee.blueoceanservice.controller.syscompany;

import com.teekee.blueoceanservice.entity.syscompany.SysCompanyUsers;
import com.teekee.blueoceanservice.service.syscompany.SysCompanyUsersService;
import com.teekee.blueoceanservice.entity.syscompany.SysCompanyUsers;
import com.teekee.blueoceanservice.service.syscompany.SysCompanyUsersService;
import com.teekee.commoncomponets.utils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @description: 公司用户信息
 * @author: zhangshuai
 * @create: 2019-01-02 18:09
 */
@RestController
@RequestMapping("/sysCompanyUsers")
@Api(description = "公司用户信息")
public class SysCompanyUsersController {


    private final Logger logger = Logger.getLogger(getClass());

    @Autowired
    private SysCompanyUsersService sysCompanyUsersService;

    @ApiOperation(
            value = "平台查看公司用户-分页列表",
            notes = "平台查看公司用户-分页列表",
            consumes = "application/json",
            responseReference = "com.teekee.commoncomponets.utils.Result"
    )
    @SuppressWarnings("unchecked")
    @RequestMapping(value = "/findPage",method=RequestMethod.POST)
    public Result findPage(@RequestBody SysCompanyUsers sysCompanyUsers) {

        logger.info("平台查看公司用户-分页列表开始,入参:sysCompanyUsers="+sysCompanyUsers.toString());
        Result result = sysCompanyUsersService.findPage(sysCompanyUsers);
        logger.info("平台查看公司用户-分页列表结束,出参:"+result.toString());
        return result;
    }


    @ApiOperation(
            value = "重置公司密码(超级管理员)",
            notes = "重置公司密码(超级管理员)",
            consumes = "application/json",
            responseReference = "com.teekee.commoncomponets.utils.Result"
    )
    @SuppressWarnings("unchecked")
    @RequestMapping(value = "/resetPassword",method=RequestMethod.GET)
    public Result resetPassword(@RequestParam Integer userId) {

        logger.info("重置公司密码(超级管理员)开始,入参:userId="+userId);
        Result result = sysCompanyUsersService.resetPassword(userId);
        logger.info("重置公司密码(超级管理员)结束,出参:"+result.toString());
        return result;
    }

}
