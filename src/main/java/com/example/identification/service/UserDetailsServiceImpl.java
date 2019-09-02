package com.example.identification.service;

import com.example.identification.entity.JwtUser;
import com.example.identification.entity.sys.SysUsersAccount;
import com.example.identification.service.sys.SysUsersAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;


/**
 * Created by zhangshuai on 2019/1/31
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private SysUsersAccountService sysUsersAccountService;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        SysUsersAccount sysUsersAccount = new SysUsersAccount();
        sysUsersAccount.setAccount(username);
        sysUsersAccount.setFlagAvailable(true);
        sysUsersAccount.setFlagDeleted(false);
        SysUsersAccount sysUsersAccount1 = sysUsersAccountService.findByUserName(sysUsersAccount);

        if(sysUsersAccount1 == null){
            throw new UsernameNotFoundException("用户名："+ username + "不存在！");
        }

        return new JwtUser(sysUsersAccount1);
    }

}
