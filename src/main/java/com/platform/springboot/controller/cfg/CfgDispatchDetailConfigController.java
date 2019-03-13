package com.platform.springboot.controller.cfg;

import com.platform.springboot.entity.cfg.CfgDispatchDetailConfig;
import com.platform.springboot.entity.cfg.CfgDispatchDetailModel;
import com.platform.springboot.service.cfg.CfgDispatchDetailConfigService;
import com.platform.springboot.utils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @Author Chenliwen
 * @Date 2019/1/3 10:45
 **/
@RestController
@RequestMapping("/cfgDispatchDetailConfig")
@Api(description = "派工要求")
public class CfgDispatchDetailConfigController {

    private Logger log = Logger.getLogger(CfgDispatchDetailConfigController.class);

    @Resource
    private CfgDispatchDetailConfigService cfgDispatchDetailConfigService;

    @ApiOperation(value = "获取基本派工要求列表", httpMethod = "GET")
    @RequestMapping(value = "/basicList", method = RequestMethod.GET)
    public Result basicList(@RequestParam String dispatchType) {
        log.info("获取基本派工要求列表-开始");
        Result result = cfgDispatchDetailConfigService.basicList(dispatchType);
        log.info("获取基本派工要求列表-结束");
        return result;
    }

    @ApiOperation(value = "获取所有子要求列表", httpMethod = "GET")
    @RequestMapping(value = "/childList", method = RequestMethod.GET)
    public Result childList(@RequestParam Integer id) {
        log.info("获取所有子要求列表-开始");
        Result result = cfgDispatchDetailConfigService.childList(id);
        log.info("获取所有子要求列表-结束");
        return result;
    }

    @ApiOperation(value = "查询派工要求所有列表", httpMethod = "GET")
    @RequestMapping(value = "/show", method = RequestMethod.GET)
    public Result show(@RequestParam Integer modelId) {
        log.info("查询派工要求所有列表-开始");
        Result result = cfgDispatchDetailConfigService.show(modelId);
        log.info("查询派工要求所有列表-结束");
        return result;
    }

    @ApiOperation(value = "分页查询派工类型模板列表", httpMethod = "POST")
    @RequestMapping(value = "/showModelList", method = RequestMethod.POST)
    public Result showModelList(@RequestBody CfgDispatchDetailModel model) {
        log.info("查询派工类型模板列表-开始");
        Result result = cfgDispatchDetailConfigService.showModelList(model);
        log.info("查询派工类型模板列表-结束");
        return result;
    }

    @ApiOperation(value = "查询版本历史列表", httpMethod = "POST")
    @RequestMapping(value = "/historyList", method = RequestMethod.POST)
    public Result historyList(@RequestBody CfgDispatchDetailModel model) {
        log.info("查询版本历史列表-开始");
        Result result = cfgDispatchDetailConfigService.selectAllVersionList(model);
        log.info("查询版本历史列表-结束");
        return result;
    }

    @ApiOperation(value = "新增派工要求", httpMethod = "POST")
    @RequestMapping(value = "/handle", method = RequestMethod.POST)
    public Result handle(@RequestBody String json) {
        log.info("新增派工要求-开始");
        Result result = cfgDispatchDetailConfigService.handle(json);
        log.info("新增派工要求-结束");
        return result;
    }

    @ApiOperation(value = "查询详细派工要求", httpMethod = "GET")
    @RequestMapping(value = "/showDetailList", method = RequestMethod.GET)
    public Result showDetailList(@RequestParam Integer id) {
        log.info("查询详细派工要求-开始");
        Result result = cfgDispatchDetailConfigService.showDetailList(id);
        log.info("查询详细派工要求-结束");
        return result;
    }
}
