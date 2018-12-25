package com.platform.springboot.controller.sys;

import com.platform.springboot.entity.sys.SysAnnouncement;
import com.platform.springboot.service.sys.SysAnnouncementService;
import com.platform.springboot.utils.Result;
import com.platform.springboot.utils.ResultUtil;
import com.platform.springboot.service.sys.SysAnnouncementService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/sysAnnouncement")
@Api(description = "首页公告")
public class SysAnnouncementController {

    @Autowired
    private SysAnnouncementService service;

    @ApiOperation(value = "查询最近的五条公告", httpMethod = "GET", notes = "查询最近的五条公告")
    @RequestMapping(value = "/getLastFive", method = RequestMethod.GET)
    public Result getLastFive() {
        List<SysAnnouncement> result = service.getLastFive();
        return ResultUtil.success(result);
    }


}
