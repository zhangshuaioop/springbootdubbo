package com.company.springboot.service.wp;

import com.company.springboot.base.BaseService;
import com.company.springboot.entity.wp.WpCfgProcessDto;
import com.company.springboot.entity.wp.WpCfgProcessStep;
import com.company.springboot.entity.wp.WpCfgProcessStepLine;
import com.company.springboot.mapper.wp.WpCfgProcessStepMapper;
import com.company.springboot.utils.Result;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @description:流程步骤配置
 * @author: zhangshuai
 * @create: 2019-01-24 11:50
 */
@Service
public class WpCfgProcessStepService extends BaseService<WpCfgProcessStepMapper,WpCfgProcessStep> {

    @Resource
    private WpCfgProcessStepMapper wpCfgProcessStepMapper;

    public Result handle(WpCfgProcessDto wpCfgProcessDto) {
        List<WpCfgProcessStep> listProStep=wpCfgProcessDto.getListProStep();
        List<WpCfgProcessStepLine> listProStepLine=wpCfgProcessDto.getListProStepLine();
        return null;
    }
}
