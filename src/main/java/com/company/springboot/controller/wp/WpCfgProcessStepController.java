package com.company.springboot.controller.wp;

import com.company.springboot.entity.wp.WpCfgProcessDto;
import com.company.springboot.service.wp.WpCfgProcessStepService;
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
 * @Description: 子流程步骤
 * @date 2019/1/24下午1:37
 */
@RestController
@RequestMapping("/wpCfgProcessStep")
@Api(description = "子流程步骤")
public class WpCfgProcessStepController {

    private Logger log = Logger.getLogger(Logger.class);

    @Resource
    private WpCfgProcessStepService wpCfgProcessStepService;


    @ApiOperation(value = "新增子流程步骤", httpMethod = "POST", notes = "新增子流程步骤")
    @PostMapping(value = "/handle")
    public Result handle(@RequestBody WpCfgProcessDto wpCfgProcessDto) {
        log.info("新增子流程步骤-开始 入参："+wpCfgProcessDto.toString());
        Result result = wpCfgProcessStepService.handle(wpCfgProcessDto);
        log.info("新增子流程步骤-结束");
        return result;
    }
}
