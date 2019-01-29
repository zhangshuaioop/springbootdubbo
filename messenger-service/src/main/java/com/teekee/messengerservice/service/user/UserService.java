package com.teekee.messengerservice.service.user;

import com.teekee.commoncomponets.base.BaseService;
import com.teekee.messengerservice.entity.publicss.User;
import com.teekee.messengerservice.mapper.user.UserMapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @description: 数据库连接测试
 * @author: zhangshuai
 * @create: 2018-11-22 16:41
 */
@Service
@Transactional(readOnly = true, rollbackFor = Exception.class)
public class UserService extends BaseService<UserMapper,User> {

    private final Logger logger = Logger.getLogger(getClass());

    @Autowired
    private UserMapper userMapper;

    /**
     * 分页查询
     *
     * @param user
     * @return
     */
    public Page<User> findPage(User user) {
        PageHelper.startPage(user.getPageNum(), user.getPageSize());
        return userMapper.findPage(user);
    }

}
