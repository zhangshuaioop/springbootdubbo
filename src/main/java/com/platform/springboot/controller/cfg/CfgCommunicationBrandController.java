package com.platform.springboot.controller.cfg;

import com.platform.springboot.entity.cfg.CfgCommunicationBrand;
import com.platform.springboot.service.cfg.CfgCommunicationBrandService;
import com.platform.springboot.utils.Result;
import com.platform.springboot.utils.ResultUtil;
import com.platform.springboot.service.cfg.CfgCommunicationBrandService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 通信品牌
 * @Author Niting
 * @date 2018/12/18
 **/
@RestController
@RequestMapping("/cfgCommBrand")
@Api(description = "通信品牌")
public class CfgCommunicationBrandController {
    private final Logger logger = Logger.getLogger(getClass());

    @Autowired
    private CfgCommunicationBrandService service;

    @ApiOperation(value = "查询所有通信品牌", httpMethod = "GET", notes = "查询所有通信品牌")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public Result list(@RequestParam Integer flagOp) {
        logger.info("查询所有通信品牌开始,入参:flagOp="+flagOp);
        List<CfgCommunicationBrand> result = service.list(flagOp);
        logger.info("查询所有通信品牌结束,出参:"+result.toString());
        return ResultUtil.success(result);
    }
}
