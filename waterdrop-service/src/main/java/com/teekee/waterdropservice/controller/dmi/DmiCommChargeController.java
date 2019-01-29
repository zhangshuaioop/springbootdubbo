package com.teekee.waterdropservice.controller.dmi;

import com.teekee.waterdropservice.entity.dmi.DmiCommCharge;
import com.teekee.waterdropservice.service.dmi.DmiCommChargeService;
import com.teekee.commoncomponets.utils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @Author Chenliwen
 * @Date 2019/1/11 15:00
 **/
@RestController
@RequestMapping("/charge")
@Api(description = "收费合约")
public class DmiCommChargeController {

    private Logger log = Logger.getLogger(DmiCommChargeController.class);
    @Resource
    private DmiCommChargeService chargeService;

    @ApiOperation(value = "根据通信类型和id，查询收费信息列表",
            notes = "根据通信类型和id，查询收费信息列表")
    @RequestMapping(value = "/list", method = RequestMethod.POST)
    public Result list(@RequestBody DmiCommCharge dmiCommCharge) {
        log.info("根据通信类型和id，查询收费信息列表-开始，入参：dmiCommCharge="+dmiCommCharge.toString());
        Result result = chargeService.list(dmiCommCharge);
        log.info("根据通信类型和id，查询收费信息列表-结束，出参："+result.toString());
        return result;
    }


    @ApiOperation(value = "新增/编辑收费合约",
            notes = "新增/编辑收费合约")
    @RequestMapping(value = "/handle", method = RequestMethod.POST)
    public Result handle(@RequestBody DmiCommCharge dmiCommCharge) {
        log.info("新增/编辑收费合约-开始，入参：dmiCommCharge="+dmiCommCharge.toString());
        Result result = chargeService.handle(dmiCommCharge);
        log.info("新增/编辑收费合约-结束，出参："+result.toString());
        return result;
    }


    @ApiOperation(
            value = "删除收费合约",
            notes = "删除收费合约")
    @RequestMapping(value = "/handleDelete", method = RequestMethod.POST)
    public Result handleDelete(@RequestBody DmiCommCharge dmiCommCharge) {
        log.info("删除收费合约-开始，入参：dmiCommCharge="+dmiCommCharge.toString());
        Result result = chargeService.handleDelete(dmiCommCharge);
        log.info("删除收费合约-结束，出参："+result.toString());
        return result;
    }


    @ApiOperation(
            value = "查看某条收费合约详情",
            notes = "查看某条收费合约详情")
    @RequestMapping(value = "/show", method = RequestMethod.GET)
    public Result show(@RequestParam int id) {
        log.info("查看某条收费合约详情-开始，入参：id="+id);
        Result result = chargeService.show(id);
        log.info("查看某条收费合约详情-结束，出参："+result.toString());
        return result;
    }
}
