package com.lovnx.serviceuser.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.lovnx.commoncomponets.utils.Result;
import com.lovnx.commoncomponets.utils.ResultUtil;
import com.lovnx.serviceuser.entity.User;
import com.lovnx.serviceuser.mapper.UserMapper;
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
     * @param pageNo 页号
     * @param pageSize 每页显示记录数
     * @return
     */
    public Page<User> findByPage(int pageNo, int pageSize) {
        PageHelper.startPage(pageNo, pageSize);
        return userMapper.findByPage();
    }

}
