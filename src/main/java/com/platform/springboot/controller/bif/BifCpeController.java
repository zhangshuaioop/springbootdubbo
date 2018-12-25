package com.platform.springboot.controller.bif;

import com.platform.springboot.entity.bif.BifCpe;
import com.platform.springboot.service.bif.BifCpeService;
import com.platform.springboot.utils.Result;
import com.platform.springboot.service.bif.BifCpeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 *
 * @Author Chenliwen
 * @Date 2018/12/17 14:00
 **/
@RestController
@RequestMapping("/cpe")
@Api(description = "网关")
public class BifCpeController {

    private Logger log = Logger.getLogger(BifCpeController.class);
    @Resource
    private BifCpeService bifCpeService;

    @ApiOperation(
            value = "网关门店信息列表",
            notes = "网关门店信息列表",
            consumes = "application/json",
            responseReference = "com.platform.springboot.utils.Result")
    @RequestMapping(value = "/getBifCpeList", method = RequestMethod.POST)
    public Result getBifCpeList(@RequestBody BifCpe bifCpe) {
        log.info("网关门店信息列表-开始,入参:bifCpe="+bifCpe);
        Result result = bifCpeService.getBifCpeList(bifCpe);
        log.info("网关门店信息列表-结束,出参:"+result.toString());
        return result;
    }

    @ApiOperation(
            value = "网关门店信息详情",
            notes = "网关门店信息详情",
            consumes = "application/json",
            responseReference = "com.platform.springboot.utils.Result")
    @RequestMapping(value = "/getBifCpeById", method = RequestMethod.GET)
    public Result getBifCpeById(@RequestParam int id) {
        log.info("网关门店信息详情-开始,入参:id="+id);
        Result result = bifCpeService.getBifCpeById(id);
        log.info("网关门店信息详情-结束,出参:"+result.toString());
        return result;
    }

    @ApiOperation(
            value = "新增编辑网关门店信息",
            notes = "新增编辑网关门店信息",
            consumes = "application/json",
            responseReference = "com.platform.springboot.utils.Result")
    @RequestMapping(value = "/handle", method = RequestMethod.POST)
    public Result confirm(@RequestBody BifCpe bifCpe) {
        log.info("新增编辑网关门店信息-开始,入参:requestJson="+bifCpe);
        Result result = bifCpeService.handle(bifCpe);
        log.info("新增编辑网关门店信息-结束,出参:"+result.toString());
        return result;
    }

    @ApiOperation(
            value = "删除网关门店信息",
            notes = "删除网关门店信息",
            consumes = "application/json",
            responseReference = "com.platform.springboot.utils.Result")
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public Result delete(@RequestBody BifCpe bifCpe) {
        log.info("删除网关门店信息-开始,入参:requestJson="+bifCpe.getId());
        Result result = bifCpeService.deleteById(bifCpe.getId());
        log.info("删除网关门店信息-结束,出参:"+result.toString());
        return result;
    }
}
