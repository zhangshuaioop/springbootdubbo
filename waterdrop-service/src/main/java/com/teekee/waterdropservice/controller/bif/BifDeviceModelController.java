package com.teekee.waterdropservice.controller.bif;

import com.teekee.waterdropservice.entity.bif.BifDeviceModel;
import com.teekee.waterdropservice.service.bif.BifDeviceModelService;
import com.teekee.commoncomponets.utils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author zhanghao
 * @Title: BifDeviceModelController
 * @ProjectName WaterDrop
 * @Description: 设备品牌型号
 * @date 2018/12/17下午3:15
 */
@RestController
@RequestMapping("/deviceModel")
@Api(description = "设备品牌型号")
public class BifDeviceModelController {

    private Logger log = Logger.getLogger(BifDeviceModelController.class);
    @Resource
    private BifDeviceModelService bifDeviceModelService;

    @ApiOperation(value = "根据设备系列id，获取设备型号列表", httpMethod = "POST", notes = "根据设备系列id，获取设备型号列表")
    @RequestMapping(value = "/list", method = RequestMethod.POST)
    public Result list(@RequestBody BifDeviceModel bifDeviceModel) {
        log.info("根据设备系列id，获取设备型号列表-开始");
        Result result = bifDeviceModelService.getDeviceModelList(bifDeviceModel);
        log.info("根据设备系列id，获取设备型号列表-结束");
        return result;
    }
    @ApiOperation(value = "根据ID，查看设备型号详情", httpMethod = "GET", notes = "根据ID，查看设备型号详情")
    @RequestMapping(value = "/show", method = RequestMethod.GET)
    public Result show(@RequestBody BifDeviceModel bifDeviceModel) {
        log.info("根据ID，查看设备型号详情-开始");
        Result result = bifDeviceModelService.getDeviceModel(bifDeviceModel);
        log.info("根据ID，查看设备型号详情-结束");
        return result;
    }
    @ApiOperation(value = "新增/编辑设备型号信息", httpMethod = "POST",
            notes = "** modelName **：@ 型号名 * | " +
                    "** seriesId **：@ 所属的型号ID * | " +
                    "** modelCode **：型号编号 | " +
                    "** memo **：备注")
    @RequestMapping(value = "/handle", method = RequestMethod.POST)
    public Result handle(@RequestBody BifDeviceModel bifDeviceModel) {
        log.info("新增/编辑设备型号信息-开始");
        Result result = bifDeviceModelService.handle(bifDeviceModel);
        log.info("新增/编辑设备型号信息-结束");
        return result;
    }
    @ApiOperation(value = "失效设备型号", httpMethod = "GET", notes = "失效设备型号")
    @RequestMapping(value = "/invalid", method = RequestMethod.GET)
    public Result handleInvalid(@RequestParam Integer id) {
        log.info("失效设备型号-开始");
        Result result = bifDeviceModelService.handleInvalid(id);
        log.info("失效设备型号-结束");
        return result;
    }
    @ApiOperation(value = "删除型号", httpMethod = "GET", notes = "删除型号")
    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public Result handleDelete(@RequestParam Integer id) {
        log.info("删除型号-开始");
        Result result = bifDeviceModelService.handleDelete(id);
        log.info("删除型号-结束");
        return result;
    }
}
