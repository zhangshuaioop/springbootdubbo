package com.teekee.blackrockservice.controller.bif;

import com.teekee.blackrockservice.base.BaseController;
import com.teekee.blackrockservice.entity.bif.HumanResourceLoginParam;
import com.teekee.blackrockservice.entity.trc.SmsParam;
import com.teekee.blackrockservice.service.bif.BifDispatchHumanResourceService;
import com.teekee.blackrockservice.utils.ResponseMessage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;

/**
 * @Author Niting
 * @date 2018/11/9
 **/
@Api(value = "HumanResourceLoginController", tags = "humanResourceLogin-service")
@RestController
@RequestMapping("/humanResourceLogin")
public class HumanResourceLoginController extends BaseController{
    private Logger log = Logger.getLogger(HumanResourceLoginController.class);
    @Autowired
    private BifDispatchHumanResourceService service;

    @ApiOperation(value = "服务商APP登录", notes = "服务商APP登录",consumes = "application/json;charset=UTF-8", responseReference = "com.example.timemachine.utils.ResponseMessage")
    @PostMapping(value = "/login")
    public String serviceLogin(@RequestBody HumanResourceLoginParam param) {
        log.info("服务商APP登录-开始");
        ResponseMessage result = service.serviceLogin(param);
        log.info("服务商APP登录-结束");
        return build(result);
    }


    @ApiOperation(value = "服务商小程序登录", notes = "服务商小程序登录", consumes = "application/json", responseReference = "com.example.timemachine.utils.ResponseMessage")
    @PostMapping(value = "/wechatLogin")
    public String wechatLogin(@RequestBody HumanResourceLoginParam param) {
        log.info("服务商小程序登录-开始");
        ResponseMessage result = service.wechatLogin(param);
        log.info("服务商小程序登录-结束");
        return build(result);
    }

    @ApiOperation(value = "微信小程序手机验证码登录", notes = "微信小程序手机验证码登录", consumes = "application/json", responseReference = "com.example.timemachine.utils.ResponseMessage")
    @PostMapping(value = "/tellLogin")
    public String tellLogin(@RequestBody HumanResourceLoginParam param) {
        log.info("微信小程序手机验证码登录-开始");
        ResponseMessage result = service.tellLogin(param);
        log.info("微信小程序手机验证码登录-结束");
        return build(result);
    }

    @ApiOperation(value = "app手机验证码登录", notes = "app手机验证码登录", consumes = "application/json", responseReference = "com.example.timemachine.utils.ResponseMessage")
    @PostMapping(value = "/appTellLogin")
    public String appTellLogin(@RequestBody HumanResourceLoginParam param) {
        log.info("app手机验证码登录-开始");
        ResponseMessage result = service.appTellLogin(param);
        log.info("app手机验证码登录-结束");
        return build(result);
    }


    @ApiOperation(value = "服务商小程序自动登录", notes = "服务商小程序自动登录", consumes = "application/json", responseReference = "com.example.timemachine.utils.ResponseMessage")
    @GetMapping(value = "/serviceAutoLogin")
    public String serviceAutoLogin(HttpServletRequest request) {
        log.info("服务商小程序自动登录-开始");
        String token = request.getHeader("Token");
        ResponseMessage result = service.serviceAutoLogin(token);
        log.info("服务商小程序自动登录-结束");
        return build(result);
    }


    @ApiOperation(value = "服务商APP注册", notes = "服务商小程序注册", consumes = "application/json", responseReference = "com.example.timemachine.utils.ResponseMessage")
    @PostMapping(value = "/register")
    public String serviceRegister(@RequestBody HumanResourceLoginParam param) {
        log.info("服务商APP注册-开始");
        ResponseMessage result = service.serviceRegister(param);
        log.info("服务商APP注册-结束");
        return build(result);
    }


    @ApiOperation(value = "发送验证码", notes = "发送验证码", consumes = "application/json", responseReference = "com.example.timemachine.utils.ResponseMessage")
    @PostMapping(value = "/getCode")
    public String batchUploadImage(@RequestBody SmsParam param) throws UnsupportedEncodingException {
        log.info("发送验证码-开始");
        ResponseMessage result = service.getCode(param);
        log.info("发送验证码-结束");
        return build(result);
    }


    @ApiOperation(value = "服务商找回密码", notes = "服务商APP找回密码", consumes = "application/json", responseReference = "com.example.timemachine.utils.ResponseMessage")
    @PostMapping(value = "/retrievePassword")
    public String retrievePassword(@RequestBody HumanResourceLoginParam param){
        log.info("服务商APP找回密码-开始");
        ResponseMessage result = service.retrievePassword(param);
        log.info("服务商APP找回密码-结束");
        return build(result);
    }
}
