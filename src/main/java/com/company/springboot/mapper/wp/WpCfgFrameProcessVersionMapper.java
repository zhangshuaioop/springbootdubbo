package com.company.springboot.mapper.wp;

import com.company.springboot.base.BaseMapper;
import com.company.springboot.entity.wp.WpCfgFrameProcessVersion;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface WpCfgFrameProcessVersionMapper extends BaseMapper<WpCfgFrameProcessVersion> {

    /**
     * 查询最大版本
     * @return
     */
    Integer selectVersion();
}