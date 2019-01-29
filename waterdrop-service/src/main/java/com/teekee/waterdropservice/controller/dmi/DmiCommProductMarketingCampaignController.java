package com.teekee.waterdropservice.controller.dmi;

import com.alibaba.fastjson.JSON;
import com.teekee.waterdropservice.entity.bif.BifCommunicationServiceContact;
import com.teekee.waterdropservice.entity.dmi.DmiCommProductBilling;
import com.teekee.waterdropservice.entity.dmi.DmiCommProductMarketingCampaign;
import com.teekee.waterdropservice.entity.dmi.dto.dmiCommProductMarketingCampaign.MarketingCampaignAddProductDTO;
import com.teekee.waterdropservice.entity.dmi.ret.dmiCommProductMarketingCampaign.MarketingCampaignGetProductListRet;
import com.teekee.waterdropservice.entity.dmi.ret.dmiCommProductMarketingCampaign.MarketingCampaignShowRet;
import com.teekee.waterdropservice.entity.sys.SysCompanyUsers;
import com.teekee.waterdropservice.service.dmi.DmiCommProductMarketingCampaignService;
import com.teekee.waterdropservice.utils.CurrentUtil;
import com.teekee.commoncomponets.utils.Result;
import com.teekee.commoncomponets.utils.ResultUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * 通信产品套餐
 * @Author Niting
 * @date 2018/12/18
 **/
@RestController
@RequestMapping("/storeCommPackage")
@Api(description = "通信产品套餐")
public class DmiCommProductMarketingCampaignController {
    private final Logger logger = Logger.getLogger(getClass());

    @Autowired
    private DmiCommProductMarketingCampaignService service;

    @ApiOperation(value = "根据门店ID，分页查询套餐列表", httpMethod = "POST", notes = "根据门店ID，分页查询套餐列表")
    @RequestMapping(value = "/getListByStoreId", method = RequestMethod.POST)
    public Result getListByStoreId(@RequestBody DmiCommProductMarketingCampaign dmiCommProductMarketingCampaign) {
        logger.info("根据门店ID，分页查询套餐列表开始,入参:"+dmiCommProductMarketingCampaign.toString());
        Result result = service.getListByStoreId(dmiCommProductMarketingCampaign);
        logger.info("根据门店ID，分页查询套餐列表结束,出参:"+result.toString());
        return result;
    }

    @ApiOperation(value = "根据套餐ID，查询套餐详情", httpMethod = "GET", notes = "根据套餐ID，查询套餐详情")
    @RequestMapping(value = "/show", method = RequestMethod.GET)
    public Result show(@RequestParam Integer id) {
        logger.info("根据套餐ID，查询套餐详情开始,入参:id="+id);
        MarketingCampaignShowRet result = service.show(id);
        logger.info("根据套餐ID，查询套餐详情结束,出参:"+result.toString());
        return ResultUtil.success(result);
    }

    @ApiOperation(value = "新增/编辑套餐", httpMethod = "POST", notes = "新增/编辑套餐")
    @RequestMapping(value = "/handle", method = RequestMethod.POST)
    public Result handle(@RequestBody String requestJson) {
        logger.info("新增/编辑套餐开始,入参:requestJson="+requestJson);
        SysCompanyUsers sysCompanyUsers = CurrentUtil.getCurrent();
        DmiCommProductMarketingCampaign dto = JSON.parseObject(requestJson, DmiCommProductMarketingCampaign.class);
        DmiCommProductBilling billing = JSON.parseObject(requestJson, DmiCommProductBilling.class);
        BifCommunicationServiceContact contact = JSON.parseObject(requestJson, BifCommunicationServiceContact.class);
        Result result = service.handle(dto, billing, contact, sysCompanyUsers.getId());
        logger.info("新增/编辑套餐结束,出参:"+result.toString());
        return result;
    }

    @ApiOperation(value = "失效套餐", httpMethod = "POST", notes = "失效套餐")
    @RequestMapping(value = "/handleInvalid", method = RequestMethod.POST)
    public Result handleInvalid(@RequestBody DmiCommProductMarketingCampaign marketingCampaign) {
        logger.info("失效套餐开始,入参:marketingCampaign="+marketingCampaign);
        SysCompanyUsers sysCompanyUsers = CurrentUtil.getCurrent();
        Result result = service.handleInvalid(marketingCampaign, sysCompanyUsers.getId());
        logger.info("失效套餐结束,出参:"+result.toString());
        return result;
    }

    @ApiOperation(value = "删除套餐", httpMethod = "POST", notes = "删除套餐")
    @RequestMapping(value = "/handleDelete", method = RequestMethod.POST)
    public Result handleDelete(@RequestBody DmiCommProductMarketingCampaign marketingCampaign) {
        logger.info("删除套餐开始,入参:marketingCampaign="+marketingCampaign);
        SysCompanyUsers sysCompanyUsers = CurrentUtil.getCurrent();
        Result result = service.handleDelete(marketingCampaign, sysCompanyUsers.getId());
        logger.info("删除套餐结束,出参:"+result.toString());
        return result;
    }

    @ApiOperation(value = "根据套餐ID，查询所有产品列表", httpMethod = "GET", notes = "根据套餐ID，查询所有产品列表")
    @RequestMapping(value = "/getProductListByPackageId", method = RequestMethod.GET)
    public Result getProductListByPackageId(@RequestParam Integer id) {
        logger.info("根据套餐ID，查询所有产品列表开始,入参:id="+id);
        Result result = service.getProductListByPackageId(id);
        logger.info("根据套餐ID，查询所有产品列表结束,出参:"+result.toString());
        return result;
    }

    @ApiOperation(value = "根据门店ID，查询所有独立产品列表", httpMethod = "GET", notes = "根据门店ID，查询所有独立产品列表")
    @RequestMapping(value = "/getIndependenceProductList", method = RequestMethod.GET)
    public Result getIndependenceProductList(@RequestParam Integer id) {
        logger.info("根据门店ID，查询所有独立产品列表开始,入参:id="+id);
        List<MarketingCampaignGetProductListRet> result = service.getIndependenceProductList(id);
        logger.info("根据门店ID，查询所有独立产品列表结束,出参:"+result.toString());
        return ResultUtil.success(result);
    }

    @ApiOperation(value = "添加产品到套餐中", httpMethod = "POST", notes = "添加产品到套餐中")
    @RequestMapping(value = "/addProduct", method = RequestMethod.POST)
    public Result addProduct(@RequestBody MarketingCampaignAddProductDTO dto) {
        logger.info("添加产品到套餐中开始,入参:dto="+dto);
        SysCompanyUsers sysCompanyUsers = CurrentUtil.getCurrent();
        Result result = service.addProduct(dto, sysCompanyUsers.getId());
        logger.info("添加产品到套餐中结束,出参:"+result.toString());
        return result;
    }

    @ApiOperation(value = "从套餐中移除产品", httpMethod = "POST", notes = "从套餐中移除产品")
    @RequestMapping(value = "/handleRemove", method = RequestMethod.POST)
    public Result handleRemove(@RequestBody MarketingCampaignAddProductDTO dto) {
        logger.info("从套餐中移除产品开始,入参:dto="+dto);
        SysCompanyUsers sysCompanyUsers = CurrentUtil.getCurrent();
        Result result = service.handleRemove(dto, sysCompanyUsers.getId());
        logger.info("从套餐中移除产品结束,出参:"+result.toString());
        return result;
    }

    @ApiOperation(value = "信息确认", httpMethod = "GET", notes = "信息确认")
    @RequestMapping(value = "/confirmInfo", method = RequestMethod.GET)
    public Result confirmInfo(@RequestParam Integer id) {
        logger.info("信息确认开始,入参:id="+id);
        Result result = service.confirmInfo(id);
        logger.info("信息确认结束,出参:"+result.toString());
        return result;
    }

    @ApiOperation(value = "信息待审核", httpMethod = "GET", notes = "信息待审核")
    @RequestMapping(value = "/needCheckInfo", method = RequestMethod.GET)
    public Result needCheckInfo(@RequestParam Integer id) {
        logger.info("信息待审核开始,入参:id="+id);
        Result result = service.needCheckInfo(id);
        logger.info("信息待审核结束,出参:"+result.toString());
        return result;
    }

    @ApiOperation(value = "信息已审核", httpMethod = "GET", notes = "信息已审核")
    @RequestMapping(value = "/checkInfo", method = RequestMethod.GET)
    public Result checkInfo(@RequestParam Integer id) {
        logger.info("信息已审核开始,入参:id="+id);
        Result result = service.checkInfo(id);
        logger.info("信息已审核结束,出参:"+result.toString());
        return result;
    }

    @ApiOperation(value = "审核不通过", httpMethod = "GET", notes = "审核不通过")
    @RequestMapping(value = "/checkNoInfo", method = RequestMethod.GET)
    public Result checkNoInfo(@RequestParam Integer id) {
        logger.info("审核不通过开始,入参:id="+id);
        Result result = service.checkNoInfo(id);
        logger.info("审核不通过结束,出参:"+result.toString());
        return result;
    }

}
