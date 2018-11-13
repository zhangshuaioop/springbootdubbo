package com.baojufeng.servicemessage.controller;

import com.baojufeng.commoncomponets.entity.message.Email;
import com.baojufeng.commoncomponets.entity.user.User;
import com.baojufeng.commoncomponets.utils.PageInfo;
import com.baojufeng.commoncomponets.utils.Result;
import com.baojufeng.commoncomponets.utils.ResultUtil;
import com.baojufeng.servicemessage.service.EmailService;
import com.github.pagehelper.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description: 邮件
 * @author: zhangshuai
 * @create: 2018-11-12 16:30
 */
@Api(value = "EmailController", tags = "email-service")
@RestController
@RequestMapping(value = "/email")
public class EmailController {

    @Autowired
    private EmailService emailService;

    @ApiOperation(
            value = "邮箱发送服务",
            notes = "邮箱发送服务",
            consumes = "application/json",
            responseReference = "com.baojufeng.commoncomponets.utils.Result"
    )
    @SuppressWarnings("unchecked")
    @PostMapping(value = "/sendEmail")
    public Result sendEmail(@RequestBody Email email) {
        return emailService.sendEmail(email);
    }

}
