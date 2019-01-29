package com.teekee.blueoceanservice.service.syscompany;//package com.teekee.blueoceanservice.service.syscompany;
//
//import com.github.pagehelper.Page;
//import com.github.pagehelper.PageHelper;
//import com.teekee.commoncomponets.base.BaseService;
//import com.teekee.blueoceanservice.entity.syscompany.SysCompanyPermission;
//import com.teekee.blueoceanservice.entity.syscompany.SysCompanyRole;
//import com.teekee.blueoceanservice.entity.syscompany.SysCompanyRolePermission;
//import com.teekee.blueoceanservice.entity.syscompany.SysCompanyUsers;
//import com.teekee.blueoceanservice.mapper.syscompany.SysCompanyPermissionMapper;
//import com.teekee.blueoceanservice.mapper.syscompany.SysCompanyRoleMapper;
//import com.teekee.blueoceanservice.mapper.syscompany.SysCompanyRolePermissionMapper;
//import com.teekee.blueoceanservice.utils.*;
//import org.apache.log4j.Logger;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//
///**
// * @description: 公司角色
// * @author: zhangshuai
// * @create: 2018-12-12 09:28
// */
//@Service
//@Transactional(readOnly = true, rollbackFor = Exception.class)
//public class SysCompanyRoleService extends BaseService<SysCompanyRoleMapper,SysCompanyRole> {
//
//    private final Logger logger = Logger.getLogger(getClass());
//
//
//    @Autowired
//    private SysCompanyRoleMapper sysCompanyRoleMapper;
//
//    @Autowired
//    private SysCompanyRolePermissionMapper sysCompanyRolePermissionMapper;
//
//    @Autowired
//    private SysCompanyPermissionMapper sysCompanyPermissionMapper;
//
//
//
//    /**
//     * 角色赋权
//     * @param sysCompanyRolePermission
//     * @return
//     */
//    @Transactional(readOnly = false,rollbackFor = Exception.class)
//    public Result updateRolePermission(SysCompanyRolePermission sysCompanyRolePermission) {
//        SysCompanyUsers sysCompanyUsers = CurrentUtil.getCurrent();
//        try {
//            logger.info("删除当前公司角色权限");
//            sysCompanyRolePermission.setCompanyId(sysCompanyUsers.getCompanyId());
//            sysCompanyRolePermissionMapper.deleteByRoleAndCompanyId(sysCompanyRolePermission);
//            logger.info("保存当前公司角色权限");
//            sysCompanyRolePermissionMapper.saveRoleAuthority(sysCompanyRolePermission.getRoleId(),sysCompanyUsers.getCompanyId(),
//                    sysCompanyUsers.getId(),sysCompanyUsers.getId(),sysCompanyRolePermission.getPermissionIds().split(","));
//
//            SysCompanyPermission sysCompanyPermission = new SysCompanyPermission();
//            sysCompanyPermission.setCompanyId(sysCompanyUsers.getCompanyId());
//            sysCompanyPermission.setUserId(sysCompanyUsers.getId());
//            logger.info("更新redis中角色权限");
//            String jsonStr = JsonUtils.getListToJson(sysCompanyPermissionMapper.selectPermission(sysCompanyPermission));
//            RedisUtil.set("sys_company_users,"+sysCompanyUsers.getId(),jsonStr);
//
//        } catch (Exception e) {
//            e.printStackTrace();
//            return ResultUtil.errorExceptionMsg("");
//        }
//        return ResultUtil.success();
//    }
//
//
//
//}
