package com.teekee.blueoceanservice.controller.fdp;//package com.teekee.blueoceanservice.controller.fdp;
//
//import com.teekee.blueoceanservice.entity.fdp.FdpFaultDispatchHrRelation;
//import com.teekee.blueoceanservice.service.fdp.FdpDispatchHrRelationService;
//import com.teekee.commoncomponets.utils.Result;
//import io.swagger.annotations.Api;
//import io.swagger.annotations.ApiOperation;
//import org.apache.log4j.Logger;
//import org.springframework.web.bind.annotation.*;
//
//import javax.annotation.Resource;
//
///**
// * @author zhanghao
// * @Title: FdpFaultDispatchHrRelationController
// * @ProjectName BlueOcean
// * @Description: 人力服务商
// * @date 2019/1/9下午2:00
// */
//@Api(description = "服务商记录")
//@RestController
//@RequestMapping("/fdpFaultDispatchHrRelation")
//public class FdpFaultDispatchHrRelationController {
//
//    private Logger log = Logger.getLogger(Logger.class);
//
//    @Resource
//    private FdpDispatchHrRelationService fdpDispatchHrRelationService;
//
//
//    @ApiOperation(value = "查看完工资料", httpMethod = "GET")
//    @GetMapping(value = "/profileLogShow")
//    public Result profileLogShow(@RequestParam Integer dispatchOrderId) {
//        log.info("查看完工资料-开始 入参：dispatchOrderId："+dispatchOrderId);
//        Result result = fdpDispatchHrRelationService.profileLogShow(dispatchOrderId);
//        log.info("查看完工资料-结束");
//        return result;
//    }
//
//    @ApiOperation(value = "采购补充完工资料", httpMethod = "POST" , notes = "采购补充完工资料")
//    @PostMapping(value = "/extendProfile")
//    public Result extendProfile(@RequestBody String json) {
//        log.info("采购补充完工资料-开始 入参：json："+json);
//        Result result = fdpDispatchHrRelationService.extendProfile(json);
//        log.info("采购补充完工资料-结束");
//        return result;
//    }
//
//    @ApiOperation(value = "修改派工人员", httpMethod = "POST", notes = "修改派工人员")
//    @PostMapping(value = "/changeDispatchHr")
//    public Result changeDispatchHr(@RequestBody FdpFaultDispatchHrRelation hrRelation) {
//        log.info("修改派工人员-开始 入参：hrRelation："+hrRelation.toString());
//        Result result = fdpDispatchHrRelationService.changeDispatchHr(hrRelation);
//        log.info("修改派工人员-结束");
//        return result;
//    }
//
//    @ApiOperation(value = "修改派工费用", httpMethod = "POST", notes = "修改派工费用")
//    @PostMapping(value = "/changeDispatchCost")
//    public Result changeDispatchCost(@RequestBody FdpFaultDispatchHrRelation hrRelation) {
//        log.info("修改派工费用-开始入参：hrRelation："+hrRelation.toString());
//        Result result = fdpDispatchHrRelationService.changeDispatchCost(hrRelation);
//        log.info("修改派工费用-结束");
//        return result;
//    }
//}
