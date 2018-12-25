package com.platform.springboot.controller.cfg;

import com.platform.springboot.entity.cfg.CfgDataDictionary;
import com.platform.springboot.service.cfg.CfgDataDictionaryService;
import com.platform.springboot.utils.Result;
import com.platform.springboot.utils.ResultUtil;
import com.platform.springboot.service.cfg.CfgDataDictionaryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 字典表
 * @Author Niting
 * @date 2018/12/18
 **/
@RestController
@RequestMapping("/cfgDic")
@Api(description = "字典表")
public class CfgDataDictionaryController {
    private final Logger logger = Logger.getLogger(getClass());
    @Resource
    private CfgDataDictionaryService service;

    @ApiOperation(value = "查看所有配置信息", httpMethod = "GET", notes = "查看所有配置信息")
    @RequestMapping(value = "/list", method = RequestMethod.GET, produces = "text/json;charset=UTF-8")
    public Result list() {
        logger.info("查询所有用户信息-开始");
        List<CfgDataDictionary> result = service.getAllDictionary();
        logger.info("查询所有用户信息-结束");
        return ResultUtil.success(result);
    }

    @ApiOperation(value = "按照类型，查看配置信息", httpMethod = "GET", notes = "按照类型，查看配置信息")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public Result list(@RequestParam String dtype) {
        logger.info("按照类型，查看配置信息开始,入参:dtype="+dtype);
        List<CfgDataDictionary> result = service.getDictionaryByType(dtype);
        logger.info("按照类型，查看配置信息结束,出参:"+result.toString());
        return ResultUtil.success(result);
    }

    @ApiOperation(value = "根据周期ID，查看结算类型", httpMethod = "GET", notes = "根据周期ID，查看结算类型")
    @RequestMapping(value = "/listByPayFrequency/v1.0/{id}", method = RequestMethod.GET, produces = "text/json;charset=UTF-8")
    public Result listByPayFrequency(@PathVariable int id) {
        logger.info("根据周期ID，查看结算类型-开始");
        List<CfgDataDictionary> result = service.listByPayFrequency(id);
        logger.info("根据周期ID，查看结算类型-结束");
        return ResultUtil.success(result);
    }
}
