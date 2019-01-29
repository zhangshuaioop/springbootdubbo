package com.teekee.waterdropservice.controller.dmi;

import com.teekee.waterdropservice.entity.dmi.DmiStoreCommProduct;
import com.teekee.waterdropservice.entity.dto.dmi.DmiStoreCommProduct.CommListDto;
import com.teekee.waterdropservice.service.dmi.DmiStoreCommProductService;
import com.teekee.waterdropservice.utils.CurrentUtil;
import com.teekee.commoncomponets.utils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @description: 门店通信产品
 * @author: zhangshuai
 * @create: 2018-12-17 13:56
 */
@RestController
@RequestMapping("/storeCommProduct")
@Api(description = "门店通信产品")
public class DmiStoreCommProductController {

    private final Logger logger = Logger.getLogger(getClass());

    @Autowired
    private DmiStoreCommProductService dmiStoreCommProductService;

    @ApiOperation(
            value = "分页查询通信产品列表",
            notes = "分页查询通信产品列表",
            consumes = "application/json",
            responseReference = "com.teekee.commoncomponets.utils.Result"
    )
    @SuppressWarnings("unchecked")
    @RequestMapping(value = "/findPage",method=RequestMethod.POST)
    public Result findPage(@RequestBody DmiStoreCommProduct dmiStoreCommProduct) {
        logger.info("分页查询通信产品列表开始,入参:dmiStoreCommProduct="+dmiStoreCommProduct.toString());
        Result result = dmiStoreCommProductService.findPage(dmiStoreCommProduct);
        logger.info("分页查询通信产品列表结束,出参:"+result.toString());
        return result;
    }


    @ApiOperation(
            value = "根据通信产品ID，查询通信产品详情",
            notes = "根据通信产品ID，查询通信产品详情",
            consumes = "application/json",
            responseReference = "com.teekee.commoncomponets.utils.Result"
    )
    @SuppressWarnings("unchecked")
        @RequestMapping(value = "/show",method=RequestMethod.GET)
    public Result show(@RequestParam Integer id) {
        logger.info("根据通信产品ID，查询通信产品详情开始,入参:id="+id);
        Result result = dmiStoreCommProductService.show(id);
        logger.info("根据通信产品ID，查询通信产品详情结束,出参:"+result.toString());
        return result;
    }



    @ApiOperation(
            value = "根据通信产品ID，失效通信产品",
            notes = "根据通信产品ID，失效通信产品",
            consumes = "application/json",
            responseReference = "com.teekee.commoncomponets.utils.Result"
    )
    @SuppressWarnings("unchecked")
    @RequestMapping(value = "/handleInvalid",method=RequestMethod.POST)
    public Result handleInvalid(@RequestBody DmiStoreCommProduct dmiStoreCommProduct) {
        logger.info("根据通信产品ID，失效通信产品开始,入参:dmiStoreCommProduct="+dmiStoreCommProduct);
        Result result = dmiStoreCommProductService.handleInvalid(dmiStoreCommProduct,CurrentUtil.getCurrent().getId());
        logger.info("根据通信产品ID，失效通信产品结束,出参:"+result.toString());
        return result;
    }


    @ApiOperation(
            value = "根据通信产品ID，删除通信产品",
            notes = "根据通信产品ID，删除通信产品",
            consumes = "application/json",
            responseReference = "com.teekee.commoncomponets.utils.Result"
    )
    @SuppressWarnings("unchecked")
    @RequestMapping(value = "/handleDelete",method=RequestMethod.POST)
    public Result handleDelete(@RequestBody DmiStoreCommProduct dmiStoreCommProduct) {
        logger.info("根据通信产品ID，删除通信产品开始,入参:dmiStoreCommProduct="+dmiStoreCommProduct);
        Result result = dmiStoreCommProductService.handleDelete(dmiStoreCommProduct,CurrentUtil.getCurrent().getId());
        logger.info("根据通信产品ID，删除通信产品结束,出参:"+result.toString());
        return result;
    }



    @ApiOperation(
            value = "门店通信产品新增/编辑-宽带",
            notes = "门店通信产品新增/编辑-宽带",
            consumes = "application/json",
            responseReference = "com.teekee.commoncomponets.utils.Result"
    )
    @SuppressWarnings("unchecked")
    @RequestMapping(value = "/handleBroadband",method=RequestMethod.POST)
    public Result handleBroadband(@RequestBody String requestJson) {
        logger.info("门店通信产品新增/编辑-宽带开始,入参:requestJson="+requestJson);
        Result result = dmiStoreCommProductService.handleBroadband(requestJson,CurrentUtil.getCurrent().getId());
        logger.info("门店通信产品新增/编辑-宽带结束,出参:"+result.toString());
        return result;
    }

    @ApiOperation(
            value = "门店通信产品新增/编辑-中继语音",
            notes = "门店通信产品新增/编辑-中继语音",
            consumes = "application/json",
            responseReference = "com.teekee.commoncomponets.utils.Result"
    )
    @SuppressWarnings("unchecked")
    @RequestMapping(value = "/handleTrunking",method=RequestMethod.POST)
    public Result handleTrunking(@RequestBody String requestJson) {
        logger.info("门店通信产品新增/编辑-中继语音开始,入参:requestJson="+requestJson);
        Result result = dmiStoreCommProductService.handleTrunking(requestJson,CurrentUtil.getCurrent().getId());
        logger.info("门店通信产品新增/编辑-中继语音结束,出参:"+result.toString());
        return result;
    }



    @ApiOperation(
            value = "门店通信产品新增/编辑-直线语音",
            notes = "门店通信产品新增/编辑-直线语音",
            consumes = "application/json",
            responseReference = "com.teekee.commoncomponets.utils.Result"
    )
    @SuppressWarnings("unchecked")
    @RequestMapping(value = "/handleStraightLine",method=RequestMethod.POST)
    public Result handleStraightLine(@RequestBody String requestJson) {
        logger.info("门店通信产品新增/编辑-直线语音开始,入参:requestJson="+requestJson);
        Result result = dmiStoreCommProductService.handleStraightLine(requestJson,CurrentUtil.getCurrent().getId());
        logger.info("门店通信产品新增/编辑-直线语音结束,出参:"+result.toString());
        return result;
    }



    @ApiOperation(
            value = "门店通信产品新增/编辑-专线",
            notes = "门店通信产品新增/编辑-专线",
            consumes = "application/json",
            responseReference = "com.teekee.commoncomponets.utils.Result"
    )
    @SuppressWarnings("unchecked")
    @RequestMapping(value = "/handleSpecialLine",method=RequestMethod.POST)
    public Result handleSpecialLine(@RequestBody String requestJson) {
        logger.info("门店通信产品新增/编辑-专线开始,入参:requestJson="+requestJson);
        Result result = dmiStoreCommProductService.handleSpecialLine(requestJson,CurrentUtil.getCurrent().getId());
        logger.info("门店通信产品新增/编辑-专线结束,出参:"+result.toString());
        return result;
    }


    @ApiOperation(
            value = "门店通信产品新增/编辑-移动",
            notes = "门店通信产品新增/编辑-移动",
            consumes = "application/json",
            responseReference = "com.teekee.commoncomponets.utils.Result"
    )
    @SuppressWarnings("unchecked")
    @RequestMapping(value = "/handleMobile",method=RequestMethod.POST)
    public Result handleMobile(@RequestBody String requestJson) {
        logger.info("门店通信产品新增/编辑-移动开始,入参:requestJson="+requestJson);
        Result result = dmiStoreCommProductService.handleMobile(requestJson,CurrentUtil.getCurrent().getId());
        logger.info("门店通信产品新增/编辑-移动结束,出参:"+result.toString());
        return result;
    }



    @ApiOperation(
            value = "根据楼宇ID，查询通信产品列表",
            notes = "根据楼宇ID，查询通信产品列表",
            consumes = "application/json",
            responseReference = "com.teekee.commoncomponets.utils.Result"
    )
    @SuppressWarnings("unchecked")
    @RequestMapping(value = "/getListByBuildingId",method=RequestMethod.GET)
    public Result getListByBuildingId(@RequestParam Integer id) {
        logger.info("根据楼宇ID，查询通信产品列表开始,入参:id="+id);
        Result result = dmiStoreCommProductService.getListByBuildingId(id);
        logger.info("根据楼宇ID，查询通信产品列表结束,出参:"+result.toString());
        return result;
    }



    @ApiOperation(
            value = "根据产品ID，查询产品基本信息以及产品所在套餐信息",
            notes = "根据产品ID，查询产品基本信息以及产品所在套餐信息",
            consumes = "application/json",
            responseReference = "com.teekee.commoncomponets.utils.Result"
    )
    @SuppressWarnings("unchecked")
    @RequestMapping(value = "/getProductAndPackageInfo",method=RequestMethod.GET)
    public Result getProductAndPackageInfo(@RequestParam Integer id) {
        logger.info("根据产品ID，查询产品基本信息以及产品所在套餐信息开始,入参:id="+id);
        Result result = dmiStoreCommProductService.getProductAndPackageInfo(id);
        logger.info("根据产品ID，查询产品基本信息以及产品所在套餐信息结束,出参:"+result.toString());
        return result;
    }


    @ApiOperation(
            value = "根据某组条件，查询通信产品列表",
            notes = "根据某组条件，查询通信产品列表",
            consumes = "application/json",
            responseReference = "com.teekee.commoncomponets.utils.Result"
    )
    @SuppressWarnings("unchecked")
    @RequestMapping(value = "/getCommList",method=RequestMethod.POST)
    public Result getCommList(@RequestBody CommListDto commListDto) {
        logger.info("根据某组条件，查询通信产品列表开始,入参:commListDto="+commListDto.toString());
        Result result = dmiStoreCommProductService.getCommList(commListDto);
        logger.info("根据某组条件，查询通信产品列表结束,出参:"+result.toString());
        return result;
    }


    @ApiOperation(
            value = "信息确认",
            notes = "信息确认",
            consumes = "application/json",
            responseReference = "com.teekee.commoncomponets.utils.Result"
    )
    @SuppressWarnings("unchecked")
    @RequestMapping(value = "/confirmInfo",method=RequestMethod.GET)
    public Result confirmInfo(@RequestParam Integer id) {
        logger.info("信息确认开始,入参:id="+id);
        Result result = dmiStoreCommProductService.confirmInfo(id,"PRODUCT");
        logger.info("信息确认结束,出参:"+result.toString());
        return result;
    }



    @ApiOperation(
            value = "信息待审核",
            notes = "信息待审核",
            consumes = "application/json",
            responseReference = "com.teekee.commoncomponets.utils.Result"
    )
    @SuppressWarnings("unchecked")
    @RequestMapping(value = "/needCheckInfo",method=RequestMethod.GET)
    public Result needCheckInfo(@RequestParam Integer id) {
        logger.info("信息待审核开始,入参:id="+id);
        Result result = dmiStoreCommProductService.needCheckInfo(id,"PRODUCT");
        logger.info("信息待审核结束,出参:"+result.toString());
        return result;
    }



    @ApiOperation(
            value = "信息已审核",
            notes = "信息已审核",
            consumes = "application/json",
            responseReference = "com.teekee.commoncomponets.utils.Result"
    )
    @SuppressWarnings("unchecked")
    @RequestMapping(value = "/checkInfo",method=RequestMethod.GET)
    public Result checkInfo(@RequestParam Integer id) {
        logger.info("信息已审核开始,入参:id="+id);
        Result result = dmiStoreCommProductService.checkInfo(id,"PRODUCT");
        logger.info("信息已审核结束,出参:"+result.toString());
        return result;
    }



    @ApiOperation(
            value = "审核不通过",
            notes = "审核不通过",
            consumes = "application/json",
            responseReference = "com.teekee.commoncomponets.utils.Result"
    )
    @SuppressWarnings("unchecked")
    @RequestMapping(value = "/checkNoInfo",method=RequestMethod.GET)
    public Result checkNoInfo(@RequestParam Integer id) {
        logger.info("审核不通过开始,入参:id="+id);
        Result result = dmiStoreCommProductService.checkNoInfo(id,"PRODUCT");
        logger.info("审核不通过结束,出参:"+result.toString());
        return result;
    }

}
