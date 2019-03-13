package com.company.springboot.service.bif;

import com.company.springboot.entity.bif.BifDeviceBrand;
import com.company.springboot.entity.bif.BifDeviceModel;
import com.company.springboot.entity.bif.BifDeviceSeries;
import com.company.springboot.entity.sys.SysCompanyUsers;
import com.company.springboot.mapper.bif.BifDeviceBrandMapper;
import com.company.springboot.mapper.bif.BifDeviceModelMapper;
import com.company.springboot.mapper.bif.BifDeviceSeriesMapper;
import com.company.springboot.utils.CurrentUtil;
import com.company.springboot.utils.PageInfo;
import com.company.springboot.utils.Result;
import com.company.springboot.utils.ResultUtil;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @author zhanghao
 * @Title: BifDeviceBrandService
 * @ProjectName WaterDrop
 * @Description: 设备品牌
 * @date 2018/12/17下午1:39
 */
@Service
public class BifDeviceBrandService {

    @Resource
    private BifDeviceBrandMapper bifDeviceBrandMapper;
    @Resource
    private BifDeviceSeriesMapper bifDeviceSeriesMapper;
    @Resource
    private BifDeviceModelMapper bifDeviceModelMapper;



    public Result getDeviceBrandList(BifDeviceBrand bifDeviceBrand) {
        if(bifDeviceBrand.getPageNum()!=null && bifDeviceBrand.getPageSize()!=null){
            PageHelper.startPage(bifDeviceBrand.getPageNum(), bifDeviceBrand.getPageSize());
            Page<BifDeviceBrand> persons = bifDeviceBrandMapper.selectList(bifDeviceBrand);
            // 需要把Page包装成PageInfo对象才能序列化。该插件也默认实现了一个PageInfo
            PageInfo<BifDeviceBrand> pageInfo = new PageInfo<>(persons);
            return ResultUtil.success(pageInfo);
        }else{
            List<BifDeviceBrand> list = bifDeviceBrandMapper.selectList(bifDeviceBrand);
            return ResultUtil.success(list);
        }

    }

    public Result getDeviceBrand(Integer id) {
        return ResultUtil.success(bifDeviceBrandMapper.selectByPrimaryKey(id));
    }

    public Result handle(BifDeviceBrand bifDeviceBrand) {
        Date now = new Date();
        SysCompanyUsers users = CurrentUtil.getCurrent();
        if(users==null){
            return ResultUtil.JurisdictionError("");
        }
        if (bifDeviceBrand.getId() != null && bifDeviceBrand.getId() != 0) {
            // 执行更新操作
            bifDeviceBrand.setUpdatePerson(users.getId());
            bifDeviceBrand.setUpdateTime(now);
            bifDeviceBrandMapper.updateByPrimaryKeySelective(bifDeviceBrand);
        } else {
            // 执行新增操作
            bifDeviceBrand.setCreatePerson(users.getId());
            bifDeviceBrand.setCreateTime(now);
            bifDeviceBrand.setFlagAvailable(true);
            bifDeviceBrand.setFlagDeleted(false);
            bifDeviceBrand.setUpdatePerson(users.getId());
            bifDeviceBrand.setUpdatePerson(users.getId());
            bifDeviceBrand.setUpdateTime(now);
            bifDeviceBrandMapper.insertSelective(bifDeviceBrand);
        }
        return ResultUtil.success();
    }

    public Result handleInvalid(Integer id) {
        SysCompanyUsers user = CurrentUtil.getCurrent();
        if(user==null){
            return ResultUtil.JurisdictionError("");
        }
        Date now = new Date();
        // 设定失效
        BifDeviceBrand bifDeviceBrand = new BifDeviceBrand();
        bifDeviceBrand.setFlagAvailable(false);
        bifDeviceBrand.setUpdateTime(now);
        bifDeviceBrand.setUpdatePerson(user.getId());
        bifDeviceBrand.setId(id);
        bifDeviceBrandMapper.updateByPrimaryKeySelective(bifDeviceBrand);

        // 失效品牌下所有系列
        List<BifDeviceSeries> seriesList = bifDeviceSeriesMapper.selectList(bifDeviceBrand.getId());
        for (BifDeviceSeries bifDeviceSeries:seriesList) {
            // 设定失效
            bifDeviceSeries.setFlagAvailable(false);
            bifDeviceSeries.setUpdateTime(now);
            bifDeviceSeries.setUpdatePerson(user.getId());
            bifDeviceSeriesMapper.updateByPrimaryKeySelective(bifDeviceSeries);
            // 失效系列下所有型号
            BifDeviceModel model = new BifDeviceModel();
            model.setSeriesId(bifDeviceSeries.getId());
            model.setUpdatePerson(user.getId());
            model.setUpdateTime(now);
            model.setFlagAvailable(false);
            bifDeviceModelMapper.invalidBySeries(model);
        }
        return ResultUtil.success();
    }

    public Result handleDelete(Integer id) {
        if(id==null||id==0){
            return ResultUtil.validateError("参数错误");
        }
        SysCompanyUsers user = CurrentUtil.getCurrent();
        if(user==null){
            return ResultUtil.JurisdictionError("");
        }
        // 设定失效
        BifDeviceBrand bifDeviceBrand = new BifDeviceBrand();
        bifDeviceBrand.setFlagDeleted(true);
        bifDeviceBrand.setUpdateTime(new Date());
        bifDeviceBrand.setUpdatePerson(user.getId());
        bifDeviceBrand.setId(id);
        bifDeviceBrandMapper.updateByPrimaryKeySelective(bifDeviceBrand);
        return ResultUtil.success();
    }
}
