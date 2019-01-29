package com.teekee.blackrockservice.controller.bif;

import com.teekee.blackrockservice.base.BaseController;
import com.teekee.blackrockservice.entity.bif.BifDispatchHrServiceArea;
import com.teekee.blackrockservice.entity.bif.ListBifDispatchHrServiceArea;
import com.teekee.blackrockservice.service.bif.BifDispatchHrServiceAreaService;
import com.teekee.blackrockservice.utils.ResponseMessage;
import com.teekee.blackrockservice.utils.StringUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @Author Niting
 * @date 2018/11/3
 **/
@Api(value = "BifDispatchHrServiceAreaController", tags = "serviceArea-service")
@RestController
@RequestMapping("serv/dispatchHrServiceArea")
public class BifDispatchHrServiceAreaController extends BaseController{
    private Logger log = Logger.getLogger(BifDispatchHrServiceAreaController.class);
    @Autowired
    BifDispatchHrServiceAreaService service;

    @ApiOperation(value = "查询可服务区域列表", notes = "查询可服务区域列表", consumes = "application/json", responseReference = "com.example.timemachine.utils.Result")
    @GetMapping(value = "/serviceAreaList")
    public String serviceAreaList(HttpServletRequest request) {
        log.info("查询可服务区域列表-开始");
        Integer hrId = getTokenFromHead(request);
        List<ListBifDispatchHrServiceArea> result = service.serviceAreaList(hrId);
        log.info("查询可服务区域列表-结束");
        return build(StringUtil.buildJsonSucessRespMsg(result));
    }

    @ApiOperation(value = "查询可服务区域", notes = "查询可服务区域", consumes = "application/json", responseReference = "com.example.timemachine.utils.Result")
    @GetMapping(value = "/serviceAreaShow")
    public String serviceAreaShow(@RequestParam("id") Integer id) {
        log.info("查询可服务区域-开始");
        ListBifDispatchHrServiceArea result = service.serviceAreaShow(id);
        log.info("查询可服务区域-结束");
        return build(StringUtil.buildJsonSucessRespMsg(result));
    }

    @ApiOperation(value = "新增/编辑可服务区域", notes = "新增/编辑可服务区域", consumes = "application/json", responseReference = "com.example.timemachine.utils.Result")
    @PostMapping(value = "/handleServiceArea")
    public String handleServiceArea(@RequestBody BifDispatchHrServiceArea param, HttpServletRequest request) {
        log.info("新增/编辑可服务区域-开始");
        Integer hrId = getTokenFromHead(request);
        param.setHrId(hrId);
        ResponseMessage result = service.handelServiceArea(param);
        log.info("新增/编辑可服务区域-结束");
        return build(StringUtil.buildJsonSucessRespMsg(result));
    }

    @ApiOperation(value = "删除可服务区域", notes = "删除可服务区域", consumes = "application/json", responseReference = "com.example.timemachine.utils.Result")
    @GetMapping(value = "/deleteServiceArea")
    public String deleteServiceArea(@RequestParam("id") Integer id) {
        log.info("删除可服务区域-开始");
        ResponseMessage result = service.deleteService(id);
        log.info("删除可服务区域-结束");
        return build(StringUtil.buildJsonSucessRespMsg(result));
    }
}
