package com.teekee.blueoceanservice.service.syscompany;

import com.github.pagehelper.PageHelper;
import com.teekee.commoncomponets.base.BaseService;
import com.teekee.blueoceanservice.entity.syscompany.SysCompanyPermission;
import com.teekee.blueoceanservice.entity.syscompany.response.SysCompanyPermissionRes;
import com.teekee.blueoceanservice.mapper.syscompany.SysCompanyPermissionMapper;
import com.teekee.blueoceanservice.utils.*;
import com.teekee.commoncomponets.utils.PageInfo;
import com.teekee.commoncomponets.utils.Result;
import com.teekee.commoncomponets.utils.ResultUtil;
import com.teekee.commoncomponets.utils.TreeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @description: 系统权限资源
 * @author: zhangshuai
 * @create: 2018-12-12 09:26
 */
@Service
public class SysCompanyPermissionService extends BaseService<SysCompanyPermissionMapper,SysCompanyPermission> {

    @Autowired
    private SysCompanyPermissionMapper sysCompanyPermissionMapper;


    /**
     * 分页查询公司权限配置
     * @param sysCompanyPermission
     * @return
     */
    public Result findPage(SysCompanyPermission sysCompanyPermission){
        PageHelper.startPage(sysCompanyPermission.getPageNum(), sysCompanyPermission.getPageSize());
        sysCompanyPermission.setFlagDeleted(false);
        List<SysCompanyPermission> persons = sysCompanyPermissionMapper.selectAll(sysCompanyPermission);
        // 需要把Page包装成PageInfo对象才能序列化。该插件也默认实现了一个PageInfo
        PageInfo<SysCompanyPermission> pageInfo = new PageInfo<>(persons);
        return ResultUtil.success(pageInfo);
    }

    /**
     * 公司权限列表(树)
     * @return
     */
    public Result findByRoleIdList(){
        List<SysCompanyPermissionRes> permissionTree = TreeUtils.formatTree(sysCompanyPermissionMapper.selectConsolePermission(),false);
        return ResultUtil.success(permissionTree);
    }

}
