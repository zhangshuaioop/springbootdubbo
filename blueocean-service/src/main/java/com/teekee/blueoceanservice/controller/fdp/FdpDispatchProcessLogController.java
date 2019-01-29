package com.teekee.blueoceanservice.controller.fdp;//package com.teekee.blueoceanservice.controller.fdp;
//
//import com.teekee.blueoceanservice.service.fdp.FdpDispatchProcessLogService;
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
// * @Title: FdpDispatchProcessLogController
// * @ProjectName BlueOcean
// * @Description: 派工流程日志
// * @date 2019/1/9下午2:38
// */
//@Api(description = "派工流程日志")
//@RestController
//@RequestMapping("/dispatchProcessLog")
//public class FdpDispatchProcessLogController {
//
//    private Logger log = Logger.getLogger(Logger.class);
//
//    @Resource
//    private FdpDispatchProcessLogService fdpDispatchProcessLogService;
//
//    @ApiOperation(value = "派工流程", httpMethod = "GET")
//    @GetMapping(value = "/show")
//    public Result show(@PathVariable Integer orderId) {
//        log.info("查看派工流程-开始 入参：orderId"+orderId);
//        Result result =  fdpDispatchProcessLogService.show(orderId);
//        log.info("查看派工流程-结束");
//        return result;
//    }
//}
