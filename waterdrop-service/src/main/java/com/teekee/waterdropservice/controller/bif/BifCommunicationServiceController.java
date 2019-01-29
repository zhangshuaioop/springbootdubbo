package com.teekee.waterdropservice.controller.bif;

import com.teekee.waterdropservice.entity.bif.BifCommunicationService;
import com.teekee.waterdropservice.service.bif.BifCommunicationServiceService;
import com.teekee.commoncomponets.utils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 *
 * @Author Chenliwen
 * @Date 2018/12/17 15:52
 **/
@RestController
@RequestMapping("/commService")
@Api(description = "通讯服务商")
public class BifCommunicationServiceController {

    private Logger log = Logger.getLogger(BifCommunicationServiceController.class);
    @Resource
    private BifCommunicationServiceService bifCommunicationServiceService;

    @ApiOperation(
            value = "获取所有通信服务商列表",
            notes = "获取所有通信服务商列表",
            consumes = "application/json",
            responseReference = "com.teekee.commoncomponets.utils.Result")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public Result list() {
        log.info("获取所有通信服务商列表-开始,入参：无");
        Result result = bifCommunicationServiceService.getCommunicationServiceList();
        log.info("获取所有通信服务商列表-结束,出参:"+result.toString());
        return result;
    }

    @ApiOperation(
            value = "获取某个条件下，所有通信服务商列表",
            notes = "** serviceName **：@ 服务商名 | " +
                    "** contactName **：@ 联系人名 | " +
                    "** address **：联系地址 | " +
                    "** mobile **：手机 | " +
                    "** telephone **：电话",
            consumes = "application/json",
            responseReference = "com.teekee.commoncomponets.utils.Result")
    @RequestMapping(value = "/list", method = RequestMethod.POST)
    public Result listCustomize(@RequestBody BifCommunicationService bifCommunicationService) {
        log.info("获取某个品牌下，获取所有通信服务商列表-开始,入参:bifCommunicationService="+bifCommunicationService);
        Result result = bifCommunicationServiceService.getCommunicationServiceListCustomize(bifCommunicationService);
        log.info("获取某个品牌下，获取所有通信服务商列表-结束,出参:"+result.toString());
        return result;
    }

    @ApiOperation(
            value = "根据ID，查看通信服务商详情",
            notes = "根据ID，查看通信服务商详情",
            consumes = "application/json",
            responseReference = "com.teekee.commoncomponets.utils.Result")
    @RequestMapping(value = "/show", method = RequestMethod.GET)
    public Result show(@RequestParam("id") int id) {
        log.info("根据ID，查看通信服务商详情-开始,入参:id="+id);
        Result result = bifCommunicationServiceService.getCommunicationService(id);
        log.info("根据ID，查看通信服务商详情-结束,出参:"+result.toString());
        return result;
    }


    @ResponseBody
    @ApiOperation(
            value = "新增/编辑通信服务商信息",
            notes = "** serviceName **：@ 服务商名 * | " +
                    "** contactName **：@ 联系人名 * | " +
                    "** address **：联系地址 | " +
                    "** mobile **：手机 | " +
                    "** telephone **：电话 | " +
                    "** memo **：备注",
            consumes = "application/json",
            responseReference = "com.teekee.commoncomponets.utils.Result")
    @RequestMapping(value = "/handle", method = RequestMethod.POST)
    public Result handle(@RequestBody BifCommunicationService bifCommunicationService) {
        log.info("新增/编辑通信服务商信息-开始,入参:bifCommunicationService="+bifCommunicationService);
        Result result = bifCommunicationServiceService.handle(bifCommunicationService);
        log.info("新增/编辑通信服务商信息-结束,出参:"+result.toString());
        return result;
    }

    @ResponseBody
    @ApiOperation(
            value = "失效通信服务商",
            notes = "失效通信服务商",
            consumes = "application/json",
            responseReference = "com.teekee.commoncomponets.utils.Result")
    @RequestMapping(value = "/invalid", method = RequestMethod.POST)
    public Result handleInvalid( @RequestBody BifCommunicationService bifCommunicationService) {
        log.info("失效通信服务商-开始,入参:bifCommunicationService="+bifCommunicationService);
        Result result = bifCommunicationServiceService.handleInvalid(bifCommunicationService);
        log.info("失效通信服务商-结束,出参:"+result.toString());
        return result;
    }

    @ResponseBody
    @ApiOperation(
            value = "删除通信服务",
            notes = "删除通信服务",
            consumes = "application/json",
            responseReference = "com.teekee.commoncomponets.utils.Result")
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public Result handleDelete(@RequestBody BifCommunicationService bifCommunicationService) {
        log.info("删除通信服务-开始,入参:bifCommunicationService="+bifCommunicationService);
        Result result = bifCommunicationServiceService.handleDelete(bifCommunicationService);
        log.info("删除通信服务-结束,出参:"+result.toString());
        return result;
    }
}
