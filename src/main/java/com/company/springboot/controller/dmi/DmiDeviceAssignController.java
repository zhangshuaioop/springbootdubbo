package com.company.springboot.controller.dmi;

import com.company.springboot.entity.bif.BifDeviceInputParam;
import com.company.springboot.entity.dmi.DmiDeviceAssignWithList;
import com.company.springboot.utils.Result;
import com.company.springboot.entity.bif.BifDeviceInputParam;
import com.company.springboot.entity.dmi.DmiDeviceAssignWithList;
import com.company.springboot.service.dmi.DmiDeviceAssignService;
import com.company.springboot.utils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;

/**
 * @author zhanghao
 * @Title: DmiDeviceAssignController
 * @ProjectName WaterDrop
 * @Description: 设备关联control
 * @date 2018/12/15下午3:33
 */
@RestController
@RequestMapping("/deviceAssign")
@Api(description = "设备关联")
public class DmiDeviceAssignController {

    private Logger log = Logger.getLogger(DmiDeviceAssignController.class);

    @Resource
    private DmiDeviceAssignService dmiDeviceAssignService;

    @ApiOperation(value = "分配设备", httpMethod = "POST")
    @RequestMapping(value = "/assign", method = RequestMethod.POST)
    public Result assign(@RequestBody DmiDeviceAssignWithList record) {
     return dmiDeviceAssignService.assign(record);
    }
    @ApiOperation(value = "回收设备", httpMethod = "POST")
    @RequestMapping(value = "/release", method = RequestMethod.POST)
    public Result release(@RequestBody DmiDeviceAssignWithList record) {
        return dmiDeviceAssignService.release(record);
    }
    @ResponseBody
    @ApiOperation(value = "查询门店中的已有设备", httpMethod = "POST")
    @RequestMapping(value = "/list", method = RequestMethod.POST, produces = "text/json;charset=UTF-8")
    public Result list(@RequestBody BifDeviceInputParam record) {
        return dmiDeviceAssignService.list(record);
    }

}
