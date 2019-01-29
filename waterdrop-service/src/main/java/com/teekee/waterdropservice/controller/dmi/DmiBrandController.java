package com.teekee.waterdropservice.controller.dmi;

import com.teekee.waterdropservice.entity.dmi.DmiBrand;
import com.teekee.waterdropservice.service.dmi.DmiBrandService;
import com.teekee.commoncomponets.utils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 雇主门店
 * @Author Chenliwen
 * @date 2018/12/15
 **/
@RestController
@RequestMapping("/brand")
@Api(description = "雇主品牌")
public class DmiBrandController {
    private final Logger logger = Logger.getLogger(getClass());
    @Autowired
    private DmiBrandService service;

    @ApiOperation(
            value = "根据雇主公司的ID，获取公司所属品牌列表",
            notes = "根据雇主公司的ID，获取公司所属品牌列表",
            consumes = "application/json",
            responseReference = "com.teekee.commoncomponets.utils.Result")
    @RequestMapping(value = "/list", method = RequestMethod.POST)
    public Result list(@RequestBody DmiBrand dmiBrand) {
        logger.info("根据雇主公司的ID，获取公司所属品牌列表-开始,入参:dmiBrand="+dmiBrand);
        Result result = service.getAllBrandByCompanyId(dmiBrand);
        logger.info("根据雇主公司的ID，获取公司所属品牌列表-结束,出参:"+result.toString());
        return result;
    }

    @ApiOperation(
            value = "根据ID，查看品牌详情",
            notes = "根据ID，查看品牌详情",
            consumes = "application/json",
            responseReference = "com.teekee.commoncomponets.utils.Result")
    @RequestMapping(value = "/show", method = RequestMethod.GET)
    public Result show(@RequestParam("id") int id) {
        logger.info("根据ID，查看品牌详情-开始,入参:id="+id);
        Result result = service.getBrand(id);
        logger.info("根据ID，查看品牌详情-结束,出参:"+result.toString());
        return result;
    }

    @ApiOperation(
            value = "新增/编辑品牌信息",
            notes = "** brandName **：@ 品牌名 * | " +
                    "** brandCode **：@ 品牌编号 * | " +
                    "** brandNameCn **：品牌中文名 | " +
                    "** brandNameEn **：品牌英文名 | " +
                    "** brandLogoUrl **：品牌logo的图片路径 | " +
                    "** brandCreateDate **：品牌创建日 | " +
                    "** companyId **：公司ID | " +
                    "** memo **：备注",
            consumes = "application/json",
            responseReference = "com.teekee.commoncomponets.utils.Result")
    @RequestMapping(value = "/handle", method = RequestMethod.POST)
    public Result handle(@RequestBody DmiBrand dmiBrand) {
        logger.info("新增/编辑品牌信息-开始,入参:dmiBrand="+dmiBrand);
        Result result = service.handle(dmiBrand);
        logger.info("新增/编辑品牌信息-结束,出参:"+result.toString());
        return result;
    }

    @ApiOperation(
            value = "失效品牌",
            notes = "失效品牌",
            consumes = "application/json",
            responseReference = "com.teekee.commoncomponets.utils.Result")
    @RequestMapping(value = "/invalid", method = RequestMethod.POST)
    public Result handleInvalid(@RequestBody DmiBrand dmiBrand) {
        logger.info("失效品牌-开始,入参:dmiBrand="+dmiBrand);
        Result result = service.handleInvalid(dmiBrand);
        logger.info("失效品牌-结束,出参:"+result.toString());
        return result;
    }

    @ApiOperation(
            value = "删除品牌",
            notes = "删除品牌",
            consumes = "application/json",
            responseReference = "com.teekee.commoncomponets.utils.Result")
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public Result handleDelete(@RequestBody DmiBrand dmiBrand) {
        logger.info("删除品牌-开始,入参:dmiBrand="+dmiBrand);
        Result result = service.handleDelete(dmiBrand);
        logger.info("删除品牌-结束,出参:"+result.toString());
        return result;
    }
}
