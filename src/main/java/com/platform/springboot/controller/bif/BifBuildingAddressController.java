package com.platform.springboot.controller.bif;

import com.platform.springboot.entity.bif.BifBuildingAddress;
import com.platform.springboot.service.bif.BifBuildingAddressServcice;
import com.platform.springboot.utils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @Author Chenliwen
 * @Date 2018/12/29 10:44
 **/
@RestController
@RequestMapping("/buildingAddress")
@Api(description = "楼宇地址")
public class BifBuildingAddressController{
    private Logger log = Logger.getLogger(BifBuildingAddressController.class);

    @Resource
    private BifBuildingAddressServcice buildingAddressServcice;

    @ApiOperation(
            value = "删除地址",
            notes = "** id **：地址id *",
            consumes = "application/json",
            responseReference = "com.platform.springboot.utils.Result")
    @RequestMapping(value = "/handleDelete", method = RequestMethod.POST)
    public Result handleDelete(@RequestBody BifBuildingAddress buildingAddress) {
        log.info("删除地址-开始，入参：buildingAddress="+buildingAddress.toString());
        Result result = buildingAddressServcice.handleDelete(buildingAddress);
        log.info("删除地址-结束，出参："+result.toString());
        return result;
    }


    @ApiOperation(
            value = "新增/编辑地址",
            notes = "** id **：地址id *" +
                    "** buildingId **：楼宇ID *" +
                    "** road **：道路 *",
            consumes = "application/json",
            responseReference = "com.platform.springboot.utils.Result")
    @RequestMapping(value = "/handle", method = RequestMethod.POST)
    public Result handle(@RequestBody BifBuildingAddress buildingAddress) {
        log.info("新增/编辑地址-开始，入参：buildingAddress="+buildingAddress.toString());
        Result result = buildingAddressServcice.handle(buildingAddress);
        log.info("新增/编辑地址-结束，出参："+result.toString());
        return result;
    }


    @ApiOperation(
            value = "查看地址详情",
            notes = "** id **：地址id *",
            consumes = "application/json",
            responseReference = "com.platform.springboot.utils.Result")
    @RequestMapping(value = "/show", method = RequestMethod.GET)
    public Result show(@RequestParam int id) {
        log.info("查看地址详情-开始，入参：id="+id);
        Result result = buildingAddressServcice.show(id);
        log.info("查看地址详情-结束，出参："+result.toString());
        return result;
    }
}
