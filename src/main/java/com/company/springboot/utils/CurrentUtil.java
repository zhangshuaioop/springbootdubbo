package com.company.springboot.utils;

import com.company.springboot.entity.sys.SysCompanyUsers;
import com.company.springboot.mapper.sys.SysCompanyRelationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Collection;
import java.util.HashSet;

/**
 * @description: 用户信息
 * @author: zhangshuai
 * @create: 2018-12-12 21:58
 */
@Component
public class CurrentUtil {


    @Autowired
    private SysCompanyRelationMapper sysCompanyRelationMapper;
    private static CurrentUtil currentUtilService;

    public CurrentUtil(){
        super();
    }


    /* 被@PostConstruct修饰的方法会在服务器加载Servlet的时候运行，并且只会被服务器调用一次，
	类似于Servlet的inti()方法。被@PostConstruct修饰的方法会在构造函数之后，init()方法之前运行。*/
    @PostConstruct
    public void init() {
        System.out.println("实例化成功");
        currentUtilService = this;
        currentUtilService.sysCompanyRelationMapper = this.sysCompanyRelationMapper;
    }

    /**
     * 关联公司及本公司
     * @param userId
     * @return
     */
    public static String getCompanyIds(Integer userId) {
        return currentUtilService.sysCompanyRelationMapper.selectCompanyIds(userId);
    }

    /**
     * 登陆用户信息
     * @return
     */
    public static SysCompanyUsers getCurrent() {
        SysCompanyUsers sysCompanyUsers = null;
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            sysCompanyUsers = (SysCompanyUsers) authentication.getCredentials();
        }
        return sysCompanyUsers;
    }


    /**
     * 权限
     * @return
     */
    public static Collection<? extends GrantedAuthority> getCurrentRole() {
        Collection<SimpleGrantedAuthority> collection = new HashSet<SimpleGrantedAuthority>();
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            collection = (Collection<SimpleGrantedAuthority>) authentication.getAuthorities();
        }
        return collection;
    }
}
