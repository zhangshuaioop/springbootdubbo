package com.lxg.springboot.service.sysuser;

import com.lxg.springboot.base.BaseService;
import com.lxg.springboot.entity.sysuser.SysUsers;
import com.lxg.springboot.mapper.sysuser.SysUsersMapper;
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
public class SysUsersService extends BaseService<SysUsersMapper,SysUsers> {

    private final Logger logger = Logger.getLogger(getClass());

    @Autowired
    private SysUsersMapper sysUsersMapper;

    public SysUsers findUserName(String username){
        return sysUsersMapper.selectByUserName(username);
    }
}
