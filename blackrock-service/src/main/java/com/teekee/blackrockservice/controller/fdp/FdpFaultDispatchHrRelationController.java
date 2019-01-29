package com.teekee.blackrockservice.controller.fdp;

import com.teekee.blackrockservice.base.BaseController;
import com.teekee.blackrockservice.entity.bif.BifServiceListParam;
import com.teekee.blackrockservice.entity.dmi.DmiBrandName;
import com.teekee.blackrockservice.entity.fdp.FdpRecentOrderList;
import com.teekee.blackrockservice.service.fdp.FdpFaultDispatchHrRelationService;
import com.teekee.blackrockservice.utils.StringUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @Author Niting
 * @date 2018/11/7
 **/
@Api(value = "FdpFaultDispatchHrRelationController", tags = "hrRelation-service")
@RestController
@RequestMapping("/serv/hrRelation")
public class FdpFaultDispatchHrRelationController extends BaseController{
    private Logger log = Logger.getLogger(FdpFaultDispatchHrRelationController.class);

    @Resource
    FdpFaultDispatchHrRelationService service;

    @ApiOperation(
            value = "近期工单",
            notes = "近期工单",
            consumes = "application/json",
            responseReference = "com.example.timemachine.utils.Result"
    )
    @PostMapping(value = "/recentOrder")
    public String statusCollect(@RequestBody BifServiceListParam param, HttpServletRequest request) {
        Integer hrId = getTokenFromHead(request);
        log.info("近期工单-开始");
        List<FdpRecentOrderList> result = service.recentOrder(param,hrId);
        log.info("近期工单-结束");
        return build(StringUtil.buildJsonSucessRespMsg(result));
    }

    @ApiOperation(
            value = "工单筛选品牌",
            notes = "工单筛选品牌",
            consumes = "application/json",
            responseReference = "com.example.timemachine.utils.Result"
    )
    @GetMapping(value = "/orderBrand")
    public String orderBrand(HttpServletRequest request) {
        log.info("工单筛选品牌-开始");
        Integer hrId = getTokenFromHead(request);
        List<DmiBrandName> result = service.orderBrand(hrId);
        log.info("工单筛选品牌-结束");
        return build(StringUtil.buildJsonSucessRespMsg(result));
    }


}
