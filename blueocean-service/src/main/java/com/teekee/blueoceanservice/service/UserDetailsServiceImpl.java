package com.teekee.blueoceanservice.service;

import com.teekee.blueoceanservice.entity.syscompany.JwtUser;
import com.teekee.blueoceanservice.entity.sysconsole.SysConsolePermission;
import com.teekee.blueoceanservice.entity.sysconsole.SysConsoleUsers;
import com.teekee.blueoceanservice.entity.sysconsole.response.SysConsolePermissionRes;
import com.teekee.blueoceanservice.service.sysconsole.SysConsolePermissionService;
import com.teekee.blueoceanservice.service.sysconsole.SysConsoleUsersService;
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

        SysConsolePermission sysConsolePermission = new SysConsolePermission();
        sysConsolePermission.setUserId(sysConsoleUsers.getId());
        //查询平台个人权限
        List<SysConsolePermissionRes> sysConsolePermissions = sysConsolePermissionService.findPermission(sysConsolePermission);

        for (SysConsolePermissionRes syspermission: sysConsolePermissions) {
            collection.add(new SimpleGrantedAuthority(syspermission.getMeta().getTitle()));
        }
        sysConsoleUsers.setAuthorities(collection);
        return new JwtUser(sysConsoleUsers);
    }

}
