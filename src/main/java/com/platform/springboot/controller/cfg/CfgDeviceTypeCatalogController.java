package com.platform.springboot.controller.cfg;

import com.platform.springboot.entity.cfg.CfgDeviceTypeCatalog;
import com.platform.springboot.service.cfg.CfgDeviceTypeCatalogService;
import com.platform.springboot.utils.Result;
import com.platform.springboot.utils.ResultUtil;
import com.platform.springboot.service.cfg.CfgDeviceTypeCatalogService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author zhanghao
 * @Title: CfgDeviceTypeCatalogController
 * @ProjectName WaterDrop
 * @Description: 设备类型
 * @date 2018/12/24下午4:31
 */
@RestController
@RequestMapping("/cfgDeviceTypeCatalog")
@Api(description = "设备类型")
public class CfgDeviceTypeCatalogController {

    private Logger log = Logger.getLogger(CfgDeviceTypeCatalogController.class);

    @Resource
    private CfgDeviceTypeCatalogService service;

    @ApiOperation(value = "根据父级节点查询子节点", httpMethod = "GET", notes = "根据父级节点查询子节点")
    @GetMapping(value = "/list")
    public Result getListByParentId(@RequestParam Integer parentId) {
        log.info("根据父级节点查询子节点-开始 入参："+parentId);
        List<Integer> list = new ArrayList<Integer>();
        list.add(parentId);
        List<CfgDeviceTypeCatalog> listResult = service.getListByParentId(list);
        log.info("根据父级节点查询子节点-结束 出参："+listResult);
        return ResultUtil.success(listResult);
    }

    @ApiOperation(value = "根据ID，查询所有设备类型，返回树形结构", httpMethod = "GET", notes = "根据ID，查询所有设备类型，返回树形结构")
    @GetMapping(value = "/getTreeById")
    public Result getTreeById(@RequestParam Integer id) {
        log.info("根据ID，查询所有设备类型，返回树形结构-开始 入参："+id);
        Result result = service.getTreeById(id);
        log.info("根据ID，查询所有设备类型，返回树形结构-结束 出参："+result.getData());
        return result;
    }

}
