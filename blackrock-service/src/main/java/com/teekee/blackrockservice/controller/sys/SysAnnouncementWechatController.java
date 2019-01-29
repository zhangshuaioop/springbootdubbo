package com.teekee.blackrockservice.controller.sys;

import com.teekee.blackrockservice.base.BaseController;
import com.teekee.blackrockservice.entity.sys.GetSysAnnouncementWechatList;
import com.teekee.blackrockservice.entity.sys.GetSysAnnouncementWechatShow;
import com.teekee.blackrockservice.service.sys.SysAnnouncementWechatService;
import com.teekee.blackrockservice.utils.StringUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author Niting
 * @date 2018/11/2
 **/
@Api(value = "SysAnnouncementWechatController", tags = "announcementWechat-service")
@RestController
@RequestMapping("announcement")
public class SysAnnouncementWechatController extends BaseController{
    private Logger log = Logger.getLogger(SysAnnouncementWechatController.class);
    @Resource
    private SysAnnouncementWechatService service;

    @ApiOperation(
            value = "公告列表",
            notes = "公告列表",
            consumes = "application/json",
            responseReference = "com.example.timemachine.utils.Result"
    )
    @GetMapping(value = "/noticeList")
    public String noticeList() {
        log.info("公告列表-开始");
        List<GetSysAnnouncementWechatList> result = service.noticeList();
        log.info("公告列表-结束");
        return build(StringUtil.buildJsonSucessRespMsg(result));
    }

    @ApiOperation(
            value = "查看公告详情",
            notes = "查看公告详情",
            consumes = "application/json",
            responseReference = "com.example.timemachine.utils.Result"
    )
    @GetMapping(value = "/noticeShow")
    public String noticeShow(@RequestParam("id") Integer id) {
        log.info("查看公告详情-开始");
        GetSysAnnouncementWechatShow result = service.noticeShow(id);
        log.info("查看公告详情-结束");
        return build(StringUtil.buildJsonSucessRespMsg(result));
    }
}
