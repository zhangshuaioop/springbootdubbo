package com.teekee.blackrockservice.controller.fdp;

import com.alibaba.fastjson.JSON;
import com.teekee.blackrockservice.base.BaseController;
import com.teekee.blackrockservice.entity.fdp.*;
import com.teekee.blackrockservice.service.fdp.FdpFaultDispatchOrderService;
import com.teekee.blackrockservice.utils.ResponseMessage;
import com.teekee.blackrockservice.utils.StringUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @Author Niting
 * @date 2018/11/3
 **/
@Api(value = "FdpFaultDispatchOrderController", tags = "dispatchOrder-service")
@RestController
@RequestMapping("/serv/order")
public class FdpFaultDispatchOrderController extends BaseController{
    private Logger log = Logger.getLogger(FdpFaultDispatchOrderController.class);
    @Resource
    FdpFaultDispatchOrderService service;

    @ApiOperation(value = "接单状态数量统计", notes = "接单状态数量统计", consumes = "application/json", responseReference = "com.example.timemachine.utils.Result")
    @GetMapping(value = "/statusCollect")
    public String statusCollect(HttpServletRequest request) {
        Integer hrId = getTokenFromHead(request);
        log.info("接单状态数量统计-开始");
        List<GetDispatchOrderServiceStatusList> result = service.statusCollect(hrId);
        log.info("接单状态数量统计-结束");
        return build(StringUtil.buildJsonSucessRespMsg(result));
    }

    @ApiOperation(value = "显示工作内容", notes = "显示工作内容", consumes = "application/json", responseReference = "com.example.timemachine.utils.Result")
    @GetMapping(value = "/dispatchDescriptionList")
    public String dispatchDescriptionList(@RequestParam("orderId") Integer orderId , HttpServletRequest request) {
        Integer hrId = getTokenFromHead(request);
        log.info("显示工作内容-开始");
        FdpDispatchJobPerformanceList result = service.dispatchDescriptionList(orderId);
        log.info("显示工作内容-结束");
        return build(StringUtil.buildJsonSucessRespMsg(result));
    }

    @ApiOperation(value = "暂存工作内容", notes = "暂存工作内容", consumes = "application/json", responseReference = "com.example.timemachine.utils.Result")
    @PostMapping(value = "/updateDispatchDescription")
    public String updateDispatchDescription(@RequestBody FdpDispatchJobPerformanceList param, HttpServletRequest request) {
        Integer hrId = getTokenFromHead(request);
        log.info("暂存工作内容-开始");
        ResponseMessage result = service.updateDispatchDescription(param);
        log.info("暂存工作内容-结束");
        return build(result);
    }

    @ApiOperation(value = "完成工作内容", notes = "完成工作内容", consumes = "application/json", responseReference = "com.example.timemachine.utils.Result")
    @PostMapping(value = "/completeDescription")
    public String completeDescription(@RequestBody String Json, HttpServletRequest request) {
        Integer hrId = getTokenFromHead(request);
        log.info("完成工作内容-开始");
        FdpDispatchJobPerformanceList DispatchDescriptionList = JSON.parseObject(Json, FdpDispatchJobPerformanceList.class);
        FdpFaultDispatchHrRelation hrRelation = JSON.parseObject(Json, FdpFaultDispatchHrRelation.class);
        ResponseMessage result = service.completeDescription(DispatchDescriptionList,hrRelation);
        log.info("完成工作内容-结束");
        return build(result);
    }

    @ApiOperation(value = "待完工资料查询", notes = "待完工资料查询", consumes = "application/json", responseReference = "com.example.timemachine.utils.Result")
    @GetMapping(value = "/queryFinishShow")
    public String queryFinishShow(@RequestParam("id") Integer id){
        log.info("待完工资料查询-开始");
        GetFdpDispatchHrRelationFinishShow result = service.queryFinishShow(id);
        log.info("待完工资料查询-结束");
        return build(StringUtil.buildJsonSucessRespMsg(result));
    }

    @ApiOperation(value = "提交完工资料", notes = "提交完工资料", consumes = "application/json", responseReference = "com.example.timemachine.utils.Result")
    @PostMapping(value = "/completeData")
    public String completeData(@RequestBody FdpFaultDispatchHrRelation param, HttpServletRequest request){
        log.info("提交完工资料-开始");
        Integer hrId = getTokenFromHead(request);
        ResponseMessage result = service.handleCompleteData(param,hrId);
        log.info("提交完工资料-结束");
        return build(result);
    }


    @ApiOperation(value = "开始出发", notes = "开始出发", consumes = "application/json", responseReference = "com.example.timemachine.utils.Result")
    @GetMapping(value = "/orderStart")
    public String orderStart(@RequestParam("id") Integer id) {
        log.info("开始出发-开始");
        ResponseMessage result = service.orderStart(id);
        log.info("开始出发-结束");
        return build(result);
    }

    @ApiOperation(value = "工单详情", notes = "工单详情", consumes = "application/json", responseReference = "com.example.timemachine.utils.Result")
    @GetMapping(value = "/orderInfo")
    public String orderInfo(@RequestParam("id") Integer id) {
        log.info("工单详情-开始");
        FdpFaultDispatchOrderList result = service.orderInfo(id);
        log.info("工单详情-结束");
        return build(StringUtil.buildJsonSucessRespMsg(result));
    }

    @ApiOperation(value = "查看流程历史记录版本时间点", notes = "查看流程历史记录版本时间点",consumes = "application/json",responseReference = "com.example.timemachine.utils.Result" )
    @GetMapping(value = "/orderHistoryTime")
    public String orderHistoryTime(@RequestParam("orderId") int orderId){
        log.info("查看流程历史记录版本时间点-开始");
        List<FdpDispatchJobPerformance> result = service.orderHistoryTime(orderId);
        log.info("查看流程历史记录版本时间点-结束");
        return build(StringUtil.buildJsonSucessRespMsg(result));
    }

    @ApiOperation(value = "查看流程历史记录", notes = "查看流程历史记录",consumes = "application/json",responseReference = "com.example.timemachine.utils.Result" )
    @PostMapping(value = "/orderHistory")
    public String orderHistory(@RequestBody FdpDispatchJobPerformance jobPerformance, HttpServletRequest request){
        log.info("查看流程历史记录-开始");
        List<FdpDispatchJobPerformance> result = service.orderHistory(jobPerformance);
        log.info("查看流程历史记录-结束");
        return build(StringUtil.buildJsonSucessRespMsg(result));
    }

    @ApiOperation(value = "工单开始处理", notes = "工单开始处理", consumes = "application/json", responseReference = "com.example.timemachine.utils.Result")
    @GetMapping(value = "/serviceStart")
    public String serviceStart(@RequestParam("id") Integer id) {
        log.info("工单开始处理-开始");
        ResponseMessage result = service.serviceStart(id);
        log.info("工单开始处理-结束");
        return build(result);
    }

    @ApiOperation(value = "确认接单", notes = "确认接单", consumes = "application/json", responseReference = "com.example.timemachine.utils.Result")
    @GetMapping(value = "/orderReceiving")
    public String orderReceiving(@RequestParam("id") Integer orderId) {
        log.info("确认接单-开始");
        ResponseMessage result = service.orderReceiving(orderId);
        log.info("确认接单-结束");
        return build(result);
    }
}
