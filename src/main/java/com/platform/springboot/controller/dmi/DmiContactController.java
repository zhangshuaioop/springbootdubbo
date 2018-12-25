package com.platform.springboot.controller.dmi;

import com.platform.springboot.entity.dmi.DmiContact;
import com.platform.springboot.entity.sys.SysCompanyUsers;
import com.platform.springboot.service.dmi.DmiContactService;
import com.platform.springboot.utils.CurrentUtil;
import com.platform.springboot.utils.Result;
import com.platform.springboot.service.dmi.DmiContactService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 雇主/门店联系人
 * @Author Niting
 * @date 2018/12/15
 **/
@RestController
@RequestMapping("/contact")
@Api(description = "雇主/门店联系人")
public class DmiContactController {
    private final Logger logger = Logger.getLogger(getClass());

    @Autowired
    private DmiContactService service;

    @ApiOperation(value = "根据雇主公司的ID，获取公司所有联系人列表", httpMethod = "POST", notes = "根据雇主公司的ID，获取公司所有联系人列表")
    @RequestMapping(value = "/companyContactList", method = RequestMethod.POST)
    public Result companyContactList(@RequestBody DmiContact contact) {
        logger.info("根据雇主公司的ID，获取公司所有联系人列表开始,入参:contact="+contact);
        SysCompanyUsers sysCompanyUsers = CurrentUtil.getCurrent();
        Result result = service.getListByCompanyId(contact, sysCompanyUsers.getId());
        logger.info("根据雇主公司的ID，获取公司所有联系人列表结束,出参:"+result.toString());
        return result;
    }

    @ApiOperation(value = "根据门店的ID，获取门店所有联系人列表", httpMethod = "POST", notes = "根据门店的ID，获取门店所有联系人列表")
    @RequestMapping(value = "/storeContactList", method = RequestMethod.POST)
    public Result storeContactList(@RequestBody DmiContact contact) {
        logger.info("根据门店的ID，获取门店所有联系人列表开始,入参:contact="+contact);
        SysCompanyUsers sysCompanyUsers = CurrentUtil.getCurrent();
        Result result = service.getListByStoreId(contact, sysCompanyUsers.getId());
        logger.info("根据门店的ID，获取门店所有联系人列表结束,出参:"+result.toString());
        return result;
    }

    @ApiOperation(value = "雇主&门店新增/编辑联系人", httpMethod = "POST", notes = "雇主&门店新增/编辑联系人")
    @RequestMapping(value = "/handle", method = RequestMethod.POST)
    public Result handle(@RequestBody DmiContact contact) {
        logger.info("雇主&门店新增/编辑联系人开始,入参:contact="+contact);
        SysCompanyUsers sysCompanyUsers = CurrentUtil.getCurrent();
        contact.setBelongCompanyId(sysCompanyUsers.getCompanyId());
        Result result = service.companyHandle(contact,sysCompanyUsers.getId());
        logger.info("雇主&门店新增/编辑联系人结束,出参:"+result.toString());
        return result;
    }

    @ApiOperation(value = "根据ID，查看联系人详情", httpMethod = "GET", notes = "根据ID，查看联系人详情")
    @RequestMapping(value = "/show", method = RequestMethod.GET)
    public Result show(@RequestParam Integer id) {
        logger.info("根据ID，查看联系人详情开始,入参:id="+id);
        Result result = service.getContact(id);
        logger.info("根据ID，查看联系人详情结束,出参:"+result.toString());
        return result;
    }

    @ApiOperation(value = "失效联系人", httpMethod = "POST", notes = "失效联系人")
    @RequestMapping(value = "/invalid", method = RequestMethod.POST)
    public Result handleInvalid(@RequestBody String requestJson) {
        logger.info("失效联系人开始,入参:requestJson="+requestJson);
        SysCompanyUsers sysCompanyUsers = CurrentUtil.getCurrent();
        Result result = service.handleInvalid(sysCompanyUsers.getId(), requestJson);
        logger.info("失效联系人结束,出参:"+result.toString());
        return result;
    }

    @ApiOperation(value = "删除联系人", httpMethod = "POST", notes = "删除联系人")
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public Result handleDelete(@RequestBody String requestJson) {
        logger.info("删除联系人开始,入参:requestJson="+requestJson);
        SysCompanyUsers sysCompanyUsers = CurrentUtil.getCurrent();
        Result result = service.handleDelete(sysCompanyUsers.getId(), requestJson);
        logger.info("删除联系人结束,出参:"+result.toString());
        return result;
    }

    @ApiOperation(value = "重置联系人密码", httpMethod = "POST", notes = "重置联系人密码")
    @RequestMapping(value = "/resetPwd", method = RequestMethod.POST)
    public Result resetPassword(@RequestBody DmiContact contact) {
        logger.info("重置联系人密码开始,入参:contact="+contact);
        SysCompanyUsers sysCompanyUsers = CurrentUtil.getCurrent();
        Result result = service.resetPassword(sysCompanyUsers.getId(), contact);
        logger.info("重置联系人密码结束,出参:"+result.toString());
        return result;
    }
}
