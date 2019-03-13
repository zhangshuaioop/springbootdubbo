package com.company.springboot.controller.pjt;

import com.company.springboot.entity.pjt.PjtProject;
import com.company.springboot.entity.pjt.PjtProjectParam;
import com.company.springboot.service.pjt.PjtProjectService;
import com.company.springboot.utils.CurrentUtil;
import com.company.springboot.utils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @description:
 * @author: zhangshuai
 * @create: 2018-12-18 16:18
 */
@RestController
@RequestMapping("/project")
@Api(description = "项目")
public class PjtProjectController {

    private final Logger logger = Logger.getLogger(getClass());

    @Autowired
    private PjtProjectService pjtProjectService;

    @ApiOperation(
            value = "新增项目",
            notes = "新增项目",
            consumes = "application/json",
            responseReference = "com.company.springboot.utils.Result"
    )
    @SuppressWarnings("unchecked")
    @RequestMapping(value = "/handle",method=RequestMethod.POST)
    public Result handle(@RequestBody PjtProject pjtProject) {
        logger.info("新增项目开始,入参:pjtProject="+pjtProject.toString());
        Result result = pjtProjectService.handle(pjtProject,CurrentUtil.getCurrent().getId());
        logger.info("新增项目结束,出参:"+result.toString());
        return result;
    }



    @ApiOperation(
            value = "查询项目列表",
            notes = "查询项目列表",
            consumes = "application/json",
            responseReference = "com.company.springboot.utils.Result"
    )
    @RequestMapping(value = "/list",method=RequestMethod.POST)
    public Result list(@RequestBody PjtProjectParam pjtProjectParam) {
        logger.info("查询项目列表开始,入参:pjtProjectParam="+pjtProjectParam.toString());
        Result result = pjtProjectService.list(pjtProjectParam);
        logger.info("查询项目列表结束,出参:"+result.toString());
        return result;
    }


    @ApiOperation(
            value = "新增模板查询项目列表",
            notes = "新增模板查询项目列表",
            consumes = "application/json",
            responseReference = "com.company.springboot.utils.Result"
    )
    @SuppressWarnings("unchecked")
    @RequestMapping(value = "/newModelList",method=RequestMethod.POST)
    public Result newModelList(@RequestBody PjtProjectParam pjtProjectParam) {
        logger.info("新增模板查询项目列表开始,入参:pjtProjectParam="+pjtProjectParam.toString());
        Result result = pjtProjectService.newModelList(pjtProjectParam,CurrentUtil.getCurrent().getId());
        logger.info("新增模板查询项目列表结束,出参:"+result.toString());
        return result;
    }



    @ApiOperation(
            value = "查看项目信息",
            notes = "查看项目信息",
            consumes = "application/json",
            responseReference = "com.company.springboot.utils.Result"
    )
    @SuppressWarnings("unchecked")
    @RequestMapping(value = "/show",method=RequestMethod.GET)
    public Result show(@RequestParam Integer id) {
        logger.info("查看项目信息开始,入参:id="+id);
        Result result = pjtProjectService.show(id);
        logger.info("查看项目信息结束,出参:"+result.toString());
        return result;
    }


    @ApiOperation(
            value = "删除项目",
            notes = "删除项目",
            consumes = "application/json",
            responseReference = "com.company.springboot.utils.Result"
    )
    @SuppressWarnings("unchecked")
    @RequestMapping(value = "/delete",method=RequestMethod.GET)
    public Result delete(@RequestParam Integer id) {
        logger.info("删除项目开始,入参:id="+id);
        Result result = pjtProjectService.delete(id);
        logger.info("删除项目结束,出参:"+result.toString());
        return result;
    }



    @ApiOperation(
            value = "启用/停用项目",
            notes = "启用/停用项目",
            consumes = "application/json",
            responseReference = "com.company.springboot.utils.Result"
    )
    @SuppressWarnings("unchecked")
    @RequestMapping(value = "/isStart",method=RequestMethod.GET)
    public Result isStart(@RequestParam Integer id,@RequestParam Integer flagAvailable) {
        logger.info("启用/停用项目开始,入参:id="+id);
        Result result = pjtProjectService.isStart(id,flagAvailable);
        logger.info("启用/停用项目结束,出参:"+result.toString());
        return result;
    }


}
