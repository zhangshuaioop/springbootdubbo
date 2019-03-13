package com.company.springboot.controller.cfg;

import com.company.springboot.service.cfg.CfgRegionService;
import com.company.springboot.utils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @description:
 * @author: zhangshuai
 * @create: 2018-12-27 18:06
 */
@RestController
@RequestMapping("/cfgRegion")
@Api(description = "节点信息")
public class CfgRegionController {


    private final Logger logger = Logger.getLogger(getClass());

    @Autowired
    private CfgRegionService cfgRegionService;

    @ApiOperation(
            value = "获取某个父级节点下的所有地址列表",
            notes = "获取某个父级节点下的所有地址列表",
            consumes = "application/json",
            responseReference = "com.company.springboot.utils.Result"
    )
    @GetMapping(value = "/listNode")
    public Result listNode(@RequestParam Integer parentId) {
        logger.info("获取某个父级节点下的所有地址列表-开始,入参:parentId="+parentId);
        Result result = cfgRegionService.getRegionList(parentId);
        logger.info("获取某个父级节点下的所有地址列表-结束,出参:result="+result.toString());
        return result;
    }

    @ApiOperation(value = "查看第三级别节点信息（城市）", httpMethod = "GET", notes = "查看第三级别节点信息（城市）")
    @GetMapping(value = "/listCity")
    public Result listCity() {
        logger.info("查看第三级别节点信息（城市）-开始");
        Result result = cfgRegionService.getCityList();
        logger.info("查看第三级别节点信息（城市）-结束");
        return result;
    }

    @ApiOperation(value = "查看地址节点信息", httpMethod = "GET", notes = "查看地址节点信息")
    @GetMapping(value = "/show")
    public Result show(@RequestParam Integer id) {
        logger.info("查看地址节点信息-开始");
        Result result = cfgRegionService.selectRegion(id);
        logger.info("查看地址节点信息-结束");
        return result;
    }
}
