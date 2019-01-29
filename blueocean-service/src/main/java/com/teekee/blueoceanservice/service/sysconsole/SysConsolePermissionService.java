package com.teekee.blueoceanservice.service.sysconsole;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.teekee.commoncomponets.base.BaseService;
import com.teekee.blueoceanservice.entity.sysconsole.SysConsolePermission;
import com.teekee.blueoceanservice.entity.sysconsole.SysConsolePermissionApiRelation;
import com.teekee.blueoceanservice.entity.sysconsole.SysConsoleUsers;
import com.teekee.blueoceanservice.entity.sysconsole.response.SysConsolePermissionRes;
import com.teekee.blueoceanservice.mapper.syscompany.SysCompanyPermissionMapper;
import com.teekee.blueoceanservice.mapper.sysconsole.SysConsolePermissionApiRelationMapper;
import com.teekee.blueoceanservice.mapper.sysconsole.SysConsolePermissionMapper;
import com.teekee.blueoceanservice.utils.*;
import com.teekee.commoncomponets.utils.*;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @description: 平台模式权限功能
 * @author: zhangshuai
 * @create: 2018-12-25 13:46
 */
@Service
@Transactional(readOnly = true, rollbackFor = Exception.class)
public class SysConsolePermissionService extends BaseService<SysConsolePermissionMapper,SysConsolePermission> {

    private final Logger logger = Logger.getLogger(getClass());

    @Autowired
    private SysConsolePermissionMapper sysConsolePermissionMapper;

    @Autowired
    private SysConsolePermissionApiRelationMapper sysConsolePermissionApiRelationMapper;

    @Autowired
    private SysCompanyPermissionMapper sysCompanyPermissionMapper;

    /**
     * 查询平台个人权限
     * @param sysConsolePermission
     * @return
     */
    public List<SysConsolePermissionRes> findPermission(SysConsolePermission sysConsolePermission){
        return sysConsolePermissionMapper.selectPermission(sysConsolePermission);
    }


    /**
     * 当前权限及相关信息
     * @return
     */
    public Result findUserView() {

        SysConsoleUsers sysConsoleUsers = CurrentUtil.getCurrent();
        SysConsolePermission sysConsolePermission = new SysConsolePermission();
        sysConsolePermission.setUserId(sysConsoleUsers.getId());
        sysConsolePermission.setFlagIsMenu(true);

        logger.info("查询权限，入参：sysCompanyPermission="+sysConsolePermission.toString());
        List<SysConsolePermissionRes> permissionTree = TreeUtils.formatTree(sysConsolePermissionMapper.selectPermission(sysConsolePermission),false);
        logger.info("查询权限，出参：permissionTree="+permissionTree.toString());

        sysConsolePermission.setFlagIsMenu(false);

        Map<String,Object> map = new HashMap<>();
        map.put("sysUsers", sysConsoleUsers);
        map.put("permissionsTree",permissionTree);
        map.put("permissions",sysConsolePermissionMapper.selectPermission(sysConsolePermission));

        return ResultUtil.success(map);
    }


    /**
     * 分页平台权限列表
     * @param sysConsolePermission
     * @return
     */
    public Result findPage(SysConsolePermission sysConsolePermission){
        PageHelper.startPage(sysConsolePermission.getPageNum(), sysConsolePermission.getPageSize());
        Page<SysConsolePermission> persons = sysConsolePermissionMapper.findPage(sysConsolePermission);
        // 需要把Page包装成PageInfo对象才能序列化。该插件也默认实现了一个PageInfo
        PageInfo<SysConsolePermission> pageInfo = new PageInfo<>(persons);
        return ResultUtil.success(pageInfo);
    }


    /**
     * 平台权限绑定接口
     * @param sysConsolePermissionApiRelation
     * @return
     */
    @Transactional(readOnly = false,rollbackFor = Exception.class)
    public Result updatePermissionApi(SysConsolePermissionApiRelation sysConsolePermissionApiRelation){

        try {
            logger.info("删除当前权限接口");
            sysConsolePermissionApiRelationMapper.deleteByPermissionId(sysConsolePermissionApiRelation);
            logger.info("保存当前权限接口");
            sysConsolePermissionApiRelationMapper.savePermissionApi(sysConsolePermissionApiRelation.getPermissionId(),
                    sysConsolePermissionApiRelation.getApiIds().split(","));
            logger.info("更新redis中角色权限");
            String jsonStr = JsonUtils.getListToJson(sysCompanyPermissionMapper.selectRedisApiAll());
            RedisUtil.set("sys_company_api_all",jsonStr);
        } catch (Exception e) {
            e.printStackTrace();
            return ResultUtil.errorExceptionMsg("");
        }
        return  ResultUtil.success();
    }

    /**
     * 平台权限列表(树)
     * @param sysConsolePermission
     * @return
     */
    public Result findByRoleIdList(SysConsolePermission sysConsolePermission){
        List<SysConsolePermissionRes> permissionTree = TreeUtils.formatTree(sysConsolePermissionMapper.selectPermissionAll(sysConsolePermission),false);
        return ResultUtil.success(permissionTree);
    }

}
