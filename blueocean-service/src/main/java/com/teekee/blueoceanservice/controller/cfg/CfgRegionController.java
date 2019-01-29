package com.teekee.blueoceanservice.controller.cfg;

import com.teekee.blueoceanservice.service.cfg.CfgRegionService;
import com.teekee.commoncomponets.utils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author Chenliwen
 * @Date 2019/1/3 10:27
 **/
@RestController
@RequestMapping("/cfgRegion")
@Api(description = "节点地址")
public class CfgRegionController {

    private Logger log = Logger.getLogger(CfgRegionController.class);
    @Resource
    private CfgRegionService cfgRegionService;



    @ApiOperation(
            value = "获取某个父级节点下的所有地址列表",
            notes = "获取某个父级节点下的所有地址列表",
            consumes = "application/json",
            responseReference = "com.teekee.commoncomponets.utils.Result"
    )
    @GetMapping(value = "/listNode")
    public Result listNode(@RequestParam Integer parentId) {
        log.info("获取某个父级节点下的所有地址列表-开始,入参:parentId="+parentId);
        Result result = cfgRegionService.getRegionList(parentId);
        log.info("获取某个父级节点下的所有地址列表-结束,出参:result="+result.toString());
        return result;
    }

    @ApiOperation(value = "查看第三级别节点信息（城市）", httpMethod = "GET", notes = "查看第三级别节点信息（城市）")
    @GetMapping(value = "/listCity")
    public Result listCity() {
        log.info("查看第三级别节点信息（城市）-开始");
        Result result = cfgRegionService.getCityList();
        log.info("查看第三级别节点信息（城市）-结束");
        return result;
    }

    @ApiOperation(value = "查看地址节点信息", httpMethod = "GET", notes = "查看地址节点信息")
    @GetMapping(value = "/show")
    public Result show(@RequestParam Integer id) {
        log.info("查看地址节点信息-开始");
        Result result = cfgRegionService.selectRegion(id);
        log.info("查看地址节点信息-结束");
        return result;
    }
}
