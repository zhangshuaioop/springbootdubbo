package com.example.messenger.controller;

import com.baojufeng.commoncomponets.client.UserMicroService;
import com.baojufeng.commoncomponets.entity.message.message.Chat;
import com.baojufeng.commoncomponets.utils.Result;
import com.baojufeng.commoncomponets.utils.ResultUtil;
import com.example.messenger.service.socket.WebSocketServer;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;

/**
 * @description: web聊天
 * @author: zhangshuai
 * @create: 2018-11-02 09:26
 */
@Api(value = "ChatController", tags = "chat-controller")
@RestController
@RequestMapping("/chat")
@CrossOrigin
public class ChatController {
    //页面请求
    @GetMapping("/socket/{cid}")
    public ModelAndView socket(@PathVariable String cid) {
        ModelAndView mav=new ModelAndView("/socket");
        mav.addObject("cid", cid);
        return mav;
    }
    //推送数据接口
    @ApiOperation(
            value = "推送数据服务",
            notes = "推送数据服务",
            consumes = "application/json",
            responseReference = "com.example.messenger.utils.Result"
    )
    @SuppressWarnings("unchecked")
    @RequestMapping(value = "/push",method=RequestMethod.POST)
    public Result push(@RequestBody Chat chatRequest) {
        try {
            WebSocketServer.sendInfo(chatRequest.getMessage(),chatRequest.getCid());
        } catch (IOException e) {
            e.printStackTrace();
            return ResultUtil.error(100,chatRequest.getCid()+"#"+e.getMessage());
        }
        return ResultUtil.success();
    }


    @RequestMapping(value = "/updatePermissionApi",method=RequestMethod.POST)
    public Result updatePermissionApi(@RequestBody Chat chat) {
        String cid =  chat.getCid();
        System.out.print(chat.getCid());
        return ResultUtil.success();
    }

}
