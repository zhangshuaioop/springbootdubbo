package com.platform.springboot.controller.fdp;

import com.platform.springboot.entity.fdp.FdpFaultReportRoute;
import com.platform.springboot.entity.sys.SysCompanyUsers;
import com.platform.springboot.service.fdp.FdpFaultReportRouteService;
import com.platform.springboot.utils.CurrentUtil;
import com.platform.springboot.utils.Result;
import com.platform.springboot.service.fdp.FdpFaultReportRouteService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @description:报障路径配置表
 * @author: zhangshuai
 * @create: 2018-12-18 14:12
 */
@RestController
@RequestMapping("/fdpFaultReportRoute")
@Api(description = "报障路径配置表")
public class FdpFaultReportRouteController {

    private final Logger logger = Logger.getLogger(getClass());

    @Autowired
    private FdpFaultReportRouteService fdpFaultReportRouteService;

    @ApiOperation(
            value = "新增故障分配路径",
            notes = "新增故障分配路径",
            consumes = "application/json",
            responseReference = "com.platform.springboot.utils.Result"
    )
    @SuppressWarnings("unchecked")
    @RequestMapping(value = "/handle",method=RequestMethod.POST)
    public Result handle(@RequestBody FdpFaultReportRoute fdpFaultReportRoute) {
        SysCompanyUsers user = CurrentUtil.getCurrent();
        logger.info("新增故障分配路径开始,入参:fdpFaultReportRoute="+fdpFaultReportRoute.toString());
        Result result = fdpFaultReportRouteService.handle(fdpFaultReportRoute,CurrentUtil.getCurrent().getId());
        logger.info("新增故障分配路径结束,出参:"+result.toString());
        return result;
    }



    @ApiOperation(
            value = "编辑故障分配路径",
            notes = "编辑故障分配路径",
            consumes = "application/json",
            responseReference = "com.platform.springboot.utils.Result"
    )
    @SuppressWarnings("unchecked")
    @RequestMapping(value = "/modify",method=RequestMethod.POST)
    public Result modify(@RequestBody List<FdpFaultReportRoute> fdpFaultReportRoutes) {
        logger.info("编辑故障分配路径开始,入参:fdpFaultReportRoute="+fdpFaultReportRoutes.toString());
        Result result = fdpFaultReportRouteService.modify(fdpFaultReportRoutes,CurrentUtil.getCurrent().getId());
        logger.info("编辑故障分配路径结束,出参:"+result.toString());
        return result;
    }


    @ApiOperation(
            value = "查询雇主列表",
            notes = "查询雇主列表",
            consumes = "application/json",
            responseReference = "com.platform.springboot.utils.Result"
    )
    @SuppressWarnings("unchecked")
    @RequestMapping(value = "/list",method=RequestMethod.GET)
    public Result list() {
        logger.info("查询雇主列表开始,无参数");
        Result result = fdpFaultReportRouteService.showCompanyList(CurrentUtil.getCurrent().getId());
        logger.info("查询雇主列表结束,出参:"+result.toString());
        return result;
    }



    @ApiOperation(
            value = "删除故障分配路径",
            notes = "删除故障分配路径",
            consumes = "application/json",
            responseReference = "com.platform.springboot.utils.Result"
    )
    @SuppressWarnings("unchecked")
    @RequestMapping(value = "/delete",method=RequestMethod.POST)
    public Result delete(@RequestBody FdpFaultReportRoute fdpFaultReportRoute) {
        logger.info("删除故障分配路径开始,入参:fdpFaultReportRoute="+fdpFaultReportRoute.toString());
        Result result = fdpFaultReportRouteService.delete(fdpFaultReportRoute.getCompanyId());
        logger.info("删除故障分配路径结束,出参:"+result.toString());
        return result;
    }



    @ApiOperation(
            value = "查询故障分配路径列表",
            notes = "查询故障分配路径列表",
            consumes = "application/json",
            responseReference = "com.platform.springboot.utils.Result"
    )
    @SuppressWarnings("unchecked")
    @RequestMapping(value = "/routelist",method=RequestMethod.GET)
    public Result routelist(@RequestParam Integer companyId) {
        logger.info("查询故障分配路径列表开始,入参:companyId="+companyId);
        Result result = fdpFaultReportRouteService.showRouteList(companyId);
        logger.info("查询故障分配路径列表结束,出参:"+result.toString());
        return result;
    }


    @ApiOperation(
            value = "查询分配对象",
            notes = "查询分配对象",
            consumes = "application/json",
            responseReference = "com.platform.springboot.utils.Result"
    )
    @SuppressWarnings("unchecked")
    @RequestMapping(value = "/routeObject",method=RequestMethod.GET)
    public Result routeObject(@RequestParam Integer companyId) {
        logger.info("查询分配对象开始,入参:companyId="+companyId);
        Result result = fdpFaultReportRouteService.routeObjectList(companyId);
        logger.info("查询分配对象结束,出参:"+result.toString());
        return result;
    }


}
