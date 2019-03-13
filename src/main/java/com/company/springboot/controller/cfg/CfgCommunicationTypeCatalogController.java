package com.company.springboot.controller.cfg;

import com.company.springboot.entity.cfg.CfgCommunicationTypeCatalog;
import com.company.springboot.utils.Result;
import com.company.springboot.utils.ResultUtil;
import com.company.springboot.entity.cfg.CfgCommunicationTypeCatalog;
import com.company.springboot.service.cfg.CfgCommunicationTypeCatalogService;
import com.company.springboot.utils.Result;
import com.company.springboot.utils.ResultUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 通讯资源类型
 * @Author Niting
 * @date 2018/12/18
 **/
@RestController
@RequestMapping("/cfgComm")
@Api(description = "通信资源类型")
public class CfgCommunicationTypeCatalogController {
    private final Logger logger = Logger.getLogger(getClass());

    @Autowired
    private CfgCommunicationTypeCatalogService service;

    @ApiOperation(value = "根据ID，查询所有通讯资源类型", httpMethod = "GET", notes = "根据ID，查询所有通讯资源类型")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public Result show(@RequestParam Integer id) {
        logger.info("根据ID，查询所有通讯资源类型开始,入参:id="+id);
        List<CfgCommunicationTypeCatalog> result = service.list(id);
        logger.info("根据ID，查询所有通讯资源类型结束,出参:"+result.toString());
        return ResultUtil.success(result);
    }
}
