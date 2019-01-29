package com.teekee.messengerservice.mapper.cfg;

import com.teekee.commoncomponets.base.BaseMapper;
import com.teekee.messengerservice.entity.cfg.CfgMailTemplate;
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