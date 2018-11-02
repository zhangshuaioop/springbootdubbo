package com.example.timemachine.service;

import com.example.timemachine.base.BaseService;
import com.example.timemachine.entity.BifDevice;
import com.example.timemachine.mapper.BifDeviceMapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @description: 设备基本信息服务
 * @author: zhangshuai
 * @create: 2018-10-25 14:59
 */
@Service
@Transactional(readOnly = true, rollbackFor = Exception.class)
public class BifDeviceService extends BaseService<BifDeviceMapper, BifDevice> {

    @Autowired
    private BifDeviceMapper bifDeviceMapper;

    /**
     * 分页查询
     *
     * @param user
     * @return
     */
    public Page<BifDevice> findPage(BifDevice user) {
        PageHelper.startPage(user.getPageNo(), user.getPageSize());
        return bifDeviceMapper.findPage(user);
    }

}
