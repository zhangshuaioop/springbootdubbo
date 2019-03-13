package com.company.springboot.service.bif;

import com.company.springboot.entity.bif.BifCommunicationServiceContact;
import com.company.springboot.entity.dto.common.HandleInvalidDeleteDTO;
import com.company.springboot.mapper.bif.BifCommunicationServiceContactMapper;
import com.company.springboot.utils.CurrentUtil;
import com.company.springboot.utils.PageInfo;
import com.company.springboot.utils.Result;
import com.company.springboot.utils.ResultUtil;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

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

    public Result list(BifCommunicationServiceContact contact) {
        if(contact.getPageNum()!=null&& contact.getPageSize()!=null){
            PageHelper.startPage(contact.getPageNum(), contact.getPageSize());
            Page<BifCommunicationServiceContact> persons = bifCommunicationServiceContactMapper.list(contact);
            // 需要把Page包装成PageInfo对象才能序列化。该插件也默认实现了一个PageInfo
            PageInfo<BifCommunicationServiceContact> pageInfo = new PageInfo<>(persons);
            if(pageInfo.getList()==null||pageInfo.getList().size()==0){
                pageInfo.setPageNum(1);
                pageInfo.setPageSize(10);
            }
            return ResultUtil.success(pageInfo);
        }else{
            List<BifCommunicationServiceContact> persons = bifCommunicationServiceContactMapper.list(contact);
            return ResultUtil.success(persons);
        }
    }

    public Result listByServiceId(BifCommunicationServiceContact contact) {
        if(contact.getPageNum()!=null&& contact.getPageSize()!=null){
            PageHelper.startPage(contact.getPageNum(), contact.getPageSize());
            Page<BifCommunicationServiceContact> persons = bifCommunicationServiceContactMapper.listByServiceId(contact);
            // 需要把Page包装成PageInfo对象才能序列化。该插件也默认实现了一个PageInfo
            PageInfo<BifCommunicationServiceContact> pageInfo = new PageInfo<>(persons);
            if(pageInfo.getList()==null||pageInfo.getList().size()==0){
                pageInfo.setPageNum(1);
                pageInfo.setPageSize(10);
            }
            return ResultUtil.success(pageInfo);
        }else{
            List<BifCommunicationServiceContact> persons = bifCommunicationServiceContactMapper.listByServiceId(contact);
            return ResultUtil.success(persons);
        }
    }

    public Result handle(BifCommunicationServiceContact contact) {
        if(contact.getServiceId()==null||contact.getServiceId()==0){
            return ResultUtil.validateError("服务商ID不可空");
        }
        Integer userId =CurrentUtil.getCurrent().getId();
        if (contact.getId() == null || contact.getId() == 0) {
            insert(contact, userId);
            return ResultUtil.success();
        } else {
            return update(contact, userId);
        }
    }

    public Result handleInvalidDelete(HandleInvalidDeleteDTO dto) {
        Integer userId =CurrentUtil.getCurrent().getId();
        if (dto.isFlagDelete()) {
            return delete(dto.getId(), userId);
        } else {
            return invalid(dto.getId(), userId);
        }
    }

    public Result invalid(int id, int userId) {
        BifCommunicationServiceContact contact = new BifCommunicationServiceContact();
        contact.setUpdateTime(new Date());
        contact.setUpdatePerson(userId);
        contact.setFlagAvailable(false);
        contact.setId(id);
        bifCommunicationServiceContactMapper.updateByPrimaryKeySelective(contact);
        return ResultUtil.success();
    }

    public Result delete(int id, int userId) {
        BifCommunicationServiceContact contact = new BifCommunicationServiceContact();
        contact.setUpdateTime(new Date());
        contact.setUpdatePerson(userId);
        contact.setFlagDeleted(true);
        contact.setId(id);
        bifCommunicationServiceContactMapper.updateByPrimaryKeySelective(contact);
        return ResultUtil.success();
    }

    public Result show(Integer id) {
        return ResultUtil.success(bifCommunicationServiceContactMapper.selectByPrimaryKey(id));
    }
}
