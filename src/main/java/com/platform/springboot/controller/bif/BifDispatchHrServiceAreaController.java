package com.platform.springboot.controller.bif;

import com.platform.springboot.entity.bif.BifDispatchHrServiceArea;
import com.platform.springboot.service.bif.BifDispatchHrServiceAreaService;
import com.platform.springboot.utils.Result;
import io.swagger.annotations.ApiOperation;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @Author Megumi
 * @Date 2019/1/2 11:34
 **/
@RestController
@RequestMapping("/hrServiceArea")
public class BifDispatchHrServiceAreaController {

    private Logger log = Logger.getLogger(BifDispatchHrServiceAreaController.class);

    @Resource
    private BifDispatchHrServiceAreaService service;

    @ApiOperation(
            value = "新增/修改服务商可服务区域",
            notes ="新增/修改服务商可服务区域",
            consumes = "application/json",
            responseReference = "com.platform.springboot.utils.Result")
    @RequestMapping(value = "/handle", method = RequestMethod.POST)
    public Result handle(@RequestBody BifDispatchHrServiceArea serviceArea) {
        log.info("新增/修改服务商可服务区域-开始,入参:serviceArea="+serviceArea);
        Result result = service.handle(serviceArea);
        log.info("新增/修改服务商可服务区域-结束,出参:"+result.toString());
        return result;
    }


    @ApiOperation(
            value = "服务商可服务区域删除",
            notes ="服务商可服务区域删除",
            consumes = "application/json",
            responseReference = "com.platform.springboot.utils.Result")
    @RequestMapping(value = "/serviceAreaDelete", method = RequestMethod.GET)
    public Result serviceDelete(@RequestParam Integer id) {
        log.info("服务商可服务区域删除-开始,入参:id="+id);
        Result result  = service.serviceAreaDelete(id);
        log.info("服务商可服务区域删除-结束,出参:"+result.toString());
        return result;
    }

    @ApiOperation(
            value = "服务商可服务区域list",
            notes ="服务商可服务区域list",
            consumes = "application/json",
            responseReference = "com.platform.springboot.utils.Result")
    @RequestMapping(value = "/serviceAreaList", method = RequestMethod.POST)
    public Result serviceAreaList(@RequestBody BifDispatchHrServiceArea area ) {
        log.info("服务商可服务区域list-开始,入参:area="+area);
        Result result  = service.serviceAreaList(area);
        log.info("服务商可服务区域list-结束,出参:"+result.toString());
        return result;
    }

    @ApiOperation(
            value = "服务商可服务区域SHOW",
            notes ="服务商可服务区域SHOW",
            consumes = "application/json",
            responseReference = "com.platform.springboot.utils.Result")
    @RequestMapping(value = "/serviceAreaShow", method = RequestMethod.GET)
    public Result serviceAreaShow(@RequestParam Integer id) {
        log.info("服务商可服务区域SHOW-开始,入参:id="+id);
        Result result  = service.serviceAreaShow(id);
        log.info("服务商可服务区域SHOW-结束,出参:"+result.toString());
        return result;
    }
}
