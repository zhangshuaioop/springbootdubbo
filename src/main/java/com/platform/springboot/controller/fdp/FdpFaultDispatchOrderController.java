package com.platform.springboot.controller.fdp;

import com.platform.springboot.entity.fdp.FdpFaultDispatchOrder;
import com.platform.springboot.entity.fdp.ParamCompleteConfirm;
import com.platform.springboot.service.fdp.FdpFaultDispatchOrderService;
import com.platform.springboot.utils.Result;
import com.platform.springboot.service.fdp.FdpFaultDispatchOrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author zhanghao
 * @Title: FdpFaultDispatchOrderController
 * @ProjectName WaterDrop
 * @Description: 派工订单
 * @date 2018/12/21下午2:30
 */
@RestController
@RequestMapping("/fdpFaultDispatchOrder")
@Api(description = "派工订单")
public class FdpFaultDispatchOrderController {

    private Logger log = Logger.getLogger(FdpFaultDispatchOrderController.class);

    @Resource
    private FdpFaultDispatchOrderService service;

    @ApiOperation(value = "取消派工", httpMethod = "POST", notes = "采购取消派工")
    @PostMapping(value = "/confirmDispatchCancel")
    public Result confirmDispatchCancel(@RequestBody FdpFaultDispatchOrder dispatchCancel) {
        log.info("取消派工-开始");
        Result result = service.confirmDispatchCancel(dispatchCancel);
        log.info("取消派工-结束");
        return result;
    }

    @ApiOperation(value = "客户派工完工确认", httpMethod = "POST", notes = "客户派工完工确认")
    @PostMapping(value = "/customerFinishConfirm")
    public Result customerFinishConfirm(@RequestBody ParamCompleteConfirm paramCompleteConfirm) {
        log.info("客户派工完工确认-开始");
        Result result = service.customerFinishConfirm(paramCompleteConfirm);
        log.info("客户派工完工确认-结束");
        return result;
    }

    @ApiOperation(value="客户驳回完工资料",httpMethod = "GET",notes = "id 对应 requestId")
    @GetMapping(value = "/rebutComplete")
    public Result rebutComplete(@RequestParam Integer id){
        log.info("客户驳回完工资料-开始");
        Result result = service.rebutComplete(id);
        log.info("客户驳回完工资料-结束");
        return result;
    }

    @ApiOperation(value = "不使用已派工人员", httpMethod = "GET")
    @GetMapping(value = "/dispatchHrInfoDeny")
    public Result dispatchHrInfoDeny(@RequestParam Integer faultDispatchRequestId) {
        log.info("不使用已派工人员-开始");
        Result result = service.cancelDispatchPerson(faultDispatchRequestId);
        log.info("不使用已派工人员-结束");
        return result;
    }

    @ApiOperation(value = "确认使用已派工人员", httpMethod = "GET")
    @GetMapping(value = "/dispatchHrInfoConfirm")
    public Result dispatchHrInfoConfirm(@RequestParam Integer faultDispatchRequestId) {
        log.info("确认使用已派工人员-开始");
        Result result = service.confirmDispatchPerson(faultDispatchRequestId);
        log.info("确认使用已派工人员-结束");
        return result;
    }


}
