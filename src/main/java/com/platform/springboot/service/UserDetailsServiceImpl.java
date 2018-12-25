package com.platform.springboot.service;

import com.platform.springboot.entity.sys.JwtUser;
import com.platform.springboot.entity.sys.SysCompanyPermission;
import com.platform.springboot.entity.sys.SysCompanyUsers;
import com.platform.springboot.entity.sys.response.SysCompanyPermissionRes;
import com.platform.springboot.service.sys.SysCompanyPermissionService;
import com.platform.springboot.service.sys.SysCompanyUsersService;
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
    private SysCompanyUsersService sysCompanyUsersService;

    @Autowired
    private SysCompanyPermissionService sysCompanyPermissionService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        SysCompanyUsers sysCompanyUsers = sysCompanyUsersService.findUserName(username);

        if(sysCompanyUsers == null){
            throw new UsernameNotFoundException("用户名："+ username + "不存在！");
        }
        Collection<SimpleGrantedAuthority> collection = new HashSet<SimpleGrantedAuthority>();
        SysCompanyPermission sysCompanyPermission = new SysCompanyPermission();
        sysCompanyPermission.setCompanyId(sysCompanyUsers.getCompanyId());
        sysCompanyPermission.setUserId(sysCompanyUsers.getId());
        List<SysCompanyPermissionRes> permissions = sysCompanyPermissionService.findPermission(sysCompanyPermission);

//        SysCompanyUserRoleRelation sysCompanyUserRoleRelation = new SysCompanyUserRoleRelation();
//        sysCompanyUserRoleRelation.setCompanyId(sysCompanyUsers.getCompanyId());
//        sysCompanyUserRoleRelation.setUserId(sysCompanyUsers.getId());
//        List<SysCompanyUserRoleRelation> roleList = sysCompanyUserRoleRelationService.findRole(sysCompanyUserRoleRelation);

        for (SysCompanyPermissionRes permission: permissions) {
            collection.add(new SimpleGrantedAuthority(permission.getName()));
        }
        sysCompanyUsers.setAuthorities(collection);
        return new JwtUser(sysCompanyUsers);
    }

}
