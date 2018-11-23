package com.example.messenger.controller;

import com.example.messenger.entity.message.Email;
import com.example.messenger.enums.BusinessEnum;
import com.example.messenger.service.rocketmq.ProducerService;
import com.example.messenger.utils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @description: 邮件
 * @author: zhangshuai
 * @create: 2018-11-12 16:30
 */
@Api(value = "EmailController", tags = "email-controller")
@RestController
@RequestMapping(value = "/email")
public class EmailController {

    private final Logger logger = Logger.getLogger(getClass());


    @Autowired
    private ProducerService producerService;

    @ApiOperation(
            value = "邮箱发送服务",
            notes = "邮箱发送服务",
            consumes = "application/json",
            responseReference = "com.example.messenger.utils.Result"
    )
    @SuppressWarnings("unchecked")
    @PostMapping(value = "/sendEmail")
    public Result sendEmail(@RequestBody Email email) {

        Map<String,Object> map = new HashMap<>();
        map.put("type",BusinessEnum.EMAIL.getType());
        map.put("object",email);
        map.put("messageId",email.getMessageId());
        logger.info("邮箱发送服务开始,入参:"+map.toString());
        Result result = producerService.producer(map);
        logger.info("邮箱发送服务结束,出参:"+result.toString());
        return result;
    }

}
