package com.platform.springboot.controller.fdp;

import com.platform.springboot.entity.fdp.GetFaultDispatchRequestList;
import com.platform.springboot.entity.fdp.GetFdpFaultdispatchOrderList;
import com.platform.springboot.service.fdp.FdpFaultDispatchListService;
import com.platform.springboot.utils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author zhanghao
 * @Title: FdpFaultDispatchListController
 * @ProjectName BlueOcean
 * @Description: 采购清单
 * @date 2019/1/9下午4:02
 */
@Api(description = "采购清单")
@RestController
@RequestMapping("/fdpFaultDispatchList")
public class FdpFaultDispatchListController {

    private Logger log = Logger.getLogger(Logger.class);
    @Resource
    private FdpFaultDispatchListService fdpFaultDispatchListService;


    @ApiOperation(value = "查询采购工单清单", httpMethod = "POST")
    @PostMapping(value = "/getFaultOrderList")
    public Result getFaultOrderListByObject(@RequestBody GetFdpFaultdispatchOrderList getFdpFaultdispatchOrderList) {
        log.info("查询采购工单清单-开始 入参：getFdpFaultdispatchOrderList：" + getFdpFaultdispatchOrderList.toString());
        Result result = fdpFaultDispatchListService.getFaultDispatchOrderList(getFdpFaultdispatchOrderList);
        log.info("查询采购工单清单-结束");
        return result;
    }

    @ApiOperation(value = "采购清单导出", httpMethod = "POST", notes = "采购清单导出")
    @PostMapping(value = "/exportFaultOrderList")
    public Result exportFaultOrderList(@RequestBody GetFdpFaultdispatchOrderList getFdpFaultdispatchOrderList) {
        log.info("采购清单导出-开始 入参："+getFdpFaultdispatchOrderList.toString());
        Result result = fdpFaultDispatchListService.exportFaultOrderList(getFdpFaultdispatchOrderList);
        log.info("采购清单导出-结束");
        return result;
    }


    @ApiOperation(value = "采购汇总导出", httpMethod = "POST", notes = "采购汇总导出")
    @PostMapping(value = "/exportFaultOrderCount")
    public Result exportFaultOrderCount(@RequestBody GetFaultDispatchRequestList getFaultDispatchRequestList) {
        log.info("采购汇总导出-入参："+getFaultDispatchRequestList.toString());
        Result result = fdpFaultDispatchListService.exportFaultOrderCount(getFaultDispatchRequestList);
        log.info("采购汇总导出-结束");
        return result;
    }

    @ApiOperation(value = "查询采购工单统计", httpMethod = "POST")
    @PostMapping(value = "/getFaultOrderCount")
    public Result getFaultOrderCount(@RequestBody GetFaultDispatchRequestList getFaultDispatchRequestList) {
        log.info("查询采购工单统计-开始 "+getFaultDispatchRequestList.toString());
        Result result = fdpFaultDispatchListService.getFaultOrderCount(getFaultDispatchRequestList);
        log.info("查询采购工单统计-结束");
        return result;
    }

    @ApiOperation(value = "查询采工单雇主统计", httpMethod = "POST")
    @PostMapping(value = "/getFaultOrderCountByDemand")
    public Result getFaultOrderCountByDemand(@RequestBody GetFaultDispatchRequestList getFaultDispatchRequestList) {
        log.info("查询采工单雇主统计-开始 "+getFaultDispatchRequestList.toString());
        Result result = fdpFaultDispatchListService.getFaultOrderCountByDemand(getFaultDispatchRequestList);
        log.info("查询采工单雇主统计-结束");
        return result;
    }


    @ApiOperation(value = "查询采购工单处理人主统计", httpMethod = "POST")
    @PostMapping(value = "/getFaultOrderCountByDealPerson")
    public Result getFaultOrderCountByDealPerson(@RequestBody GetFaultDispatchRequestList getFaultDispatchRequestList) {
        log.info("查询采购工单处理人主统计-开始 "+getFaultDispatchRequestList.toString());
        Result result = fdpFaultDispatchListService.getFaultOrderCountByDealPerson(getFaultDispatchRequestList);
        log.info("查询采购工单处理人主统计-结束");
        return result;
    }

}

