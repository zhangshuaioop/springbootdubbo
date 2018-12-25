package com.platform.springboot.controller.fdp;

import com.platform.springboot.service.fdp.FdpDispatchProcessLogService;
import com.platform.springboot.utils.Result;
import com.platform.springboot.service.fdp.FdpDispatchProcessLogService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author zhanghao
 * @Title: FdpDispatchProcessLogController
 * @ProjectName WaterDrop
 * @Description: 派工流程
 * @date 2018/12/22下午1:50
 */
@RestController
@RequestMapping("/dispatchProcessLog")
@Api(description = "派工流程")
public class FdpDispatchProcessLogController {
    private Logger log = Logger.getLogger(FdpFaultDispatchOrderController.class);

    @Resource
    private FdpDispatchProcessLogService service;

    @ApiOperation(value = "查看派工流程", httpMethod = "GET")
    @GetMapping(value = "/show")
    public Result show(@RequestParam Integer orderId) {
        log.info("查看派工流程-开始");
        Result result =  service.show(orderId);
        log.info("查看派工流程-结束");
        return result;
    }

}
