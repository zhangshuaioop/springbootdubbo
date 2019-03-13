package com.company.springboot.controller.cfg;

import com.company.springboot.entity.cfg.CfgDispatchRouteDetail;
import com.company.springboot.service.cfg.CfgDispatchRouteDetailService;
import com.company.springboot.utils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * @description: 项目细则配置
 * @author: zhangshuai
 * @create: 2019-01-07 17:32
 */
@RestController
@RequestMapping("/cfgDispatchRouteDetail")
@Api(description = "项目细则配置")
public class CfgDispatchRouteDetailController {

    private final Logger logger = Logger.getLogger(getClass());

    @Autowired
    private CfgDispatchRouteDetailService cfgDispatchRouteDetailService;

    @ApiOperation(
            value = "项目细则配置列表(树)",
            notes = "项目细则配置列表(树)",
            consumes = "application/json",
            responseReference = "com.platform.springboot.utils.Result"
    )
    @SuppressWarnings("unchecked")
    @RequestMapping(value = "/findTree",method=RequestMethod.GET)
    public Result findTree(@RequestParam Integer routeId) {
        logger.info("项目细则配置列表(树)开始,入参:routeId="+routeId);
        Result result = cfgDispatchRouteDetailService.findTree(routeId);
        logger.info("项目细则配置列表(树)结束,出参:"+result.toString());
        return result;
    }



    @ApiOperation(
            value = "查看项目细则配置人员",
            notes = "查看项目细则配置人员",
            consumes = "application/json",
            responseReference = "com.platform.springboot.utils.Result"
    )
    @SuppressWarnings("unchecked")
    @RequestMapping(value = "/findPerson",method=RequestMethod.GET)
    public Result findPerson(@RequestParam Integer routeId) {
        logger.info("查看项目细则配置人员开始,入参:routeId="+routeId);
        Result result = cfgDispatchRouteDetailService.findPerson(routeId);
        logger.info("查看项目细则配置人员结束,出参:"+result.toString());
        return result;
    }


    @ApiOperation(
            value = "保存/修改项目细则配置",
            notes = "保存/修改项目细则配置",
            consumes = "application/json",
            responseReference = "com.platform.springboot.utils.Result"
    )
    @SuppressWarnings("unchecked")
    @RequestMapping(value = "/saveOrUpdate",method=RequestMethod.POST)
    public Result saveOrUpdate(@RequestBody List<CfgDispatchRouteDetail> cfgDispatchRouteDetails) {
        logger.info("保存/修改项目细则配置开始,入参:cfgDispatchRouteDetails="+cfgDispatchRouteDetails.toString());
        Result result = cfgDispatchRouteDetailService.saveOrUpdate(cfgDispatchRouteDetails);
        logger.info("保存/修改项目细则配置结束,出参:"+result.toString());
        return result;
    }

}
