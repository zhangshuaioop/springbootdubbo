package com.lxg.springboot.service.sysuser;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.lxg.springboot.base.BaseService;
import com.lxg.springboot.entity.sysuser.SysUsers;
import com.lxg.springboot.mapper.sysuser.SysUsersMapper;
import com.lxg.springboot.utils.PageInfo;
import com.lxg.springboot.utils.Result;
import com.lxg.springboot.utils.ResultUtil;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

/**
 * @description: 公司用户账号
 * @author: zhangshuai
 * @create: 2018-12-12 09:20
 */
@Service
@Transactional(readOnly = true, rollbackFor = Exception.class)
public class SysUsersService extends BaseService<SysUsersMapper,SysUsers> {

    private final Logger logger = Logger.getLogger(getClass());

    @Autowired
    private SysUsersMapper sysUsersMapper;

    public SysUsers findUserName(String username){
        return sysUsersMapper.selectByUserName(username);
    }



    /**
     * 分页查询
     *
     * @param sysUsers
     * @return
     */
    public Result findPage(SysUsers sysUsers) {

        PageHelper.startPage(sysUsers.getPageNo(), sysUsers.getPageSize());
        Page<SysUsers> persons = sysUsersMapper.findPage(sysUsers);
        // 需要把Page包装成PageInfo对象才能序列化。该插件也默认实现了一个PageInfo
        PageInfo<SysUsers> pageInfo = new PageInfo<>(persons);

        return ResultUtil.success(pageInfo);
    }

}
