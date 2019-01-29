package com.teekee.waterdropservice.controller.bif;

import com.teekee.waterdropservice.entity.bif.BifCommunicationServiceContact;
import com.teekee.waterdropservice.entity.dto.common.HandleInvalidDeleteDTO;
import com.teekee.waterdropservice.service.bif.BifCommunicationServiceContactService;
import com.teekee.commoncomponets.utils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author zhanghao
 * @Title: BifCommunicationServiceContactController
 * @ProjectName WaterDrop
 * @Description: 通信服务商联系人
 * @date 2018/12/29下午3:54
 */

@RestController
@RequestMapping("/commServiceContact")
@Api(description = "通信服务商联系人")
public class BifCommunicationServiceContactController {

    private Logger log = Logger.getLogger(BifCommunicationServiceContactController.class);

    @Resource
    private BifCommunicationServiceContactService service;


    @ApiOperation(value = "根据条件，查询联系人列表", httpMethod = "POST", notes = "根据条件，查询联系人列表")
    @PostMapping(value = "/list")
    public Result list(@RequestBody BifCommunicationServiceContact contact) {
        log.info("根据条件，查询联系人列表-开始 入参："+contact.toString());
        Result result = service.list(contact);
        log.info("根据条件，查询联系人列表-结束");
        return result;
    }

    @ApiOperation(value = "查询某个服务商下面的联系人列表", httpMethod = "POST", notes = "查询某个服务商下面的联系人列表")
    @PostMapping(value = "/listByServiceId")
    public Result listByServiceId(@RequestBody BifCommunicationServiceContact contact) {
        log.info("查询某个服务商下面的联系人列表-开始 入参：contact："+contact.toString());
        Result result = service.listByServiceId(contact);
        log.info("查询某个服务商下面的联系人列表-结束");
        return result;
    }

    @ApiOperation(value = "新增/编辑服务商联系人", httpMethod = "POST", notes = "新增/编辑服务商联系人")
    @PostMapping(value = "/handle")
    public Result handle(@RequestBody BifCommunicationServiceContact contact) {
        log.info("新增/编辑服务商联系人-开始 入参："+contact.toString());
        Result result = service.handle(contact);
        log.info("新增/编辑服务商联系人-结束");
        return result;
    }

    @ApiOperation(value = "失效/删除服务商联系人", httpMethod = "POST", notes = "失效/删除服务商联系人")
    @PostMapping(value = "/handleInvalidDelete")
    public Result handleInvalidDelete(@RequestBody HandleInvalidDeleteDTO dto) {
        log.info("失效/删除服务商联系人-开始 ");
        Result result = service.handleInvalidDelete(dto);
        log.info("失效/删除服务商联系人-结束");
        return result;
    }

    @ApiOperation(value = "查询服务商联系人详情", httpMethod = "GET", notes = "查询服务商联系人详情")
    @GetMapping(value = "/show")
    public Result show(@RequestParam Integer id) {
        log.info("查询服务商联系人详情-开始");
        Result result = service.show(id);
        log.info("查询服务商联系人详情-结束");
        return result;
    }

}
