package com.example.messenger.mapper.cfg;

import com.example.messenger.base.BaseMapper;
import com.example.messenger.entity.cfg.CfgMailTemplate;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CfgMailTemplateMapper extends BaseMapper<CfgMailTemplate> {

    /**
     * 根据类型查询
     * @param type
     * @return
     */
    CfgMailTemplate selectByType(String type);
}