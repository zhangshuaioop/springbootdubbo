package com.example.messenger.controller;


import com.example.messenger.entity.publicss.User;
import com.example.messenger.utils.RedisUtil;
import com.example.messenger.utils.Result;
import com.example.messenger.utils.ResultUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description: redis - 缓存
 * @author: zhangshuai
 * @create: 2018-11-14 15:00
 */
@Api(value = "RedisController", tags = "redis-controller")
@RestController
@RequestMapping(value = "/redis")
public class RedisController {



    @Autowired
    private RedisUtil redisUtil;

    @ApiOperation(
            value = "redis测试",
            notes = "redis测试",
            consumes = "application/json",
            responseReference = "com.example.messenger.utils.Result"
    )
    @SuppressWarnings("unchecked")
    @RequestMapping(value = "/test",method=RequestMethod.POST)
    public Result test(@RequestBody User user) {
        redisUtil.set("uuuu","hfidshgljfsdlkj");

        return ResultUtil.success(redisUtil.get("haha"));
    }

}
