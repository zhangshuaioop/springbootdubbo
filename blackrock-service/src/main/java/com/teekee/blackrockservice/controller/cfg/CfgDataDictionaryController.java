package com.teekee.blackrockservice.controller.cfg;

import com.teekee.blackrockservice.base.BaseController;
import com.teekee.blackrockservice.entity.cfg.CfgDataDictionary;
import com.teekee.blackrockservice.service.cfg.CfgDataDictionaryService;
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
@Api(value = "CfgDataDictionaryController", tags = "dictionary-service")
@RestController
@RequestMapping("/dictionary")
public class CfgDataDictionaryController extends BaseController{
    private Logger log = Logger.getLogger(CfgDataDictionaryController.class);

    @Resource
    CfgDataDictionaryService service;

    @ApiOperation(value = "字典表查询", notes = "字典表查询", consumes = "application/json", responseReference = "com.example.timemachine.utils.Result")
    @GetMapping(value = "/queryDictionary")
    public String serviceAreaList(@RequestParam("type") String type) {
        log.info("字典表查询-开始");
        List<CfgDataDictionary> result = service.getDictionaryByType(type);
        log.info("字典表查询-结束");
        return build(StringUtil.buildJsonSucessRespMsg(result));
    }
}
