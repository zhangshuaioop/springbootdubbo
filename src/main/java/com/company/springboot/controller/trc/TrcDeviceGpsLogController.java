package com.company.springboot.controller.trc;

import com.company.springboot.service.trc.TrcDeviceGpsLogService;
import com.company.springboot.utils.Result;
import io.swagger.annotations.ApiOperation;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
　* @Description: 设备GPS地址位置日志
　* @param ${tags}
　* @return ${return_type}
　* @throws
　* @author zhanghao
　* @date 2019/3/6 上午10:28
　*/
@RestController
@RequestMapping("/trcDeviceGpsLog")
public class TrcDeviceGpsLogController {

    private Logger log = Logger.getLogger(TrcDeviceGpsLogController.class);

    @Resource
    private TrcDeviceGpsLogService trcDeviceGpsLogService;

    @ApiOperation(value = "坐标日志列表", httpMethod = "GET")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public Result getDeviceOperate(@RequestParam Integer orderId) {
        log.info("坐标日志列表-开始");
        Result result = trcDeviceGpsLogService.list(orderId);
        log.info("坐标日志列表-结束");
        return result;
    }

}
