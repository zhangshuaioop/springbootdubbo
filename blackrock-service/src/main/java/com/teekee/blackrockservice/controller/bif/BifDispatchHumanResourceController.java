package com.teekee.blackrockservice.controller.bif;

import com.alibaba.fastjson.JSON;
import com.teekee.blackrockservice.base.BaseController;
import com.teekee.blackrockservice.entity.bif.*;
import com.teekee.blackrockservice.service.bif.BifDispatchHumanResourceService;
import com.teekee.blackrockservice.utils.ResponseMessage;
import com.teekee.blackrockservice.utils.StringUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author Niting
 * @date 2018/11/2
 **/
@Api(value = "BifDispatchHumanResourceController", tags = "humanResource-service")
@RestController
@RequestMapping("serv/humanResource")
public class BifDispatchHumanResourceController extends BaseController{
    private Logger log = Logger.getLogger(BifDispatchHumanResourceController.class);
    @Autowired
    private BifDispatchHumanResourceService service;

    @ApiOperation(value = "服务商基础信息", notes = "服务商基础信息", consumes = "application/json", responseReference = "com.example.timemachine.utils.Result")
    @GetMapping(value = "/serviceInfo")
    public String serviceInfo(HttpServletRequest request){
        Integer hrId = getTokenFromHead(request);
        log.info("服务商基础信息-开始");
        BifDispatchHumanResourceInfoShow result = service.serviceInfo(hrId);
        log.info("服务商基础信息-结束");
        return build(StringUtil.buildJsonSucessRespMsg(result));
    }


    @ApiOperation(value = "服务商基础信息编辑", notes = "服务商基础信息编辑", consumes = "application/json", responseReference = "com.example.timemachine.utils.Result")
    @PostMapping(value = "/serviceEdit")
    public String serviceEdit(@RequestBody BifDispatchHumanResourceInfoShow param, HttpServletRequest request){
        log.info("服务商基础信息编辑-开始");
        Integer hrId = getTokenFromHead(request);
        ResponseMessage result = service.serviceEdit(param,hrId);
        log.info("服务商基础信息编辑-结束");
        return build(result);
    }


    @ApiOperation(value = "服务商认证信息查询", notes = "服务商认证信息查询", consumes = "application/json", responseReference = "com.example.timemachine.utils.Result")
    @GetMapping(value = "/serviceInfoShow")
    public String serviceInfoShow(HttpServletRequest request){
        Integer hrId = getTokenFromHead(request);
        log.info("服务商认证信息查询-开始");
        GetHumanResourceServiceInfoShow result = service.serviceInfoShow(hrId);
        log.info("服务商认证信息查询-结束");
        return build(StringUtil.buildJsonSucessRespMsg(result));
    }


    @ApiOperation(value = "服务商认证信息新增&编辑", notes = "服务商认证信息新增&编辑", consumes = "application/json", responseReference = "com.example.timemachine.utils.Result")
    @PostMapping(value = "/handleServiceInfo")
    public String handleServiceInfo(@RequestBody String json, HttpServletRequest request){
        log.info("服务商认证信息新增&编辑-开始");
        Integer hrId = getTokenFromHead(request);
        BifDispatchHumanResource resource = JSON.parseObject(json, BifDispatchHumanResource.class);
        BifDispatchHrAutonymValid valid = JSON.parseObject(json, BifDispatchHrAutonymValid.class);
        resource.setId(hrId);
        ResponseMessage result = service.handleServiceInfo(resource,valid);
        log.info("服务商认证信息新增&编辑-结束");
        return build(result);
    }


    @ApiOperation(value = "查询关联公司&发票", notes = "查询关联公司&发票", consumes = "application/json", responseReference = "com.example.timemachine.utils.Result")
    @GetMapping(value = "/companyInvoiceShow")
    public String companyInvoiceShow(HttpServletRequest request){
        log.info("查询关联公司&发票-开始");
        Integer hrId = getTokenFromHead(request);
        GetHumanResourceCompanyInvoice result = service.companyInvoiceShow(hrId);
        log.info("查询关联公司&发票-结束");
        return build(StringUtil.buildJsonSucessRespMsg(result));
    }


    @ApiOperation(value = "编辑关联公司&发票信息", notes = "编辑关联公司&发票信息", consumes = "application/json", responseReference = "com.example.timemachine.utils.Result")
    @PostMapping(value = "/updateCompanyInvoice")
    public String updateCompanyInvoice(@RequestBody BifDispatchHumanResource param, HttpServletRequest request){
        log.info("编辑关联公司&发票信息-开始");
        Integer hrId = getTokenFromHead(request);
        param.setId(hrId);
        ResponseMessage result = service.updateCompanyInvoice(param);
        log.info("编辑关联公司&发票信息-结束");
        return build(result);
    }
}
