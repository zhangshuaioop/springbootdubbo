package com.company.springboot.controller.wp;

import com.company.springboot.entity.wp.WpCfgProcess;
import com.company.springboot.service.wp.WpCfgProcessService;
import com.company.springboot.utils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author zhanghao
 * @Title: WpCfgProcessController
 * @ProjectName WaterDrop
 * @Description: 框架子流程
 * @date 2019/1/24下午1:37
 */
@RestController
@RequestMapping("/wpCfgProcess")
@Api(description = "框架子流程")
public class WpCfgProcessController {

    private Logger log = Logger.getLogger(Logger.class);

    @Resource
    private WpCfgProcessService wpCfgProcessService;

    @ApiOperation(value = "框架子流程列表", httpMethod = "POST", notes = "框架子流程列表")
    @PostMapping(value = "/list")
    public Result list(@RequestBody WpCfgProcess wpCfgProcess) {
        log.info("框架子流程列表-开始 入参："+wpCfgProcess.toString());
        Result result = wpCfgProcessService.list(wpCfgProcess);
        log.info("框架子流程列表-结束");
        return result;
    }


    @ApiOperation(value = "新增框架子流程", httpMethod = "POST", notes = "新增框架子流程")
    @PostMapping(value = "/handle")
    public Result handle(@RequestBody WpCfgProcess wpCfgProcess) {
        log.info("新增框架子流程-开始 入参："+wpCfgProcess.toString());
        Result result = wpCfgProcessService.handle(wpCfgProcess);
        log.info("新增框架子流程-结束");
        return result;
    }
}
