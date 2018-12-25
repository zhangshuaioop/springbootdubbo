package com.platform.springboot.controller.dmi;

import com.alibaba.fastjson.JSON;
import com.platform.springboot.Thread.ImportDTO;
import com.platform.springboot.entity.bif.BifDeviceUploadFileWithList;
import com.platform.springboot.entity.dmi.DmiStore;
import com.platform.springboot.entity.dmi.DmiStoreWithBusinessLicense;
import com.platform.springboot.entity.sys.SysCompanyUsers;
import com.platform.springboot.entity.trc.TrcDmiBatchEmpolyeeImport;
import com.platform.springboot.service.dmi.DmiStoreService;
import com.platform.springboot.utils.CurrentUtil;
import com.platform.springboot.utils.Result;
import com.platform.springboot.utils.ResultUtil;
import com.platform.springboot.Thread.ImportDTO;
import com.platform.springboot.service.dmi.DmiStoreService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.log4j.Logger;
import org.apache.poi.poifs.filesystem.OfficeXmlFileException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.commons.CommonsMultipartFile;


/**
 * 雇主门店
 * @Author Niting
 * @date 2018/12/15
 **/
@RestController
@RequestMapping("/store")
@Api(description = "雇主门店")
public class DmiStoreController {
    private final Logger logger = Logger.getLogger(getClass());
    @Autowired
    private DmiStoreService dmiStoreService;

    @ApiOperation(value = "分页获取门店list", httpMethod = "POST", notes = "根据雇主公司的ID,获取门店list")
    @RequestMapping(value = "/storeList", method = RequestMethod.POST)
    public Result getLastFive(@RequestBody DmiStore store) {
        logger.info("分页获取门店list开始");
        Result result = dmiStoreService.storeList(store);
        logger.info("分页获取门店list开始,出参:"+result.toString());
        return result;
    }


    @ApiOperation(value = "根据雇主公司的ID,获取门店list", httpMethod = "GET", notes = "根据雇主公司的ID,获取门店list")
    @RequestMapping(value = "/storeListByCompanyId", method = RequestMethod.GET)
    public Result storeListByCompanyId(@RequestParam Integer companyId) {
        logger.info("根据雇主公司的ID,获取门店list开始");
        Result result = dmiStoreService.storeListByCompanyId(companyId);
        logger.info("根据雇主公司的ID,获取门店list开始,出参:"+result.toString());
        return result;
    }



    @ApiOperation(value = "查看门店基础信息", httpMethod = "GET", notes = "查看门店基础信息")
    @RequestMapping(value = "/show/basic", method = RequestMethod.GET)
    public Result showBasic(@RequestParam Integer storeId) {
        logger.info("查看门店基础信息开始,入参:storeId="+storeId);
        DmiStoreWithBusinessLicense result = dmiStoreService.getStoreBasicInfo(storeId);
        logger.info("查看门店基础信息结束,出参:"+result.toString());
        return ResultUtil.success(result);
    }

    @ApiOperation(value = "新增/编辑门店信息", httpMethod = "POST", notes = "新增/编辑门店信息")
    @RequestMapping(value = "/handle", method = RequestMethod.POST)
    public Result handle(@RequestBody String requestJson) {
        SysCompanyUsers sysCompanyUsers = CurrentUtil.getCurrent();
        logger.info("新增/编辑门店信息开始,入参:requestJson="+requestJson);
        DmiStore store = JSON.parseObject(requestJson, DmiStore.class);
        BifDeviceUploadFileWithList bifDeviceUploadFileWithList = JSON.parseObject(requestJson, BifDeviceUploadFileWithList.class);
        Result result = dmiStoreService.handle(sysCompanyUsers.getId(), store, bifDeviceUploadFileWithList);
        logger.info("新增/编辑门店信息结束,出参:"+result.toString());
        return result;
    }

    @ApiOperation(value = "失效门店", httpMethod = "POST", notes = "失效门店")
    @RequestMapping(value = "/invalid", method = RequestMethod.POST)
    public Result handleInvalid(@RequestBody String requestJson) {
        SysCompanyUsers sysCompanyUsers = CurrentUtil.getCurrent();
        logger.info("失效门店开始,入参:requestJson="+requestJson);
        Result result = dmiStoreService.handleInvalid(sysCompanyUsers.getId(), requestJson);
        logger.info("失效门店结束,出参:"+result.toString());
        return result;
    }

    @ApiOperation(value = "删除门店", httpMethod = "POST", notes = "删除门店")
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public Result handleDelete(@RequestBody String requestJson) {
        SysCompanyUsers sysCompanyUsers = CurrentUtil.getCurrent();
        logger.info("删除门店开始,入参:requestJson="+requestJson);
        Result result = dmiStoreService.handleDelete(sysCompanyUsers.getId(), requestJson);
        logger.info("删除门店结束,出参:"+result.toString());
        return result;
    }

    @ApiOperation(value = "校验导入excel数据", httpMethod = "POST", notes = "校验导入excel数据")
    @RequestMapping(value = "/validateBeforeImport", method = RequestMethod.POST)
    public Result validateBeforeImport(@RequestParam("file") CommonsMultipartFile file) {
        SysCompanyUsers sysCompanyUsers = CurrentUtil.getCurrent();
        logger.info("校验导入excel数据开始,入参:file=" + file);
        Result result = null;
        try {
            result = dmiStoreService.check(file, sysCompanyUsers.getId(), sysCompanyUsers.getCompanyId());
            logger.info("校验导入excel数据结束");
            return result;
        } catch (OfficeXmlFileException e) {
            if (e.getMessage().contains("2007+")) {
                result = ResultUtil.errorExceptionMsg("导入失败，您使用的不是 office 2003 版本，请转换格式后重新导入！");
            }
            logger.info("校验导入excel数据结束");
            return result;
        }
    }

    @ApiOperation(value = "门店导入", httpMethod = "POST", notes = "门店导入")
    @RequestMapping(value = "/importStore", method = RequestMethod.POST)
    public Result importStore(@RequestBody ImportDTO importDTO) {
        SysCompanyUsers sysCompanyUsers = CurrentUtil.getCurrent();
        logger.info("门店导入开始,入参:importDTO="+importDTO);
        Result result = dmiStoreService.importStore(importDTO,sysCompanyUsers.getId(), sysCompanyUsers.getCompanyId());
        logger.info("门店导入结束,出参:"+result.toString());
        return result;
    }

    @ApiOperation(value = "导入门店回调", httpMethod = "POST", notes = "导入门店回调")
    @RequestMapping(value = "/importCallBack", method = RequestMethod.POST)
    public Result importCallBack(@RequestParam String batchInsertCode) {
        logger.info("导入门店回调,入参:batchInsertCode="+batchInsertCode);
        TrcDmiBatchEmpolyeeImport result = dmiStoreService.importCallBack(batchInsertCode);
        logger.info("导入门店回调,出参:"+result.toString());
        return ResultUtil.success(result);
    }
}
