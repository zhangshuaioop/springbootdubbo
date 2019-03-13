//package com.platform.springboot.controller.syscompany;
//
//import com.platform.springboot.entity.syscompany.SysCompanyRolePermission;
//import com.platform.springboot.service.syscompany.SysCompanyRoleService;
//import com.platform.springboot.utils.Result;
//import io.swagger.annotations.Api;
//import io.swagger.annotations.ApiOperation;
//import org.apache.log4j.Logger;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
///**
// * @description: 公司角色
// * @author: zhangshuai
// * @create: 2018-12-21 11:33
// */
//@RestController
//@RequestMapping("/sysCompanyRole")
//@Api(description = "公司角色")
//public class SysCompanyRoleController {
//
//    private final Logger logger = Logger.getLogger(getClass());
//
//    @Autowired
//    private SysCompanyRoleService sysCompanyRoleService;
//
//    @ApiOperation(
//            value = "角色赋权",
//            notes = "角色赋权",
//            consumes = "application/json",
//            responseReference = "com.platform.springboot.utils.Result"
//    )
//    @SuppressWarnings("unchecked")
//    @RequestMapping(value = "/updateRolePermission",method=RequestMethod.POST)
//    public Result updateRolePermission(@RequestBody SysCompanyRolePermission sysCompanyRolePermission) {
//
//        logger.info("角色赋权开始,入参:sysCompanyRolePermission="+sysCompanyRolePermission.toString());
//        Result result = sysCompanyRoleService.updateRolePermission(sysCompanyRolePermission);
//        logger.info("角色赋权结束,出参:"+result.toString());
//        return result;
//    }
//
//
//}
