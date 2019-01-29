package com.teekee.waterdropservice.controller.dmi;

import com.teekee.waterdropservice.entity.dmi.DmiOrganization;
import com.teekee.waterdropservice.entity.sys.SysCompanyUsers;
import com.teekee.waterdropservice.service.dmi.DmiOrganizationService;
import com.teekee.waterdropservice.utils.CurrentUtil;
import com.teekee.commoncomponets.utils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

/**
 * @description: 组织结构
 * @author: zhangshuai
 * @create: 2018-12-15 13:05
 */
@RestController
@RequestMapping("/organization")
@Api(description = "组织结构")
public class DmiOrganizationController {
    private final Logger logger = Logger.getLogger(getClass());

    @Autowired
    private DmiOrganizationService dmiOrganizationService;

    @ApiOperation(
            value = "新增/编辑组织结构节点信息",
            notes = "新增/编辑组织结构节点信息",
            consumes = "application/json",
            responseReference = "com.teekee.commoncomponets.utils.Result"
    )
    @SuppressWarnings("unchecked")
    @RequestMapping(value = "/handle",method=RequestMethod.POST)
    public Result handle(@RequestBody DmiOrganization dmiOrganization) {
        SysCompanyUsers user = CurrentUtil.getCurrent();
        logger.info("新增/编辑组织结构节点信息开始,入参:dmiOrganization="+dmiOrganization.toString());
        Result result = dmiOrganizationService.handle(user.getId(),user.getCompanyId(),dmiOrganization);
        logger.info("新增/编辑组织结构节点信息结束,出参:"+result.toString());
        return result;
    }


    @ApiOperation(
            value = "根据雇主公司的ID，获取公司所属组织结构列表",
            notes = "根据雇主公司的ID，获取公司所属组织结构列表",
            consumes = "application/json",
            responseReference = "com.teekee.commoncomponets.utils.Result"
    )
    @SuppressWarnings("unchecked")
    @RequestMapping(value = "/tree",method=RequestMethod.GET)
    public Result tree(@RequestParam Integer companyId) {
        logger.info("根据雇主公司的ID，获取公司所属组织结构列表开始,入参:companyId="+companyId);
        Result result = dmiOrganizationService.getOragnizationByCompanyId(companyId);
        logger.info("根据雇主公司的ID，获取公司所属组织结构列表结束,出参:"+result.toString());
        return result;
    }


    @ApiOperation(
            value = "删除组织结构节点",
            notes = "删除组织结构节点",
            consumes = "application/json",
            responseReference = "com.teekee.commoncomponets.utils.Result"
    )
    @SuppressWarnings("unchecked")
    @RequestMapping(value = "/delete",method=RequestMethod.POST)
    public Result delete(@RequestBody DmiOrganization dmiOrganization) {
        logger.info("删除组织结构节点开始,入参:dmiOrganization="+dmiOrganization.toString());
        Result result = dmiOrganizationService.handleDelete(dmiOrganization);
        logger.info("删除组织结构节点结束,出参:"+result.toString());
        return result;
    }


    @ApiOperation(
            value = "根据ID，查看组织结构节点详情",
            notes = "根据ID，查看组织结构节点详情",
            consumes = "application/json",
            responseReference = "com.teekee.commoncomponets.utils.Result"
    )
    @SuppressWarnings("unchecked")
    @RequestMapping(value = "/show",method=RequestMethod.GET)
    public Result show(@RequestParam Integer id) {
        logger.info("根据ID，查看组织结构节点详情开始,入参:id="+id);
        Result result = dmiOrganizationService.getOragnization(id);
        logger.info("根据ID，查看组织结构节点详情结束,出参:"+result.toString());
        return result;
    }



    @ApiOperation(
            value = "根据雇主公司的ID，获取公司所属组织结构某个级别的列表",
            notes = "根据雇主公司的ID，获取公司所属组织结构某个级别的列表",
            consumes = "application/json",
            responseReference = "com.teekee.commoncomponets.utils.Result"
    )
    @SuppressWarnings("unchecked")
    @RequestMapping(value = "/list",method=RequestMethod.GET)
    public Result list(@RequestParam Integer companyId, @RequestParam Integer parentId) {
        logger.info("根据雇主公司的ID，获取公司所属组织结构某个级别的列表开始,入参:companyId="+companyId+",parentId="+parentId);
        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("parentId", parentId);
        map.put("companyId", companyId);
        Result result = dmiOrganizationService.getOragnizationListByParentId(map);
        logger.info("根据雇主公司的ID，获取公司所属组织结构某个级别的列表结束,出参:"+result.toString());
        return result;
    }




    @ApiOperation(
            value = "失效组织结构节点",
            notes = "失效组织结构节点",
            consumes = "application/json",
            responseReference = "com.teekee.commoncomponets.utils.Result"
    )
    @SuppressWarnings("unchecked")
    @RequestMapping(value = "/invalid",method=RequestMethod.POST)
    public Result invalid(@RequestBody DmiOrganization dmiOrganization) {
        logger.info("失效组织结构节点开始,入参:dmiOrganization="+dmiOrganization.toString());
        Result result = dmiOrganizationService.handleInvalid(CurrentUtil.getCurrent().getId(),dmiOrganization);
        logger.info("失效组织结构节点结束,出参:"+result.toString());
        return result;
    }




//    @ApiOperation(
//            value = "根据ID，查看全部组织结构列表",
//            notes = "根据ID，查看全部组织结构列表",
//            consumes = "application/json",
//            responseReference = "com.teekee.commoncomponets.utils.Result"
//    )
//    @SuppressWarnings("unchecked")
//    @RequestMapping(value = "/getTreeById",method=RequestMethod.GET)
//    public Result getTreeById(@PathVariable("id") int id) {
//        logger.info("根据ID，查看全部组织结构列表开始,入参:id="+id);
//        Result result = dmiOrganizationService.getOragnizationTreeById(id);
//        logger.info("根据ID，查看全部组织结构列表结束,出参:"+result.toString());
//        return result;
//    }

}
