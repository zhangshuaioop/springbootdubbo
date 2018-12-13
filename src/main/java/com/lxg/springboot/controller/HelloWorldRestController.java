package com.lxg.springboot.controller;

import java.util.List;

import com.lxg.springboot.entity.sysuser.SysUsers;
import com.lxg.springboot.service.sysuser.SysUsersService;
import com.lxg.springboot.utils.CurrentUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class HelloWorldRestController {

    @Autowired
    private SysUsersService sysUsersService;


    @PreAuthorize("hasRole('admin')")
    @RequestMapping(value = "/findAll", method = RequestMethod.GET)
    public List<SysUsers> listAllUsers() {
        Authentication a = CurrentUtil.getCurrentUsername();
        SysUsers sysUsers = new SysUsers();
        List<SysUsers> users = sysUsersService.findAll(sysUsers);
        if(users.isEmpty()){
            return null;
        }
        return users;
    }
}