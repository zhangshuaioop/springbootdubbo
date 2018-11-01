package com.baojufeng.servicepublic.controller;

import com.baojufeng.cloudfeign.client.UserMicroService;
import com.baojufeng.commoncomponets.entity.user.User;
import com.baojufeng.commoncomponets.utils.Result;
import com.baojufeng.commoncomponets.utils.ResultUtil;
import com.baojufeng.servicepublic.service.ProducerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


/**
 * @description: alibaba RocketMq服务
 * @author: zhangshuai
 * @create: 2018-10-24 16:51
 */
@Api(value = "RocketMqController", tags = "alibaba RocketMq")
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
    @RequestMapping(value = "/findPage",method=RequestMethod.POST)
    public Result findPage(@RequestBody User user) {

        return userMicroService.findPage(user);
    }

    //远程调用
//    @RequestMapping(value="testServiceB",method=RequestMethod.GET)
//    public String testServiceB(@RequestParam Integer a,@RequestParam Integer b){
//        RestTemplate restTemplate=new RestTemplate();
//        return restTemplate.getForObject("http://localhost:7075/add?a="+a+"&b="+b, String.class);
//    }

}
