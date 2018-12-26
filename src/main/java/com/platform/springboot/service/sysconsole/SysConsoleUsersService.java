package com.platform.springboot.service.sysconsole;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.platform.springboot.base.BaseService;
import com.platform.springboot.entity.sysconsole.SysConsoleUsers;
import com.platform.springboot.mapper.sysconsole.SysConsoleUsersMapper;
import com.platform.springboot.utils.MD5Utils;
import com.platform.springboot.utils.PageInfo;
import com.platform.springboot.utils.Result;
import com.platform.springboot.utils.ResultUtil;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @description: 平台用户账号
 * @author: zhangshuai
 * @create: 2018-12-25 13:54
 */
@Service
public class SysConsoleUsersService extends BaseService<SysConsoleUsersMapper,SysConsoleUsers> {

    private final Logger logger = Logger.getLogger(getClass());

    @Autowired
    private SysConsoleUsersMapper sysConsoleUsersMapper;

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
        return ResultUtil.success(pageInfo);
    }


    /**
     * 账号保存/修改
     * @param sysConsoleUsers
     * @return
     */
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
                        sysConsoleUsers.setFlagDeleted(true);
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

}
