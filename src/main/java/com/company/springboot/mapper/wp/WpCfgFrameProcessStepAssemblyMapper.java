package com.company.springboot.mapper.wp;

import com.company.springboot.base.BaseMapper;
import com.company.springboot.entity.wp.WpCfgFrameProcessStepAssembly;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface WpCfgFrameProcessStepAssemblyMapper extends BaseMapper<WpCfgFrameProcessStepAssembly> {

    WpCfgFrameProcessStepAssembly selectByWpCfgFrameProcessStepAssembly(WpCfgFrameProcessStepAssembly wpCfgFrameProcessStepAssembly);

    WpCfgFrameProcessStepAssembly selectAll(int cfgFrameProcessStepId);
}