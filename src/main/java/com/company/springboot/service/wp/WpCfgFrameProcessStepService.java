package com.company.springboot.service.wp;

import com.company.springboot.base.BaseService;
import com.company.springboot.entity.wp.WpCfgFrameProcessStep;
import com.company.springboot.mapper.wp.WpCfgFrameProcessStepMapper;
import com.company.springboot.utils.Result;
import com.company.springboot.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @description: 框架子流程步骤配置
 * @author: zhangshuai
 * @create: 2019-01-24 11:46
 */
@Service
public class WpCfgFrameProcessStepService extends BaseService<WpCfgFrameProcessStepMapper,WpCfgFrameProcessStep> {

    @Autowired
    private WpCfgFrameProcessStepMapper wpCfgFrameProcessStepMapper;

    /**
     * 框架子流程列表
     * @param cfgFrameProcessId
     * @return
     */
    public Result findList(Integer cfgFrameProcessId){
        WpCfgFrameProcessStep wpCfgFrameProcessStep = new WpCfgFrameProcessStep();
        wpCfgFrameProcessStep.setCfgFrameProcessId(cfgFrameProcessId);
        wpCfgFrameProcessStep.setFlagDeleted(false);
        return ResultUtil.success(wpCfgFrameProcessStepMapper.selectAll(wpCfgFrameProcessStep));
    }
}
