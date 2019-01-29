package com.teekee.blueoceanservice.controller.syscompany;

import com.teekee.blueoceanservice.entity.syscompany.SysAnnouncement;
import com.teekee.blueoceanservice.service.syscompany.SysAnnouncementService;
import com.teekee.commoncomponets.utils.Result;
import com.teekee.commoncomponets.utils.ResultUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/sysAnnouncement")
@Api(description = "首页公告")
public class SysAnnouncementController {

    private Logger log = Logger.getLogger(SysAnnouncementController.class);
    @Autowired
    private SysAnnouncementService service;

    @ApiOperation(value = "查询最近的五条公告", httpMethod = "GET", notes = "查询最近的五条公告")
    @GetMapping(value = "/getLastFive")
    public Result getLastFive() {
        List<SysAnnouncement> result = service.getLastFive();
        return ResultUtil.success(result);
    }

    @ApiOperation(value = "公告分页列表", httpMethod = "POST", notes = "公告分页列表")
    @PostMapping(value = "/list")
    public Result list(@RequestBody SysAnnouncement sysAnnouncement) {
        Result result = service.list(sysAnnouncement);
        return result;
    }

    @ApiOperation(value = "新增/编辑系统公告", httpMethod = "POST", notes = "新增/编辑系统公告")
    @PostMapping(value = "/handle")
    public Result handle(@RequestBody SysAnnouncement sysAnnouncement) {
        Result result = service.handle(sysAnnouncement);
        return result;
    }

    @ApiOperation(value = "查看公告", httpMethod = "GET", notes = "查看公告")
    @GetMapping(value = "/show")
    public Result show(@RequestParam Integer id) {
        log.info("查看服务商公告-开始");
        Result result = service.show(id);
        log.info("查看服务商公告-结束");
        return result;
    }

    @ApiOperation(value = "删除公告", httpMethod = "GET", notes = "删除公告")
    @GetMapping(value = "/delete")
    public Result delete(@RequestParam Integer id) {
        log.info("删除公告-开始");
        Result result = service.delete(id);
        log.info("删除公告-结束");
        return result;
    }


}
