package com.teekee.waterdropservice.controller.bif;

import com.teekee.waterdropservice.entity.bif.BifDevice;
import com.teekee.waterdropservice.entity.bif.BifDeviceInputParam;
import com.teekee.waterdropservice.entity.bif.BifDisableDevice;
import com.teekee.waterdropservice.service.bif.BifDeviceService;
import com.teekee.commoncomponets.utils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
　* @Description: 设备信息control类
　* @param ${tags}
　* @return ${return_type}
　* @throws
　* @author zhanghao
　* @date 2018/12/14 下午6:28
　*/
@RestController
@RequestMapping("/device")
@Api(description = "设备信息类")
public class BifDeviceController {

    @Resource
    private BifDeviceService bifDeviceService;

    @ApiOperation(value = "根据雇主id,分页查询设备列表", httpMethod = "POST", notes = "分页获取所有设备列表")
    @RequestMapping(value = "/list", method = RequestMethod.POST)
    public Result list(@RequestBody BifDevice bifDevice) {
        return bifDeviceService.getDeviceList(bifDevice);
    }

    @ApiOperation(value = "根据条件，获取分页设备列表", httpMethod = "POST")
    @RequestMapping(value = "/getListByObject", method = RequestMethod.POST)
    public Result getListByObject(@RequestBody BifDeviceInputParam bifDeviceInputParam) {
        return bifDeviceService.getListByObject(bifDeviceInputParam);
    }

    @ApiOperation(value = "根据ID，查看设备详情", httpMethod = "GET", notes = "根据ID，查看设备详情")
    @RequestMapping(value = "/show", method = RequestMethod.GET)
    public Result deviceShow(@RequestParam Integer id) {
        return bifDeviceService.deviceShow(id);
    }

    @ApiOperation(value = "新增/编辑设备信息", httpMethod = "POST")
    @RequestMapping(value = "/handle", method = RequestMethod.POST)
    public Result handle(@RequestBody String jsonStr) {
        return bifDeviceService.handle(jsonStr);
    }

    @ApiOperation(value = "删除设备", httpMethod = "GET", notes = "删除设备")
    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public Result handleDelete(@RequestParam Integer id) {
        return bifDeviceService.handleDelete(id);
    }

    @ApiOperation(value = "停用设备", httpMethod = "POST", notes = "停用设备")
    @RequestMapping(value = "/disable", method = RequestMethod.POST)
    public Result disable(@RequestBody BifDisableDevice bifDisableDevice) {
        return bifDeviceService.disable(bifDisableDevice);
    }

    @ApiOperation(value = "下载设备列表", httpMethod = "POST")
    @RequestMapping(value = "/downloadDeviceList", method = RequestMethod.POST)
    public Result downloadDeviceList(@RequestBody BifDeviceInputParam record) {
        return bifDeviceService.downloadDeviceList(record);
    }
}
