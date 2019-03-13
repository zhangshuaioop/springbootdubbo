package com.company.springboot.controller.fdp;

import com.company.springboot.entity.fdp.FdpFaultReportRoute;
import com.company.springboot.service.fdp.FdpFaultReportRouteService;
import com.company.springboot.utils.Result;
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
            value = "编辑故障分配路径",
            notes = "编辑故障分配路径",
            consumes = "application/json",
            responseReference = "com.company.springboot.utils.Result"
    )
    @RequestMapping(value = "/modify",method=RequestMethod.POST)
    public Result modify(@RequestBody List<FdpFaultReportRoute> fdpFaultReportRoutes) {
        logger.info("编辑故障分配路径开始,入参:fdpFaultReportRoute="+fdpFaultReportRoutes.toString());
        Result result = fdpFaultReportRouteService.modify(fdpFaultReportRoutes);
        logger.info("编辑故障分配路径结束,出参:"+result.toString());
        return result;
    }


    @ApiOperation(
            value = "查询故障分配路径列表",
            notes = "查询故障分配路径列表",
            consumes = "application/json",
            responseReference = "com.company.springboot.utils.Result"
    )
    @RequestMapping(value = "/routelist",method=RequestMethod.GET)
    public Result routelist(@RequestParam Integer companyId) {
        logger.info("查询故障分配路径列表开始,入参:companyId="+companyId);
        Result result = fdpFaultReportRouteService.showRouteList(companyId);
        logger.info("查询故障分配路径列表结束,出参:"+result.toString());
        return result;
    }


    @ApiOperation(
            value = "查询可分配雇主列表",
            notes = "查询可分配雇主列表",
            consumes = "application/json",
            responseReference = "com.company.springboot.utils.Result"
    )
    @RequestMapping(value = "/routeObject",method=RequestMethod.GET)
    public Result routeObject(@RequestParam Integer companyId) {
        logger.info("查询可分配雇主列表,入参:companyId="+companyId);
        Result result = fdpFaultReportRouteService.routeObjectList(companyId);
        logger.info("查询可分配雇主列表,出参:"+result.toString());
        return result;
    }


}
