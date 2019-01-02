package com.platform.springboot.service.sysconsole;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.platform.springboot.base.BaseService;
import com.platform.springboot.entity.sysconsole.SysConsolePermission;
import com.platform.springboot.entity.sysconsole.SysConsolePermissionApiRelation;
import com.platform.springboot.mapper.syscompany.SysCompanyPermissionMapper;
import com.platform.springboot.mapper.sysconsole.SysConsolePermissionApiRelationMapper;
import com.platform.springboot.mapper.sysconsole.SysConsolePermissionMapper;
import com.platform.springboot.utils.*;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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
     * @param userId
     * @return
     */
    public List<SysConsolePermission> findPermission(Integer userId){
        return sysConsolePermissionMapper.selectPermission(userId);
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


}
