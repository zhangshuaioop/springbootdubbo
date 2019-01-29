package com.teekee.blueoceanservice.controller.sysconsole;

import com.teekee.blueoceanservice.entity.sysconsole.SysAnnouncementWechat;
import com.teekee.blueoceanservice.service.sysconsole.SysAnnouncementWechatService;
import com.teekee.commoncomponets.utils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author zhanghao
 * @Title: SysAnnouncementWechatController
 * @ProjectName BlueOcean
 * @Description: 服务商公告
 * @date 2019/1/2下午2:01
 */

@RestController
@RequestMapping("/announcementWechat")
@Api(description = "服务商公告")
public class SysAnnouncementWechatController {

    private Logger log = Logger.getLogger(SysAnnouncementWechatController.class);

    @Resource
    private SysAnnouncementWechatService service;


    @ApiOperation(value = "查询服务商公告", httpMethod = "POST", notes = "查询服务商公告")
    @PostMapping(value = "/list")
    public Result list(@RequestBody SysAnnouncementWechat sysAnnouncementWechat) {
        log.info("查询服务商公告-开始 入参："+sysAnnouncementWechat);
        Result result = service.list(sysAnnouncementWechat);
        log.info("查询服务商公告-结束");
        return result;
    }

    @ApiOperation(value = "查看服务商公告详情", httpMethod = "GET", notes = "查看服务商公告详情")
    @GetMapping(value = "/show")
    public Result show(@RequestParam Integer id) {
        log.info("查看服务商公告-开始");
        Result result = service.show(id);
        log.info("查看服务商公告-结束");
        return result;
    }

    @ApiOperation(value = "新增/编辑服务商公告", httpMethod = "POST", notes = "新增/编辑服务商公告")
    @PostMapping(value = "/handle")
    public Result handle(@RequestBody SysAnnouncementWechat sysAnnouncementWechat) {
        log.info("新增/编辑服务商公告-开始 入参："+sysAnnouncementWechat.toString());
        Result result = service.handle(sysAnnouncementWechat);
        log.info("新增/编辑服务商公告-结束");
        return result;
    }

    @ApiOperation(value = "发布服务商公告", httpMethod = "POST", notes = "发布服务商公告")
    @PostMapping(value = "/publish")
    public Result publishNotice(@RequestBody SysAnnouncementWechat sysAnnouncementWechat) {
        log.info("发布服务商公告-开始");
        Result result = service.publishNotice(sysAnnouncementWechat);
        log.info("发布服务商公告-结束");
        return result;
    }

    @ApiOperation(value = "撤回服务商公告", httpMethod = "GET", notes = "撤回服务商公告")
    @GetMapping(value = "/recall")
    public Result recallNotice(@RequestParam Integer id) {
        log.info("撤回服务商公告-开始");
        Result result = service.recall(id);
        log.info("撤回服务商公告-结束");
        return result;
    }

    @ApiOperation(value = "删除服务商公告", httpMethod = "GET", notes = "删除服务商公告")
    @GetMapping(value = "/delete")
    public Result deleteNotice(@RequestParam Integer id) {
        log.info("删除服务商公告-开始");
        Result result = service.delete(id);
        log.info("删除服务商公告-结束");
        return result;
    }
}
