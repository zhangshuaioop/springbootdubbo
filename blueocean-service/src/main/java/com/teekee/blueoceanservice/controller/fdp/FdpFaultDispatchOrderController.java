package com.teekee.blueoceanservice.controller.fdp;

import com.teekee.blueoceanservice.entity.fdp.*;
import com.teekee.blueoceanservice.service.fdp.FdpFaultDispatchOrderService;
import com.teekee.commoncomponets.utils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

/**
 * @author zhanghao
 * @Title: FdpFaultDispatchOrderController
 * @ProjectName BlueOcean
 * @Description: 采购工单
 * @date 2018/12/29上午10:41
 */
@Api(description = "采购工单")
@RestController
@RequestMapping("/fdpFaultDispatchOrder")
public class FdpFaultDispatchOrderController {

    private Logger log = Logger.getLogger(FdpFaultDispatchOrderController.class);

    @Resource
    private FdpFaultDispatchOrderService service;


    @ApiOperation(value = "服务商工单列表", httpMethod = "POST", notes = "服务商工单列表")
    @PostMapping(value = "/serOrderList")
    public Result serOrderList(@RequestBody ParamServiceDispatchOrder param) {
        log.info("服务商工单列表-开始 入参:"+param.toString());
        Result result = service.serOrderList(param);
        log.info("服务商工单列表-结束");
        return result;
    }

    @ApiOperation(value = "服务商查看工单信息", httpMethod = "GET", notes = "服务商查看工单信息")
    @GetMapping(value = "/serOrderShow")
    public Result serOrderShow(@RequestParam Integer orderId) {
        log.info("服务商查看工单信息-开始");
        Result result = service.serOrderShow(orderId);
        log.info("服务商查看工单信息-结束");
        return result;
    }

    @ApiOperation(value = "确认派工", httpMethod = "POST")
    @PostMapping(value = "/confirmDispatch")
    public Result confirmDispatch(@RequestBody FdpFaultOrderInsertParam insertParam) {
        log.info("确认派工-开始");
        Result result = service.confirmDispatch(insertParam);
        log.info("确认派工-结束");
        return result;
    }

    @ApiOperation(value = "查询符合条件的派工工单列表", httpMethod = "POST")
    @PostMapping(value = "/getOrderListByObject")
    public Result getOrderListByObject(@RequestBody GetDispatchOrderListRequest getDispatchOrderListRequest) {
        log.info("查询符合条件的派工工单列表-开始 入参："+getDispatchOrderListRequest.toString());
        Result result = service.getOrderListByObject(getDispatchOrderListRequest);
        log.info("查询符合条件的派工工单列表-结束");
        return result;
    }

    @ApiOperation(value = "查看采购订单信息", httpMethod = "GET")
    @GetMapping(value = "/showFile")
    public Result showFile(@RequestParam Integer requestId) {
        log.info("查看采购订单信息-开始");
        Result result= service.showFile(requestId);
        log.info("查看采购订单信息-结束");
        return result;
    }

    @ApiOperation(value = "采购信息确认", httpMethod = "POST")
    @PostMapping(value = "/dispatchNeedConfirm")
    public Result dispatchNeedConfirm(@RequestBody FdpFaultDispatchOrder fdpFaultDispatchOrder) {
        log.info("派工信息确认-开始");
        Result result = service.dispatchNeedConfirm(fdpFaultDispatchOrder);
        log.info("派工信息确认-结束");
        return result;
    }

    @ApiOperation(value = "提交完工资料", httpMethod = "POST", notes = "提交完工资料")
    @PostMapping(value = "/completeConfirm")
    public Result completeConfirm(@RequestBody ParamCompleteConfirm paramCompleteConfirm) {
        log.info("提交完工资料-开始 入参："+paramCompleteConfirm.toString());
        Result result = service.confirmDispatchComplete(paramCompleteConfirm);
        log.info("提交完工资料-结束");
        return result;
    }

    @ApiOperation(value = "采购确认实际售价", httpMethod = "POST", notes = "采购确认实际售价")
    @PostMapping(value = "/confirmActualPrice")
    public Result confirmActualPrice(@RequestBody ParamCompleteConfirm paramCompleteConfirm) {
        log.info("采购确认实际售价-开始入参："+paramCompleteConfirm.toString());
        Result result = service.confirmActualPrice(paramCompleteConfirm);
        log.info("采购确认实际售价-结束");
        return result;
    }

    @ApiOperation(value = "采购完工确认", httpMethod = "POST", notes = "采购完工确认")
    @PostMapping(value = "/purchaseFinishConfirm")
    public Result purchaseFinishConfirm(@RequestBody String json) {
        log.info("采购完工确认-开始 入参："+json);
        Result result = service.purchaseFinishConfirm(json);
        log.info("采购完工确认-结束");
        return result;
    }

    @ApiOperation(value = "放弃派工", httpMethod = "POST")
    @PostMapping(value = "/abandonDispatch")
    public Result abandonDispatch(@RequestBody FdpFaultDispatchOrder dispatchAbandon) {
        log.info("放弃派工-开始 入参："+dispatchAbandon.toString());
        Result result = service.abandonDispatch(dispatchAbandon);
        log.info("放弃派工-结束");
        return result;
    }

    @ApiOperation(value = "采购转发", httpMethod = "POST", notes = "采购转发")
    @PostMapping(value = "/dealPersonTransmit")
    public Result dispatchTransmit(@RequestBody HashMap<String, Object> reqJsonMap) {
        log.info("派工转发-开始");
        Result result = service.dispatchTransmit(reqJsonMap);
        log.info("派工转发-结束");
        return result;
    }

    @ApiOperation(value = "管理员开放完工资料", httpMethod = "POST", notes = "管理员开放完工资料")
    @PostMapping(value = "/disparkProfile")
    public Result disparkProfile(@RequestBody HashMap<String, List<Integer>> reqJsonMap) {
        log.info("管理员开放完工资料-开始");
        Result result = service.disparkProfile(reqJsonMap);
        log.info("管理员开放完工资料-结束");
        return result;
    }

}
