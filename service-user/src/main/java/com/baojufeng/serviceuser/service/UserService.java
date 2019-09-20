package com.baojufeng.serviceuser.service;

import com.baojufeng.commoncomponets.base.BaseService;
import com.baojufeng.commoncomponets.client.messenger.MessengerMicroService;
import com.baojufeng.commoncomponets.entity.message.trc.TrcEmailLog;
import com.baojufeng.commoncomponets.entity.user.User;
import com.baojufeng.commoncomponets.utils.PageInfo;
import com.baojufeng.commoncomponets.utils.Result;
import com.baojufeng.commoncomponets.utils.ResultUtil;
import com.baojufeng.serviceuser.mapper.UserMapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

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

    @Autowired
    private MessengerMicroService messengerMicroService;

    /**
     * 分页查询
     *
     * @param user
     * @return
     */
    public Result findPage(User user) {

//        TrcEmailLog trcEmailLog = new TrcEmailLog();
//        trcEmailLog.setMessageId(UUID.randomUUID().toString());
//        trcEmailLog.setEmails("1301505228@qq.com");
//        trcEmailLog.setBusinessType("KEFU");
//
//        Result messengerRes = messengerMicroService.sendEmail(trcEmailLog);

//        if(messengerRes.getCode() != 200){
//            return messengerRes;
//        }
        PageHelper.startPage(user.getPageNo(), user.getPageSize());
        Page<User> persons = userMapper.findPage(user);
        // 需要把Page包装成PageInfo对象才能序列化。该插件也默认实现了一个PageInfo
        PageInfo<User> pageInfo = new PageInfo<>(persons);

        return ResultUtil.success(pageInfo);
    }

}
