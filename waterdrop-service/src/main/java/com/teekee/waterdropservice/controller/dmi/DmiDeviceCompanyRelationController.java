package com.teekee.waterdropservice.controller.dmi;

import com.teekee.waterdropservice.entity.bif.BifDeviceDetail;
import com.teekee.waterdropservice.entity.bif.BifDeviceInputParam;
import com.teekee.waterdropservice.entity.dmi.DmiDeviceCompanyRelation;
import com.teekee.waterdropservice.service.dmi.DmiDeviceCompanyRelationService;
import com.teekee.commoncomponets.utils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author zhanghao
 * @Title: DmiDeviceCompanyRelationController
 * @ProjectName WaterDrop
 * @Description: 设备与公司关系
 * @date 2018/12/15下午4:30
 */
@RestController
@RequestMapping("/deviceComRlat")
@Api(description = "设备与公司关系")
public class DmiDeviceCompanyRelationController {

    private Logger log = Logger.getLogger(DmiDeviceCompanyRelationController.class);

    @Resource
    private DmiDeviceCompanyRelationService dmiDeviceCompanyRelationService;

    @ResponseBody
    @ApiOperation(value = "新增/编辑设备与公司关系", httpMethod = "POST", notes = "新增/编辑设备与公司关系")
    @RequestMapping(value = "/handle", method = RequestMethod.POST)
    public Result handle(@RequestBody DmiDeviceCompanyRelation dmiDeviceCompanyRelation) {
        return dmiDeviceCompanyRelationService.handle(dmiDeviceCompanyRelation);
    }
    @ApiOperation(value = "失效设备与公司关系", httpMethod = "GET", notes = "失效设备与公司关系")
    @RequestMapping(value = "/handleInvalid", method = RequestMethod.GET)
    public Result handleInvalid(@RequestParam Integer id) {
        return dmiDeviceCompanyRelationService.handleInvalid(id);
    }

    @ApiOperation(value = "删除设备与公司关系", httpMethod = "GET", notes = "删除设备与公司关系")
    @RequestMapping(value = "/handleDelete", method = RequestMethod.GET)
    public Result handleDelete(@RequestParam Integer id) {
        return dmiDeviceCompanyRelationService.handleDelete(id);
    }
    @ApiOperation(value = "根据公司ID查询设备", httpMethod = "POST", notes = "根据公司ID查询设备")
    @RequestMapping(value = "/list", method = RequestMethod.POST)
    public Result list(@RequestBody DmiDeviceCompanyRelation dmiDeviceCompanyRelation) {
        return dmiDeviceCompanyRelationService.list(dmiDeviceCompanyRelation);
    }
    @ApiOperation(value = "根据雇主ID，查询该雇主下所有设备", httpMethod = "GET", notes = "** companyId **：@ 雇主公司ID *")
    @RequestMapping(value = "/getListByCompanyId", method = RequestMethod.GET)
    public Result getListByCompanyId(@RequestBody BifDeviceDetail bifDeviceDetail) {
        log.info("根据雇主ID，查询该雇主下所有设备-开始");
        Result result = dmiDeviceCompanyRelationService.getListByCompanyId(bifDeviceDetail);
        log.info("根据雇主ID，查询该雇主下所有设备-结束");
        return result;
    }
    @ApiOperation(value = "根据雇主ID以及某组条件，查询该雇主下满足相应条件的所有设备", httpMethod = "POST",
            notes = "** catalogId **：@ 资源分类节点ID | " +
                    "** deviceSn **：设备序号 | " +
                    "** assetSn **：资产编号(公司) | " +
                    "** brandId **：品牌ID | " +
                    "** seriesId **：系列ID | " +
                    "** modelId **：型号ID | " +
                    "** purchaseDateMax **：购买日期上限 | " +
                    "** purchaseDateMin **：购买日期下限 | " +
                    "** companyId **：公司ID")
    @RequestMapping(value = "/getListByCompanyIdAndObject", method = RequestMethod.POST)
    public Result getListByCompanyIdAndObject(@RequestBody BifDeviceInputParam bifDeviceInputParam) {
        log.info("根据雇主ID以及某组条件，查询该雇主下满足相应条件的所有设备-开始");
        Result result = dmiDeviceCompanyRelationService.getListByCompanyIdAndObject(bifDeviceInputParam);
        log.info("根据雇主ID以及某组条件，查询该雇主下满足相应条件的所有设备-结束");
        return result;
    }
    @ApiOperation(value = "查询未被购入的所有设备", httpMethod = "GET", notes = "查询未被购入的所有设备")
    @RequestMapping(value = "/getDeviceNotInCompany", method = RequestMethod.GET)
    public Result getDeviceNotInCompany() {
        log.info("查询未被购入的所有设备-开始");
        Result result = dmiDeviceCompanyRelationService.getDeviceNotInCompany();
        log.info("查询未被购入的所有设备-结束");
        return result;
    }
    @ApiOperation(value = "根据某组条件，查询未被购入的所有设备", httpMethod = "POST",
            notes = "** catalogId **：@ 资源分类节点ID | " +
                    "** deviceSn **：设备序号 | " +
                    "** brandId **：品牌ID | " +
                    "** seriesId **：系列ID | " +
                    "** modelId **：型号ID | " +
                    "** createTimeMax **：录入日期上限 | " +
                    "** createTimeMin **：录入日期下限")
    @RequestMapping(value = "/getDeviceNotInCompanyByObject", method = RequestMethod.POST)
    public Result getDeviceNotInCompanyByObject(@RequestBody BifDeviceInputParam bifDeviceInputParam) {
        log.info("根据某组条件，查询未被购入的所有设备-开始");
        Result result = dmiDeviceCompanyRelationService.getDeviceNotInCompanyByObject(bifDeviceInputParam);
        log.info("根据某组条件，查询未被购入的所有设备-结束");
        return result;
    }
}
