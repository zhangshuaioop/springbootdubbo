package com.platform.springboot.controller.syscompany;

import com.platform.springboot.entity.syscompany.SysCompanyPermission;
import com.platform.springboot.service.syscompany.SysCompanyPermissionService;
import com.platform.springboot.utils.Result;
import com.platform.springboot.utils.ResultUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @description: 公司权限配置
 * @author: zhangshuai
 * @create: 2018-12-21 15:11
 */
@RestController
@RequestMapping("/sysCompanyPermission")
@Api(description = "公司权限配置")
public class SysCompanyPermissionController {

    private final Logger logger = Logger.getLogger(getClass());

    @Autowired
    private SysCompanyPermissionService sysCompanyPermissionService;

    @ApiOperation(
            value = "分页公司权限配置列表",
            notes = "分页公司权限配置列表",
            consumes = "application/json",
            responseReference = "com.platform.springboot.utils.Result"
    )
    @SuppressWarnings("unchecked")
    @RequestMapping(value = "/findPage",method=RequestMethod.POST)
    public Result findPage(@RequestBody SysCompanyPermission sysCompanyPermission) {

        logger.info("分页公司权限配置列表开始,入参:sysCompanyPermission="+sysCompanyPermission.toString());
        Result result = sysCompanyPermissionService.findPage(sysCompanyPermission);
        logger.info("分页公司权限配置列表结束,出参:"+result.toString());
        return result;
    }


    @ApiOperation(
            value = "公司权限列表(树)",
            notes = "公司权限列表(树)",
            consumes = "application/json",
            responseReference = "com.platform.springboot.utils.Result"
    )
    @SuppressWarnings("unchecked")
    @RequestMapping(value = "/findList",method=RequestMethod.POST)
    public Result findList() {

        logger.info("公司权限列表(树)开始,入参:无");
        Result result = sysCompanyPermissionService.findByRoleIdList();
        logger.info("公司权限列表(树)结束,出参:"+result.toString());
        return result;
    }



    @ApiOperation(
            value = "权限详情",
            notes = "权限详情",
            consumes = "application/json",
            responseReference = "com.platform.springboot.utils.Result"
    )
    @SuppressWarnings("unchecked")
    @RequestMapping(value = "/findDetails",method=RequestMethod.GET)
    public Result findDetails(@RequestParam Integer id) {

        logger.info("获取权限详情开始,入参:id="+id);
        Result result = ResultUtil.success(sysCompanyPermissionService.get(id));
        logger.info("获取权限详情结束,出参:"+result.toString());
        return result;
    }


    @ApiOperation(
            value = "权限保存/更新",
            notes = "权限保存/更新",
            consumes = "application/json",
            responseReference = "com.platform.springboot.utils.Result"
    )
    @SuppressWarnings("unchecked")
    @RequestMapping(value = "/saveUpdate",method=RequestMethod.POST)
    public Result saveUpdate(@RequestBody SysCompanyPermission sysCompanyPermission) {

        logger.info("权限保存/更新开始,入参:sysCompanyPermission="+sysCompanyPermission);
        if(sysCompanyPermission != null){

            if(sysCompanyPermission.getId() != null && sysCompanyPermission.getId() > 0){
                logger.info("进入更新业务");
                sysCompanyPermissionService.update(sysCompanyPermission);
            }else {
                logger.info("进入保存业务");
                sysCompanyPermission.setFlagDeleted(false);
                sysCompanyPermissionService.save(sysCompanyPermission);
            }
        }
        Result result = ResultUtil.successMsg("");
        logger.info("权限保存/更新结束,出参:"+result.toString());
        return result;
    }

}
