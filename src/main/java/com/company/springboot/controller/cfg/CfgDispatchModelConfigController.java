package com.company.springboot.controller.cfg;

import com.company.springboot.entity.cfg.CfgDispatchModelConfig;
import com.company.springboot.entity.cfg.CfgDispatchModelConfigParam;
import com.company.springboot.utils.Result;
import com.company.springboot.entity.cfg.*;
import com.company.springboot.service.cfg.CfgDispatchModelConfigService;
import com.company.springboot.utils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @Author Chenliwen
 * @Date 2018/12/18 13:33
 **/
@RestController
@RequestMapping("/dispatchModelConfig")
@Api(description = "派工模板")
public class CfgDispatchModelConfigController {
    private Logger log = Logger.getLogger(CfgDispatchModelConfigController.class);

    @Resource
    private CfgDispatchModelConfigService service;


    @ApiOperation(
            value = "新增/编辑派工模板",
            notes = "新增/编辑派工模板",
            consumes = "application/json",
            responseReference = "com.company.springboot.utils.Result")
    @RequestMapping(value = "/handle", method = RequestMethod.POST)
    public Result handle(@RequestBody CfgDispatchModelConfig cfgDispatchModelConfig) {
        log.info("新增/编辑派工模板-开始,入参:cfgDispatchModelConfig="+cfgDispatchModelConfig);
        Result result = service.handle(cfgDispatchModelConfig);
        log.info("新增/编辑派工模板-结束,出参:"+result.toString());
        return result;
    }

    @ApiOperation(
            value = "查询模板列表",
            notes = "查询模板列表",
            consumes = "application/json",
            responseReference = "com.company.springboot.utils.Result")
    @RequestMapping(value = "/list", method = RequestMethod.POST)
    public Result list(@RequestBody CfgDispatchModelConfigParam cfgDispatchModelConfigParam) {
        log.info("查询模板列表-开始,入参:cfgDispatchModelConfigParam="+cfgDispatchModelConfigParam);
        Result result = service.list(cfgDispatchModelConfigParam);
        log.info("查询模板列表-结束,出参:"+result.toString());
        return result;
    }

    @ApiOperation(
            value = "查看模板信息",
            notes = "查看模板信息",
            consumes = "application/json",
            responseReference = "com.company.springboot.utils.Result")
    @RequestMapping(value = "/show", method = RequestMethod.GET)
    public Result show(@RequestParam int id) {
        log.info("查看模板信息-开始,入参:id="+id);
        Result result = service.show(id);
        log.info("查看模板信息-结束,出参:"+result.toString());
        return result;
    }

    @ApiOperation(
            value = "删除模板",
            notes = "删除模板",
            consumes = "application/json",
            responseReference = "com.company.springboot.utils.Result")
    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public Result delete(@RequestParam int id) {
        log.info("删除模板-开始,入参:id="+id);
        Result result = service.delete(id);
        log.info("删除模板-结束,出参:"+result.toString());
        return result;
    }

    @ApiOperation(
            value = "查看模板创建人列表",
            notes = "查看模板创建人列表",
            consumes = "application/json",
            responseReference = "com.company.springboot.utils.Result")
    @RequestMapping(value = "/createPersonList", method = RequestMethod.GET)
    public Result createPersonList(CfgDispatchModelConfig cfgDispatchModelConfig) {
        log.info("查看模板创建人列表-开始,入参:cfgDispatchModelConfig="+cfgDispatchModelConfig);
        Result result = service.createPersonList(cfgDispatchModelConfig);
        log.info("查看模板创建人列表-结束,出参:"+result.toString());
        return result;
    }

    @ApiOperation(
            value = "启用/停用模板",
            notes = "启用/停用模板",
            consumes = "application/json",
            responseReference = "com.company.springboot.utils.Result")
    @RequestMapping(value = "/isStart", method = RequestMethod.GET)
    public Result isStart(@RequestParam int id,@RequestParam int flagUsed) {
        log.info("启用/停用模板-开始,入参:id="+id+",flagUsed="+flagUsed);
        Result result = service.isStart(id,flagUsed);
        log.info("启用/停用模板-结束,出参:"+result.toString());
        return result;
    }

    @ApiOperation(
            value = "查询已启用模板列表",
            notes = "查询已启用模板列表",
            consumes = "application/json",
            responseReference = "com.company.springboot.utils.Result")
    @RequestMapping(value = "/useModelList", method = RequestMethod.GET)
    public Result useModelList(@RequestParam int projectId) {
        log.info("查询已启用模板列表-开始,入参:projectId="+projectId);
        Result result = service.useModelList(projectId);
        log.info("查询已启用模板列表-结束,出参:"+result.toString());
        return result;
    }

    @ApiOperation(
            value = "查询已启用项目-模板列表",
            notes = "查询已启用项目-模板列表",
            consumes = "application/json",
            responseReference = "com.company.springboot.utils.Result")
    @RequestMapping(value = "/pList", method = RequestMethod.GET)
    public Result pList(@RequestParam int companyId) {
        log.info("查询已启用项目-模板列表-开始,入参:companyId="+companyId);
        Result result = service.pList(companyId);
        log.info("查询已启用项目-模板列表-结束,出参:"+result.toString());
        return result;
    }
}
