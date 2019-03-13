package com.company.springboot.controller.wp;

import com.company.springboot.service.wp.WpCfgFrameProcessStepService;
import com.company.springboot.utils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description: 框架子流程步骤配置
 * @author: zhangshuai
 * @create: 2019-01-25 15:46
 */
@RestController
@RequestMapping("/wpCfgFrameProcessStep")
@Api(description = "框架子流程步骤配置")
public class WpCfgFrameProcessStepController {

    private Logger log = Logger.getLogger(Logger.class);

    @Autowired
    private WpCfgFrameProcessStepService wpCfgFrameProcessStepService;

    @ApiOperation(
            value = "框架子流程列表",
            notes = "框架子流程列表",
            consumes = "application/json",
            responseReference = "com.company.springboot.utils.Result"
    )
    @SuppressWarnings("unchecked")
    @RequestMapping(value = "/findList",method=RequestMethod.GET)
    public Result findList(@RequestParam Integer cfgFrameProcessId) {
        log.info("框架子流程列表开始,入参:cfgFrameProcessId="+cfgFrameProcessId);
        Result result = wpCfgFrameProcessStepService.findList(cfgFrameProcessId);
        log.info("框架子流程列表结束,出参:"+result.toString());
        return result;
    }

}
