package com.platform.springboot.controller.dmi;

import com.platform.springboot.entity.dmi.DmiCompanyInfo;
import com.platform.springboot.service.dmi.DmiCompanyInfoService;
import com.platform.springboot.utils.Result;
import com.platform.springboot.service.dmi.DmiCompanyInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
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

    @ApiOperation(
            value = "新增/编辑雇主基础信息",
            notes = "新增/编辑雇主基础信息",
            consumes = "application/json",
            responseReference = "com.platform.springboot.utils.Result"
    )
    @SuppressWarnings("unchecked")
    @RequestMapping(value = "/handle",method=RequestMethod.POST)
    public Result handle(@RequestBody DmiCompanyInfo dmiCompanyInfo) {
        logger.info("新增/编辑雇主基础信息开始,入参:dmiCompanyInfo="+dmiCompanyInfo.toString());
        Result result = dmiCompanyInfoService.handle(dmiCompanyInfo);
        logger.info("新增/编辑雇主基础信息结束,出参:"+result.toString());
        return result;
    }



    @ApiOperation(
            value = "查看雇主公司基础信息",
            notes = "查看雇主公司基础信息",
            consumes = "application/json",
            responseReference = "com.platform.springboot.utils.Result"
    )
    @SuppressWarnings("unchecked")
    @RequestMapping(value = "/show/basic",method=RequestMethod.GET)
    public Result findCompanyBasicInfo(@RequestParam("companyId") int companyId) {
        logger.info("查看雇主公司基础信息开始,入参:companyId="+companyId);
        Result result = dmiCompanyInfoService.getCompanyBasicInfo(companyId);
        logger.info("查看雇主公司基础信息结束,出参:"+result.toString());
        return result;
    }

    @ApiOperation(value = "查看雇主列表")
    @RequestMapping(value = "/companyList",method=RequestMethod.GET)
    public Result companyList() {
        logger.info("查看雇主列表开始");
        Result result = dmiCompanyInfoService.companyList();
        logger.info("查看雇主列表结束,出参:"+result.toString());
        return result;
    }

}
