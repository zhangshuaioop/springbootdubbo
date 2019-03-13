package com.company.springboot.controller.dmi;

import com.company.springboot.entity.dmi.DmiInvoiceModelWithBLOBs;
import com.company.springboot.service.dmi.DmiInvoiceModelService;
import com.company.springboot.utils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;


/**
 * @Author Chenliwen
 * @Date 2019/1/9 15:08
 **/
@RestController
@RequestMapping("/invoice")
@Api(description = "发票模板")
public class DmiInvoiceModelController {

    private Logger log = Logger.getLogger(DmiInvoiceModelController.class);
    @Resource
    private DmiInvoiceModelService dmiInvoiceModelService;


    @ApiOperation(
            value = "根据节点的ID，获取该节点所属发票模板列表",
            notes = "根据节点的ID，获取该节点所属发票模板列表")
    @RequestMapping(value = "/list", method = RequestMethod.POST)
    public Result listCom(@RequestBody DmiInvoiceModelWithBLOBs dmiInvoiceModelWithBLOBs) {
        log.info("根据公司的ID，获取公司所属发票模板列表-开始，入参：dmiInvoiceModelWithBLOBs="+dmiInvoiceModelWithBLOBs.toString());
        Result result = dmiInvoiceModelService.list(dmiInvoiceModelWithBLOBs);
        log.info("根据公司的ID，获取公司所属发票模板列表-结束，出参："+result.toString());
        return result;
    }


    @ApiOperation(value = "新增/编辑发票信息",
            notes = "** invoiceModelName **：@ 发票模板名称 | " +
                    "** invoiceType **：@ 发票类型 | " +
                    "** invoiceTitle **：@ 发票抬头 | " +
                    "** taxpayerNumber **：@ 纳税人识别号 | " +
                    "** invoiceAddress **：@ 发票地址 | " +
                    "** bankName **：@ 开户行 | " +
                    "** invoiceAccount **：@ 银行行号 | " +
                    "** dependenceCompanyId **：归属公司ID | " +
                    "** deliveryAddress **：寄送地址 | " +
                    "** contactName **：联系人地址 | " +
                    "** contactTel **：联系人电话 | " +
                    "** belongObjectId **：属于组织节点ID | " +
                    "** belongObjectType **：属于组织节点类型 | " +
                    "** memo **：备注")
    @RequestMapping(value = "/handle", method = RequestMethod.POST)
    public Result handle(@RequestBody DmiInvoiceModelWithBLOBs dmiInvoiceModelWithBLOBs) {
        log.info("新增/编辑发票信息-开始，入参：dmiInvoiceModelWithBLOBs="+dmiInvoiceModelWithBLOBs.toString());
        Result result = dmiInvoiceModelService.handle(dmiInvoiceModelWithBLOBs);
        log.info("新增/编辑发票信息-结束，出参："+result.toString());
        return result;
    }


    @ApiOperation(
            value = "根据ID，查看发票详情",
            notes = "根据ID，查看发票详情")
    @RequestMapping(value = "/show", method = RequestMethod.GET)
    public Result show(@RequestParam("id") int id) {
        log.info("根据ID，查看发票详情-开始，入参：id="+id);
        Result result = dmiInvoiceModelService.getInvoiceModel(id);
        log.info("根据ID，查看发票详情-结束，出参："+result.toString());
        return result;
    }


    @ApiOperation(
            value = "失效发票",
            notes = "失效发票")
    @RequestMapping(value = "/invalid", method = RequestMethod.POST)
    public Result handleInvalid(@RequestBody DmiInvoiceModelWithBLOBs dmiInvoiceModelWithBLOBs) {
        log.info("失效发票-开始，入参：dmiInvoiceModelWithBLOBs="+dmiInvoiceModelWithBLOBs.toString());
        Result result = dmiInvoiceModelService.handleInvalid(dmiInvoiceModelWithBLOBs);
        log.info("失效发票-结束，出参："+result.toString());
        return result;
    }


    @ApiOperation(
            value = "删除发票",
            notes = "删除发票")
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public Result handleDelete(@RequestBody DmiInvoiceModelWithBLOBs dmiInvoiceModelWithBLOBs) {
        log.info("删除发票-开始，入参：dmiInvoiceModelWithBLOBs="+dmiInvoiceModelWithBLOBs.toString());
        Result result = dmiInvoiceModelService.handleDelete(dmiInvoiceModelWithBLOBs);
        log.info("删除发票-结束，出参："+result.toString());
        return result;
    }
}
