package com.baojufeng.serviceuser.controller;

import com.baojufeng.cloudfeign.client.RocketMqMicroService;
import com.baojufeng.commoncomponets.entity.user.User;
import com.baojufeng.commoncomponets.utils.PageInfo;
import com.baojufeng.commoncomponets.utils.Result;
import com.baojufeng.commoncomponets.utils.ResultUtil;
import com.baojufeng.serviceuser.service.UserService;
import com.github.pagehelper.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * @description: 用户基础服务
 * @author: zhangshuai
 * @create: 2018-10-25 14:49
 */
@Api(value = "UserController", tags = "user-service")
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
            responseReference = "com.baojufeng.commoncomponets.utils.Result"
    )
    @SuppressWarnings("unchecked")
    @PostMapping(value = "/findPage")
    public Result findPage(@RequestBody User user) {

        Page<User> persons = userService.findPage(user);
        // 需要把Page包装成PageInfo对象才能序列化。该插件也默认实现了一个PageInfo
        PageInfo<User> pageInfo = new PageInfo<>(persons);

        return ResultUtil.success(pageInfo);
    }


    @ApiOperation(
            value = "远程服务调用public",
            notes = "远程服务调用public",
            consumes = "application/json",
            responseReference = "com.lovnx.publicdservice.config.Result"
    )
    @SuppressWarnings("unchecked")
    @RequestMapping(value = "/producer", method = RequestMethod.GET)
    public Result producer() {

        return ResultUtil.success(rocketMqMicroService.producer());
    }


}
