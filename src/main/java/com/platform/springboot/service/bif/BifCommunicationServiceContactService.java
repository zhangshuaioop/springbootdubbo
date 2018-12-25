package com.platform.springboot.service.bif;

import com.platform.springboot.entity.bif.BifCommunicationServiceContact;
import com.platform.springboot.mapper.bif.BifCommunicationServiceContactMapper;
import com.platform.springboot.utils.Result;
import com.platform.springboot.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @description:
 * @author: zhangshuai
 * @create: 2018-12-17 15:37
 */
@Service
public class BifCommunicationServiceContactService {

    @Autowired
    private BifCommunicationServiceContactMapper bifCommunicationServiceContactMapper;

    public BifCommunicationServiceContact showByService(int serviceId, String contactName) {
        BifCommunicationServiceContact record = new BifCommunicationServiceContact();
        record.setServiceId(serviceId);
        record.setContactName(contactName);
        return bifCommunicationServiceContactMapper.showByService(record);
    }

    public int insert(BifCommunicationServiceContact record, int userId) {
        Date now = new Date();
        record.setFlagAvailable(true);
        record.setFlagDeleted(false);
        record.setCreatePerson(userId);
        record.setCreateTime(now);
        record.setUpdatePerson(userId);
        record.setUpdateTime(now);
        bifCommunicationServiceContactMapper.insertSelective(record);
        return record.getId();
    }

    public Result update(BifCommunicationServiceContact record, int userId) {
        record.setUpdatePerson(userId);
        record.setUpdateTime(new Date());
        bifCommunicationServiceContactMapper.updateByPrimaryKeySelective(record);
        return ResultUtil.successMsg("更新成功");
    }
}
