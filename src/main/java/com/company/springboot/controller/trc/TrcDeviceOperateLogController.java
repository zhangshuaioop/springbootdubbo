package com.company.springboot.controller.trc;

import com.company.springboot.entity.ret.trc.GetDeviceOperate;
import com.company.springboot.service.trc.TrcDeviceOperateLogService;
import com.company.springboot.utils.Result;
import io.swagger.annotations.ApiOperation;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 设备操作日志
 *
 * @author Wujun
 * @create 2017年11月17日 14:24
 */
@Controller
@RequestMapping("/trcDeviceOperateLog")
public class TrcDeviceOperateLogController{

    private Logger log = Logger.getLogger(TrcDeviceOperateLogController.class);

    @Resource
    private TrcDeviceOperateLogService service;

    @ResponseBody
    @ApiOperation(value = "查询设备操作日志", httpMethod = "GET")
    @RequestMapping(value = "/getDeviceOperate", method = RequestMethod.GET)
    public Result getDeviceOperate(@RequestParam int deviceId) {
        log.info("查询设备操作日志-开始");
        Result result = service.getDeviceOperate(deviceId);
        log.info("查询设备操作日志-结束");
        return result;
    }

}
