package com.company.springboot.controller.wp;

import com.company.springboot.entity.wp.WpApproval;
import com.company.springboot.entity.wp.WpCfgFrameProcess;
import com.company.springboot.entity.wp.WpProcessOperateLog;
import com.company.springboot.service.wp.WpCfgFrameProcessService;
import com.company.springboot.utils.RedisUtil;
import com.company.springboot.utils.Result;
import com.company.springboot.utils.ResultUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author zhanghao
 * @Title: WpCfgFrameProcessController
 * @ProjectName WaterDrop
 * @Description: 框架流程
 * @date 2019/1/24下午1:35
 */
@RestController
@RequestMapping("/wpCfgFrameProcess")
@Api(description = "框架流程")
public class WpCfgFrameProcessController {

    private Logger log = Logger.getLogger(Logger.class);

    @Resource
    private WpCfgFrameProcessService wpCfgFrameProcessService;


    @ApiOperation(value = "框架流程列表(分页)", httpMethod = "POST", notes = "框架流程列表")
    @PostMapping(value = "/pageList")
    public Result pageList(@RequestBody WpCfgFrameProcess wpCfgFrameProcess) {
        log.info("框架流程列表(分页)-开始 入参："+wpCfgFrameProcess.toString());
        Result result = wpCfgFrameProcessService.list(wpCfgFrameProcess);
        log.info("框架流程列表(分页)-结束");
        return result;
    }



    @ApiOperation(
            value = "框架流程列表",
            notes = "框架流程列表",
            consumes = "application/json",
            responseReference = "com.company.springboot.utils.Result"
    )
    @SuppressWarnings("unchecked")
    @RequestMapping(value = "/findList",method=RequestMethod.GET)
    public Result findList() {
        log.info("框架流程列表开始,入参:无");
        Result result = wpCfgFrameProcessService.findList();
        log.info("框架流程列表结束,出参:"+result.toString());
        return result;
    }



    @ApiOperation(value = "新增框架流程", httpMethod = "POST", notes = "新增框架流程")
    @PostMapping(value = "/handle")
    public Result handle(@RequestBody WpCfgFrameProcess wpCfgFrameProcess) {
        log.info("新增框架流程-开始 入参："+wpCfgFrameProcess.toString());
        Result result = wpCfgFrameProcessService.handle(wpCfgFrameProcess);
        log.info("新增框架流程-结束");
        return result;
    }



    @ApiOperation(value = "下一处理人", httpMethod = "GET", notes = "下一处理人")
    @GetMapping(value = "/nextDeal")
    public Result nextDeal(@RequestParam Integer orderId ,@RequestParam Integer frameProcessId) {
        log.info("下一处理人-开始 入参：orderId:"+orderId+",frameProcessId:"+frameProcessId);
        Result result = wpCfgFrameProcessService.nextDeal(orderId,frameProcessId);
        log.info("下一处理人-结束");
        return ResultUtil.success(result);
    }



    @ApiOperation(value = "上一处理人", httpMethod = "GET", notes = "上一处理人")
    @GetMapping(value = "/topDeal")
    public Result topDeal(@RequestParam Integer orderId ,@RequestParam Integer frameProcessId) {
        log.info("上一处理人-开始 入参：orderId:"+orderId+",frameProcessId:"+frameProcessId);
        Result result = wpCfgFrameProcessService.topDeal(orderId,frameProcessId);
        log.info("上一处理人-结束");
        return ResultUtil.success(result);
    }



    @ApiOperation(value = "流程审核", httpMethod = "POST", notes = "流程审核")
    @PostMapping(value = "/approval")
    public Result approval(@RequestBody WpApproval wpApproval) {
        log.info("流程审核-开始 入参："+wpApproval.toString());
        Result map = wpCfgFrameProcessService.approval(wpApproval);
        log.info("流程审核-结束");
        return ResultUtil.success(map);
    }



    @ApiOperation(value = "分页查询框架流程日志记录", httpMethod = "POST", notes = "流程审核")
    @PostMapping(value = "/frameLog")
    public Result frameLog(@RequestBody WpProcessOperateLog wpProcessOperateLog) {
        log.info("分页查询框架流程日志记录-开始 入参："+wpProcessOperateLog.toString());
        Result map = wpCfgFrameProcessService.frameLog(wpProcessOperateLog);
        log.info("分页查询框架流程日志记录-结束");
        return ResultUtil.success(map);
    }


    @ApiOperation(value = "根据key删除redis", httpMethod = "GET", notes = "根据key删除redis")
    @GetMapping(value = "/deleteRedisByKey")
    public Result frameLog(@RequestParam String key) {
        log.info("根据key删除redis-开始 入参："+key);
        RedisUtil.delete(key);
        log.info("根据key删除redis-结束");
        return ResultUtil.success();
    }
}
