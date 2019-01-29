package com.teekee.waterdropservice.service.bif;

import com.teekee.commoncomponets.utils.PageInfo;
import com.teekee.waterdropservice.entity.bif.BifDeviceModel;
import com.teekee.waterdropservice.entity.bif.BifDeviceSeries;
import com.teekee.waterdropservice.entity.sys.SysCompanyUsers;
import com.teekee.waterdropservice.mapper.bif.BifDeviceModelMapper;
import com.teekee.waterdropservice.mapper.bif.BifDeviceSeriesMapper;
import com.teekee.waterdropservice.utils.CurrentUtil;
import com.teekee.commoncomponets.utils.Result;
import com.teekee.commoncomponets.utils.ResultUtil;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @author zhanghao
 * @Title: BifDeviceSeriesService
 * @ProjectName WaterDrop
 * @Description: 设备品牌系列
 * @date 2018/12/17下午2:17
 */
@Service
public class BifDeviceSeriesService {

    @Resource
    private BifDeviceSeriesMapper bifDeviceSeriesMapper;
    @Resource
    private BifDeviceModelMapper bifDeviceModelMapper;

    public Result getDeviceSeriesList(BifDeviceSeries bifDeviceSeries) {
        if (bifDeviceSeries.getPageNum() != null && bifDeviceSeries.getPageSize() != null) {
            PageHelper.startPage(bifDeviceSeries.getPageNum(), bifDeviceSeries.getPageSize());
            Page<BifDeviceSeries> persons = bifDeviceSeriesMapper.selectList(bifDeviceSeries.getBrandId());
            // 需要把Page包装成PageInfo对象才能序列化。该插件也默认实现了一个PageInfo
            PageInfo<BifDeviceSeries> pageInfo = new PageInfo<>(persons);
            return ResultUtil.success(pageInfo);
        } else {
            List<BifDeviceSeries> list = bifDeviceSeriesMapper.selectList(bifDeviceSeries.getBrandId());
            return ResultUtil.success(list);
        }

    }

    public Result getDeviceSeries(Integer id) {
        return ResultUtil.success(bifDeviceSeriesMapper.selectByPrimaryKey(id));
    }

    public Result handle(BifDeviceSeries bifDeviceSeries) {
        Date now = new Date();
        SysCompanyUsers users = CurrentUtil.getCurrent();
        if (users == null) {
            return ResultUtil.JurisdictionError("");
        }
        if (bifDeviceSeries.getId() != null && bifDeviceSeries.getId() != 0) {
            // 执行更新操作
            bifDeviceSeries.setUpdatePerson(users.getId());
            bifDeviceSeries.setUpdateTime(now);
            bifDeviceSeriesMapper.updateByPrimaryKeySelective(bifDeviceSeries);
        } else {
            // 执行新增操作
            bifDeviceSeries.setCreatePerson(users.getId());
            bifDeviceSeries.setCreateTime(now);
            bifDeviceSeries.setFlagAvailable(true);
            bifDeviceSeries.setFlagDeleted(false);
            bifDeviceSeries.setUpdatePerson(users.getId());
            bifDeviceSeries.setUpdateTime(now);
            bifDeviceSeriesMapper.insertSelective(bifDeviceSeries);
        }
        return ResultUtil.success();
    }

    public Result handleInvalid(Integer id) {
        SysCompanyUsers users = CurrentUtil.getCurrent();
        if (users == null) {
            return ResultUtil.JurisdictionError("");
        }
        Date now = new Date();
        // 设定失效
        BifDeviceSeries bifDeviceSeries = new BifDeviceSeries();
        bifDeviceSeries.setFlagAvailable(false);
        bifDeviceSeries.setUpdateTime(now);
        bifDeviceSeries.setUpdatePerson(users.getId());
        bifDeviceSeries.setId(id);
        bifDeviceSeriesMapper.updateByPrimaryKeySelective(bifDeviceSeries);

        // 失效系列下所有型号
        BifDeviceModel model = new BifDeviceModel();
        model.setSeriesId(bifDeviceSeries.getId());
        model.setUpdatePerson(users.getId());
        model.setUpdateTime(now);
        model.setFlagAvailable(false);
        bifDeviceModelMapper.invalidBySeries(model);

        return ResultUtil.success();
    }

    public Result handleDelete(Integer id) {
        SysCompanyUsers users = CurrentUtil.getCurrent();
        if (users == null) {
            return ResultUtil.JurisdictionError("");
        }
        // 设定失效
        BifDeviceSeries bifDeviceSeries = new BifDeviceSeries();
        bifDeviceSeries.setFlagDeleted(true);
        bifDeviceSeries.setUpdateTime(new Date());
        bifDeviceSeries.setUpdatePerson(users.getId());
        bifDeviceSeries.setId(id);
        bifDeviceSeriesMapper.updateByPrimaryKeySelective(bifDeviceSeries);
        return ResultUtil.success();
    }
}
