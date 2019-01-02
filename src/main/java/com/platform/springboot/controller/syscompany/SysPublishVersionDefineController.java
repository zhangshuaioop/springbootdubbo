package com.platform.springboot.controller.syscompany;

import com.platform.springboot.entity.syscompany.SysPublishVersionDefine;
import com.platform.springboot.entity.syscompany.SysPublishVersionPermission;
import com.platform.springboot.entity.sysconsole.SysConsoleRolePermission;
import com.platform.springboot.entity.sysconsole.SysConsoleUsers;
import com.platform.springboot.service.syscompany.SysPublishVersionDefineService;
import com.platform.springboot.utils.CurrentUtil;
import com.platform.springboot.utils.Result;
import com.platform.springboot.utils.ResultUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @description:系统发布版本表
 * @author: zhangshuai
 * @create: 2018-12-29 17:09
 */
@RestController
@RequestMapping("/sysPublishVersionDefine")
@Api(description = "系统发布版本表")
public class SysPublishVersionDefineController {

    private final Logger logger = Logger.getLogger(getClass());

    @Autowired
    private SysPublishVersionDefineService sysPublishVersionDefineService;

    @ApiOperation(
            value = "分页系统版本列表",
            notes = "分页系统版本列表",
            consumes = "application/json",
            responseReference = "com.platform.springboot.utils.Result"
    )
    @SuppressWarnings("unchecked")
    @RequestMapping(value = "/findPage",method=RequestMethod.POST)
    public Result findPage(@RequestBody SysPublishVersionDefine sysPublishVersionDefine) {

        logger.info("分页系统版本列表开始,入参:sysPublishVersionDefine="+sysPublishVersionDefine.toString());
        Result result = sysPublishVersionDefineService.findPage(sysPublishVersionDefine);
        logger.info("分页系统版本列表结束,出参:"+result.toString());
        return result;
    }



    @ApiOperation(
            value = "系统版本列表详情",
            notes = "系统版本列表详情",
            consumes = "application/json",
            responseReference = "com.platform.springboot.utils.Result"
    )
    @SuppressWarnings("unchecked")
    @RequestMapping(value = "/findPage",method=RequestMethod.GET)
    public Result findPage(@RequestParam Integer id) {

        logger.info("系统版本列表详情开始,入参:id="+id);
        Result result = ResultUtil.success(sysPublishVersionDefineService.get(id));
        logger.info("系统版本列表详情结束,出参:"+result.toString());
        return result;
    }


    @ApiOperation(
            value = "系统版本保存/更新",
            notes = "系统版本保存/更新",
            consumes = "application/json",
            responseReference = "com.platform.springboot.utils.Result"
    )
    @SuppressWarnings("unchecked")
    @RequestMapping(value = "/saveOrUpdate",method=RequestMethod.POST)
    public Result saveOrUpdate(@RequestBody SysPublishVersionDefine sysPublishVersionDefine) {

        SysConsoleUsers sysConsoleUsers = CurrentUtil.getCurrent();
        sysPublishVersionDefine.setUpdatePerson(sysConsoleUsers.getId());
        if(sysPublishVersionDefine != null){

            if(sysPublishVersionDefine.getId() != null && sysPublishVersionDefine.getId() > 0) {
                logger.info("进入更新业务");
                sysPublishVersionDefineService.update(sysPublishVersionDefine);
            }else {
                logger.info("进入保存业务");
                sysPublishVersionDefine.setCreatePerson(sysConsoleUsers.getId());
                sysPublishVersionDefineService.save(sysPublishVersionDefine);
            }
            return ResultUtil.success();
        }else {
            return ResultUtil.validateError("");
        }
    }


    @ApiOperation(
            value = "赋予版本功能",
            notes = "赋予版本功能",
            consumes = "application/json",
            responseReference = "com.platform.springboot.utils.Result"
    )
    @SuppressWarnings("unchecked")
    @RequestMapping(value = "/updateVersionPermission",method=RequestMethod.POST)
    public Result updateVersionPermission(@RequestBody SysPublishVersionPermission sysPublishVersionPermission) {
        logger.info("赋予版本功能开始,入参:sysPublishVersionPermission="+sysPublishVersionPermission.toString());
        Result result = sysPublishVersionDefineService.updateVersionPermission(sysPublishVersionPermission);
        logger.info("赋予版本功能结束,出参:result="+result.toString());
        return result;
    }

}
