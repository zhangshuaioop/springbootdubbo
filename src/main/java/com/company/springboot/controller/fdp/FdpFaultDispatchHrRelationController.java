package com.company.springboot.controller.fdp;

import com.company.springboot.entity.fdp.FdpFaultDispatchHrRelation;
import com.company.springboot.service.fdp.FdpDispatchHrRelationService;
import com.company.springboot.utils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author zhanghao
 * @Title: FdpFaultDispatchHrRelationController
 * @ProjectName WaterDrop
 * @Description: 完工资料
 * @date 2018/12/22上午11:25
 */
@RestController
@RequestMapping("/fdpFaultDispatchHrRelation")
@Api(description = "完工资料")
public class FdpFaultDispatchHrRelationController {

    private Logger log = Logger.getLogger(FdpFaultDispatchHrRelationController.class);

    @Resource
    private FdpDispatchHrRelationService fdpDispatchHrRelationService;

    @ApiOperation(value = "查看完工资料", httpMethod = "GET")
    @GetMapping(value = "/profileLogShow")
    public Result profileLogShow(@RequestParam Integer dispatchOrderId) {
        log.info("查看完工资料-开始 入参：dispatchOrderId：" + dispatchOrderId);
        Result result = fdpDispatchHrRelationService.profileLogShow(dispatchOrderId);
        log.info("查看完工资料-结束");
        return result;
    }

    @ApiOperation(value = "采购补充完工资料", httpMethod = "POST", notes = "采购补充完工资料")
    @PostMapping(value = "/extendProfile")
    public Result extendProfile(@RequestBody String json) {
        log.info("采购补充完工资料-开始 入参：json：" + json);
        Result result = fdpDispatchHrRelationService.extendProfile(json);
        log.info("采购补充完工资料-结束");
        return result;
    }

    @ApiOperation(value = "修改派工人员", httpMethod = "POST", notes = "修改派工人员")
    @PostMapping(value = "/changeDispatchHr")
    public Result changeDispatchHr(@RequestBody FdpFaultDispatchHrRelation hrRelation) {
        log.info("修改派工人员-开始 入参：hrRelation：" + hrRelation.toString());
        Result result = fdpDispatchHrRelationService.changeDispatchHr(hrRelation);
        log.info("修改派工人员-结束");
        return result;
    }

    @ApiOperation(value = "修改派工费用", httpMethod = "POST", notes = "修改派工费用")
    @PostMapping(value = "/changeDispatchCost")
    public Result changeDispatchCost(@RequestBody FdpFaultDispatchHrRelation hrRelation) {
        log.info("修改派工费用-开始入参：hrRelation：" + hrRelation.toString());
        Result result = fdpDispatchHrRelationService.changeDispatchCost(hrRelation);
        log.info("修改派工费用-结束");
        return result;
    }

    @ApiOperation(value = "查看补充完工资料",httpMethod = "GET",notes = "查看补充完工资料")
    @GetMapping(value = "/showExtendProfile")
    public Result showExtendProfile(@RequestParam Integer dispatchOrderId){
        log.info("查看补充完工资料-开始 入参：dispatchOrderId："+dispatchOrderId);
        Result result = fdpDispatchHrRelationService.showExtendProfile(dispatchOrderId);
        log.info("查看补充完工资料-结束");
        return result;
    }

    @ApiOperation(value = "控制是否显示服务商信息", httpMethod = "POST", notes = "修改派工费用")
    @PostMapping(value = "/changeFlagDispatch")
    public Result changeFlagDispatch(@RequestBody FdpFaultDispatchHrRelation hrRelation) {
        log.info("控制是否显示服务商信息-开始 入参："+hrRelation.toString());
        Result result = fdpDispatchHrRelationService.changeFlagDispatch(hrRelation);
        log.info("控制是否显示服务商信息-结束");
        return result;
    }

    @ApiOperation(value = "查询服务商修改时间记录", notes = "查询修改时间记录")
    @GetMapping(value = "/findServiceTime")
    public Result selectServiceTimeLog(@RequestParam Integer orderId) {
        log.info("查询服务商修改时间记录-开始");
        Result result = fdpDispatchHrRelationService.selectServiceTime(orderId);
        log.info("查询服务商修改时间记录-结束");
        return result;
    }
}
