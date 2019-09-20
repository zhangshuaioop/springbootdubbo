package com.example.messenger.controller;

import com.baojufeng.commoncomponets.entity.message.publicss.User;
import com.baojufeng.commoncomponets.utils.PageInfo;
import com.baojufeng.commoncomponets.utils.Result;
import com.baojufeng.commoncomponets.utils.ResultUtil;
import com.example.messenger.service.user.UserService;
import com.github.pagehelper.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description: 数据库连接测试
 * @author: zhangshuai
 * @create: 2018-11-22 16:39
 */
@Api(value = "UserController", tags = "User-controller")
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

        logger.info("用户分页查询开始，入参:"+user.toString());
        Page<User> persons = userService.findPage(user);
        // 需要把Page包装成PageInfo对象才能序列化。该插件也默认实现了一个PageInfo
        PageInfo<User> pageInfo = new PageInfo<>(persons);
        logger.info("用户分页查询结束，出参:"+pageInfo.toString());

        return ResultUtil.success(pageInfo);
    }

}
