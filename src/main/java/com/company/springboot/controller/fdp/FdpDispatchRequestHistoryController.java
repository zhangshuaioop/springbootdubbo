package com.company.springboot.controller.fdp;


import com.company.springboot.entity.fdp.FdbOrderFindPage;
import com.company.springboot.service.fdp.FdpDispatchRequestHistoryService;
import com.company.springboot.utils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;


/**
 * @author zhanghao
 * @Title: FdpDispatchRequestHistoryController
 * @Description: 采购工单历史记录
 * @date 2019/1/9下午2:54
 */
@Api(description = "采购工单历史记录")
@RestController
@RequestMapping("/requestHistory")
public class FdpDispatchRequestHistoryController {

    private Logger log = Logger.getLogger(Logger.class);

    @Resource
    private FdpDispatchRequestHistoryService fdpDispatchRequestHistoryService;

    @ApiOperation(value = "查询派工单历史", httpMethod = "POST")
    @PostMapping(value = "/getHistoryList")
    public Result getHistoryList(@RequestBody FdbOrderFindPage fdbOrderFindPage) {
        log.info("查询派工单历史-开始 入参："+fdbOrderFindPage.toString());
        Result result = fdpDispatchRequestHistoryService.getHistoryList(fdbOrderFindPage);
        log.info("查询派工单历史-结束");
        return result;
    }

    @ApiOperation(value = "查询派工单历史详情", httpMethod = "GET")
    @GetMapping(value = "/showHistory")
    public Result showHistory(@RequestParam Integer id) {
        log.info("查询派工单历史详情-开始");
        Result result = fdpDispatchRequestHistoryService.showHistory(id);
        log.info("查询派工单历史详情-结束");
        return result;
    }


}
