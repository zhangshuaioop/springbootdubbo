//package com.platform.springboot.controller.cfg;
//
//import com.platform.springboot.entity.cfg.CfgDispatchRoute;
//import com.platform.springboot.service.cfg.CfgDispatchRouteService;
//import com.platform.springboot.utils.Result;
//import com.platform.springboot.utils.ResultUtil;
//import io.swagger.annotations.Api;
//import io.swagger.annotations.ApiOperation;
//import org.apache.log4j.Logger;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
///**
// * @description: 项目规则
// * @author: zhangshuai
// * @create: 2019-01-03 10:02
// */
//@RestController
//@RequestMapping("/cfgDispatchRoute")
//@Api(description = "项目规则")
//public class CfgDispatchRouteController {
//
//    private final Logger logger = Logger.getLogger(getClass());
//
//
//    @Autowired
//    private CfgDispatchRouteService cfgDispatchRouteService;
//
//    @ApiOperation(
//            value = "分页查询项目规则配置列表",
//            notes = "分页查询项目规则配置列表",
//            consumes = "application/json",
//            responseReference = "com.platform.springboot.utils.Result"
//    )
//    @SuppressWarnings("unchecked")
//    @RequestMapping(value = "/findPage",method=RequestMethod.POST)
//    public Result findPage(@RequestBody CfgDispatchRoute cfgDispatchRoute) {
//        logger.info("分页查询项目规则配置列表开始,入参:cfgDispatchRoute="+cfgDispatchRoute.toString());
//        Result result = cfgDispatchRouteService.findPage(cfgDispatchRoute);
//        logger.info("分页查询项目规则配置列表结束,出参:"+result.toString());
//        return result;
//    }
//
//
//    @ApiOperation(
//            value = "查询项目人员",
//            notes = "查询项目人员",
//            consumes = "application/json",
//            responseReference = "com.platform.springboot.utils.Result"
//    )
//    @SuppressWarnings("unchecked")
//    @RequestMapping(value = "/findPerson",method=RequestMethod.GET)
//    public Result findPerson(@RequestParam Integer id) {
//        logger.info("查询项目人员开始,入参:id="+id);
//        Result result = cfgDispatchRouteService.findPerson(id);
//        logger.info("查询项目人员结束,出参:"+result.toString());
//        return result;
//    }
//
//
//
//    @ApiOperation(
//            value = "项目规则配置列表详情",
//            notes = "项目规则配置列表详情",
//            consumes = "application/json",
//            responseReference = "com.platform.springboot.utils.Result"
//    )
//    @SuppressWarnings("unchecked")
//    @RequestMapping(value = "/findDetail",method=RequestMethod.GET)
//    public Result findDetail(@RequestParam Integer id) {
//        logger.info("项目规则配置列表详情开始,入参:id="+id);
//        Result result = ResultUtil.success(cfgDispatchRouteService.get(id));
//        logger.info("项目规则配置列表详情结束,出参:"+result.toString());
//        return result;
//    }
//
//
//    @ApiOperation(
//            value = "获取公司列表",
//            notes = "获取公司列表",
//            consumes = "application/json",
//            responseReference = "com.platform.springboot.utils.Result"
//    )
//    @SuppressWarnings("unchecked")
//    @RequestMapping(value = "/findCompanyList",method=RequestMethod.GET)
//    public Result findCompanyList() {
//        logger.info("获取公司列表开始,入参:无");
//        Result result = cfgDispatchRouteService.findCompanyList();
//        logger.info("获取公司列表结束,出参:"+result.toString());
//        return result;
//    }
//
//
//    @ApiOperation(
//            value = "根据公司id获取项目列表",
//            notes = "根据公司id获取项目列表",
//            consumes = "application/json",
//            responseReference = "com.platform.springboot.utils.Result"
//    )
//    @SuppressWarnings("unchecked")
//    @RequestMapping(value = "/findProjectByCompany",method=RequestMethod.GET)
//    public Result findProjectByCompany(@RequestParam Integer companyId) {
//        logger.info("根据公司id获取项目列表开始,入参:companyId="+companyId);
//        Result result = cfgDispatchRouteService.findProjectByCompany(companyId);
//        logger.info("根据公司id获取项目列表结束,出参:"+result.toString());
//        return result;
//    }
//
//
//
//    @ApiOperation(
//            value = "保存/编辑项目规则配置",
//            notes = "保存/编辑项目规则配置",
//            consumes = "application/json",
//            responseReference = "com.platform.springboot.utils.Result"
//    )
//    @SuppressWarnings("unchecked")
//    @RequestMapping(value = "/saveOrUpdate",method=RequestMethod.POST)
//    public Result saveOrUpdate(@RequestBody CfgDispatchRoute cfgDispatchRoute) {
//        logger.info("保存/编辑项目规则配置开始,入参:cfgDispatchRoute="+cfgDispatchRoute);
//        Result result = cfgDispatchRouteService.saveOrUpdate(cfgDispatchRoute);
//        logger.info("保存/编辑项目规则配置结束,出参:"+result.toString());
//        return result;
//    }
//
//
//
//    @ApiOperation(
//            value = "删除项目规则配置",
//            notes = "删除项目规则配置",
//            consumes = "application/json",
//            responseReference = "com.platform.springboot.utils.Result"
//    )
//    @SuppressWarnings("unchecked")
//    @RequestMapping(value = "/deleteCfg",method=RequestMethod.GET)
//    public Result deleteCfg(@RequestParam Integer id) {
//        logger.info("删除项目规则配置开始,入参:id="+id);
//        Result result = cfgDispatchRouteService.deleteCfg(id);
//        logger.info("删除项目规则配置结束,出参:"+result.toString());
//        return result;
//    }
//
//
//
//
//
//}
