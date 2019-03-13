package com.company.springboot.controller.bif;

import com.company.springboot.utils.Result;
import com.company.springboot.entity.bif.BifDeviceSeries;
import com.company.springboot.service.bif.BifDeviceSeriesService;
import com.company.springboot.utils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;


/**
 * @author zhanghao
 * @Title: BifDeviceSeriesController
 * @ProjectName WaterDrop
 * @Description: 设备品牌系列
 * @date 2018/12/17下午2:16
 */
@RestController
@RequestMapping("/deviceSeries")
@Api(description = "设备品牌系列")
public class BifDeviceSeriesController {

    private Logger log = Logger.getLogger(BifDeviceSeriesController.class);
    @Resource
    private BifDeviceSeriesService bifDeviceSeriesService;

    @ApiOperation(value = "根据品牌ID，分页获取系列列表", httpMethod = "POST", notes = "根据品牌ID，分页获取系列列表")
    @RequestMapping(value = "/list", method = RequestMethod.POST)
    public Result list(@RequestBody BifDeviceSeries bifDeviceSeries) {
        log.info("根据品牌ID，分页获取系列列表-开始");
        Result result = bifDeviceSeriesService.getDeviceSeriesList(bifDeviceSeries);
        log.info("根据品牌ID，分页获取系列列表-结束");
        return result;
    }
    @ApiOperation(value = "根据ID，查看设备系列详情", httpMethod = "GET", notes = "根据ID，查看设备系列详情")
    @RequestMapping(value = "/show", method = RequestMethod.GET)
    public Result show(@RequestParam Integer id) {
        log.info("根据ID，查看设备系列详情-开始");
        Result result = bifDeviceSeriesService.getDeviceSeries(id);
        log.info("根据ID，查看设备系列详情-结束");
        return result;
    }
    @ApiOperation(value = "新增/编辑设备系列信息", httpMethod = "POST",
            notes = "** seriesName **：@ 系列名 * | " +
                    "** brandId **：@ 所属的品牌ID * | " +
                    "** seriesCode **：系列编号 | " +
                    "** memo **：备注")
    @RequestMapping(value = "/handle", method = RequestMethod.POST)
    public Result handle(@RequestBody BifDeviceSeries bifDeviceSeries) {
        log.info("新增/编辑设备系列信息-开始");
        Result result = bifDeviceSeriesService.handle(bifDeviceSeries);
        log.info("新增/编辑设备系列信息-结束");
        return result;
    }
    @ApiOperation(value = "失效设备系列", httpMethod = "GET", notes = "失效设备系列")
    @RequestMapping(value = "/invalid", method = RequestMethod.GET)
    public Result handleInvalid(@RequestParam Integer id) {
        log.info("失效设备系列-开始");
        Result result = bifDeviceSeriesService.handleInvalid(id);
        return result;
    }
    @ApiOperation(value = "删除系列", httpMethod = "GET", notes = "删除系列")
    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public Result handleDelete(@RequestParam Integer id) {
        log.info("删除系列-开始");
        Result result = bifDeviceSeriesService.handleDelete(id);
        return result;
    }
}
