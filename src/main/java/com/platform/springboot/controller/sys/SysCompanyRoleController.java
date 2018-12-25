package com.platform.springboot.controller.sys;

import com.platform.springboot.entity.sys.SysCompanyRole;
import com.platform.springboot.entity.sys.SysCompanyRolePermission;
import com.platform.springboot.service.sys.SysCompanyRoleService;
import com.platform.springboot.utils.CurrentUtil;
import com.platform.springboot.utils.Result;
import com.platform.springboot.utils.ResultUtil;
import com.platform.springboot.service.sys.SysCompanyRoleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @description: 公司角色
 * @author: zhangshuai
 * @create: 2018-12-21 11:33
 */
@RestController
@RequestMapping("/sysCompanyRole")
@Api(description = "公司角色")
public class SysCompanyRoleController {

    private final Logger logger = Logger.getLogger(getClass());

    @Autowired
    private SysCompanyRoleService sysCompanyRoleService;

    @ApiOperation(
            value = "分页角色列表",
            notes = "分页角色列表",
            consumes = "application/json",
            responseReference = "com.platform.springboot.utils.Result"
    )
    @SuppressWarnings("unchecked")
    @RequestMapping(value = "/findPage",method=RequestMethod.POST)
    public Result findPage(@RequestBody SysCompanyRole sysCompanyRole) {

        logger.info("分页角色列表开始,入参:sysCompanyRole="+sysCompanyRole.toString());
        Result result = sysCompanyRoleService.findPage(sysCompanyRole);
        logger.info("分页角色列表结束,出参:"+result.toString());
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
        Result result = ResultUtil.success(sysCompanyRoleService.get(id));
        logger.info("角色详情结束,出参:"+result.toString());
        return result;
    }




    @ApiOperation(
            value = "角色保存/更新",
            notes = "角色保存/更新",
            consumes = "application/json",
            responseReference = "com.platform.springboot.utils.Result"
    )
    @SuppressWarnings("unchecked")
    @RequestMapping(value = "/saveOrUpdate",method=RequestMethod.POST)
    public Result saveOrUpdate(@RequestBody SysCompanyRole sysCompanyRole) {

        logger.info("角色保存/更新开始,入参:sysCompanyRole="+sysCompanyRole.toString());

        if(sysCompanyRole != null){

            if(sysCompanyRole.getId() != null && sysCompanyRole.getId() > 0){
                logger.info("进入更新业务");
                sysCompanyRole.setUpdatePerson(CurrentUtil.getCurrent().getId());
                sysCompanyRoleService.update(sysCompanyRole);
            }else {
                logger.info("进入保存业务");
                sysCompanyRole.setFlagDeleted(true);
                sysCompanyRole.setCreatePerson(CurrentUtil.getCurrent().getId());
                sysCompanyRole.setUpdatePerson(CurrentUtil.getCurrent().getId());
                sysCompanyRoleService.save(sysCompanyRole);
            }
        }
        Result result = ResultUtil.successMsg("");
        logger.info("角色保存/更新结束,出参:"+result.toString());
        return result;
    }




    @ApiOperation(
            value = "角色赋权",
            notes = "角色赋权",
            consumes = "application/json",
            responseReference = "com.platform.springboot.utils.Result"
    )
    @SuppressWarnings("unchecked")
    @RequestMapping(value = "/updateRolePermission",method=RequestMethod.POST)
    public Result updateRolePermission(@RequestBody SysCompanyRolePermission sysCompanyRolePermission) {

        logger.info("角色赋权开始,入参:sysCompanyRolePermission="+sysCompanyRolePermission.toString());
        Result result = sysCompanyRoleService.updateRolePermission(sysCompanyRolePermission);
        logger.info("角色赋权结束,出参:"+result.toString());
        return result;
    }


}
