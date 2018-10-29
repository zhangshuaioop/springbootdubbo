package com.lovnx.serviceuser.controller;

import com.feign.client.RocketMqMicroService;
import com.github.pagehelper.Page;
import com.lovnx.commoncomponets.utils.PageInfo;
import com.lovnx.commoncomponets.utils.Result;
import com.lovnx.commoncomponets.utils.ResultUtil;
import com.lovnx.serviceuser.entity.User;
import com.lovnx.serviceuser.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



/**
 * @description: 用户基础服务
 * @author: zhangshuai
 * @create: 2018-10-25 14:49
 */
@Api(value = "UserController", tags = "用户基础服务")
@RestController
@RequestMapping(value = "/user")
public class UserController {

    private final Logger logger = Logger.getLogger(getClass());

    @Autowired
    private UserService userService;

    @Autowired
    private RocketMqMicroService rocketMqMicroService;

    @ApiOperation(
            value = "用户分页查询",
            notes = "用户分页查询",
            consumes = "application/json",
            responseReference = "com.lovnx.commoncomponets.utils.Result"
    )
    @SuppressWarnings("unchecked")
    @RequestMapping(value = "/findPage" ,method = RequestMethod.GET)
    public Result findPage(@RequestParam Long id) {

        Page<User> persons = userService.findByPage(1, 2);
        // 需要把Page包装成PageInfo对象才能序列化。该插件也默认实现了一个PageInfo
        PageInfo<User> pageInfo = new PageInfo<>(persons);
        logger.debug(pageInfo.toString());

        return ResultUtil.success(pageInfo);
    }


    @ApiOperation(
            value = "远程服务调用public",
            notes = "远程服务调用public",
            consumes = "application/json",
            responseReference = "com.lovnx.publicdservice.config.Result"
    )
    @SuppressWarnings("unchecked")
    @RequestMapping(value = "/producer" ,method = RequestMethod.GET)
    public Result producer() {

        return ResultUtil.success(rocketMqMicroService.producer());
    }



}
