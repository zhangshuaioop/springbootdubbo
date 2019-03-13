package com.company.springboot.controller.dmi;

import com.company.springboot.entity.dmi.DmiCompanyInfo;
import com.company.springboot.entity.sys.SysCompanyPurchaseVersion;
import com.company.springboot.service.dmi.DmiCompanyInfoService;
import com.company.springboot.utils.Result;
import com.company.springboot.utils.ResultUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;


/**
 * @description: 公司信息
 * @author: zhangshuai
 * @create: 2018-12-15 12:33
 */
@RestController
@RequestMapping("/company")
@Api(description = "公司信息")
public class DmiCompanyInfoController {

    private final Logger logger = Logger.getLogger(getClass());

    @Autowired
    private DmiCompanyInfoService dmiCompanyInfoService;

//    @ApiOperation(
//            value = "新增/编辑雇主基础信息",
//            notes = "新增/编辑雇主基础信息",
//            consumes = "application/json",
//            responseReference = "com.company.springboot.utils.Result"
//    )
//    @RequestMapping(value = "/handle", method = RequestMethod.POST)
//    public Result handle(@RequestBody DmiCompanyInfo dmiCompanyInfo) {
//        logger.info("新增/编辑雇主基础信息开始,入参:dmiCompanyInfo=" + dmiCompanyInfo.toString());
//        Result result = dmiCompanyInfoService.handle(dmiCompanyInfo);
//        logger.info("新增/编辑雇主基础信息结束,出参:" + result.toString());
//        return result;
//    }


    @ApiOperation(
            value = "新增/编辑子公司基础信息",
            notes = "新增/编辑子公司基础信息",
            consumes = "application/json",
            responseReference = "com.company.springboot.utils.Result"
    )
    @RequestMapping(value = "/handle", method = RequestMethod.POST)
    public Result handle(@RequestBody DmiCompanyInfo dmiCompanyInfo) {
        logger.info("新增/编辑子公司基础信息开始,入参:dmiCompanyInfo=" + dmiCompanyInfo.toString());
        Result result = dmiCompanyInfoService.saveOrUpdate(dmiCompanyInfo);
        logger.info("新增/编辑子公司基础信息结束,出参:" + result.toString());
        return result;
    }


    @ApiOperation(
            value = "关闭删除公司",
            notes = "关闭删除公司",
            consumes = "application/json",
            responseReference = "com.company.springboot.utils.Result"
    )
    @RequestMapping(value = "/deleteCompany", method = RequestMethod.GET)
    @Transactional(readOnly = false,rollbackFor = Exception.class)
    public Result deleteCompany(@RequestParam Integer id) {
        logger.info("关闭删除公司开始,入参:id=" + id);
        dmiCompanyInfoService.relieveCompany(id);
        DmiCompanyInfo companyInfo = new DmiCompanyInfo();
        companyInfo.setId(id);
        companyInfo.setFlagDeleted(true);
        dmiCompanyInfoService.update(companyInfo);
        logger.info("关闭删除公司结束");
        return ResultUtil.success();
    }


    @ApiOperation(
            value = "解除公司关系",
            notes = "解除公司关系",
            consumes = "application/json",
            responseReference = "com.company.springboot.utils.Result"
    )
    @RequestMapping(value = "/relieveCompany", method = RequestMethod.GET)
    @Transactional(readOnly = false,rollbackFor = Exception.class)
    public Result relieveCompany(@RequestParam Integer id) {
        logger.info("解除公司关系开始,入参:id=" + id);
        Result result = dmiCompanyInfoService.relieveCompany(id);
        logger.info("解除公司关系结束,出参:" + result.toString());
        return result;
    }


    @ApiOperation(
            value = "赋予公司版本",
            notes = "赋予公司版本",
            consumes = "application/json",
            responseReference = "com.platform.springboot.utils.Result"
    )
    @SuppressWarnings("unchecked")
    @RequestMapping(value = "/updateCompanyPermission",method=RequestMethod.POST)
    public Result updateCompanyPermission(@RequestBody SysCompanyPurchaseVersion sysCompanyPurchaseVersion) {
        logger.info("赋予公司版本开始,入参:sysCompanyPurchaseVersion="+sysCompanyPurchaseVersion.toString());
        Result result = dmiCompanyInfoService.updateCompanyPermission(sysCompanyPurchaseVersion);
        logger.info("赋予公司版本结束,出参:result="+result.toString());
        return result;
    }


    @ApiOperation(
            value = "查看雇主公司基础信息",
            notes = "查看雇主公司基础信息",
            consumes = "application/json",
            responseReference = "com.company.springboot.utils.Result"
    )
    @RequestMapping(value = "/show/basic", method = RequestMethod.GET)
    public Result findCompanyBasicInfo(@RequestParam("companyId") int companyId) {
        logger.info("查看雇主公司基础信息开始,入参:companyId=" + companyId);
        Result result = dmiCompanyInfoService.getCompanyBasicInfo(companyId);
        logger.info("查看雇主公司基础信息结束,出参:" + result.toString());
        return result;
    }

    @ApiOperation(value = "查看雇主下拉列表")
    @RequestMapping(value = "/companyList", method = RequestMethod.GET)
    public Result companyList() {
        logger.info("查看雇主下拉列表开始");
        Result result = dmiCompanyInfoService.companyList();
        logger.info("查看雇主列表结束,出参:" + result.toString());
        return result;
    }


    @ApiOperation(value = "查看雇主下拉列表（传参）")
    @RequestMapping(value = "/companyListParam", method = RequestMethod.GET)
    public Result companyListParam(@RequestParam("companyId") Integer companyId) {
        logger.info("查看雇主下拉列表（传参）开始，入参：");
        Result result = dmiCompanyInfoService.companyListParam(companyId);
        logger.info("查看雇主下拉列表（传参）结束,出参:" + result.toString());
        return result;
    }


    @ApiOperation(value = "分页查看关联雇主列表")
    @PostMapping(value = "/companyRalationList")
    public Result companyRalationList(@RequestBody DmiCompanyInfo dmiCompanyInfo) {
        logger.info("分页查看关联雇主列表");
        Result result = dmiCompanyInfoService.companyRalationList(dmiCompanyInfo);
        logger.info("分页查看关联雇主列表,出参:" + result.toString());
        return result;
    }

}
