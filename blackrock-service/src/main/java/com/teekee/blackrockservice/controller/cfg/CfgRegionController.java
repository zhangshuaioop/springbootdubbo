package com.teekee.blackrockservice.controller.cfg;

import com.teekee.blackrockservice.base.BaseController;
import com.teekee.blackrockservice.entity.cfg.CfgRegionList;
import com.teekee.blackrockservice.service.cfg.CfgRegionService;
import com.teekee.blackrockservice.utils.StringUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author Niting
 * @date 2018/11/7
 **/
@Api(value = "CfgRegionController", tags = "region-service")
@RestController
@RequestMapping("cfgRegion")
public class CfgRegionController extends BaseController{
    private Logger log = Logger.getLogger(CfgRegionController.class);
    @Resource
    CfgRegionService service;

    @ApiOperation(value = "查询第二级省份信息", notes = "查询第二级省份信息", consumes = "application/json", responseReference = "com.example.timemachine.utils.Result")
    @GetMapping(value = "/queryProvice")
    public String serviceAreaList() {
        log.info("查询第二级省份信息-开始");
        List<CfgRegionList> result = service.queryProvice();
        log.info("查询第二级省份信息-结束");
        return build(StringUtil.buildJsonSucessRespMsg(result));
    }

    @ApiOperation(value = "查询第三级城市信息", notes = "查询第三级城市信息", consumes = "application/json", responseReference = "com.example.timemachine.utils.Result")
    @GetMapping(value = "/queryCity")
    public String queryCity(@RequestParam("id") Integer id) {
        log.info("查询第三级城市信息-开始");
        List<CfgRegionList> result = service.queryCity(id);
        log.info("查询第三级城市信息-结束");
        return build(StringUtil.buildJsonSucessRespMsg(result));
    }
}
