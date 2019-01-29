package com.teekee.waterdropservice.service.sys;

import com.teekee.commoncomponets.base.BaseService;
import com.teekee.commoncomponets.utils.PageInfo;
import com.teekee.commoncomponets.utils.RedisUtil;
import com.teekee.commoncomponets.utils.Result;
import com.teekee.commoncomponets.utils.ResultUtil;
import com.teekee.waterdropservice.entity.sys.SysCompanyRole;
import com.teekee.waterdropservice.entity.sys.SysCompanyRolePermission;
import com.teekee.waterdropservice.entity.sys.SysCompanyUsers;
import com.teekee.waterdropservice.entity.sys.response.RedisCompanyPermissionApiRes;
import com.teekee.waterdropservice.mapper.sys.SysCompanyPermissionMapper;
import com.teekee.waterdropservice.mapper.sys.SysCompanyRoleMapper;
import com.teekee.waterdropservice.mapper.sys.SysCompanyRolePermissionMapper;
import com.teekee.waterdropservice.utils.*;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
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
            logger.info("删除当前公司角色权限");
            sysCompanyRolePermission.setCompanyId(sysCompanyUsers.getCompanyId());
            sysCompanyRolePermissionMapper.deleteByRoleAndCompanyId(sysCompanyRolePermission);
            logger.info("保存当前公司角色权限");
            sysCompanyRolePermissionMapper.saveRoleAuthority(sysCompanyRolePermission.getRoleId(),sysCompanyUsers.getCompanyId(),
                    sysCompanyUsers.getId(),sysCompanyUsers.getId(),sysCompanyRolePermission.getPermissionIds().split(","));

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
