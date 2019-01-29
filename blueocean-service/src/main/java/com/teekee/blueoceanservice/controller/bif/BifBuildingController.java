package com.teekee.blueoceanservice.controller.bif;

import com.teekee.commoncomponets.utils.Result;
import com.teekee.blueoceanservice.entity.bif.BifBuilding;
import com.teekee.blueoceanservice.service.bif.BifBuildingService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @Author Chenliwen
 * @Date 2018/12/28 18:02
 **/
@Api(description = "楼宇信息")
@RestController
@RequestMapping("/building")
public class BifBuildingController {
    private Logger log = Logger.getLogger(BifBuildingController.class);

    @Resource
    private BifBuildingService bifBuildingService;

    @ResponseBody
    @ApiOperation(
            value = "新增/编辑楼宇",
            notes = "** province **：@ 省 * | " +
                    "** city **：@ 市 * | " +
                    "** district **：区/县 | " +
                    "** buildingName **：@ 楼宇/园区名 | " +
                    "** longitude **：经度坐标 | " +
                    "** latitude **：纬度坐标 | " +
                    "** road **：道路 | " +
                    "** applyId **：楼宇信息申请ID",
            consumes = "application/json",
            responseReference = "com.teekee.commoncomponets.utils.Result")
    @RequestMapping(value = "/handle", method = RequestMethod.POST)
    public Result handle(@RequestBody BifBuilding building) {
        log.info("新增/编辑楼宇-开始，入参：building="+building.toString());
        Result result = bifBuildingService.handle(building);
        log.info("新增/编辑楼宇-结束，出参："+result.toString());
        return result;
    }


    @ApiOperation(
            value = "查询楼地址详情",
            notes = "** id **：楼id *",
            consumes = "application/json",
            responseReference = "com.teekee.commoncomponets.utils.Result")
    @RequestMapping(value = "/addressInfo", method = RequestMethod.GET)
    public Result addressInfo(@RequestParam Integer id) {
        log.info("查询楼地址详情-开始，入参：id="+id);
        Result result = bifBuildingService.addressInfo(id);
        log.info("查询楼地址详情-结束，出参："+result.toString());
        return result;
    }

    @ApiOperation(value = "根据省市区和楼宇名（模糊查询），获取楼列表",
            notes = "** province **：省 * | " +
                    "** city **：市 " +
                    "** district **：区 " +
                    "** buildingName **：楼宇名 ",
            consumes = "application/json",
            responseReference = "com.teekee.commoncomponets.utils.Result")
    @RequestMapping(value = "/list", method = RequestMethod.POST)
    public Result list(@RequestBody BifBuilding bifBuilding) {
        log.info("根据省市区和楼宇名（模糊查询），获取楼列表-开始，入参：bifBuilding="+bifBuilding.toString());
        Result result = bifBuildingService.list(bifBuilding);
        log.info("根据省市区和楼宇名（模糊查询），获取楼列表-结束，出参："+result.toString());
        return result;
    }

    @ApiOperation(value = "根据经纬度查询附近的楼地址",
            notes = "** longitude **：@ 经度 * | " +
                    "** latitude **：@ 纬度 ",
            consumes = "application/json",
            responseReference = "com.teekee.commoncomponets.utils.Result")
    @RequestMapping(value = "/vicinityBuildingList", method = RequestMethod.GET)
    public Result vicinityBuildingList(@RequestParam double longitude, @RequestParam double latitude) {
        log.info("根据经纬度查询附近的楼地址-开始，入参：longitude="+longitude+"，latitude="+latitude);
        Result result = bifBuildingService.vicinityBuildingList(longitude, latitude);
        log.info("根据经纬度查询附近的楼地址-结束，出参："+result.toString());
        return result;
    }

    @ApiOperation(
            value = "根据楼查询地址信息列表",
            notes = "** id **：楼id *",
            consumes = "application/json",
            responseReference = "com.teekee.commoncomponets.utils.Result")
    @RequestMapping(value = "/addressList", method = RequestMethod.GET)
    public Result addressList(@RequestParam Integer id) {
        log.info("根据楼查询地址信息列表-开始，入参：id="+id);
        Result result = bifBuildingService.addressList(id);
        log.info("根据楼查询地址信息列表-结束，出参："+result.toString());
        return result;
    }

    @ApiOperation(value = "删除楼",
            notes = "** id **：楼id *",
            consumes = "application/json",
            responseReference = "com.teekee.commoncomponets.utils.Result")
    @RequestMapping(value = "/handleDelete", method = RequestMethod.POST)
    public Result handleDelete(@RequestBody BifBuilding building) {
        log.info("删除楼-开始，入参：building="+building.toString());
        Result result = bifBuildingService.handleDelete(building);
        log.info("删除楼-结束，出参："+result.toString());
        return result;
    }

}
