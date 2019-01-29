package com.teekee.blueoceanservice.controller.bif;

import com.teekee.commoncomponets.utils.Result;
import com.teekee.blueoceanservice.entity.bif.BifDispatchHrAccountInfo;
import com.teekee.blueoceanservice.service.bif.BifDispatchHrAccountInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author zhanghao
 * @Title: BifDispatchHrAccountInfoController
 * @ProjectName BlueOcean
 * @Description: 人力服务商账号
 * @date 2018/12/29下午1:35
 */
@Api(description = "人力服务商账号")
@RestController
@RequestMapping("/bifDispatchHrAccountInfo")
public class BifDispatchHrAccountInfoController {

    private Logger log = Logger.getLogger(BifDispatchHrAccountInfoController.class);

    @Resource
    private BifDispatchHrAccountInfoService service;


    @ApiOperation(value = "人力服务商账号列表", httpMethod = "POST")
    @PostMapping(value = "/list")
    public Result list(@RequestBody BifDispatchHrAccountInfo bifDispatchHrAccountInfo) {
        log.info("人力服务商账号列表-开始");
        Result result = service.getHrAccountlist(bifDispatchHrAccountInfo);
        log.info("人力服务商账号列表-结束");
        return result;
    }

    @ApiOperation(value = "人力服务商账号详情", httpMethod = "GET")
    @GetMapping(value = "/show")
    public Result show(@RequestParam Integer id) {
        log.info("人力服务商账号详情-开始");
        Result result = service.getHrAccountShow(id);
        log.info("人力服务商账号详情-结束");
        return result;
    }

    @ApiOperation(value = "新增,更新人力服务商账号", httpMethod = "POST")
    @PostMapping(value = "/handle")
    public Result handle(@RequestBody BifDispatchHrAccountInfo accountInfo) {
        log.info("新增,更新人力服务商账号-开始 入参："+accountInfo.toString());
        Result result = service.handle(accountInfo);
        log.info("新增,更新人力服务商账号-结束");
        return result;
    }

    @ApiOperation(value = "派工人员默认帐号详情", httpMethod = "GET")
    @GetMapping(value = "/showDefault")
    public Result showDefault(@RequestParam Integer hrId) {
        log.info("派工人员指定帐号详情-开始");
        Result result = service.showDefaultHrAccount(hrId);
        log.info("派工人员指定帐号详情-结束");
        return result;
    }

    @ApiOperation(value = "账户删除", httpMethod = "GET")
    @GetMapping(value = "/accountDelete")
    public Result accountDelete(@RequestParam Integer id) {
        log.info("账户删除-开始");
        Result result  = service.accountDelete(id);
        log.info("账户删除-结束");
        return result;
    }

}
