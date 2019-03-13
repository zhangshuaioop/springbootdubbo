package com.platform.springboot.service.sysconsole;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.mysql.jdbc.util.ResultSetUtil;
import com.platform.springboot.base.BaseService;
import com.platform.springboot.controller.sysconsole.request.SysConsoleUserPassword;
import com.platform.springboot.entity.sysconsole.SysConsoleUserRoleRelation;
import com.platform.springboot.entity.sysconsole.SysConsoleUsers;
import com.platform.springboot.mapper.sysconsole.SysConsoleUserRoleRelationMapper;
import com.platform.springboot.mapper.sysconsole.SysConsoleUsersMapper;
import com.platform.springboot.utils.*;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @description: 平台用户账号
 * @author: zhangshuai
 * @create: 2018-12-25 13:54
 */
@Service
@Transactional(readOnly = true, rollbackFor = Exception.class)
public class SysConsoleUsersService extends BaseService<SysConsoleUsersMapper,SysConsoleUsers> {

    private final Logger logger = Logger.getLogger(getClass());

    @Autowired
    private SysConsoleUsersMapper sysConsoleUsersMapper;

    @Autowired
    private SysConsoleUserRoleRelationMapper sysConsoleUserRoleRelationMapper;

    /**
     * 根据用户名查询用户信息
     * @param username
     * @return
     */
    public SysConsoleUsers findUserName(String username){
        return sysConsoleUsersMapper.selectByUserName(username);
    }


    /**
     * 分页账号列表
     * @param sysConsoleUsers
     * @return
     */
    public Result findPage(SysConsoleUsers sysConsoleUsers){
        PageHelper.startPage(sysConsoleUsers.getPageNum(), sysConsoleUsers.getPageSize());
        Page<SysConsoleUsers> persons = sysConsoleUsersMapper.findPage(sysConsoleUsers);
        // 需要把Page包装成PageInfo对象才能序列化。该插件也默认实现了一个PageInfo
        PageInfo<SysConsoleUsers> pageInfo = new PageInfo<>(persons);
        if(pageInfo.getList()==null||pageInfo.getList().size()==0){
            pageInfo.setPageNum(1);
            pageInfo.setPageSize(10);
        }
        return ResultUtil.success(pageInfo);
    }


    /**
     * 账号保存/修改
     * @param sysConsoleUsers
     * @return
     */
    @Transactional(readOnly = false,rollbackFor = Exception.class)
    public Result saveOrUpdateUsers(SysConsoleUsers sysConsoleUsers){
        if(sysConsoleUsers != null){

            if(sysConsoleUsers.getId() != null && sysConsoleUsers.getId() > 0) {
                logger.info("进入账号修改业务");
                if(sysConsoleUsers.getPassword() != null && sysConsoleUsers.getPassword().length() > 0){
                    sysConsoleUsers.setPassword(MD5Utils.MD5Encode(sysConsoleUsers.getPassword(),"utf-8"));
                }
                sysConsoleUsersMapper.updateByPrimaryKeySelective(sysConsoleUsers);
                return ResultUtil.successMsg("更新成功");
            }else {

                if(sysConsoleUsers != null && sysConsoleUsers.getUsername() != null &&
                        sysConsoleUsers.getUsername().length() > 0 && sysConsoleUsers.getPassword() != null &&
                        sysConsoleUsers.getPassword().length() > 0){

                    logger.info("进入账号保存业务");
                    if(sysConsoleUsersMapper.selectByUserName(sysConsoleUsers.getUsername()) == null){
                        sysConsoleUsers.setPassword(MD5Utils.MD5Encode(sysConsoleUsers.getPassword(),"utf-8"));
                        sysConsoleUsers.setFlagDeleted(false);
                        sysConsoleUsers.setFlagAvailable(true);
                        sysConsoleUsersMapper.insertSelective(sysConsoleUsers);
                        return ResultUtil.successMsg("注册成功");
                    }
                    return ResultUtil.errorBusinessMsg("用户已存在");

                }else {
                    return ResultUtil.validateError("");
                }

            }

        }else {
            return ResultUtil.validateError("");
        }
    }



    /**
     * 赋予账号角色
     * @param sysConsoleUserRoleRelation
     * @return
     */
    @Transactional(readOnly = false,rollbackFor = Exception.class)
    public Result updateUserRole(SysConsoleUserRoleRelation sysConsoleUserRoleRelation) {
        try {
            logger.info("删除当前用户角色");
            sysConsoleUserRoleRelationMapper.deleteByUser(sysConsoleUserRoleRelation);
            logger.info("保存当前用户角色");
            sysConsoleUserRoleRelationMapper.saveUserRole(sysConsoleUserRoleRelation.getUserId(),
                    CurrentUtil.getCurrent().getId(),sysConsoleUserRoleRelation.getRoleIds().split(","));

        } catch (Exception e) {
            e.printStackTrace();
            return ResultUtil.errorExceptionMsg("");
        }
        return ResultUtil.success();
    }


    /**
     * 修改平台密码
     * @param sysConsoleUserPassword
     * @return
     */
    @Transactional(readOnly = false,rollbackFor = Exception.class)
    public Result updatePassword(SysConsoleUserPassword sysConsoleUserPassword) {

        if(sysConsoleUserPassword != null){

            SysConsoleUsers sysConsoleUsers = CurrentUtil.getCurrent();
            if(sysConsoleUserPassword.getPassword() == null || sysConsoleUserPassword.getPassword().length()==0){
                return ResultUtil.validateError("请输入原密码");
            }

            if(sysConsoleUserPassword.getNewPassword() == null || sysConsoleUserPassword.getNewPassword().length()==0){
                return ResultUtil.validateError("请输入新密码");
            }

            if(!sysConsoleUsersMapper.selectByPrimaryKey(sysConsoleUsers.getId()).getPassword().equals(MD5Utils.MD5Encode(sysConsoleUserPassword.getPassword(),"utf-8"))){
                return ResultUtil.validateError("原密码错误");
            }

            SysConsoleUsers sysConsoleUsers1 = new SysConsoleUsers();
            sysConsoleUsers1.setId(sysConsoleUsers.getId());
            sysConsoleUsers1.setPassword(MD5Utils.MD5Encode(sysConsoleUserPassword.getNewPassword(),"utf-8"));
            sysConsoleUsersMapper.updateByPrimaryKeySelective(sysConsoleUsers1);

        }else {
            return ResultUtil.validateError("");
        }
        return ResultUtil.success();
    }




    /**
     * 重置平台密码
     * @param userId
     * @return
     */
    @Transactional(readOnly = false,rollbackFor = Exception.class)
    public Result resetPassword(Integer userId) {

        if(userId != null){
            SysConsoleUsers sysConsoleUsers = new SysConsoleUsers();
            sysConsoleUsers.setId(userId);
            sysConsoleUsers.setPassword(MD5Utils.MD5Encode("123456","utf-8"));
            sysConsoleUsersMapper.updateByPrimaryKeySelective(sysConsoleUsers);
        }else {
            return ResultUtil.validateError("");
        }
        return ResultUtil.success();
    }

    /**
     * 查询有效用户列表
     * @return
     */
    public Result findUserList(){
        return ResultUtil.success(sysConsoleUsersMapper.findUserList());
    }

}
