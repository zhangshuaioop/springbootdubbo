package com.teekee.blueoceanservice.controller.cfg;

import com.teekee.blueoceanservice.entity.cfg.CfgFaultTypeModel;
import com.teekee.blueoceanservice.service.cfg.CfgFaultTypeModelService;
import com.teekee.commoncomponets.utils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author zhanghao
 * @Title: CfgFaultTypeModelController
 * @ProjectName BlueOcean
 * @Description: 故障类型
 * @date 2019/1/17下午5:27
 */

@RestController
@RequestMapping("/cfgFaultTypeModel")
@Api(description = "故障类型")
public class CfgFaultTypeModelController {

    private Logger log = Logger.getLogger(CfgFaultTypeModelController.class);

    @Resource
    private CfgFaultTypeModelService service;

    @ApiOperation(value = "新增客服故障JSON", httpMethod = "POST", notes = "新增客服故障JSON")
    @RequestMapping(value = "/handle", method = RequestMethod.POST)
    public Result handle(@RequestBody String json) {
        log.info("新增客服故障JSON-开始");
        Result result = service.handle(json);
        log.info("新增客服故障JSON-结束");
        return result;
    }

    @ApiOperation(value = "查询客服配置列表", httpMethod = "POST", notes = "查询客服配置")
    @PostMapping(value = "/list")
    public Result list(@RequestBody CfgFaultTypeModel model) {
        log.info("查询客服配置列表-开始 入参："+model.toString());
        Result result = service.list(model);
        log.info("查询客服配置列表-结束");
        return result;
    }

    @ApiOperation(value = "查询客服Json", httpMethod = "GET", notes = "查询客服Json")
    @RequestMapping(value = "/listConfig", method = RequestMethod.GET)
    public Result listConfig(@RequestParam Integer modelId) {
        log.info("查询客服Json-开始");
        Result result = service.listConfig(modelId);
        log.info("查询客服Json-结束");
        return result;
    }

    @ApiOperation(value = "客服界面配置json显示", httpMethod = "GET", notes = "客服界面配置json显示")
    @RequestMapping(value = "/listConfigByCustomer", method = RequestMethod.GET)
    public Result listConfigByCustomer(@RequestParam String faultDefineType) {
        log.info("客服界面配置json显示-开始");
        Result result = service.listConfigByCustomer(faultDefineType);
        log.info("客服界面配置json显示-结束");
        return result;
    }

    @ApiOperation(value = "显示历史记录", httpMethod = "POST", notes = "显示历史记录")
    @RequestMapping(value = "/listHistory", method = RequestMethod.POST)
    public Result listHistory(@RequestBody CfgFaultTypeModel model) {
        log.info("显示历史记录-开始");
        Result result = service.listHistory(model);
        log.info("显示历史记录-结束");
        return result;
    }
}
