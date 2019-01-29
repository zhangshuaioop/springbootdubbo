package com.teekee.blueoceanservice.service.sysconsole;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.teekee.commoncomponets.base.BaseService;
import com.teekee.blueoceanservice.entity.syscompany.response.RedisCompanyPermissionApiRes;
import com.teekee.blueoceanservice.entity.sysconsole.SysConsoleRole;
import com.teekee.blueoceanservice.entity.sysconsole.SysConsoleRolePermission;
import com.teekee.blueoceanservice.mapper.sysconsole.SysConsoleRoleMapper;
import com.teekee.blueoceanservice.mapper.sysconsole.SysConsoleRolePermissionMapper;
import com.teekee.blueoceanservice.utils.CurrentUtil;
import com.teekee.commoncomponets.utils.PageInfo;
import com.teekee.commoncomponets.utils.Result;
import com.teekee.commoncomponets.utils.ResultUtil;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @description: 平台角色
 * @author: zhangshuai
 * @create: 2018-12-25 13:50
 */
@Service
@Transactional(readOnly = true, rollbackFor = Exception.class)
public class SysConsoleRoleService extends BaseService<SysConsoleRoleMapper,SysConsoleRole> {

    private final Logger logger = Logger.getLogger(getClass());

    @Autowired
    private SysConsoleRoleMapper sysConsoleRoleMapper;

    @Autowired
    private SysConsoleRolePermissionMapper sysConsoleRolePermissionMapper;

    /**
     * 分页角色列表
     * @param sysConsoleRole
     * @return
     */
    public Result findPage(SysConsoleRole sysConsoleRole){

        PageHelper.startPage(sysConsoleRole.getPageNum(), sysConsoleRole.getPageSize());
        Page<SysConsoleRole> persons = sysConsoleRoleMapper.findPage(sysConsoleRole);
        // 需要把Page包装成PageInfo对象才能序列化。该插件也默认实现了一个PageInfo
        PageInfo<SysConsoleRole> pageInfo = new PageInfo<>(persons);
        return ResultUtil.success(pageInfo);
    }



    /**
     * 角色赋权
     * @param sysConsoleRolePermission
     * @return
     */
    @Transactional(readOnly = false,rollbackFor = Exception.class)
    public Result updateRolePermission(SysConsoleRolePermission sysConsoleRolePermission) {
        try {
            logger.info("删除当前角色权限");
            sysConsoleRolePermissionMapper.deleteByRoleId(sysConsoleRolePermission);
            logger.info("保存当前角色权限");
            sysConsoleRolePermissionMapper.saveRolePermission(sysConsoleRolePermission.getRoleId(),CurrentUtil.getCurrent().getId(),
                    sysConsoleRolePermission.getPermissionIds().split(","));
        } catch (Exception e) {
            e.printStackTrace();
            return ResultUtil.errorExceptionMsg("");
        }
        return ResultUtil.success();
    }


    /**
     * 根据用户id获取所有角色列表
     * @param userId
     * @return
     */
    public Result findAllByUserId(Integer userId) {
        RedisCompanyPermissionApiRes redisCompanyPermissionApiRes = new RedisCompanyPermissionApiRes();
        redisCompanyPermissionApiRes.setUserId(userId);
        return ResultUtil.success(sysConsoleRoleMapper.selectAllByUserId(redisCompanyPermissionApiRes));
    }

}
