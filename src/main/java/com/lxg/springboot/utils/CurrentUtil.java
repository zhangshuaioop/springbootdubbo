package com.lxg.springboot.utils;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * @description: 用户信息
 * @author: zhangshuai
 * @create: 2018-12-12 21:58
 */
public class CurrentUtil {

    public static Authentication getCurrentUsername() {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        if (!(authentication instanceof AnonymousAuthenticationToken)) {
//            String currentUserName = authentication.getName();
//            return currentUserName;
//        }
        return authentication;

    }
}
