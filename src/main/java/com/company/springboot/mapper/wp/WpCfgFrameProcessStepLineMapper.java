package com.company.springboot.mapper.wp;

import com.company.springboot.base.BaseMapper;
import com.company.springboot.entity.wp.WpCfgFrameProcessStepLine;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface WpCfgFrameProcessStepLineMapper extends BaseMapper<WpCfgFrameProcessStepLine> {
    WpCfgFrameProcessStepLine selectByWpCfgFrameProcessStepLine(WpCfgFrameProcessStepLine wpCfgFrameProcessStepLine);
}