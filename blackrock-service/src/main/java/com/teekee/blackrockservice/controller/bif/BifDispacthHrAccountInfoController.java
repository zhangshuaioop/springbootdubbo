package com.teekee.blackrockservice.controller.bif;

import com.teekee.blackrockservice.base.BaseController;
import com.teekee.blackrockservice.entity.bif.BifDispatchHrAccountInfo;
import com.teekee.blackrockservice.entity.bif.ListDispatchAccountInfo;
import com.teekee.blackrockservice.service.bif.BifDispatchHumanResourceService;
import com.teekee.blackrockservice.service.bif.BifDispatcheHrAccountInfoService;
import com.teekee.blackrockservice.utils.ResponseMessage;
import com.teekee.blackrockservice.utils.StringUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @Author Chenliwen
 * @date 2018/11/5
 **/
@Api(value = "BifDispatchHrAccountInfoController", tags = "accountInfo-service")
@RestController
@RequestMapping("serv/dispatchHrAccountInfo")
public class BifDispacthHrAccountInfoController extends BaseController {
    private Logger log = Logger.getLogger(BifDispatchHrServiceAreaController.class);

    @Autowired
    BifDispatcheHrAccountInfoService service;
    @Autowired
    BifDispatchHumanResourceService humanResourceService;

    @ApiOperation(value = "查询账户列表", notes = "查询账户列表", consumes = "application/json", responseReference = "com.example.timemachine.utils.Result")
    @GetMapping(value = "/payAcountList")
    public String serviceAreaList(HttpServletRequest request) {
        log.info("查询账户列表-开始");
        Integer hrId = getTokenFromHead(request);
        List<ListDispatchAccountInfo> result = service.payAcountList(hrId);
        log.info("查询账户列表-结束");
        return build(StringUtil.buildJsonSucessRespMsg(result));
    }

    @ApiOperation(value = "删除账户", notes = "删除账户", consumes = "application/json", responseReference = "com.example.timemachine.utils.Result")
    @GetMapping(value = "/deletePayAccount")
    public String deletePayAccount(@RequestParam("id") Integer id) {
        log.info("删除账户-开始");
        ResponseMessage result = service.deletePayAccount(id);
        log.info("删除账户-结束");
        return build(result);
    }

    @ApiOperation(value = "查询账户信息",notes = "查询账户信息", consumes = "application/json", responseReference = "com.example.timemachine.utils.Result")
    @GetMapping(value = "/payAcountShow")
    public String payAcountShow(@RequestParam("id") Integer id) {
        log.info("查询账户信息-开始");
        ListDispatchAccountInfo result = service.payAcountShow(id);
        log.info("查询账户信息-结束");
        return build(StringUtil.buildJsonSucessRespMsg(result));
    }

    @ApiOperation(value = "新增/编辑账户", notes = "新增/编辑账户", consumes = "application/json", responseReference = "com.example.timemachine.utils.Result")
    @PostMapping(value = "/handlePayAccount")
    public String handlePayAccount(@RequestBody BifDispatchHrAccountInfo param, HttpServletRequest request) {
        log.info("新增/编辑账户-开始");
        Integer hrId = getTokenFromHead(request);
        param.setHrId(hrId);
        ResponseMessage result = service.handlePayAccount(param);
        log.info("新增/编辑账户-结束");
        return build(result);
    }
    //
    //@ApiOperation(value = "查询关联公司&发票",notes = "查询关联公司&发票", consumes = "application/json", responseReference = "com.example.timemachine.utils.Result")
    //@GetMapping(value = "/filter/companyInvoiceShow")
    //public String companyInvoiceShow() {
    //    log.info("查询关联公司&发票-开始");
    //    GetHumanResourceCompanyInvoice result = humanResourceService.companyInvoiceShow();
    //    log.info("查询关联公司&发票-结束");
    //    return build(StringUtil.buildJsonSucessRespMsg(result));
    //}
    //
    //@ApiOperation(value = "编辑关联公司&发票信息", notes = "编辑关联公司&发票信息", consumes = "application/json", responseReference = "com.example.timemachine.utils.Result")
    //@PostMapping(value = "/filter/updateCompanyInvoice")
    //public String updateCompanyInvoice(@RequestBody BifDispatchHumanResource resource, @RequestParam("id") Integer hrId) {
    //    log.info("编辑关联公司&发票信息-开始");
    //    resource.setId(hrId);
    //    ResponseMessage result = humanResourceService.updateCompanyInvoice(resource);
    //    log.info("编辑关联公司&发票信息-结束");
    //    return build(result);
    //}
}
