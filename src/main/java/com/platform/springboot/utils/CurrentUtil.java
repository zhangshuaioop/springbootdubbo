package com.platform.springboot.utils;

import com.platform.springboot.entity.sys.SysCompanyUsers;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.HashSet;

/**
 * @description: 用户信息
 * @author: zhangshuai
 * @create: 2018-12-12 21:58
 */
@Component
public class CurrentUtil {


    public static SysCompanyUsers getCurrent() {
        SysCompanyUsers sysCompanyUsers = null;
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            sysCompanyUsers = (SysCompanyUsers) authentication.getCredentials();
        }
        return sysCompanyUsers;
}


    public static Collection<? extends GrantedAuthority> getCurrentRole() {

        Collection<SimpleGrantedAuthority> collection = new HashSet<SimpleGrantedAuthority>();
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            collection = (Collection<SimpleGrantedAuthority>) authentication.getAuthorities();
        }
        return collection;
    }
}