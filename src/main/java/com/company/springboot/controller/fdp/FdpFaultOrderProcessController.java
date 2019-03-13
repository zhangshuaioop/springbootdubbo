package com.company.springboot.controller.fdp;

import com.company.springboot.entity.fdp.FdpFaultOrderProcess;
import com.company.springboot.entity.fdp.GetFaultOrderListRequest;
import com.company.springboot.service.fdp.FdpFaultOrderProcessService;
import com.company.springboot.utils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;

/**
 * @author zhanghao
 * @Title: FdpFaultOrderProcessController
 * @ProjectName WaterDrop
 * @Description: 报障工单
 * @date 2019/1/11上午10:19
 */
@RestController
@RequestMapping("/fdpFaultOrderProcess")
@Api(description = "报障工单")
public class FdpFaultOrderProcessController {

    private Logger log = Logger.getLogger(Logger.class);

    @Resource
    private FdpFaultOrderProcessService fdpFaultOrderProcessService;


    @ApiOperation(value = "查询符合条件的故障工单列表", httpMethod = "POST")
    @PostMapping(value = "/getFaultOrderListByObject")
    public Result getFaultOrderListByObject(@RequestBody GetFaultOrderListRequest request) {
        log.info("查询符合条件的故障工单列表-开始 入参：" + request);
        Result result = fdpFaultOrderProcessService.getFaultOrderListByObject(request);
        log.info("查询符合条件的故障工单列表-结束");
        return result;
    }

    @ApiOperation(value = "查询故障单下所有信息列表", httpMethod = "GET")
    @GetMapping(value = "/getFaultOrderListByRootId")
    public Result getFaultOrderListByRootId(@RequestParam Integer rootId) {
        log.info("查询故障单下所有信息列表-开始 入参：rootId：" + rootId);
        Result result = fdpFaultOrderProcessService.getFaultOrderListByRootId(rootId);
        log.info("查询故障单下所有信息列表-结束");
        return result;
    }

    @ApiOperation(value = "显示完整的报障信息", httpMethod = "GET")
    @GetMapping(value = "/show")
    public Result show(@RequestParam Integer id) {
        log.info("查看指定报障信息-开始 入参 id:" + id);
        Result result = fdpFaultOrderProcessService.show(id);
        log.info("查看指定报障信息-结束");
        return result;
    }

    @ApiOperation(value = "报障确认信息", httpMethod = "GET")
    @GetMapping(value = "/confirm")
    public Result confirm(@RequestParam Integer id, @RequestParam Integer rootId) {
        log.info("报障确认信息-开始 入参：id：" + id + " rootId：" + rootId);
        Result result = fdpFaultOrderProcessService.confirm(id, rootId);
        log.info("报障确认信息-结束");
        return result;
    }

    @ApiOperation(value = "取消故障工单", httpMethod = "POST")
    @PostMapping(value = "/cancel")
    public Result cancel(@RequestBody FdpFaultOrderProcess fdpFaultOrderProcess) {
        log.info("取消故障工单-开始 入参：" + fdpFaultOrderProcess.toString());
        Result result = fdpFaultOrderProcessService.cancel(fdpFaultOrderProcess);
        log.info("取消故障工单-结束");
        return result;
    }

    @ApiOperation(value = "查询报障粗略信息", httpMethod = "GET")
    @GetMapping(value = "/showFaultInfo")
    public Result showNew(@RequestParam Integer id) {
        log.info("查询报障粗略信息-开始 入参：id:" + id);
        Result result = fdpFaultOrderProcessService.showFaultInfo(id);
        log.info("查询报障粗略信息-结束");
        return result;
    }

    @ApiOperation(value = "故障工单删除", httpMethod = "POST", notes = "故障工单删除")
    @PostMapping(value = "/deleteFaultProcess")
    public Result deleteFaultProcess(@RequestBody HashMap<String, Object> reqJsonMap) {
        log.info("故障工单删除-开始");
        Result result = fdpFaultOrderProcessService.deleteProcessById(reqJsonMap);
        log.info("故障工单删除-结束");
        return result;
    }

    @ApiOperation(value = "所属人更改", httpMethod = "POST", notes = "所属人更改")
    @PostMapping(value = "/belongPersonTransmit")
    public Result belongPersonTransmit(@RequestBody HashMap<String, Object> reqJsonMap) {
        log.info("所属人更改-开始 入参 reqJsonMap：" + reqJsonMap);
        Result result = fdpFaultOrderProcessService.updateBelongPersonId(reqJsonMap);
        log.info("所属人更改-结束");
        return result;
    }

    @ApiOperation(value = "处理人转发", httpMethod = "POST", notes = "处理人转发")
    @PostMapping(value = "/dealPersonTransmit")
    public Result dealPersonTransmit(@RequestBody HashMap<String, Object> reqJsonMap) {
        log.info("处理人转发-开始 入参：reqJsonMap：" + reqJsonMap);
        Result result = fdpFaultOrderProcessService.updateDealPerson(reqJsonMap);
        log.info("处理人转发-结束");
        return result;
    }

    @ApiOperation(value = "新增/编辑故障信息", httpMethod = "POST")
    @PostMapping(value = "/handle")
    public Result handle(@RequestBody FdpFaultOrderProcess process) {
        log.info("新增/编辑故障信息-开始");
        Result result = fdpFaultOrderProcessService.handle(process);
        log.info("新增/编辑故障信息-结束");
        return result;
    }
}
