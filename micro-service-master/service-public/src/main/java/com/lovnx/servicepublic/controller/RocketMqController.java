package com.lovnx.servicepublic.controller;

import com.feign.client.UserMicroService;
import com.lovnx.commoncomponets.utils.Result;
import com.lovnx.commoncomponets.utils.ResultUtil;
import com.lovnx.servicepublic.service.ProducerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @description: alibaba RocketMq服务
 * @author: zhangshuai
 * @create: 2018-10-24 16:51
 */
@Api(value = "RocketMqController", tags = "alibaba RocketMq服务")
@RestController
@RequestMapping(value = "/rocketMq")
public class RocketMqController {

    private final Logger logger = Logger.getLogger(getClass());

    @Autowired
    private ProducerService producerService;

    @Autowired
    private UserMicroService userMicroService;

    @ApiOperation(
            value = "发送消息服务",
            notes = "发送消息服务",
            consumes = "application/json",
            responseReference = "com.lovnx.publicdservice.config.Result"
    )
    @SuppressWarnings("unchecked")
    @RequestMapping(value = "/producer" ,method = RequestMethod.GET)
    public Result producer() {

        return ResultUtil.success(producerService.producer());
    }




    @ApiOperation(
            value = "远程服务调用",
            notes = "远程服务调用",
            consumes = "application/json",
            responseReference = "com.lovnx.publicdservice.config.Result"
    )
    @SuppressWarnings("unchecked")
    @RequestMapping(value = "/findUser" ,method = RequestMethod.GET)
    public Result findUser(@RequestParam Integer id) {

        return userMicroService.findById(id);
    }

    //远程调用
//    @RequestMapping(value="testServiceB",method=RequestMethod.GET)
//    public String testServiceB(@RequestParam Integer a,@RequestParam Integer b){
//        RestTemplate restTemplate=new RestTemplate();
//        return restTemplate.getForObject("http://localhost:7075/add?a="+a+"&b="+b, String.class);
//    }

}
