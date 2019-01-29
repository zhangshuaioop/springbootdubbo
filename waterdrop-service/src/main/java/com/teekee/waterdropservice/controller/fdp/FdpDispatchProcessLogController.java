package com.teekee.waterdropservice.controller.fdp;

import com.teekee.waterdropservice.service.fdp.FdpDispatchProcessLogService;
import com.teekee.commoncomponets.utils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
