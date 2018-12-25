package com.platform.springboot.controller.fdp;

import com.platform.springboot.entity.fdp.GetFaultDispatchRequestList;
import com.platform.springboot.entity.fdp.ParamFdpProcessDetailed;
import com.platform.springboot.service.fdp.FdpFaultDispatchListService;
import com.platform.springboot.utils.Result;
import com.platform.springboot.service.fdp.FdpFaultDispatchListService;
import io.swagger.annotations.ApiOperation;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author Chenliwen
 * @Date 2018/12/21 10:32
 **/
@RestController
@RequestMapping("/fdpFaultDispatchList")
public class FdpFaultDispatchListController {
    private Logger log = Logger.getLogger(FdpFaultReportInfoController.class);
    @Resource
    private FdpFaultDispatchListService service;

    @ApiOperation(
            value = "查询客服工单清单",
            notes = "查询客服工单清单",
            consumes = "application/json",
            responseReference = "com.platform.springboot.utils.Result")
    @RequestMapping(value = "/getProcessList", method = RequestMethod.POST)
    public Result getProcessListByObject(@RequestBody ParamFdpProcessDetailed param) {
        log.info("查询客服工单清单-开始,入参：param="+param);
        Result result = service.getProcessListByObject(param);
        log.info("查询客服工单清单-结束,出参:"+result.toString());
        return result;
    }

    @ApiOperation(
            value = "客服工单清单下载",
            notes = "客服工单清单下载",
            consumes = "application/json",
            responseReference = "com.platform.springboot.utils.Result")
    @RequestMapping(value = "/processListDownload", method = RequestMethod.POST)
    public Result processListDownload(@RequestBody ParamFdpProcessDetailed param) {
        log.info("客服工单清单下载-开始,入参：param="+param);
        Result result = service.processListDownload(param);
        log.info("客服工单清单下载-结束,出参:"+result.toString());
        return result;
    }

    @ApiOperation(
            value = "查询客服工单汇总",
            notes = "查询客服工单汇总",
            consumes = "application/json",
            responseReference = "com.platform.springboot.utils.Result")
    @RequestMapping(value = "/getProcesscollect", method = RequestMethod.POST)
    public Result getProcesscollectByObject(@RequestBody ParamFdpProcessDetailed param) {
        log.info("查询客服工单汇总-开始");
        Result result = service.getProcesscollectByObject(param);
        log.info("查询客服工单汇总-结束");
        return result;
    }

    @ApiOperation(
            value = "查询客服工单处理人汇总",
            notes = "查询客服工单处理人汇总",
            consumes = "application/json",
            responseReference = "com.platform.springboot.utils.Result")
    @RequestMapping(value = "/getProcessDealPersoncollect", method = RequestMethod.POST)
    public Result getProcessDealPersoncollectByObject(@RequestBody ParamFdpProcessDetailed param) {
        log.info("查询客服工单处理人汇总-开始");
        Result result = service.getProcessDealPersoncollectByObject(param);
        log.info("查询客服工单处理人汇总-结束");
        return result;
    }

    @ApiOperation(
            value = "查询客服工单雇主汇总",
            notes = "查询客服工单雇主汇总",
            consumes = "application/json",
            responseReference = "com.platform.springboot.utils.Result")
    @RequestMapping(value = "/getProcessDemandcollect", method = RequestMethod.POST)
    public Result getProcessDemandcollectByObject(@RequestBody ParamFdpProcessDetailed param) {
        log.info("查询客服工单雇主汇总-开始");
        Result result = service.getDemandcollectByObject(param);
        log.info("查询客服工单雇主汇总-结束");
        return result;
    }

    @ApiOperation(
            value = "客服工单汇总下载",
            notes = "查询客服工单雇主汇总",
            consumes = "application/json",
            responseReference = "com.platform.springboot.utils.Result")
    @RequestMapping(value = "/processCollectDownload", method = RequestMethod.POST)
    public Result processDownload(@RequestBody ParamFdpProcessDetailed param) {
        log.info("客服工单汇总下载-开始");
        Result result = service.processCollectDown(param);
        log.info("客服工单汇总下载-结束");
        return result;
    }

    @ApiOperation(
            value = "查询派工工单清单",
            notes = "查询客服工单雇主汇总",
            consumes = "application/json",
            responseReference = "com.platform.springboot.utils.Result")
    @RequestMapping(value = "/getFaultOrderRequestList", method = RequestMethod.POST)
    public Result getFaultOrderRequestListByObject(@RequestBody GetFaultDispatchRequestList getFaultDispatchRequestList) {
        log.info("查询符合条件的故障工单列表-开始");
        Result result = service.getFaultDispatchOrderRequestList(getFaultDispatchRequestList);
        log.info("查询符合条件的故障工单列表-结束");
        return result;
    }

    @ApiOperation(
            value = "派工清单导出",
            notes = "派工清单导出",
            consumes = "application/json",
            responseReference = "com.platform.springboot.utils.Result")
    @RequestMapping(value = "/exportFaultOrderRequestList", method = RequestMethod.POST)
    public Result exportFaultOrderRequestList(@RequestBody GetFaultDispatchRequestList getFaultDispatchRequestList) {
        log.info("派工清单导出-开始");;
        Result result = service.exportFaultOrderRequestList(getFaultDispatchRequestList);
        log.info("派工清单导出-结束");
        return result   ;
    }

    @ApiOperation(
            value = "查询派工工单统计",
            notes = "查询派工工单统计",
            consumes = "application/json",
            responseReference = "com.platform.springboot.utils.Result")
    @RequestMapping(value = "/getFaultOrderRequestCount", method = RequestMethod.POST)
    public Result getFaultOrderRequestCount(@RequestBody GetFaultDispatchRequestList getFaultDispatchRequestList) {
        log.info("查询派工工单统计-开始");
        Result result = service.getFaultOrderRequestCount(getFaultDispatchRequestList);
        log.info("查询派工工单统计-结束");
        return result;
    }

    @ApiOperation(
            value = "查询派工工单雇主统计",
            notes = "查询派工工单雇主统计",
            consumes = "application/json",
            responseReference = "com.platform.springboot.utils.Result")
    @RequestMapping(value = "/getFaultOrderRequestCountByDemand", method = RequestMethod.POST)
    public Result getFaultOrderRequestCountByDemand(@RequestBody GetFaultDispatchRequestList getFaultDispatchRequestList) {
        log.info("查询派工工单统计-开始");
        Result result = service.getFaultOrderRequestCountByDemand(getFaultDispatchRequestList);
        log.info("查询派工工单统计-结束");
        return result;
    }

    @ApiOperation(
            value = "查询派工工单创建人统计",
            notes = "查询派工工单创建人统计",
            consumes = "application/json",
            responseReference = "com.platform.springboot.utils.Result")
    @RequestMapping(value = "/getFaultOrderRequestCountByCreatePerson", method = RequestMethod.POST)
    public Result requestCountByCreatePerson(@RequestBody GetFaultDispatchRequestList getFaultDispatchRequestList) {
        log.info("查询派工工单创建人统计-开始");
        Result result = service.requestCountByCreatePerson(getFaultDispatchRequestList);
        log.info("查询派工工单创建人统计-结束");
        return result;
    }

    @ApiOperation(
            value = "派工汇总导出",
            notes = "派工汇总导出",
            consumes = "application/json",
            responseReference = "com.platform.springboot.utils.Result")
    @RequestMapping(value = "/exportFaultOrderRequestCount", method = RequestMethod.POST)
    public Result exportFaultOrderRequestCount(@RequestBody GetFaultDispatchRequestList getFaultDispatchRequestList) {
        log.info("派工汇总导出-开始");
        Result result = service.exportFaultOrderRequestCount(getFaultDispatchRequestList);
        log.info("派工汇总导出-结束");
        return result;
    }
}
