package com.teekee.waterdropservice.controller.dmi;

import com.teekee.waterdropservice.entity.dmi.DmiCommPayment;
import com.teekee.waterdropservice.service.dmi.DmiCommPaymentService;
import com.teekee.commoncomponets.utils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @Author Chenliwen
 * @Date 2019/1/11 18:05
 **/
@RestController
@RequestMapping("/payment")
@Api(description = "付费合约")
public class DmiCommPaymentController {

    private Logger log = Logger.getLogger(DmiCommPaymentController.class);
    @Resource
    private DmiCommPaymentService paymentService;

    @ApiOperation(
            value = "根据通信类型和id，查询付费信息列表",
            notes = "根据通信类型和id，查询付费信息列表")
    @RequestMapping(value = "/list", method = RequestMethod.POST)
    public Result list(@RequestBody DmiCommPayment dmiCommPayment) {
        log.info("根据通信类型和id，查询付费信息列表-开始，入参：dmiCommPayment="+dmiCommPayment.toString());
        Result result = paymentService.list(dmiCommPayment);
        log.info("根据通信类型和id，查询付费信息列表-结束，出参："+result.toString());
        return result;
    }


    @ApiOperation(
            value = "新增/编辑付费合约",
            notes = "新增/编辑付费合约")
    @RequestMapping(value = "/handle", method = RequestMethod.POST)
    public Result handle(@RequestBody DmiCommPayment dmiCommPayment) {
        log.info("新增/编辑付费合约-开始，入参：dmiCommPayment="+dmiCommPayment.toString());
        Result result = paymentService.handle(dmiCommPayment);
        log.info("新增/编辑付费合约-结束，出参："+result.toString());
        return result;
    }


    @ApiOperation(
            value = "删除付费合约",
            notes = "删除付费合约")
    @RequestMapping(value = "/handleDelete", method = RequestMethod.POST)
    public Result handleDelete( @RequestBody DmiCommPayment dmiCommPayment) {
        log.info("删除付费合约-开始，入参：dmiCommPayment="+dmiCommPayment.toString());
        Result result = paymentService.handleDelete(dmiCommPayment);
        log.info("删除付费合约-结束，出参："+result.toString());
        return result;
    }


    @ApiOperation(
            value = "查看某条付费合约详情",
            notes = "查看某条付费合约详情")
    @RequestMapping(value = "/show", method = RequestMethod.GET)
    public Result show(@RequestParam int id) {
        log.info("查看某条付费合约详情-开始，入参：id="+id);
        Result result = paymentService.show(id);
        log.info("查看某条付费合约详情-结束，出参："+result.toString());
        return result;
    }
}
