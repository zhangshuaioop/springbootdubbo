package com.teekee.waterdropservice.controller.bif;

import com.teekee.waterdropservice.entity.bif.BifDispatchHrSkillLabel;
import com.teekee.waterdropservice.service.bif.BifDispatchHrSkillLabelService;
import com.teekee.commoncomponets.utils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author zhanghao
 * @Title: BifDispatchHrSkillLabelController
 * @ProjectName WaterDrop
 * @Description: 服务商标签
 * @date 2019/1/17上午10:13
 */
@Api(description = "服务商标签")
@RestController
@RequestMapping("/bifDispatchHrSkillLabel")
public class BifDispatchHrSkillLabelController {

    private Logger log = Logger.getLogger(BifDispatchHrSkillLabelController.class);

    @Resource
    private BifDispatchHrSkillLabelService bifDispatchHrSkillLabelService;


    @ApiOperation(value = "服务商标签列表", httpMethod = "GET", notes = "服务商标签列表")
    @GetMapping(value = "/list")
    public Result list(@RequestParam Integer id) {
        log.info("获取服务商标签列表-开始");
        Result result = bifDispatchHrSkillLabelService.findList(id);
        log.info("获取服务商标签列表-结束");
        return result;
    }

    @ApiOperation(value = "添加服务商标签", httpMethod = "POST", notes = "添加服务商标签")
    @PostMapping(value = "/add")
    public Result add(@RequestBody List<BifDispatchHrSkillLabel> bifDispatchHrSkillLabel) {
        log.info("添加服务商标签-开始 入参：" + bifDispatchHrSkillLabel);
        Result result = bifDispatchHrSkillLabelService.add(bifDispatchHrSkillLabel);
        log.info("添加服务商标签-结束");
        return result;
    }

    @ApiOperation(value = "自定义标签列表", httpMethod = "GET", notes = "自定义标签列表")
    @GetMapping(value = "/customLabelList")
    public Result customLabelList() {
        log.info("自定义标签列表-开始");
        Result result = bifDispatchHrSkillLabelService.customLabelList();
        log.info("自定义标签列表-结束");
        return result;
    }

    @ApiOperation(value = "查询所有服务商标签", httpMethod = "GET", notes = "查询所有服务商标签")
    @GetMapping(value = "/findAll")
    public Result findAll() {
        log.info("查询所有服务商标签-开始");
        Result result = bifDispatchHrSkillLabelService.findAll();
        log.info("查询所有服务商标签-结束");
        return result;
    }
}