package com.teekee.blueoceanservice.controller.dmi;

import com.teekee.blueoceanservice.entity.dmi.DmiCompanyInfo;
import com.teekee.blueoceanservice.entity.syscompany.SysCompanyPurchaseVersion;
import com.teekee.blueoceanservice.service.dmi.DmiCompanyInfoService;
import com.teekee.commoncomponets.utils.Result;
import com.teekee.commoncomponets.utils.ResultUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @description:雇主公司信息
 * @author: zhangshuai
 * @create: 2018-12-29 16:19
 */
@RestController
@RequestMapping("/dmiCompanyInfo")
@Api(description = "雇主公司信息")
public class DmiCompanyInfoController {

    private final Logger logger = Logger.getLogger(getClass());

    @Autowired
    private DmiCompanyInfoService dmiCompanyInfoService;

    @ApiOperation(
            value = "分页公司列表",
            notes = "分页公司列表",
            consumes = "application/json",
            responseReference = "com.teekee.commoncomponets.utils.Result"
    )
    @SuppressWarnings("unchecked")
    @RequestMapping(value = "/findPage",method=RequestMethod.POST)
    public Result findPage(@RequestBody DmiCompanyInfo dmiCompanyInfo) {

        logger.info("分页公司列表开始,入参:dmiCompanyInfo="+dmiCompanyInfo.toString());
        Result result = dmiCompanyInfoService.findPage(dmiCompanyInfo);
        logger.info("分页公司列表结束,出参:"+result.toString());
        return result;
    }



    @ApiOperation(
            value = "公司列表详情",
            notes = "公司列表详情",
            consumes = "application/json",
            responseReference = "com.teekee.commoncomponets.utils.Result"
    )
    @SuppressWarnings("unchecked")
    @RequestMapping(value = "/findDetails",method=RequestMethod.GET)
    public Result findDetails(@RequestParam Integer id) {

        logger.info("公司列表详情开始,入参:id="+id);
        Result result = ResultUtil.success(dmiCompanyInfoService.get(id));
        logger.info("公司列表详情结束,出参:"+result.toString());
        return result;
    }


    @ApiOperation(
            value = "公司保存/更新",
            notes = "公司保存/更新",
            consumes = "application/json",
            responseReference = "com.teekee.commoncomponets.utils.Result"
    )
    @SuppressWarnings("unchecked")
    @RequestMapping(value = "/saveOrUpdate",method=RequestMethod.POST)
    public Result saveOrUpdate(@RequestBody DmiCompanyInfo dmiCompanyInfo) {

        logger.info("公司保存/更新开始,入参:dmiCompanyInfo="+dmiCompanyInfo.toString());
        Result result = dmiCompanyInfoService.saveOrUpdate(dmiCompanyInfo);
        logger.info("公司保存/更新结束,出参:result="+result.toString());
        return result;
    }


    @ApiOperation(
            value = "赋予公司版本",
            notes = "赋予公司版本",
            consumes = "application/json",
            responseReference = "com.teekee.commoncomponets.utils.Result"
    )
    @SuppressWarnings("unchecked")
    @RequestMapping(value = "/updateCompanyPermission",method=RequestMethod.POST)
    public Result updateCompanyPermission(@RequestBody SysCompanyPurchaseVersion sysCompanyPurchaseVersion) {
        logger.info("赋予公司版本开始,入参:sysCompanyPurchaseVersion="+sysCompanyPurchaseVersion.toString());
        Result result = dmiCompanyInfoService.updateCompanyPermission(sysCompanyPurchaseVersion);
        logger.info("赋予公司版本结束,出参:result="+result.toString());
        return result;
    }

}
