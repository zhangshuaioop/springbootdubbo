package com.baojufeng.serviceuser.controller;

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


    @ApiOperation(
            value = "用户分页查询",
            notes = "用户分页查询",
            consumes = "application/json",
            responseReference = "com.baojufeng.commoncomponets.utils.Result"
    )
    @SuppressWarnings("unchecked")
    @PostMapping(value = "/findPage")
    public Result findPage(@RequestBody User user) {
        return userService.findPage(user);
    }



}
