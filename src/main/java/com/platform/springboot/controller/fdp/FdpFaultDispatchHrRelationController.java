package com.platform.springboot.controller.fdp;

import com.platform.springboot.service.fdp.FdpDispatchHrRelationService;
import com.platform.springboot.utils.Result;
import com.platform.springboot.service.fdp.FdpDispatchHrRelationService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author zhanghao
 * @Title: FdpFaultDispatchHrRelationController
 * @ProjectName WaterDrop
 * @Description: 服务商记录
 * @date 2018/12/22上午11:25
 */
@RestController
@RequestMapping("/fdpFaultDispatchHrRelation")
@Api(description = "服务商记录")
public class FdpFaultDispatchHrRelationController {

    private Logger log = Logger.getLogger(FdpFaultDispatchHrRelationController.class);

    @Resource
    private FdpDispatchHrRelationService service;

    @ApiOperation(value = "查看服务商app工作记录", httpMethod = "GET")
    @GetMapping(value = "/workRecord")
    public Result workRecord(@RequestParam Integer dispatchOrderId) {
        log.info("查看服务商app工作记录-开始");
        Result result = service.profileLogShow(dispatchOrderId);
        log.info("查看服务商app工作记录-结束");
        return result;
    }
}
