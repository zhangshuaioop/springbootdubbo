package com.company.springboot.service.bif;

import com.company.springboot.entity.bif.BifDeviceModel;
import com.company.springboot.entity.sys.SysCompanyUsers;
import com.company.springboot.mapper.bif.BifDeviceModelMapper;
import com.company.springboot.utils.CurrentUtil;
import com.company.springboot.utils.PageInfo;
import com.company.springboot.utils.Result;
import com.company.springboot.utils.ResultUtil;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.company.springboot.entity.bif.BifDeviceBrand;
import com.company.springboot.entity.bif.BifDeviceModel;
import com.company.springboot.entity.sys.SysCompanyUsers;
import com.company.springboot.mapper.bif.BifDeviceModelMapper;
import com.company.springboot.utils.CurrentUtil;
import com.company.springboot.utils.PageInfo;
import com.company.springboot.utils.Result;
import com.company.springboot.utils.ResultUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @author zhanghao
 * @Title: BifDeviceModelService
 * @ProjectName WaterDrop
 * @Description: 设备品牌型号
 * @date 2018/12/17下午3:16
 */
@Service
public class BifDeviceModelService {
    @Resource
    private BifDeviceModelMapper bifDeviceModelMapper;

    public Result getDeviceModelList(BifDeviceModel bifDeviceModel) {
        if(bifDeviceModel.getPageNum()!=null && bifDeviceModel.getPageSize()!=null){
            PageHelper.startPage(bifDeviceModel.getPageNum(), bifDeviceModel.getPageSize());
            Page<BifDeviceModel> persons = bifDeviceModelMapper.selectList(bifDeviceModel.getSeriesId());
            // 需要把Page包装成PageInfo对象才能序列化。该插件也默认实现了一个PageInfo
            PageInfo<BifDeviceModel> pageInfo = new PageInfo<>(persons);
            return ResultUtil.success(pageInfo);
        }else{
            List<BifDeviceModel> list = bifDeviceModelMapper.selectList(bifDeviceModel.getSeriesId());
            return ResultUtil.success(list);
        }

    }

    public Result getDeviceModel(Integer id) {
        if(id==null||id==0){
            return ResultUtil.validateError("参数错误");
        }
        return ResultUtil.success(bifDeviceModelMapper.selectByPrimaryKey(id));
    }

    public Result handle(BifDeviceModel bifDeviceModel) {
        SysCompanyUsers users = CurrentUtil.getCurrent();
        if(users==null){
            return ResultUtil.JurisdictionError("");
        }
        Date now = new Date();
        if (bifDeviceModel.getId() != null && bifDeviceModel.getId() != 0) {
            // 执行更新操作
            bifDeviceModel.setUpdatePerson(users.getId());
            bifDeviceModel.setUpdateTime(now);
            bifDeviceModelMapper.updateByPrimaryKeySelective(bifDeviceModel);
        } else {
            // 执行新增操作
            bifDeviceModel.setCreatePerson(users.getId());
            bifDeviceModel.setCreateTime(now);
            bifDeviceModel.setFlagAvailable(true);
            bifDeviceModel.setFlagDeleted(false);
            bifDeviceModel.setUpdatePerson(users.getId());
            bifDeviceModel.setUpdateTime(now);
            bifDeviceModelMapper.insertSelective(bifDeviceModel);
        }
        return ResultUtil.success();
    }

    public Result handleInvalid(Integer id) {
        if(id ==null|| id==0){
            return ResultUtil.validateError("参数错误");
        }
        // 设定失效
        BifDeviceModel bifDeviceModel = new BifDeviceModel();
        bifDeviceModel.setFlagAvailable(false);
        bifDeviceModel.setUpdateTime(new Date());
        bifDeviceModel.setUpdatePerson(CurrentUtil.getCurrent().getId());
        bifDeviceModel.setId(id);
        bifDeviceModelMapper.invalidBySeries(bifDeviceModel);
        return ResultUtil.success();
    }

    public Result handleDelete(Integer id) {
        if(id ==null|| id==0){
            return ResultUtil.validateError("参数错误");
        }
        // 设定失效
        BifDeviceModel bifDeviceModel = new BifDeviceModel();
        bifDeviceModel.setFlagDeleted(true);
        bifDeviceModel.setUpdateTime(new Date());
        bifDeviceModel.setUpdatePerson(CurrentUtil.getCurrent().getId());
        bifDeviceModel.setId(id);
        bifDeviceModelMapper.updateByPrimaryKeySelective(bifDeviceModel);
        return ResultUtil.success();
    }
}
