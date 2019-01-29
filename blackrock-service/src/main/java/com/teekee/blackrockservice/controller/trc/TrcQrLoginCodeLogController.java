package com.teekee.blackrockservice.controller.trc;

import com.teekee.blackrockservice.base.BaseController;
import com.teekee.blackrockservice.entity.trc.ParamTrcQrLoginVerify;
import com.teekee.blackrockservice.service.trc.TrcQrLoginCodeLogService;
import com.teekee.blackrockservice.utils.ResponseMessage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author Niting
 * @date 2018/11/21
 **/
@Api(value = "TrcQrLoginCodeLogController", tags = "qrLogin-service")
@RestController
@RequestMapping("/qrLoginCodeLog")
public class TrcQrLoginCodeLogController extends BaseController{
    private Logger log = Logger.getLogger(TrcQrLoginCodeLogController.class);
    @Resource
    private TrcQrLoginCodeLogService service;

    @ApiOperation(value = "服务商二维码登录验证", notes = "服务商二维码登录验证", consumes = "application/json", responseReference = "com.example.timemachine.utils.ResponseMessage")
    @PostMapping(value = "/verifyQrCode")
    public String verifyQrCode(@RequestBody ParamTrcQrLoginVerify param, HttpServletRequest request) {
        log.info("服务商二维码登录验证-开始");
        Integer hrId = getTokenFromHead(request);
        ResponseMessage result = service.verifyQrCode(param,hrId);
        log.info("服务商二维码登录验证-结束");
        return build(result);
    }


    @ApiOperation(value = "APP服务商二维码登录验证", notes = "APP服务商二维码登录验证", consumes = "application/json", responseReference = "com.example.timemachine.utils.ResponseMessage")
    @PostMapping(value = "/AppVerifyQrCode")
    public String AppVerifyQrCode(@RequestBody ParamTrcQrLoginVerify param, HttpServletRequest request) {
        log.info("APP服务商二维码登录验证-开始");
        ResponseMessage result = service.AppVerifyQrCode(param,request.getHeader("Token"));
        log.info("APP服务商二维码登录验证-结束");
        return build(result);
    }
}
