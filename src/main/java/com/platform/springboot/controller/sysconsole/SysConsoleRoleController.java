package com.platform.springboot.controller.sysconsole;

import com.platform.springboot.entity.sysconsole.SysConsoleRole;
import com.platform.springboot.entity.sysconsole.SysConsoleRolePermission;
import com.platform.springboot.entity.sysconsole.SysConsoleUsers;
import com.platform.springboot.service.sysconsole.SysConsoleRoleService;
import com.platform.springboot.utils.CurrentUtil;
import com.platform.springboot.utils.Result;
import com.platform.springboot.utils.ResultUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @description:平台角色
 * @author: zhangshuai
 * @create: 2018-12-25 16:19
 */
@RestController
@RequestMapping("/sysConsoleRole")
@Api(description = "平台角色")
public class SysConsoleRoleController {

    private final Logger logger = Logger.getLogger(getClass());

    @Autowired
    private SysConsoleRoleService sysConsoleRoleService;

    @ApiOperation(
            value = "分页角色列表",
            notes = "分页角色列表",
            consumes = "application/json",
            responseReference = "com.platform.springboot.utils.Result"
    )
    @SuppressWarnings("unchecked")
    @RequestMapping(value = "/findPage",method=RequestMethod.POST)
    public Result findPage(@RequestBody SysConsoleRole sysConsoleRole) {
        logger.info("分页角色列表开始,入参:sysConsoleRole="+sysConsoleRole.toString());
        Result result = sysConsoleRoleService.findPage(sysConsoleRole);
        logger.info("分页角色列表结束,出参:result="+result.toString());
        return result;
    }


    @ApiOperation(
            value = "角色详情",
            notes = "角色详情",
            consumes = "application/json",
            responseReference = "com.platform.springboot.utils.Result"
    )
    @SuppressWarnings("unchecked")
    @RequestMapping(value = "/findDetails",method=RequestMethod.GET)
    public Result findDetails(@RequestParam Integer id) {
        logger.info("角色详情开始,入参:id="+id);
        Result result = ResultUtil.success(sysConsoleRoleService.get(id));
        logger.info("角色详情结束,出参:result="+result.toString());
        return result;
    }


    @ApiOperation(
            value = "更新/保存角色",
            notes = "更新/保存角色",
            consumes = "application/json",
            responseReference = "com.platform.springboot.utils.Result"
    )
    @SuppressWarnings("unchecked")
    @RequestMapping(value = "/updateSave",method=RequestMethod.POST)
    public Result updateSave(@RequestBody SysConsoleRole sysConsoleRole) {
        Result result = new Result();
        SysConsoleUsers sysConsoleUsers = CurrentUtil.getCurrent();
        sysConsoleRole.setUpdatePerson(sysConsoleUsers.getId());
        logger.info("更新/保存角色开始,入参:sysConsoleRole="+sysConsoleRole.toString());
        if(sysConsoleRole != null && sysConsoleRole.getId() != null){
            logger.info("进入更新操作");
            sysConsoleRoleService.update(sysConsoleRole);
        }else {
            logger.info("进入保存操作");
            sysConsoleRole.setCreatePerson(sysConsoleUsers.getId());
            sysConsoleRoleService.save(sysConsoleRole);

            SysConsoleRolePermission sysConsoleRolePermission = new SysConsoleRolePermission();
            sysConsoleRolePermission.setRoleId(sysConsoleRole.getId());
            sysConsoleRolePermission.setPermissionIds("1");    //默认拥有首页权限
            sysConsoleRoleService.updateRolePermission(sysConsoleRolePermission);
        }
        logger.info("更新/保存角色结束,出参:result="+result.toString());
        return ResultUtil.success();
    }



    @ApiOperation(
            value = "角色赋权",
            notes = "角色赋权",
            consumes = "application/json",
            responseReference = "com.platform.springboot.utils.Result"
    )
    @SuppressWarnings("unchecked")
    @RequestMapping(value = "/updateRolePermission",method=RequestMethod.POST)
    public Result updateRolePermission(@RequestBody SysConsoleRolePermission sysConsoleRolePermission) {
        logger.info("角色赋权开始,入参:sysConsoleRolePermission="+sysConsoleRolePermission.toString());
        Result result = sysConsoleRoleService.updateRolePermission(sysConsoleRolePermission);
        logger.info("角色赋权结束,出参:result="+result.toString());
        return result;
    }


    @ApiOperation(
            value = "根据用户id获取所有角色列表",
            notes = "根据用户id获取所有角色列表",
            consumes = "application/json",
            responseReference = "com.company.springboot.utils.Result"
    )
    @SuppressWarnings("unchecked")
    @RequestMapping(value = "/findAllByUserId",method=RequestMethod.GET)
    public Result findAllByUserId(@RequestParam Integer userId) {

        logger.info("根据用户id获取所有角色列表开始,入参:userId="+userId);
        Result result = sysConsoleRoleService.findAllByUserId(userId);
        logger.info("根据用户id获取所有角色列表结束,出参:"+result.toString());
        return result;
    }
}
