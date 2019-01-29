package com.teekee.blueoceanservice.controller.cfg;

import com.teekee.blueoceanservice.entity.cfg.CfgDataDictionary;
import com.teekee.blueoceanservice.service.cfg.CfgDataDictionaryService;
import com.teekee.commoncomponets.utils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author Chenliwen
 * @Date 2019/1/3 11:28
 **/
@RestController
@RequestMapping("/cfgDic")
@Api(description = "配置信息")
public class CfgDataDictionaryController {

    private Logger log = Logger.getLogger(CfgDataDictionaryController.class);
    @Resource
    private CfgDataDictionaryService service;

    @ApiOperation(
            value = "查看所有配置信息",
            notes = "查看所有配置信息",
            consumes = "application/json",
            responseReference = "com.teekee.commoncomponets.utils.Result")
    @RequestMapping(value = "/list", method = RequestMethod.POST)
    public Result list(@RequestBody CfgDataDictionary cfgDataDictionary) {
        log.info("查询所有用户信息-开始，入参：cfgDataDictionary="+cfgDataDictionary);
        Result result = service.getAllDictionary(cfgDataDictionary);
        log.info("查询所有用户信息-结束，出参："+result.toString());
        return result;
    }
}
