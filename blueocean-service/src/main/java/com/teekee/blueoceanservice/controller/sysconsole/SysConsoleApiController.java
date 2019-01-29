package com.teekee.blueoceanservice.controller.sysconsole;

import com.teekee.blueoceanservice.entity.sysconsole.SysConsoleApi;
import com.teekee.blueoceanservice.service.sysconsole.SysConsoleApiService;
import com.teekee.commoncomponets.utils.Result;
import com.teekee.commoncomponets.utils.ResultUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @description:平台模式权限接口
 * @author: zhangshuai
 * @create: 2018-12-28 13:16
 */
@RestController
@RequestMapping("/sysConsoleApi")
@Api(description = "平台模式权限接口")
public class SysConsoleApiController {

    private final Logger logger = Logger.getLogger(getClass());

    @Autowired
    private SysConsoleApiService sysConsoleApiService;

    @ApiOperation(
            value = "分页权限接口列表",
            notes = "分页权限接口列表",
            consumes = "application/json",
            responseReference = "com.teekee.commoncomponets.utils.Result"
    )
    @SuppressWarnings("unchecked")
    @RequestMapping(value = "/findPage",method=RequestMethod.POST)
    public Result findPage(@RequestBody SysConsoleApi sysConsoleApi) {

        logger.info("分页权限接口列表开始,入参:sysConsoleApi="+sysConsoleApi.toString());
        Result result = sysConsoleApiService.findPage(sysConsoleApi);
        logger.info("分页权限接口列表结束,出参:"+result.toString());
        return result;
    }


    @ApiOperation(
            value = "权限接口列表详情",
            notes = "权限接口列表详情",
            consumes = "application/json",
            responseReference = "com.teekee.commoncomponets.utils.Result"
    )
    @SuppressWarnings("unchecked")
    @RequestMapping(value = "/findDetails",method=RequestMethod.GET)
    public Result findDetails(@RequestParam Integer id) {

        logger.info("权限接口列表详情开始,入参:id="+id);
        Result result = ResultUtil.success(sysConsoleApiService.get(id));
        logger.info("权限接口列表详情结束,出参:"+result.toString());
        return result;
    }


    @ApiOperation(
            value = "更新/保存权限接口",
            notes = "更新/保存权限接口",
            consumes = "application/json",
            responseReference = "com.teekee.commoncomponets.utils.Result"
    )
    @SuppressWarnings("unchecked")
    @RequestMapping(value = "/updateSave",method=RequestMethod.POST)
    public Result updateSave(@RequestBody SysConsoleApi sysConsoleApi) {
        Result result = new Result();
        logger.info("更新/保存权限接口开始,入参:sysConsoleApi="+sysConsoleApi.toString());
        if(sysConsoleApi != null && sysConsoleApi.getId() != null){
            logger.info("进入更新操作");
            result = ResultUtil.success(sysConsoleApiService.update(sysConsoleApi));
        }else {
            logger.info("进入保存操作");
            result = ResultUtil.success(sysConsoleApiService.save(sysConsoleApi));
        }
        logger.info("更新/保存权限接口结束,出参:result="+result.toString());
        return result;
    }


}
