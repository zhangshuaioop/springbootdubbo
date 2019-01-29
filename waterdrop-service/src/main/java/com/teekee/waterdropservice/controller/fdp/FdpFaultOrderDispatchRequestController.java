package com.teekee.waterdropservice.controller.fdp;

import com.teekee.waterdropservice.entity.fdp.FdpFaultOrderDispatchRequest;
import com.teekee.waterdropservice.entity.fdp.ParamFdpFaultDispatchRequestQuery;
import com.teekee.waterdropservice.service.fdp.FdpFaultOrderDispatchRequestService;
import com.teekee.commoncomponets.utils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.HashMap;

/**
 * @author zhanghao
 * @Title: FdpFaultOrderDispatchRequestController
 * @ProjectName WaterDrop
 * @Description: 派工
 * @date 2018/12/20下午2:32
 */
@RestController
@RequestMapping("/fdpFaultOrderDispatchRequest")
@Api(description = "派工")
public class FdpFaultOrderDispatchRequestController {

    private Logger log = Logger.getLogger(FdpFaultOrderDispatchRequestController.class);

    @Resource
    private FdpFaultOrderDispatchRequestService service;

    @ApiOperation(value = "新增派工信息", httpMethod = "POST")
    @RequestMapping(value = "/handle", method = RequestMethod.POST)
    public Result confirm(@RequestBody FdpFaultOrderDispatchRequest dispatchRequest) {
        log.info("新增派工信息-开始");
        Result result = service.handle(dispatchRequest);
        log.info("新增派工信息-结束");
        return result;
    }

    @ApiOperation(value = "编辑派工模板路径信息", httpMethod = "POST")
    @RequestMapping(value = "/profile", method = RequestMethod.POST)
    public Result profile(@RequestBody FdpFaultOrderDispatchRequest dispatchRequest) {
        log.info("编辑派工模板路径信息-开始");
        Result result = service.profile(dispatchRequest);
        log.info("编辑派工模板路径信息-结束");
        return result;
    }

    @ApiOperation(value = "查看派工信息", notes = "id 对应request表的id", httpMethod = "GET")
    @RequestMapping(value = "/show", method = RequestMethod.GET)
    public Result show(@RequestParam Integer id) {
        log.info("查看派工信息-开始");
        Result result = service.show(id);
        log.info("查看派工信息-结束");
        return result;
    }

    @ApiOperation(value = "查看派工人员信息", notes = "id 对应request表的id", httpMethod = "GET")
    @RequestMapping(value = "/showDispatch", method = RequestMethod.GET)
    public Result showDispatch(@RequestParam Integer id) {
        log.info("查看派工人员信息-开始");
        Result result = service.showDispatch(id);
        log.info("查看派工人员信息-结束");
        return result;
    }

    @RequestMapping(value = "/getFaultOrderRequestListByObject", method = RequestMethod.POST)
    public Result getFaultOrderRequestListByObject(@RequestBody ParamFdpFaultDispatchRequestQuery paramFdpFaultDispatchRequestQuery) {
        log.info("查询派工信息-开始");
        Result result = service.getFaultOrderRequestListByObject(paramFdpFaultDispatchRequestQuery);
        log.info("查询派工信息-结束");
        return result;
    }

    @ApiOperation(value = "查看派工信息", notes = "id 对应request表的id", httpMethod = "GET")
    @GetMapping(value = "/showNew")
    public Result showNew(@RequestParam Integer id) {
        log.info("查看派工信息-开始");
        Result result = service.showNew(id);
        log.info("查看派工信息-结束");
        return result;
    }

    @ApiOperation(value = "查看派工申请人信息", httpMethod = "GET")
    @GetMapping(value = "/listDispatchApplyUser")
    public Result listDispatchApplyUser() {
        log.info("查看派工申请人信息 - 开始");
        Result result = service.selectApplyUser();
        log.info("查看派工申请人信息 - 结束");
        return result;
    }

    @ApiOperation(value = "派工单导入--上传excel", httpMethod = "POST", notes = "上传派工单excel")
    @PostMapping(value = "/uploadOrderExcel")
    public Result uploadOrderExcel(@RequestParam("file") MultipartFile file) {
        log.info("派工单导入--上传excel-开始");
        Result result = service.uploadOrderExcel(file);
        log.info("派工单导入--上传excel-结束");
        return result;
    }

    @ApiOperation(value = "派工单导入--校验文件头部", httpMethod = "GET", notes = "上传派工单-校验文件头部")
    @GetMapping(value = "/checkModelTitle")
    public Result checkModelTitle(@RequestParam String fileName) {
        log.info("派工单导入--校验文件头部-开始");
        Result result = service.checkModelTitle(fileName);
        log.info("派工单导入--校验文件头部-结束");
        return result;
    }

    @ApiOperation(value = "派工单导入--校验数据量", httpMethod = "GET", notes = "上传派工单-校验数据量")
    @GetMapping(value = "/checkExcelNumber")
    public Result checkExcelNumber(@RequestParam String fileName) {
        log.info("派工单导入--校验模版头部-开始");
        Result result = service.checkExcelNumber(fileName);
        log.info("派工单导入--校验模版头部-结束");
        return result;
    }

    @ApiOperation(value = "派工单导入--校验文件内容", httpMethod = "POST", notes = "上传派工单-校验文件内容")
    @PostMapping(value = "/checkExcel")
    public Result checkExcel(@RequestBody FdpFaultOrderDispatchRequest dispatchRequest) {
        log.info("派工单导入--校验文件内容-开始");
        Result result = service.checkExcel(dispatchRequest);
        log.info("派工单导入--校验文件内容-结束");
        return result;
    }

    @ApiOperation(value = "派工单导入--存储工单内容", httpMethod = "POST", notes = "上传派工单-存储工单内容")
    @PostMapping(value = "/storageExcel")
    public Result storageExcel(@RequestBody FdpFaultOrderDispatchRequest dispatchRequest) {
        log.info("派工单导入--存储工单内容-开始");
        Result result = service.storageExcel(dispatchRequest);
        log.info("派工单导入--存储工单内容-结束");
        return result;
    }

    @ApiOperation(value = "派工单导入--计算百分比", httpMethod = "GET", notes = "上传派工单-计算百分比")
    @GetMapping(value = "/calculatedPercentage")
    public Result calculatedPercentage(@RequestParam String fileName) {
        log.info("派工单导入--计算百分比-开始");
        Result result = service.calculatedPercentage(fileName);
        log.info("派工单导入--计算百分比-结束");
        return result;
    }

    @ApiOperation(value = "导出雇主下所有门店信息", httpMethod = "POST", notes = "导出雇主下所有门店信息")
    @GetMapping(value = "/storeExport")
    public Result storeExport(@RequestParam Integer companyId) {
        log.info("导出雇主下所有门店信息-开始");
        Result result = service.storeExport(companyId);
        log.info("导出雇主下所有门店信息-结束");
        return result;
    }

    @ApiOperation(value = "派工导出", httpMethod = "POST", notes = "派工导出")
    @PostMapping(value = "/dispatchDownLoad")
    public Result dispatchDownLoad(@RequestBody ParamFdpFaultDispatchRequestQuery paramFdpFaultDispatchRequestQuery) {
        log.info("派工导出-开始");
        Result result = service.dispatchDownLoad(paramFdpFaultDispatchRequestQuery);
        log.info("派工导出-结束");
        return result;
    }

    @ApiOperation(value = "派工转发", httpMethod = "POST")
    @PostMapping(value = "/dispatchForward")
    public Result dispatchForward(@RequestBody HashMap<String, Object> reqJsonMap) {
        log.info("派工转发-开始");
        Result result = service.dispatchForward(reqJsonMap);
        log.info("派工转发-结束");
        return result;
    }

}
