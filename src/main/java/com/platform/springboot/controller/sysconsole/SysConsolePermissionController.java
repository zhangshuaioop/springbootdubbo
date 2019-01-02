package com.platform.springboot.controller.sysconsole;

import com.platform.springboot.entity.sysconsole.SysConsolePermission;
import com.platform.springboot.entity.sysconsole.SysConsolePermissionApiRelation;
import com.platform.springboot.service.sysconsole.SysConsolePermissionService;
import com.platform.springboot.utils.Result;
import com.platform.springboot.utils.ResultUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @description:平台模式权限功能
 * @author: zhangshuai
 * @create: 2018-12-28 09:28
 */
@RestController
@RequestMapping("/sysConsolePermission")
@Api(description = "平台模式权限功能")
public class SysConsolePermissionController {

    private final Logger logger = Logger.getLogger(getClass());

    @Autowired
    private SysConsolePermissionService sysConsolePermissionService;

    @ApiOperation(
            value = "分页平台权限列表",
            notes = "分页平台权限列表",
            consumes = "application/json",
            responseReference = "com.platform.springboot.utils.Result"
    )
    @SuppressWarnings("unchecked")
    @RequestMapping(value = "/findPage",method=RequestMethod.POST)
    public Result findPage(@RequestBody SysConsolePermission sysConsolePermission) {
        logger.info("分页平台权限列表开始,入参:sysConsolePermission="+sysConsolePermission.toString());
        Result result = sysConsolePermissionService.findPage(sysConsolePermission);
        logger.info("分页平台权限列表结束,出参:result="+result.toString());
        return result;
    }


    @ApiOperation(
            value = "平台权限列表详情",
            notes = "平台权限列表详情",
            consumes = "application/json",
            responseReference = "com.platform.springboot.utils.Result"
    )
    @SuppressWarnings("unchecked")
    @RequestMapping(value = "/findDetails",method=RequestMethod.POST)
    public Result findDetails(@RequestParam Integer id) {
        logger.info("平台权限列表详情开始,入参:id="+id);
        Result result = ResultUtil.success(sysConsolePermissionService.get(id));
        logger.info("平台权限列表详情结束,出参:result="+result.toString());
        return result;
    }



    @ApiOperation(
            value = "平台权限更新/保存",
            notes = "平台权限更新/保存",
            consumes = "application/json",
            responseReference = "com.platform.springboot.utils.Result"
    )
    @SuppressWarnings("unchecked")
    @RequestMapping(value = "/saveOrUpdate",method=RequestMethod.POST)
    public Result saveOrUpdate(@RequestBody SysConsolePermission sysConsolePermission) {
        Result result = new Result();
        logger.info("平台权限更新/保存开始,入参:sysConsolePermission="+sysConsolePermission.toString());
        if(sysConsolePermission != null && sysConsolePermission.getId() != null){
            logger.info("进入更新操作");
            result = ResultUtil.success(sysConsolePermissionService.update(sysConsolePermission));
        }else {
            logger.info("进入保存操作");
            result = ResultUtil.success(sysConsolePermissionService.save(sysConsolePermission));
        }
        logger.info("平台权限更新/保存结束,出参:result="+result.toString());

        return result;
    }



    @ApiOperation(
            value = "平台权限绑定接口",
            notes = "平台权限绑定接口",
            consumes = "application/json",
            responseReference = "com.platform.springboot.utils.Result"
    )
    @SuppressWarnings("unchecked")
    @RequestMapping(value = "/updatePermissionApi",method=RequestMethod.POST)
    public Result updatePermissionApi(@RequestBody SysConsolePermissionApiRelation sysConsolePermissionApiRelation) {
        logger.info("平台权限绑定接口开始,入参:sysConsolePermissionApiRelation="+sysConsolePermissionApiRelation.toString());
        Result result = sysConsolePermissionService.updatePermissionApi(sysConsolePermissionApiRelation);
        logger.info("平台权限绑定接口结束,出参:result="+result.toString());
        return result;
    }

}
