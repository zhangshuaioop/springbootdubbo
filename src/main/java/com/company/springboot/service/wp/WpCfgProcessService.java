package com.company.springboot.service.wp;

import com.company.springboot.base.BaseService;
import com.company.springboot.entity.wp.WpCfgProcess;
import com.company.springboot.entity.wp.WpCfgProcessVersion;
import com.company.springboot.mapper.wp.WpCfgProcessMapper;
import com.company.springboot.mapper.wp.WpCfgProcessVersionMapper;
import com.company.springboot.utils.CurrentUtil;
import com.company.springboot.utils.PageInfo;
import com.company.springboot.utils.Result;
import com.company.springboot.utils.ResultUtil;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @description:流程配置
 * @author: zhangshuai
 * @create: 2019-01-24 11:49
 */
@Service
public class WpCfgProcessService extends BaseService<WpCfgProcessMapper,WpCfgProcess> {


    @Resource
    private WpCfgProcessMapper wpCfgProcessMapper;

    @Resource
    private WpCfgProcessVersionMapper wpCfgProcessVersionMapper;


    public Result list(WpCfgProcess wpCfgProcess) {
        if (wpCfgProcess.getCompanyId() == null || wpCfgProcess.getCompanyId() == 0) {
            return ResultUtil.validateError("参数错误");
        }
        if (wpCfgProcess.getPageNum() != null && wpCfgProcess.getPageSize() != null) {
            PageHelper.startPage(wpCfgProcess.getPageNum(), wpCfgProcess.getPageSize());
            Page<WpCfgProcess> persons = wpCfgProcessMapper.findPage(wpCfgProcess);
            PageInfo<WpCfgProcess> pageInfo = new PageInfo<>(persons);
            return ResultUtil.success(pageInfo);
        } else {
            List<WpCfgProcess> list = wpCfgProcessMapper.findPage(wpCfgProcess);
            return ResultUtil.success(list);
        }
    }

    public Result handle(WpCfgProcess wpCfgProcess) {

        //新增流程
        Integer userId = CurrentUtil.getCurrent().getId();
        Date now = new Date();
        wpCfgProcess.setUpdateTime(now);
        wpCfgProcess.setUpdatePerson(userId);
        wpCfgProcess.setCreateTime(now);
        wpCfgProcess.setCreatePerson(userId);
        wpCfgProcess.setFlagDeleted(false);
        wpCfgProcess.setFlagAvaliable(false);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
        String str = sdf.format(now);
        str = str.substring(2, str.length());
        wpCfgProcess.setProcessCode("PRO" + "_" + str + "_" + getRandom());
        wpCfgProcessMapper.insertSelective(wpCfgProcess);

        //新增流程版本
        WpCfgProcessVersion wpCfgProcessVersion = new WpCfgProcessVersion();
        wpCfgProcessVersion.setCfgProcessId(wpCfgProcess.getId());
        wpCfgProcessVersion.setCreatePerson(userId);
        wpCfgProcessVersion.setCreateTime(now);
        wpCfgProcessVersion.setUpdatePerson(userId);
        wpCfgProcessVersion.setUpdateTime(now);
        wpCfgProcessVersion.setFlagIsLast(true);
        wpCfgProcessVersion.setFlagAvaliable(false);
        wpCfgProcessVersion.setVersion(1);
        wpCfgProcessVersionMapper.insertSelective(wpCfgProcessVersion);

        return ResultUtil.success();

    }

    private String getRandom() {
        String result = "";
        while (result.length() < 3) {
            String str = String.valueOf((int) (Math.random() * 10));
            if (result.indexOf(str) == -1) {
                result += str;
            }
        }
        return result;

    }
}
