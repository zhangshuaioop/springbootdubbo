package com.example.identification.service.sys;

import com.example.identification.base.BaseService;
import com.example.identification.entity.sys.SysUsersAccount;
import com.example.identification.mapper.sys.SysUsersAccountMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @description: 平台用户账号表
 * @author: zhangshuai
 * @create: 2019-08-30 13:21
 */
@Service
public class SysUsersAccountService extends BaseService<SysUsersAccountMapper,SysUsersAccount> {

    @Autowired
    private SysUsersAccountMapper sysUsersAccountMapper;

    /**
     * 根据用户名获取用户信息
     * @param sysUsersAccount
     * @return
     */
    public SysUsersAccount findByUserName(SysUsersAccount sysUsersAccount){
        return sysUsersAccountMapper.selectByUserName(sysUsersAccount);
    }
}
