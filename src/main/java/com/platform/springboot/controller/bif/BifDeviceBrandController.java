package com.platform.springboot.controller.bif;

import com.platform.springboot.entity.bif.BifDeviceBrand;
import com.platform.springboot.service.bif.BifDeviceBrandService;
import com.platform.springboot.utils.Result;
import com.platform.springboot.service.bif.BifDeviceBrandService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author zhanghao
 * @Title: BifDeviceBrandController
 * @ProjectName WaterDrop
 * @Description: 设备品牌
 * @date 2018/12/17下午1:38
 */
@RestController
@RequestMapping("/deviceBrand")
@Api(description = "设备品牌")
public class BifDeviceBrandController {

    private Logger log = Logger.getLogger(BifDeviceBrandController.class);
    @Resource
    private BifDeviceBrandService bifDeviceBrandService;

    @ApiOperation(value = "分页获取所有设备的品牌列表", httpMethod = "POST", notes = "分页获取所有设备的品牌列表")
    @RequestMapping(value = "/list", method = RequestMethod.POST)
    public Result list(@RequestBody BifDeviceBrand bifDeviceBrand) {
        log.info("获取所有设备的品牌列表-开始");
        Result result = bifDeviceBrandService.getDeviceBrandList(bifDeviceBrand);
        log.info("获取所有设备的品牌列表-结束");
        return result;
    }
    @ApiOperation(value = "根据ID，查看设备品牌详情", httpMethod = "GET", notes = "根据ID，查看设备品牌详情")
    @RequestMapping(value = "/show", method = RequestMethod.GET)
    public Result show(@RequestParam Integer id) {
        log.info("根据ID，查看设备品牌详情-开始");
        Result result = bifDeviceBrandService.getDeviceBrand(id);
        log.info("根据ID，查看设备品牌详情-结束");
        return result;
    }
    @ApiOperation(value = "新增/编辑设备品牌信息", httpMethod = "POST",
            notes = "** brandName **：@ 品牌名 * | " +
                    "** brandCode **：@ 品牌编号 * | " +
                    "** brandNameCn **：品牌中文名 | " +
                    "** brandNameEn **：品牌英文名 | " +
                    "** brandLogoUrl **：品牌logo的图片路径 | " +
                    "** companyName **：品牌的公司名 | " +
                    "** memo **：备注")
    @RequestMapping(value = "/handle", method = RequestMethod.POST)
    public Result handle(@RequestBody BifDeviceBrand bifDeviceBrand) {
        log.info("新增/编辑设备品牌信息-开始");
        Result result = bifDeviceBrandService.handle(bifDeviceBrand);
        log.info("新增/编辑设备品牌信息-结束");
        return result;
    }
    @ApiOperation(value = "失效设备品牌", httpMethod = "GET", notes = "失效设备品牌")
    @RequestMapping(value = "/invalid", method = RequestMethod.GET)
    public Result handleInvalid(@RequestParam Integer id ) {
        log.info("失效设备品牌-开始");
        Result result = bifDeviceBrandService.handleInvalid(id);
        log.info("失效设备品牌-结束");
        return result;
    }
    @ApiOperation(value = "删除设备品牌", httpMethod = "GET", notes = "删除设备品牌")
    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public Result handleDelete(@RequestParam Integer id) {
        log.info("删除设备品牌-开始");
        Result result = bifDeviceBrandService.handleDelete(id);
        log.info("删除设备品牌-结束");
        return result;
    }
}
