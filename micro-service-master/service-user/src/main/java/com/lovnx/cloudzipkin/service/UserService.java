package com.lovnx.cloudzipkin.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.lovnx.commoncomponets.base.BaseService;
import com.lovnx.commoncomponets.entity.user.User;
import com.lovnx.cloudzipkin.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @description: 用户基础服务
 * @author: zhangshuai
 * @create: 2018-10-25 14:59
 */
@Service
@Transactional(readOnly = true, rollbackFor = Exception.class)
public class UserService extends BaseService<UserMapper, User> {

    @Autowired
    private UserMapper userMapper;

    /**
     * 分页查询
     *
     * @param user
     * @return
     */
    public Page<User> findPage(User user) {
        PageHelper.startPage(user.getPageNo(), user.getPageSize());
        return userMapper.findPage(user);
    }

}
