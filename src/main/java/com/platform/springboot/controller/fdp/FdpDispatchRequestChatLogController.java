package com.platform.springboot.controller.fdp;

import com.platform.springboot.entity.fdp.FdpDispatchRequestChatLog;
import com.platform.springboot.service.fdp.fdpDispatchRequestChatLogService;
import com.platform.springboot.utils.Result;
import com.platform.springboot.service.fdp.fdpDispatchRequestChatLogService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;


/**
 * @author zhanghao
 * @Title: FdpDispatchRequestChatLogController
 * @ProjectName WaterDrop
 * @Description: 派工消息
 * @date 2018/12/22下午2:18
 */
@RestController
@RequestMapping("/fdpDispatchRequestChatLog")
@Api(description = "派工消息")
public class FdpDispatchRequestChatLogController {

    private Logger log = Logger.getLogger(FdpDispatchRequestChatLogController.class);

    @Resource
    private fdpDispatchRequestChatLogService service;

    @ApiOperation(value = "新增调整信息", httpMethod = "POST")
    @PostMapping(value = "/handle")
    public Result handle(@RequestBody FdpDispatchRequestChatLog request) {
        log.info("新增调整信息-开始");
        Result result = service.handle(request);
        log.info("新增调整信息-结束");
        return result;
    }

    @ApiOperation(value = "查询派工信息", httpMethod = "POST")
    @PostMapping(value = "/list")
    public Result getFaultOrderRequestListByObject(@RequestBody FdpDispatchRequestChatLog request) {
        log.info("查询派工信息-开始");
        Result result = service.list(request);
        log.info("查询派工信息-结束");
        return result;
    }

    @ApiOperation(value = "查询未读信息列表", httpMethod = "GET")
    @GetMapping(value = "/listLast")
    public Result listLast() {
        log.info("查询未读信息列表-开始");
        Result result = service.listLast();
        log.info("查询未读信息列表-结束");
        return result;
    }

    @ApiOperation(value = "设置沟通消息已读", httpMethod = "GET")
    @GetMapping(value = "/setRead")
    public Result setRead(@RequestParam Integer requestId) {
        log.info("设置沟通消息已读-开始");
        Result result = service.setRead(requestId);
        log.info("设置沟通消息已读-结束");
        return result;
    }


    @ApiOperation(value = "设置非本人发送沟通消息已读", httpMethod = "GET")
    @GetMapping(value = "/setReadNotSend")
    public Result setReadNotSend(@RequestParam Integer requestId) {
        log.info("设置非本人发送沟通消息已读-开始");
        Result result = service.setReadNotSend(requestId);
        log.info("设置非本人发送沟通消息已读-结束");
        return result;
    }

}
