package com.platform.springboot.service;

import com.platform.springboot.entity.syscompany.JwtUser;
import com.platform.springboot.entity.sysconsole.SysConsolePermission;
import com.platform.springboot.entity.sysconsole.SysConsoleUsers;
import com.platform.springboot.service.sysconsole.SysConsolePermissionService;
import com.platform.springboot.service.sysconsole.SysConsoleUsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;

/**
 * Created by echisan on 2018/6/23
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private SysConsoleUsersService sysConsoleUsersService;

    @Autowired
    private SysConsolePermissionService sysConsolePermissionService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        SysConsoleUsers sysConsoleUsers = sysConsoleUsersService.findUserName(username);

        if(sysConsoleUsers == null){
            throw new UsernameNotFoundException("用户名："+ username + "不存在！");
        }
        Collection<SimpleGrantedAuthority> collection = new HashSet<SimpleGrantedAuthority>();

        //查询平台个人权限
        List<SysConsolePermission> sysConsolePermissions = sysConsolePermissionService.findPermission(sysConsoleUsers.getId());

        for (SysConsolePermission sysConsolePermission: sysConsolePermissions) {
            collection.add(new SimpleGrantedAuthority(sysConsolePermission.getName()));
        }
        sysConsoleUsers.setAuthorities(collection);
        return new JwtUser(sysConsoleUsers);
    }

}
