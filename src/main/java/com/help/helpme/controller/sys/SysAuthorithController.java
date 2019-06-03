package com.help.helpme.controller.sys;

import com.help.helpme.entity.sys.SysAuthority;
import com.help.helpme.entity.sys.response.SysAuthorityRes;
import com.help.helpme.service.sys.SysAuthorityService;
import com.help.helpme.utils.Result;
import com.help.helpme.utils.ResultUtil;
import com.help.helpme.utils.TreeUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @description: 系统权限
 * @author: zhangshuai
 * @create: 2019-05-31 22:31
 */
@RestController
@RequestMapping("/sysAuthorith")
@Api(description = "系统权限")
public class SysAuthorithController {

    private final Logger logger = Logger.getLogger(getClass());

    @Autowired
    private SysAuthorityService sysAuthorityService;

    @ApiOperation(
            value = "系统权限列表",
            notes = "系统权限列表",
            consumes = "application/json",
            responseReference = "com.help.helpme.utils.Result"
    )
    @SuppressWarnings("unchecked")
    @RequestMapping(value = "/getList",method=RequestMethod.GET)
    @PreAuthorize("hasRole('角色列表')")
    public Result getList() {
        logger.info("系统权限列表开始,入参:无");
        SysAuthority sysAuthority = new SysAuthority();
        sysAuthority.setFlagEnabled(true);
        List<SysAuthorityRes> sysAuthoritiesTree = TreeUtils.formatTree(sysAuthorityService.findAllTree(sysAuthority),false);
        logger.info("系统权限列表结束,出参:result="+sysAuthoritiesTree.toString());
        return ResultUtil.success(sysAuthoritiesTree);
    }

}
