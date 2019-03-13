package com.company.springboot.service.sys;

import com.company.springboot.base.BaseService;
import com.company.springboot.entity.sys.SysCompanyRole;
import com.company.springboot.entity.sys.SysCompanyRolePermission;
import com.company.springboot.entity.sys.SysCompanyUsers;
import com.company.springboot.entity.sys.response.RedisCompanyPermissionApiRes;
import com.company.springboot.mapper.sys.SysCompanyRolePermissionMapper;
import com.company.springboot.utils.*;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.company.springboot.mapper.sys.SysCompanyPermissionMapper;
import com.company.springboot.mapper.sys.SysCompanyRoleMapper;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * @description: 公司角色
 * @author: zhangshuai
 * @create: 2018-12-12 09:28
 */
@Service
@Transactional(readOnly = true, rollbackFor = Exception.class)
public class SysCompanyRoleService extends BaseService<SysCompanyRoleMapper,SysCompanyRole> {

    private final Logger logger = Logger.getLogger(getClass());


    @Autowired
    private SysCompanyRoleMapper sysCompanyRoleMapper;

    @Autowired
    private SysCompanyRolePermissionMapper sysCompanyRolePermissionMapper;

    @Autowired
    private SysCompanyPermissionMapper sysCompanyPermissionMapper;

    /**
     * 分页查询
     * @param sysCompanyRole
     * @return
     */
    public Result findPage(SysCompanyRole sysCompanyRole) {

//        sysCompanyRole.setRelationCompanyIds(CurrentUtil.getCurrent().getRelationCompanyIds());
        sysCompanyRole.setCompanyId(CurrentUtil.getCurrent().getCompanyId());
        PageHelper.startPage(sysCompanyRole.getPageNum(), sysCompanyRole.getPageSize());
        Page<SysCompanyRole> persons = sysCompanyRoleMapper.findPage(sysCompanyRole);
        // 需要把Page包装成PageInfo对象才能序列化。该插件也默认实现了一个PageInfo
        PageInfo<SysCompanyRole> pageInfo = new PageInfo<>(persons);
        if(pageInfo.getList()==null||pageInfo.getList().size()==0){
            pageInfo.setPageNum(1);
            pageInfo.setPageSize(10);
        }
        return ResultUtil.success(pageInfo);
    }

    /**
     * 根据用户id获取所有角色列表
     * @param userId
     * @return
     */
    public Result findAllByUserId(Integer userId) {
        RedisCompanyPermissionApiRes redisCompanyPermissionApiRes = new RedisCompanyPermissionApiRes();
        redisCompanyPermissionApiRes.setUserId(userId);
        redisCompanyPermissionApiRes.setCompanyId(CurrentUtil.getCurrent().getCompanyId());
        return ResultUtil.success(sysCompanyRoleMapper.selectAllByUserId(redisCompanyPermissionApiRes));
    }

    /**
     * 角色赋权
     * @param sysCompanyRolePermission
     * @return
     */
    @Transactional(readOnly = false,rollbackFor = Exception.class)
    public Result updateRolePermission(SysCompanyRolePermission sysCompanyRolePermission) {
        SysCompanyUsers sysCompanyUsers = CurrentUtil.getCurrent();
        try {
            logger.info("删除当前角色权限");
            sysCompanyRolePermissionMapper.deleteByRoleAndCompanyId(sysCompanyRolePermission);
            sysCompanyRolePermission.setCompanyId(sysCompanyUsers.getCompanyId());
            logger.info("保存当前公司角色权限");
            String permissionIds = "1,"+sysCompanyRolePermission.getPermissionIds();
            sysCompanyRolePermissionMapper.saveRoleAuthority(sysCompanyRolePermission.getRoleId(),sysCompanyUsers.getCompanyId(),
                    sysCompanyUsers.getId(),sysCompanyUsers.getId(),permissionIds.split(","));

            logger.info("更新redis中角色权限");
            String jsonStr = JsonUtils.getListToJson(sysCompanyPermissionMapper.selectRedisApiAll());
            RedisUtil.set("sys_company_api_all",jsonStr);

        } catch (Exception e) {
            e.printStackTrace();
            return ResultUtil.errorExceptionMsg("");
        }
        return ResultUtil.success();
    }



}
