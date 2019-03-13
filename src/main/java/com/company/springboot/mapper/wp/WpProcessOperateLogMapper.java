package com.company.springboot.mapper.wp;

import com.company.springboot.base.BaseMapper;
import com.company.springboot.entity.wp.WpProcessOperateLog;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface WpProcessOperateLogMapper extends BaseMapper<WpProcessOperateLog> {

    int insertSelective(WpProcessOperateLog wpProcessOperateLog);

    /**
     * 根据版本id和步骤id查询自定义流程日志的最后一条日志信息
     * @param cfgProcessStepId
     * @param frameProcessId
     * @return
     */
    WpProcessOperateLog selectByProcessStep(@Param("cfgProcessStepId") Integer cfgProcessStepId, @Param("frameProcessId") Integer frameProcessId);
}