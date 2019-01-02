package com.platform.springboot.service.dmi;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.platform.springboot.base.BaseService;
import com.platform.springboot.entity.dmi.DmiCompanyInfo;
import com.platform.springboot.entity.syscompany.SysCompanyPurchaseVersion;
import com.platform.springboot.entity.syscompany.SysCompanyUsers;
import com.platform.springboot.entity.sysconsole.SysConsoleUsers;
import com.platform.springboot.mapper.dmi.DmiCompanyInfoMapper;
import com.platform.springboot.mapper.syscompany.SysCompanyPermissionMapper;
import com.platform.springboot.mapper.syscompany.SysCompanyPurchaseVersionMapper;
import com.platform.springboot.mapper.syscompany.SysCompanyUsersMapper;
import com.platform.springboot.utils.*;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @description:雇主公司信息
 * @author: zhangshuai
 * @create: 2018-12-29 16:17
 */
@Service
@Transactional(readOnly = true, rollbackFor = Exception.class)
public class DmiCompanyInfoService extends BaseService<DmiCompanyInfoMapper,DmiCompanyInfo> {

    private final Logger logger = Logger.getLogger(getClass());

    @Autowired
    private DmiCompanyInfoMapper dmiCompanyInfoMapper;

    @Autowired
    private SysCompanyPurchaseVersionMapper sysCompanyPurchaseVersionMapper;

    @Autowired
    private SysCompanyPermissionMapper sysCompanyPermissionMapper;

    @Autowired
    private SysCompanyUsersMapper sysCompanyUsersMapper;

    /**
     * 分页列表
     * @param dmiCompanyInfo
     * @return
     */
    public Result findPage(DmiCompanyInfo dmiCompanyInfo){
        PageHelper.startPage(dmiCompanyInfo.getPageNum(), dmiCompanyInfo.getPageSize());
        Page<DmiCompanyInfo> persons = dmiCompanyInfoMapper.findPage(dmiCompanyInfo);
        // 需要把Page包装成PageInfo对象才能序列化。该插件也默认实现了一个PageInfo
        PageInfo<DmiCompanyInfo> pageInfo = new PageInfo<>(persons);
        return ResultUtil.success();
    }

    /**
     * 公司保存/更新
     * @param dmiCompanyInfo
     * @return
     */
    @Transactional(readOnly = false,rollbackFor = Exception.class)
    public Result saveOrUpdate(DmiCompanyInfo dmiCompanyInfo){

        SysConsoleUsers sysConsoleUsers = CurrentUtil.getCurrent();
        dmiCompanyInfo.setUpdatePerson(sysConsoleUsers.getId());
        if(dmiCompanyInfo != null){

            if(dmiCompanyInfo.getId() != null && dmiCompanyInfo.getId() > 0) {
                logger.info("进入更新业务");
                dmiCompanyInfoMapper.updateByPrimaryKeySelective(dmiCompanyInfo);
                return ResultUtil.success("更新成功");
            }else {
                logger.info("进入保存业务");
                if(dmiCompanyInfoMapper.selectCompanyName(dmiCompanyInfo.getCompanyName()) == null){

                    boolean isNext = true;

                    logger.info("初始化用户账号");
                    while (isNext){
                        String username = MathUtil.getUserName(8);
                        if(sysCompanyUsersMapper.selectByUserName(username) == null){

                            logger.info("开始创建公司");
                            dmiCompanyInfo.setCreatePerson(sysConsoleUsers.getId());
                            dmiCompanyInfoMapper.insertGetId(dmiCompanyInfo);
                            logger.info("创建公司成功");

                            String password = "123456";

                            SysCompanyUsers sysCompanyUsers = new SysCompanyUsers();
                            sysCompanyUsers.setPassword("123456");
                            sysCompanyUsers.setUsername(username);
                            sysCompanyUsers.setPassword(MD5Utils.MD5Encode(password,"utf-8"));
                            sysCompanyUsers.setNickname("超级管理员");
                            sysCompanyUsers.setFlagDeleted(false);
                            sysCompanyUsers.setFlagAvailable(true);
                            sysCompanyUsers.setCompanyId(dmiCompanyInfo.getId());
                            sysCompanyUsersMapper.insertSelective(sysCompanyUsers);
                            logger.info("账号初始化成功");
                            return ResultUtil.success("创建公司成功,初始用户名:"+username+",密码:"+password);
                        }
                    }

                }
                    return ResultUtil.errorBusinessMsg("公司已存在");


            }

        }else {
            return ResultUtil.validateError("");
        }
    }


    /**
     * 赋予公司版本
     * @param sysCompanyPurchaseVersion
     * @return
     */
    @Transactional(readOnly = false,rollbackFor = Exception.class)
    public Result updateCompanyPermission(SysCompanyPurchaseVersion sysCompanyPurchaseVersion){
        sysCompanyPurchaseVersionMapper.updateByPrimaryKeySelective(sysCompanyPurchaseVersion);
        logger.info("更新redis中角色权限");
        String jsonStr = JsonUtils.getListToJson(sysCompanyPermissionMapper.selectRedisApiAll());
        RedisUtil.set("sys_company_api_all",jsonStr);
        return ResultUtil.success();
    }

}
