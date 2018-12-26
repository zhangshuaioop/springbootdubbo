//package com.platform.springboot.service.syscompany;
//
//import com.github.pagehelper.Page;
//import com.github.pagehelper.PageHelper;
//import com.platform.springboot.base.BaseService;
//import com.platform.springboot.entity.syscompany.SysCompanyPermission;
//import com.platform.springboot.entity.syscompany.SysCompanyUsers;
//import com.platform.springboot.entity.syscompany.response.SysCompanyPermissionRes;
//import com.platform.springboot.mapper.syscompany.SysCompanyPermissionMapper;
//import com.platform.springboot.mapper.syscompany.SysCompanyUsersMapper;
//import com.platform.springboot.utils.*;
//import org.apache.log4j.Logger;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
///**
// * @description: 公司用户账号
// * @author: zhangshuai
// * @create: 2018-12-12 09:20
// */
//@Service
//@Transactional(readOnly = true, rollbackFor = Exception.class)
//public class SysCompanyUsersService extends BaseService<SysCompanyUsersMapper,SysCompanyUsers> {
//
//    private final Logger logger = Logger.getLogger(getClass());
//
//    @Autowired
//    private SysCompanyUsersMapper sysCompanyUsersMapper;
//
//    @Autowired
//    private SysCompanyPermissionMapper sysCompanyPermissionMapper;
//
//
//    /**
//     * 根据用户名查询用户信息
//     * @param username
//     * @return
//     */
//    public SysCompanyUsers findUserName(String username){
//        return sysCompanyUsersMapper.selectByUserName(username);
//    }
//
//
//    /**
//     * 当前权限及相关信息
//     * @return
//     */
//    public Result findUserView() {
//
//        SysCompanyUsers sysCompanyUsers = CurrentUtil.getCurrent();
//        SysCompanyPermission sysCompanyPermission = new SysCompanyPermission();
//        sysCompanyPermission.setCompanyId(sysCompanyUsers.getCompanyId());
//        sysCompanyPermission.setUserId(sysCompanyUsers.getId());
//
//        logger.info("查询权限，入参：sysCompanyPermission="+sysCompanyPermission.toString());
//        List<SysCompanyPermissionRes> permissionTree = TreeUtils.formatTree(sysCompanyPermissionMapper.selectPermission(sysCompanyPermission),false);
//        logger.info("查询权限，出参：permissionTree="+permissionTree.toString());
//
//
//        Map<String,Object> map = new HashMap<>();
//        map.put("sysUsers", sysCompanyUsers);
//        map.put("permissionTree",permissionTree);
//
//        return ResultUtil.success(map);
//    }
//
//
//    /**
//     * 分页查询
//     *
//     * @param sysCompanyUsers
//     * @return
//     */
//    public Result findPage(SysCompanyUsers sysCompanyUsers) {
//
//        sysCompanyUsers.setRelationCompanyIds(CurrentUtil.getCurrent().getRelationCompanyIds());
//        PageHelper.startPage(sysCompanyUsers.getPageNum(), sysCompanyUsers.getPageSize());
//        Page<SysCompanyUsers> persons = sysCompanyUsersMapper.findPage(sysCompanyUsers);
//        // 需要把Page包装成PageInfo对象才能序列化。该插件也默认实现了一个PageInfo
//        PageInfo<SysCompanyUsers> pageInfo = new PageInfo<>(persons);
//
//        return ResultUtil.success(pageInfo);
//    }
//
//
//    /**
//     * 账号保存/修改
//     * @param sysCompanyUsers
//     * @return
//     */
//    @Transactional(readOnly = false,rollbackFor = Exception.class)
//    public Result saveOrUpdateUsers(SysCompanyUsers sysCompanyUsers){
//
//        if(sysCompanyUsers != null){
//
//            if(sysCompanyUsers.getId() != null && sysCompanyUsers.getId() > 0) {
//                logger.info("进入账号修改业务");
//                if(sysCompanyUsers.getPassword() != null && sysCompanyUsers.getPassword().length() > 0){
//                    sysCompanyUsers.setPassword(MD5Utils.MD5Encode(sysCompanyUsers.getPassword(),"utf-8"));
//                }
//                sysCompanyUsersMapper.updateByPrimaryKeySelective(sysCompanyUsers);
//                return ResultUtil.successMsg("更新成功");
//            }else {
//
//                if(sysCompanyUsers != null && sysCompanyUsers.getUsername() != null &&
//                        sysCompanyUsers.getUsername().length() > 0 && sysCompanyUsers.getPassword() != null &&
//                        sysCompanyUsers.getPassword().length() > 0){
//
//                    logger.info("进入账号保存业务");
//                    if(sysCompanyUsersMapper.selectByUserName(sysCompanyUsers.getUsername()) == null){
//                        sysCompanyUsers.setPassword(MD5Utils.MD5Encode(sysCompanyUsers.getPassword(),"utf-8"));
//                        sysCompanyUsers.setFlagDeleted(true);
//                        sysCompanyUsers.setFlagAvailable(true);
//                        sysCompanyUsers.setCompanyId(CurrentUtil.getCurrent().getCompanyId());
//                        sysCompanyUsersMapper.insertSelective(sysCompanyUsers);
//                        return ResultUtil.successMsg("注册成功");
//                    }
//                    return ResultUtil.errorBusinessMsg("用户已存在");
//
//                }else {
//                    return ResultUtil.validateError("");
//                }
//
//            }
//
//        }else {
//            return ResultUtil.validateError("");
//        }
//
//
//
//    }
//
//
//
//
//}
