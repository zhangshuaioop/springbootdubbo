package com.company.springboot.mapper.wp;

import com.company.springboot.base.BaseMapper;
import com.company.springboot.entity.wp.WpCfgProcessStepLine;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface WpCfgProcessStepLineMapper extends BaseMapper<WpCfgProcessStepLine> {
    WpCfgProcessStepLine selectByWpCfgProcessStepLine(WpCfgProcessStepLine wpCfgProcessStepLine);
}