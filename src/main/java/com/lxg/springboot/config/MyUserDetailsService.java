package com.lxg.springboot.config;

import com.lxg.springboot.entity.sysuser.SysCompanyUserRoleRelation;
import com.lxg.springboot.entity.sysuser.SysUsers;
import com.lxg.springboot.service.sysuser.SysCompanyRolePermissionService;
import com.lxg.springboot.service.sysuser.SysCompanyUserRoleRelationService;
import com.lxg.springboot.service.sysuser.SysUsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;

/**
 * Created by lxg
 * on 2017/2/20.
 */
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private SysUsersService sysUsersService;


    @Autowired
    private SysCompanyUserRoleRelationService sysCompanyUserRoleRelationService;

    @Autowired
    private SysCompanyRolePermissionService sysCompanyRolePermissionService;



    /**
     * 根据用户名获取登录用户信息
     * @param username
     * @return
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        SysUsers sysUsers = sysUsersService.findUserName(username);

        if(sysUsers == null){
             throw new UsernameNotFoundException("用户名："+ username + "不存在！");
        }
        Collection<SimpleGrantedAuthority> collection = new HashSet<SimpleGrantedAuthority>();
        SysCompanyUserRoleRelation sysCompanyUserRoleRelation = new SysCompanyUserRoleRelation();
        sysCompanyUserRoleRelation.setCompanyId(sysUsers.getCompanyId());
        sysCompanyUserRoleRelation.setUserId(sysUsers.getId());
        List<SysCompanyUserRoleRelation> roleList = sysCompanyUserRoleRelationService.findAll(sysCompanyUserRoleRelation);

        for (SysCompanyUserRoleRelation role: roleList) {
            collection.add(new SimpleGrantedAuthority(role.getRoleName()));
        }

        UserDetails us = new org.springframework.security.core.userdetails.User(username,sysUsers.getPassword(),collection);
        return us;
    }
}
