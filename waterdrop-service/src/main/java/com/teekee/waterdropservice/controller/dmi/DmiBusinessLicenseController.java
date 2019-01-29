package com.teekee.waterdropservice.controller.dmi;

import com.teekee.waterdropservice.entity.dmi.DmiBusinessLicense;
import com.teekee.waterdropservice.entity.dmi.DmiBusinessLicenseWithBLOBs;
import com.teekee.waterdropservice.service.dmi.DmiBusinessLicenseService;
import com.teekee.commoncomponets.utils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 *
 * @Author Chenliwen
 * @date 2018/12/16
 */
@RestController
@RequestMapping("/bizlic")
@Api(description = "营业执照")
public class DmiBusinessLicenseController {
    private Logger log = Logger.getLogger(DmiBusinessLicenseController.class);

    @Resource
    private DmiBusinessLicenseService dmiBusinessLicenseService;

    @ApiOperation(
            value = "根据雇主ID，查看营业执照列表",
            notes = "根据雇主ID，查看营业执照列表",
            consumes = "application/json",
            responseReference = "com.teekee.commoncomponets.utils.Result")
    @RequestMapping(value = "/list", method = RequestMethod.POST)
    public Result list(@RequestBody DmiBusinessLicense dmiBusinessLicense) {
        log.info("根据雇主ID，查看营业执照列表-开始,入参：dmiBusinessLicense="+dmiBusinessLicense.toString());
        Result result = dmiBusinessLicenseService.pageBusinessLicense(dmiBusinessLicense);
        log.info("根据雇主ID，查看营业执照列表-结束,出参："+toString());
        return result;
    }

    @ApiOperation(
            value = "根据雇主ID，查看营业执照列表，下拉框用",
            notes = "根据雇主ID，查看营业执照列表，下拉框用",
            consumes = "application/json",
            responseReference = "com.teekee.commoncomponets.utils.Result")
    @RequestMapping(value = "/listDown", method = RequestMethod.GET)
    public Result listDown(@RequestParam int companyId) {
        log.info("根据雇主ID，查看营业执照列表-开始,入参：companyId="+companyId);
        Result result = dmiBusinessLicenseService.pageBusinessLicenseDown(companyId);
        log.info("根据雇主ID，查看营业执照列表-结束,出参："+toString());
        return result;
    }


    @ApiOperation(
            value = "根据ID，查看营业执照详情",
            notes = "根据ID，查看营业执照详情",
            consumes = "application/json",
            responseReference = "com.teekee.commoncomponets.utils.Result")
    @RequestMapping(value = "/show", method = RequestMethod.GET)
    public Result show(@RequestParam("id") Integer id) {
        log.info("根据ID，查看营业执照详情-开始,入参：id="+id);
        Result result = dmiBusinessLicenseService.getBusinessLicense(id);
        log.info("根据ID，查看营业执照详情-结束,出参："+toString());
        return result;
    }



    @ApiOperation(value = "新增/编辑营业执照信息",
            notes = "** companyName **：@ 公司全称 | " +
                    "** legalPerson **：@ 法人 | " +
                    "** licenseCode **：@ 营业执照号 | " +
                    "** licenseType **：营业执照类型 | " +
                    "** registerAddress **：注册地址 | " +
                    "** licenseCodeType **：营业执照号码类型 | " +
                    "** registerPlace **：注册城市/省份 | " +
                    "** registerCapital **：注册资本 | " +
                    "** validDateStart **：有效时间开始 | " +
                    "** validDateEnd **：有效时间结束 | " +
                    "** registerDate **：注册日期 | " +
                    "** registerOffice **：注册机构 | " +
                    "** issuingDate **：发证日期 | " +
                    "** isIntegrated **：是否三证合一 | " +
                    "** licenseImageUrl **：营业执照扫描件图片路径 | " +
                    "** companyId **：公司ID | " +
                    "** businessArea **：经营范围 | " +
                    "** memo **：备注",
            consumes = "application/json",
            responseReference = "com.teekee.commoncomponets.utils.Result")
    @RequestMapping(value = "/handle", method = RequestMethod.POST)
    public Result handle(@RequestBody DmiBusinessLicenseWithBLOBs dmiBusinessLicenseWithBLOBs) {
        log.info("新增/编辑营业执照信息-开始,入参:dmiBusinessLicenseWithBLOBs="+dmiBusinessLicenseWithBLOBs);
        Result result = dmiBusinessLicenseService.handle(dmiBusinessLicenseWithBLOBs);
        log.info("新增/编辑营业执照信息-结束,出参:"+result.toString());
        return result;
    }


    @ApiOperation(
            value = "失效营业执照",
            notes = "失效营业执照",
            consumes = "application/json",
            responseReference = "com.teekee.commoncomponets.utils.Result")
    @RequestMapping(value = "/invalid", method = RequestMethod.POST)
    public Result handleInvalid(@RequestBody DmiBusinessLicenseWithBLOBs dmiBusinessLicenseWithBLOBs) {
        log.info("失效营业执照-开始,入参:dmiBusinessLicenseWithBLOBs="+dmiBusinessLicenseWithBLOBs);
        Result result = dmiBusinessLicenseService.handleInvalid(dmiBusinessLicenseWithBLOBs);
        log.info("失效营业执照-结束,出参:"+result.toString());
        return result;
    }


    @ApiOperation(
            value = "删除营业执照",
            notes = "删除营业执照",
            consumes = "application/json",
            responseReference = "com.teekee.commoncomponets.utils.Result")
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public Result handleDelete(@RequestBody DmiBusinessLicenseWithBLOBs dmiBusinessLicenseWithBLOBs) {
        log.info("删除营业执照-开始,入参:dmiBusinessLicenseWithBLOBs="+dmiBusinessLicenseWithBLOBs);
        Result result = dmiBusinessLicenseService.handleDelete(dmiBusinessLicenseWithBLOBs);
        log.info("删除营业执照-结束,出参:"+result.toString());
        return result;
    }
}
