package com.teekee.waterdropservice.controller.bif;

import com.teekee.waterdropservice.entity.bif.BifDispatchHrAutonymValid;
import com.teekee.waterdropservice.entity.bif.BifDispatchHumanResource;
import com.teekee.waterdropservice.entity.bif.BifServiceListParam;
import com.teekee.waterdropservice.entity.bif.DispatchHumanResourceList;
import com.teekee.waterdropservice.service.bif.BifDispatchHumanResourceService;
import com.teekee.commoncomponets.utils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author zhanghao
 * @Title: BifDispatchHumanResourceController
 * @Description: 人力服务商
 * @date 2018/12/28上午11:38
 */
@Api(description = "人力服务商")
@RestController
@RequestMapping("/bifDispatchHumanResource")
public class BifDispatchHumanResourceController {

    private Logger log = Logger.getLogger(BifDispatchHumanResourceController.class);

    @Resource
    private BifDispatchHumanResourceService service;

    @ApiOperation(value = "服务商人员List", httpMethod = "POST")
    @PostMapping(value = "/serviceList")
    public Result serviceList(@RequestBody BifServiceListParam serviceListParam) {
        log.info("服务商人员List-开始 入参:"+serviceListParam.toString());
        Result result = service.serviceListParam(serviceListParam);
        log.info("服务商人员List-结束");
        return result;
    }

    @ApiOperation(value = "根据某组条件,获取派工资源列表", httpMethod = "POST")
    @PostMapping(value = "/list")
    public Result list(@RequestBody DispatchHumanResourceList dispatchHumanResourceList) {
        log.info("根据某组条件,获取派工资源列表-开始 入参："+dispatchHumanResourceList.toString());
        Result result = service.list(dispatchHumanResourceList);
        log.info("根据某组条件,获取派工资源列表-结束");
        return result;
    }

    @ApiOperation(value = "查看派工人员详情", httpMethod = "GET")
    @GetMapping(value = "/show")
    public Result show(@RequestParam Integer id) {
        log.info("查看派工人员详情-开始 入参："+id);
        Result result = service.show(id);
        log.info("查看派工人员详情-结束");
        return result;
    }

    @ApiOperation(value = "新增/修改派工人员详情", httpMethod = "POST")
    @PostMapping(value = "/handle")
    public Result handle(@RequestBody BifDispatchHumanResource bifDispatchHumanResource) {
        log.info("查看派工人员详情-开始 入参："+bifDispatchHumanResource.toString());
        Result result = service.handle(bifDispatchHumanResource);
        log.info("查看派工人员详情-结束");
        return result;
    }

    @ApiOperation(value = "新增/修改服务商人员详情", httpMethod = "POST")
    @PostMapping(value = "/serviceHandle")
    public Result serviceHandle(@RequestBody BifDispatchHumanResource bifDispatchHumanResource) {
        log.info("新增/修改服务商人员详情-开始 入参:"+bifDispatchHumanResource.toString());
        Result result = service.serviceHandle(bifDispatchHumanResource);
        log.info("新增/修改服务商人员详情-结束");
        return result;
    }

    @ApiOperation(value = "查看服务商详情", httpMethod = "GET")
    @GetMapping(value = "/serviceShow")
    public Result serviceShow(@RequestParam Integer id) {
        log.info("查看服务商详情-开始");
        Result result = service.serviceShow(id);
        log.info("查看服务商详情-结束");
        return result;
    }

    @ApiOperation(value = "查看服务商权限详情", httpMethod = "GET")
    @GetMapping(value = "/servicePermissionShow")
    public Result servicePermissionShow(@RequestParam Integer id) {
        log.info("查看服务商权限详情-开始");
        Result result = service.servicePermissionShow(id);
        log.info("查看服务商权限详情-结束");
        return result;
    }

    @ApiOperation(value = "服务商冻结/解冻", httpMethod = "GET")
    @GetMapping(value = "/serviceAvailable")
    public Result serviceAvailable(@RequestParam Integer id , @RequestParam Integer available) {
        log.info("服务商冻结/解冻-开始");
        Result result  = service.serviceAvailable(id,available);
        log.info("服务商冻结/解冻-结束");
        return result;
    }

    @ApiOperation(value = "服务商审核", httpMethod = "POST")
    @PostMapping(value = "/serviceValid")
    public Result serviceValid(@RequestBody BifDispatchHrAutonymValid bifDispatchHrAutonymValid) {
        log.info("服务商审核-开始 入参："+bifDispatchHrAutonymValid.toString());
        Result result  = service.serviceValid(bifDispatchHrAutonymValid);
        log.info("服务商审核-结束");
        return result;
    }

    @ApiOperation(value = "服务商删除", httpMethod = "GET")
    @GetMapping(value = "/serviceDelete")
    public Result serviceDelete(@RequestParam Integer id ) {
        log.info("服务商删除-开始");
        Result result  = service.serviceDelete(id);
        log.info("服务商删除-结束");
        return result;
    }

    @ApiOperation(value = "服务商审核Show", httpMethod = "GET")
    @GetMapping(value = "/serviceCheckShow")
    public Result serviceCheck(@RequestParam Integer id ) {
        log.info("服务商审核Show-开始");
        Result result  = service.serviceCheck(id);
        log.info("服务商审核Show-结束");
        return result;
    }

    @ApiOperation(value = "服务商账号密码登录", httpMethod = "POST")
    @RequestMapping(value = "/serviceLogin", method = RequestMethod.POST, produces = "text/json;charset=UTF-8")
    public Result serviceLogin(@RequestBody BifDispatchHumanResource bifDispatchHumanResource) {
        log.info("服务商账号密码登录-开始 入参："+bifDispatchHumanResource);
        Result result = service.serviceLogin(bifDispatchHumanResource);
        log.info("服务商账号密码登录-结束");
        return result;
    }

    @ApiOperation(value = "校验服务商手机号", httpMethod = "GET")
    @GetMapping(value = "/checkHrMobile")
    public Result checkHrMobile(@RequestParam String mobile) {
        log.info("校验服务商手机号-开始");
        Result result = service.checkHrMobile(mobile);
        log.info("校验服务商手机号-结束");
        return result;
    }

    @ApiOperation(value = "校验服务商手机号编辑时验证", httpMethod = "GET")
    @GetMapping(value = "/checkHrMobileEdit")
    public Result checkHrMobileEdit(@RequestParam String mobile) {
        log.info("校验服务商手机号-开始");
        Result result = service.checkHrMobileEdit(mobile);
        log.info("校验服务商手机号-结束");
        return result;
    }

    @ApiOperation(value = "更新派工人员标签", httpMethod = "POST", notes ="更新派工人员标签")
    @PostMapping(value = "/updateLabel")
    public Result updateLabel(@RequestBody BifDispatchHumanResource bifDispatchHumanResource) {
        log.info("更新派工人员标签-开始");
        Result result  = service.updateLabel(bifDispatchHumanResource);
        log.info("更新派工人员标签-结束");
        return result;
    }

    @ApiOperation(value = "更新派工人员标签和自定义标签", httpMethod = "POST", notes ="更新派工人员标签")
    @PostMapping(value = "/updateLabels")
    public Result updateLabels(@RequestBody BifDispatchHumanResource bifDispatchHumanResource) {
        log.info("更新派工人员标签-开始");
        Result result  = service.updateLabels(bifDispatchHumanResource);
        log.info("更新派工人员标签-结束");
        return result;
    }
}
