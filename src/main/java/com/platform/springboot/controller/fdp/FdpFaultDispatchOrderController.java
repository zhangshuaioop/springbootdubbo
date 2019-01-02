package com.platform.springboot.controller.fdp;

import com.alibaba.fastjson.JSON;
import com.platform.springboot.entity.fdp.FdpFaultOrderInsertParam;
import com.platform.springboot.entity.fdp.ParamServiceDispatchOrder;
import com.platform.springboot.service.fdp.FdpFaultDispatchOrderService;
import com.platform.springboot.utils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author zhanghao
 * @Title: FdpFaultDispatchOrderController
 * @ProjectName BlueOcean
 * @Description: 派工工单
 * @date 2018/12/29上午10:41
 */
@Api(description = "派工工单")
@RestController
@RequestMapping("/fdpFaultDispatchOrder")
public class FdpFaultDispatchOrderController {

    private Logger log = Logger.getLogger(FdpFaultDispatchOrderController.class);

    @Resource
    private FdpFaultDispatchOrderService service;


    @ApiOperation(value = "服务商工单列表", httpMethod = "POST", notes = "服务商工单列表")
    @PostMapping(value = "/serOrderList")
    public Result serOrderList(@RequestBody ParamServiceDispatchOrder param) {
        log.info("服务商工单列表-开始 入参:"+param);
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
}
