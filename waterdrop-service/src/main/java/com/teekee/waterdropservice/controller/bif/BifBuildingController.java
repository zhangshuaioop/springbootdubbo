package com.teekee.waterdropservice.controller.bif;

import com.teekee.commoncomponets.utils.Result;
import com.teekee.waterdropservice.entity.bif.BifBuilding;
import com.teekee.waterdropservice.service.bif.BifBuildingService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author zhanghao
 * @Title: BifBuildingController
 * @ProjectName WaterDrop
 * @Description: 楼宇信息
 * @date 2018/12/27下午6:04
 */
@RestController
@RequestMapping("/building")
@Api(description = "楼宇信息")
public class BifBuildingController {


    private Logger log = Logger.getLogger(BifBuildingController.class);

    @Resource
    private BifBuildingService bifBuildingService;


    @ApiOperation(value = "新增/编辑楼宇", httpMethod = "POST",
            notes = "** province **：@ 省 * | " +
                    "** city **：@ 市 * | " +
                    "** district **：区/县 | " +
                    "** buildingName **：@ 楼宇/园区名 | " +
                    "** longitude **：经度坐标 | " +
                    "** latitude **：纬度坐标 | " +
                    "** road **：道路 | " +
                    "** applyId **：楼宇信息申请ID")
    @PostMapping(value = "/handle")
    public Result handle(@RequestBody String requestJson) {
        log.info("新增/编辑楼宇-开始 入参:" + requestJson);
        Result result = bifBuildingService.handle(requestJson);
        log.info("新增/编辑楼宇-结束");
        return result;
    }

    @ApiOperation(value = "根据经纬度查询附近的楼地址", httpMethod = "GET",
            notes = "** longitude **：@ 经度 * | " +
                    "** latitude **：@ 纬度 ")
    @GetMapping(value = "/vicinityBuildingList")
    public Result vicinityBuildingList(@RequestParam double longitude, @RequestParam double latitude) {
        log.info("根据经纬度查询附近的楼地址-开始");
        Result result = bifBuildingService.vicinityBuildingList(longitude, latitude);
        log.info("根据经纬度查询附近的楼地址-结束");
        return result;
    }

    @ApiOperation(value = "根据省市区和楼宇名（模糊查询），获取楼列表", httpMethod = "POST",
            notes = "** province **：省 * | " +
                    "** city **：市 " +
                    "** district **：区 " +
                    "** buildingName **：楼宇名 ")
    @PostMapping(value = "/list")
    public Result list(@RequestBody BifBuilding bifBuilding) {
        log.info("根据省市区和楼宇名（模糊查询），获取楼列表-开始 入参：" + bifBuilding);
        Result result = bifBuildingService.list(bifBuilding);
        log.info("根据省市区和楼宇名（模糊查询），获取楼列表-结束");
        return result;
    }

    @ApiOperation(value = "根据省市区和楼宇名（模糊查询），获取楼（多地址）列表", httpMethod = "POST",
            notes = "** province **：省 * | " +
                    "** city **：市 " +
                    "** district **：区 " +
                    "** buildingName **：楼宇名 ")
    @PostMapping(value = "/listAllAddress")
    public Result listAllAddress(@RequestBody BifBuilding bifBuilding) {
        log.info("根据省市区和楼宇名（模糊查询），获取楼（多地址）列表-开始");
        Result result = bifBuildingService.listAllAddress(bifBuilding);
        log.info("根据省市区和楼宇名（模糊查询），获取楼（多地址）列表-结束");
        return result;
    }

    @ApiOperation(value = "查询楼地址详情", httpMethod = "GET", notes = "** id **：楼id *")
    @GetMapping(value = "/addressInfo")
    public Result addressInfo(@RequestParam Integer id) {
        log.info("查询楼地址详情-开始");
        Result result = bifBuildingService.addressInfo(id);
        log.info("查询楼地址详情-结束");
        return result;
    }

    @ApiOperation(value = "删除楼", httpMethod = "POST", notes = "** id **：楼id *")
    @PostMapping(value = "/handleDelete")
    public Result handleDelete(@RequestBody BifBuilding building) {
        log.info("删除楼-开始");
        Result result = bifBuildingService.handleDelete(building);
        log.info("删除楼-结束");
        return result;
    }

    @ApiOperation(value = "根据楼查询地址信息列表", httpMethod = "GET", notes = "** id **：楼id *")
    @GetMapping(value = "/addressList")
    public Result addressList(@RequestParam Integer id) {
        log.info("根据楼查询地址信息列表-开始");
        Result result = bifBuildingService.addressList(id);
        log.info("根据楼查询地址信息列表-结束");
        return result;
    }


}
