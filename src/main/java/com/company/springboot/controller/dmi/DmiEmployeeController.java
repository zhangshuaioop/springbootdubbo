package com.company.springboot.controller.dmi;

import com.company.springboot.Thread.ImportDTO;
import com.company.springboot.entity.dmi.DmiEmployee;
import com.company.springboot.service.DmiEmployeeService;
import com.company.springboot.utils.DataFormatTransform;
import com.company.springboot.utils.Result;
import com.company.springboot.utils.ResultUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.log4j.Logger;
import org.apache.poi.poifs.filesystem.OfficeXmlFileException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.annotation.Resource;


/**
 * @Author Chenliwen
 * @Date 2019/1/9 18:19
 **/
@RestController
@RequestMapping("/employee")
@Api(description = "员工")
public class DmiEmployeeController {

    private Logger log = Logger.getLogger(DmiEmployeeController.class);
    @Resource
    private DmiEmployeeService dmiEmployeeService;

    @ApiOperation(
            value = "根据某组条件，查询员工列表",
            notes = "根据某组条件，查询员工列表")
    @RequestMapping(value = "/list", method = RequestMethod.POST)
    public Result list(@RequestBody DmiEmployee dmiEmployee) {
        log.info("根据某组条件，查询员工列表-开始，入参：dmiEmployee="+dmiEmployee.toString());
        Result result = dmiEmployeeService.list(dmiEmployee);
        log.info("根据某组条件，查询员工列表-结束，出参："+result.toString());
        return result;
    }


    @ApiOperation(value = "新增/编辑员工",
            notes = "新增/编辑员工")
    @RequestMapping(value = "/handle", method = RequestMethod.POST)
    public Result handle(@RequestBody DmiEmployee dmiEmployee) {
        log.info("新增/编辑员工-开始，入参：dmiEmployee="+dmiEmployee.toString());
        Result result = dmiEmployeeService.handle(dmiEmployee);
        log.info("新增/编辑员工-结束，出参："+result.toString());
        return result;
    }


    @ApiOperation(value = "校验导入数据",
            notes = "校验导入数据")
    @RequestMapping(value = "/check", method = RequestMethod.POST)
    public Result check(@RequestParam("file") MultipartFile file, @RequestParam("uniqueness") String uniqueness) {
        log.info("校验导入数据-开始，入参：file="+file+",uniqueness="+uniqueness);
        Result result = null;
        try {
            result = dmiEmployeeService.check(file, uniqueness);
            log.info("校验导入数据-结束，出参："+result.toString());
            return result;
        } catch (OfficeXmlFileException e) {
            if (e.getMessage().contains("2007+")) {
               result = ResultUtil.successMsg("导入失败，您使用的不是 office 2003 版本，请转换格式后重新导入！");
            }
            log.info("校验导入数据-结束，出参："+result.toString());
            return DataFormatTransform.changeModel2Json(result);
        }
    }


    @ApiOperation(
            value = "导入员工",
            notes = "导入员工")
    @RequestMapping(value = "/importEmployee", method = RequestMethod.POST)
    public Result importEmployee(@RequestBody ImportDTO importDTO) {
        log.info("导入员工-开始，入参：importDTO="+importDTO.toString());
        Result result = dmiEmployeeService.importEmployee(importDTO);
        log.info("导入员工-结束，出参："+result.toString());
        return result;
    }


    @ApiOperation(value = "导入员工回调",
            notes = "导入员工回调")
    @RequestMapping(value = "/importCallBack", method = RequestMethod.GET)
    public Result importCallBack(@PathVariable String batchInsertCode) {
        log.info("导入员工回调-开始");
        Result result = dmiEmployeeService.importCallBack(batchInsertCode);
        log.info("导入员工回调-结束，出参："+result.toString());
        return result;
    }


    @ApiOperation(value = "员工转岗",  notes = "员工转岗")
    @RequestMapping(value = "/transfer", method = RequestMethod.POST)
    public Result transfer(@RequestBody DmiEmployee dmiEmployee) {
        log.info("员工转岗-开始，入参：dmiEmployee="+dmiEmployee.toString());
        Result result = dmiEmployeeService.transfer(dmiEmployee);
        log.info("员工转岗-结束，出参："+result.toString());
        return result;
    }


    @ApiOperation(value = "删除员工", notes = "删除员工")
    @RequestMapping(value = "/handleDelete", method = RequestMethod.POST)
    public Result handleDelete(@RequestBody DmiEmployee dmiEmployee) {
        log.info("删除员工-开始，入参：dmiEmployee="+dmiEmployee.toString());
        Result result = dmiEmployeeService.handleDelete(dmiEmployee);
        log.info("删除员工-结束，出参："+result.toString());
        return result;
    }


    @ApiOperation(
            value = "失效员工",
            notes = "失效员工")
    @RequestMapping(value = "/handleInvalid", method = RequestMethod.POST)
    public Result handleInvalid(@RequestBody DmiEmployee dmiEmployee) {
        log.info("失效员工-开始，入参：dmiEmployee="+dmiEmployee.toString());
        Result result = dmiEmployeeService.handleInvalid(dmiEmployee);
        log.info("失效员工-结束，出参："+result.toString());
        return result;
    }


    @ApiOperation(
            value = "显示员工详情",
            notes = "显示员工详情")
    @RequestMapping(value = "/show", method = RequestMethod.GET)
    public Result show(@RequestParam int id) {
        log.info("新增/编辑员工-开始，入参：id="+id);
        Result result = dmiEmployeeService.show(id);
        log.info("新增/编辑员工-结束，出参："+result.toString());
        return result;
    }

    @ApiOperation(value = "员工导出", httpMethod = "POST", notes = "员工导出")
    @RequestMapping(value = "/export", method = RequestMethod.POST, produces = "text/json;charset=UTF-8")
    public Result export(@RequestBody DmiEmployee dmiEmployee) {
        log.info("员工导出-开始，入参：dmiEmployee="+dmiEmployee.toString());
        Result result = dmiEmployeeService.export(dmiEmployee);
        log.info("员工导出-结束，出参："+result.toString());
        return result;
    }
}
