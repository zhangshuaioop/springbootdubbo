package com.teekee.blueoceanservice.service.syscompany;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.teekee.commoncomponets.base.BaseService;
import com.teekee.blueoceanservice.entity.syscompany.SysCompanyUsers;
import com.teekee.blueoceanservice.mapper.syscompany.SysCompanyPermissionMapper;
import com.teekee.blueoceanservice.mapper.syscompany.SysCompanyUsersMapper;
import com.teekee.blueoceanservice.utils.*;
import com.teekee.commoncomponets.utils.MD5Utils;
import com.teekee.commoncomponets.utils.PageInfo;
import com.teekee.commoncomponets.utils.Result;
import com.teekee.commoncomponets.utils.ResultUtil;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * @description: 公司用户账号
 * @author: zhangshuai
 * @create: 2018-12-12 09:20
 */
@Service
@Transactional(readOnly = true, rollbackFor = Exception.class)
public class SysCompanyUsersService extends BaseService<SysCompanyUsersMapper,SysCompanyUsers> {

    private final Logger logger = Logger.getLogger(getClass());

    @Autowired
    private SysCompanyUsersMapper sysCompanyUsersMapper;

    @Autowired
    private SysCompanyPermissionMapper sysCompanyPermissionMapper;




    /**
     * 平台查看公司用户-分页列表
     *
     * @param sysCompanyUsers
     * @return
     */
    public Result findPage(SysCompanyUsers sysCompanyUsers) {

        PageHelper.startPage(sysCompanyUsers.getPageNum(), sysCompanyUsers.getPageSize());
        Page<SysCompanyUsers> persons = sysCompanyUsersMapper.findPageConsole(sysCompanyUsers);
        // 需要把Page包装成PageInfo对象才能序列化。该插件也默认实现了一个PageInfo
        PageInfo<SysCompanyUsers> pageInfo = new PageInfo<>(persons);

        return ResultUtil.success(pageInfo);
    }

    /**
     * 重置密码
     * @param userId
     * @return
     */
    @Transactional(readOnly = false,rollbackFor = Exception.class)
    public Result resetPassword(Integer userId) {

        if(userId != null){
            SysCompanyUsers sysCompanyUsers1 = new SysCompanyUsers();
            sysCompanyUsers1.setId(userId);
            sysCompanyUsers1.setPassword(MD5Utils.MD5Encode("123456","utf-8"));
            sysCompanyUsersMapper.updateByPrimaryKeySelective(sysCompanyUsers1);
        }else {
            return ResultUtil.validateError("");
        }
        return ResultUtil.success();
    }


}
