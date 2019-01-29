package com.teekee.blueoceanservice.controller.fdp;//package com.teekee.blueoceanservice.controller.fdp;
//
//import com.teekee.blueoceanservice.entity.fdp.FdpFaultOrderDispatchRequest;
//import com.teekee.blueoceanservice.service.fdp.FdpFaultOrderDispatchRequestService;
//import com.teekee.commoncomponets.utils.Result;
//import io.swagger.annotations.Api;
//import io.swagger.annotations.ApiOperation;
//import org.apache.log4j.Logger;
//import org.springframework.web.bind.annotation.*;
//
//import javax.annotation.Resource;
//import javax.servlet.http.HttpServletRequest;
//
//
///**
// * @author zhanghao
// * @Title: FdpFaultOrderDispatchRequestController
// * @ProjectName BlueOcean
// * @Description: 工单信息
// * @date 2019/1/4上午9:24
// */
//
//@Api(description = "工单信息")
//@RestController
//@RequestMapping("/fdpFaultOrderDispatchRequest")
//public class FdpFaultOrderDispatchRequestController {
//
//    private Logger log = Logger.getLogger(Logger.class);
//
//    @Resource
//    private FdpFaultOrderDispatchRequestService fdpFaultOrderDispatchRequestService;
//
//
//    @ApiOperation(value = "查看派工人员信息", httpMethod = "GET")
//    @GetMapping(value = "/showDispatch")
//    public Result showDispatch(@RequestParam Integer requestId) {
//        log.info("查看派工人员信息-开始 入参：requestId："+requestId);
//        Result result = fdpFaultOrderDispatchRequestService.showDispatch(requestId);
//        log.info("查看派工人员信息-结束");
//        return result;
//    }
//
//    @ApiOperation(value = "采购查看工单信息", httpMethod = "GET")
//    @GetMapping(value = "/showNew")
//    public Result showNew(@RequestParam Integer requestId) {
//        log.info("派工查看工单信息-开始 入参：requestId："+requestId);
//        Result result = fdpFaultOrderDispatchRequestService.showNew(requestId);
//        log.info("派工查看工单信息-结束");
//        return result;
//    }
//
//    @ApiOperation(value = "编辑工单信息", httpMethod = "POST")
//    @PostMapping(value = "/handle")
//    public Result confirm(@RequestBody FdpFaultOrderDispatchRequest dispatchRequest) {
//        log.info("新增派工信息-开始 入参：dispatchRequest："+dispatchRequest.toString());
//        Result result = fdpFaultOrderDispatchRequestService.handle(dispatchRequest);
//        log.info("新增派工信息-结束");
//        return result;
//    }
//
//    @ApiOperation(value = "编辑派工模板路径信息", httpMethod = "POST")
//    @PostMapping(value = "/profile")
//    public Result profile(@RequestBody FdpFaultOrderDispatchRequest dispatchRequest) {
//        log.info("编辑派工模板路径信息-开始 入参：dispatchRequest："+dispatchRequest.toString());
//        Result result = fdpFaultOrderDispatchRequestService.profile(dispatchRequest);
//        log.info("编辑派工模板路径信息-结束");
//        return result;
//    }
//
//}
