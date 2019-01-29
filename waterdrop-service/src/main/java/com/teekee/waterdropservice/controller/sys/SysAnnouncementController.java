package com.teekee.waterdropservice.controller.sys;

import com.teekee.waterdropservice.entity.sys.SysAnnouncement;
import com.teekee.waterdropservice.service.sys.SysAnnouncementService;
import com.teekee.commoncomponets.utils.Result;
import com.teekee.commoncomponets.utils.ResultUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
