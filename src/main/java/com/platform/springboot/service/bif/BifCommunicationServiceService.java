package com.platform.springboot.service.bif;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.platform.springboot.base.BaseService;
import com.platform.springboot.entity.bif.BifCommunicationService;
import com.platform.springboot.entity.sys.SysCompanyUsers;
import com.platform.springboot.mapper.bif.BifCommunicationServiceMapper;
import com.platform.springboot.utils.CurrentUtil;
import com.platform.springboot.utils.PageInfo;
import com.platform.springboot.utils.Result;
import com.platform.springboot.utils.ResultUtil;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @Author Chenliwen
 * @Date 2018/12/17 15:54
 **/
@Service
public class BifCommunicationServiceService{

    private Logger log = Logger.getLogger(BifCommunicationServiceService.class);
    @Resource
    private BifCommunicationServiceMapper bifCommunicationServiceMapper;

//    public Result getCommunicationServiceList() {
//        List<BifCommunicationService> sqlResult = bifCommunicationServiceMapper.selectList();
//        return ResultUtil.success(sqlResult == null ? new ArrayList<BifCommunicationService>() : sqlResult);
//    }

    public Result getCommunicationServiceListCustomize(BifCommunicationService bifCommunicationService) {
        PageHelper.startPage(bifCommunicationService.getPageNum(), bifCommunicationService.getPageSize());
        Page<BifCommunicationService> persons = bifCommunicationServiceMapper.selectListCustomize(bifCommunicationService);
        // 需要把Page包装成PageInfo对象才能序列化。该插件也默认实现了一个PageInfo
        PageInfo<BifCommunicationService> pageInfo = new PageInfo<>(persons);
        return ResultUtil.success(pageInfo);
    }

    public Result getCommunicationService(int id) {
        log.info("id:" + id);
        BifCommunicationService sqlResult = bifCommunicationServiceMapper.selectByPrimaryKey(id);
        return ResultUtil.success(sqlResult == null ? new BifCommunicationService() : sqlResult);
    }

    public Result handle(BifCommunicationService bifCommunicationService) {

        SysCompanyUsers user = CurrentUtil.getCurrent();
        if(user==null){
            return ResultUtil.JurisdictionError("");
        }
        Date now = new Date();

        if (bifCommunicationService.getServiceName() == null) {
            return ResultUtil.validateError("服务商名不能为空");
        } else {
            if (bifCommunicationService.getId() != null && bifCommunicationService.getId() > 0) {
                // 执行更新操作
                bifCommunicationService.setUpdatePerson(user.getId());
                bifCommunicationService.setUpdateTime(now);

                updateCommunicationService(bifCommunicationService);

                return ResultUtil.successMsg("更新成功");
            } else {
                // 执行新增操作
                bifCommunicationService.setCreatePerson(user.getId());
                bifCommunicationService.setCreateTime(now);
                bifCommunicationService.setFlagAvailable(true);
                bifCommunicationService.setFlagDeleted(false);
                bifCommunicationService.setUpdatePerson(user.getId());
                bifCommunicationService.setUpdateTime(now);

                insertCommunicationService(bifCommunicationService);

                return ResultUtil.successMsg("新增成功");
            }
        }
    }

    private boolean insertCommunicationService(BifCommunicationService bifCommunicationService) {
        int effectRows = bifCommunicationServiceMapper.insertSelective(bifCommunicationService);

        if (effectRows > 0) {
            return true;
        } else {
            return false;
        }
    }

    private boolean updateCommunicationService(BifCommunicationService bifCommunicationService) {
        int effectRows = bifCommunicationServiceMapper.updateByPrimaryKeySelective(bifCommunicationService);

        if (effectRows > 0) {
            return true;
        } else {
            return false;
        }
    }

    public Result handleInvalid(BifCommunicationService bifCommunicationService) {

        SysCompanyUsers user = CurrentUtil.getCurrent();
        if(user==null){
            return ResultUtil.JurisdictionError("");
        }
        // 设定失效
        bifCommunicationService.setFlagAvailable(false);
        bifCommunicationService.setUpdateTime(new Date());
        bifCommunicationService.setUpdatePerson(user.getId());

        updateCommunicationService(bifCommunicationService);

        return ResultUtil.successMsg("通信服务商失效成功");
    }

    public Result handleDelete(BifCommunicationService bifCommunicationService) {

        SysCompanyUsers user = CurrentUtil.getCurrent();
        if(user==null){
            return ResultUtil.JurisdictionError("");
        }
        // 设定删除
        bifCommunicationService.setFlagDeleted(true);
        bifCommunicationService.setUpdateTime(new Date());
        bifCommunicationService.setUpdatePerson(user.getId());

        updateCommunicationService(bifCommunicationService);

        return ResultUtil.successMsg("通信服务商删除成功");
    }
}
