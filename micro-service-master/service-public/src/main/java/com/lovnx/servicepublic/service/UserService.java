package com.lovnx.servicepublic.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.lovnx.commoncomponets.entity.user.User;
import com.lovnx.commoncomponets.utils.Result;
import com.lovnx.commoncomponets.utils.ResultUtil;
import com.lovnx.servicepublic.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @description: 用户基础服务
 * @author: zhangshuai
 * @create: 2018-10-25 14:59
 */
@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;
    /**
     * 查询用户信息
     * @param id
     * @return
     */
    public Result findById(Integer id) {
        return ResultUtil.success("hhhhhhhhhhhh");
    }

    /**
     * 查询用户信息
     * @param id
     * @return
     */
    public User findById(Long id){
        User users = userMapper.selectByPrimaryKey(id);
        return users;
    }

    /**
     * 分页查询
     * @param user
     * @return
     */
    public Page<User> findByPage(User user) {
        PageHelper.startPage(user.getPageNo(), user.getPageSize());
        return userMapper.findByPage();
    }

}
